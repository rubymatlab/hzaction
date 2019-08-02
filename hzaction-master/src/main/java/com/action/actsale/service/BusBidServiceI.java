package com.action.actsale.service;
import com.action.actsale.entity.BusBidEntity;
import com.action.actsale.entity.VwBusBidEntity;

import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BusBidServiceI extends CommonService{
	
 	public void delete(BusBidEntity entity) throws Exception;
 	
 	public Serializable save(BusBidEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BusBidEntity entity) throws Exception;
 	
}
