package com.huixin.web.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Kctzd;
import com.huixin.web.model.Stock;

/**
 * 
 * @author  jzg
 * 
 **/
public interface StockService {
	
	
		/**  --------------------------------- 库存管理  -------------------------------**/

		/**
		 * 新增库存调整单
		 * @param kctzd 调整单参数
		 * @return 数据库受影响行数
		 */
		int inputKctzdObj(Kctzd kctzd);
		
		
		/**
		 * 修改库存调整单
		 * @param kctzd 调整单参数
		 * @return 数据库受影响行数
		 */
		int modifyKctzdObj(Kctzd kctzd);
		
		
		/**
		 * 删除库存调整单
		 * @param kctzd 调整单参数
		 * @return 数据库受影响行数
		 */
		int removeKctzdObj(Kctzd kctzd);
		
		
		/**
		 * 查询库存调整单集合
		 * @param kctzd 调整单参数
		 * @param pageBounds 分页参数
		 * @return 查询结果集合
		 */
		PageList<Kctzd> searchKctzdList(Kctzd kctzd,PageBounds pageBounds);
		

		/**
		 * 查询库存调整单明细
		 * @param kctzd 调整单参数
		 * @return 查询结果集合
		 */
		Kctzd searchKctzdObj(Kctzd kctzd);
		
		
		/**
		 * 根据商品编码 查询所有的商品
		 * @param code
		 * @return
		 */
		List searchProductByCode(String code);
		
		
		/**
		 * 验收 调整单
		 * @param kctzd 调整单
		 * @return 返回受影响行数
		 */
		int changeKctzd(Kctzd kctzd);
		
		/**
		 * 库存查询 分页查询
		 * @param stock
		 * @param pageBounds
		 * @return
		 */
		PageList<Stock> searchStockList(Stock stock,PageBounds pageBounds);

		/**
		 * 文件导入 批量更新安全库存
		 * @param stockList
		 * @return
		 */
		int batchUpdateStock(List<Stock> stockList);
		
		
		/**
		 * 删除调整单明细
		 * @param itemId
		 * @return
		 */
		Integer removeKctzdItem(Integer itemId);
		
}
