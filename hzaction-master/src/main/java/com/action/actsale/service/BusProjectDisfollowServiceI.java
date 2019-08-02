package com.action.actsale.service;
import com.action.actsale.entity.BusProjectDisfollowEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BusProjectDisfollowServiceI extends CommonService{
	
 	public void delete(BusProjectDisfollowEntity entity) throws Exception;
 	
 	public Serializable save(BusProjectDisfollowEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BusProjectDisfollowEntity entity) throws Exception;
 	
}
