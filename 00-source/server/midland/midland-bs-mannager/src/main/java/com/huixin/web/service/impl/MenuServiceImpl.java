package com.huixin.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huixin.web.dao.MenuMapper;
import com.huixin.web.model.Menu;
import com.huixin.web.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired private MenuMapper menuMapper;

	@Override
	public List<Menu> selectList() {
		// TODO Auto-generated method stub
		return menuMapper.selectById();
	}

}
