package com.huixin.web.controller;
import java.io.IOException;
import java.util.ArrayList;
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

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.huixin.core.util.UploadImgUtil;
import com.huixin.web.enums.ContextEnums;
import com.huixin.web.model.Activity;
import com.huixin.web.model.Ad;
import com.huixin.web.model.AdProd;
import com.huixin.web.model.BannerProd;
import com.huixin.web.model.Category;
import com.huixin.web.model.ListFrom;
import com.huixin.web.model.User;
import com.huixin.web.service.AdService;
import com.huixin.web.service.ProductService;

@Controller
@RequestMapping(value = "/ad")
public class AdController extends BaseController {

	@Autowired
	private AdService adService;
	@Autowired
	private ProductService productService;
	private static Logger logger = Logger.getLogger(AdController.class);

	/**
	 * 
	 * @param model
	 * @param request
	 * @param classes
	 *            进行数据绑定
	 * @return 返回页面 查询广告列表
	 */
	
	@RequestMapping(value = "/listindex", method = { RequestMethod.GET, RequestMethod.POST })
	public String findAdListIndex(Model model, HttpServletRequest request, Ad ad) {
		return "ad/adIndex";

	};
	/**
	 * 查看广告列表
	 * @param model
	 * @param request
	 * @param ad
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String findAdList(Model model, HttpServletRequest request, Ad ad) {
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		PageList<Ad> adList = adService.selectAdList(ad,pageBounds);
		Paginator paginator = adList.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("adList", adList);
		return "ad/adList";

	};
	
	/**
	 * 进入发布活动页面
	 * @param model
	 * @param request
	 * @param activity
	 * @return
	 */
	@RequestMapping(value = "/enterAd", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterAd(Model model, HttpServletRequest request, Ad ad) {
		return "ad/addAd";

	};
	
	/**
	 * 新建广告
	 * @param model
	 * @param request
	 * @param ad
	 * @return
	 */
	@RequestMapping(value = "/addAd", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String addAd(MultipartHttpServletRequest mul,Model model, HttpServletRequest request, Ad ad,String isAll,String catId,ListFrom listFrom){
		Map<String, Object> map = new HashMap<>();
		Map<String, MultipartFile> fileMap = mul.getFileMap();
		Map<String, String> pathList = null;
		try {
			pathList = UploadImgUtil.upload(fileMap, "/home/upload/");
		} catch (IOException e) {
			logger.error("上传文件失败！！！");
		}
		if(pathList!=null&&pathList.size()>0){
			ad.setAd_thumb_pic1(pathList.get("file1"));
			ad.setAd_thumb_pic2(pathList.get("file2"));
		}
	   	HttpSession session = request.getSession();
	   	User user=(User) session.getAttribute("userInfo");
	   	ad.setUserBy(user.getUsername());
		Integer num = adService.insertAdAndProd(ad, listFrom.getAdProdList(), isAll, catId);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);

	};
	/**
	 * 进入广告编辑页面
	 * @param model
	 * @param request
	 * @param ad
	 * @return
	 */
	@RequestMapping(value = "/enterEditAd", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterEditAd(Model model, HttpServletRequest request, Ad ad) {
		
		
		ad = adService.selectAd(ad);
		List<AdProd> adProdList =  adService.selectAdProd(ad);
		if(adProdList !=null&&adProdList.size()>0&&adProdList.get(0).getIsAll()!=null&&adProdList.get(0).getIsAll()==1){
			Category category = new Category();
			category.setCatId(Integer.valueOf(adProdList.get(0).getCatId()));
			category =  productService.selectCategory(category);
			List<Category> categoryList =  productService.selectCatParnet(category.getCatId());
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("adProd", adProdList.get(0));
			model.addAttribute("ad", ad);
			model.addAttribute("category", category);
			return "ad/editAd";
		}
		if(adProdList!=null&&adProdList.size()>0){
			Category category = new Category();
			category.setCatId(Integer.valueOf(adProdList.get(0).getCatId()));
			category =  productService.selectCategory(category);
			List<Category> categoryList =  productService.selectCatParnet(category.getCatId());
			List productList = adService.queryProListForAdList(adProdList);
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("adProd", adProdList.get(0));
			model.addAttribute("productList", productList);
			model.addAttribute("category", category);
		}
		model.addAttribute("ad", ad);
		return "ad/editAd";

	};
	
	/**
	 * 保存编辑后的广告
	 * @param model
	 * @param request
	 * @param ad
	 * @return
	 */
	@RequestMapping(value = "/saveEditAd", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String saveEditAd(MultipartHttpServletRequest mul,Model model, HttpServletRequest request, Ad ad,ListFrom listFrom,String isAll,String catId) {
		Map<String,Object> map = new HashMap<>();
		adService.deleteAdById(ad);
		adService.deleteAdprod(ad.getAdId());
		Map<String, MultipartFile> fileMap = mul.getFileMap();
		Map<String, String> pathList = null;
		try {
			pathList = UploadImgUtil.upload(fileMap, "/home/upload/");
		} catch (IOException e) {
			logger.error("上传文件失败！！！");
		}
		if(pathList!=null&&pathList.size()>0){
			ad.setAd_thumb_pic1(pathList.get("file1"));
			ad.setAd_thumb_pic2(pathList.get("file2"));
		}
	   	HttpSession session = request.getSession();
	   	User user=(User) session.getAttribute("userInfo");
	   	ad.setUserBy(user.getUsername());
		Integer num = adService.insertAdAndProd(ad, listFrom.getAdProdList(), isAll, catId);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
			}
		return JSONObject.toJSONString(map);

	};
	/**
	 * 删除广告
	 * @param model
	 * @param request
	 * @param ad
	 * @return
	 */
	@RequestMapping(value = "/deleteAd", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String deleteAd(Model model, HttpServletRequest request, Ad ad) {
		Map<String, Object> map = new HashMap<>();
		Integer num = adService.deleteAd(ad);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);

	};
	
	/**
	 * 进入商品查询页面
	 * @param model
	 * @param request
	 * @param ad
	 * @return
	 */
	@RequestMapping(value = "/enterSearchProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchCategory(Model model, HttpServletRequest request, Category category,String isAll) {
		List categoryList =null;
		if(category.getCatId()!=null&&!category.getCatId().equals("")){
			 categoryList =  productService.searchCategoryList(category,new PageBounds());	
			 model.addAttribute("categoryList", categoryList.get(0));
		}/*{else
		     categoryList =  productService.searchCategoryList(null,new PageBounds());
		}*/
			String categoryData = super.getCategoryTree("");
			model.addAttribute("categoryData", categoryData);
			model.addAttribute("isAll",isAll);
		return "ad/productSearch";

	};
	
	/**
	 * 查询商品
	 * @param model
	 * @param request
	 * @param ad
	 * @return
	 */
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
		return "ad/productSearch";

	};
	/**
	 * 
	 * @param model
	 * @param request
	 * @param ad
	 * @return ajax查找所有选择类型的父类
	 */
	@RequestMapping(value = "/selectCatParnet", method = { RequestMethod.GET, RequestMethod.POST },produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String selectCatParnet(Model model, HttpServletRequest request, String catId) {
		Map< String, Object> map = new HashMap<>();
		List<Category> categoryList =  productService.selectCatParnet(Integer.valueOf(catId));
		map.put("result", categoryList);
		return JSONObject.toJSONString(map);

	};
	
	
	@RequestMapping(value = "/testMune",method = { RequestMethod.GET, RequestMethod.POST },produces = "text/html;charset=UTF-8")
	@ResponseBody
    public String testMune() {
 	    List<Category> categoryList = productService.selectCategoryLevel();
 	    // 查看结果
 	    for (Category menu : categoryList) {
 	        System.out.println(menu);
 	    }
 	    // 最后的结果
 	    List<Category> menuList = new ArrayList<Category>();
 	    // 先找到所有的一级菜单
 	    for (int i = 0; i < categoryList.size(); i++) {
 	        // 一级菜单没有parentId
 	        if (categoryList.get(i).getParentId()==0) {
 	            menuList.add(categoryList.get(i));
 	        }
 	    }
 	    // 为一级菜单设置子菜单，getChild是递归调用的
 	    for (Category menu : menuList) {
 	        menu.setChildCategory(getChild(menu.getCatId(), categoryList));
 	    }
 	    Map<String,Object> jsonMap = new HashMap<>();
 	    jsonMap.put("menu", menuList);
 	    
 	   return JSONObject.toJSONString(jsonMap);
       
    }
    
	/**
	 * 递归查找子菜单
	 * 
	 * @param id
	 *            当前菜单id
	 * @param rootMenu
	 *            要查找的列表
	 * @return
	 */
	private static List<Category> getChild(Integer id, List<Category> rootMenu) {
	    // 子菜单
	    List<Category> childList = new ArrayList<>();
	    for (Category menu : rootMenu) {
	        // 遍历所有节点，将父菜单id与传过来的id比较
	        if (menu.getParentId()!=0) {
	            if (menu.getParentId().equals(id)) {
	                childList.add(menu);
	            }
	        }
	    }
	    // 把子菜单的子菜单再循环一遍
	    for (Category menu : childList) {// 没有url子菜单还有子菜单
	       /* if (StringUtils.isEmpty(menu.getUrl())) {*/
	            // 递归
	            menu.setChildCategory(getChild(menu.getCatId(), rootMenu));
	       /* }*/
	    } // 递归退出条件
	    if (childList.size() == 0) {
	        return null;
	    }
	    return childList;
	}
    
    

	
	
	
	

}
