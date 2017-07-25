package com.huixin.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 备份数据记录Model类
 * @author kenyyip
 *
 */
public class DataBackup implements Serializable {

	private static final long serialVersionUID = 1L;

	/** ID标识 */
	private Integer id;

	/** 备份文件绝对路径 */
    private String path;

    /** 创建时间 */
    private Date createTime;

    /** 用户ID */
    private Integer userId;

    /** 还原时间 */
    private Date restoreTime;
    
    /** 用户名(非数据库字段) */
    private String userName;
    
    /** 创建开始时间(非数据库字段) */
    private String beginTime;
    
    /** 创建结束时间(非数据库字段) */
    private String endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getRestoreTime() {
        return restoreTime;
    }

    public void setRestoreTime(Date restoreTime) {
        this.restoreTime = restoreTime;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
    
}