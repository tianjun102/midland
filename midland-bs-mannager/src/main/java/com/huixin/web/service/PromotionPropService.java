package com.huixin.web.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Promotion;
import com.huixin.web.model.PromotionProp;
public interface PromotionPropService {
	
	public List<PromotionProp> selectPromotionPropByParem(PromotionProp promotionProp);
	public PageList<PromotionProp> selectPromotionPropByEntity(PromotionProp promotionProp,PageBounds pageBounds);//搜索可用
	public PromotionProp selectPromotionPropById(PromotionProp promotionProp);//查询实体
	public Integer insetPromotionProp(PromotionProp promotionProp);
	public Integer deletePromotionProp(PromotionProp promotionProp);
	public Integer updatePromotionPropById(PromotionProp promotionProp);
	public Integer insetBatchPromotionProp(List<PromotionProp> promotionProp);
	public List<PromotionProp> selectPromotionPropByPromId(Map<String,Object> map);
	public Integer saveOrUpdatePromotionProp(List<PromotionProp> promotionPropList,Promotion promotion);
	Integer delectPromotionPropAndInsert(List<PromotionProp> promotionPropList, Promotion promotion);
}
