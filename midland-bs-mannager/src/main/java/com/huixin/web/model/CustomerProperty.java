package com.huixin.web.model;

public class CustomerProperty {
    private Integer propId;

    private Integer propType;

    private String propName;

    private String propValues;

    private Integer isShow;

    public Integer getPropId() {
        return propId;
    }

    public void setPropId(Integer propId) {
        this.propId = propId;
    }

    public Integer getPropType() {
        return propType;
    }

    public void setPropType(Integer propType) {
        this.propType = propType;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName == null ? null : propName.trim();
    }

    public String getPropValues() {
        return propValues;
    }

    public void setPropValues(String propValues) {
        this.propValues = propValues == null ? null : propValues.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
}