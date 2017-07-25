package com.huixin.web.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.huixin.core.util.UploadImgUtil;
import com.huixin.web.dao.BannerProdMapper;
import com.huixin.web.enums.ContextEnums;
import com.huixin.web.model.Activity;
import com.huixin.web.model.Ad;
import com.huixin.web.model.Banner;
import com.huixin.web.model.BannerProd;
import com.huixin.web.model.Category;
import com.huixin.web.model.ListFrom;
import com.huixin.web.model.User;
import com.huixin.web.service.AdService;
import com.huixin.web.service.BannerService;
import com.huixin.web.service.ProductService;

@Controller
@RequestMapping(value = "/banner")
public class bannerController extends BaseController {

	@Autowired
	private BannerService bannerService;
	@Autowired
	private ProductService productService;
	private static Logger logger = Logger.getLogger(bannerController.class);

	/**
	 * 
	 * @param model
	 * @param request
	 * @param classes
	 *            进行数据绑定
	 * @return 返回页面 查询广告列表
	 */
	
	@RequestMapping(value = "/bannerindex", method = { RequestMethod.GET, RequestMethod.POST })
	public String findAdListIndex(Model model, HttpServletRequest request, Ad ad) {
		return "banner/bannerIndex";

	};
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String findAdList(Model model, HttpServletRequest request,Banner banner ) {
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		PageList<Banner> bannerList =  bannerService.selectBannerList(banner, pageBounds);
		Paginator paginator = bannerList.getPaginator();
		model.addAttribute("bannerList", bannerList);
		model.addAttribute("paginator", paginator);
		return "banner/bannerList";

	};
	
