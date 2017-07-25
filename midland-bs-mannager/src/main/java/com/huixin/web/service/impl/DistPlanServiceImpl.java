package com.huixin.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.dao.DistPlanMapper;
import com.huixin.web.model.DistPlan;
import com.huixin.web.model.DistPlanCustomer;
import com.huixin.web.model.DistPlanProduct;
import com.huixin.web.service.DistPlanService;

/**
 *
 * @author  jzg
 * @since 
 */
@Service
public class DistPlanServiceImpl  implements DistPlanService {

    @Resource
    private DistPlanMapper distPlanMapper;

    /** ---------------------------------- 产品分类 ------------------------------**/
    
	@Override
	public int inputDistPlanObj(DistPlan distPlan) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			distPlanMapper.addDistPlanObj(distPlan);
			List<DistPlanProduct> proList = distPlan.getProList();
			List<DistPlanCustomer> custList = distPlan.getCustList();
			if(proList!=null){
				for (int i = 0; i < proList.size(); i++) {
					DistPlanProduct proObj = new DistPlanProduct();
					proObj.setDistPlanId(distPlan.getId());
					proObj.setProdId(proList.get(i).getProdId());
					distPlanMapper.addPlanProduct(proObj);
				}
			}
			
			if(custList!=null){
				for (int i = 0; i < custList.size(); i++) {
					DistPlanCustomer custObj = new DistPlanCustomer();
					custObj.setDistPlanId(distPlan.getId());
					custObj.setCustId(custList.get(i).getCustId());
					distPlanMapper.addPlanCustomer(custObj);
				}
			}
			result = 1 ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int modifyDistPlanObj(DistPlan distPlan) {
		// TODO Auto-generated method stub
		int result = 0 ;
		try {
			distPlanMapper.updateDistPlanObj(distPlan);
			
			distPlanMapper.deletePlanCustomer(distPlan.getId());
			distPlanMapper.deletePlanProduct(distPlan.getId());
			List<DistPlanProduct> proList = distPlan.getProList();
			List<DistPlanCustomer> custList = distPlan.getCustList();
			if(proList!=null){
				for (int i = 0; i < proList.size(); i++) {
					DistPlanProduct proObj = new DistPlanProduct();
					proObj.setDistPlanId(distPlan.getId());
					proObj.setProdId(proList.get(i).getProdId());
					distPlanMapper.addPlanProduct(proObj);
				}
			}
			
			if(custList!=null){
				for (int i = 0; i < custList.size(); i++) {
					DistPlanCustomer custObj = new DistPlanCustomer();
					custObj.setDistPlanId(distPlan.getId());
					custObj.setCustId(custList.get(i).getCustId());
					distPlanMapper.addPlanCustomer(custObj);
				}
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int removeDistPlanObj(DistPlan distPlan) {
		// TODO Auto-generated method stub
		int result =  0;
		try {
			
			distPlanMapper.deleteDistPlanObj(distPlan);
			distPlanMapper.deletePlanCustomer(distPlan.getId());
			distPlanMapper.deletePlanProduct(distPlan.getId());
			result =  1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public PageList<DistPlan> searchDistPlanList(DistPlan distPlan,PageBounds pageBounds) {
		// TODO Auto-generated method stub
		return distPlanMapper.queryDistPlanList(distPlan,pageBounds);
	}

	@Override
	public DistPlan searchDistPlanObj(DistPlan distPlan) {
		
		DistPlan newdistPlan =  new DistPlan();
		try {
			newdistPlan = distPlanMapper.queryDistPlanObj(distPlan);
			if(newdistPlan.getId()!=null){
				newdistPlan.setProList(distPlanMapper.queryPlanCustomer(newdistPlan.getId()));
				newdistPlan.setCustList(distPlanMapper.queryPlanProduct(newdistPlan.getId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newdistPlan;
	}

	@Override
	public List<Map<String, Object>> searchCatProForList(){
		// TODO Auto-generated method stub
		return distPlanMapper.queryCatProForList();
	}
	
	
	@Override
	public List<Map<String, Object>> searchAreaCustForList(){
		// TODO Auto-generated method stub
		return distPlanMapper.queryAreaCustForList();
	}
}
