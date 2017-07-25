package com.huixin.web.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Banner;
import com.huixin.web.model.BannerProd;
public interface BannerService {
	public PageList<Banner> selectBannerList(Banner banner,PageBounds pageBounds);
	public Banner selectBanner(Integer id);
	public Integer deleteBanner(Integer id);
	Integer insertBannerAndProd(Banner banner, List<BannerProd> BannerProdList,String isAll,String catId);
	public List<BannerProd> selectBannerProd(Banner banner);
	List queryProListForList(List<BannerProd> list);
	Integer deleteBannerprd(Integer id);

}
