package com.huixin.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Category;
import com.huixin.web.model.Product;
import com.huixin.web.model.ProductProperty;

/**
 * 
 * @author  jzg
 * 
 **/
public interface ProductService {
	
	
		/**  --------------------------------- 产品分类  -------------------------------**/

		/**
		 * 新增产品分类
		 * @param category 分类参数
		 * @return 数据库受影响行数
		 */
		int inputCategoryObj(Category category);
		
		
		/**
		 * 修改产品分类
		 * @param category 分类参数
		 * @return 数据库受影响行数
		 */
		int modifyCategoryObj(Category category);
		
		
		/**
		 * 删除产品分类
		 * @param category 分类参数
		 * @return 数据库受影响行数
		 */
		int removeCategoryObj(Category category);
		
		
		/**
		 * 查询产品分类集合
		 * @param category 分类参数
		 * @param pageBounds 分页参数
		 * @return 查询结果集合
		 */
		PageList<Category> searchCategoryList(Category category,PageBounds pageBounds);
		

		/**
		 * 查询产品分类明细
		 * @param category 分类参数
		 * @return 查询结果集合
		 */
		Category searchCategoryObj(Category category);
		
		
		/**
		 * 查询产品分类名称是否存在
		 * @param catName 产品分类名称
		 * @return 返回结果  
		 */
		int searchCatNameIsExist(String catName);
		
		
		
		/**
		 * 查询产品分类集合 最上面2级
		 * @param category 分类参数
		 * @return 查询结果集合
		 */
		List searchCategoryTopTwo(Category category);
		
		
		/** -------------------------------- 产品商品 ----------------------------------- **/
		
		/**
		 * 查询商品列表
		 * @param product 查询条件
		 * @param pageBounds 分页参数
		 * @return 查询结果集合
		 */
		PageList<Product> searchProductList(Product product,PageBounds pageBounds);
		
		/**
		 * 新增商品
		 * @param product 商品参数
		 * @return 数据库受影响行数
		 */
		int inputProductObj(Product product);
		
		/**
		 * 修改商品
		 * @param product 商品参数
		 * @return 数据库受影响行数
		 */
		int modifyProductObj(Product product);
		
		/**
		 * 删除商品
		 * @param product 商品参数
		 * @return 数据库受影响行数
		 */
		int removeProductObj(Product product);
		
		/**
		 * 查询商品信息
		 * @param product
		 * @return
		 */
		Product searchProductObj(Product product);
		
		/**
		 * 修改商品上下架状态
		 * @param productList 商品参数
		 * @return 数据库受影响行数
		 */
		int modifyProductFlag(ArrayList<Product> productList);
		
		/**
		 * 查询商品编码是否存在
		 * @param prodCode 商品编码
		 * @return 返回结果  
		 */
		int searchProdCodeIsExist(String prodCode);
		
		
		/**
		 * 根据分类Id查询对应商品属性
		 * @param catId 分类id
		 * @return 返回结果集合
		 */
		List<Category> searchPropertyList(Integer catId);
		
		
		/**
		 * 根据分类Id查询对应商品属性
		 * @param catId 分类id
		 * @return 返回结果集合
		 */
		List<Category> searchPropertyListAll(Integer catId);
		
		/**
		 * 根据属性Id查询对应属性
		 * @param propId 属性id
		 * @return 返回结果
		 */
		ProductProperty searchPropertyObj(Integer propId);
		
		/**
		 * 新增属性
		 * @param productProperty 属性id
		 * @return 数据库受影响行数
		 */
		ProductProperty inputPropertyObj(ProductProperty productProperty);
		
		
		
		/**
		 * 根据商品条件 查询所有的商品
		 * @param map
		 * @return
		 */
		List queryProListForMap(Map map);
		
		
		/**
		 * 根据商品条件 查询所有的商品
		 * @param map
		 * @return
		 */
		Map<String,Object> searchProductForMap(Map map);
		
		
		/**
		 * 修改商品状态
		 * @param idStr pid
		 * @param type 类型
		 * @return
		 */
		int changeProductStatus(String idStr,String type,String flag);
		
		
		List<Category>  selectCatParnet(Integer catId);
		
		Category selectCategory(Category category);
		
		/**
		 * 删除产品属性
		 * @param prop
		 * @return
		 */
		int removeProductProperty(ProductProperty prop);
		
		
		List<Category> selectCategoryLevel();
		

		/**
		 * 产品定时上架
		 * @return
		 */
	    int changeProdStatus();
	    
	    /**
	     * 修改属性
	     * @return
	     */
	    Integer modifyPropertyObj(ProductProperty property);
	    
	    /**
	     * 删除产品图片
	     * @param pid
	     * @return
	     */
	    Integer removeProductPic(Integer pid);
}
