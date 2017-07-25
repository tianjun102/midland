package com.huixin.web.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.SysLog;

public interface SysLogService   {
	
	/**
	 * 新增日志
	 * @param sysLog
	 * @return
	 */
	int crateSysLog(SysLog sysLog);
	
	/**
	 * 获取日志信息列表
	 * @param sysLog
	 * @return
	 */
	List<SysLog> selectSysLogList(SysLog sysLog);
	
	/**
	 * 获取对象信息
	 * @param sysLogId
	 * @return
	 */
	SysLog selectById(Integer sysLogId);

	/**
	 * 分页列表条件查询
	 * @param pageBounds
	 * @param sysLog
	 * @return
	 */
	PageList<SysLog> selectByExampleAndPage(PageBounds pageBounds, SysLog sysLog);

}
