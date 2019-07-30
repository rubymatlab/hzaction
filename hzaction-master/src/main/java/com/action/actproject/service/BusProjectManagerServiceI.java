package com.action.actproject.service;
import com.action.actproject.entity.BusProjectManagerEntity;
import com.action.actproject.entity.BusCollectPlanEntity;
import com.action.actproject.entity.BusProjectFollowEntity_manager;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface BusProjectManagerServiceI extends CommonService{
 	public void delete(BusProjectManagerEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BusProjectManagerEntity busProjectManager,
	        List<BusCollectPlanEntity> busCollectPlanList,List<BusProjectFollowEntity_manager> busProjectFollowList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BusProjectManagerEntity busProjectManager,
	        List<BusCollectPlanEntity> busCollectPlanList,List<BusProjectFollowEntity_manager> busProjectFollowList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (BusProjectManagerEntity busProjectManager) throws Exception;
	
	public void doUpdateStatusBus (BusProjectManagerEntity busProjectManager) throws Exception;
	
	
}
