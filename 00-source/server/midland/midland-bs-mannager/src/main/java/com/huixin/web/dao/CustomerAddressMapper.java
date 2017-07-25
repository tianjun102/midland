package com.huixin.web.dao;

import com.huixin.web.model.CustomerAddress;
import com.huixin.web.model.CustomerAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerAddressMapper {
    int countByExample(CustomerAddressExample example);

    int deleteByExample(CustomerAddressExample example);

    int deleteByPrimaryKey(Integer addressId);

    int insert(CustomerAddress record);

    int insertSelective(CustomerAddress record);

    List<CustomerAddress> selectByExample(CustomerAddressExample example);

    CustomerAddress selectByPrimaryKey(Integer addressId);

    int updateByExampleSelective(@Param("record") CustomerAddress record, @Param("example") CustomerAddressExample example);

    int updateByExample(@Param("record") CustomerAddress record, @Param("example") CustomerAddressExample example);

    int updateByPrimaryKeySelective(CustomerAddress record);

    int updateByPrimaryKey(CustomerAddress record);
}