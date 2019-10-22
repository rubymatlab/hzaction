package com.action.actaccount.service;
import com.action.actaccount.entity.VwBusSpecialPayEntity;
import com.action.actaccount.entity.BusPayInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;

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
	 
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(VwBusSpecialPayEntity vwBusSpecialPay,
	        List<BusPayInfoEntity> busPayInfoList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(VwBusSpecialPayEntity vwBusSpecialPay,
	        List<BusPayInfoEntity> busPayInfoList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (VwBusSpecialPayEntity vwBusSpecialPay) throws Exception;
}
