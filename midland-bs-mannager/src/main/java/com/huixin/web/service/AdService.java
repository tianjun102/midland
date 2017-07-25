package com.huixin.web.service;

import java.util.List;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Ad;
import com.huixin.web.model.AdProd;
public interface AdService {
	
	public PageList<Ad> selectAdList(Ad ad ,PageBounds pageBounds);
	
	public Ad selectAd(Ad Ad);
	
	public Integer updateAd(Ad ad);
	
	public Integer insertAd(Ad ad);
	
	public Integer deleteAd(Ad ad);
	
	Integer insertAdAndProd(Ad ad, List<AdProd> AdProdList, String isAll, String catId);

	List<AdProd> selectAdProd(Ad ad);

	List queryProListForAdList(List<AdProd> list);
	
	Integer deleteAdprod(Integer adId);

	Integer deleteAdById(Ad ad);
	
	
	

	
	
	
}
