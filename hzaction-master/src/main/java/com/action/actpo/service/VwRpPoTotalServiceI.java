package com.action.actpo.service;
import com.action.actpo.entity.VwRpPoTotalEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VwRpPoTotalServiceI extends CommonService{
	
 	public void delete(VwRpPoTotalEntity entity) throws Exception;
 	
 	public Serializable save(VwRpPoTotalEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VwRpPoTotalEntity entity) throws Exception;
 	
}
