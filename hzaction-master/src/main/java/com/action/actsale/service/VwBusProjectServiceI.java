package com.action.actsale.service;
import java.util.List;
import org.jeecgframework.core.common.service.CommonService;

import com.action.actsale.entity.BusProjectDetailEntity;
import com.action.actsale.entity.BusProjectFollowEntity;
import com.action.actsale.entity.VwBusProjectEntity;

import java.io.Serializable;

public interface VwBusProjectServiceI extends CommonService{
 	public void delete(VwBusProjectEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(VwBusProjectEntity vwBusProject,
	        List<BusProjectDetailEntity> busProjectDetailList,List<BusProjectFollowEntity> busProjectFollowList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(VwBusProjectEntity vwBusProject,
	        List<BusProjectDetailEntity> busProjectDetailList,List<BusProjectFollowEntity> busProjectFollowList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (VwBusProjectEntity vwBusProject) throws Exception;
}
