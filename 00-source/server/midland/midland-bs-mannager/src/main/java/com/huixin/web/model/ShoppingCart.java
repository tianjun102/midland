package com.huixin.web.model;



public class ShoppingCart implements java.io.Serializable{

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8456182291437212997L;

	/**
     * 购物车商品主键
     */
    private String productId;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 添加时间
     */
  //  private Long addTime;

    /**
     * 会员添加的备注
     */
    private String userRemark;
    
    
    /**
     * 该商品是否为礼品
     */
    private Integer isGift;

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }


    public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	public Integer getIsGift() {
		return isGift;
	}

	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
	}

 /*   public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }*/
    
    
}
