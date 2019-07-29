package com.action.actsale.service;
import java.util.List;
import org.jeecgframework.core.common.service.CommonService;

import com.action.actsale.entity.BusProjectDetailEntity;
import com.action.actsale.entity.BusProjectEntity;
import com.action.actsale.entity.BusProjectFollowEntity;

import java.io.Serializable;

public interface BusProjectServiceI extends CommonService{
 	public void delete(BusProjectEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BusProjectEntity busProject,
	        List<BusProjectFollowEntity> busProjectFollowList,List<BusProjectDetailEntity> busProjectDetailList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BusProjectEntity busProject,
	        List<BusProjectFollowEntity> busProjectFollowList,List<BusProjectDetailEntity> busProjectDetailList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (BusProjectEntity busProject) throws Exception;
}
