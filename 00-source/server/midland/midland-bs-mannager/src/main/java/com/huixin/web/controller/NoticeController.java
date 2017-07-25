package com.huixin.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.huixin.core.util.DateUtils;
import com.huixin.web.enums.ContextEnums;
import com.huixin.web.model.Notice;
import com.huixin.web.model.NoticeWithBLOBs;
import com.huixin.web.model.User;
import com.huixin.web.service.NoticeService;
import com.huixin.web.service.SysLogService;

/**
 * 公告 控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

	@Resource
	private NoticeService noticeService;

	@Resource
	private SysLogService sysLogService;

	
	/**
	 * 进入列表搜索页面
	 * @param notice
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/noticeIndex", method = {RequestMethod.GET,RequestMethod.POST})
    public String findNoticeIndex(Notice notice,Model model,HttpServletRequest request){
    	return "notice/noticeIndex";
    }
	
	/**
     * 公告列表查询 
     * @param notice
     * @return
     */
    @RequestMapping(value = "/noticeList", method={RequestMethod.GET, RequestMethod.POST})
    public String selectNoticeList(Notice notice,Model model,HttpServletRequest request){
    	String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")){
			pageNo =ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
    	
		notice.setIsDelete(0);
    	PageList<NoticeWithBLOBs> noticeList=noticeService.selectByExampleAndPage(notice,pageBounds);
    	Paginator paginator = noticeList.getPaginator();
		model.addAttribute("paginator", paginator);
    	
    	model.addAttribute("notices", noticeList);
    	return "notice/noticelist";
    }
    /**
     * 进入公告列表页面
     * @param notice
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/noticeShowIndex", method = {RequestMethod.GET,RequestMethod.POST})
    public String noticeShowIndex(Notice notice,Model model,HttpServletRequest request){
    	return "notice/noticeShowIndex";
    }
    
    /**
     * 显示公告列表
     * @param notice
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/noticeShowList", method={RequestMethod.GET, RequestMethod.POST})
    public String showNoticeList(Notice notice,Model model,HttpServletRequest request,HttpSession session){
    	User user=(User) session.getAttribute("userInfo");
    	String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")){
			pageNo =ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
    	
		notice.setIsDelete(0);
		notice.setIsSend(1);
		if(user!=null){
			if(user.getUserType().compareTo(1)==0){
				notice.setMsgType(2);//渠道商看 应用通知
			}else{
				notice.setMsgType(1);//系统消息
			}
    	}
    	PageList<NoticeWithBLOBs> noticeList=noticeService.selectByExampleAndPage(notice,pageBounds);
    	Paginator paginator = noticeList.getPaginator();
		model.addAttribute("paginator", paginator);
    	
    	model.addAttribute("notices", noticeList);
    	return "notice/noticeShowList";
    }
    
    /**
     * 跳转到新增页面
     * @return
     */
    @RequestMapping(value = "/toAddPage", method={RequestMethod.GET, RequestMethod.POST})
    public String toAddPage(){
    	return "notice/addNotice";
    }
    
    /**
     * 新增公告
     * @param notice
     * @return
     */
    @RequestMapping(value = "/addNotice", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String addNotice(NoticeWithBLOBs notices){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("flag", "0");
    	
    	if(notices.getIsSend()==1
    			&&StringUtils.isEmpty(notices.getSendTime())){
    		notices.setSendTime(DateUtils.nowDateToStringYYMMDDHHmmss());
    	}
    	
    	if(noticeService.addNotice(notices)>0){
    		map.put("flag", "1");
    	}
    	return JSONObject.toJSONString(map);
    }

    /**
     * 查询公告
     * @param notice
     * @return
     */
    @RequestMapping(value = "/findNotice", method={RequestMethod.GET, RequestMethod.POST})
    public String findNotice(Integer id,Model model){
    	if(id!=null){
    		NoticeWithBLOBs noticeInfo = noticeService.findNoticeById(id);
        	model.addAttribute("notice",noticeInfo);
    	}
    	return "notice/noticeInfo";
    }
    /**
     * 公告展示
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/viewNotice", method={RequestMethod.GET, RequestMethod.POST})
    public String viewNotice(Integer id,Model model){
    	if(id!=null){
    		NoticeWithBLOBs noticeInfo = noticeService.findNoticeById(id);
        	model.addAttribute("notice",noticeInfo);
    	}
    	return "notice/viewNotice";
    }
    
    /**
     * 编辑公告
     * @param notice
     * @return
     */
    @RequestMapping(value = "/editNotice", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String updateNotice(NoticeWithBLOBs notice){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("flag", "0");
    	
    	if(notice.getIsSend()==1
    			&&StringUtils.isEmpty(notice.getSendTime())){
    		notice.setSendTime(DateUtils.nowDateToStringYYMMDDHHmmss());
    	}
    	
    	if(noticeService.updateNotice(notice)>0){
    		map.put("flag", "1");
    	}
    	return JSONObject.toJSONString(map);
    }
    
    /**
     * 发布公告
     * @param noticeId
     * @return
     */
    @RequestMapping(value = "/sendNotice", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String sendNotice(Integer noticeId){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("flag", "0");
    	NoticeWithBLOBs notice=new NoticeWithBLOBs();
    	notice.setId(noticeId);
    	notice.setIsSend(1);
    	if(StringUtils.isEmpty(notice.getSendTime())){
    		notice.setSendTime(DateUtils.nowDateToStringYYMMDDHHmmss());
    	}
    	if(noticeService.updateNotice(notice)>0){
    		map.put("flag", "1");
    	}
    	return JSONObject.toJSONString(map);
    	
    }
    /**
     * 删除
     * @param notice
     * @return
     */
    @RequestMapping(value = "/deleteNotice", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String deleteNotice(Integer noticeId){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("flag", "0");
    	NoticeWithBLOBs notice=new NoticeWithBLOBs();
    	notice.setId(noticeId);
    	notice.setIsDelete(1);//删除
    	if(noticeService.updateNotice(notice)>0){
    		map.put("flag", "1");
    	}
    	return JSONObject.toJSONString(map);
    }
    
    /**
     * 置顶
     * @param noticeId
     * @return
     */
    @RequestMapping(value = "/top", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String top(Integer noticeId){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("flag", "0");
    	int n=noticeService.top(noticeId);
    	if(n==1){
    		map.put("flag", "1");
    	}
    	return JSONObject.toJSONString(map);
    }
    
    /**
     * 降级
     * @param noticeId
     * @return
     */
    @RequestMapping(value = "/decline", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String decline(Integer noticeId){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("flag", "0");
    	NoticeWithBLOBs notice=new NoticeWithBLOBs();
    	notice.setId(noticeId);
    	notice.setIsTop(0);;//取消置顶
    	if(noticeService.updateNotice(notice)>0){
    		map.put("flag", "1");
    	}
    	return JSONObject.toJSONString(map);
    }
}
