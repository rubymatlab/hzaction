package com.action.actsale.service;
import com.action.actsale.entity.BusProjPartnerEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BusProjPartnerServiceI extends CommonService{
	
 	public void delete(BusProjPartnerEntity entity) throws Exception;
 	
 	public Serializable save(BusProjPartnerEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BusProjPartnerEntity entity) throws Exception;
 	
}
