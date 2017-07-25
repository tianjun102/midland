package com.huixin.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.util.DateUtils;
import com.huixin.web.dao.ProductMapper;
import com.huixin.web.dao.StockMapper;
import com.huixin.web.model.Kctzd;
import com.huixin.web.model.KctzdItem;
import com.huixin.web.model.Stock;
import com.huixin.web.service.StockService;

/**
 *
 * @author  jzg
 * @since 
 */
@Service
public class StockServiceImpl  implements StockService {

    @Resource
    private ProductMapper productMapper;
    
    @Resource
    private StockMapper stockMapper;

    
	@Override
	public int inputKctzdObj(Kctzd kctzd) {
		// TODO Auto-generated method stub
		int  result = 0;
		try {
			kctzd.setAddTime(DateUtils.nowDateToStringYYMMDDHHmmss());
			stockMapper.addKctzdObj(kctzd);
			List<KctzdItem> itemList = kctzd.getItemList();
			if(itemList!=null){
				for (int i = 0; i < itemList.size(); i++) {
					KctzdItem  kctzdItem =  new KctzdItem();
					if(itemList.get(i).getProdId()!=null){
						kctzdItem.setKctzdId(kctzd.getId());
						kctzdItem.setNum(itemList.get(i).getNum());
						kctzdItem.setProdId(itemList.get(i).getProdId());
						stockMapper.addKctzdItemObj(kctzdItem);
					}
					
				}
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int modifyKctzdObj(Kctzd kctzd) {
		// TODO Auto-generated method stub
		int result = 0 ;
		try {
			kctzd.setUpdateTime(DateUtils.nowDateToStringYYMMDDHHmmss());
			stockMapper.updateKctzdObj(kctzd);
			List<KctzdItem> itemList = kctzd.getItemList();
			if(itemList!=null){
				for (int i = 0; i < itemList.size(); i++) {
					if(itemList.get(i).getId()==null){
						KctzdItem  kctzdItem =  new KctzdItem();
						kctzdItem.setKctzdId(kctzd.getId());
						kctzdItem.setNum(itemList.get(i).getNum());
						kctzdItem.setProdId(itemList.get(i).getProdId());
						stockMapper.addKctzdItemObj(kctzdItem);
					}else{
						stockMapper.updateKctzdItemObj(itemList.get(i));
					}
				}
			}
			result = 1 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int removeKctzdObj(Kctzd kctzd) {
		// TODO Auto-generated method stub
		int result = 0 ;
		try {
			stockMapper.deleteKctzdObj(kctzd);
			stockMapper.deleteKctzdItemObj(kctzd.getId());
			result = 1 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public PageList<Kctzd> searchKctzdList(Kctzd kctzd,PageBounds pageBounds) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotEmpty(kctzd.getAddTimeStart())){
			kctzd.setAddTimeStart(kctzd.getAddTimeStart()+" 00:00:00");
		}
		if(StringUtils.isNotEmpty(kctzd.getAddTimeEnd())){
			kctzd.setAddTimeEnd(kctzd.getAddTimeEnd()+" 23:59:59");
		}
		if(StringUtils.isNotEmpty(kctzd.getUpdateTimeStart())){
			kctzd.setUpdateTimeStart(kctzd.getUpdateTimeStart()+" 00:00:00");
		}
		if(StringUtils.isNotEmpty(kctzd.getUpdateTimeEnd())){
			kctzd.setUpdateTimeEnd(kctzd.getUpdateTimeEnd()+" 23:59:59");
		}
		
		return stockMapper.queryKctzdList(kctzd,pageBounds);
	}

	@Override
	public Kctzd searchKctzdObj(Kctzd kctzd) {
		Kctzd  newKctzd =  new Kctzd();
		try {
			newKctzd = stockMapper.queryKctzdObj(kctzd);
			List<KctzdItem> itemList = stockMapper.queryKctzdItemList(newKctzd.getId());
			newKctzd.setItemList(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newKctzd;
	}

	@Override
	public List searchProductByCode(String code) {
		// TODO Auto-generated method stub
		return productMapper.queryProductByCode(code);
	}

	@Override
	public int changeKctzd(Kctzd kctzd) {
		int result = 0;
		try {
			List list = stockMapper.queryKctzdItemList(kctzd.getId());
			if(list!=null){
				for (int i = 0; i < list.size(); i++) {
					KctzdItem item = (KctzdItem)list.get(i);
					if(stockMapper.queryStockByPid(item.getProdId())!=null){
						Stock stock = stockMapper.queryStockByPid(item.getProdId());
						if((stock.getSl()+item.getNum())<0){
							return 0;
						}
						stock.setSl(stock.getSl()+item.getNum());
						stock.setSl2(stock.getSl2()+item.getNum());
						stockMapper.updateStockObj(stock);
						
					}else{
						if(item.getNum()<0){
							return 0;
						}
						Stock stock =new Stock();
						stock.setProductId(item.getProdId());
						stock.setSl(item.getNum());
						stock.setSl2(item.getNum());
						stockMapper.addStockObj(stock);
					}
				}
			}
			kctzd.setIsComplete(1);
			kctzd.setUpdateTime(DateUtils.nowDateToStringYYMMDDHHmmss());
			stockMapper.changeKctzd(kctzd);
			 result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public PageList<Stock> searchStockList(Stock stock, PageBounds pageBounds) {
		return stockMapper.queryStockList(stock,pageBounds);
	}

	@Override
	public int batchUpdateStock(List<Stock> stockList) {
		return stockMapper.batchUpdateStock(stockList);
	}

	@Override
	public Integer removeKctzdItem(Integer itemId) {
		return stockMapper.deleteKctzdItem(itemId);
	}
  
}
