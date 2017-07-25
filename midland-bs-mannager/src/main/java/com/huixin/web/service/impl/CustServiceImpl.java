package com.huixin.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.generic.GenericDao;
import com.huixin.core.generic.GenericServiceImpl;
import com.huixin.web.dao.AreaMapper;
import com.huixin.web.dao.CustomerAddressMapper;
import com.huixin.web.dao.CustomerMapper;
import com.huixin.web.dao.CustomerPropertyMapper;
import com.huixin.web.dao.RegionMapper;
import com.huixin.web.model.Area;
import com.huixin.web.model.AreaExample;
import com.huixin.web.model.AreaExample.Criteria;
import com.huixin.web.model.Customer;
import com.huixin.web.model.CustomerAddress;
import com.huixin.web.model.CustomerAddressExample;
import com.huixin.web.model.CustomerExample;
import com.huixin.web.model.CustomerProperty;
import com.huixin.web.model.CustomerPropertyExample;
import com.huixin.web.model.Region;
import com.huixin.web.model.RegionExample;
import com.huixin.web.service.CustService;

@Service
public class CustServiceImpl extends GenericServiceImpl<Area, Long> implements CustService {
	
	@Resource
    private AreaMapper areaMapper;

	@Resource
    private CustomerMapper customerMapper;
	
	@Resource
    private CustomerAddressMapper customerAddressMapper;
	
	@Resource
    private CustomerPropertyMapper customerPropertyMapper;
	
	@Resource
    private RegionMapper regionMapper;

	@Override
	public GenericDao<Area, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public int insertArea(Area area) {
		if(area!=null){
			area.setIsShow(1);
			return areaMapper.insertSelective(area);
		}
        return 0;
    }

	@Override
	public int addCustomer(Customer cust, CustomerAddress custAddr) {
		customerMapper.insertSelective(cust);
		if(StringUtils.isNotEmpty(cust.getProdNames())){
			this.insertCustomerProperty(cust.getProdNames());
		}
		if(custAddr!=null&&custAddr.getProvinceId()!=null){
			custAddr.setCustId(cust.getCustId());
			customerAddressMapper.insertSelective(custAddr);
		}
		return 1;
	}
	/**
	 * 添加更多 经营产品
	 * @param prodNames
	 * @return
	 */
	private int insertCustomerProperty(String prodNames){
		if(StringUtils.isNotEmpty(prodNames)){
			String[] prodValueArr=prodNames.split(",");
			List<CustomerProperty> list=new ArrayList<CustomerProperty>();
			CustomerProperty record=null;
			for(int a=0;a<prodValueArr.length;a++){
				record=new CustomerProperty();
				record.setIsShow(1);
				record.setPropName("经营产品");
				record.setPropType(2);
				record.setPropValues(prodValueArr[a]);
				list.add(record);
			}
			if(list!=null&&list.size()>0)  
			return customerPropertyMapper.insertBatch(list);
			
		}
		return 0;
	}
	
	@Override
	public int updateArea(Area area) {
		
		return areaMapper.updateByPrimaryKeySelective(area);
	}

	@Override
	public int updateCustomer(Customer cust, CustomerAddress custAddr) {
		customerMapper.updateByPrimaryKeySelective(cust);
		if(StringUtils.isNotEmpty(cust.getProdNames())){
			this.insertCustomerProperty(cust.getProdNames());
		}
		if(custAddr.getAddressId()==null){
			customerAddressMapper.insert(custAddr);
		}else{
			customerAddressMapper.updateByPrimaryKeySelective(custAddr);
		}
		return 1;
	}

	@Override
	public Area findAreaById(Integer areaId) {
		return areaMapper.selectByPrimaryKey(areaId);
	}

	@Override
	public Customer findCustById(Integer custId) {
		
		return customerMapper.selectByPrimaryKey(custId);
	}

	@Override
	public List<Area> queryAreas(Area area) {
		AreaExample example=new AreaExample();
		Criteria criteria=example.createCriteria();
		if(area!=null){
			if(StringUtils.isNotEmpty(area.getAreaDescription())){
				criteria.andAreaDescriptionEqualTo(area.getAreaDescription());
			}
			if(StringUtils.isNotEmpty(area.getAreaName())){
				criteria.andAreaNameEqualTo(area.getAreaName());
			}
			if(area.getIsShow()!= null){
				criteria.andIsShowEqualTo(area.getIsShow());
			}
		}
		return areaMapper.selectByExample(example);
	}

