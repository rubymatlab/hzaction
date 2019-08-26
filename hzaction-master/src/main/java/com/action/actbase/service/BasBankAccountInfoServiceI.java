package com.action.actbase.service;
import com.action.actbase.entity.BasBankAccountInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BasBankAccountInfoServiceI extends CommonService{
	
 	public void delete(BasBankAccountInfoEntity entity) throws Exception;
 	
 	public Serializable save(BasBankAccountInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BasBankAccountInfoEntity entity) throws Exception;
 	
}
