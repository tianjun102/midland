package com.huixin.web.model;

import java.io.Serializable;
import java.util.List;

//分类表
public class Category implements Serializable{
		
	
	private static final long serialVersionUID = 4089861267775703147L;
	
	
	private Integer	catId; 
	private	String	catName;
	private	String	catDesc;
	private	Integer	parentId;
	private	Integer	sortOrder;	//菜单排序，默认升序'
	private	Integer	isShow; 	//0=不显示，1=显示；
	private String	parentName;
	private List<Category> childCategory;
	
	private Integer	chirdCount;   //子类数
	
	private Integer	productCount;  //分类数
	
	public Integer getChirdCount() {
		if(chirdCount==null){
			chirdCount=0;
		}
		return chirdCount;
	}
	public void setChirdCount(Integer chirdCount) {
		this.chirdCount = chirdCount;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
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
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public List<Category> getChildCategory() {
		return childCategory;
	}
	public void setChildCategory(List<Category> childCategory) {
		this.childCategory = childCategory;
	}

	
	
}
