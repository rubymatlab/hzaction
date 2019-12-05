package com.action.actbase.service;
import com.action.actbase.entity.BasInvoiceEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BasInvoiceServiceI extends CommonService{
	
 	public void delete(BasInvoiceEntity entity) throws Exception;
 	
 	public Serializable save(BasInvoiceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BasInvoiceEntity entity) throws Exception;
 	
}
