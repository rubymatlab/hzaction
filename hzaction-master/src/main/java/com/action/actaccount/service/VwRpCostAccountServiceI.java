package com.action.actaccount.service;
import com.action.actaccount.entity.VwRpCostAccountEntity;
import com.action.actaccount.entity.VwBusPoContractPayEntity;
import com.action.actaccount.entity.VwBusOthersProjPayEntity;
import com.action.actaccount.entity.VwBusOthersPayDetailEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface VwRpCostAccountServiceI extends CommonService{
 	public void delete(VwRpCostAccountEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(VwRpCostAccountEntity vwRpCostAccount,
	        List<VwBusPoContractPayEntity> vwBusPoContractPayList,List<VwBusOthersProjPayEntity> vwBusOthersProjPayList,List<VwBusOthersPayDetailEntity> vwBusOthersPayDetailList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(VwRpCostAccountEntity vwRpCostAccount,
	        List<VwBusPoContractPayEntity> vwBusPoContractPayList,List<VwBusOthersProjPayEntity> vwBusOthersProjPayList,List<VwBusOthersPayDetailEntity> vwBusOthersPayDetailList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (VwRpCostAccountEntity vwRpCostAccount) throws Exception;
}
