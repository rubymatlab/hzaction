package com.action.actaccount.service;
import com.action.actaccount.entity.BusCollectionEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BusCollectionServiceI extends CommonService{
	
 	public void delete(BusCollectionEntity entity) throws Exception;
 	
 	public Serializable save(BusCollectionEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BusCollectionEntity entity) throws Exception;
 	
}
