package com.huixin.web.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.huixin.web.model.Activity;
import com.huixin.web.model.Category;
import com.huixin.web.model.ListFrom;
import com.huixin.web.model.Product;
import com.huixin.web.model.Promotion;
import com.huixin.web.model.PromotionGift;
import com.huixin.web.model.PromotionProp;
import com.huixin.web.service.ProductService;
import com.huixin.web.service.PromotionGiftService;
import com.huixin.web.service.PromotionPropService;
import com.huixin.web.service.PromotionService;

@Controller
@RequestMapping(value="/promotion")
public class PromotionController extends BaseController{
	@Autowired private PromotionGiftService promotionGiftService;
	@Autowired private PromotionService promotionService;
	@Autowired private ProductService productService;
	@Autowired private PromotionPropService promotionPropService;
	
	
	@RequestMapping(value = "/enterPromotionIndex", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterPromotionIndex(Model model, HttpServletRequest request) {
		return "promotion/promotionIndex";
	};
	
	@RequestMapping(value = "/promotionlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String promotionList(Model model, HttpServletRequest request,Promotion promotion) {
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		PageList<Promotion> promotionList = promotionService.selectPromotionByEntity(promotion, pageBounds);
		Paginator paginator = promotionList.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("promotionList", promotionList);
		return "promotion/promotionList";

	};
	
	
	@RequestMapping(value = "/enterPromotion", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterActivity(Model model, HttpServletRequest request) {
		String Str = DateUtils.formatDateToString(new Date(), DateUtils.FORMAT_YYYYMMDDHHMMSS);
		Str = Str.substring(2, 8);
		Long randomNumber = (Long) System.currentTimeMillis()%(1000)+1; 
		String createDate = DateUtils.formatDateToString(new Date(), DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS);
		model.addAttribute("createDate", createDate);
		model.addAttribute("prom_sn", "CX"+Str+randomNumber);
		return "promotion/addPromotion";

	};
	
	@RequestMapping(value = "/enterSearchProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchCategory(Model model, HttpServletRequest request, Category category,String flag) {
		String result = getCategoryTree("");
		if(StringUtils.isNotEmpty(result)){
			model.addAttribute("categoryData",result );
		}
		model.addAttribute("flag", flag);
		return "promotion/productSearch";

	};
	
	@RequestMapping(value = "/SearchProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchProduct(Model model, HttpServletRequest request, String nameStr,String codeStr,String catId,String flag) {
		Map<String, Object> map = new HashMap<>();
		map.put("nameStr", nameStr);
		map.put("codeStr", codeStr);
		map.put("catId", catId);
		List productList = productService.queryProListForMap(map);
		List<Category> categoryList =  productService.searchCategoryList(null,new PageBounds());
		String result = getCategoryTree("");
		if(StringUtils.isNotEmpty(result)){
			model.addAttribute("categoryData",result );
		}
		model.addAttribute("productList", productList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("flag", flag);
		return "promotion/productSearch";

	};
	
	@RequestMapping(value = "/savePromotion", method = {RequestMethod.POST,RequestMethod.GET })
	@ResponseBody
	public String savePromotion(Model model, HttpServletRequest request,Promotion promotion,ListFrom promotionGiftList) {
		 Map<String, Object> map = new HashMap<>();
		 Integer num =0;
		 num = promotionService.insetPromotion(promotion);
		 List<PromotionGift> promotionGiftLists = promotionGiftList.getPromotionGiftList();
		 List<PromotionProp> promotionPropList = promotionGiftList.getPromotionPropList();
		 List<PromotionProp> newpromotionProp = new ArrayList<>();
		 List<PromotionGift> newpromotionGift = new ArrayList<>();
		 if(promotionPropList!=null){
		 for (PromotionProp promotionProp : promotionPropList) {
			 promotionProp.setProm_id(promotion.getId());
			 newpromotionProp.add(promotionProp);
			
		}
		}
		 if(promotionGiftLists!=null){
		 for (PromotionGift promotionGiftLis : promotionGiftLists) {
			 promotionGiftLis.setProm_id(promotion.getId());
			 newpromotionGift.add(promotionGiftLis);
		}
		 }
		 
		 if(promotionGiftList.getPromotionGiftList()!=null&&promotionGiftList.getPromotionGiftList().size()>0){
			 num= promotionGiftService.insetBatchPromotionGift(promotionGiftList.getPromotionGiftList());
		 }
		 if(promotionGiftList.getPromotionPropList()!=null&&promotionGiftList.getPromotionPropList().size()>0){
			 num= promotionPropService.insetBatchPromotionProp(promotionGiftList.getPromotionPropList());
		 }
		 if(num>0){
			 map.put("result", "ok");
		 }else{
			 map.put("result", "error");
		 }
		return JSONObject.toJSONString(map);

	};
	/**
	 * @author tianj
	 * @param model
	 * @param request
	 * @return进入促销详情页面
	 */
	@RequestMapping(value = "/enterPromotionDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterPromotionDetails(Model model, HttpServletRequest request,String prom_id) {
		Map<String, Object> map = new HashMap<>();
		map.put("prom_id", prom_id);
		Promotion promotion = new Promotion();
		promotion.setId(Integer.valueOf(prom_id));
		promotion= promotionService.selectPromotionById(promotion);
		List<PromotionGift> promotionGiftList = promotionGiftService.selectPromotionGiftByPromId(map);
		List<PromotionProp> promotionPropList = promotionPropService.selectPromotionPropByPromId(map);
		model.addAttribute("promotionGiftList", promotionGiftList);
		model.addAttribute("promotionPropList", promotionPropList);
		model.addAttribute("promotion", promotion);
		return "promotion/promotionDetails";
	};
	
	/**
	 * 进入编辑页面
	 * @param model
	 * @param request
	 * @param prom_id
	 * @return
	 */
	@RequestMapping(value = "/enterPromotionEdit", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterPromotionEdit(Model model, HttpServletRequest request,String prom_id) {
		Map<String, Object> map = new HashMap<>();
		map.put("prom_id", prom_id);
		Promotion promotion = new Promotion();
		promotion.setId(Integer.valueOf(prom_id));
		promotion= promotionService.selectPromotionById(promotion);
		List<PromotionGift> promotionGiftList = promotionGiftService.selectPromotionGiftByPromId(map);
		List<PromotionProp> promotionPropList = promotionPropService.selectPromotionPropByPromId(map);
		model.addAttribute("promotionGiftList", promotionGiftList);
		model.addAttribute("promotionPropList", promotionPropList);
		model.addAttribute("promotion", promotion);
		return "promotion/editPromotion";
	};
	
	@RequestMapping(value = "/savePromotionEdit", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String savePromotionEdit(Model model, HttpServletRequest request,Promotion promotion,ListFrom promotionGiftList) {
		Integer num =0;
		Map<String, Object> map = new HashMap<>();
		promotionService.updatePromotionById(promotion);
		/*if(promotionGiftList.getPromotionPropList()==null){
			PromotionProp promotionProp = new PromotionProp();
			promotionProp.setProm_id(promotion.getId());
			promotionPropService.deletePromotionProp(promotionProp);
		}else{
			promotionPropService.saveOrUpdatePromotionProp(promotionGiftList.getPromotionPropList(), promotion);
		}
		if(promotionGiftList.getPromotionGiftList()==null){
			PromotionGift promotionGift = new PromotionGift();
			promotionGift.setProm_id(promotion.getId());
			promotionGiftService.deletePromotionGift(promotionGift);
		}else{
			promotionGiftService.saveOrUpdatePromotionGift(promotionGiftList.getPromotionGiftList(), promotion);
		}*/
		num = promotionGiftService.delectPromotionGiftAndInsert(promotionGiftList.getPromotionGiftList(), promotion);
		num = promotionPropService.delectPromotionPropAndInsert(promotionGiftList.getPromotionPropList(), promotion);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);
	};
	
	@RequestMapping(value = "/updateEnabled", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String updateEnabled(Model model, HttpServletRequest request,Promotion promotion) {
		Map<String, Object> map = new HashMap<>();
		promotionService.updatePromotionById(promotion);
		map.put("result", "ok");
		return JSONObject.toJSONString(map);
	};
	
	@RequestMapping(value = "/updateisMutex", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String UpdateisMutex(Model model, HttpServletRequest request,Promotion promotion) {
		Map<String, Object> map = new HashMap<>();
		promotionService.updatePromotionById(promotion);
		map.put("result", "ok");
		return JSONObject.toJSONString(map);
	};
	
	@RequestMapping(value = "/deleteProm", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String deleteProm(Model model, HttpServletRequest request,Promotion promotion) {
		Map<String, Object> map = new HashMap<>();
		Integer num = 0;
		num = promotionService.deletePromById(promotion);
		PromotionGift promotionGift = new PromotionGift();
		promotionGift.setProm_id(promotion.getId());
		promotionGiftService.deletePromotionGift(promotionGift);
		PromotionProp promotionProp = new PromotionProp();
		promotionProp.setProm_id(promotion.getId());
		promotionPropService.deletePromotionProp(promotionProp);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		
		return JSONObject.toJSONString(map);
	};
	

}
