package com.huixin.web.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Activity;

public interface ActivityService {
	
	public PageList<Activity>  selectActivityList(Activity activity,PageBounds pageBounds);
	
	public Activity selectActivity(Activity activity);
	
	public Integer updateActivity(Activity activity);
	
	public Integer insertActivity(Activity activity);
	
	public Integer deleteActivity(Activity activity);
	
	
	

	
	
	
}
