package com.huixin.web.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.generic.GenericDao;
import com.huixin.web.model.Class;

public interface ClassMapper extends GenericDao<Class,Integer> {
	
	public PageList<Class> selectClassList(PageBounds pageBounds);
	
	public List<Class> selectClassByParem(Map<String, Object> param);
	
	public PageList<Class> selectClassByEntity(Class classes,PageBounds pageBounds);
	
	public List<Class> selectChildMenus(Class classes);//查询子菜单
	
	public int updateClassById(Class classes);
	
	public int insetClass(Class classes);
	
	public int deleteClass(Class classes);
	
	public List<Class> selectUnionMenu();//查询一二级菜单
	
	public Class selectClassById(Class classes);
	
	public List<Class> selectChildMenusList(Class classes);
	
	public Class selectParentMenus(Class classes);//通过parentId查询父菜单
	
	
	
	

}
