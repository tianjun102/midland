package com.huixin.web.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Area;
import com.huixin.web.model.Customer;
import com.huixin.web.model.CustomerAddress;
import com.huixin.web.model.CustomerProperty;
import com.huixin.web.model.Region;

/**
 * 客户管理 接口
 * @author Administrator
 *
 */
public interface CustService {
	/**
	 * 区域 分页列表查询
	 * @param area
	 * @param pageBounds
	 * @return
	 */
	PageList<Area> selectAreaByExampleAndPage(Area area, PageBounds pageBounds);
	
	/**
	 * 客户分页列表查询
	 * @param cust
	 * @param pageBounds
	 * @return
	 */
	PageList<Customer> selectCustByExampleAndPage(Customer cust, PageBounds pageBounds);
	
	/**
	 * 新增区域
	 * @param area
	 * @return
	 */
	int insertArea(Area area);
	
	/**
	 * 新增客户
	 * @param cust
	 * @param custPro 
	 * @param custAddr 
	 * @return
	 */
	int addCustomer(Customer cust, CustomerAddress custAddr);

	/**
	 * 更新区域
	 * @param area
	 * @return
	 */
	int updateArea(Area area);
	
	/**
	 * 更新客户
	 * @param cust
	 * @param custAddr
	 * @param custPro
	 * @return
	 */
	int updateCustomer(Customer cust, CustomerAddress custAddr);

	/**
	 * 查找区域对象
	 * @param areaId
	 * @return
	 */
	Area findAreaById(Integer areaId);

	/**
	 * 查找客户对象
	 * @param custId
	 * @return
	 */
	Customer findCustById(Integer custId);

	/**
	 * 查询所有的区域
	 * @return
	 */
	List<Area> queryAreas(Area area);
	
	/**
	 * 查询不同类型的属性值
	 * @param type
	 * @return
	 */
	List<CustomerProperty> queryCustomerPropertyByType(Integer type);

	/**
	 * 通过父级id查找地址区域
	 * @param regionId
	 * @return
	 */
	List<Region> selectRegionByParentId(Integer parentId);

	/**
	 * 查询客户地址
	 * @param custId
	 * @return
	 */
	List<CustomerAddress> findCustAddrByCustId(Integer custId);
	
	/**
	 * 查询客户list
	 * @param cust
	 * @return
	 */
	List<Customer> queryCustList(Customer cust);
	
	int deleteCustomer(Customer record);

	int checkAreaIsEmploy(Integer areaId);

	List<CustomerAddress> queryCustAddrByCustAddr(CustomerAddress custAddr);
}
