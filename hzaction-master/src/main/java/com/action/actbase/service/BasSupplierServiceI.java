package com.action.actbase.service;
import com.action.actbase.entity.BasSupplierEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BasSupplierServiceI extends CommonService{
	
 	public void delete(BasSupplierEntity entity) throws Exception;
 	
 	public Serializable save(BasSupplierEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BasSupplierEntity entity) throws Exception;
 	
}
