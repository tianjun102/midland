package com.huixin.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.huixin.core.util.RestResponse;
import com.huixin.web.model.ShoppingCart;
import com.huixin.web.service.impl.ShoppingCartService;

/**
 * 购物车
 * Created by jzg
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController  {

    //日志
    public static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    /**
     * 购物车服务类
     */
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    /**
     * 获取我的购物车列表接口
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResponse list() {
        try {
            List<Map<String, Object>> list = this.shoppingCartService.getList();
            return RestResponse.RestResponseBuilder.createSuccessBuilder("获取成功!").setResult(list).buidler();
        } catch (Exception ex) {
            logger.error("=========获取我的购物车列表出错:", ex);
            return RestResponse.RestResponseBuilder.createFailBuilder("获取我的购物车列表出错:" + ex.getMessage()).buidler();
        }
    }
    
    @RequestMapping(value = "/getCartSize", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResponse getCartSize() {
        try {
            Long size = this.shoppingCartService.getCartSize();
            return RestResponse.RestResponseBuilder.createSuccessBuilder("获取成功!").setResult(size).buidler();
        } catch (Exception ex) {
            logger.error("=========获取我的购物车数量出错:", ex);
            return RestResponse.RestResponseBuilder.createFailBuilder("获取我的购物车数量出错:").buidler();
        }
    }


    /**
     * 添加购物车接口
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public RestResponse add(String productId) {
      
       // String productId = (String) parameters.get("productId");
    	
    	Map<String ,Object> parameters  = new HashMap<String ,Object>();
    	parameters.put("productId", productId);
        if (StringUtils.isEmpty(productId)) {
            return RestResponse.RestResponseBuilder.createFailBuilder("商品ID不能为空!").buidler();
        }
        String quantity = (String) parameters.get("quantity");
        if (StringUtils.isEmpty(quantity)) {
            parameters.put("quantity", "1");
        }
        try {
            return this.shoppingCartService.add(parameters);
        } catch (Exception ex) {
            logger.error("===========添加购物车接口出错:", ex);
            return RestResponse.RestResponseBuilder.createFailBuilder("添加购物车出错").buidler();
        }
    }

    /**
     * 更新购物车接口
     *
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public RestResponse update(@RequestBody List<ShoppingCart> shoppingCartDtos) {
        if (shoppingCartDtos == null || shoppingCartDtos.isEmpty()) {
            return RestResponse.RestResponseBuilder.createFailBuilder("购物车参数不能为空!").buidler();
        }
        List<ShoppingCart> list = Lists.newArrayList();
        for (ShoppingCart shoppingCartDto : shoppingCartDtos) {
            String productId = shoppingCartDto.getProductId();
            if (StringUtils.isEmpty(productId)) {
                return RestResponse.RestResponseBuilder.createFailBuilder("商品ID不能为空!").buidler();
            }
            Integer quantity = shoppingCartDto.getQuantity();
            if (quantity == null || quantity < 0) {
                shoppingCartDto.setQuantity(0);
            }
            boolean flag = false;
            for (ShoppingCart dto : list) {
                if (dto.getProductId().equals(productId)) {
                    dto.setQuantity(dto.getQuantity() + shoppingCartDto.getQuantity());
                    flag = true;
                    break;
                }
            }
            if(!flag){
                list.add(shoppingCartDto);
            }
        }
        try {
            return this.shoppingCartService.update(list);
        } catch (Exception ex) {
            logger.error("===========更新购物车接口出错:", ex);
            return RestResponse.RestResponseBuilder.createFailBuilder("更新购物车出错").buidler();
        }
    }

    /**
     * 删除购物车接口
     *
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public RestResponse delete(List<String> productIds) {
    	// productIds.add("1");   测试
    	
        if (productIds == null || productIds.isEmpty()) {
            return RestResponse.RestResponseBuilder.createFailBuilder("删除购物车商品ID值不能为空!").buidler();
        }
        try {
            return this.shoppingCartService.delete(productIds);
        } catch (Exception ex) {
            logger.error("===========删除购物车接口出错:", ex);
            return RestResponse.RestResponseBuilder.createFailBuilder("删除购物车出错").buidler();
        }
    }

    /**
     * 清除购物车接口
     *
     * @return
     */
    @RequestMapping(value = "/clearAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public RestResponse clearAll() {
        try {
            return this.shoppingCartService.clearAll();
        } catch (Exception ex) {
            logger.error("===========清除购物车接口出错:", ex);
            return RestResponse.RestResponseBuilder.createFailBuilder("清除购物车出错").buidler();
        }
    }
}
