package com.huixin.web.dao;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.generic.GenericDao;
import com.huixin.web.model.Activity;

public interface ActivityMapper extends GenericDao<Activity,Integer> {
	
	public Activity selectActivityByParem(Activity activity);
	
	public PageList<Activity> selectActivityListByParem(Activity activity,PageBounds pageBounds);
	
	public int updateActivityById(Activity activity);
	
	public int insetActivity(Activity activity);
	
	public int deleteActivity(Activity activity);
	

}
