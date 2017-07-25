package com.huixin.web.service;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Customer;
import com.huixin.web.model.OrderInfo;
import com.huixin.web.model.Settlement;
import com.huixin.web.model.SettlementItem;
public interface SettlementService {
	
	public PageList<Settlement> selectSettlementList(Settlement settlement ,PageBounds pageBounds);
	
	public Settlement selectSettlement(Settlement settlement);
	
	public Integer updateSettlement(Settlement settlement);
	
	public Integer insertSettlement(Settlement settlement);
	
	public Integer deleteSettlement(Settlement settlement);
	
	public Integer deleteSettlementItem(SettlementItem settlementItem);
	
	public List<OrderInfo> selectOrderInfoList(OrderInfo orderInfo);

	List<Customer> selectCustomerList(String custName);

	List<Customer> selectCustomerListById(Integer custId);
	
	public Integer insertSettlementItem(List<SettlementItem> list);
	
	public Double selectOrderAmountCount(OrderInfo orderInfo);

	public Integer updateSettStatus(Settlement settlement);

	public Integer deleteSettlementItem(Settlement settlement);
	
	public Integer deleteSettlementItemByOrderId(Map<String, Object> map);
	
	public List<OrderInfo>  selectOrderInfoDetails(Settlement settlement);
}
