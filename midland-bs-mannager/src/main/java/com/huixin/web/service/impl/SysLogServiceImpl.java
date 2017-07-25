package com.huixin.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.util.DateUtils;
import com.huixin.web.dao.SysLogMapper;
import com.huixin.web.model.SysLog;
import com.huixin.web.service.SysLogService;

@Service
public class SysLogServiceImpl  implements SysLogService{

	@Resource
	private SysLogMapper sysLogMapper;

	
	@Override
	public int crateSysLog(SysLog sysLog) {
		if(sysLog!=null){
			if(StringUtils.isEmpty(sysLog.getAddTime())){
				sysLog.setAddTime(DateUtils.nowDateToStringYYMMDDHHmmss());
			}
		}
		return sysLogMapper.insert(sysLog);
	}
	

	public List<SysLog> selectSysLogList(SysLog sysLog) {

		List<SysLog> list=sysLogMapper.selectByExample(sysLog);
		return list;
	}

	@Override
	public SysLog selectById(Integer sysLogId) {
		return sysLogMapper.selectByPrimaryKey(sysLogId);
	}


	@Override
	public PageList<SysLog> selectByExampleAndPage(PageBounds pageBounds, SysLog sysLog) {
		
		return sysLogMapper.selectByExampleAndPage(pageBounds, sysLog);
	}


}
