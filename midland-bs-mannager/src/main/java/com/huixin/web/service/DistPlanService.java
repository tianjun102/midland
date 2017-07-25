package com.huixin.web.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.DistPlan;

/**
 * 
 * @author  jzg
 * 
 **/
public interface DistPlanService {
	
	
		/**  --------------------------------- 分销方案  -------------------------------**/

		/**
		 * 新增分销方案
		 * @param distPlan 分销方案参数
		 * @return 数据库受影响行数
		 */
		int inputDistPlanObj(DistPlan distPlan);
		
		
		/**
		 * 修改分销方案
		 * @param distPlan 分销方案参数
		 * @return 数据库受影响行数
		 */
		int modifyDistPlanObj(DistPlan distPlan);
		
		
		/**
		 * 删除分销方案
		 * @param distPlan 分销方案参数
		 * @return 数据库受影响行数
		 */
		int removeDistPlanObj(DistPlan distPlan);
		
		
		/**
		 * 查询分销方案集合
		 * @param distPlan 分销方案参数
		 * @param pageBounds 分页参数
		 * @return 查询结果集合
		 */
		PageList<DistPlan> searchDistPlanList(DistPlan distPlan,PageBounds pageBounds);
		

		/**
		 * 查询分销方案明细
		 * @param distPlan 分销方案参数
		 * @return 查询结果集合
		 */
		DistPlan searchDistPlanObj(DistPlan distPlan);
		
		
		
		/**
		 * 查询分类商品集合
		 * @return 查询结果集合
		 */
		List<Map<String, Object>> searchCatProForList();
	
		/**
		 * 查询区域客户集合
		 * @return 查询结果集合
		 */
		List<Map<String, Object>> searchAreaCustForList();
		
}
