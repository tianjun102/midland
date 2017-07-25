package com.huixin.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.dao.ActivityMapper;
import com.huixin.web.model.Activity;
import com.huixin.web.service.ActivityService;
/**
 * 
 * @author tianj
 * 活动管理实现类
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired private ActivityMapper activityMapper;

	@Override
	public PageList<Activity> selectActivityList(Activity activity,PageBounds pageBounds) {
		return activityMapper.selectActivityListByParem(activity,pageBounds);
	}

	@Override
	public Activity selectActivity(Activity activity) {
		return activityMapper.selectActivityByParem(activity);
	}

	@Override
	public Integer updateActivity(Activity activity) {
		return activityMapper.updateActivityById(activity);
	}

	@Override
	public Integer insertActivity(Activity activity) {
		return activityMapper.insetActivity(activity);
	}

	@Override
	public Integer deleteActivity(Activity activity) {
		return activityMapper.deleteActivity(activity);
	}

}
