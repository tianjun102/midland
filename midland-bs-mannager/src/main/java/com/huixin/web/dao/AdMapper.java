package com.huixin.web.dao;

import java.util.List;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.generic.GenericDao;
import com.huixin.web.model.Ad;

public interface AdMapper extends GenericDao<Ad,Integer> {
	
	
	public PageList<Ad> selectAdByParem(Ad ad,PageBounds pageBounds);
	
	public Ad selectAdById(Ad ad);
	
	public int updateAdById(Ad ad);
	
	public int insetAd(Ad ad);
	
	public int deleteAd(Ad ad);
	
	public int deleteAdById(Ad ad);
	
	
	
	
	
	
	

}
