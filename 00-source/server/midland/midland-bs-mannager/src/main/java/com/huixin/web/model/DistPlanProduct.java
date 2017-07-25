package com.huixin.web.model;

import java.io.Serializable;

public class DistPlanProduct implements Serializable{
	
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7093200561151525506L;

	private Integer id;

    private Integer distPlanId;

    private Integer prodId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistPlanId() {
        return distPlanId;
    }

    public void setDistPlanId(Integer distPlanId) {
        this.distPlanId = distPlanId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }
}