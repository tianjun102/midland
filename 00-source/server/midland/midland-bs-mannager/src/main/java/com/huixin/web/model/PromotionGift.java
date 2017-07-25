package com.huixin.web.model;

public class PromotionGift {
	
	  private Integer id;
	  private Integer prom_id;
	  private Integer prod_id;// '产品ID',
	  private String  prod_code;// '产品货号',
	  private String  prod_name;// '产品名称',
	  private Integer prod_number;//'产品数量',
	  private Double    prod_price; //产品价格',
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProm_id() {
		return prom_id;
	}
	public void setProm_id(Integer prom_id) {
		this.prom_id = prom_id;
	}
	public Integer getProd_id() {
		return prod_id;
	}
	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_code() {
		return prod_code;
	}
	public void setProd_code(String prod_code) {
		this.prod_code = prod_code;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public Integer getProd_number() {
		return prod_number;
	}
	public void setProd_number(Integer prod_number) {
		this.prod_number = prod_number;
	}
	public Double getProd_price() {
		return prod_price;
	}
	public void setProd_price(Double prod_price) {
		this.prod_price = prod_price;
	}
	@Override
	public String toString() {
		return "PromotionGift [id=" + id + ", prom_id=" + prom_id + ", prod_id=" + prod_id + ", prod_code=" + prod_code
				+ ", prod_name=" + prod_name + ", prod_number=" + prod_number + ", prod_price=" + prod_price + "]";
	}
	  
	  

}
