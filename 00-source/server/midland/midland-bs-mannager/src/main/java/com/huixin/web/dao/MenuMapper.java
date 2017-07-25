package com.huixin.web.dao;

import java.util.List;

import com.huixin.core.generic.GenericDao;
import com.huixin.web.model.Menu;

public interface MenuMapper extends GenericDao<Menu,String> {
	
	public List<Menu> selectById();

}
