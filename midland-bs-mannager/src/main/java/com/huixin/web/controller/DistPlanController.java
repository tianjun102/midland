package com.huixin.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.huixin.web.model.DistPlan;
import com.huixin.web.model.DistPlanCustomer;
import com.huixin.web.model.DistPlanProduct;
import com.huixin.web.service.DistPlanService;

/**
 * 公共视图控制器
 * 
 * @author jzg
 * 
 **/

@Controller
@RequestMapping( value = "/distPlan")
public class DistPlanController {
	
	 @Resource
	 private DistPlanService distPlanService;
	
    	
	 /***
	  *  --------------------------------- 分销方案 -------------------------------------  
	  */
	 
	 //进入分销方案 首页面
    @RequestMapping(value = "showDistPlanIndex", method = { RequestMethod.GET, RequestMethod.POST })
    public String showDistPlanIndex(Model model, HttpServletRequest request) {
        return "distPlan/showDistPlanIndex";
   }
	 
	 
	 //进入分销方案 首页面
    @RequestMapping(value = "showDistPlanList", method = { RequestMethod.GET, RequestMethod.POST })
    public String showDistPlanList(DistPlan searchObj, Model model, HttpServletRequest request) {
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		if (pageSize == null || pageSize.equals("")) {
			pageSize = "10";
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		
		PageList<DistPlan> distPlanList=distPlanService.searchDistPlanList(searchObj,pageBounds);
		Paginator paginator = distPlanList.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("distPlanList", distPlanList);
        return "distPlan/showDistPlanList";
    }
    
    //跳转新增分销方案页面
    @RequestMapping(value = "showInputDistPlan", method = { RequestMethod.GET, RequestMethod.POST })
    public String showInputDistPlan(Model model, HttpServletRequest request) {
    		DistPlan distplan = new DistPlan();
	    	String   preix = "FX";
	        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
	        String format1 = format.format(new Date());
	        int i = RandomUtils.nextInt(1000);
	        String distPlanSn =  preix + format1 + StringUtils.leftPad(i + "", 4, '0');
	        distplan.setDistPlanSn(distPlanSn);
	    	model.addAttribute("distplan", distplan);
        	String catProData = encapsulateTree(distPlanService.searchCatProForList(),null,null);
        	String areaCustData = encapsulateTree(distPlanService.searchAreaCustForList(),null,null);
    		model.addAttribute("catProData", catProData);
    		model.addAttribute("areaCustData", areaCustData);
        return "distPlan/showInputDistPlan";
    }
    
    
    //新增分销方案
    @RequestMapping(value = "forInputDistPlan", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String forInputDistPlan(@Valid DistPlan distplan,Model model, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (distPlanService.inputDistPlanObj(distplan)> 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
    }
    
    
    //跳转修改分销方案页面
    @RequestMapping(value = "showModifyDistPlan", method = { RequestMethod.GET, RequestMethod.POST })
    public String showModifyDistPlan(@Valid DistPlan distplanObj,HttpServletRequest request,Model model) {
		DistPlan distplan =(DistPlan) distPlanService.searchDistPlanObj(distplanObj);
		String catProData = encapsulateTree(distPlanService.searchCatProForList(),distplan.getCustList(),"prod");
    	String areaCustData = encapsulateTree(distPlanService.searchAreaCustForList(),distplan.getProList(),"cust");
		model.addAttribute("catProData", catProData);
		model.addAttribute("areaCustData", areaCustData);
		model.addAttribute("distplan", distplan);
        return "distPlan/showModifyDistPlan";
    }
    
    
    //修改分销方案
    @RequestMapping(value = "forModifyDistPlan", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String forModifyDistPlan(@Valid DistPlan distplanObj,Model model, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (distPlanService.modifyDistPlanObj(distplanObj)> 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
    }
    
    
    //删除分销方案
    @RequestMapping(value = "forRemoveDistPlan", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String forRemoveDistPlan(@Valid DistPlan distplanObj,Model model, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		if (distPlanService.removeDistPlanObj(distplanObj)> 0) {
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
    }

    
   
    
    private String encapsulateTree(List<Map<String, Object>> list,List showList,String type) {
		// 避免数据库中存在换行符,进行菜单文字的过滤
		//String replaceStr = "(\r\n|\r|\n|\n\r)";
		StringBuffer ret = new StringBuffer("");
		
		if(list!=null){
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object>  map = list.get(i);
				ret.append("{id:").append(map.get("id")).append(", pId:").append(map.get("parentId")).append(", name:'")
				.append(map.get("showName")).append("',sid:").append(map.get("sid")).append(",type:").append(map.get("type"));
				if("0".equals(map.get("type").toString())){
					ret.append(",open:true");
					if(Integer.valueOf(map.get("countNum").toString())==0){
						ret.append(",nocheck:true");
					}
				}
				if(showList!=null){
					if("cust".equals(type)){
						for (int j = 0; j < showList.size(); j++) {
							String sid = map.get("sid").toString();
							DistPlanCustomer cust = (DistPlanCustomer) showList.get(j);
							if(sid.equals(cust.getCustId().toString())){
								ret.append(",checked:true");
							}
						}
					}else{
						for (int j = 0; j < showList.size(); j++) {
							String sid = map.get("sid").toString();
							DistPlanProduct prod = (DistPlanProduct) showList.get(j);
							if(sid.equals(prod.getProdId().toString())){
								ret.append(",checked:true");
							}
						}
					}
				}
				ret.append("},");
			}
		}
		return ret.substring(0, ret.length() - 1);
	}
   
}