package com.action.actproject.service;
import com.action.actproject.entity.VmBusProjectManagerEntity;
import com.action.actproject.entity.VmBusCollectPlanEntity;
import com.action.actproject.entity.BusProjectFollowEntity_manager;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface VmBusProjectManagerServiceI extends CommonService{
 	public void delete(VmBusProjectManagerEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(VmBusProjectManagerEntity vmBusProjectManager,
	        List<VmBusCollectPlanEntity> vmBusCollectPlanList,List<BusProjectFollowEntity_manager> busProjectFollowList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(VmBusProjectManagerEntity vmBusProjectManager,
	        List<VmBusCollectPlanEntity> vmBusCollectPlanList,List<BusProjectFollowEntity_manager> busProjectFollowList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	
	public void delMain (VmBusProjectManagerEntity vmBusProjectManager) throws Exception;
	
	/*
	 * 修改状态
	 * */
	
	public void doUpdateStatusBus (VmBusProjectManagerEntity vmBusProjectManager) throws Exception;
	
	/*
	 * 刷新
	 * */
	public void doReloadBus (VmBusProjectManagerEntity vmBusProjectManager) throws Exception;
}

