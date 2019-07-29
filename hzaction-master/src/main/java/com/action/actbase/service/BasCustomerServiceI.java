package com.action.actbase.service;
import java.util.List;
import org.jeecgframework.core.common.service.CommonService;

import com.action.actbase.entity.BasCustomerContactsEntity;
import com.action.actbase.entity.BasCustomerEntity;

import java.io.Serializable;

public interface BasCustomerServiceI extends CommonService{
 	public void delete(BasCustomerEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BasCustomerEntity basCustomer,
	        List<BasCustomerContactsEntity> basCustomerContactsList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BasCustomerEntity basCustomer,
	        List<BasCustomerContactsEntity> basCustomerContactsList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (BasCustomerEntity basCustomer) throws Exception;
}
