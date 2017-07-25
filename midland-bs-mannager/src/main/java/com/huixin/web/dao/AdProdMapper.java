package com.huixin.web.dao;

import com.huixin.web.model.AdProd;
import com.huixin.web.model.AdProdExample;
import com.huixin.web.model.BannerProd;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdProdMapper {
    int countByExample(AdProdExample example);

    int deleteByExample(AdProdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdProd record);

    int insertSelective(AdProd record);

    List<AdProd> selectByExample(AdProdExample example);

    AdProd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdProd record, @Param("example") AdProdExample example);

    int updateByExample(@Param("record") AdProd record, @Param("example") AdProdExample example);

    int updateByPrimaryKeySelective(AdProd record);

    int updateByPrimaryKey(AdProd record);
    
    int batchInsert (List<AdProd> list); 
    
    int deleteByAdId(Integer adId);
}