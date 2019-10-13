package com.action.actaccount.service;
import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.action.actaccount.entity.BusPayInfoEntity;
import com.action.actaccount.entity.VmBusPoContractPayWmtEntity;
import com.action.actaccount.entity.VmBusPoPayWmtEntity;

public interface VmBusPoPayWmtServiceI extends CommonService{
	public void delete(VmBusPoPayWmtEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(VmBusPoPayWmtEntity vmBusPoPayWmt,
	        List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtList,List<BusPayInfoEntity> busPayInfoList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(VmBusPoPayWmtEntity vmBusPoPayWmt,
	        List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtList,List<BusPayInfoEntity> busPayInfoList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (VmBusPoPayWmtEntity vmBusPoPayWmt) throws Exception;
	
	
	public void doAuditFinishSql(VmBusPoPayWmtEntity t) throws Exception;
	public void doSendAuditSql(VmBusPoPayWmtEntity t) throws Exception;
	public void doBpcpIdUpdate(String bpcpIds);
	public String getBpiVoucherno();
}
