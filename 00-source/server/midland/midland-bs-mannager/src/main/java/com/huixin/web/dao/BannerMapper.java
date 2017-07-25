package com.huixin.web.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.generic.GenericDao;
import com.huixin.web.model.Banner;
import com.huixin.web.model.BannerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BannerMapper {
    int countByExample(BannerExample example);

    int deleteByExample(BannerExample example);

    int insert(Banner record);

    int insertSelective(Banner banner);

    List<Banner> selectByExample(BannerExample example);
    
    PageList<Banner> selectByParem(Banner record,PageBounds pageBounds);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);
    
    public Banner selectBanner(Integer id);

	Integer deleteById(Integer id);
}