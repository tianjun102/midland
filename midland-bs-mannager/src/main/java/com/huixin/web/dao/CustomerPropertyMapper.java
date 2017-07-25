package com.huixin.web.dao;

import com.huixin.web.model.CustomerProperty;
import com.huixin.web.model.CustomerPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerPropertyMapper {
    int countByExample(CustomerPropertyExample example);

    int deleteByExample(CustomerPropertyExample example);

    int deleteByPrimaryKey(Integer propId);

    int insert(CustomerProperty record);

    int insertSelective(CustomerProperty record);

    List<CustomerProperty> selectByExample(CustomerPropertyExample example);

    CustomerProperty selectByPrimaryKey(Integer propId);

    int updateByExampleSelective(@Param("record") CustomerProperty record, @Param("example") CustomerPropertyExample example);

    int updateByExample(@Param("record") CustomerProperty record, @Param("example") CustomerPropertyExample example);

    int updateByPrimaryKeySelective(CustomerProperty record);

    int updateByPrimaryKey(CustomerProperty record);

    /**
     * 批量新增
     * @param list
     * @return
     */
	int insertBatch(List<CustomerProperty> list);
}