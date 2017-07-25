package com.huixin.web.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.huixin.core.util.OrderInfoUtils;
import com.huixin.core.util.RestResponse;
import com.huixin.web.model.ShoppingCart;
import com.huixin.web.service.ProductService;

/**
 */
@Service
public class ShoppingCartService {

 
    /**
     * 商品服务类
     */
    private final ProductService productService;

    /**
     * 购物车REDIS操作类
     */
    @Resource(name = "shoppingCartDtoRedisTemplate")
    private RedisTemplate<String, ShoppingCart> redisTemplate;

    @Autowired
    public ShoppingCartService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 获取我的购物车列表
     *
     * @return
     */
    public List<Map<String, Object>> getList() {
        //获取redis缓存key
        String redisKey = getRedisKey();
        BoundListOperations<String, ShoppingCart> listOperations = redisTemplate.boundListOps(redisKey);
        Long size = listOperations.size();
        if (size != null && size > 0) {
            List<ShoppingCart> ranges = listOperations.range(0L, listOperations.size());
            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>(size.intValue());
            Map<String, Object> params = new HashMap<String, Object>(1);
            for (ShoppingCart shoppingCart : ranges) {
                params.put("productId", shoppingCart.getProductId());
                Map<String, Object> product = this.productService.searchProductForMap(params);
                if (product == null || product.isEmpty()) {
                    continue;
                }
                OrderInfoUtils.validateProductSku(shoppingCart, product);
                product.put("quantity",shoppingCart.getQuantity());
                result.add(product);
            }
            return result;
        }
        return null;
    }
    
    /**
     * 获取商品数量
     * @return
     */
    public Long getCartSize(){
    	String redisKey = getRedisKey();
        BoundListOperations<String, ShoppingCart> listOperations = redisTemplate.boundListOps(redisKey);
        Long size = 0l;
        if(listOperations!=null){
        	size=listOperations.size();
        }
    	
    	return size;
    }

