package com.huixin.web.model;

import java.io.Serializable;

public class ClassProperty implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8951358179434841585L;
	private Integer property_id;
	private String property_name;
	private String property_code;
	private Integer list_id;
	private String addtime;
	private Integer isclose;
	
	public Integer getProperty_id() {
		return property_id;
	}
	public void setProperty_id(Integer property_id) {
		this.property_id = property_id;
	}
	public String getProperty_name() {
		return property_name;
	}
	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}
	public String getProperty_code() {
		return property_code;
	}
	public void setProperty_code(String property_code) {
		this.property_code = property_code;
	}
	public Integer getList_id() {
		return list_id;
	}
	public void setList_id(Integer list_id) {
		this.list_id = list_id;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public Integer getIsclose() {
		return isclose;
	}
	public void setIsclose(Integer isclose) {
		this.isclose = isclose;
	}
	@Override
	public String toString() {
		return "ClassProperty [property_id=" + property_id + ", property_name=" + property_name + ", property_code="
				+ property_code + ", list_id=" + list_id + ", addtime=" + addtime + ", isclose=" + isclose + "]";
	}
	
	
	

}
