package com.huixin.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.huixin.core.util.DateUtils;
import com.huixin.web.enums.ContextEnums;
import com.huixin.web.model.Customer;
import com.huixin.web.model.ListFrom;
import com.huixin.web.model.OrderInfo;
import com.huixin.web.model.Promotion;
import com.huixin.web.model.Settlement;
import com.huixin.web.model.SettlementItem;
import com.huixin.web.model.User;
import com.huixin.web.service.SettlementService;
import com.huixin.web.service.impl.ExportService;

import net.sf.jxls.transformer.XLSTransformer;

@Controller
@RequestMapping(value="settlement")
public class SettlementController {
	public static final Logger  logger = LoggerFactory.getLogger(SettlementController.class);
	@Autowired private SettlementService settlementService;
	@RequestMapping(value="saveSettlementIndex", method = { RequestMethod.GET, RequestMethod.POST } )
	public String orderInfoIndex(Model model, HttpServletRequest request,Promotion promotion){
		String Str = DateUtils.formatDateToString(new Date(), DateUtils.FORMAT_YYYYMMDDHHMMSS);
		Str = Str.substring(2, 8);
		Long randomNumber = (Long) System.currentTimeMillis()%(1000)+1;
		String createDate = DateUtils.formatDateToString(new Date(), DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS);
		model.addAttribute("createDate", createDate);
		model.addAttribute("settSn", "CX"+Str+randomNumber);
		return "settlement/saveSettlementIndex";
	};
	/**
	 * 查询订单列表
	 * @param model
	 * @param request
	 * @param orderInfo
	 * @param custId
	 * @return
	 */
	@RequestMapping(value="seracheOrderList", method = { RequestMethod.GET, RequestMethod.POST },produces = "application/json; charset=UTF-8" )
	public String seracheOrder(Model model, HttpServletRequest request,OrderInfo orderInfo,String custId){
		List<OrderInfo> orderInfoList = settlementService.selectOrderInfoList(orderInfo);
		Double orderAmountCount = settlementService.selectOrderAmountCount(orderInfo);
		model.addAttribute("orderInfoList", orderInfoList);
		model.addAttribute("orderAmountCount", orderAmountCount);
		return "settlement/seracheOrder";
	};
	/**
	 * 获取客户信息
	 * @param model
	 * @param request
	 * @param orderInfo
	 * @param custId
	 * @param custName
	 * @return
	 */
	@RequestMapping(value="seracheCustomer", method = { RequestMethod.GET, RequestMethod.POST },produces = "application/json; charset=UTF-8" )
	@ResponseBody
	public String seracheCustomer(Model model, HttpServletRequest request,OrderInfo orderInfo,String custId,String custName){
		Map<String, Object> map = new HashMap<>();
		
		//获取顶级客户
		if(custName!=null&&!custName.equals("")){
			List<Customer> customerList =	 settlementService.selectCustomerList(custName);
			map.put("data", customerList);
		}
		//获取子客户
		if(custId!=null&&!custId.equals("")){
			List<Customer> customerListChild = settlementService.selectCustomerListById(Integer.valueOf(custId));
			map.put("data", customerListChild);
		}
		return JSONObject.toJSONString(map);
	};
	
