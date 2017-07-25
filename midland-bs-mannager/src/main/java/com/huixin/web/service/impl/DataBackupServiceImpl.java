package com.huixin.web.service.impl;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.backup.MySQLDatabaseBackup;
import com.huixin.core.util.DateUtils;
import com.huixin.web.dao.DataBackupMapper;
import com.huixin.web.model.DataBackup;
import com.huixin.web.service.DataBackupService;

/**
 * 备份数据记录业务逻辑实现类
 * @author kenyyip
 *
 */
@Service
public class DataBackupServiceImpl implements DataBackupService {

	private static Logger logger = Logger.getLogger(DataBackupServiceImpl.class);

	@Autowired
	private DataBackupMapper dataBackupMapper;

	/** 备份数据库IP */
	@Value("${backup.mysql.hostIP}")
	private String hostIP;

	/** 备份数据库用户名 */
	@Value("${backup.mysql.userName}")
	private String userName;

	/** 备份数据库密码 */
	@Value("${backup.mysql.password}")
	private String password;

	/** 备份数据库指定路径 */
	@Value("${backup.mysql.backupPath}")
	private String backupPath;

	/** mysql备份/还原执行命令绝对路径 */
	@Value("${mysql.run.path}")
	private String runPath;

	/** 备份数据库名称 */
	@Value("${backup.mysql.database.name}")
	private String databaseName;

	@Override
	public int backupDatabase(Integer userId) throws Exception {

		//定义临时返回值变量
		int i = 0;
		
		// 备份文件名称
		String fileName = databaseName + "_" + DateUtils.formatDateToString(DateUtils.nowDate(),DateUtils.FORMAT_YYYYMMDDHHMMSS) + ".sql";

		logger.info("准备数据库备份...");

		boolean bool = MySQLDatabaseBackup.databaseBackup(hostIP, userName, password, backupPath, fileName, databaseName, runPath);

		logger.info("数据库备份结束。");

		if (bool) {
			
			DataBackup record = new DataBackup();
			
			record.setCreateTime(DateUtils.nowDate());
			record.setPath(backupPath + fileName);
			record.setUserId(userId);

			i = dataBackupMapper.insertSelective(record);

		} else {
			String msg = "数据库备份出现异常!!";
			logger.error(msg);
			throw new Exception(msg);
		}
		return i;
	}

	@Deprecated
	@Override
	public int restoreDatabase(Integer id) throws Exception {
		
		//定义临时返回值变量
		int i = 0;
		
		DataBackup record = dataBackupMapper.selectByPrimaryKey(id);
		
		logger.info("准备数据库还原...");

		boolean bool = MySQLDatabaseBackup.databaseRestore(hostIP, userName, password, record.getPath(), databaseName, runPath);

		logger.info("数据库还原结束。");
		
		if(bool){
			
			record.setRestoreTime(DateUtils.nowDate());
			i = dataBackupMapper.updateByPrimaryKeySelective(record);
			
		} else {
			throw new Exception("数据库还原出现异常!!");
		}
		return i;
	}

	@Override
	public PageList<DataBackup> findByDataBackupAndPage(DataBackup DataBackup, PageBounds pageBounds) {
		return dataBackupMapper.findByDataBackupAndPage(DataBackup, pageBounds);
	}

	@Override
	public int deleteById(Integer id) {
		int result = 0;
		DataBackup dataBackup = dataBackupMapper.selectByPrimaryKey(id);
		String path = dataBackup.getPath();
		
		boolean bool = FileUtils.deleteQuietly(new File(path));
		if(bool)
			result= dataBackupMapper.deleteByPrimaryKey(id);
		return result;
	}

}
