package com.huixin.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 报表 控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/dataTable")
public class DataTableController {


	/**
	 * 客户统计
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/showCustDataTable", method = {RequestMethod.GET,RequestMethod.POST})
    public String showCustDataTable(Model model,HttpServletRequest request){
    	return "dataTable/showCustDataTable";
    }
	
	/**
	 * 订单统计
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/showOrderDataTable", method = {RequestMethod.GET,RequestMethod.POST})
    public String showOrderDataTable(Model model,HttpServletRequest request){
    	return "dataTable/showOrderDataTable";
    }
	
	/**
	 * 财务统计
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/showPriceDataTable", method = {RequestMethod.GET,RequestMethod.POST})
    public String showPriceDataTable(Model model,HttpServletRequest request){
    	return "dataTable/showPriceDataTable";
    }
	
	/**
	 * 商品统计
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/showProductDataTable", method = {RequestMethod.GET,RequestMethod.POST})
    public String showProductDataTable(Model model,HttpServletRequest request){
    	return "dataTable/showProductDataTable";
    }
	

}
