package com.huixin.web.controller;
import java.io.IOException;
import java.util.HashMap;
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
import com.huixin.web.model.Activity;
import com.huixin.web.model.User;
import com.huixin.web.service.ActivityService;

@Controller
@RequestMapping(value = "/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	private static Logger logger = Logger.getLogger(ActivityController.class);

	/**
	 * 
	 * @param model
	 * @param request
	 * @param classes
	 *            进行数据绑定
	 * @return 返回页面 查询活动列表
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String activityIndex(Model model, HttpServletRequest request, Activity activity) {
		return "activity/activityIndex";

	};
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String findActivityList(Model model, HttpServletRequest request, Activity activity) {
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		PageList<Activity> activityList =  activityService.selectActivityList(activity,pageBounds);
		Paginator paginator = activityList.getPaginator();
		model.addAttribute("activityList", activityList);
		model.addAttribute("paginator", paginator);
		return "activity/activityList";

	};
	
	/**
	 * 进入发布活动页面
	 * @param model
	 * @param request
	 * @param activity
	 * @return
	 */
	@RequestMapping(value = "/enterActivity", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterActivity(Model model, HttpServletRequest request, Activity activity) {
		return "activity/addActivity";

	};
	
	/**
	 * 保存活动
	 * @param model
	 * @param request
	 * @param activity
	 * @return
	 */
	@RequestMapping(value = "/addActivity", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String addActivity(MultipartHttpServletRequest mul, Model model, HttpServletRequest request, Activity activity) throws IOException {
		Map<String,Object> map = new HashMap<>();
		Map<String, MultipartFile> fileMap = mul.getFileMap();
		Map<String,String> pathList = UploadImgUtil.upload(fileMap, "/home/upload/");
		if(pathList!=null&&pathList.size()>0){
			activity.setActi_thumb_pic1(pathList.get("file1"));
			activity.setActi_thumb_pic2(pathList.get("file2"));
		}
	   	HttpSession session = request.getSession();
	   	User user=(User) session.getAttribute("userInfo");
	   	activity.setUserBy(user.getUsername());
		Integer num = activityService.insertActivity(activity);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);

	};
	
	/**
	 * 进入编辑活动页面
	 * @param model
	 * @param request
	 * @param activity
	 * @return
	 */
	@RequestMapping(value = "/enterEditActivity", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterEditActivity(Model model, HttpServletRequest request, Activity activity) {
		Activity activitys = activityService.selectActivity(activity);
		model.addAttribute("activity", activitys);
		return "activity/editActivity";

	};
	/**
	 * 保存活动页面
	 * @param model
	 * @param request
	 * @param activity
	 * @return
	 */
	@RequestMapping(value = "/saveEditActivity", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveEditActivity(MultipartHttpServletRequest mul,Model model, HttpServletRequest request, Activity activity) throws IOException {
		Map<String, MultipartFile> fileMap = mul.getFileMap();
		Map<String,String> pathList = UploadImgUtil.upload(fileMap, "/home/upload/");
		if(pathList!=null&&pathList.size()>0){
			activity.setActi_thumb_pic1(pathList.get("file1"));
			activity.setActi_thumb_pic2(pathList.get("file2"));
		}
		Integer num = activityService.updateActivity(activity);
		return "redirect:index";

	};
	/**
	 * 删除活动
	 * @param model
	 * @param request
	 * @param activity
	 * @return
	 */
	@RequestMapping(value = "/deleteActivity", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String deleteActivity(Model model, HttpServletRequest request, Activity activity) {
		Map<String,Object> map = new HashMap<>();
		Integer num = activityService.deleteActivity(activity);
		if(num>0){
			map.put("result", "ok");
		}else{
			map.put("result", "error");
		}
		return JSONObject.toJSONString(map);

	};
	
	
	
	

}
