package com.huixin.web.controller;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.huixin.web.model.Category;
import com.huixin.web.model.Product;
import com.huixin.web.model.ProductPic;
import com.huixin.web.model.ProductProperty;
import com.huixin.web.service.ProductService;
import com.huixin.web.service.impl.ExportService;

/**
 * 公共视图控制器
 * 
 * @author jzg
 * 
 **/

@Controller
@RequestMapping(value = "/product")
public class ProductController extends BaseController{

	//日志
    public static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	
	@Resource
	private ProductService productService;
	
	
	private final String  excelFileName="exportProduct.xls";

	/**** --------------------------------- 产品分类 -------------------------------------*/

	// 进入产品分页首页面
	@RequestMapping(value = "showCategoryIndex", method = { RequestMethod.GET, RequestMethod.POST })
	public String showCategoryIndex(Model model, HttpServletRequest request) {
		return "product/showCategoryIndex";
	}

	// 进入产品分页首页面
	@RequestMapping(value = "showCategoryList", method = { RequestMethod.GET, RequestMethod.POST })
	public String showCategoryList(Category searchObj, Model model, HttpServletRequest request) {
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		if (pageSize == null || pageSize.equals("")) {
			pageSize = "10";
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));

		PageList<Category> categoryList = productService.searchCategoryList(searchObj, pageBounds);
		Paginator paginator = categoryList.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("categoryList", categoryList);
		String result = getCategoryTree("");
		if(StringUtils.isNotEmpty(result)){
			model.addAttribute("categoryData",result );
		}
		return "product/showCategoryList";
	}

	// 跳转新增产品分类页面
	@RequestMapping(value = "showInputCategory", method = { RequestMethod.GET, RequestMethod.POST })
	public String showInputCategory(Model model, HttpServletRequest request) {
		String result = getCategoryTree("1");
		if(StringUtils.isNotEmpty(result)){
			model.addAttribute("categoryData",result );
		}
		return "product/showInputCategory";
	}

	// 新增产品分类
	@RequestMapping(value = "forInputCategory", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forInputCategory(@Valid Category category, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (productService.inputCategoryObj(category) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}

	// 跳转修改产品分类页面
	@RequestMapping(value = "showModifyCategory", method = { RequestMethod.GET, RequestMethod.POST })
	public String showModifyCategory(@Valid Category categoryObj, HttpServletRequest request, Model model) {
		try {
			Category category = (Category) productService.searchCategoryObj(categoryObj);
			model.addAttribute("category", category);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "product/showModifyCategory";
	}

	// 修改产品分类
	@RequestMapping(value = "forModifyCategory", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forModifyCategory(@Valid Category categoryObj, Model model, HttpServletRequest request) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (productService.modifyCategoryObj(categoryObj) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}

	// 删除产品分类
	@RequestMapping(value = "forRemoveCategory", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forRemoveCategory(@Valid Category categoryObj, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (productService.removeCategoryObj(categoryObj) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}

	// 查询分类名称是否存在
	@RequestMapping(value = "searchCatNameIsExist", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String searchCatNameIsExist(Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String catName = request.getParameter("catName").toString();
			map.put("result", "0");
			if (StringUtils.isNotEmpty(catName)) {
				int result = productService.searchCatNameIsExist(catName);
				if (result > 0) {
					map.put("result", "1");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toJSONString(map);
	}

	

	/**** --------------------------------- 产品分类 -------------------------------------*/
	
	
	
	// 进入产品分页首页面
	@RequestMapping(value = "showProductIndex", method = { RequestMethod.GET, RequestMethod.POST })
	public String showProductIndex(Model model, HttpServletRequest request) {
		return "product/showProductIndex";
	}

	// 进入产品分页首页面
	@RequestMapping(value = "showProductList", method = { RequestMethod.GET, RequestMethod.POST })
	public String showProductList(Product searchObj, Model model, HttpServletRequest request) {
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		if (pageSize == null || pageSize.equals("")) {
			pageSize = "10";
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		PageList<Product> productList = productService.searchProductList(searchObj, pageBounds);
		Paginator paginator = productList.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("productList", productList);
		return "product/showProductList";
	}

	// 跳转新增产品页面
	@RequestMapping(value = "showInputProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public String showInputProduct(Model model, HttpServletRequest request) {
		String result = getCategoryTree("");
		if(StringUtils.isNotEmpty(result)){
			model.addAttribute("categoryData",result );
		}
		return "product/showInputProduct";
	}

	// 新增产品
	@RequestMapping(value = "forInputProduct", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forInputProduct(MultipartHttpServletRequest mul,Product product, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, MultipartFile> fileMap = mul.getFileMap();
		List<ProductPic> picList = null;
		try {
			picList = UploadImgUtil.upload2(fileMap, "/home/upload/");
			//picList = UploadImgUtil.upload2(fileMap, "D://");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(picList!=null&&picList.size()>0){
			if(picList.get(0).getImg1()!=null){
				product.setProdThumbPic1(picList.get(0).getImg1());
			}
			if(picList.get(0).getImg2()!=null){
				product.setProdThumbPic2(picList.get(0).getImg2());
			}
			product.setPicList(picList);
		}
		map.put("flag", 0);
		if (productService.inputProductObj(product) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}

	// 查询当前产品分类的所有属性
	@RequestMapping(value = "searchPropertyList", method = { RequestMethod.GET,RequestMethod.POST }, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String searchPropertyList(Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer catId = Integer.valueOf(request.getParameter("catId").toString());
			if (catId != null) {
				List<Category> result = productService.searchPropertyList(catId);
				map.put("result", result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toJSONString(map);
	}

	
	// 查询当前产品分类的所有属性
	@RequestMapping(value = "searchPropertyListAll", method = { RequestMethod.GET,RequestMethod.POST }, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String searchPropertyListAll(Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer catId = Integer.valueOf(request.getParameter("catId").toString());
			if (catId != null) {
				List<Category> result = productService.searchPropertyListAll(catId);
				map.put("result", result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toJSONString(map);
	}
	
	
	// 查询当前产品分类的所有属性
	@RequestMapping(value = "searchPropertyObj", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String searchPropertyObj(Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer propId = Integer.valueOf(request.getParameter("propId").toString());
			if (propId != null) {
				ProductProperty result = (ProductProperty) productService.searchPropertyObj(propId);
				map.put("result", result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toJSONString(map);
	}	

	// 查询当前产品分类的所有属性
	@RequestMapping(value = "forInputPropertyObj", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String forInputPropertyObj(Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer catId = Integer.valueOf(request.getParameter("catId").toString());
			String propName = request.getParameter("propName").toString();
			String propType = request.getParameter("propType").toString();
			String propValue = request.getParameter("propValue").toString();
			Integer enabled = Integer.valueOf(request.getParameter("enabled").toString());

			ProductProperty property = new ProductProperty();
			property.setCatId(catId);
			property.setPropName(propName);
			property.setPropType(propType);
			property.setPropValue(propValue);
			property.setEnabled(enabled);
			map.put("result", "err");
			if (property != null) {
				ProductProperty newProperty = productService.inputPropertyObj(property);
				if (newProperty != null) {
					map.put("result", newProperty);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.toJSONString(map);
	}

	// 修改产品
	@RequestMapping(value = "showModifyProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public String showModifyProduct(@Valid Product productObj, HttpServletRequest request, Model model) {
			Product product = productService.searchProductObj(productObj);
			model.addAttribute("product", product);
			if(product.getPicList()!=null && product.getPicList().size()>0){
				model.addAttribute("picSize", product.getPicList().size()+1);
			}else{
				model.addAttribute("picSize", 1);
			}
		return "product/showModifyProduct";
	}

	// 复制产品
	@RequestMapping(value = "showCopyProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public String showCopyProduct(@Valid Product productObj, HttpServletRequest request, Model model) {
			Product product = productService.searchProductObj(productObj);
			model.addAttribute("product", product);
			model.addAttribute("picSize", 1);
		return "product/showCopyProduct";
	}
	
	
	// 复制产品
	@RequestMapping(value = "forInputCopyProduct", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forInputCopyProduct(MultipartHttpServletRequest mul,Product product, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, MultipartFile> fileMap = mul.getFileMap();
		List<ProductPic> picList = null;
		try {
			picList = UploadImgUtil.upload2(fileMap, "/home/upload/");
			//picList = UploadImgUtil.upload2(fileMap, "D://");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(picList!=null&&picList.size()>0){
			if(picList.get(0).getImg1()!=null){
				product.setProdThumbPic1(picList.get(0).getImg1());
			}
			if(picList.get(0).getImg2()!=null){
				product.setProdThumbPic2(picList.get(0).getImg2());
			}
			product.setPicList(picList);
		}
		map.put("flag", 0);
		if (productService.inputProductObj(product) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}
	
	// 修改产品信息
	@RequestMapping(value = "forModifyProduct", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forModifyProduct(MultipartHttpServletRequest mul,Product product, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, MultipartFile> fileMap = mul.getFileMap();
		List<ProductPic> picList = null;
		try {
			picList = UploadImgUtil.upload2(fileMap, "/home/upload/");
			//	picList = UploadImgUtil.upload2(fileMap, "D://");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(picList!=null){
			product.setPicList(picList);
		}
		map.put("flag", 0);
		if (productService.modifyProductObj(product) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}

	// 删除产品分类
	@RequestMapping(value = "forRemoveProduct", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forRemoveProduct(@Valid Product product, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (productService.removeProductObj(product) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}
	
	
	// 删除产品分类
	@RequestMapping(value = "changeProductStatus", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String changeProductStatus(@Valid Model model, HttpServletRequest request) {
		String idStr = request.getParameter("idStr");
		String type = request.getParameter("type");
		String flag = request.getParameter("flag");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (productService.changeProductStatus(idStr,type,flag) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}
	/**
	 * 发布产品模板设置页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/rcms", method = {RequestMethod.GET,RequestMethod.POST})
    public String rcms(Model model,HttpServletRequest request){
		String result = getCategoryTree("");
		if(StringUtils.isNotEmpty(result)){
			model.addAttribute("categoryData",result );
		}
    	return "product/releaseCommoditiesModelSet";
    }
    
	/**
	 * 更新保存类目的产品属性
	 * @param model
	 * @param productProperty
	 * @return
	 */
    @RequestMapping(value = "/saveProductProperty", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String saveProductProperty(Model model,ProductProperty productProperty){
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		
    	List<ProductProperty> list=new ArrayList<ProductProperty>();
    	
    	Integer catId=productProperty.getCatId();
    	String propNameStr=productProperty.getPropName()+"";
    	String propTypeStr=productProperty.getPropType()+"";
    	String propValueStr=productProperty.getPropValue()+"";
    	String propId="";
    	if(StringUtils.isNotEmpty(productProperty.getPropIdStr())){
    		propId=productProperty.getPropIdStr();
    	}
    	
    	String[] propNameArr=propNameStr.split(",");
    	String[] propTypeArr=propTypeStr.split(",");
    	String[] propValueArr=propValueStr.split(",");
    	String[] propIdArr=propId.split(",");
    	
    	int length=propValueArr.length;
    	
    	if(catId!=null){
    		ProductProperty prop=null;
    		for(int i=0;i<propNameArr.length;i++){
        		String propName=propNameArr[i];
        		if(propName!=null && !propName.equals("")){
        			prop=new ProductProperty();
        			prop.setEnabled(1);
        			prop.setCatId(catId);
            		prop.setPropName(propName);
            		prop.setPropType(propTypeArr[i]);
            		if(i<length){//属性值的数组长度可能小于属性名的数组长度
            			prop.setPropValue(propValueArr[i]);
            		}
            		if(i<propIdArr.length){
            			if(StringUtils.isNotEmpty(propIdArr[i])){
                			prop.setPropId(Integer.valueOf(propIdArr[i]));
                		}
            		}
            		list.add(prop);	
        		}     			
        	}
    		for(int i=0;i<list.size();i++){
    			if(list.get(i).getPropId()==null){
    				 productService.inputPropertyObj(list.get(i));
    			}else{
    				 productService.modifyPropertyObj(list.get(i));
    			}
    			map.put("flag", 1);
        	}  		
    	}
		return JSONObject.toJSONString(map);
    }

    
	// 删除产品分类
	@RequestMapping(value = "forRemoveProperty", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forRemoveProperty(@Valid Integer prodId , Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		ProductProperty prop = new ProductProperty();
		prop.setPropId(prodId);
		prop.setEnabled(0);
		if (productService.modifyPropertyObj(prop) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}
    
    
    /**
     * 导出
     * @param
     * @return
     */
    @RequestMapping(value = "/exportProduct", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public void exportProduct(Product product,HttpServletRequest request,HttpServletResponse response){
    	try {
    	
    	   PageList<Product> list = productService.searchProductList(product, new PageBounds());
     	   String fileName = "产品列表";// 需要下载的文件名字
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
					exportService.exportDataToExcel(list,5000,os,"产品列表",excelFileName);
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
    
	// 删除产品分类
	@RequestMapping(value = "forRemovePic", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forRemovePic(@Valid Integer prodId , Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (productService.removeProductPic(prodId) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}
    
	
	
    
}