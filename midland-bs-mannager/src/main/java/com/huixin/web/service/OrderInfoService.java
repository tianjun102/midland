package com.huixin.web.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.OrderInfo;
import com.huixin.web.model.OrderItem;
import com.huixin.web.model.OrderLog;
import com.huixin.web.model.OrderRemark;
import com.huixin.web.model.Shipping;

/**
 * 
 * @author  jzg
 * 
 **/
public interface OrderInfoService {
	
	

		/**
		 * 新增订单
		 * @param orderInfo 订单参数
		 * @return 数据库受影响行数
		 */
		Integer inputOrderInfoObj(OrderInfo orderInfo);
		
		
		/**
		 * 修改订单
		 * @param orderInfo 订单参数
		 * @return 数据库受影响行数
		 */
		Integer modifyOrderInfoObj(OrderInfo orderInfo);
		
		
		/**
		 * 删除订单
		 * @param orderInfo 订单参数
		 * @return 数据库受影响行数
		 */
		Integer removeOrderInfoObj(OrderInfo orderInfo);
		
		
		/**
		 * 查询订单集合
		 * @param orderInfo 订单参数
		 * @param pageBounds 分页参数
		 * @return 查询结果集合
		 */
		PageList<OrderInfo> searchOrderInfoList(OrderInfo orderInfo,PageBounds pageBounds);
		

		/**
		 * 查询订单明细
		 * @param orderInfo 订单参数
		 * @return 查询结果集合
		 */
		OrderInfo searchOrderInfoObj(OrderInfo orderInfo);
		
		
		/**
		 * 查询订单明细
		 * @param orderInfo 订单参数
		 * @return 查询结果集合
		 */
		List<OrderItem> searchOrderItemList(OrderInfo orderInfo);
		
		
		/**
		 * 查询订单日志
		 * @param orderId 订单id
		 * @return 查询结果集合
		 */
		List<OrderLog> searchOrderLogList(Integer orderId);
		
		
		/**
		 * 查询订单备注
		 * @param orderId 订单id
		 * @return 查询结果集合
		 */
		List<OrderRemark> searchOrderRemarkList(Integer orderId);
		
		/**
		 * 新增订单备注
		 * @param orderRemark
		 * @return
		 */
		Integer inputOrderRemarkObj(OrderRemark orderRemark);
		
		/**
		 * 修改订单状态
		 * @return 数据库受影响行数
		 */
		Integer changeOrderStatus(Map<String, Object> map);
		
		/**
		 * 修改订单状态 - 财审
		 * @return 数据库受影响行数
		 */
		Integer forAudit(Map<String, Object> map);
		
		
		/**
		 * 定时任务 超时支付 关闭订单
		 * @return
		 */
		Integer changeOrderStatus();
		
		/**
		 * 定时任务 收货超时 自动完成
		 * @return
		 */
		Integer changeOrderComplete();
		
		
		/**
		 * 查询所有的配送方式
		 * @return
		 */
		List<Shipping>  searchShippingList();
		
}
