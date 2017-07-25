package com.huixin.web.model;

import java.io.Serializable;

public class OrderLog implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -6402287779228876425L;

	private Long logId;

    private Long orderId;

    private String operateUserCode;

    private String operateUserName;

    private String operateInfo;

    private Integer operateState;

    private String operateTime;

    private String operateLogInfo;

    private String orderSn;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOperateUserCode() {
        return operateUserCode;
    }

    public void setOperateUserCode(String operateUserCode) {
        this.operateUserCode = operateUserCode == null ? null : operateUserCode.trim();
    }

    public String getOperateUserName() {
        return operateUserName;
    }

    public void setOperateUserName(String operateUserName) {
        this.operateUserName = operateUserName == null ? null : operateUserName.trim();
    }

    public String getOperateInfo() {
        return operateInfo;
    }

    public void setOperateInfo(String operateInfo) {
        this.operateInfo = operateInfo == null ? null : operateInfo.trim();
    }

    public Integer getOperateState() {
        return operateState;
    }

    public void setOperateState(Integer operateState) {
        this.operateState = operateState;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateLogInfo() {
        return operateLogInfo;
    }

    public void setOperateLogInfo(String operateLogInfo) {
        this.operateLogInfo = operateLogInfo == null ? null : operateLogInfo.trim();
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }
}