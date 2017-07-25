package com.huixin.core.util;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.huixin.web.model.ShoppingCart;

/**

 */
public final class OrderInfoUtils {

    /**订单状态 - 删除**/
    public static final Integer ORDER_STATUS_DELETE = -2;
    /**订单状态 - 取消**/
    public static final Integer ORDER_STATUS_CANCEL = -1;
    /**订单状态 -  待确认**/
    public static final Integer ORDER_STATUS_NOPAY = 0;
    /**订单状态 - 待发货**/
    public static final Integer ORDER_STATUS_NOLP = 1;
    /**订单状态 - 已发货**/
    public static final Integer ORDER_STATUS_LP = 2;
    /**订单状态 - 已完成**/
    public static final Integer ORDER_STATUS_FINISH = 3;
    /**订单状态 - 订单取消**/
    public static final Integer ORDER_STATUS_PAYANDCANCEL = 4;
    
    
    
    
    /**订单状态 - 删除   -2**/
    public static final String ORDER_DELETE = "删除";
    /**订单状态 - 取消 -1**/
    public static final String ORDER_CANCEL = "超时取消";
    /**订单状态 - 待确认 0  未支付 0 **/
    public static final String ORDER_DZF = "待付款";
    /**订单状态 - 待确认 0**/
    public static final String ORDER_NOPAY = "待确认";
    /**订单状态 - 待发货 1**/
    public static final String ORDER_NOLP = "待发货";
    /**订单状态 - 已发货 2**/
    public static final String ORDER_LP = "已发货";
    /**订单状态 - 已完成 3**/
    public static final String ORDER_FINISH = "已完成";
    /**订单状态 - 订单取消 4**/
    public static final String ORDER_PAYANDCANCEL = "订单取消";
    
    

    /**订单支付状态 - 未支付**/
    public static final Integer PAY_STATUS_UNFINISH = 0;
    
    /**订单支付状态 - 已支付**/
    public static final Integer PAY_STATUS_FINISH = 1;
    
    
    /**订单支付状态 - 未支付 0**/
    public static final String PAY_UNFINISH = "未支付";
    
    /**订单支付状态 - 已支付 1**/
    public static final String PAY_FINISH = "已支付";
    
    
    
    /**订单支付状态 - 支付宝**/
    public static final String PAY_TYPE_ZFB = "支付宝";
    
    /**订单支付状态 - 微信支付**/
    public static final String PAY_TYPE_WX = "微信支付";
    
    /**订单支付状态 - 银联支付**/
    public static final String PAY_TYPE_YL = "银联支付";
    
    /**订单支付状态 - 银行汇款/转帐**/
    public static final String PAY_TYPE_XXZF = "银行汇款/转帐";
    
    /**订单支付状态 - 预授信**/
    public static final String PAY_TYPE_YSX = "预授信";
    
    /**订单支付状态 - 账户余额**/
    public static final String PAY_TYPE_ZHYE = "账户余额";
    
    
    
    public static String getOrderSn() {
    	String   preix = "WKS-";
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
        String format1 = format.format(new Date());
        int i = RandomUtils.nextInt(1000);
        return preix + format1 + StringUtils.leftPad(i + "", 4, '0');
    }

    /**
     * 校验订单信息
     *
     * @param shoppingCart
     * @param params
     * @return
     */
    public static boolean validateProductSku(ShoppingCart shoppingCart, Map<String, Object> params) {
    	params.put("expireStatus", "0");
        //校验商品状态
        Integer status = (Integer) params.get("prodStatus");
        if (status == null || status != 1) {
        	params.put("expireStatus", "1");
            params.put("errorMsg", "商品已移除,不能购买!");
            return false;
        }

      /*  //校验商品上架状态
        Integer shelvesFlag = (Integer) params.get("shelvesFlag");
        if (shelvesFlag == null || shelvesFlag != 1) {
        	params.put("expireStatus", "2");
            params.put("errorMsg", "商品已下架,不能购买!");
            return false;
        }*/

       /* //校验自动下架时间
        long currentTimeMillis = System.currentTimeMillis();
        Long autoOffTime = convertDateToLong(params.get("autoOffTime"));
        if (autoOffTime != null && autoOffTime < currentTimeMillis) {
        	params.put("expireStatus", "3");
            params.put("errorMsg", "已超过商品自动下架时间,不能购买!");
            return false;
        }*/

        /*//校验兑换时间
        Long cashBeginTime = convertDateToLong(params.get("cashBeginTime"));
        Long cashEndTime = convertDateToLong(params.get("cashEndTime"));
        if (cashEndTime != null && cashBeginTime != null) {
            if (!(currentTimeMillis >= cashBeginTime && cashEndTime >= currentTimeMillis)) {
            	params.put("expireStatus", "4");
                params.put("errorMsg", "不在兑换时间内,不能购买!");
                return false;
            }

        }*/

        //校验库存
       /* Integer stock = (Integer) params.get("stock");
        Integer quantity = shoppingCart.getQuantity();
        if (stock == null || (quantity > stock)) {
        	params.put("expireStatus", "5");
            params.put("errorMsg", "库存不足,不能购买!");
            return false;
        }*/

        return true;
    }

    public static Long convertDateToLong(Object date) {
        if (date != null) {
            if (date instanceof Long) {
                return (Long) date;
            } else if (date instanceof Timestamp) {
                Timestamp timestamp = (Timestamp) date;
                return timestamp.getTime();
            } else if (date instanceof Date) {
                Date cur = (Date) date;
                return cur.getTime();
            } else if (date instanceof String) {
                try {
                    return Long.valueOf((String) date);
                } catch (Exception ex) {
                    return null;
                }
            }
        }
        return null;
    }

    public static MultiValueMap<String, Object> getMultiValueMap() {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("timestamp", "");
        params.add("clientType", "WAP");
        params.add("businessType", "80");
        params.add("version", "1.0.0");
        params.add("nocache", "true");
        return params;
    }

    /**
     * 检校签名是否正确
     *
     * @param params
     * @return
     */
    public static boolean validateSignature(Map<String, Object> params) {
        return true;
    }
}
