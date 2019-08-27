package com.action.actaccount.service;
import com.action.actaccount.entity.VwBusCollectionEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VwBusCollectionServiceI extends CommonService{
	
 	public void delete(VwBusCollectionEntity entity) throws Exception;
 	
 	public Serializable save(VwBusCollectionEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VwBusCollectionEntity entity) throws Exception;
 	
}
