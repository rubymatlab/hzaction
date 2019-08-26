package com.action.actproject.service;
import com.action.actproject.entity.VwRpBusCollectPlanTotalEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VwRpBusCollectPlanTotalServiceI extends CommonService{
	
 	public void delete(VwRpBusCollectPlanTotalEntity entity) throws Exception;
 	
 	public Serializable save(VwRpBusCollectPlanTotalEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VwRpBusCollectPlanTotalEntity entity) throws Exception;
 	
}
