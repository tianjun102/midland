package com.huixin.web.model;

import java.util.Date;

public class Customer {
    private Integer custId;

    private String custCode;

    private String custName;

    private Integer custType;

    private String custFullName;

    private Integer custParentId;

    private Integer areaId;

    private String custNote;

    private String realName;

    private String idCard;

    private String custPhone;

    private String custTel;

    private String custEmail;

    private String businessLicense;

    private String businessLicensePic;

    private String registAddress;

    private Integer enterAttr;

    private String enterProd;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private Integer status;
    
    private String areaName;
    
    private String parentCustName;
    
    private String distType;//渠道商分类
    
    private String prodNames;
    
    private Integer deleteFlag;//是否可以删除

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode == null ? null : custCode.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public Integer getCustType() {
        return custType;
    }

    public void setCustType(Integer custType) {
        this.custType = custType;
    }

    public String getCustFullName() {
        return custFullName;
    }

    public void setCustFullName(String custFullName) {
        this.custFullName = custFullName == null ? null : custFullName.trim();
    }

    public Integer getCustParentId() {
        return custParentId;
    }

    public void setCustParentId(Integer custParentId) {
        this.custParentId = custParentId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getCustNote() {
        return custNote;
    }

    public void setCustNote(String custNote) {
        this.custNote = custNote == null ? null : custNote.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel == null ? null : custTel.trim();
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail == null ? null : custEmail.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public String getBusinessLicensePic() {
        return businessLicensePic;
    }

    public void setBusinessLicensePic(String businessLicensePic) {
        this.businessLicensePic = businessLicensePic == null ? null : businessLicensePic.trim();
    }

    public String getRegistAddress() {
        return registAddress;
    }

    public void setRegistAddress(String registAddress) {
        this.registAddress = registAddress == null ? null : registAddress.trim();
    }

    public Integer getEnterAttr() {
        return enterAttr;
    }

    public void setEnterAttr(Integer enterAttr) {
        this.enterAttr = enterAttr;
    }

    public String getEnterProd() {
        return enterProd;
    }

    public void setEnterProd(String enterProd) {
        this.enterProd = enterProd == null ? null : enterProd.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getParentCustName() {
		return parentCustName;
	}

	public void setParentCustName(String parentCustName) {
		this.parentCustName = parentCustName;
	}

	public String getDistType() {
		return distType;
	}

	public void setDistType(String distType) {
		this.distType = distType;
	}

	public String getProdNames() {
		return prodNames;
	}

	public void setProdNames(String prodNames) {
		this.prodNames = prodNames;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
    
}