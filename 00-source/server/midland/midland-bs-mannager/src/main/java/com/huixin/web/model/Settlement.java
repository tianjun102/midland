package com.huixin.web.model;

import java.io.Serializable;

public class Settlement implements Serializable {
	
	/**
	 * 财务结算单
	 */
	private static final long serialVersionUID = -932655053617377115L;
	private Integer id;
	private String sett_sn;
	private Integer cust_id;
	private Double sett_amount;
	private Double total_amount;
	private String sett_note;
	private String create_time;
	private String user_by;
	private Integer status;
	private String update_time;
	private Integer user_id;
	private String begin_time;
	private String end_time;
	private String betweenTimeStart;
	private String betweenTimeEnd;
	private String cust_name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) { 
		this.id = id;
	}
	public String getSett_sn() {
		return sett_sn;
	}
	public void setSett_sn(String sett_sn) {
		this.sett_sn = sett_sn;
	}
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	public Double getSett_amount() {
		return sett_amount;
	}
	public void setSett_amount(Double sett_amount) {
		this.sett_amount = sett_amount;
	}
	public Double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}
	public String getSett_note() {
		return sett_note;
	}
	public void setSett_note(String sett_note) {
		this.sett_note = sett_note;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUser_by() {
		return user_by;
	}
	public void setUser_by(String user_by) {
		this.user_by = user_by;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getBetweenTimeStart() {
		return betweenTimeStart;
	}
	public void setBetweenTimeStart(String betweenTimeStart) {
		this.betweenTimeStart = betweenTimeStart;
	}
	public String getBetweenTimeEnd() {
		return betweenTimeEnd;
	}
	public void setBetweenTimeEnd(String betweenTimeEnd) {
		this.betweenTimeEnd = betweenTimeEnd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	
	

}
