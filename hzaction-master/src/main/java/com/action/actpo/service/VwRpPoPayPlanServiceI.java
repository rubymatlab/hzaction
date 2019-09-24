package com.action.actpo.service;
import com.action.actpo.entity.VwRpPoPayPlanEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VwRpPoPayPlanServiceI extends CommonService{
	
 	public void delete(VwRpPoPayPlanEntity entity) throws Exception;
 	
 	public Serializable save(VwRpPoPayPlanEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VwRpPoPayPlanEntity entity) throws Exception;
 	
}
