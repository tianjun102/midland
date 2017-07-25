package com.huixin.web.controller;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.google.common.collect.Maps;
import com.huixin.web.model.OrderInfo;
import com.huixin.web.model.OrderItem;
import com.huixin.web.model.OrderRemark;
import com.huixin.web.model.Product;
import com.huixin.web.model.Region;
import com.huixin.web.model.Shipping;
import com.huixin.web.model.User;
import com.huixin.web.service.CustService;
import com.huixin.web.service.OrderInfoService;
import com.huixin.web.service.ProductService;
import com.huixin.web.service.impl.ExportService;
import com.huixin.web.service.impl.ShoppingCartService;

/**
 * 公共视图控制器
 * 
 * @author jzg
 * 
 **/

@Controller
@RequestMapping(value = "/order")
public class OrderInfoController {

	@Resource
	private OrderInfoService orderInfoService;

	@Resource
	private ProductService productService;

	@Resource
	private ShoppingCartService shoppingCartService;

	@Resource
	private CustService custService;

	private final String excelFileName = "exportOrder.xls";

	// 日志
	public final static Logger logger = LoggerFactory.getLogger(OrderInfoController.class);

	/****
	 * --------------------------------- 订单
	 * -------------------------------------
	 **/

	// 进入产品分页首页面
	@RequestMapping(value = "showOrderInfoIndex", method = { RequestMethod.GET, RequestMethod.POST })
	public String showOrderInfoIndex(Model model, HttpServletRequest request) {
		return "order/showOrderInfoIndex";
	}

