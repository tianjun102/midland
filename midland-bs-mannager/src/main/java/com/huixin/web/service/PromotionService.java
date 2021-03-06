package com.huixin.web.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Promotion;

public interface PromotionService {
	
	public PageList<Promotion> selectPromotionByParem(Promotion promotion,PageBounds pageBounds);
	public PageList<Promotion> selectPromotionByEntity(Promotion promotion,PageBounds pageBounds);//搜索可用
	public Promotion selectPromotionById(Promotion promotion);//查询实体
	public Integer insetPromotion(Promotion promotion);
	public Integer deletePromotion(Promotion promotion);
	public Integer updatePromotionById(Promotion promotion);
	public Integer insetBatchPromotion(List<Promotion> promotion);
	public Integer deletePromById(Promotion promotion);

}
