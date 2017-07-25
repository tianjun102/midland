package com.huixin.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.dao.PromotionGiftMapper;
import com.huixin.web.dao.PromotionMapper;
import com.huixin.web.model.Promotion;
import com.huixin.web.model.PromotionGift;
import com.huixin.web.model.PromotionProp;
import com.huixin.web.service.PromotionGiftService;
@Service
public class PromotionGiftServiceImpl implements PromotionGiftService {
	@Autowired private PromotionGiftMapper promotionGiftMapper;
	//@Autowired private PromotionMapper promotionMapper;

	@Override
	public List<PromotionGift> selectPromotionGiftByParem(PromotionGift promotionGif) {
		return promotionGiftMapper.selectPromotionGiftByParem(promotionGif);
	}

	@Override
	public PageList<PromotionGift> selectPromotionGiftByEntity(PromotionGift promotionGif, PageBounds pageBounds) {
		return promotionGiftMapper.selectPromotionGiftByEntity(promotionGif, pageBounds);
	}

	@Override
	public PromotionGift selectPromotionGiftById(PromotionGift promotionGif) {
		return promotionGiftMapper.selectPromotionGiftById(promotionGif);
	}

	@Override
	public Integer insetPromotionGift(PromotionGift promotionGif) {
		return promotionGiftMapper.insetPromotionGift(promotionGif);
	}

	@Override
	public Integer deletePromotionGift(PromotionGift promotionGif) {
		return promotionGiftMapper.deletePromotionGift(promotionGif);
	}

	@Override
	public Integer updatePromotionGiftById(PromotionGift promotionGif) {
		return promotionGiftMapper.updatePromotionGiftById(promotionGif);
	}

	@Override
	public Integer insetBatchPromotionGift(List<PromotionGift> promotionGif) {
		return promotionGiftMapper.batchInsert(promotionGif);
	}

	@Override
	public List<PromotionGift> selectPromotionGiftByPromId(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return promotionGiftMapper.selectPromotionGiftByPromId(map);
	}

	@Override
	public Integer saveOrUpdatePromotionGift(List<PromotionGift> promotionGiftList,Promotion promotion) {
		if(promotionGiftList!=null&&promotionGiftList.size()>0){
		List<Integer> idList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("prom_id", promotion.getId());
		for (PromotionGift promotionGift : promotionGiftList) {
			if(promotionGift.getId()==null){
				continue;
			}
			idList.add(promotionGift.getId());
		}
		map.put("idList", idList);
		if(idList!=null&&idList.size()>0){
			idList= promotionGiftMapper.selectidListGiftById(map);
		}
		if(idList!=null&&idList.size()>0){
		promotionGiftMapper.batchDeletePromotionGift(idList);
		}
		List<PromotionGift> PromotionGiftupdate = new ArrayList<PromotionGift>();
		List<PromotionGift> PromotionGiftinsert = new ArrayList<PromotionGift>();
		for (PromotionGift promotionGift : promotionGiftList) {
			if(promotionGift.getId()!=null){
				PromotionGiftupdate.add(promotionGift);
			}else{
				PromotionGiftinsert.add(promotionGift);
			}
		}
		if(PromotionGiftupdate!=null&&PromotionGiftupdate.size()>0){
			promotionGiftMapper.batchUpdate(PromotionGiftupdate);
		}
		if(PromotionGiftinsert!=null&&PromotionGiftinsert.size()>0){
			promotionGiftMapper.batchInsert(PromotionGiftinsert);
		}
		
		}
		
		return null;
	}
	@Override
	public Integer delectPromotionGiftAndInsert(List<PromotionGift> promotionGiftList,Promotion promotion){
		PromotionGift promotionGif = new PromotionGift();
		promotionGif.setProm_id(promotion.getId());
		Integer delectNum = 0;
		Integer insertNum = 0;
		//先清空
			delectNum = this.deletePromotionGift(promotionGif);
		//再批量添加
		if(promotionGiftList!=null&&promotionGiftList.size()>0){
		    insertNum =  promotionGiftMapper.batchInsert(promotionGiftList);
		}
		
		return insertNum;
		
	}

}
