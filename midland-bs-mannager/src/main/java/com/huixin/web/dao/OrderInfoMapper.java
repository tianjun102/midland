package com.huixin.web.dao;
import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.OrderInfo;
import com.huixin.web.model.OrderItem;
import com.huixin.web.model.OrderLog;
import com.huixin.web.model.OrderRemark;
import com.huixin.web.model.Settlement;
import com.huixin.web.model.Shipping;
public interface OrderInfoMapper {
	
	/**
	 * 新增订单
	 * @param orderInfo 订单参数
	 * @return 数据库受影响行数
	 */
	Integer addOrderInfoObj(OrderInfo orderInfo);
	
	
	/**
	 * 修改订单
	 * @param orderInfo 订单参数
	 * @return 数据库受影响行数
	 */
	Integer updateOrderInfoObj(OrderInfo orderInfo);
	
	
	/**
	 * 删除订单
	 * @param orderInfo 订单参数
	 * @return 数据库受影响行数
	 */
	Integer deleteOrderInfoObj(OrderInfo orderInfo);
	
	
	/**
	 * 查询订单集合
	 * @param orderInfo 订单参数
	 * @return 查询结果集合
	 */
	PageList<OrderInfo> queryOrderInfoList(OrderInfo orderInfo,PageBounds pageBounds);
	

	/**
	 * 查询订单明细
	 * @param orderInfo 订单参数
	 * @return 查询结果集合
	 */
	OrderInfo queryOrderInfoObj(OrderInfo orderInfo);
	
	/**
	 * 新增订单明细
	 * @param orderItem 订单明细
	 * @return 数据库受影响行数
	 */
	Integer addOrderItemObj(OrderItem orderItem);
	
	

	/**
	 * 查询订单明细
	 * @param orderInfo 订单参数
	 * @return 查询结果集合
	 */
	List<OrderItem> queryOrderItemList(OrderInfo orderInfo);
	
	
	/**
	 * 新增订单日志
	 * @param orderLog
	 * @return
	 */
	Integer addLogObj(OrderLog orderLog);
	
	/**
	 * 查询订单日志
	 * @param orderId
	 * @return
	 */
	List<OrderLog> queryLogList(Integer orderId);
	
	/**
	 * 新增订单备注
	 * @param orderRemark
	 * @return
	 */
	Integer addRemarkObj(OrderRemark orderRemark);
	
	/**
	 * 查询订单备注
	 * @param orderId
	 * @return
	 */
	List<OrderRemark> queryRemarkList(Integer orderId);
	
	
	public List<OrderInfo> selectOrderInfoByEntity(OrderInfo orderInfo);
	public Double selectOrderAmountCount(OrderInfo orderInfo);
	public Integer updatesettStatus(Map<String, Object> map);
	public List<OrderInfo> selectorderDetails(Settlement settlement);
	
	/**
	 * 定时任务  支付超时  自动关闭
	 * @return
	 */
	Integer changeOrderStatus();
	
	
	/**
	 * 定时任务  收货超时自动收货 
	 * @return
	 */
	Integer changeOrderComplete();
	
	
	/**
	 * 查询所有的配送方式
	 * @return
	 */
	List<Shipping>  queryShippingList();
}
