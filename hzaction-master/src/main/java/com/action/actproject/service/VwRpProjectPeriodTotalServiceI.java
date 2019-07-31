package com.action.actproject.service;
import com.action.actproject.entity.VwRpProjectPeriodTotalEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VwRpProjectPeriodTotalServiceI extends CommonService{
	
 	public void delete(VwRpProjectPeriodTotalEntity entity) throws Exception;
 	
 	public Serializable save(VwRpProjectPeriodTotalEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VwRpProjectPeriodTotalEntity entity) throws Exception;
 	
}
