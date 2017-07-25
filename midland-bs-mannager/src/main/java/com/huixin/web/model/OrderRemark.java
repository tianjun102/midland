package com.huixin.web.model;

import java.io.Serializable;

public class OrderRemark implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2833510922771733008L;

	private Long remarkUid;

    private Integer orderId;

    private String userCode;

    private String userName;

    private String remarkDesc;

    private String remarkTime;

    private String orderSn;

    public Long getRemarkUid() {
        return remarkUid;
    }

    public void setRemarkUid(Long remarkUid) {
        this.remarkUid = remarkUid;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRemarkDesc() {
        return remarkDesc;
    }

    public void setRemarkDesc(String remarkDesc) {
        this.remarkDesc = remarkDesc == null ? null : remarkDesc.trim();
    }

    public String getRemarkTime() {
        return remarkTime;
    }

    public void setRemarkTime(String remarkTime) {
        this.remarkTime = remarkTime;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }
}