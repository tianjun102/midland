package com.huixin.web.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.dao.ClassMapper;
import com.huixin.web.dao.ClassPropertyMapper;
import com.huixin.web.dao.ProductMapper;
import com.huixin.web.model.Category;
import com.huixin.web.model.Class;
import com.huixin.web.model.ClassProperty;
import com.huixin.web.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {
	@Autowired private ClassMapper classMapper;
	@Autowired private ClassPropertyMapper classPropertyMapper;
	@Autowired private ProductMapper productMapper;
	@Override
	public PageList<Class> selectClassList(Class classes,PageBounds pageBounds) {
		
		if(classes != null && (classes.getClassName()!=null&&!classes.getClassName().equals("") || classes.getIsClose() != null)){
		PageList<Class>	classList = classMapper.selectClassByEntity(classes,pageBounds);
		/*List<Class>	newClassList = new ArrayList<>();
		for (Class classe : classList) {
			if(classe!=null){
			Integer isChildMenu = isChildMenus(classe);
			classe.setIsChildMenu(isChildMenu);
			}
			newClassList.add(classe);
		}*/
		return classList;
		}
		return classMapper.selectClassList(pageBounds);
	}
	
	//是否有子菜单
	public Integer isChildMenus(Class classes){
		List<Class> classesList =  classMapper.selectChildMenus(classes);
		if (classesList!=null) {
			return classesList.size();
		}
		return 0;
	}
	
	@Override
	public List<Class> selectUnionMenu(){
		//取并集查出一二级菜单
		return classMapper.selectUnionMenu();
		
	}

	@Override
	public List<ClassProperty> selectClassProp() {
		//查询所有属性列表
		return classPropertyMapper.selectClassProperty();
	};
	
	@Override
	public Class selectProperty(Class classes){
		//查询栏目属性
		return classMapper.selectClassById(classes);
	}

	@Override
	public Integer insertClass(Class classes) {
		//添加新的菜单
		return classMapper.insetClass(classes);
	}

	@Override
	public List<Class> selectChildMenusList(Class classes) {
		//查询子菜单列表并且统计下级菜单的个数（通过classId）
		return classMapper.selectChildMenusList(classes);
	}

	@Override
	public Integer updateClassById(Class classes) {
		//编辑栏目
		return classMapper.updateClassById(classes);
	}

	@Override
	public Integer deleteClassById(Class classes) {
		return classMapper.deleteClass(classes);
	}

	@Override
	public Class selectParentMenu(Class classes) {
		//查询所有父菜单栏
		return classMapper.selectParentMenus(classes);
	}

	@Override
	public List<Category> selectCategoryRoot() {
		return productMapper.queryCategoryRoot();
	}
	
	
	
	

}
