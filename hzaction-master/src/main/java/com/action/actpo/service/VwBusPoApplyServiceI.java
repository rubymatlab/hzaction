package com.action.actpo.service;
import com.action.actpo.entity.VwBusPoApplyEntity;
import com.action.actpo.entity.BusPoApplyDetailEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface VwBusPoApplyServiceI extends CommonService{
 	public void delete(VwBusPoApplyEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(VwBusPoApplyEntity vwBusPoApply,
	        List<BusPoApplyDetailEntity> busPoApplyDetailList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(VwBusPoApplyEntity vwBusPoApply,
	        List<BusPoApplyDetailEntity> busPoApplyDetailList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (VwBusPoApplyEntity vwBusPoApply) throws Exception;
}
