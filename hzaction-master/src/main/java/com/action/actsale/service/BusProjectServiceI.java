package com.action.actsale.service;
import com.action.actsale.entity.BusProjectEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BusProjectServiceI extends CommonService{
	
 	public void delete(BusProjectEntity entity) throws Exception;
 	
 	public Serializable save(BusProjectEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BusProjectEntity entity) throws Exception;
 	
}
