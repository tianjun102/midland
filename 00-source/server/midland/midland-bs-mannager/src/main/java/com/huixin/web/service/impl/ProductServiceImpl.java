package com.huixin.web.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import com.huixin.core.util.DateUtils;
import com.huixin.web.dao.ProductMapper;
import com.huixin.web.model.Category;
import com.huixin.web.model.Product;
import com.huixin.web.model.ProductAttribute;
import com.huixin.web.model.ProductPic;
import com.huixin.web.model.ProductProperty;
import com.huixin.web.service.ProductService;

/**
 *
 * @author  jzg
 * @since 
 */
@Service
public class ProductServiceImpl  implements ProductService {

    @Resource
    private ProductMapper productMapper;

    /** ---------------------------------- 产品分类 ------------------------------**/
    
	@Override
	public int inputCategoryObj(Category category) {
		// TODO Auto-generated method stub
		return productMapper.addCategory(category);
	}

	@Override
	public int modifyCategoryObj(Category category) {
		// TODO Auto-generated method stub
		return productMapper.updateCategoryObj(category);
	}

	@Override
	public int removeCategoryObj(Category category) {
		// TODO Auto-generated method stub
		return productMapper.deleteCategoryObj(category);
	}

	@Override
	public PageList<Category> searchCategoryList(Category category,PageBounds pageBounds) {
		// TODO Auto-generated method stub
		return productMapper.queryCategoryList(category,pageBounds);
	}

	@Override
	public Category searchCategoryObj(Category category) {
		// TODO Auto-generated method stub
		return productMapper.queryCategoryObj(category);
	}

	@Override
	public int searchCatNameIsExist(String catName) {
		// TODO Auto-generated method stub
		return productMapper.queryCatNameIsExist(catName);
	}

	@Override
	public List searchCategoryTopTwo(Category category){
		return productMapper.queryCategoryTopTwo(category);
	}
	
	
	
	/** -------------------------------- 产品商品 ----------------------------------- **/
	
