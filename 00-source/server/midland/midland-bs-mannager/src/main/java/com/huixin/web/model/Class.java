package com.huixin.web.model;

import java.io.Serializable;
import java.util.List;

public class Class implements Serializable {
	
	/**
	 * 栏目表
	 */
	private static final long serialVersionUID = -2831193091027457555L;
	private Integer classId;//主键
	private Integer propertyId;//属性id关联属性表
	private String className;//栏目名称
	private String classPic;//栏目图片
	private String targetUrl;//栏目url
	private String linkUrl;//连接地址
	private String classDescription;//栏目描述
	private Integer catId;//关联分类表id
	private Integer parentId;//父菜单id
	private String  addTime;//添加时间
	private Integer isClose;//是否开启
	private  Integer sortOrder;//排序
	private List<Menu> childMenus;//封装子菜单
	private Integer counts;//子菜单总数
	private String propertyName;
	private Integer isChildMenu;
	private String userBy;
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassPic() {
		return classPic;
	}
	public void setClassPic(String classPic) {
		this.classPic = classPic;
	}
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getClassDescription() {
		return classDescription;
	}
	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public Integer getIsClose() {
		return isClose;
	}
	public void setIsClose(Integer isClose) {
		this.isClose = isClose;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public List<Menu> getChildMenus() {
		return childMenus;
	}
	public void setChildMenus(List<Menu> childMenus) {
		this.childMenus = childMenus;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public Integer getIsChildMenu() {
		return isChildMenu;
	}
	public void setIsChildMenu(Integer isChildMenu) {
		this.isChildMenu = isChildMenu;
	}
	public String getUserBy() {
		return userBy;
	}
	public void setUserBy(String userBy) {
		this.userBy = userBy;
	}
	@Override
	public String toString() {
		return "Class [classId=" + classId + ", propertyId=" + propertyId + ", className=" + className + ", classPic="
				+ classPic + ", targetUrl=" + targetUrl + ", linkUrl=" + linkUrl + ", classDescription="
				+ classDescription + ", catId=" + catId + ", parentId=" + parentId + ", addTime=" + addTime
				+ ", isClose=" + isClose + ", sortOrder=" + sortOrder + ", childMenus=" + childMenus + ", counts="
				+ counts + ", propertyName=" + propertyName + ", isChildMenu=" + isChildMenu + ", userBy=" + userBy
				+ "]";
	}


	
	
	
	

}
