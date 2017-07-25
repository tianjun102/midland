package com.huixin.web.model;

import java.io.Serializable;

public class ProductAttribute  implements Serializable{
	
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1547962634292114901L;

	private Integer attrId;

    private Integer productId;

    private Integer propId;

    private String propValue;

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPropId() {
        return propId;
    }

    public void setPropId(Integer propId) {
        this.propId = propId;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue == null ? null : propValue.trim();
    }
}