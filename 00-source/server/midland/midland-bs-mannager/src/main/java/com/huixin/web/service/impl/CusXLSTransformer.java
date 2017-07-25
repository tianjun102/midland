package com.huixin.web.service.impl;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

@Service("cusXLSTransformer")
public class CusXLSTransformer extends XLSTransformer{
	
	 @SuppressWarnings("unchecked")
	public void transformXLS(String srcFilePath, Map beanParams, OutputStream os) throws ParsePropertyException, IOException, InvalidFormatException {
	        InputStream is = new BufferedInputStream(new FileInputStream(srcFilePath));
	        HSSFWorkbook workbook = (HSSFWorkbook) transformXLS(is, beanParams);
	        workbook.write(os);
	        is.close();
	       
	 }
	 
	 @SuppressWarnings("unchecked")
	public void transformXLS(InputStream is, Map beanParams, OutputStream os) throws ParsePropertyException, IOException, InvalidFormatException {
	        Workbook workbook = transformXLS(is, beanParams);
	        workbook.write(os);
	        is.close();
	       
	 }
	 
	 public void transformMultipleSheetsList(InputStream is,List objects,List listSheetNames,String beanName,OutputStream os) throws ParsePropertyException, InvalidFormatException, IOException{
		 	XLSTransformer transformer = new XLSTransformer();
	        Workbook workbook = transformer.transformMultipleSheetsList(is, objects, listSheetNames, "list", new HashMap(), 0);
	        workbook.write(os);
	        is.close();
	 }
}
