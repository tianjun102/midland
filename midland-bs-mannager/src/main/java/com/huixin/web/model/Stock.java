package com.huixin.web.model;

import java.util.Date;

public class Stock {
    private Integer id;

    private Integer ckId;

    private String ckCode;

    private Integer productId;

    private Integer sl;

    private Integer sl1;

    private Integer sl2;

    private Integer safeSl;

    private Date updateTime;
    
    private String productCode;//产品代码
    private String productName;//产品名称
    
    private Integer  catId;//分类
    private String  catName;//分类

    private Integer kcl;//筛选条件 库存量
    private Integer l1;//下限
    private Integer l2;//上限
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCkId() {
        return ckId;
    }

    public void setCkId(Integer ckId) {
        this.ckId = ckId;
    }

    public String getCkCode() {
        return ckCode;
    }

    public void setCkCode(String ckCode) {
        this.ckCode = ckCode == null ? null : ckCode.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSl() {
    	if(sl==null){
    		sl = 0;
    	}
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public Integer getSl1() {
    	if(sl1==null){
    		sl1 = 0;
    	}
        return sl1;
    }

    public void setSl1(Integer sl1) {
        this.sl1 = sl1;
    }

    public Integer getSl2() {
    	if(sl2==null){
    		sl2 = 0;
    	}
        return sl2;
    }

    public void setSl2(Integer sl2) {
        this.sl2 = sl2;
    }

    public Integer getSafeSl() {
        return safeSl;
    }

    public void setSafeSl(Integer safeSl) {
        this.safeSl = safeSl;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
	
	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Integer getKcl() {
		return kcl;
	}

	public void setKcl(Integer kcl) {
		this.kcl = kcl;
	}

	public Integer getL1() {
		return l1;
	}

	public void setL1(Integer l1) {
		this.l1 = l1;
	}

	public Integer getL2() {
		return l2;
	}

	public void setL2(Integer l2) {
		this.l2 = l2;
	}
    
    
}