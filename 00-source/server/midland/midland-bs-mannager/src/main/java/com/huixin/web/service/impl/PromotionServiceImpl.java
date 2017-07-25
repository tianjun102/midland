package com.huixin.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.dao.PromotionMapper;
import com.huixin.web.model.Promotion;
import com.huixin.web.service.PromotionService;
@Service
public class PromotionServiceImpl implements PromotionService {
	@Autowired
	private PromotionMapper promotionMapper;
	@Override
	public PageList<Promotion> selectPromotionByParem(Promotion promotion, PageBounds pageBounds) {
		return promotionMapper.selectPromotionByParem(promotion, pageBounds);
	}

	@Override
	public PageList<Promotion> selectPromotionByEntity(Promotion promotion, PageBounds pageBounds) {
		return promotionMapper.selectPromotionByEntity(promotion, pageBounds);
	}

	@Override
	public Promotion selectPromotionById(Promotion promotion) {
		return promotionMapper.selectPromotionById(promotion);
	}

	@Override
	public Integer insetPromotion(Promotion promotion) {
		return promotionMapper.insetPromotion(promotion);
	}

	@Override
	public Integer deletePromotion(Promotion promotion) {
		return promotionMapper.deletePromotion(promotion);
	}

	@Override
	public Integer updatePromotionById(Promotion promotion) {
		return promotionMapper.updatePromotionById(promotion);
	}

	@Override
	public Integer insetBatchPromotion(List<Promotion> promotionList) {
		return promotionMapper.batchInsert(promotionList);
	}

	@Override
	public Integer deletePromById(Promotion promotion) {
		return promotionMapper.deletePromById(promotion);
	}

}
