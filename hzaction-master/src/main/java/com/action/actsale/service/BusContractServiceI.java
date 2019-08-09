package com.action.actsale.service;
import com.action.actsale.entity.BusContractEntity;
import com.action.actsale.entity.BusConQuotedPriceEntity;
import com.action.actsale.entity.BusContractPaymentEntity;
import com.action.actsale.entity.BusCostBudgetingEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface BusContractServiceI extends CommonService{
	
	public void affirmButton(BusContractEntity t);
	
	
 	public void delete(BusContractEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BusContractEntity busContract,
	        List<BusConQuotedPriceEntity> busConQuotedPriceList,List<BusContractPaymentEntity> busContractPaymentList,List<BusCostBudgetingEntity> busCostBudgetingList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BusContractEntity busContract,
	        List<BusConQuotedPriceEntity> busConQuotedPriceList,List<BusContractPaymentEntity> busContractPaymentList,List<BusCostBudgetingEntity> busCostBudgetingList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (BusContractEntity busContract) throws Exception;
}
