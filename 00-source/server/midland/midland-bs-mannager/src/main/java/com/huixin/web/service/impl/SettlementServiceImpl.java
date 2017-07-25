package com.huixin.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.dao.CustomerMapper;
import com.huixin.web.dao.OrderInfoMapper;
import com.huixin.web.dao.SettlementItemMapper;
import com.huixin.web.dao.SettlementMapper;
import com.huixin.web.model.Customer;
import com.huixin.web.model.CustomerExample;
import com.huixin.web.model.OrderInfo;
import com.huixin.web.model.RegionExample;
import com.huixin.web.model.Settlement;
import com.huixin.web.model.SettlementItem;
import com.huixin.web.service.SettlementService;
@Service
public class SettlementServiceImpl implements SettlementService {
	@Autowired private SettlementMapper settlementMapper;
	@Autowired private OrderInfoMapper orderInfoMapper;
	@Autowired private CustomerMapper customerMapper;
	@Autowired private SettlementItemMapper settlementItemMapper;

	@Override
	public PageList<Settlement> selectSettlementList(Settlement settlement, PageBounds pageBounds) {
		return settlementMapper.selectSettlementByEntity(settlement, pageBounds);
	}

	@Override
	public Settlement selectSettlement(Settlement settlement) {
		return settlementMapper.selectSettlementById(settlement);
	}

	@Override
	public Integer updateSettlement(Settlement settlement) {
		return settlementMapper.updateSettlementById(settlement);
	}

	@Override
	public Integer insertSettlement(Settlement settlement) {
		return settlementMapper.insetSettlement(settlement);
	}

	@Override
	public Integer deleteSettlement(Settlement settlement) {
		return settlementMapper.deleteSettlement(settlement);
	}
	//获取订单信息
	@Override
	public List<OrderInfo> selectOrderInfoList(OrderInfo orderInfo) {
		return orderInfoMapper.selectOrderInfoByEntity(orderInfo);
	}
	@Override
	public List<Customer> selectCustomerList(String custName){
		CustomerExample example=new CustomerExample();
		example.createCriteria().andCustNameLike("%"+custName+"%").andCustParentIdEqualTo(0);
		return customerMapper.selectByExample(example);
		
	}
	@Override
	public List<Customer> selectCustomerListById(Integer custId){
		CustomerExample example=new CustomerExample();
		example.createCriteria().andCustParentIdEqualTo(custId);
		return customerMapper.selectByExample(example);
		
	}

	@Override
	public Integer insertSettlementItem(List<SettlementItem> list) {
		// TODO Auto-generated method stub
		return settlementItemMapper.batchInsertSettlementItem(list);
	}

	@Override
	public Double selectOrderAmountCount(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return orderInfoMapper.selectOrderAmountCount(orderInfo);
	}
	
	@Override
	public Integer updateSettStatus(Settlement settlement) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", settlement.getId());
		return orderInfoMapper.updatesettStatus(map);
	}

	@Override
	public Integer deleteSettlementItem(Settlement settlement) {
		// TODO Auto-generated method stub
		return settlementItemMapper.deleteSettlementItemBysettId(settlement);
	}

	@Override
	public Integer deleteSettlementItem(SettlementItem settlementItem) {
		// TODO Auto-generated method stub
		return settlementItemMapper.deleteSettlementItem(settlementItem);
	}

	@Override
	public Integer deleteSettlementItemByOrderId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return settlementItemMapper.deleteSettlementItemByOrderId(map);
	}

	@Override
	public List<OrderInfo> selectOrderInfoDetails(Settlement settlement) {
		// TODO Auto-generated method stub
		return orderInfoMapper.selectorderDetails(settlement);
	}





}
