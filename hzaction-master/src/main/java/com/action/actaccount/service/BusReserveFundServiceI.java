package com.action.actaccount.service;
import com.action.actaccount.entity.BusReserveFundEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BusReserveFundServiceI extends CommonService{
	
 	public void delete(BusReserveFundEntity entity) throws Exception;
 	
 	public Serializable save(BusReserveFundEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BusReserveFundEntity entity) throws Exception;
 	
}
