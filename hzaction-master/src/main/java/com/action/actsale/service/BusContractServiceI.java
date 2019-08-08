package com.action.actsale.service;
import java.util.List;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;

import com.action.actsale.entity.BusConQuotedPriceEntity;
import com.action.actsale.entity.BusContractEntity;
import com.action.actsale.entity.BusContractPaymentEntity;
import com.action.actsale.entity.BusCostBudgetingEntity;

/**
 * service层操作数据库API
 * @author Administrator
 *
 */
public interface BusContractServiceI extends CommonService{
	
 	public void delete(BusContractEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BusContractEntity busContract,
	        List<BusCostBudgetingEntity> busCostBudgetingList,List<BusContractPaymentEntity> busContractPaymentList,
	        List<BusConQuotedPriceEntity> busConQuotedPriceList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BusContractEntity busContract,
	        List<BusCostBudgetingEntity> busCostBudgetingList,List<BusContractPaymentEntity> busContractPaymentList,
	        List<BusConQuotedPriceEntity> busConQuotedPriceList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (BusContractEntity busContract) throws Exception;
	
	public void getList() ;
	
	public void affirmButton(BusContractEntity t);
	
}
