package com.huixin.web.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Promotion;
import com.huixin.web.model.PromotionGift;

public interface PromotionGiftService {
	
	public List<PromotionGift> selectPromotionGiftByParem(PromotionGift promotionGif);
	public PageList<PromotionGift> selectPromotionGiftByEntity(PromotionGift promotionGif,PageBounds pageBounds);//搜索可用
	public PromotionGift selectPromotionGiftById(PromotionGift promotionGif);//查询实体
	public Integer insetPromotionGift(PromotionGift promotionGif);
	public Integer deletePromotionGift(PromotionGift promotionGif);
	public Integer updatePromotionGiftById(PromotionGift promotionGif);
	public Integer insetBatchPromotionGift(List<PromotionGift> promotionGif);
	public List<PromotionGift> selectPromotionGiftByPromId(Map<String,Object> map);
	public Integer saveOrUpdatePromotionGift(List<PromotionGift> promotionPromotionGiftList,Promotion promotion);
	Integer delectPromotionGiftAndInsert(List<PromotionGift> promotionGiftList, Promotion promotion);
}
