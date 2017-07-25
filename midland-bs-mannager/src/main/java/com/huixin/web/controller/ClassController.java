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

import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.huixin.core.util.UploadImgUtil;
import com.huixin.web.enums.ContextEnums;
import com.huixin.web.model.Category;
import com.huixin.web.model.Class;
import com.huixin.web.model.ClassProperty;
import com.huixin.web.model.User;
import com.huixin.web.service.ClassService;
import com.huixin.web.service.ProductService;

@Controller
@RequestMapping(value = "/class")
public class ClassController {

	@Autowired
	private ClassService classService;
	@Autowired
	private ProductService productService;
	private static Logger logger = Logger.getLogger(ClassController.class);

	/**
	 * 栏目关联控制器
	 * 
	 * @author tianj
	 */

	/**
	 * 
	 * @param model
	 * @param request
	 * @param classes
	 *            进行数据绑定
	 * @return 返回页面 查询栏目列表
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String classIndex(Model model, HttpServletRequest request, Class classes) {
		return "class/classIndex";

	};
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String findClassList(Model model, HttpServletRequest request, Class classes) {
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		
		PageList<Class> classList= classService.selectClassList(classes, pageBounds);
		Paginator paginator = classList.getPaginator();
		model.addAttribute("classList", classList);
		model.addAttribute("paginator", paginator);
		if (classes != null) {
			model.addAttribute("classId", classes.getClassId());
		}
		return "class/classList";

	};

	/**
	 * 
	 * @param model
	 * @param request
	 * @param classes
	 *            进行数据绑定
	 * @return  进入添加栏目页面
	 */
	@RequestMapping(value = "/addclass", method = { RequestMethod.GET, RequestMethod.POST })
	public String addClass(Model model, HttpServletRequest request, Class classes) {
		// 先查出所有一级和二级菜单
		List<Class> unionMenuList = classService.selectUnionMenu();
		List<ClassProperty> ClassPropList = classService.selectClassProp();
		List<Category> categoryList = classService.selectCategoryRoot();
		model.addAttribute("unionMenuList", unionMenuList);
		model.addAttribute("ClassPropList", ClassPropList);
		model.addAttribute("categoryList",categoryList);
		return "class/addClass";

	};

	/**
	 * 
	 * @param model
	 * @param request
	 * @param classes
	 *            进行数据绑定
	 * @return 返回页面 栏目添加页面通过Ajax请求实现联动
	 */
	@RequestMapping(value = "/linkclassandprop", method = { RequestMethod.POST }, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String LinkClassAndProp(Model model, HttpServletRequest request, Class classes) {
		Class classed = classService.selectProperty(classes);
		Map<String, Object> map = new HashMap<>();
		map.put("classed", classed);
		return JSONObject.toJSONString(map);

	};

	/**
	 * 
	 * @param model
	 * @param request
	 * @param classes
	 *            进行数据绑定
	 * @return 返回页面 保存新添加的栏目
	 */
	@RequestMapping(value = "/saveclass", method = { RequestMethod.GET, RequestMethod.POST }, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String saveClass(MultipartHttpServletRequest mul,Model model, HttpServletRequest request, Class classes) {
		// 新增一条栏目
		Map<String, String> map = new HashMap<>();
		Map<String, MultipartFile> fileMap = mul.getFileMap();
		Map<String, String> pathList = null;
		try {
			pathList = UploadImgUtil.upload(fileMap, "/home/upload/");
		} catch (IOException e) {
			logger.error("上传文件失败！！！");
		}
		if(pathList!=null&&pathList.size()>0){
			classes.setClassPic(pathList.get("file1"));
		}
	   	HttpSession session = request.getSession();
	   	User user=(User) session.getAttribute("userInfo");
		classes.setUserBy(user.getUsername());
		Integer num = classService.insertClass(classes);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);
	};

	/**
	 * 
	 * @param model
	 * @param request
	 * @param classes
	 *            进行数据绑定
	 * @return 返回页面 进入子栏目
	 */
	@RequestMapping(value = "/enterchildmenusList", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterChildMenusList(Model model, HttpServletRequest request, Class classes) {
		// 先查出所有一级和二级菜单
		List<Class> childMenusList = classService.selectChildMenusList(classes);
		model.addAttribute("childMenusList", childMenusList);
		model.addAttribute("classes", classes);
		return "class/childClass";
	};

	/**
	 * 
	 * @param model
	 * @param request
	 * @param classes
	 *            进行数据绑定
	 * @return 返回页面 先查出所有一级和二级菜单提供供所属父级栏目选项
	 */
	@RequestMapping(value = "/uppermenusList", method = { RequestMethod.GET, RequestMethod.POST })
	public String UppermenusList(Model model, HttpServletRequest request, Class classes) {
		// 先查出所有一级和二级菜单
		List<Class> childMenusList = classService.selectChildMenusList(classes);
		model.addAttribute("childMenusList", childMenusList);
		model.addAttribute("classes", classes);
		return "class/childClass";
	};

	/**
	 * 
	 * @param model
	 * @param request
	 * @param classes
	 *            进行数据绑定
	 * @return 返回页面 进入栏目编辑页面
	 */
	@RequestMapping(value = "/editmenus", method = { RequestMethod.GET, RequestMethod.POST })
	public String editMenus(Model model, HttpServletRequest request, Class classes) {
		// 通过classId查出该条栏目
		Class classed = classService.selectProperty(classes);
		Class parentClass = classService.selectParentMenu(classed);
		List<Category> categoryList = classService.selectCategoryRoot();
		if(classed!=null&&classed.getCatId()!=null){
			Category category = new Category();
			category.setCatId(classed.getCatId());
			category = productService.searchCategoryObj(category);
			model.addAttribute("category", category);
		}
		model.addAttribute("classed", classed);
		model.addAttribute("parentClass", parentClass);
		model.addAttribute("categoryList", categoryList);
		return "class/editClass";

	};

	/**
	 * 
	 * @param model
	 * @param request
	 * @param classes
	 *            进行数据绑定
	 * @return 返回页面 保存修改栏目信息
	 */
	@RequestMapping(value = "/submiteditmenus", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String submitEditmenus(MultipartHttpServletRequest mul,Model model, HttpServletRequest request, Class classes) {
		// 通过classId查出该条栏目
		// 新增一条栏目
		Map<String, String> map = new HashMap<>();
		Map<String, MultipartFile> fileMap = mul.getFileMap();
		Map<String, String> pathList = null;
		try {
			pathList = UploadImgUtil.upload(fileMap, "/home/upload/");
		} catch (IOException e) {
			logger.error("上传文件失败！！！");
		}
		if(pathList!=null&&pathList.size()>0){
			classes.setClassPic(pathList.get("file1"));
		}
		Integer num = classService.updateClassById(classes);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);

	};
	
	/**
	 * ajax获取商品分类信息
	 * 
	 */
	@RequestMapping(value = "/getCategory", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getCategory(Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		List<Category> categoryList = classService.selectCategoryRoot();
		map.put("result", categoryList);
		return JSONObject.toJSONString(map);

	};
	
	
	@RequestMapping(value = "/deleteClass", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String deleteClass(Model model, HttpServletRequest request,Class classes) {
		Map<String, Object> map = new HashMap<>();
		Integer num = classService.deleteClassById(classes);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);

	};
	
}
