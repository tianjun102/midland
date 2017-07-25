package com.huixin.web.service.impl;



import java.io.InputStream;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.huixin.web.service.DataExportService;

public class ExportService {

    private final static Logger logger = LoggerFactory.getLogger(ExportService.class);

    private static boolean isWindows() {
        boolean flag = false;
        if (System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
            flag = true;
        }
        return flag;
    }

    public void exportOrderToExcel(List<?> list, int pageSize, OutputStream os, String sheetName, String fileName) {
        DataExportService dataExportService = new ExcelDataExportServiceImpl();
        try {
            ClassPathResource resource = new ClassPathResource(fileName);
            InputStream is = resource.getInputStream();
            dataExportService.transformMultipleSheetsList(is, list, pageSize, sheetName, os);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("导出数据出错！", e);

        }
    }
    
    
    public void exportSettelToExcel(OutputStream os, Map<String, Object> beanParams, String fileName) {
        DataExportService dataExportService = new ExcelDataExportServiceImpl();
        try {
            ClassPathResource resource = new ClassPathResource(fileName);
            InputStream is = resource.getInputStream();
            dataExportService.exportData(is, os, beanParams);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("导出数据出错！", e);

        }
    }

    /**
     * @param list
     * @param pageSize
     * @param os
     * @param sheetName
     * @param fileName  模板名
     */
    public void exportDataToExcel(List<?> list, int pageSize, OutputStream os, String sheetName, String fileName) {
        DataExportService dataExportService = new ExcelDataExportServiceImpl();
        try {
            ClassPathResource resource = new ClassPathResource(fileName);
            InputStream is = resource.getInputStream();
            logger.info("文件流：" + is);
            dataExportService.transformMultipleSheetsList(is, list, pageSize, sheetName, os);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("导出数据出错！", e);
        }
    }

}
