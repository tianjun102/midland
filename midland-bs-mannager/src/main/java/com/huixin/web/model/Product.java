package com.huixin.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.huixin.core.util.ProductUtils;

//商品表
public class Product implements Serializable{  

	/**
	 * 
	 */
	private static final long serialVersionUID = 5834262813224438850L;

	private Integer productId;

    private Integer catId;

    private String productCode;

    private String productName;

    private String productKeywords;

    private Integer clickCount;

    private Float marketPrice;

    private Float salePrice;

    private Integer isShowAll;

    private Integer brandId;

    private String prodThumbPic1;

    private String prodThumbPic2;

    private Integer isReal;

    private Integer isGift;

    private Integer isRecommend;

    private Integer prodStatus;

    private String releaseTime;

    private String planSaleTime;

    private String shelvesTime;

    private Integer isDelete;
    
    private Integer isNowTime;

    private String addTime;

    private String updateTime;

    private String prodDetails;
    
    
    private Integer miniNum;
    
    private String unit;
    
    private String warrantyNotes;
    
    //自定义属性
    
    private Integer quantity;
    
    private String prodStatusName;
    
    private List<ProductProperty> propList =  new ArrayList<ProductProperty>();
    
    private List<ProductAttribute> attrList =  new ArrayList<ProductAttribute>();
    
    private List<ProductPic> picList = new ArrayList<ProductPic>();
    
    private String catName ;
    
    private Float  salePrice1;
    
    private Float  salePrice2;
    
    private String planSaleStartTime;
    
    private String planSaleEndTime;
    
	
    private Integer saleCount;
    
	public Float getSalePrice1() {
		return salePrice1;
	}

	public void setSalePrice1(Float salePrice1) {
		this.salePrice1 = salePrice1;
	}

	public Float getSalePrice2() {
		return salePrice2;
	}

	public void setSalePrice2(Float salePrice2) {
		this.salePrice2 = salePrice2;
	}

	public String getPlanSaleStartTime() {
		return planSaleStartTime;
	}

	public void setPlanSaleStartTime(String planSaleStartTime) {
		this.planSaleStartTime = planSaleStartTime;
	}

	public String getPlanSaleEndTime() {
		return planSaleEndTime;
	}

	public void setPlanSaleEndTime(String planSaleEndTime) {
		this.planSaleEndTime = planSaleEndTime;
	}

	public String getCatName() {
		return catName;
	}

	public List<ProductProperty> getPropList() {
		return propList;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public void setPropList(List<ProductProperty> propList) {
		this.propList = propList;
	}

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductKeywords() {
        return productKeywords;
    }

    public void setProductKeywords(String productKeywords) {
        this.productKeywords = productKeywords == null ? null : productKeywords.trim();
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Float marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }


    public Integer getIsShowAll() {
		return isShowAll;
	}

	public void setIsShowAll(Integer isShowAll) {
		this.isShowAll = isShowAll;
	}

	public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getProdThumbPic1() {
        return prodThumbPic1;
    }

    public void setProdThumbPic1(String prodThumbPic1) {
        this.prodThumbPic1 = prodThumbPic1 == null ? null : prodThumbPic1.trim();
    }

    public String getProdThumbPic2() {
        return prodThumbPic2;
    }

    public void setProdThumbPic2(String prodThumbPic2) {
        this.prodThumbPic2 = prodThumbPic2 == null ? null : prodThumbPic2.trim();
    }

    public Integer getIsReal() {
        return isReal;
    }

    public void setIsReal(Integer isReal) {
        this.isReal = isReal;
    }

    public Integer getIsGift() {
        return isGift;
    }

    public void setIsGift(Integer isGift) {
        this.isGift = isGift;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Integer getProdStatus() {
        return prodStatus;
    }

    public void setProdStatus(Integer prodStatus) {
        this.prodStatus = prodStatus;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getPlanSaleTime() {
        return planSaleTime;
    }

    public void setPlanSaleTime(String planSaleTime) {
        this.planSaleTime = planSaleTime;
    }

    public String getShelvesTime() {
        return shelvesTime;
    }

    public void setShelvesTime(String shelvesTime) {
        this.shelvesTime = shelvesTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getProdDetails() {
        return prodDetails;
    }

    public void setProdDetails(String prodDetails) {
        this.prodDetails = prodDetails == null ? null : prodDetails.trim();
    }


	public List<ProductAttribute> getAttrList() {
		return attrList;
	}

	public void setAttrList(List<ProductAttribute> attrList) {
		this.attrList = attrList;
	}

	public Integer getMiniNum() {
		return miniNum;
	}

	public void setMiniNum(Integer miniNum) {
		this.miniNum = miniNum;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getProdStatusName() {
		String temp = ProductUtils.PROD_STATUS_YSJ;
		if(prodStatus==2){
			temp = ProductUtils.PROD_STATUS_YXJ;
		}else if(prodStatus==3){
			temp = ProductUtils.PROD_STATUS_DSJ;
		}else if(prodStatus==4){
			temp = ProductUtils.PROD_STATUS_SY;
		}
		return temp;
	}

	public void setProdStatusName(String prodStatusName) {
		this.prodStatusName = prodStatusName;
	}

	public List<ProductPic> getPicList() {
		return picList;
	}

	public void setPicList(List<ProductPic> picList) {
		this.picList = picList;
	}

	public Integer getIsNowTime() {
		return isNowTime;
	}

	public void setIsNowTime(Integer isNowTime) {
		this.isNowTime = isNowTime;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getWarrantyNotes() {
		return warrantyNotes;
	}

	public void setWarrantyNotes(String warrantyNotes) {
		this.warrantyNotes = warrantyNotes;
	}

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}


    
    
}