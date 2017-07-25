package com.huixin.web.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.SysLog;

public interface SysLogMapper {
	
	int insert(SysLog record);
	
	int updateByPrimaryKey(SysLog record);
	
	List<SysLog> selectByExample(SysLog record);
	
	SysLog selectByPrimaryKey(Integer sysLogId);

	/**
     * 分页条件查询
     * 
     * @param page
     * @param example
     * @return
     */
	PageList<SysLog> selectByExampleAndPage(PageBounds pageBounds, SysLog example);
}
