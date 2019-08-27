package com.action.actproject.service;
import com.action.actproject.entity.VmBusCollectPlanEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VmBusCollectPlanServiceI extends CommonService{
	
 	public void delete(VmBusCollectPlanEntity entity) throws Exception;
 	
 	public Serializable save(VmBusCollectPlanEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VmBusCollectPlanEntity entity) throws Exception;
 	
}
