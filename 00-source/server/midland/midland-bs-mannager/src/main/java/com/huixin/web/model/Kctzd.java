package com.huixin.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.huixin.core.util.ProductUtils;

public class Kctzd implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 3264697336592505469L;

	private Integer id;

    private String djbh;

    private Integer totalNum;

    private String kctzdNote;

    private Integer isComplete;

    private String addTime;

    private Integer userBy;

    private String updateTime;
    
    
    
    // 自定义属性 
    
    private Integer pageFlag=0; 
    
    private List<KctzdItem> itemList = new ArrayList<KctzdItem>();
    
    private	String	isCompleteName;
    
    
    private String addTimeStart;
    
    private String addTimeEnd;

    private String updateTimeStart;
    
    private String updateTimeEnd;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDjbh() {
        return djbh;
    }

    public void setDjbh(String djbh) {
        this.djbh = djbh == null ? null : djbh.trim();
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getKctzdNote() {
        return kctzdNote;
    }

    public void setKctzdNote(String kctzdNote) {
        this.kctzdNote = kctzdNote == null ? null : kctzdNote.trim();
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public Integer getUserBy() {
		return userBy;
	}

	public void setUserBy(Integer userBy) {
		this.userBy = userBy;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getPageFlag() {
		return pageFlag;
	}

	public void setPageFlag(Integer pageFlag) {
		this.pageFlag = pageFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<KctzdItem> getItemList() {
		return itemList;
	}

	public String getAddTimeStart() {
		return addTimeStart;
	}

	public void setAddTimeStart(String addTimeStart) {
		this.addTimeStart = addTimeStart;
	}

	public String getAddTimeEnd() {
		return addTimeEnd;
	}

	public void setAddTimeEnd(String addTimeEnd) {
		this.addTimeEnd = addTimeEnd;
	}

	public String getUpdateTimeStart() {
		return updateTimeStart;
	}

	public void setUpdateTimeStart(String updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}

	public String getUpdateTimeEnd() {
		return updateTimeEnd;
	}

	public void setUpdateTimeEnd(String updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}

	public void setItemList(List<KctzdItem> itemList) {
		this.itemList = itemList;
	}

	public String getIsCompleteName() {
		String temp  = ProductUtils.COMPLETE_STATUS_WYS;
		if(isComplete==1){
			temp  = ProductUtils.COMPLETE_STATUS_YYS;
		}
		return temp;
	}

	public void setIsCompleteName(String isCompleteName) {
		this.isCompleteName = isCompleteName;
	}
	
	

}