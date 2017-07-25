package com.huixin.web.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Settlement;
import com.huixin.web.model.SettlementItem;

public interface SettlementItemMapper {
	
	public PageList<SettlementItem> selectSettlementItemByEntity(SettlementItem settlementItem,PageBounds pageBounds);
	
	public SettlementItem selectSettlementItemById(SettlementItem settlementItem);
	
	public int updateSettlementItemById(SettlementItem settlementItem);
	
	public int insetSettlementItem(SettlementItem settlementItem);
	
	public int deleteSettlementItem(SettlementItem settlementItem);
	
	public int batchInsertSettlementItem(List<SettlementItem> settlementItem);
	
	public int deleteSettlementItemBysettId(Settlement settlement);
	
	public int deleteSettlementItemByOrderId(Map<String, Object> map);
	

}