	@Override
	public PageList<Product> searchProductList(Product product,PageBounds pageBounds) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotEmpty(product.getPlanSaleStartTime())){
			product.setPlanSaleStartTime(product.getPlanSaleStartTime()+" 00:00:00");
		}
		if(StringUtils.isNotEmpty(product.getPlanSaleEndTime())){
			product.setPlanSaleEndTime(product.getPlanSaleEndTime()+" 23:59:59");
		}
		return productMapper.queryProductList(product,pageBounds);
	}

	@Override
	public int inputProductObj(Product product) {
		// TODO Auto-generated method stub
		int result = 0 ; 
		try {
			if(product!=null){
				
				product.setAddTime(DateUtils.nowDateToStringYYMMDDHHmmss());
				if(StringUtils.isEmpty(product.getPlanSaleTime())){
					product.setPlanSaleTime(product.getAddTime());
				}
				productMapper.addProductObj(product);
			}
			
			
			List<ProductAttribute>  attrList = product.getAttrList(); 
			if(attrList!=null){
				for (int i = 0; i < attrList.size(); i++) {
					//设置属性
					ProductAttribute attribute = new ProductAttribute();
					attribute.setProductId(product.getProductId());
					attribute.setPropId(attrList.get(i).getPropId());
					attribute.setPropValue(attrList.get(i).getPropValue());
					productMapper.addAttributeObj(attribute);
				}
				result = 1 ;
			}
			List<ProductPic>   picList = product.getPicList(); 
			if(picList!=null){
				for (int i = 0; i < picList.size(); i++) {
					//设置属性
					ProductPic p = picList.get(i);
					p.setProdId(product.getProductId());
					p.setPicDesc("产品图片");
					productMapper.addPropPic(p);
				}
				result = 1 ;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = 0 ;
		}
		return result;
	}
 
	@Override
	public int modifyProductObj(Product product) {
		// TODO Auto-generated method stub
		int result = 0 ; 
		try {
		
			
			List<ProductAttribute>  list = product.getAttrList(); //p product.getValueList();
			if(list!=null){
				for (int i = 0; i < list.size(); i++) {
					//设置属性
					ProductAttribute attribute = new ProductAttribute();
					if(list.get(i).getAttrId()==null){
						attribute.setProductId(product.getProductId());
						attribute.setPropId(list.get(i).getPropId());
						attribute.setPropValue(list.get(i).getPropValue());
						productMapper.addAttributeObj(attribute);
					}else{
						attribute.setAttrId(list.get(i).getAttrId());
						attribute.setPropValue(list.get(i).getPropValue());
						productMapper.updateAttributeObj(attribute);
					}
				}
				result = 1 ;
			}
			List<ProductPic>   picList = product.getPicList(); 
			if(picList!=null){
				for (int i = 0; i < picList.size(); i++) {
					//设置属性
					ProductPic p = picList.get(i);
					p.setProdId(product.getProductId());
					p.setPicDesc("产品图片");
					productMapper.addPropPic(p);
				}
				result = 1 ;
			}
			//若状态为定时上架时，商品状态修改为待上架状态
			if("2".equals(product.getIsNowTime())){
				product.setProdStatus(3);
			}
			
			List<ProductPic> propList =   productMapper.queryPicListForPid(product.getProductId());
			if(propList!=null && propList.size()>0){
				product.setProdThumbPic1(propList.get(0).getThumbUrl());
				product.setProdThumbPic2(propList.get(0).getThumbUrl2());
			}
			result = productMapper.updateProductObj(product);
			
		} catch (Exception e) {
			e.printStackTrace();
			result = 0 ;
		}
		return result;
	}

	@Override
	public int removeProductObj(Product product) {
		// TODO Auto-generated method stub
		return productMapper.deleteProductObj(product);
	}
    
	@Override
	public Product searchProductObj(Product product) {
		Product newProduct  = new Product();
		try {
			newProduct = productMapper.queryProductObj(product);
			List propList =   productMapper.queryPropertyForPropId(newProduct.getProductId());
			if(propList!=null){
				newProduct.setPropList(propList);
			}
			List<ProductPic> picList =   productMapper.queryPicListForPid(newProduct.getProductId());
			if(picList!=null){
				newProduct.setPicList(picList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return newProduct;
	}

	@Override
	public int modifyProductFlag(ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		return productMapper.updateProductFlag(productList);
	}

	@Override
	public int searchProdCodeIsExist(String prodCode) {
		// TODO Auto-generated method stub
		return productMapper.queryProdCodeIsExist(prodCode);
	}

	@Override
	public List<Category> searchPropertyList(Integer catId) {
		// TODO Auto-generated method stub
		return productMapper.queryPropertyList(catId);
	}
	
	@Override
	public List<Category> searchPropertyListAll(Integer catId) {
		// TODO Auto-generated method stub
		List<Category>  list = productMapper.queryPropertyList(catId);
		Integer  newCatId = catId;
		while (true) {
			Category cat = new Category();
			cat.setCatId(newCatId);
			cat = productMapper.queryCategory(cat);
			if(cat.getParentId()==0){
				break;
			}else{
				List<Category>  list2  = productMapper.queryPropertyList(cat.getParentId());
				list.addAll(list2);
				newCatId = cat.getParentId();
			}
			
		}
		return list;
	}
	
	@Override
	public ProductProperty searchPropertyObj(Integer propId) {
		// TODO Auto-generated method stub
		return productMapper.queryPropertyObj(propId);
	}

	@Override
	public ProductProperty inputPropertyObj(ProductProperty productProperty) {
		// TODO Auto-generated method stub
		return searchPropertyObj(productMapper.addPropertyObj(productProperty));
	}

	@Override
	public List queryProListForMap(Map map) {
		// TODO Auto-generated method stub
		return productMapper.queryProListForMap(map);
	}

	@Override
	public Map<String, Object> searchProductForMap(Map map) {
		// TODO Auto-generated method stub
		return productMapper.queryProductForMap(map);
	}

	@Override
	public int changeProductStatus(String idStr, String type,String flag) {
		int result = 0 ; 
		String [] idArr = {} ;
		String [] flagArr= {} ;
		try {
			if(StringUtils.isNotEmpty(idStr)){
				idArr = idStr.split(";");
			}
			if(StringUtils.isNotEmpty(flag)){
				flagArr = flag.split(";");
			}
			for (int i = 0; i < idArr.length; i++) {
				Product p = new Product();
				p.setProductId(Integer.parseInt(idArr[i]));
				if("0".equals(flagArr[i]) && "2".equals(type)){
					continue;
				}
				if("1".equals(type)){//上架
					p.setProdStatus(1);
					p.setPlanSaleTime(DateUtils.nowDateToStringYYMMDDHHmmss());
					
				}else if("2".equals(type)){//下架
					p.setProdStatus(2);
					p.setShelvesTime(DateUtils.nowDateToStringYYMMDDHHmmss());
					
				}else if("3".equals(type)){//设置推荐
					p.setIsRecommend(1);
					
				}else if("4".equals(type)){//取消设置
					p.setIsRecommend(0);
				}
				p.setUpdateTime(DateUtils.nowDateToStringYYMMDDHHmmss());
				productMapper.updateProductObj(p);
			}
			result = 1 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Category> selectCatParnet(Integer catId) {
		return productMapper.queryCategoryParent(catId);
	}

	@Override
	public Category selectCategory(Category category) {
		return productMapper.queryCategory(category);
	}

	@Override
	public int removeProductProperty(ProductProperty prop) {
		return productMapper.deleteProductPropertySelective(prop);
	}

	@Override
	public List<Category> selectCategoryLevel() {
		// TODO Auto-generated method stub
		return productMapper.selectCategoryLevel();
	}
	@Override
	public int changeProdStatus() {
		return productMapper.updateProdStatus();
	}

	@Override
	public Integer modifyPropertyObj(ProductProperty property) {
		// TODO Auto-generated method stub
		return productMapper.updatePropertyObj(property);
	}

	@Override
	public Integer removeProductPic(Integer pid) {
		Integer result = 0 ; 
		ProductPic  p = productMapper.queryProductPicObj(pid);
		try {
			if(p==null){
				return  0 ; 
			}else{
				if(StringUtils.isNotEmpty(p.getThumbUrl())){
					FileUtils.deleteQuietly(new File(p.getThumbUrl()));
				}
				if(StringUtils.isNotEmpty(p.getThumbUrl2())){
					FileUtils.deleteQuietly(new File(p.getThumbUrl2()));
				}
				if(StringUtils.isNotEmpty(p.getPicOriginal())){
					FileUtils.deleteQuietly(new File(p.getPicOriginal()));
				}
				if(StringUtils.isNotEmpty(p.getPicUrl())){
					FileUtils.deleteQuietly(new File(p.getPicUrl()));
				}
				result = productMapper.deleteProductPic(pid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
