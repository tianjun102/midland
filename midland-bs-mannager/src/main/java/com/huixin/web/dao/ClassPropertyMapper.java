package com.huixin.web.dao;

import java.util.List;

import com.huixin.core.generic.GenericDao;
import com.huixin.web.model.ClassProperty;


public interface ClassPropertyMapper extends GenericDao<ClassProperty,Integer>{
	
	public List<ClassProperty> selectClassProperty();
	

}