	/**
	 * 保存计算单
	 * @param model
	 * @param request
	 * @param orderInfo
	 * @param settlement
	 * @return
	 */
	@RequestMapping(value="saveSettlement", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
	public String saveSettlement(Model model, HttpServletRequest request,ListFrom orderInfoList,Settlement settlement){
		if(settlement!=null&&settlement.getId()!=null){
			settlementService.deleteSettlement(settlement);
			settlementService.deleteSettlementItem(settlement);
		}
		if(settlement.getBetweenTimeStart()!=null&&!settlement.getBetweenTimeStart().equals("")){
			settlement.setBegin_time(settlement.getBetweenTimeStart());
		}
		if(settlement.getBetweenTimeEnd()!=null&&!settlement.getBetweenTimeEnd().equals("")){
			settlement.setEnd_time(settlement.getBetweenTimeEnd());
		}
		Integer num = settlementService.insertSettlement(settlement);
		List<SettlementItem> settlementItemList = new ArrayList<>();
		if(orderInfoList!=null&&orderInfoList.getOrderInfoList()!=null){
		for (OrderInfo orderInfo : orderInfoList.getOrderInfoList()) {
			SettlementItem settlementItem = new SettlementItem();
			if(orderInfo.getId()!=null&&settlement.getId()!=null){
				settlementItem.setOrder_id(orderInfo.getId());
				settlementItem.setSett_id(settlement.getId());
				settlementItemList.add(settlementItem);
			}
		}
		}
		if(settlementItemList.size()>0){
		settlementService.insertSettlementItem(settlementItemList);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("id", settlement.getId());
		return JSONObject.toJSONString(map);
	};
	/**
	 * 账单确认
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="settlementConfirm", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
	public String SettlementConfirm(Model model, HttpServletRequest request,Settlement settlement){
		Map<String, Object> map = new HashMap<>();
		settlement.setStatus(1);
		Integer num = settlementService.updateSettlement(settlement);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);
	};
	
	/**
	 * 账单反确认
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="reversalConfirm", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
	public String reversalConfirm(Model model, HttpServletRequest request,Settlement settlement){
		Map<String, Object> map = new HashMap<>();
		settlement.setStatus(0);
		Integer num = settlementService.updateSettlement(settlement);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);
	};
	
	/**
	 * 记账
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="accounting", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
	public String accounting(Model model, HttpServletRequest request,Settlement settlement){
		Map<String, Object> map = new HashMap<>();
		settlement.setStatus(2);
		settlementService.updateSettlement(settlement);
		Integer num = settlementService.updateSettStatus(settlement);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);
	};
	
	/**
	 * 删除一条订单信息
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 * orderAmount 单个订单总额
	 */
	@RequestMapping(value="deleteSettlementItem", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
	public String deleteSettlementItem(Model model, HttpServletRequest request,String orderId ,String id,String total_amount,String orderAmount){
		Settlement settlement = new Settlement();
		settlement.setId(Integer.valueOf(id));
		if(total_amount!=null&&!total_amount.equals("")&&orderAmount!=null&&!orderAmount.equals("")){
		settlement.setTotal_amount(Double.valueOf(total_amount)-Double.valueOf(orderAmount));
		}else{
			settlement.setTotal_amount(0.00);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("orderId", orderId);
		Integer num = settlementService.deleteSettlementItemByOrderId(map);
		settlementService.updateSettlement(settlement);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);

	};
	
	/**
	 * 查询结算单列表
	 * @param model
	 * @param request
	 * @param settlement
	 * @return
	 */
	@RequestMapping(value="settlementIndex", method = { RequestMethod.GET, RequestMethod.POST } )
	public String settlementIndex(Model model, HttpServletRequest request,Settlement settlement){
		User user = (User)request.getSession().getAttribute("userInfo");
		model.addAttribute("userType", user.getUserType());
		return "settlement/settlementIndex";
	};
	/**
	 * 查询结算单列表
	 * @param model
	 * @param request
	 * @param orderInfo
	 * @param custId
	 * @return
	 */
	@RequestMapping(value="settlementList", method = { RequestMethod.GET, RequestMethod.POST } )
	public String settlementList(Model model, HttpServletRequest request,Settlement settlement){
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		User user = (User)request.getSession().getAttribute("userInfo");
		if(user.getUserType()!=0){
			settlement.setCust_name(user.getUserCnName());
		}
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		PageList<Settlement> settlementList = settlementService.selectSettlementList(settlement, pageBounds);
		Paginator paginator = settlementList.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("settlementList", settlementList);
		model.addAttribute("userType", user.getUserType());
		return "settlement/settlementList";
	};
	/**
	 * 查看详情
	 * @param model
	 * @param request
	 * @param settlement
	 * @return
	 */
	@RequestMapping(value="settlementDetails", method = { RequestMethod.GET, RequestMethod.POST } )
	public String settlementDetails(Model model, HttpServletRequest request,Settlement settlement){
		settlement = settlementService.selectSettlement(settlement);
		List<OrderInfo> orderInfoList = settlementService.selectOrderInfoDetails(settlement);
		model.addAttribute("settlement", settlement);
		model.addAttribute("orderInfoList", orderInfoList);
		return "settlement/settlementDetails";
	};
	
	/**
	 * 编辑
	 * @param model
	 * @param request
	 * @param settlement
	 * @return
	 */
	@RequestMapping(value="settlementEdit", method = { RequestMethod.GET, RequestMethod.POST } )
	public String settlementEdit(Model model, HttpServletRequest request,Settlement settlement){
		settlement = settlementService.selectSettlement(settlement);
		List<OrderInfo> orderInfoList = settlementService.selectOrderInfoDetails(settlement);
		model.addAttribute("settlement", settlement);
		model.addAttribute("orderInfoList", orderInfoList);
		return "settlement/settlementEdit";
	};
	
	
    /**
     * 服务工单导出
     * @param
     * @return
     */
    @RequestMapping(value = "/exportExSettlement", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public void exportOrders(HttpServletRequest request,HttpServletResponse response,ListFrom orderInfoList,Settlement settlement){
    	try {
    		Map<String, Object> map = new HashMap<>();
    		map.put("settlement", settlement);
    		map.put("list", orderInfoList.getOrderInfoList());
     	   String fileName = "结算单";// 需要下载的文件名字
				if (request.getHeader("User-Agent").toLowerCase()
						.indexOf("firefox") > 0) {
					fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// firefox浏览器
				} else if (request.getHeader("User-Agent").toUpperCase()
						.indexOf("MSIE") > 0) {
					fileName = URLEncoder.encode(fileName, "UTF-8");// IE浏览器
				} else if (request.getHeader("User-Agent").toUpperCase()
						.indexOf("CHROME") > 0) {
					fileName = URLEncoder.encode(fileName, "UTF-8");// IE浏览器
				}
				OutputStream os = null;
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "attachment;filename=\""
						+ fileName + ".xls\"");
				response.setHeader("Connection", "close");

				try {
					os = response.getOutputStream();
					ExportService exportService = new ExportService();
					exportService.exportSettelToExcel(os, map, "exportExSettlement.xlsx");
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
            logger.debug("<======================Exit {}. Method: {}.", this.getClass(), Thread.currentThread().getStackTrace()[1].getMethodName());
        }
    
    
    }
	
	@RequestMapping(value="deleteSettlement", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
	public String deleteSettlement(Settlement settlement){
		Map<String, Object> map = new HashMap<>();
		Integer num = 0;
		if(settlement!=null&&settlement.getId()!=null){
			num = settlementService.deleteSettlement(settlement);
			settlementService.deleteSettlementItem(settlement);
		}
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");	
		}
		return JSONObject.toJSONString(map);

	}

}
