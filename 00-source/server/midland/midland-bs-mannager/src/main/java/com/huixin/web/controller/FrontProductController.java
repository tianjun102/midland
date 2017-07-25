package com.huixin.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.huixin.core.util.RestResponse;
import com.huixin.web.model.Product;
import com.huixin.web.service.ProductService;

/**
 * 前台商品控制器
 * 
 * @author jzg
 * 
 **/

@Controller
@RequestMapping(value = "/frontProduct")
public class FrontProductController  {
	
	 @Resource
	 private ProductService productService;
	
    
   //日志
    public final static Logger logger = LoggerFactory.getLogger(FrontProductController.class);
	    

	 
	 //查询商品列表
    @RequestMapping(value="showProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public RestResponse showProductList(@Valid Product product,HttpServletRequest request) {
    	try {
    		List productList=(ArrayList<Product>) productService.searchProductList(product,new PageBounds());
    		return RestResponse.RestResponseBuilder.createSuccessBuilder().setResult(productList).buidler();
		} catch (Exception e) {
			 logger.error("=========查询商品列表:", e);
	         return RestResponse.RestResponseBuilder.createFailBuilder("查询商品列表异常,稍候再试!").buidler();
		}
    }
    
    //查询商品详情
    @RequestMapping(value="showProductDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public RestResponse showProductDetail(@Valid Product productObj,HttpServletRequest request) {
    	try {
    		Product product = productService.searchProductObj(productObj);
    		return RestResponse.RestResponseBuilder.createSuccessBuilder().setResult(product).buidler();
		} catch (Exception e) {
			 logger.error("=========查询商品详情:", e);
	         return RestResponse.RestResponseBuilder.createFailBuilder("查询商品详情异常,稍候再试!").buidler();
		}
    }
    
    

    

}