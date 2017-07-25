package com.huixin.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DistPlan implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1467574318008842790L;

	private Integer id;

    private String distPlanSn;

    private String distPlanName;

    private Date creatTime;

    private Integer userBy;

    private Date updateTime;

    //自定义属性  
    
    private List<DistPlanProduct> proList = new ArrayList<DistPlanProduct>();
    
    private List<DistPlanCustomer> custList = new ArrayList<DistPlanCustomer>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistPlanSn() {
        return distPlanSn;
    }

    public void setDistPlanSn(String distPlanSn) {
        this.distPlanSn = distPlanSn == null ? null : distPlanSn.trim();
    }

    public String getDistPlanName() {
        return distPlanName;
    }

    public void setDistPlanName(String distPlanName) {
        this.distPlanName = distPlanName == null ? null : distPlanName.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getUserBy() {
        return userBy;
    }

    public void setUserBy(Integer userBy) {
        this.userBy = userBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public List<DistPlanProduct> getProList() {
		return proList;
	}

	public void setProList(List<DistPlanProduct> proList) {
		this.proList = proList;
	}

	public List<DistPlanCustomer> getCustList() {
		return custList;
	}

	public void setCustList(List<DistPlanCustomer> custList) {
		this.custList = custList;
	}
    
    
}