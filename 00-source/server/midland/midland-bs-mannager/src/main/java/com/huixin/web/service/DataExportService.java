package com.huixin.web.service;


import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface DataExportService {
	
	void  exportData(InputStream is,OutputStream os,Map beanParams) throws Exception;
	
	void transformMultipleSheetsList(InputStream is, List sourceList,int pageSize,String sheetName,OutputStream os);
}
