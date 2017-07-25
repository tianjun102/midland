package com.huixin.web.service.impl;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.sf.jxls.exception.ParsePropertyException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.huixin.web.service.DataExportService;



/**
 * Excel
 *
 */


public class ExcelDataExportServiceImpl implements DataExportService {

	
	private CusXLSTransformer cusXLSTransformer = new CusXLSTransformer();
	
	private List<?> objects;
	
	private List<?> listSheetNames;
	
	private final static String BEAN_NAME="list";
	
	@SuppressWarnings("unchecked")
	public void exportData(InputStream is, OutputStream os, Map beanParams) throws Exception {
		cusXLSTransformer.transformXLS(is, beanParams, os);
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public void transformMultipleSheetsList(InputStream is, List sourceList,
			int pageSize,String sheetName,OutputStream os) {
		// TODO Auto-generated method stub
		try {
			initMultipleSheetsList(sourceList,pageSize,sheetName);
			cusXLSTransformer.transformMultipleSheetsList(is, objects, listSheetNames, BEAN_NAME, os);
		} catch (ParsePropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initMultipleSheetsList(List list,int pageSize,String sheetName){
		List<String> listSheetNames = null;
		List objects = null;
		if(list!=null&&list.size()>0){
			int listSize = list.size();
			int sheetCount = listSize/pageSize;
			if(sheetCount*pageSize<listSize){
				sheetCount+=1;
			}
			listSheetNames = new ArrayList<String>();
			objects = new ArrayList();
			int index = 0;
			if(listSize<=pageSize){//如果只有一个Sheet
				listSheetNames.add(sheetName);
				List<?> tmpList = null;
				tmpList = list.subList(index,listSize);
				objects.add(tmpList);
			}else{
				for(int j=0;j<sheetCount;j++){
					listSheetNames.add(sheetName+j);
					List<?> tmpList = null;
					if(listSize-index>pageSize){
						tmpList = list.subList(index,(j+1)*pageSize);
					}else{
						tmpList = list.subList(index,listSize);
					}
					objects.add(tmpList);
					index = (j+1)*pageSize;
				}
			}
			this.objects = objects;
			this.listSheetNames = listSheetNames;
		}else{
			this.objects = new ArrayList();
			listSheetNames = new ArrayList();
			listSheetNames.add(sheetName);
			this.listSheetNames = listSheetNames;
		}
		
	}
}
