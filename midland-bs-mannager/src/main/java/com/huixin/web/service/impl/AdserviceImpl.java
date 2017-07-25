package com.huixin.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.dao.AdMapper;
import com.huixin.web.dao.AdProdMapper;
import com.huixin.web.dao.ProductMapper;
import com.huixin.web.model.Ad;
import com.huixin.web.model.AdProd;
import com.huixin.web.model.AdProdExample;
import com.huixin.web.model.Banner;
import com.huixin.web.model.BannerProd;
import com.huixin.web.model.BannerProdExample;
import com.huixin.web.service.AdService;
@Service
public class AdserviceImpl implements AdService {
	@Autowired
	private AdMapper adMapper;
	@Autowired
	private AdProdMapper adProdMapper;
	@Autowired
	private ProductMapper productMapper;
 
	@Override
	public PageList<Ad> selectAdList(Ad ad ,PageBounds pageBounds) {
		return adMapper.selectAdByParem(ad,pageBounds);
	}

	@Override
	public Ad selectAd(Ad ad) {
		return adMapper.selectAdById(ad);
	}

	@Override
	public Integer updateAd(Ad ad) {
		return adMapper.updateAdById(ad);
	}

	@Override
	public Integer insertAd(Ad ad) {
		return adMapper.insetAd(ad);
	}

	@Override
	public Integer deleteAd(Ad ad) {
		return adMapper.deleteAd(ad);
	}
	@Override
	public Integer deleteAdById(Ad ad){
		return adMapper.deleteAdById(ad);
	}

	@Override
	public Integer insertAdAndProd(Ad ad, List<AdProd> AdProdList, String isAll, String catId) {
		//先添加主表内容
		Integer num =0;
		num = this.insertAd(ad);
		//再添加副表内容
		List<AdProd> adProdList = new ArrayList<>();
		if(isAll!=null&&isAll.equals("1")){
			AdProd newAdProd  = new AdProd ();
			newAdProd.setAdId(ad.getAdId());
			newAdProd.setCatId(Integer.valueOf(catId));
			newAdProd.setIsAll(Integer.valueOf(isAll));
			adProdList.add(newAdProd);
			num = adProdMapper.batchInsert(adProdList);
		}
		if(AdProdList!=null&&AdProdList.size()>0){
		for (AdProd adProd : AdProdList) {
			if(adProd.getProdId()!=null){
				adProd.setAdId(ad.getAdId());
				adProdList.add(adProd);
			}
		}
		num = adProdMapper.batchInsert(adProdList);
		}
		return num;
	}

	@Override
	public List<AdProd> selectAdProd(Ad ad) {
		AdProdExample example = new AdProdExample();
		example.createCriteria().andAdIdEqualTo(ad.getAdId());
		return adProdMapper.selectByExample(example);
	}
	
	@Override
	public List queryProListForAdList(List<AdProd> list) {
		return productMapper.queryProListForAdList(list);
	}

	@Override
	public Integer deleteAdprod(Integer adId) {
		return adProdMapper.deleteByAdId(adId);
	}


}
