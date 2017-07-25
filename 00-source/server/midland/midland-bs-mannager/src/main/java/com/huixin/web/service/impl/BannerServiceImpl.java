package com.huixin.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.dao.BannerMapper;
import com.huixin.web.dao.BannerProdMapper;
import com.huixin.web.dao.ProductMapper;
import com.huixin.web.model.Banner;
import com.huixin.web.model.BannerExample;
import com.huixin.web.model.BannerProd;
import com.huixin.web.model.BannerProdExample;
import com.huixin.web.service.BannerService;
@Service
public class BannerServiceImpl implements BannerService {
	@Autowired private BannerMapper bannerMapper;
	@Autowired private BannerProdMapper bannerProdMapper;
	@Autowired private ProductMapper productMapper;
	@Override
	public PageList<Banner> selectBannerList(Banner banner, PageBounds pageBounds) {
		return bannerMapper.selectByParem(banner, pageBounds);
	}
	@Override
	public Integer insertBannerAndProd(Banner banner , List<BannerProd> BannerProdList,String isAll,String catId) {
		//先添加主表内容
		Integer num =0;
		num = bannerMapper.insertSelective(banner);
		//再添加副表内容
		List<BannerProd> bannerProdList = new ArrayList<>();
		if(isAll!=null&&isAll.equals("1")){
			BannerProd newBannerProdr = new BannerProd();
			newBannerProdr.setBannerId(banner.getId());
			newBannerProdr.setCatId(Integer.valueOf(catId));
			newBannerProdr.setIsAll(Integer.valueOf(isAll));
			bannerProdList.add(newBannerProdr);
			num = bannerProdMapper.batchInsert(bannerProdList);
		}
		if(BannerProdList!=null&&BannerProdList.size()>0){
		for (BannerProd bannerProd : BannerProdList) {
			if(bannerProd.getProdId()!=null){
				bannerProd.setBannerId(banner.getId());
				bannerProdList.add(bannerProd);
			}
		}
		num = bannerProdMapper.batchInsert(bannerProdList);
		}
		return num;
	}
	@Override
	public List<BannerProd> selectBannerProd(Banner banner) {
		BannerProdExample example = new BannerProdExample();
		example.createCriteria().andBannerIdEqualTo(banner.getId());
		return bannerProdMapper.selectByExample(example);
	}
	
	@Override
	public List queryProListForList(List<BannerProd> list) {
		return productMapper.queryProListForList(list);
	}
	@Override
	public Banner selectBanner(Integer id) {
		return bannerMapper.selectBanner(id);
	}
	@Override
	public Integer deleteBanner(Integer id) {
		return bannerMapper.deleteById(id);
	}
	@Override
	public Integer deleteBannerprd(Integer id) {
		return bannerProdMapper.deletebybannerId(id);
	}
	
	

}
