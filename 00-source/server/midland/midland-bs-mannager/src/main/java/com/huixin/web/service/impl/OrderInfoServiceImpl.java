package com.huixin.web.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.util.DateUtils;
import com.huixin.core.util.OrderInfoUtils;
import com.huixin.web.dao.NoticeMapper;
import com.huixin.web.dao.OrderInfoMapper;
import com.huixin.web.dao.ProductMapper;
import com.huixin.web.dao.StockMapper;
import com.huixin.web.dao.UserMapper;
import com.huixin.web.model.NoticeWithBLOBs;
import com.huixin.web.model.OrderInfo;
import com.huixin.web.model.OrderItem;
import com.huixin.web.model.OrderLog;
import com.huixin.web.model.OrderRemark;
import com.huixin.web.model.Product;
import com.huixin.web.model.Shipping;
import com.huixin.web.model.Stock;
import com.huixin.web.model.User;
import com.huixin.web.service.OrderInfoService;

/**
 *
 * @author  jzg
 * @since 
 */
@Service
public class OrderInfoServiceImpl  implements OrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    
    @Resource
    private UserMapper userMapper;
    
    @Resource
    private NoticeMapper noticeMapper;
    
	@Resource
	private StockMapper stockMapper;
	
	@Resource
	private ProductMapper productMapper;
    
    
	@Override
	public Integer inputOrderInfoObj(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		 
		int result = 0 ;
		List<OrderItem> orderItems = orderInfo.getOrderItems();
		try {
			orderInfoMapper.addOrderInfoObj(orderInfo);
			if(orderItems!=null){
				for(int i = 0;i<orderItems.size();i++){
					OrderItem orderItem = (OrderItem)orderItems.get(i);
					orderItem.setOrderId(orderInfo.getId());
					orderInfoMapper.addOrderItemObj(orderItem);
				}
			}
			OrderLog log = new OrderLog();
			log.setOrderId(Long.valueOf(orderInfo.getId()));
			log.setOrderSn(orderInfo.getOrderSn());
			log.setOperateTime(DateUtils.nowDateToStringYYMMDDHHmmss());
			log.setOperateUserCode(orderInfo.getCustId().toString());
			log.setOperateUserName(orderInfo.getCustName());
			log.setOperateInfo("创建订单");
			orderInfoMapper.addLogObj(log);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Integer modifyOrderInfoObj(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		int result = 0 ;
		try {
			orderInfoMapper.updateOrderInfoObj(orderInfo);
			OrderLog log = new OrderLog();
			log.setOrderId(Long.valueOf(orderInfo.getId()));
			log.setOrderSn(orderInfo.getOrderSn());
			log.setOperateTime(DateUtils.nowDateToStringYYMMDDHHmmss());
			log.setOperateUserCode(orderInfo.getCustId().toString());
			log.setOperateUserName(orderInfo.getCustName());
			log.setOperateInfo("修改订单");
			orderInfoMapper.addLogObj(log);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Integer removeOrderInfoObj(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return orderInfoMapper.deleteOrderInfoObj(orderInfo);
	}

	@Override
	public PageList<OrderInfo> searchOrderInfoList(OrderInfo orderInfo,PageBounds pageBounds) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotEmpty(orderInfo.getCreateStartTime())){
			orderInfo.setCreateStartTime(orderInfo.getCreateStartTime()+" 00:00:00");
		}
		if(StringUtils.isNotEmpty(orderInfo.getCreateEndTime())){
			orderInfo.setCreateEndTime(orderInfo.getCreateEndTime()+" 23:59:59");
		}
		if(StringUtils.isNotEmpty(orderInfo.getPayStartTime())){
			orderInfo.setPayStartTime(orderInfo.getPayStartTime()+" 00:00:00");
		}
		if(StringUtils.isNotEmpty(orderInfo.getPayEndTime())){
			orderInfo.setPayEndTime(orderInfo.getPayEndTime()+" 23:59:59");
		}
		return orderInfoMapper.queryOrderInfoList(orderInfo,pageBounds);
	}

	@Override
	public OrderInfo searchOrderInfoObj(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return orderInfoMapper.queryOrderInfoObj(orderInfo);
	}

	@Override
	public List<OrderItem> searchOrderItemList(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return  orderInfoMapper.queryOrderItemList(orderInfo);
	}

	@Override
	public List<OrderLog> searchOrderLogList(Integer orderId) {
		// TODO Auto-generated method stub
		return orderInfoMapper.queryLogList(orderId);
	}

	@Override
	public List<OrderRemark> searchOrderRemarkList(Integer orderId) {
		// TODO Auto-generated method stub
		return orderInfoMapper.queryRemarkList(orderId);
	}

	@Override
	public Integer inputOrderRemarkObj(OrderRemark orderRemark) {
		// TODO Auto-generated method stub
		return orderInfoMapper.addRemarkObj(orderRemark);
	}

	@Override
	public Integer changeOrderStatus(Map<String, Object> map) {
		int result = 0 ;
		try {
			String custId = map.get("custId").toString();
			String custName = map.get("custName").toString();
			String idStr = map.get("idStr").toString();
			String type = map.get("type").toString();
			String orderStatusStr  = map.get("orderStatusStr").toString();
			String [] idArr = {} ;
			String [] statusArr= {} ;
			Integer status = 1 ;
			if(StringUtils.isNotEmpty(idStr)){
				idArr = idStr.split(";");
			}
			if(StringUtils.isNotEmpty(orderStatusStr)){
				statusArr = orderStatusStr.split(";");
			}
			for (int i = 0; i < idArr.length; i++) {
				String doStr = "";
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setId(Integer.parseInt(idArr[i]));
				
				if(OrderInfoUtils.ORDER_STATUS_NOPAY.equals(Integer.parseInt(statusArr[i])) && "1".equals(type)){//确定按钮 
					orderInfo.setOrderStatus(OrderInfoUtils.ORDER_STATUS_NOLP);
					doStr = "确定订单";
				}else if(OrderInfoUtils.ORDER_STATUS_NOLP.equals(Integer.parseInt(statusArr[i])) && "2".equals(type)){//反确定按钮
					orderInfo.setOrderStatus(OrderInfoUtils.ORDER_STATUS_NOPAY);
					doStr = "反确定订单";
				}else if(OrderInfoUtils.ORDER_STATUS_NOPAY.equals(Integer.parseInt(statusArr[i])) && "3".equals(type)){//财审
					orderInfo.setOrderStatus(OrderInfoUtils.ORDER_STATUS_NOLP);
					orderInfo.setPayStatus(OrderInfoUtils.PAY_STATUS_FINISH);
					orderInfo.setPayTime(DateUtils.nowDateToStringYYMMDDHHmmss());
					doStr = "财审订单";
				}else if(OrderInfoUtils.ORDER_STATUS_NOLP.equals(Integer.parseInt(statusArr[i])) && "4".equals(type)){//打印
					orderInfo.setIsPrintOrder(1);
					doStr = "打印订单";
				}else if(OrderInfoUtils.ORDER_STATUS_NOLP.equals(Integer.parseInt(statusArr[i])) && "5".equals(type)){//发货
					orderInfo.setOrderStatus(OrderInfoUtils.ORDER_STATUS_LP);
					doStr = "订单发货";
					OrderInfo order = orderInfoMapper.queryOrderInfoObj(orderInfo);
					Integer flag  = orderInfoMapper.updateOrderInfoObj(orderInfo);
					if(flag>0){
						changeStock(orderInfo,"unlock");
						User user = userMapper.queryUserForCustCode(order.getCustCode());
						NoticeWithBLOBs notice  = new NoticeWithBLOBs(); 
						notice.setTitle("发货通知");
						notice.setContent("您的订单【"+order.getOrderSn()+"】已发货!配送方式为:"+order.getShippingName()+" 配送单号为:"+order.getShippingSn());
						notice.setMsgType(3);
						notice.setCreatTime(new Date());
						notice.setUserIds(user.getId().toString());
						notice.setIsViewed(0);
						noticeMapper.insertSelective(notice);
					}
					status = 0;
				}
				
				if(status>0){
					orderInfoMapper.updateOrderInfoObj(orderInfo);
				}
				
				OrderLog log = new OrderLog();
				log.setOrderId(Long.valueOf(orderInfo.getId()));
				log.setOperateTime(DateUtils.nowDateToStringYYMMDDHHmmss());
				log.setOperateUserCode(custId);
				log.setOperateUserName(custName);
				log.setOperateInfo(doStr);
				orderInfoMapper.addLogObj(log);
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Integer forAudit(Map<String, Object> map) {
		int result = 0;
		try{
			OrderInfo  orderInfo = new OrderInfo();
			orderInfo.setId(Integer.parseInt(map.get("orderId").toString()));
			orderInfo.setPayStatus(OrderInfoUtils.PAY_STATUS_FINISH);
			OrderInfo order = orderInfoMapper.queryOrderInfoObj(orderInfo);
			orderInfo.setMoneyPaid(order.getOrderAmount());
			String type = map.get("type").toString();
			String payType = "TRANSFER";
			if("2".equals(type)){
				payType = "CREDIT";
			}
			else if("3".equals(type)){
				payType = "WALLET";
			}
			orderInfo.setPayCode(payType);
			orderInfo.setPayTime(DateUtils.nowDateToStringYYMMDDHHmmss());
			orderInfoMapper.updateOrderInfoObj(orderInfo);
			changeStock(orderInfo,"lock");
			OrderLog log = new OrderLog();
			log.setOrderId(Long.valueOf(orderInfo.getId()));
			log.setOperateTime(DateUtils.nowDateToStringYYMMDDHHmmss());
			log.setOperateUserCode(map.get("userId").toString());
			log.setOperateUserName(map.get("userName").toString());
			log.setOperateInfo("财审订单");
			orderInfoMapper.addLogObj(log);
			result = 1 ;
		}catch (Exception e) {
			result = 0;
			e.printStackTrace();
		}
		
		return result ;
	}


	//修改库存
	 public void changeStock(OrderInfo orderInfo,String type){
			try {
				List<OrderItem>	orderItems =  orderInfoMapper.queryOrderItemList(orderInfo);
				if(orderItems!=null && orderItems.size()>0){
					for (int i = 0; i < orderItems.size(); i++) {
						Stock stock = stockMapper.queryStockByPid(orderItems.get(i).getProdId());
						if(stock == null){
							continue;
						}
						if("lock".equals(type)){  //锁定库存
							Product product = new Product();
							product.setProductId(orderItems.get(i).getProdId());
							product  = 	productMapper.queryProductObj(product);
							if(product.getSaleCount()!=null){
								product.setSaleCount(product.getSaleCount()+orderItems.get(i).getQuantity());
							}else{
								product.setSaleCount(orderItems.get(i).getQuantity());
							}
							productMapper.updateProductObj(product);
							stock.setSl1(stock.getSl1()+orderItems.get(i).getQuantity());
							stock.setSl2(stock.getSl2()-orderItems.get(i).getQuantity());
						}else{ //释放库存
							stock.setSl1(stock.getSl1()-orderItems.get(i).getQuantity());
							stock.setSl(stock.getSl()-orderItems.get(i).getQuantity());
						}
						stockMapper.updateStockObj(stock);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	
	@Override
	public Integer changeOrderStatus() {
		// TODO Auto-generated method stub
		return orderInfoMapper.changeOrderStatus();
	}

	@Override
	public Integer changeOrderComplete() {
		// TODO Auto-generated method stub
		return orderInfoMapper.changeOrderComplete();
	}

	@Override
	public List<Shipping> searchShippingList() {
		// TODO Auto-generated method stub
		return orderInfoMapper.queryShippingList();
	} 
	
	
	
	
}
