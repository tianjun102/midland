package com.huixin.web.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Kctzd;
import com.huixin.web.model.KctzdItem;
import com.huixin.web.model.Stock;


/**
 * 库存管理Dao接口
 * @author jzg
 **/
public interface StockMapper {

	/**  --------------------------------- 库存管理  -------------------------------**/

	/**
	 * 新增库存调整单
	 * @param kctzd 调整单参数
	 * @return 数据库受影响行数
	 */
	int addKctzdObj(Kctzd kctzd);
	
	
	/**
	 * 修改库存调整单
	 * @param kctzd 调整单参数
	 * @return 数据库受影响行数
	 */
	int updateKctzdObj(Kctzd kctzd);
	
	
	/**
	 * 删除库存调整单
	 * @param kctzd 调整单参数
	 * @return 数据库受影响行数
	 */
	int deleteKctzdObj(Kctzd kctzd);
	
	
	/**
	 * 查询库存调整单集合
	 * @param kctzd 调整单参数
	 * @param pageBounds 分页参数
	 * @return 查询结果集合
	 */
	PageList<Kctzd> queryKctzdList(Kctzd kctzd,PageBounds pageBounds);
	

	/**
	 * 查询库存调整单明细
	 * @param kctzd 调整单参数
	 * @return 查询结果集合
	 */
	Kctzd queryKctzdObj(Kctzd kctzd);
	
	/**
	 * 新增库存调整单 明细
	 * @param kctzd 调整单参数
	 * @return 数据库受影响行数
	 */
	int addKctzdItemObj(KctzdItem kctzdItem);
	
	
	/**
	 * 根据调整单编号  查询调整单明细
	 * @param kctzdId 编号 
	 * @return 查询结果集合
	 */
	List queryKctzdItemList(Integer kctzdId);
	
	
	/**
	 * 修改调整单明细 
	 * @param kctzdItem 调整单参数
	 * @return 数据库受影响行数
	 */
	int updateKctzdItemObj(KctzdItem kctzdItem);
	
	/**
	 * 删除调整单明细 
	 * @param id 调整单参数
	 * @return 数据库受影响行数
	 */
	int  deleteKctzdItemObj(Integer  id);
	
	
	/**
	 * 验收 调整单
	 * @param kctzd 调整单
	 * @return 返回受影响行数
	 */
	int changeKctzd(Kctzd kctzd);

	/**
	 * 库存分页查询
	 */
	PageList<Stock> queryStockList(Stock stock, PageBounds pageBounds);


	int batchUpdateStock(List<Stock> stockList);
	
	/**
	 * 新增库存记录
	 * @param stock
	 * @return
	 */
	int addStockObj(Stock stock);
	
	

	/**
	 * 修改库存记录
	 * @param stock
	 * @return
	 */
	int updateStockObj(Stock stock);
	
	
	/**
	 * 查询库存记录
	 * @param stock
	 * @return
	 */
	Stock queryStockByPid(Integer pid);
	
	/**
	 * 根据id删除调整单明细
	 * @param itemId
	 * @return
	 */
	Integer deleteKctzdItem(Integer itemId);
	
}