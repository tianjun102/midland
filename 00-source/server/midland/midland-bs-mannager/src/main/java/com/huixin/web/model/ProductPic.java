package com.huixin.web.model;

import java.io.Serializable;

public class ProductPic implements Serializable{
	
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2759604953392423649L;

	private Integer picId;

    private Integer prodId;

    private String picUrl;

    private String picDesc;

    private String thumbUrl;
    
    private String thumbUrl2;

    private String picOriginal;

    private String img1;
    
    private String img2;
    
    
    
    
    public String getThumbUrl2() {
		return thumbUrl2;
	}

	public void setThumbUrl2(String thumbUrl2) {
		this.thumbUrl2 = thumbUrl2;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getPicDesc() {
        return picDesc;
    }

    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc == null ? null : picDesc.trim();
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl == null ? null : thumbUrl.trim();
    }

    public String getPicOriginal() {
        return picOriginal;
    }

    public void setPicOriginal(String picOriginal) {
        this.picOriginal = picOriginal == null ? null : picOriginal.trim();
    }
}