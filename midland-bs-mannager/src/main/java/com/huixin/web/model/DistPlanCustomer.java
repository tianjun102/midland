package com.huixin.web.model;

import java.io.Serializable;

public class DistPlanCustomer implements Serializable{
	
	
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3911090534931804066L;

	private Integer id;

    private Integer distPlanId;

    private Integer custId;

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

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }
}