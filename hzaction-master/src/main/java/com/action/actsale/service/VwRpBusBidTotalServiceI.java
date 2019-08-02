package com.action.actsale.service;
import com.action.actsale.entity.VwRpBusBidTotalEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VwRpBusBidTotalServiceI extends CommonService{
	
 	public void delete(VwRpBusBidTotalEntity entity) throws Exception;
 	
 	public Serializable save(VwRpBusBidTotalEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VwRpBusBidTotalEntity entity) throws Exception;
 	
}
