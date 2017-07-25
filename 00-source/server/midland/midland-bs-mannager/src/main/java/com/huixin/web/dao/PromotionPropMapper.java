package com.huixin.web.dao;

import java.util.List;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.PromotionProp;

public interface PromotionPropMapper {
	public List<PromotionProp> selectPromotionPropByParem(PromotionProp promotionProp);
	public PageList<PromotionProp> selectPromotionPropByEntity(PromotionProp promotionProp,PageBounds pageBounds);//搜索可用
	public PromotionProp selectPromotionPropById(PromotionProp promotionProp);//查询实体
	public Integer insetPromotionProp(PromotionProp promotionProp);
	public Integer deletePromotionProp(PromotionProp promotionProp);
	public Integer updatePromotionPropById(PromotionProp promotionProp);
	public Integer batchInsert(List<PromotionProp> promotionPropList);
	public List<PromotionProp> selectPromotionPropByPromId(Map<String, Object> map);
	public List<Integer> selectidListPropById(Map<String, Object> map);//prom_id 和所有id
	public Integer batchDeletePromotionProp(List<Integer> idList);
	public Integer batchUpdate(List<PromotionProp> list);
	

}
