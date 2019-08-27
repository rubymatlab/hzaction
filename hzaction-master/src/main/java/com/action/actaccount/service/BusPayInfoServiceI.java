package com.action.actaccount.service;
import com.action.actaccount.entity.BusPayInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BusPayInfoServiceI extends CommonService{
	
 	public void delete(BusPayInfoEntity entity) throws Exception;
 	
 	public Serializable save(BusPayInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BusPayInfoEntity entity) throws Exception;
 	
}
