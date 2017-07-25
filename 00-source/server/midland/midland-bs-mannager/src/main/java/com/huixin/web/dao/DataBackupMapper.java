package com.huixin.web.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.generic.GenericDao;
import com.huixin.web.model.DataBackup;

/**
 * 备份数据记录DAO类
 * 
 * @author kenyyip
 *
 */
public interface DataBackupMapper extends GenericDao<DataBackup, Integer> {

	/**
	 * 根据条件分页查询备份数据记录
	 * 
	 * @param DataBackup
	 *            条件集合参数对象
	 * @param pageBounds
	 *            分页对象
	 * @return PageList<DataBackup>
	 */
	PageList<DataBackup> findByDataBackupAndPage(DataBackup DataBackup, PageBounds pageBounds);

}