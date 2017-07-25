package com.huixin.web.model;

import java.io.Serializable;

public class Activity implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -7950817108897001602L;
	 private Integer id;
	 private String actiTitle;
	 private String acti_thumb_pic1;
	 private String acti_thumb_pic2;
	 private String actiDetails;
	 private Integer clickNum;
	 private String addTime;
	 private String updateTime;
	 private String startTime;//活动开始
	 private String endTime;//活动结束
	 private Integer isShow;
	 private Integer sortOrder;
	 private String userBy;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getActiTitle() {
		return actiTitle;
	}
	public void setActiTitle(String actiTitle) {
		this.actiTitle = actiTitle;
	}
	public String getActiDetails() {
		return actiDetails;
	}
	public void setActiDetails(String actiDetails) {
		this.actiDetails = actiDetails;
	}
	public Integer getClickNum() {
		return clickNum;
	}
	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getUserBy() {
		return userBy;
	}
	public void setUserBy(String userBy) {
		this.userBy = userBy;
	}
	public String getActi_thumb_pic1() {
		return acti_thumb_pic1;
	}
	public void setActi_thumb_pic1(String acti_thumb_pic1) {
		this.acti_thumb_pic1 = acti_thumb_pic1;
	}
	public String getActi_thumb_pic2() {
		return acti_thumb_pic2;
	}
	public void setActi_thumb_pic2(String acti_thumb_pic2) {
		this.acti_thumb_pic2 = acti_thumb_pic2;
	}
	
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Activity [id=" + id + ", actiTitle=" + actiTitle+", updateTime=" + updateTime + ", acti_thumb_pic1=" + acti_thumb_pic1
				+ ", acti_thumb_pic2=" + acti_thumb_pic2 + ", actiDetails=" + actiDetails + ", clickNum=" + clickNum
				+ ", addTime=" + addTime + ", startTime=" + startTime + ", endTime=" + endTime + ", isShow=" + isShow
				+ ", sortOrder=" + sortOrder + ", userBy=" + userBy + "]";
	}
	


}
