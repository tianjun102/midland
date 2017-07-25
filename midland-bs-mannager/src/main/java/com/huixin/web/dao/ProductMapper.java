package com.huixin.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.AdProd;
import com.huixin.web.model.BannerProd;
import com.huixin.web.model.Category;
import com.huixin.web.model.Product;
import com.huixin.web.model.ProductAttribute;
import com.huixin.web.model.ProductPic;
import com.huixin.web.model.ProductProperty;

/**
 * 产品Dao接口
 * @author jzg
 **/
public interface ProductMapper {
	
	 
	/**
	 *------------------------------------- 产品分类 -------------------------------------
	 */
	
	
	/**
	 * 新增产品分类
	 * @param category 分类参数
	 * @return 数据库受影响行数
	 */
	Integer addCategory(Category category);
	
	
	/**
	 * 修改产品分类
	 * @param category 分类参数
	 * @return 数据库受影响行
	 */
	Integer updateCategoryObj(Category category);
	
	
	/**
	 * 删除产品分类
	 * @param category 分类参数
	 * @return 数据库受影响行数
	 */
	Integer deleteCategoryObj(Category category);
	
	
	
	/**
	 * 查询产品分类集合
	 * @param category 分类参数
	 * @param pageBounds 分页参数
	 * @return 查询结果集合
	 */
	PageList<Category> queryCategoryList(Category category,PageBounds pageBounds);
	

	/**
	 * 查询产品分类明细
	 * @param category 分类参数
	 * @return 查询结果集合
	 */
	Category queryCategoryObj(Category category);
	
	
	
	/**
	 * 查询产品分类名称是否存在
	 * @param catName 产品分类名称
	 * @return 返回结果  
	 */
	Integer queryCatNameIsExist(String catName);
	
	
	/**
	 * 查询所有分类根节点
	 * @param catName 产品分类名称
	 * @return 返回结果  
	 */
	List<Category> queryCategoryRoot();
	
	
	
	/**
	 * 查询产品分类集合 最上面2级
	 * @param category 分类参数
	 * @return 查询结果集合
	 */
	List<Category> queryCategoryTopTwo(Category category);
	
	

	/** -------------------------------- 产品商品 ----------------------------------- **/
	
	/**
	 * 查询商品列表
	 * @param product 查询条件
	 * @param pageBounds 分页参数
	 * @return 查询结果集合
	 */
	PageList<Product> queryProductList(Product product,PageBounds pageBounds);
	
	/**
	 * 新增商品
	 * @param product 商品参数
	 * @return 数据库受影响行数
	 */
	Integer addProductObj(Product product);
	
	/**
	 * 修改商品
	 * @param product 商品参数
	 * @return 数据库受影响行数
	 */
	Integer updateProductObj(Product product);
	
	/**
	 * 删除商品
	 * @param product 商品参数
	 * @return 数据库受影响行数
	 */
	Integer deleteProductObj(Product product);
	
	/**
	 * 查询商品信息
	 * @param product
	 * @return
	 */
	Product queryProductObj(Product product);
	
	/**
	 * 修改商品上下架状态
	 * @param productList 商品参数
	 * @return 数据库受影响行数
	 */
	Integer updateProductFlag(ArrayList<Product> productList);
	
	/**
	 * 查询商品编码是否存在
	 * @param prodCode 商品编码
	 * @return 返回结果  
	 */
	Integer queryProdCodeIsExist(String prodCode);
	
	
	/**
	 * 根据分类Id查询对应商品属性
	 * @param catId 分类id
	 * @return 返回结果集合
	 */
	List<Category> queryPropertyList(Integer catId);
	
	
	/**
	 * 根据属性Id查询对应属性
	 * @param propId 属性id
	 * @return 返回结果
	 */
	ProductProperty queryPropertyObj(Integer propId);
	

	/**
	 * 新增属性
	 * @param productProperty 属性参数
	 * @return 数据库受影响行数
	 */
	int addPropertyObj(ProductProperty productProperty);
	
	
	/**
	 * 新增属性值
	 * @param productProperty 属性值参数
	 * @return 数据库受影响行数
	 */
	Integer addAttributeObj(ProductAttribute productAttribute);
	
	
	/**
	 * 新增属性值
	 * @param productProperty 属性值参数
	 * @return 数据库受影响行数
	 */
	Integer updateAttributeObj(ProductAttribute productAttribute);
	
	
	/**
	 * 根据商品ID查询对应的商品值 和商品属性
	 * @param propId
	 * @return
	 */
	List<ProductProperty> queryPropertyForPropId(Integer propId);
	
	
	/**
	 * 根据商品编码 查询所有的商品
	 * @param code
	 * @return
	 */
	List<Product> queryProductByCode(String code);
	
	
	
	/**
	 * 根据商品名称 查询所有的商品
	 * @param map
	 * @return
	 */
	List queryProListForMap(Map<String,Object> map);
	
	
	/**
	 * 根据商品条件 查询所有的商品
	 * @param map
	 * @return
	 */
	Map<String,Object> queryProductForMap(Map map);
	
	List queryProListForList(List<BannerProd> list);
	
	List<Category> queryCategoryParent(Integer catId);
	
	Category queryCategory(Category category);

	List queryProListForAdList(List<AdProd> list);
	
	/**
	 * 根据id查询商品的图片
	 * @param pid 商品id
	 * @return 
	 */
	List<ProductPic> queryPropPicForList(Integer pid);
	
	
	/**
	 * 新增商品图片
	 * @param productPic
	 * @return
	 */
	Integer addPropPic(ProductPic productPic);
	
	
	/**
	 * 根据id删除商品的图片
	 * @param pid 商品id
	 * @return 
	 */
	Integer deletePropPic(Integer pid);
	

	/**
	 * 条件过滤删除商品属性
	 * @param prop
	 * @return
	 */
	Integer deleteProductPropertySelective(ProductProperty prop);
	
	List<Category> selectCategoryLevel();
	
	
	/**
	 * 根据商品Id查询商品图片
	 * @param pid  商品Id
	 * @return
	 */
	List<ProductPic> queryPicListForPid(Integer pid);
	
	
	/**
	 * 商品定时上架任务
	 * @return
	 */
	Integer updateProdStatus();
	
	
	/**
	 * 修改属性
	 * @return
	 */
	Integer updatePropertyObj(ProductProperty property);
	
	
	/**
	 * 查询商品属性
	 * @param pid
	 * @return
	 */
	ProductPic queryProductPicObj(Integer picId);
	
	
	/**
	 * 根据pidid删除图片
	 * @param pid
	 * @return
	 */
	Integer deleteProductPic(Integer picId);

}