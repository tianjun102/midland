package com.huixin.web.model;

import java.util.List;

public class Promotion {
	
	  private Integer id;
	  private String  prom_sn;//
	  private String  prom_name;//
	  private Integer type;//类型：0=买送；1=满送；',
	  private Integer is_mutex; //'是否互斥：0=不互斥；1=互斥；（默认不做互斥处理）',
	  private Integer is_confirm;// '是否审核:0=未审核；1=已审核;',
	  private String  prom_start; //datetime DEFAULT NULL,
	  private String  prom_end; //datetime DEFAULT NULL,
	  private Long prom_order_amount; //DEFAULT NULL COMMENT '订单金额(≥）',
	  private String  creat_time; //datetime DEFAULT NULL COMMENT '创建日期',
	  private String  confirm_time; //datetime DEFAULT NULL COMMENT '审核时间',
	  private Integer enabled; // '是否启用：0=未启用；1=启用；',
	  private String  update_time;// 更新时间
	  private List<Object>  prom_prod_idList;// 更新时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProm_sn() {
		return prom_sn;
	}
	public void setProm_sn(String prom_sn) {
		this.prom_sn = prom_sn;
	}
	public String getProm_name() {
		return prom_name;
	}
	public void setProm_name(String prom_name) {
		this.prom_name = prom_name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getIs_mutex() {
		return is_mutex;
	}
	public void setIs_mutex(Integer is_mutex) {
		this.is_mutex = is_mutex;
	}
	public Integer getIs_confirm() {
		return is_confirm;
	}
	public void setIs_confirm(Integer is_confirm) {
		this.is_confirm = is_confirm;
	}
	public String getProm_start() {
		return prom_start;
	}
	public void setProm_start(String prom_start) {
		this.prom_start = prom_start;
	}
	public String getProm_end() {
		return prom_end;
	}
	public void setProm_end(String prom_end) {
		this.prom_end = prom_end;
	}
	public Long getProm_order_amount() {
		return prom_order_amount;
	}
	public void setProm_order_amount(Long prom_order_amount) {
		this.prom_order_amount = prom_order_amount;
	}
	public String getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(String creat_time) {
		this.creat_time = creat_time;
	}
	public String getConfirm_time() {
		return confirm_time;
	}
	public void setConfirm_time(String confirm_time) {
		this.confirm_time = confirm_time;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	public List<Object> getProm_prod_idList() {
		return prom_prod_idList;
	}
	public void setProm_prod_idList(List<Object> prom_prod_idList) {
		this.prom_prod_idList = prom_prod_idList;
	}
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", prom_sn=" + prom_sn + ", prom_name=" + prom_name + ", type=" + type
				+ ", is_mutex=" + is_mutex + ", is_confirm=" + is_confirm + ", prom_start=" + prom_start + ", prom_end="
				+ prom_end + ", prom_order_amount="
				+ prom_order_amount + ", creat_time=" + creat_time + ", confirm_time=" + confirm_time + ", enabled="
				+ enabled + ", update_time=" + update_time + "]";
	}
	  
	  

}
