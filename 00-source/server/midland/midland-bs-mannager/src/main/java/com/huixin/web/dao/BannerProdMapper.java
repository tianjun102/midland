package com.huixin.web.dao;

import com.huixin.web.model.BannerProd;
import com.huixin.web.model.BannerProdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BannerProdMapper {
    int countByExample(BannerProdExample example);

    int deleteByExample(BannerProdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BannerProd record);

    int insertSelective(BannerProd record);

    List<BannerProd> selectByExample(BannerProdExample example);

    BannerProd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BannerProd record, @Param("example") BannerProdExample example);

    int updateByExample(@Param("record") BannerProd record, @Param("example") BannerProdExample example);

    int updateByPrimaryKeySelective(BannerProd record);

    int updateByPrimaryKey(BannerProd record);
    
    int batchInsert (List<BannerProd> list); 
    
    int deletebybannerId(Integer bannerId);
}