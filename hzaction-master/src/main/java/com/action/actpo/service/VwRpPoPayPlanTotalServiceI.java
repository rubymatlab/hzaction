package com.action.actpo.service;
import com.action.actpo.entity.VwRpPoPayPlanTotalEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VwRpPoPayPlanTotalServiceI extends CommonService{
	
 	public void delete(VwRpPoPayPlanTotalEntity entity) throws Exception;
 	
 	public Serializable save(VwRpPoPayPlanTotalEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VwRpPoPayPlanTotalEntity entity) throws Exception;
 	
}
