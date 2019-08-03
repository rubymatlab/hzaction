package com.action.actpo.service;
import com.action.actpo.entity.BusPoContractEntity;
import com.action.actpo.entity.BusPoContractPayEntity;
import com.action.actpo.entity.BusPoApplyDetailConEntity;
import com.action.actpo.entity.BusPoContractDetailEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface BusPoContractServiceI extends CommonService{
 	public void delete(BusPoContractEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BusPoContractEntity busPoContract,
	        List<BusPoContractPayEntity> busPoContractPayList,List<BusPoApplyDetailConEntity> busPoApplyDetailConList,List<BusPoContractDetailEntity> busPoContractDetailList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BusPoContractEntity busPoContract,
	        List<BusPoContractPayEntity> busPoContractPayList,List<BusPoApplyDetailConEntity> busPoApplyDetailConList,List<BusPoContractDetailEntity> busPoContractDetailList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (BusPoContractEntity busPoContract) throws Exception;
}
