package com.huixin.web.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.PromotionGift;
import com.huixin.web.model.PromotionProp;

public interface PromotionGiftMapper {
	
	public List<PromotionGift> selectPromotionGiftByParem(PromotionGift promotionGif);
	public PageList<PromotionGift> selectPromotionGiftByEntity(PromotionGift promotionGif,PageBounds pageBounds);//搜索可用
	public PromotionGift selectPromotionGiftById(PromotionGift promotionGif);//查询实体
	public Integer insetPromotionGift(PromotionGift promotionGif);
	public Integer deletePromotionGift(PromotionGift promotionGif);
	public Integer updatePromotionGiftById(PromotionGift promotionGif);
	public Integer batchInsert(List<PromotionGift> promotionGiftList);
	public List<PromotionGift> selectPromotionGiftByPromId(Map<String, Object> map);
	public List<Integer> selectidListGiftById(Map<String, Object> map);//prom_id 和所有id
	public Integer batchDeletePromotionGift(List<Integer> idList);
	public Integer batchUpdate(List<PromotionGift> list);

}
