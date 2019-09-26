package com.action.actaccount.service;
import com.action.actaccount.entity.VwRpBusPayInfoTotalEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VwRpBusPayInfoTotalServiceI extends CommonService{
	
 	public void delete(VwRpBusPayInfoTotalEntity entity) throws Exception;
 	
 	public Serializable save(VwRpBusPayInfoTotalEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VwRpBusPayInfoTotalEntity entity) throws Exception;
 	
}
