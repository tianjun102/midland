package com.huixin.web.model;

import java.io.Serializable;

public class SettlementItem implements Serializable {
	
		/**
		 * 订单结算关联表
		 */
	private static final long serialVersionUID = -5650286640084437379L;
		private Integer id;
		private Integer sett_id;
		private Integer order_id;
	  
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getSett_id() {
			return sett_id;
		}
		public void setSett_id(Integer sett_id) {
			this.sett_id = sett_id;
		}
		public Integer getOrder_id() {
			return order_id;
		}
		public void setOrder_id(Integer order_id) {
			this.order_id = order_id;
		}
		  
		  

}
