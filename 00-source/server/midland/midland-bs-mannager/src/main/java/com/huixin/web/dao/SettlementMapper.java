package com.huixin.web.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Settlement;

public interface SettlementMapper {
	public PageList<Settlement> selectSettlementByEntity(Settlement settlement,PageBounds pageBounds);
	
	public Settlement selectSettlementById(Settlement settlement);
	
	public int updateSettlementById(Settlement settlement);
	
	public int insetSettlement(Settlement settlement);
	
	public int deleteSettlement(Settlement settlement);
	
	public int batchInsert(List<Settlement> list);

}
