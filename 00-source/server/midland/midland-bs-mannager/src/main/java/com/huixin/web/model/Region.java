package com.huixin.web.model;

import java.util.Date;

public class Region {
    private Integer regionId;

    private Integer parentId;

    private String regionName;

    private Boolean regionType;

    private Short agencyId;

    private String regionSn;

    private Boolean buildin;

    private Date lastchanged;

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Boolean getRegionType() {
        return regionType;
    }

    public void setRegionType(Boolean regionType) {
        this.regionType = regionType;
    }

    public Short getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Short agencyId) {
        this.agencyId = agencyId;
    }

    public String getRegionSn() {
        return regionSn;
    }

    public void setRegionSn(String regionSn) {
        this.regionSn = regionSn == null ? null : regionSn.trim();
    }

    public Boolean getBuildin() {
        return buildin;
    }

    public void setBuildin(Boolean buildin) {
        this.buildin = buildin;
    }

    public Date getLastchanged() {
        return lastchanged;
    }

    public void setLastchanged(Date lastchanged) {
        this.lastchanged = lastchanged;
    }
}