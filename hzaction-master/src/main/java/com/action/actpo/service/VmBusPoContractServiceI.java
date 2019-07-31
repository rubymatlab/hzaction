package com.action.actpo.service;
import com.action.actpo.entity.VmBusPoContractEntity;
import com.action.actpo.entity.VmMergeBusPoApplyDetailEntity;
import com.action.actpo.entity.BusPoContractPayEntity;
import com.action.actpo.entity.BusPoContractDetailEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface VmBusPoContractServiceI extends CommonService{
 	public void delete(VmBusPoContractEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(VmBusPoContractEntity vmBusPoContract,
	        List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailList,List<BusPoContractPayEntity> busPoContractPayList,List<BusPoContractDetailEntity> busPoContractDetailList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(VmBusPoContractEntity vmBusPoContract,
	        List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailList,List<BusPoContractPayEntity> busPoContractPayList,List<BusPoContractDetailEntity> busPoContractDetailList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (VmBusPoContractEntity vmBusPoContract) throws Exception;
}