    /**
     * 更新购物车
     *
     * @param shoppingCarts
     * @return
     */
    public RestResponse update(List<ShoppingCart> shoppingCarts) {
        if (shoppingCarts == null || shoppingCarts.isEmpty()) {
            return RestResponse.RestResponseBuilder.createFailBuilder("更新失败!").buidler();
        }
        List<ShoppingCart> redisShoppingCart = Lists.newArrayList();
        BoundListOperations<String, ShoppingCart> listOperations = redisTemplate.boundListOps(getRedisKey());
        Long size = listOperations.size();
        if (size == null || size <= 0) {
            redisShoppingCart.addAll(shoppingCarts);
        } else {
            List<ShoppingCart> ranges = listOperations.range(0L, listOperations.size());
            for (ShoppingCart cartDto : shoppingCarts) {
                String productId = cartDto.getProductId();
                int k = ranges.size();
                boolean flag = false;
                for (int i = 0; i < k; i++) {
                    ShoppingCart shoppingCart = ranges.get(i);
                    String productId1 = shoppingCart.getProductId();
                    if (productId.equals(productId1)) {
                        Integer quantity = cartDto.getQuantity();
                        if (quantity != null && quantity > 0) {
                            redisShoppingCart.add(cartDto);
                        }
                        ranges.remove(i);
                        listOperations.remove(0, shoppingCart);
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    Integer quantity = cartDto.getQuantity();
                    if (quantity != null && quantity > 0) {
                        redisShoppingCart.add(cartDto);
                    }
                }
            }
        }
        if(redisShoppingCart.size() > 0){
            Map<String, Object> params = new HashMap<String, Object>(1);
            for(ShoppingCart cr : redisShoppingCart){
                params.put("productId", cr.getProductId());
                Map<String, Object> product = this.productService.searchProductForMap(params);
                if (product == null || product.isEmpty()) {
                    return RestResponse.RestResponseBuilder.createFailBuilder("更新的商品不存在,请重新选择商品!").buidler();
                }
                boolean b = OrderInfoUtils.validateProductSku(cr, product);
                if (!b) {
                    return RestResponse.RestResponseBuilder.createFailBuilder(product.get("errorMsg").toString()).buidler();
                }
                listOperations.leftPush(cr);
                listOperations.expire(1,TimeUnit.DAYS);
            }
        }
        return RestResponse.RestResponseBuilder.createSuccessBuilder("更新成功!").buidler();
    }

    /**
     * 删除购物车
     *
     * @param productIds
     * @return
     */
    public RestResponse delete(List<String> productIds) {
        if (productIds == null || productIds.isEmpty()) {
            return RestResponse.RestResponseBuilder.createFailBuilder("删除购物车!").buidler();
        }
        BoundListOperations<String, ShoppingCart> listOperations = redisTemplate.boundListOps(getRedisKey());
        Long size = listOperations.size();
        if (size != null && size > 0) {
            List<ShoppingCart> ranges = listOperations.range(0L, listOperations.size());
            for (ShoppingCart cartDto : ranges) {
                String productId = cartDto.getProductId();
                if(productIds.contains(productId)) {
                    listOperations.remove(0, cartDto);
                }
            }
        }
        return RestResponse.RestResponseBuilder.createSuccessBuilder("删除购物车成功!").buidler();
    }

    /**
     * 清除所有购物车
     *
     * @return
     */
    public RestResponse clearAll() {
        BoundListOperations<String, ShoppingCart> listOperations = redisTemplate.boundListOps(getRedisKey());
        Long size = listOperations.size();
        if (size != null && size > 0) {
            List<ShoppingCart> ranges = listOperations.range(0L, listOperations.size());
            for (ShoppingCart cartDto : ranges) {
                listOperations.remove(0, cartDto);
                break;
            }
        }
        return RestResponse.RestResponseBuilder.createSuccessBuilder("清除所有购物车成功!").buidler();
    }

    /**
     * 添加购物车列表
     *
     * @return
     */
    public RestResponse add(Map<String, Object> params) {
        Map<String, Object> product = this.productService.searchProductForMap(params);
        if (product == null || product.isEmpty()) {
            return RestResponse.RestResponseBuilder.createFailBuilder("添加的商品不存在,请重新选择商品!").buidler();
        }
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingCart tempCartDto = null;
        shoppingCart.setProductId(params.get("productId").toString());
        shoppingCart.setQuantity(Integer.valueOf(params.get("quantity").toString()));
        String redisKey = getRedisKey();
        BoundListOperations<String, ShoppingCart> boundListOperations = redisTemplate.boundListOps(redisKey);
        Long size = boundListOperations.size();
        if (size != null && size > 0) {
            List<ShoppingCart> range = boundListOperations.range(0, size);
            for (ShoppingCart cartDto : range) {
                if (cartDto.getProductId().equals(shoppingCart.getProductId())) {
                    shoppingCart.setQuantity(cartDto.getQuantity() + shoppingCart.getQuantity());
                    tempCartDto = cartDto;
                    break;
                }
            }
        }
        boolean b = OrderInfoUtils.validateProductSku(shoppingCart, product);
        if (!b) {
            return RestResponse.RestResponseBuilder.createFailBuilder(product.get("errorMsg").toString()).buidler();
        }
        if(tempCartDto != null){
            boundListOperations.remove(0, tempCartDto);
        }
        boundListOperations.leftPush(shoppingCart);
        boundListOperations.expire(1, TimeUnit.DAYS);
        return RestResponse.RestResponseBuilder.createSuccessBuilder().buidler();
    }

    private String getRedisKey() {
        //获取当前登录用户ID
        String currentUsername = "tian" ; // SecurityUtils.getCurrentUsername();
        return "tsh:shopping:cart:" + currentUsername;
    }

    /**
     * 订单确认页面
     * @param shoppingCarts
     * @return
     */
    public RestResponse confirm(List<ShoppingCart> shoppingCarts){
        if(shoppingCarts == null || shoppingCarts.isEmpty()){
            return RestResponse.RestResponseBuilder.createFailBuilder("未加入购买商品!").buidler();
        }
        Map<String,Object> params = Maps.newHashMap();
        List<Map<String,Object>> list = Lists.newArrayList();
        for(ShoppingCart shoppingCart : shoppingCarts){
            String productId = shoppingCart.getProductId();
            if(StringUtils.isEmpty(productId)){
                return RestResponse.RestResponseBuilder.createFailBuilder("购买商品ID为空!").buidler();
            }
            params.put("productId",productId);
            Map<String, Object> goodsInfo = this.productService.searchProductForMap(params);
            if(goodsInfo == null || goodsInfo.isEmpty()){
                return RestResponse.RestResponseBuilder.createFailBuilder("购买的商品未找到或已下架!").buidler();
            }
            boolean b = OrderInfoUtils.validateProductSku(shoppingCart, goodsInfo);
            if(!b){
                return RestResponse.RestResponseBuilder.createFailBuilder(goodsInfo.get("errorMsg").toString()).buidler();
            }
            goodsInfo.put("quantity",shoppingCart.getQuantity());
            list.add(goodsInfo);
        }
        return RestResponse.RestResponseBuilder.createSuccessBuilder("订单确认页面").setResult(list).buidler();
    }
}
