package com.huixin.web.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.DataBackup;

/**
 * 备份数据记录业务逻辑接口类
 * @author kenyyip
 *
 */
public interface DataBackupService {
	
	/**
	 * 根据ID删除指定备份数据记录
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id);

	/**
	 * 数据库备份并对数据库插入备份记录
	 * 
	 * @param userId
	 *            用户ID
	 * @return int
	 * @throws Exception
	 */
	public int backupDatabase(Integer userId) throws Exception;

	/**
	 * 数据库还原并对数据库备份记录更改
	 * 
	 * @param id
	 *            数据库备份记录ID
	 */
	@Deprecated
	public int restoreDatabase(Integer id) throws Exception;
	
	public PageList<DataBackup> findByDataBackupAndPage(DataBackup DataBackup, PageBounds pageBounds);
}
