package com.huixin.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.huixin.web.model.Category;
import com.huixin.web.service.ProductService;



public class BaseController {
	
	
	@Resource
	private ProductService productService;

	
	
	
	// 把查询结果转换成JSON格式      type: 1-查询1-2级 ； 为空时查询所有
	public String getCategoryTree(String type) {
		// 避免数据库中存在换行符,进行菜单文字的过滤
		// String replaceStr = "(\r\n|\r|\n|\n\r)";
		List list = new ArrayList<>();
		if("1".equals(type)){
			list = productService.searchCategoryTopTwo(null);
		}else{
			list = productService.searchCategoryList(null, new PageBounds());
		}	
		
		StringBuffer ret = new StringBuffer("");
		if (list != null   &&  list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				Category cat = (Category) list.get(i);
				ret.append("{id:").append(cat.getCatId()).append(", pId:").append(cat.getParentId())
				.append(", name:'").append(cat.getCatName()).append("',open:true,nocheck:true");
				if("".equals(type)){
					ret.append(", chirdCount:").append(cat.getChirdCount());
				}
				if(!("0".equals(cat.getParentId().toString()))){
					ret.append(",iconSkin:'pIcon03'");
				}
				
				ret.append("},");
			}
			return ret.substring(0, ret.length() - 1);
		}
		
		return "";
	}

}
