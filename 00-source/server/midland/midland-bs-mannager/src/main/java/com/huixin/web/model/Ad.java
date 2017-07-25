package com.huixin.web.model;

import java.io.Serializable;

public class Ad implements Serializable {
	
	
	  /**
	 * 广告实体类
	 */
	private static final long serialVersionUID = -4629701472767972192L;
	private  Integer adId;
	private  String adName;
	private  String adInfo;
	private  String ad_thumb_pic1;
	private  String ad_thumb_pic2;
	private  Integer mediaType;
	private  String adLinkurl;
	private  Integer clickNum;
	private  String addTime;
	private  Integer enabled;
	private  Integer sortOrder;
	private  String  updateTime;
	private  String  userBy;
	public Integer getAdId() {
		return adId;
	}
	public void setAdId(Integer adId) {
		this.adId = adId;
	}
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}
	public String getAdInfo() {
		return adInfo;
	}
	public void setAdInfo(String adInfo) {
		this.adInfo = adInfo;
	}
	public String getAd_thumb_pic1() {
		return ad_thumb_pic1;
	}
	public void setAd_thumb_pic1(String ad_thumb_pic1) {
		this.ad_thumb_pic1 = ad_thumb_pic1;
	}
	public String getAd_thumb_pic2() {
		return ad_thumb_pic2;
	}
	public void setAd_thumb_pic2(String ad_thumb_pic2) {
		this.ad_thumb_pic2 = ad_thumb_pic2;
	}
	public Integer getMediaType() {
		return mediaType;
	}
	public void setMediaType(Integer mediaType) {
		this.mediaType = mediaType;
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
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getAdLinkurl() {
		return adLinkurl;
	}
	public void setAdLinkurl(String adLinkurl) {
		this.adLinkurl = adLinkurl;
	}
	
	public String getUserBy() {
		return userBy;
	}
	public void setUserBy(String userBy) {
		this.userBy = userBy;
	}
	@Override
	public String toString() {
		return "Ad [adId=" + adId + ", adName=" + adName+", adName=" + adName + ", adInfo=" + adInfo + ", ad_thumb_pic1=" + ad_thumb_pic1
				+ ", ad_thumb_pic2=" + ad_thumb_pic2 + ", mediaType=" + mediaType + ", adLinkurl=" + adLinkurl
				+ ", clickNum=" + clickNum + ", addTime=" + addTime + ", enabled=" + enabled + ", sortOrder="
				+ sortOrder + ", updateTime=" + updateTime + "]";
	}

	
	
	

}