	// 进入产品分页首页面
	@RequestMapping(value = "showOrderInfoList", method = { RequestMethod.GET, RequestMethod.POST })
	public String showOrderInfoList(OrderInfo searchObj, Model model, HttpServletRequest request) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		if (userInfo.getUserType() != 0) {
			searchObj.setShipperCode(userInfo.getUsername());
		}
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		if (pageSize == null || pageSize.equals("")) {
			pageSize = "10";
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));

		PageList<OrderInfo> orderInfoList = orderInfoService.searchOrderInfoList(searchObj, pageBounds);
		Paginator paginator = orderInfoList.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("orderInfoList", orderInfoList);
		return "order/showOrderInfoList";
	}

	@RequestMapping(value = "/detail", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResponseEntity<Map<String, Object>> detail(int orderId, Model model, HttpServletRequest request) {

		if (orderId == 0) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		OrderInfo order = new OrderInfo();
		order.setId(orderId);
		OrderInfo orderInfo = this.orderInfoService.searchOrderInfoObj(order);
		if (orderInfo == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		Map<String, Object> result = Maps.newHashMap();
		result.put("orderInfo", orderInfo);
		// result.put("orderLogs",
		// this.orderLogService.findListByOrderSn(orderInfo.getOrderSn()));
		// result.put("orderRemarks",
		// this.orderRemarkService.findListByOrderSn(orderInfo.getOrderSn()));
		result.put("orderItems", this.orderInfoService.searchOrderItemList(orderInfo));
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

	// 跳转修改订单页面
	@RequestMapping(value = "showModifyOrderInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public String showModifyOrderInfo(@Valid OrderInfo orderInfoObj, HttpServletRequest request, Model model) {
		try {
			OrderInfo orderInfo = (OrderInfo) orderInfoService.searchOrderInfoObj(orderInfoObj);
			model.addAttribute("orderInfo", orderInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "order/showModifyOrderInfo";
	}

	// 修改订单
	@RequestMapping(value = "forModifyOrderInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forModifyOrderInfo(OrderInfo orderInfo, Model model, HttpServletRequest request) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		orderInfo.setCustId(userInfo.getId());
		orderInfo.setCustName(userInfo.getUsername());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (orderInfoService.modifyOrderInfoObj(orderInfo) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}

	// 删除订单
	@RequestMapping(value = "forRemoveOrderInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forRemoveOrderInfo(@Valid OrderInfo orderInfoObj, Model model, HttpServletRequest request) {
		try {
			orderInfoService.removeOrderInfoObj(orderInfoObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// 展示详情
	@RequestMapping(value = "showOrderInfoDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String showOrderInfoDetail(OrderInfo orderInfo, Model model, HttpServletRequest request) {
		OrderInfo order = orderInfoService.searchOrderInfoObj(orderInfo);
		model.addAttribute("order", order);
		model.addAttribute("orderItems", orderInfoService.searchOrderItemList(orderInfo));
		model.addAttribute("orderLog", orderInfoService.searchOrderLogList(order.getId()));
		model.addAttribute("orderRemark", orderInfoService.searchOrderRemarkList(order.getId()));
		return "order/showOrderInfoDetail";
	}

	// 跳转新增订单备注页面
	@RequestMapping(value = "showInputRemark", method = { RequestMethod.GET, RequestMethod.POST })
	public String showInputRemark(OrderInfo orderInfo, Model model, HttpServletRequest request) {
		model.addAttribute("orderInfo", orderInfo);
		return "order/showInputRemark";
	}

	// 新增订单备注
	@RequestMapping(value = "forInputRemark", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forInputCategory(OrderRemark orderRemark, Model model, HttpServletRequest request) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		orderRemark.setUserCode(userInfo.getId().toString());
		orderRemark.setUserName(userInfo.getUsername());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (orderInfoService.inputOrderRemarkObj(orderRemark) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}

	// 修改订单状态
	@RequestMapping(value = "forChangeOrderStatus", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forChangeOrderStatus(Map<String, Object> context, Model model, HttpServletRequest request) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		context.put("custId", userInfo.getId().toString());
		context.put("custName", userInfo.getUsername());
		context.put("idStr", request.getParameter("idStr").toString());
		context.put("type", request.getParameter("type").toString());
		context.put("orderStatusStr", request.getParameter("orderStatusStr").toString());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (orderInfoService.changeOrderStatus(context) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}

	// 财审操作
	@RequestMapping(value = "forAudit", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forAudit(Map<String, Object> context, Model model, HttpServletRequest request) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		context.put("userId", userInfo.getId().toString());
		context.put("userName", userInfo.getUsername());
		context.put("orderId", request.getParameter("orderId").toString());
		context.put("type", request.getParameter("type").toString());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (orderInfoService.forAudit(context) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}

	// 展示详情
	@RequestMapping(value = "showReceiptDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String showReceiptDetail(OrderInfo orderInfo, Model model, HttpServletRequest request) {
		OrderInfo order = orderInfoService.searchOrderInfoObj(orderInfo);
		List<Region> result = custService.selectRegionByParentId(1);// 先获取省份下拉框列表
		List<Region> resultcity = null;
		if (order != null && order.getProvince() != null) {
			resultcity = custService.selectRegionByParentId(Integer.valueOf(order.getProvince()));// 获取市下拉框列表
		}
		List<Region> resultdist = null;
		if (order != null && order.getCity() != null) {
			resultdist = custService.selectRegionByParentId(Integer.valueOf(order.getCity()));// 获取区下拉框列表
		}
		
		List<Shipping> shipList = orderInfoService.searchShippingList();//获取所有的配送方式
		model.addAttribute("order", order);
		model.addAttribute("result", result);
		model.addAttribute("resultcity", resultcity);
		model.addAttribute("resultdist", resultdist);
		model.addAttribute("shipList", shipList);
		
		return "order/showReceiptDetail";
	}

	
	//打印详情
	@RequestMapping(value = "showOrderPrintDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String showOrderPrintDetail(OrderInfo orderInfo, Model model, HttpServletRequest request) {
		OrderInfo order = orderInfoService.searchOrderInfoObj(orderInfo);
		model.addAttribute("order", order);
		List<OrderItem> orderItems = orderInfoService.searchOrderItemList(orderInfo);
		if (orderItems != null && orderItems.size() > 0) {
			Integer count = 0;
			Float moneyCount = 0f;
			for (int i = 0; i < orderItems.size(); i++) {
				count += orderItems.get(i).getQuantity();
				if (orderItems.get(i).getIsGift() == 0) {
					moneyCount += (orderItems.get(i).getSalePrice() * orderItems.get(i).getQuantity());
				}
			}
			model.addAttribute("count", count);
			model.addAttribute("moneyCount", moneyCount);
		}
		model.addAttribute("orderItems", orderItems);

		return "order/showOrderPrintDetail";
	}

	/**
	 * 导出
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/exportOrder", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public void exportOrder(OrderInfo orderInfo, HttpServletRequest request, HttpServletResponse response) {
		try {

			User userInfo = (User) request.getSession().getAttribute("userInfo");
			if (userInfo.getUserType() != 0) {
				orderInfo.setShipperCode(userInfo.getUsername());
			}
			PageList<OrderInfo> list = orderInfoService.searchOrderInfoList(orderInfo, new PageBounds());
			String fileName = "订单列表";// 需要下载的文件名字
			if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
				fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// firefox浏览器
			} else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
				fileName = URLEncoder.encode(fileName, "UTF-8");// IE浏览器
			} else if (request.getHeader("User-Agent").toUpperCase().indexOf("CHROME") > 0) {
				fileName = URLEncoder.encode(fileName, "UTF-8");// IE浏览器
			}
			OutputStream os = null;
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + ".xls\"");
			response.setHeader("Connection", "close");

			try {
				os = response.getOutputStream();
				ExportService exportService = new ExportService();
				exportService.exportDataToExcel(list, 5000, os, "订单列表", excelFileName);
				os.flush();

			} catch (Exception e) {
				response.setContentType("text/xml;charset=UTF-8");
				response.setHeader("Content-Disposition", null);
			} catch (Throwable e) {
				response.setContentType("text/xml;charset=UTF-8");
				response.setHeader("Content-Disposition", null);
			} finally {
				if (null != os) {
					try {
						os.close();
						os = null;
					} catch (Exception e) {
						logger.error("error:", e);
					}
				}
			}

		} catch (Exception ex) {
			logger.error("=======================Exception:" + ex.getMessage(), ex);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("<======================Exit {}. Method: {}.", this.getClass(),
					Thread.currentThread().getStackTrace()[1].getMethodName());
		}
	}
}