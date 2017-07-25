package com.huixin.web.model;

import java.io.Serializable;

public class Shipping implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1781630979432157719L;

	private Integer shippingId;

    private String shippingCode;

    private String shippingName;

    private String shippingDesc;

    private String modelImg;

    private String defalutDelivery;

    private Integer sortOrder;

    private String regular;

    private Integer enabled;

    private String modified;
    
    private String shippingPrint;
    
    private String shippingPrint2;

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    public String getShippingDesc() {
        return shippingDesc;
    }

    public void setShippingDesc(String shippingDesc) {
        this.shippingDesc = shippingDesc == null ? null : shippingDesc.trim();
    }

    public String getModelImg() {
        return modelImg;
    }

    public void setModelImg(String modelImg) {
        this.modelImg = modelImg == null ? null : modelImg.trim();
    }

    public String getDefalutDelivery() {
        return defalutDelivery;
    }

    public void setDefalutDelivery(String defalutDelivery) {
        this.defalutDelivery = defalutDelivery == null ? null : defalutDelivery.trim();
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular == null ? null : regular.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

	public String getShippingPrint() {
		return shippingPrint;
	}

	public void setShippingPrint(String shippingPrint) {
		this.shippingPrint = shippingPrint;
	}

	public String getShippingPrint2() {
		return shippingPrint2;
	}

	public void setShippingPrint2(String shippingPrint2) {
		this.shippingPrint2 = shippingPrint2;
	}
    
    
}