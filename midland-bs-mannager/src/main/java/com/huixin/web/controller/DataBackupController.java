package com.huixin.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.DataBackup;
import com.huixin.web.model.User;
import com.huixin.web.service.DataBackupService;

/**
 * 数据备份Controller类
 * @author kenyyip
 *
 */
@Controller
@RequestMapping(value = "/dataBackup")
public class DataBackupController {

	private static Logger logger = Logger.getLogger(DataBackupController.class);

	@Autowired
	private DataBackupService dataBackupService;

	/**
	 * 加载数据备份列表条件页面
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String toList() {
		return "backup/backupIndex";
	}

	/**
	 * 加载数据备份列表页面
	 * 
	 * @param model
	 *            Model
	 * @param request
	 *            HttpServletRequest
	 * @param dataBackup
	 *            条件参数集合
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String list(Model model, HttpServletRequest request, DataBackup dataBackup) {

		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");

		if (StringUtils.isBlank(pageNo)) {
			pageNo = "1";
		}
		if (StringUtils.isBlank(pageSize)) {
			pageSize = "3";
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		PageList<DataBackup> pageList = dataBackupService.findByDataBackupAndPage(dataBackup, pageBounds);
		model.addAttribute("paginator", pageList.getPaginator());
		model.addAttribute("pageList", pageList);

		return "backup/backupList";
	}

	/**
	 * 根据ID删除备份数据记录
	 * @param id 备份数据记录ID
	 * @return String
	 */
	@RequestMapping(value = "/delete", method = { RequestMethod.GET })
	@ResponseBody
	public String delete(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", 0);
		int i = dataBackupService.deleteById(id);
		if(i==1){
			map.put("flag", 1);
		}
		return JSONObject.toJSONString(map);
	}

	/**
	 * 执行数据库备份
	 * @param request HttpServletRequest
	 * @return String
	 */
	@RequestMapping(value = "/backup", method = { RequestMethod.GET })
	public String backup(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");
		try {
			dataBackupService.backupDatabase(user.getId());
		} catch (Exception e) {
			logger.error("数据库备份时出现异常！", e);
		}
		return "backup/backupIndex";
	}

	/**
	 * 数据还原
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@Deprecated
	@RequestMapping(value = "/restore", method = { RequestMethod.POST })
	public String restore(Integer id) {
		try {
			dataBackupService.restoreDatabase(id);
		} catch (Exception e) {
			logger.error("数据库还原时出现异常！", e);
		}
		return "dataBackup/list";
	}
}