	/**
	 * 进入发布活动页面
	 * @param model
	 * @param request
	 * @param activity
	 * @return
	 */
	@RequestMapping(value = "/enterBanner", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterBanner(Model model, HttpServletRequest request, Banner banner) {
		return "banner/addBanner";

	};
	
	@RequestMapping(value = "/addBanner", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String addBanner(MultipartHttpServletRequest mul,Model model, HttpServletRequest request, Banner banner,ListFrom listFrom,String isAll,String catId){
		Map<String, Object> map = new HashMap<>();
		Map<String, MultipartFile> fileMap = mul.getFileMap();
		Map<String, String> pathList = null;
		try {
			pathList = UploadImgUtil.upload(fileMap, "/home/upload/");
		} catch (IOException e) {
			logger.error("上传文件失败！！！");
		}
		if(pathList!=null&&pathList.size()>0){
			banner.setBannerImg1(pathList.get("file1"));
			banner.setBannerImg2(pathList.get("file2"));
		}
		Integer num = bannerService.insertBannerAndProd(banner, listFrom.getBannerProdList(),isAll,catId);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);

	};
	
	
	@RequestMapping(value = "/enterSearchProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchCategory(Model model, HttpServletRequest request, Category category,String isAll) {
		List categoryList =null;
		if(category.getCatId()!=null&&!category.getCatId().equals("")){
			 categoryList =  productService.searchCategoryList(category,new PageBounds());	
			 model.addAttribute("categoryList", categoryList.get(0));
		}/*else{
		     categoryList =  productService.searchCategoryList(null,new PageBounds());
		}*/
		String categoryData = super.getCategoryTree("");
		model.addAttribute("categoryData", categoryData);
		model.addAttribute("isAll",isAll);
		return "banner/productSearch";

	};
	
	@RequestMapping(value = "/SearchProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchProduct(Model model, HttpServletRequest request, String nameStr,String codeStr,String catId,String isAll) {
		Map<String, Object> map = new HashMap<>();
		map.put("nameStr", nameStr);
		map.put("codeStr", codeStr);
		map.put("catId", catId);
		List productList = null;
		if(nameStr.equals("")&&codeStr.equals("")&&catId.equals("")){
		}else{
			productList = productService.queryProListForMap(map);
		}
		List categoryList =null;
		if(catId!=null&&!catId.equals("")){
			 Category category = new Category();
			 category.setCatId(Integer.valueOf(catId));
			 categoryList =  productService.searchCategoryList(category,new PageBounds());	
			 model.addAttribute("categoryList", categoryList.get(0));
		}
		String categoryData = super.getCategoryTree("");
		model.addAttribute("productList", productList);
		model.addAttribute("categoryData", categoryData);
		model.addAttribute("catId",catId);
		model.addAttribute("isAll",isAll);
		return "banner/productSearch";

	};
	
	@RequestMapping(value = "/enterEditBanner", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterEditBanner(Model model, HttpServletRequest request,Banner banner ) {
		banner = bannerService.selectBanner(banner.getId());
		List<BannerProd> bannerProdList =  bannerService.selectBannerProd(banner);
		if(bannerProdList !=null&&bannerProdList.size()>0&&bannerProdList.get(0).getIsAll()!=null&&bannerProdList.get(0).getIsAll()==1){
			Category category = new Category();
			category.setCatId(Integer.valueOf(bannerProdList.get(0).getCatId()));
			category =  productService.selectCategory(category);
			List<Category> categoryList =  productService.selectCatParnet(category.getCatId());
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("bannerProd", bannerProdList.get(0));
			model.addAttribute("banner", banner);
			model.addAttribute("category", category);
			return "banner/editBanner";
		}
		if(bannerProdList!=null&&bannerProdList.size()>0){
			Category category = new Category();
			category.setCatId(Integer.valueOf(bannerProdList.get(0).getCatId()));
			category =  productService.selectCategory(category);
			List<Category> categoryList =  productService.selectCatParnet(category.getCatId());
			List productList = bannerService.queryProListForList(bannerProdList);
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("bannerProd", bannerProdList.get(0));
			model.addAttribute("productList", productList);
			model.addAttribute("category", category);
		}
		model.addAttribute("banner", banner);
		return "banner/editBanner";

	};
	
	@RequestMapping(value = "/saveEditBanner", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String saveEditBanner(MultipartHttpServletRequest mul,Model model, HttpServletRequest request, Banner banner,ListFrom listFrom,String isAll,String catId) {
		bannerService.deleteBanner(banner.getId());
		bannerService.deleteBannerprd(banner.getId());
		Map<String, Object> map = new HashMap<>();
		Map<String, MultipartFile> fileMap = mul.getFileMap();
		Map<String, String> pathList = null;
		try {
			pathList = UploadImgUtil.upload(fileMap, "/home/upload/");
		} catch (IOException e) {
			logger.error("上传文件失败！！！");
		}
		if(pathList!=null&&pathList.size()>0){
			banner.setBannerImg1(pathList.get("file1"));
			banner.setBannerImg2(pathList.get("file2"));
		}
		Integer num = bannerService.insertBannerAndProd(banner, listFrom.getBannerProdList(),isAll,catId);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);

	};
	//ajax查找所有选择类型的父类
	@RequestMapping(value = "/selectCatParnet", method = { RequestMethod.GET, RequestMethod.POST },produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String selectCatParnet(Model model, HttpServletRequest request, String catId) {
		Map< String, Object> map = new HashMap<>();
		List<Category> categoryList =  productService.selectCatParnet(Integer.valueOf(catId));
		map.put("result", categoryList);
		return JSONObject.toJSONString(map);

	};
	
	//ajax删除banner
	@RequestMapping(value = "/deleteBanner", method = { RequestMethod.GET, RequestMethod.POST },produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteBanner(Model model, HttpServletRequest request, String bannerId) {
		Integer num = 0;
		Map< String, Object> map = new HashMap<>();
		num = bannerService.deleteBanner(Integer.valueOf(bannerId));
		bannerService.deleteBannerprd(Integer.valueOf(bannerId));
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);

	};
	
	
	
	

}
