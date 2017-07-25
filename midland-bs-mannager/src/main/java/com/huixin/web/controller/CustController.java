package com.huixin.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
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
import com.huixin.web.model.Area;
import com.huixin.web.model.Customer;
import com.huixin.web.model.CustomerAddress;
import com.huixin.web.model.CustomerProperty;
import com.huixin.web.model.OrderInfo;
import com.huixin.web.model.Region;
import com.huixin.web.model.User;
import com.huixin.web.service.CustService;
import com.huixin.web.service.OrderInfoService;
import com.huixin.web.service.SysLogService;
import com.huixin.web.service.UserService;

/**
 * 客户管理 控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/cust")
public class CustController {
	@Resource
	private CustService custService;

	@Resource
    private UserService userService;
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Resource
	private SysLogService sysLogService;
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	String picPath=File.separator+"home"+File.separator+"upload"+File.separator;

	@RequestMapping(value = "/areaIndex", method = {RequestMethod.GET,RequestMethod.POST})
	public String areaIndex(Area area,Model model,HttpServletRequest request){
		return "cust/areaIndex";
	}

	@RequestMapping(value = "/custIndex", method = {RequestMethod.GET,RequestMethod.POST})
	public String custIndex(Customer cust,Model model,HttpServletRequest request,HttpServletResponse response){

		response.setCharacterEncoding("UTF-8"); // encoding为utf-8  
		response.setContentType("text/html; charset=utf-8"); 
		Area area=new Area();
		area.setIsShow(1);
		List<Area> areas=custService.queryAreas(area);
		model.addAttribute("areas", areas);
		return "cust/custIndex";
	}

	/**
	 * 区域 列表条件分页查询
	 * @param area
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/areaList", method={RequestMethod.GET, RequestMethod.POST})
	public String selectAreaList(Area area,Model model,HttpServletRequest request){
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));

		area.setIsShow(1);//有效的
		PageList<Area> areaList=custService.selectAreaByExampleAndPage(area,pageBounds);
		Paginator paginator = areaList.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("areas", areaList);
		return "cust/arealist";
	}

	/**
	 * 客户 列表条件分页查询
	 * @param cust
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/custList", method={RequestMethod.GET, RequestMethod.POST})
	public String selectCustList(Customer cust,Model model,HttpServletRequest request){
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		
		PageList<Customer> custList=custService.selectCustByExampleAndPage(cust,pageBounds);

		Paginator paginator = custList.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("custs", custList);

		return "cust/custlist";
	}

	/**
	 * 跳转到区域新增页面
	 * @return
	 */
	@RequestMapping(value = "/toAddAreaPage", method = {RequestMethod.GET,RequestMethod.POST})
	public String toAddAreaPage(){

		return "cust/addArea";
	}

	/**
	 * 跳转到客户新增页面
	 * @return
	 */
	@RequestMapping(value = "/toAddCustPage", method = {RequestMethod.GET,RequestMethod.POST})
	public String toAddCustPage(Model model){
		Customer cust=new Customer();
		cust.setCustParentId(0);
		cust.setStatus(1);
		List<Customer> custParentList=custService.queryCustList(cust);//查询所有一级客户
		
		Area area=new Area();
		area.setIsShow(1);
		List<Area> areas=custService.queryAreas(area);
		List<CustomerProperty> enterAttrs=custService.queryCustomerPropertyByType(1);//查找经营性质的属性值
		List<CustomerProperty> enterProds=custService.queryCustomerPropertyByType(2);//查找经营产品的属性值
		List<Region> provinces =custService.selectRegionByParentId(1);// 先获取省份下拉框列表
		
		model.addAttribute("areas", areas);
		model.addAttribute("custParentList", custParentList);
		model.addAttribute("enterAttrs", enterAttrs);
		model.addAttribute("enterProds", enterProds);
		model.addAttribute("provinces", provinces);
		return "cust/addCust";
	}

	/**
	 * 通过父级id查找下级地区
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/seleAddress",produces = "application/json; charset=UTF-8", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	private String getRegionByPerentId(Integer pid) throws Exception {
		if (pid == null) {pid = 1;}

		List<Region> result = custService.selectRegionByParentId(pid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return JSONObject.toJSONString(map);
	}

	/**
	 * 新增保存区域
	 * @return
	 */
	@RequestMapping(value = "/addArea", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String addArea(Area area){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", "0");
		if(custService.insertArea(area)>0){
			map.put("flag", "1");
		}
		return JSONObject.toJSONString(map);
	}
	
	/**
	 * 检查区域名称唯一性
	 * @param areaName
	 * @return
	 */
	@RequestMapping(value = "/checkAreaName", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String checkAreaNameUnique(String areaName){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", "0");
		Area area=new Area();
		area.setAreaName(areaName);
		area.setIsShow(1);
		List<Area> areaList=custService.queryAreas(area);
		if(areaList!=null&&areaList.size()>0){
			map.put("flag", "1");
		}
		return JSONObject.toJSONString(map);
	}
	
	/**
	 * 新增保存客户
	 * @return
	 */
	@RequestMapping(value = "/addCust", method = {RequestMethod.GET,RequestMethod.POST})
	public String addCust(Customer cust,CustomerAddress custAddr,MultipartHttpServletRequest req){
		String path=null;
		Map<String, MultipartFile> fileMap = req.getFileMap();
		if(fileMap!=null){
			for (String key : fileMap.keySet()) {
				MultipartFile file = fileMap.get(key);
				if(file!=null && file.getSize()>0){
					path=UploadImgUtil.uploadImgFile(file,picPath);
				}
			}
		}
		cust.setBusinessLicensePic(path);
		cust.setCustCode(this.createCustCode(cust.getCustType(), cust.getDistType(), custAddr.getRegionSn()));
		
		if(cust.getCustType().compareTo(2)==0&&cust.getCustParentId()!=null){
			Customer c=custService.findCustById(cust.getCustParentId());
			cust.setAreaId(c.getAreaId());
		}
		cust.setCustPhone(custAddr.getContactPhone());
		custService.addCustomer(cust,custAddr);
		userService.addUser(this.custToUser(cust));//保存到用户表
		return "cust/custIndex";
	}
	
	/**
	 * 产生客户编号
	 * 客户代码规则					
		渠道服务商（每类渠道服务商不超过99个）				
			直属销售服务分公司		VOXA01~VOXA99	
			股东省区渠道服务商		VOXB01~VOXB99	
			普通省区渠道服务商		VOXC01~VOXC99	
			4S店渠道服务商			VOXD01~VOXD99
		终端服务商（每个省999个）				
			V+省区简写（两位）+数字（三位）			
			比如广东，则：VGD001~VGD999			
			查看省区简写对照表	
	 * @param custType
	 * @param classified
	 * @return
	 */
	private String createCustCode(Integer custType,String classified,String regionSn){
		String custCode="";
		String numberMax="";
		String key="";
		
		if(custType.compareTo(1)==0){
			key=classified;
		}else{
			key="V"+regionSn;
		}
		BoundValueOperations<String, Object> vo = redisTemplate.boundValueOps(key);
		numberMax=(String) vo.get();
		if(StringUtils.isEmpty(numberMax)){
			numberMax="01";
		}else{
			numberMax=String.valueOf(Integer.valueOf(numberMax)+1);
			if(numberMax.length()==1){
				numberMax="0"+numberMax;
			}
		}
		vo.set(numberMax);
		custCode=key+numberMax;
		
		Customer cust=new Customer();
		cust.setCustCode(custCode);
		List<Customer> list=custService.queryCustList(cust);
		if(list!=null&&list.size()>0){//防止redis上最大值与数据库不一致
			custCode=this.createCustCode(custType,classified,regionSn);
		}
		
		return custCode;
	}
	
	/**
	 * 客户信息对象转换到用户信息对象
	 * @param cust
	 * @return
	 */
	private User custToUser(Customer cust){
		User user=new User();
		if(cust!=null){
			user.setUsername(cust.getCustCode());
			user.setUserCnName(cust.getCustName());
			user.setUserType(cust.getCustType());
			user.setPhone(cust.getCustPhone());
			user.setEmail(cust.getCustEmail());
		}
		return user;
	}
	
	/**
	 * 检查客户唯一性
	 * @param custCode
	 * @return
	 */
	@RequestMapping(value = "/checkUnique", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String checkCustUnique(Customer cust){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", "0");
		List<Customer> list=new ArrayList<Customer>();
		if(cust!=null){
			list=custService.queryCustList(cust);
		}
		
		if(list!=null&&list.size()>0){
			map.put("flag", "1");
		}
		return JSONObject.toJSONString(map);
	}
	/**
	 * 检查手机号唯一性
	 * @param cust
	 * @return
	 */
	@RequestMapping(value = "/checkPhoneUnique", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String checkPhoneUnique(String contactPhone){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", "0");
		List<CustomerAddress> list=new ArrayList<CustomerAddress>();
		if(contactPhone!=null){
			CustomerAddress custAddr=new CustomerAddress();
			custAddr.setContactPhone(contactPhone);
			list=custService.queryCustAddrByCustAddr(custAddr);
		}
		if(list!=null&&list.size()>0){
			map.put("flag", "1");
		}
		return JSONObject.toJSONString(map);
	}

	
	/**
	 * 查找区域
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findArea", method = {RequestMethod.GET,RequestMethod.POST})
	public String findArea(Model model,HttpServletRequest request){
		Integer areaId=StringUtils.isEmpty(request.getParameter("areaId"))?-1:Integer.valueOf(request.getParameter("areaId"));
		Area areaInfo = custService.findAreaById(areaId);
		model.addAttribute("area",areaInfo);
		return "cust/areaInfo";
	}

	/**
	 * 编辑保存区域
	 * @param area
	 * @return
	 */
	@RequestMapping(value = "/editArea", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String updateArea(Area area){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", "0");
		if(custService.updateArea(area)>0){
			map.put("flag", "1");
		}
		return JSONObject.toJSONString(map);
	}

	/**
	 * 查找客户
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findCust", method = {RequestMethod.GET,RequestMethod.POST})
	public String findCust(Model model,HttpServletRequest request){
		Integer custId=StringUtils.isEmpty(request.getParameter("custId"))?-1:Integer.valueOf(request.getParameter("custId"));
		Customer custInfo = custService.findCustById(custId);//获取客户信息对象
		List<CustomerAddress> custAddrs=custService.findCustAddrByCustId(custId);//获取客户地址信息
		CustomerAddress custAddr=null;
		if(custAddrs!=null && custAddrs.size()>0){
			custAddr=custAddrs.get(0);
		}
		Area area=new Area();
		area.setIsShow(1);
		List<Area> areas=custService.queryAreas(area);//区域选项
		List<CustomerProperty> enterAttrs=custService.queryCustomerPropertyByType(1);//查找经营性质的属性值
		List<CustomerProperty> enterProds=custService.queryCustomerPropertyByType(2);//查找经营产品的属性值
		List<Region> result =custService.selectRegionByParentId(1);// 先获取省份下拉框列表
		List<Region> resultcity =null;
		if(custAddr!=null && custAddr.getProvinceId()!=null){
			resultcity =custService.selectRegionByParentId(custAddr.getProvinceId());// 获取市下拉框列表
		}
		List<Region> resultdist =null;
		if(custAddr!=null && custAddr.getCityId()!=null){
			resultdist =custService.selectRegionByParentId(custAddr.getCityId());// 获取区下拉框列表
		}
		
		String prods=custInfo.getEnterProd();//经营产品拆分到list
		List<String> custProds=null;
		if(prods!=null){
			String[] s = prods.split(",");
			custProds=Arrays.asList(s);
		}
		
		Customer cust=new Customer();
		cust.setCustParentId(0);
		cust.setStatus(1);
		List<Customer> custParentList=custService.queryCustList(cust);//查询所有一级客户
		
		String distType="";//渠道服务商分类
		try {
			if(custInfo.getCustType().compareTo(1)==0){
				distType=custInfo.getCustCode().substring(0,4);
			}else{
				distType=custInfo.getCustCode().substring(0,3);
			}
			custInfo.setDistType(distType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		model.addAttribute("areas", areas);
		model.addAttribute("enterAttrs", enterAttrs);
		model.addAttribute("enterProds", enterProds);
		model.addAttribute("result", result);
		model.addAttribute("resultcity", resultcity);
		model.addAttribute("resultdist", resultdist);
		model.addAttribute("custParentList", custParentList);
		
		model.addAttribute("cust",custInfo);
		model.addAttribute("custProds",custProds);
		model.addAttribute("custAddr",custAddr);
		return "cust/custInfo";
	}
	
	/**
	 * 条件查询客户list
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryCustList",produces = "application/json; charset=UTF-8", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String queryCustList(Model model,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		
		Customer cust=new Customer();
		cust.setCustParentId(0);//查询所有一级客户
		cust.setStatus(1);
		List<Customer> custParentList=custService.queryCustList(cust);
		map.put("custParentList", custParentList);
		return JSONObject.toJSONString(map);
	}

	/**
	 * 编辑客户保存
	 * @param cust
	 * @param custAddr
	 * @return
	 */
	@RequestMapping(value = "/editCust", method = {RequestMethod.GET,RequestMethod.POST})
	public String updateCust(Customer cust,CustomerAddress custAddr,MultipartHttpServletRequest req){
		String path=null;//图片保存路径名
		Map<String, MultipartFile> fileMap = req.getFileMap();
		if(fileMap!=null){
			for (String key : fileMap.keySet()) {
				MultipartFile file = fileMap.get(key);
				if(file!=null && file.getSize()>0){
					path=UploadImgUtil.uploadImgFile(file,picPath);
				}
				
			}
		}
		cust.setBusinessLicensePic(path);
		custService.updateCustomer(cust,custAddr);
		return "cust/custIndex";
	}

	/**
	 * 删除区域
	 * @param area
	 * @return
	 */
	@RequestMapping(value = "/deleteArea", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String deleteArea(Integer areaId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", "0");
		Area area=new Area();
		area.setAreaId(areaId);
		area.setIsShow(0);//删除
		if(custService.updateArea(area)>0){
			map.put("flag", "1");
		}
		return JSONObject.toJSONString(map);
	}
	
	/**
     * 检查区域是否已被客户使用
     * @param noticeId
     * @return
     */
    @RequestMapping(value = "/check", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String isEmploy(Integer areaId){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("flag", "0");
    	int n=custService.checkAreaIsEmploy(areaId);
    	if(n>0){
    		map.put("flag", "1");
    	}
    	return JSONObject.toJSONString(map);
    }
	
	/**
	 * 删除客户
	 * @param area
	 * @return
	 */
	@RequestMapping(value = "/deleteCust", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String deleteCust(Integer custId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", "0");
		Customer cust=new Customer();
		cust.setCustId(custId);
		cust.setStatus(3);
		if(custService.deleteCustomer(cust)>0){
			map.put("flag", "1");
		}
		return JSONObject.toJSONString(map);
	}
	
	/**
	 * 检查客户是否被使用
	 * @return
	 */
	@RequestMapping(value = "/checkCustIsEmploy", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String checkCustIsEmploy(Integer custId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", "0");
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setCustId(custId);
		List<OrderInfo> list=orderInfoService.searchOrderInfoList(orderInfo,new PageBounds());
		Customer cust=new Customer();
		cust.setCustType(2);
		cust.setCustParentId(custId);
		List<Customer> custLit = custService.queryCustList(cust);
		if((list!=null&&list.size()>0) || (custLit!=null && custLit.size()>0)){
			map.put("flag", "1");
		}
		return JSONObject.toJSONString(map);
	}
}
