package com.huixin.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.dao.PromotionPropMapper;
import com.huixin.web.model.Promotion;
import com.huixin.web.model.PromotionGift;
import com.huixin.web.model.PromotionProp;
import com.huixin.web.service.PromotionPropService;
@Service
public class PromotionPropServiceImpl implements PromotionPropService {
	@Autowired private PromotionPropMapper promotionPropMapper;



	@Override
	public Integer insetPromotionProp(PromotionProp promotionGif) {
		return promotionPropMapper.insetPromotionProp(promotionGif);
	}

	@Override
	public Integer deletePromotionProp(PromotionProp promotionGif) {
		return promotionPropMapper.deletePromotionProp(promotionGif);
	}

	@Override
	public Integer updatePromotionPropById(PromotionProp promotionGif) {
		return promotionPropMapper.updatePromotionPropById(promotionGif);
	}

	@Override
	public Integer insetBatchPromotionProp(List<PromotionProp> promotionGif) {
		return promotionPropMapper.batchInsert(promotionGif);
	}

	@Override
	public List<PromotionProp> selectPromotionPropByParem(PromotionProp promotionProp) {
		return promotionPropMapper.selectPromotionPropByParem(promotionProp);
	}

	@Override
	public PageList<PromotionProp> selectPromotionPropByEntity(PromotionProp promotionProp, PageBounds pageBounds) {
		return promotionPropMapper.selectPromotionPropByEntity(promotionProp, pageBounds);
	}

	@Override
	public PromotionProp selectPromotionPropById(PromotionProp promotionProp) {
		return promotionPropMapper.selectPromotionPropById(promotionProp);
	}

	@Override
	public List<PromotionProp> selectPromotionPropByPromId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return promotionPropMapper.selectPromotionPropByPromId(map);
	}

	@Override
	public Integer saveOrUpdatePromotionProp(List<PromotionProp> promotionPropList,Promotion promotion) {
		if(promotionPropList!=null&&promotionPropList.size()>0){
		List<Integer> idList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("prom_id", promotion.getId());
		for (PromotionProp promotionProp : promotionPropList) {
			if(promotionProp.getId()==null){
				continue;
			}
			idList.add(promotionProp.getId());
		}
		map.put("idList", idList);
		if(idList!=null&&idList.size()>0){
		idList= promotionPropMapper.selectidListPropById(map);
		}
		List<PromotionProp> PromotionPropupdate = new ArrayList<PromotionProp>();
		List<PromotionProp> PromotionPropinsert = new ArrayList<PromotionProp>();
		if(idList!=null&&idList.size()>0){
		promotionPropMapper.batchDeletePromotionProp(idList);
		}
		for (PromotionProp promotionProp : promotionPropList) {
			if(promotionProp.getId()!=null){
				PromotionPropupdate.add(promotionProp);
			}else{
				PromotionPropinsert.add(promotionProp);
			}
		}
		if(PromotionPropinsert!=null&&PromotionPropinsert.size()>0){
			promotionPropMapper.batchInsert(PromotionPropinsert);
		}
		if(PromotionPropupdate!=null&&PromotionPropupdate.size()>0){
			
			promotionPropMapper.batchUpdate(PromotionPropupdate);
		}
		}
		
		return null;
	}
	@Override
	public Integer delectPromotionPropAndInsert(List<PromotionProp> promotionPropList,Promotion promotion){
		PromotionProp promotionProp = new PromotionProp();
		promotionProp.setProm_id(promotion.getId());
		Integer delectNum = 0;
		Integer insertNum = 0;
		//先清空
			delectNum = this.deletePromotionProp(promotionProp);
		//再批量添加
		if(promotionPropList!=null&&promotionPropList.size()>0){
		    insertNum =  promotionPropMapper.batchInsert(promotionPropList);
		}
		
		return insertNum;
		
	}


}
