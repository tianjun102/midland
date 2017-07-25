package com.huixin.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.huixin.core.util.OrderInfoUtils;

public class OrderInfo implements Serializable {

	/**
	 * 订单详情类
	 */
	private static final long serialVersionUID = 3477281586211668349L;

	private Integer id;

	private String orderSn;

	private Integer custId;

	private Integer orderStatus;

	private Integer payStatus;

	private String consignee;

	private String province;

	private String city;

	private String district;

	private String address;

	private String mobile;

	private String tel;

	private String email;

	private String postscript;

	private Integer shippingId;

	private String payCode;

	private Integer invStatus;

	private Float invPayee;

	private String invContent;

	private Float goodsAmount;

	private Float shippingFee;

	private Float orderAmount;

	private Float discount;

	private Float moneyPaid;

	private String createTime;

	private String updateTime;

	private String payTime;

	private String betweenTimeStart;

	private String betweenTimeEnd;

	private Float orderAmountCount;
	
	private Integer settStatus;
	
	private String deliveryTime;
	
	private String shipperCode;
	
	private Integer num;
	
	private String buyerMessage;
	
	private String shippingSn;

	private Integer isPrintOrder;
	
	// 自定义属性

	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	private List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
	
	private List<Integer> custIdList;
	
	private String custName;
	
	private String custCode;
	
	private Integer custType;

	private String orderStatusName;
	
	private String payCodeName;
	
	private String payStatusName;
	
	private String createStartTime;
	
	private String createEndTime;
	
	private String payStartTime;
	
	private String payEndTime;
	
	private Integer  flag;
	
	private String provinceName;
	
	private String cityName;
	
	private String distName;
	
	private String shippingName;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostscript() {
		return postscript;
	}

	public void setPostscript(String postscript) {
		this.postscript = postscript;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public String getPayId() {
		return payCode;
	}

	public void setPayId(String payCode) {
		this.payCode = payCode;
	}

	public Integer getInvStatus() {
		return invStatus;
	}

	public void setInvStatus(Integer invStatus) {
		this.invStatus = invStatus;
	}

	public Float getInvPayee() {
		return invPayee;
	}

	public void setInvPayee(Float invPayee) {
		this.invPayee = invPayee;
	}

	public String getInvContent() {
		return invContent;
	}

	public void setInvContent(String invContent) {
		this.invContent = invContent;
	}

	public Float getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(Float goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public Float getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(Float shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Float orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Float getMoneyPaid() {
		return moneyPaid;
	}

	public void setMoneyPaid(Float moneyPaid) {
		this.moneyPaid = moneyPaid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getBetweenTimeStart() {
		return betweenTimeStart;
	}

	public void setBetweenTimeStart(String betweenTimeStart) {
		this.betweenTimeStart = betweenTimeStart;
	}

	public String getBetweenTimeEnd() {
		return betweenTimeEnd;
	}

	public void setBetweenTimeEnd(String betweenTimeEnd) {
		this.betweenTimeEnd = betweenTimeEnd;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public List<Integer> getCustIdList() {
		return custIdList;
	}

	public void setCustIdList(List<Integer> custIdList) {
		this.custIdList = custIdList;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Float getOrderAmountCount() {
		return orderAmountCount;
	}

	public void setOrderAmountCount(Float orderAmountCount) {
		this.orderAmountCount = orderAmountCount;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	public Integer getSettStatus() {
		return settStatus;
	}

	public void setSettStatus(Integer settStatus) {
		this.settStatus = settStatus;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getShipperCode() {
		return shipperCode;
	}

	public void setShipperCode(String shipperCode) {
		this.shipperCode = shipperCode;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getOrderStatusName() {
		String temp = OrderInfoUtils.ORDER_NOPAY;
		if(orderStatus!=null){
			if(payStatus==0 && orderStatus==0){
					temp  = OrderInfoUtils.ORDER_DZF; 
			}else{
				if(orderStatus == OrderInfoUtils.ORDER_STATUS_DELETE ){
					temp = OrderInfoUtils.ORDER_DELETE;
				}else if(orderStatus == OrderInfoUtils.ORDER_STATUS_CANCEL ){
					temp = OrderInfoUtils.ORDER_CANCEL;
				}else if(orderStatus == OrderInfoUtils.ORDER_STATUS_NOLP ){
					temp = OrderInfoUtils.ORDER_NOLP;
				}else if(orderStatus == OrderInfoUtils.ORDER_STATUS_LP ){
					temp = OrderInfoUtils.ORDER_LP;
				}else if(orderStatus == OrderInfoUtils.ORDER_STATUS_FINISH ){
					temp = OrderInfoUtils.ORDER_FINISH;
				}else if(orderStatus == OrderInfoUtils.ORDER_STATUS_PAYANDCANCEL ){
					temp = OrderInfoUtils.ORDER_PAYANDCANCEL;
				}else{
					temp = OrderInfoUtils.ORDER_NOPAY; 
				}
			}
		}
		return temp;
		
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public String getPayCodeName() {
		String temp = "";
		if(StringUtils.isNotEmpty(payCode)){
			if(payCode.indexOf("ZFB")!=-1){
				temp = OrderInfoUtils.PAY_TYPE_ZFB;
			}else if(payCode.indexOf("WX")!=-1){
				temp = OrderInfoUtils.PAY_TYPE_WX;
			}else if(payCode.indexOf("YL")!=-1){
				temp = OrderInfoUtils.PAY_TYPE_YL;
			}else if(payCode.indexOf("TRANSFER")!=-1){
				temp = OrderInfoUtils.PAY_TYPE_XXZF;
			}else if(payCode.indexOf("CREDIT")!=-1){
				temp = OrderInfoUtils.PAY_TYPE_YSX;
			}else if(payCode.indexOf("WALLET")!=-1){
				temp = OrderInfoUtils.PAY_TYPE_ZHYE;
			}
		}
		return temp;
	}

	public void setPayCodeName(String payCodeName) {
		this.payCodeName = payCodeName;
	}

	public String getCreateStartTime() {
		return createStartTime;
	}

	public void setCreateStartTime(String createStartTime) {
		this.createStartTime = createStartTime;
	}

	public String getCreateEndTime() {
		return createEndTime;
	}

	public void setCreateEndTime(String createEndTime) {
		this.createEndTime = createEndTime;
	}

	public String getPayStartTime() {
		return payStartTime;
	}

	public void setPayStartTime(String payStartTime) {
		this.payStartTime = payStartTime;
	}

	public String getPayEndTime() {
		return payEndTime;
	}

	public void setPayEndTime(String payEndTime) {
		this.payEndTime = payEndTime;
	}

	public String getPayStatusName() {
		String temp = OrderInfoUtils.PAY_UNFINISH;
		if(payStatus!=null){
			if(payStatus == OrderInfoUtils.PAY_STATUS_FINISH){
				 temp = OrderInfoUtils.PAY_FINISH;
			}
		}
		return temp;
	}

	public void setPayStatusName(String payStatusName) {
		this.payStatusName = payStatusName;
	}

	public String getBuyerMessage() {
		return buyerMessage;
	}

	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}

	public String getShippingSn() {
		return shippingSn;
	}

	public void setShippingSn(String shippingSn) {
		this.shippingSn = shippingSn;
	}

	public Integer getCustType() {
		return custType;
	}

	public void setCustType(Integer custType) {
		this.custType = custType;
	}

	public Integer getIsPrintOrder() {
		return isPrintOrder;
	}

	public void setIsPrintOrder(Integer isPrintOrder) {
		this.isPrintOrder = isPrintOrder;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}
	
	
	
}