package com.action.actproject.service;
import com.action.actproject.entity.VwRpBusProgressInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VwRpBusProgressInfoServiceI extends CommonService{
	
 	public void delete(VwRpBusProgressInfoEntity entity) throws Exception;
 	
 	public Serializable save(VwRpBusProgressInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VwRpBusProgressInfoEntity entity) throws Exception;
 	
}
