package com.huixin.web.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class ProductProperty implements Serializable{
	
   

	/**
	 * 
	 */
	private static final long serialVersionUID = 7301605409374747052L;

	private Integer propId;

    private Integer catId;

    private String propName;

    private String propType;

    private String propValue;

    private Byte sortOrder;

    private Date addTime;

    private Integer enabled;
    
    
    //自定义属性
    private Integer attrId;
    
    private Integer productId;
    
    private String aPropValue;
    
    private String[] arrNameValue;
    
    private String[] arrValue;
    
    private String propIdStr;

    public Integer getPropId() {
        return propId;
    }

    public void setPropId(Integer propId) {
        this.propId = propId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName == null ? null : propName.trim();
    }

    public String getPropType() {
        return propType;
    }

    public void setPropType(String propType) {
        this.propType = propType == null ? null : propType.trim();
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue == null ? null : propValue.trim();
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

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

	public String getaPropValue() {
		return aPropValue;
	}

	public void setaPropValue(String aPropValue) {
		this.aPropValue = aPropValue;
	}

	public String[] getArrNameValue() {
		String str = this.getPropValue();
		if(StringUtils.isEmpty(str)){
			return new String[]{};
		}
		String[]  temp = str.split("\\|\\|");
		return temp;
	}

	public void setArrNameValue(String[] arrNameValue) {
		this.arrNameValue = arrNameValue;
	}

	public String[] getArrValue() {
		String str = this.getaPropValue();
		String[]  temp ={};
		if(StringUtils.isNotEmpty(str)){
			temp =str.trim().split(" ");
		}
		return temp;
	}

	public void setArrValue(String[] arrValue) {
		this.arrValue = arrValue;
	}

	public String getPropIdStr() {
		return propIdStr;
	}

	public void setPropIdStr(String propIdStr) {
		this.propIdStr = propIdStr;
	}
    
	
	
    
}