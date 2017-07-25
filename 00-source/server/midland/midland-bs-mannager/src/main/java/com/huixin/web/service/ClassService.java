package com.huixin.web.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Category;
import com.huixin.web.model.Class;
import com.huixin.web.model.ClassProperty;

public interface ClassService { 
	
	//查询一级栏目列表
	public PageList<Class> selectClassList(Class classes,PageBounds pageBounds);

	public List<Class> selectUnionMenu();
	
	public List<ClassProperty> selectClassProp();//查询栏目属性
	
	public Class selectProperty(Class classes);
	
	public Integer insertClass(Class classes);
	
	public List<Class> selectChildMenusList(Class classes);//查询子菜单列表
	
	public Integer updateClassById(Class classes);
	
	public Integer deleteClassById(Class classes);
	
	public Class selectParentMenu(Class classes);//通过parentId查询父菜单
	
	public List<Category> selectCategoryRoot();
	
	
}
