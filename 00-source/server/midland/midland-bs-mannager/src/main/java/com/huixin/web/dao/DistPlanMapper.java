package com.huixin.web.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.DistPlan;
import com.huixin.web.model.DistPlanCustomer;
import com.huixin.web.model.DistPlanProduct;

public interface DistPlanMapper {

	/**  --------------------------------- 分销方案  -------------------------------**/

	/**
	 * 新增分销方案
	 * @param distPlan 分销方案参数
	 * @return 数据库受影响行数
	 */
	int addDistPlanObj(DistPlan distPlan);
	
	
	/**
	 * 修改分销方案
	 * @param distPlan 分销方案参数
	 * @return 数据库受影响行数
	 */
	int updateDistPlanObj(DistPlan distPlan);
	
	
	/**
	 * 删除分销方案
	 * @param distPlan 分销方案参数
	 * @return 数据库受影响行数
	 */
	int deleteDistPlanObj(DistPlan distPlan);
	
	
	/**
	 * 查询分销方案集合
	 * @param distPlan 分销方案参数
	 * @return 查询结果集合
	 */
	PageList<DistPlan> queryDistPlanList(DistPlan distPlan,PageBounds pageBounds);
	

	/**
	 * 查询分销方案明细
	 * @param distPlan 分销方案参数
	 * @return 查询结果集合
	 */
	DistPlan queryDistPlanObj(DistPlan distPlan);
	
	
	/**
	 * 查询分类商品集合
	 * @return 查询结果集合
	 */
	List<Map<String, Object>> queryCatProForList();
	
	/**
	 * 查询区域客户集合
	 * @return 查询结果集合
	 */
	List<Map<String, Object>> queryAreaCustForList();
	
	
	
	/**
	 * 新增区域商品信息
	 * @param distPlanProduct 新增参数
	 * @return 返回受影响行数
	 */
	int addPlanProduct(DistPlanProduct distPlanProduct);
	
	/**
	 * 新增区域客户信息
	 * @param distPlanCustomer 新增参数
	 * @return 返回受影响行数
	 */
	int addPlanCustomer(DistPlanCustomer distPlanCustomer);
	
	
	/**
	 * 根据分销方案ID删除 
	 * @param dist_id 分校方案ID 
	 * @return
	 */
	int deletePlanCustomer(int dist_id);
	
	
	/**
	 * 根据分销方案ID删除 
	 * @param dist_id 分校方案ID 
	 * @return
	 */
	int deletePlanProduct(int dist_id);
	
	
	/**
	 * 根据分销方案ID查询
	 * @param dist_id 分销方案
	 * @return
	 */
	List  queryPlanCustomer(int dist_id);
	
	
	/**
	 * 根据分销方案ID查询
	 * @param dist_id 分销方案
	 * @return
	 */
	List  queryPlanProduct(int dist_id);
}