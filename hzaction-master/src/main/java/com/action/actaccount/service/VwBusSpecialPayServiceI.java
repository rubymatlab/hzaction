package com.action.actaccount.service;
import com.action.actaccount.entity.VwBusSpecialPayEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VwBusSpecialPayServiceI extends CommonService{
	
 	public void delete(VwBusSpecialPayEntity entity) throws Exception;
 	
 	public Serializable save(VwBusSpecialPayEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VwBusSpecialPayEntity entity) throws Exception;
 	
 	/**
	 * 自定义按钮-[送审]业务处理
	 * @param id
	 * @return
	 */
	 public void doAccessBus(VwBusSpecialPayEntity t) throws Exception;
 	/**
	 * 自定义按钮-[支付]业务处理
	 * @param id
	 * @return
	 */
	 public void doPayBus(VwBusSpecialPayEntity t) throws Exception;
}
