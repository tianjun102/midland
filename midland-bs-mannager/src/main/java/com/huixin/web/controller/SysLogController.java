package com.huixin.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.huixin.web.enums.ContextEnums;
import com.huixin.web.model.SysLog;
import com.huixin.web.model.User;
import com.huixin.web.service.SysLogService;

/**
 * 日志 控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/sysLog")
public class SysLogController {

	@Resource
	private SysLogService sysLogService;

	
	@RequestMapping(value = "/sysLogIndex", method = {RequestMethod.GET,RequestMethod.POST})
    public String findsysLogIndex(User user,Model model,HttpServletRequest request){
    	return "syslog/sysLogIndex";
    }
	
	/**
	 * 日志列表 分页条件查询
	 * @param sysLog
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sysLogList", method={RequestMethod.GET, RequestMethod.POST})
	public String selectSysLogList(SysLog sysLog,Model model,HttpServletRequest request){
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		

    	PageList<SysLog> sysLogList=sysLogService.selectByExampleAndPage(pageBounds,sysLog);
    	Paginator paginator = sysLogList.getPaginator();
    	
    	model.addAttribute("paginator", paginator);
		model.addAttribute("sysLogs", sysLogList);
		return "syslog/sysloglist";
	}


	@RequestMapping(value = "/findSysLog", method={RequestMethod.GET, RequestMethod.POST})
    public String findSysLog(Model model,HttpServletRequest request){
    	Integer sysLogId=Integer.valueOf(request.getParameter("logId"));
    	SysLog sysLog = sysLogService.selectById(sysLogId);
    	model.addAttribute("sysLog",sysLog);
    	return "syslog/sysLogInfo";
    }
}