	@Override
	public List<CustomerProperty> queryCustomerPropertyByType(Integer type) {
		CustomerPropertyExample example=new CustomerPropertyExample();
		example.createCriteria().andPropTypeEqualTo(type).andIsShowEqualTo(1);
		
		return customerPropertyMapper.selectByExample(example);
	}

	@Override
	public PageList<Area> selectAreaByExampleAndPage(Area area, PageBounds pageBounds) {
		AreaExample areaExample=new AreaExample();
		Criteria criteria=areaExample.createCriteria();
		if(area!=null){
			if(StringUtils.isNotEmpty(area.getAreaDescription())){
				criteria.andAreaDescriptionEqualTo(area.getAreaDescription());
			}
			if(StringUtils.isNotEmpty(area.getAreaName())){
				criteria.andAreaNameLike("%"+area.getAreaName()+"%");
			}
			if(area.getIsShow()!= null){
				criteria.andIsShowEqualTo(area.getIsShow());
			}
		}
		PageList<Area> list=areaMapper.selectAreaByExampleAndPage(areaExample,pageBounds);
		return list;
	}

	@Override
	public PageList<Customer> selectCustByExampleAndPage(Customer cust, PageBounds pageBounds) {
		
		PageList<Customer> list=customerMapper.selectCustByExampleAndPage(cust,pageBounds);
		return list;
	}

	@Override
	public List<Region> selectRegionByParentId(Integer parentId) {
		RegionExample example=new RegionExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		return regionMapper.selectByExample(example);
	}

	@Override
	public List<CustomerAddress> findCustAddrByCustId(Integer custId) {
		CustomerAddressExample example=new CustomerAddressExample();
		example.setOrderByClause(" is_default desc ");
		example.createCriteria().andCustIdEqualTo(custId);
		return customerAddressMapper.selectByExample(example);
	}

	@Override
	public List<Customer> queryCustList(Customer cust) {
		CustomerExample example=new CustomerExample();
		com.huixin.web.model.CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo(3);
		if(cust!=null){
			if(cust.getStatus()!=null){
				criteria.andStatusEqualTo(cust.getStatus());
			}
			if(StringUtils.isNotEmpty(cust.getCustCode())){
				criteria.andCustCodeEqualTo(cust.getCustCode());
			}
			if(StringUtils.isNotEmpty(cust.getCustName())){
				criteria.andCustNameEqualTo(cust.getCustName());
			}
			if(cust.getCustType()!=null){
				criteria.andCustTypeEqualTo(cust.getCustType());
			}
			if(cust.getAreaId()!=null){
				criteria.andAreaIdEqualTo(cust.getAreaId());
			}
			if(cust.getCustParentId()!=null){
				criteria.andCustParentIdEqualTo(cust.getCustParentId());
			}
			if(StringUtils.isNotEmpty(cust.getCustPhone())){
				criteria.andCustPhoneEqualTo(cust.getCustPhone());
			}
			if(StringUtils.isNotEmpty(cust.getCustTel())){
				criteria.andCustTelEqualTo(cust.getCustTel());
			}
			
		}
		return customerMapper.selectByExample(example);
	}

	@Override
	public int deleteCustomer(Customer record) {
		return customerMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int checkAreaIsEmploy(Integer areaId) {
		CustomerExample example=new CustomerExample();
		example.createCriteria().andAreaIdEqualTo(areaId).andStatusNotEqualTo(3);
		List<Customer> list=customerMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return 1;
		}
		return 0;
	}

	@Override
	public List<CustomerAddress> queryCustAddrByCustAddr(CustomerAddress custAddr) {
		CustomerAddressExample example=new CustomerAddressExample();
		com.huixin.web.model.CustomerAddressExample.Criteria criteria = example.createCriteria();
		if(custAddr!=null){
			if(StringUtils.isNotEmpty(custAddr.getContactPhone())){
				criteria.andContactPhoneEqualTo(custAddr.getContactPhone());
			}
		}	
		return customerAddressMapper.selectByExample(example);
	
	}

}
