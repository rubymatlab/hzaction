package com.action.actsale.service;
import com.action.actsale.entity.BusProjectFeeDetailEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BusProjectFeeDetailServiceI extends CommonService{
	
 	public void delete(BusProjectFeeDetailEntity entity) throws Exception;
 	
 	public Serializable save(BusProjectFeeDetailEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BusProjectFeeDetailEntity entity) throws Exception;
 	
}
