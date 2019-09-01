package com.action.actsale.service;
import com.action.actsale.entity.VwBusBidEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VwBusBidServiceI extends CommonService{
	
 	public void delete(VwBusBidEntity entity) throws Exception;
 	
 	public Serializable save(VwBusBidEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VwBusBidEntity entity) throws Exception;
 	
 	/**
	 * 自定义按钮-[审核]业务处理
	 * @param id
	 * @return
	 */
	 public void doVerifyBtnBus(VwBusBidEntity t) throws Exception;
}
