package com.huixin.web.controller;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.math.RandomUtils;
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
import com.huixin.core.util.ReadExcel;
import com.huixin.web.enums.ContextEnums;
import com.huixin.web.model.Category;
import com.huixin.web.model.Kctzd;
import com.huixin.web.model.Stock;
import com.huixin.web.service.ProductService;
import com.huixin.web.service.StockService;
import com.huixin.web.service.impl.ExportService;

/**
 * 公共视图控制器
 * 
 * @author jzg
 * 
 **/

@Controller
@RequestMapping(value = "/stock")
public class StockController extends BaseController{
	
	//日志
    public static final Logger logger = LoggerFactory.getLogger(StockController.class);
	
	 @Resource
	 private StockService stockService;
	 
	 @Resource
	 private ProductService productService;
	
	 private final String  excelFileName="exportStock.xls";
	 /***
	  *  --------------------------------- 库存调整单 -------------------------------------  
	  */
	 
	 
	 //进入产品分页首页面
	    @RequestMapping(value ="showKctzdIndex", method = { RequestMethod.GET, RequestMethod.POST })
	    public String showKctzdIndex(Model model, HttpServletRequest request) {
	        return "stock/showKctzdIndex";
	    }
	 
	 
	 //进入产品分页首页面
    @RequestMapping(value ="showKctzdList", method = { RequestMethod.GET, RequestMethod.POST })
    public String showKctzdList(Kctzd searchObj,Model model, HttpServletRequest request) {
    	String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		if (pageSize == null || pageSize.equals("")) {
			pageSize = "10";
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		
		PageList<Kctzd> kctzdList= stockService.searchKctzdList(searchObj,pageBounds);
		Paginator paginator = kctzdList.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("kctzdList", kctzdList);
        return "stock/showKctzdList";
    }
    
    //跳转新增库存调整单页面
    @RequestMapping(value ="showInputKctzd", method = { RequestMethod.GET, RequestMethod.POST })
    public String showInputKctzd(Model model, HttpServletRequest request) {
    	Kctzd kctzd = new Kctzd();
    	String   preix = "TZ";
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        String format1 = format.format(new Date());
        int i = RandomUtils.nextInt(1000);
        String djbh =  preix + format1 + StringUtils.leftPad(i + "", 4, '0');
        kctzd.setDjbh(djbh);
    	kctzd.setPageFlag(0);
    	model.addAttribute("kctzd", kctzd);
        return "stock/showInputKctzd";
    }
    
    
    //跳转修改库存调整单页面
    @RequestMapping(value ="showModifyKctzd", method = { RequestMethod.GET, RequestMethod.POST })
    public String showModifyKctzd(@Valid Kctzd kctzdObj,HttpServletRequest request,Model model) {
		Kctzd kctzd = stockService.searchKctzdObj(kctzdObj);
    	kctzd.setPageFlag(1);
    	model.addAttribute("kctzd", kctzd);
    	model.addAttribute("itemList",kctzd.getItemList());
        return "stock/showInputKctzd";
    }
    
    
    
    
    
    //新增库存调整单
    @RequestMapping(value ="forInputKctzd", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String forInputKctzd(@Valid Kctzd kctzd,Model model, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (stockService.inputKctzdObj(kctzd)> 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
    }
    
    //查看库存调整单
    @RequestMapping(value ="showKctzdDetail", method = { RequestMethod.GET, RequestMethod.POST })
    public String showKctzdDetail(@Valid Kctzd kctzdObj,HttpServletRequest request,Model model) {
		Kctzd kctzd = stockService.searchKctzdObj(kctzdObj);
    	kctzd.setPageFlag(2);
    	model.addAttribute("kctzd", kctzd);
    	model.addAttribute("itemList",kctzd.getItemList());
        return "stock/showInputKctzd";
    }
    
    
    
    //跳转商品列表页面
    @RequestMapping(value ="showInputKctzdItem", method = { RequestMethod.GET, RequestMethod.POST })
    public String showInputKctzdItem(HttpServletRequest request,Model model) {
		String codeStr = request.getParameter("codeStr").toString();
		if(StringUtils.isNotEmpty(codeStr)){
			List prodList = stockService.searchProductByCode(codeStr);
    		model.addAttribute("prodList", prodList);
		}
        return "stock/showInputKctzdItem";
    }
    
    
    //跳转商品列表页面
    @RequestMapping(value ="forRemoveKctzd", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String forRemoveKctzd(Kctzd kctzd,HttpServletRequest request,Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
  		map.put("flag", 0);
  		if (stockService.removeKctzdObj(kctzd)> 0) {
  			map.put("flag", 1);
  		}
      	return JSONObject.toJSONString(map);
    }
    
    
    
    
    //查询当前产品分类的所有属性
    @RequestMapping(value = "searchProductByCode" ,method = { RequestMethod.GET, RequestMethod.POST },produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String searchProductByCode(Model model, HttpServletRequest request) {
    	Map<String, Object> map = new HashMap<String, Object>();
		String codeStr = request.getParameter("codeStr").toString();
		if(StringUtils.isNotEmpty(codeStr)){
			List prodList = stockService.searchProductByCode(codeStr);
			map.put("result", prodList);
		}
        return JSONObject.toJSONString(map);
    }
    
    
    
  //查询当前产品分类的所有属性
    @RequestMapping(value = "searchProduct" ,method = { RequestMethod.GET, RequestMethod.POST },produces = "text/json;charset=UTF-8")
    public String searchProduct(Model model, HttpServletRequest request,String nameStr,String codeStr,String catId) {
		Map<String, Object> map = new HashMap<>();
		map.put("nameStr", nameStr);
		map.put("codeStr", codeStr);
		map.put("catId", catId);
		if(map!=null){
			List prodList = productService.queryProListForMap(map);
			model.addAttribute("result", prodList);
		}
        return "stock/showProductItems";
    }
    
    
    //修改库存调整单
    @RequestMapping(value ="forModifyKctzd", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String forModifyKctzd(@Valid Kctzd kctzdObj,Model model, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (stockService.modifyKctzdObj(kctzdObj) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
    }
    
    
    @RequestMapping(value ="forChangeKctzd", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String forChangeKctzd(@Valid Kctzd kctzdObj,Model model, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (stockService.changeKctzd(kctzdObj) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
    }
    
    /**
     * 库存查询
     * @param model
     * @param request
     * @return
     * lfx 2017-03-21
     */
    @RequestMapping(value ="stockQueryIndex", method = { RequestMethod.GET, RequestMethod.POST })
    public String stockQueryIndex(Model model, HttpServletRequest request) {
		String result = getCategoryTree("");
		if(StringUtils.isNotEmpty(result)){
			model.addAttribute("categoryData",result );
		}
        return "stock/stockQueryIndex";
    }
 
    /**
     * 库存查询列表
     * @param searchObj
     * @param model
     * @param request
     * @return
     * lfx 2017-03-21
     */
    @RequestMapping(value ="stockQueryList", method = { RequestMethod.GET, RequestMethod.POST })
    public String stockQueryList(Stock searchObj,Model model, HttpServletRequest request) {
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null || pageNo.equals("")) {
			pageNo = ContextEnums.PAGENO;
		}
		if (pageSize == null || pageSize.equals("")) {
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		
		PageList<Stock> stockList= stockService.searchStockList(searchObj,pageBounds);
		Paginator paginator = stockList.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("stockList", stockList);
	    return "stock/stockQueryList";
	    
    }

    /**
     * 导出
     * @param
     * @return
     */
    @RequestMapping(value = "/exportStock", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public void exportStock(Stock stock,HttpServletRequest request,HttpServletResponse response){
    	try {
    	
    	   PageList<Stock> list = stockService.searchStockList(stock,new PageBounds());
     	   String fileName = "库存查询";// 需要下载的文件名字
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
					exportService.exportDataToExcel(list,5000,os,"工单",excelFileName);
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
    
    /**
     * 弹出导入文件的页面
     * @return
     */
    @RequestMapping(value = "/toImportPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String toImportPage(){
    	return "stock/importStock";
    }
    
    /**
     * 导入
     * @param req
     * @return
     */
    @RequestMapping(value = "/importStock", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String importStock(MultipartHttpServletRequest req){
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
    	Map<String, MultipartFile> fileMap = req.getFileMap();
    	for (String key : fileMap.keySet()) {
			MultipartFile file = fileMap.get(key);
			String fileName = file.getOriginalFilename();
			
			//进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
	        long size=file.getSize();
	        if(fileName==null || ("").equals(fileName) && size==0)
	        	return JSONObject.toJSONString(map);
	        
	        //创建处理EXCEL
	        ReadExcel readExcel=new ReadExcel();
	        //解析excel，获取对象信息集合。
	        List<Stock> stockList = (List<Stock>) readExcel.getExcelInfo(fileName ,file);
			
	        //批量更新
			int n=stockService.batchUpdateStock(stockList);
			if(n>0){
				map.put("flag", 1);
			}
		}
    	
    	return JSONObject.toJSONString(map);
    }
    
    
	// 删除调整单明细
	@RequestMapping(value = "forRemoveKctzdItem", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String forRemoveKctzdItem(@Valid Integer itemId , Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (stockService.removeKctzdItem(itemId) > 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}
    
    
    
    
}