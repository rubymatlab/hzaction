package com.action.actpo.service;
import com.action.actpo.entity.BusPoApplyEntity;
import com.action.actpo.entity.BusPoApplyDetailEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface BusPoApplyServiceI extends CommonService{
 	public void delete(BusPoApplyEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BusPoApplyEntity busPoApply,
	        List<BusPoApplyDetailEntity> busPoApplyDetailList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BusPoApplyEntity busPoApply,
	        List<BusPoApplyDetailEntity> busPoApplyDetailList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (BusPoApplyEntity busPoApply) throws Exception;
}
