package com.huixin.web.model;

import java.io.Serializable;

public class KctzdItem implements Serializable{
	
	
   

	/**
	 * 
	 */
	private static final long serialVersionUID = 9018265661704581782L;

	private Integer id;

    private Integer kctzdId;

    private Integer prodId;

    private Integer num;

    
    //自定义
    private String productCode ; 
    
    private String productName ;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public Integer getKctzdId() {
		return kctzdId;
	}

	public void setKctzdId(Integer kctzdId) {
		this.kctzdId = kctzdId;
	}

	public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}