package com.action.actsale.service;
import com.action.actsale.entity.BusProjectEntity;
import com.action.actsale.entity.BusProjectFeeDetailEntity;
import com.action.actsale.entity.BusProjectDisfollowEntity;
import com.action.actsale.entity.BusProjPartnerEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface BusProjectServiceI extends CommonService{
 	public void delete(BusProjectEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BusProjectEntity busProject,
	        List<BusProjectFeeDetailEntity> busProjectFeeDetailList,List<BusProjectDisfollowEntity> busProjectDisfollowList,List<BusProjPartnerEntity> busProjPartnerList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BusProjectEntity busProject,
	        List<BusProjectFeeDetailEntity> busProjectFeeDetailList,List<BusProjectDisfollowEntity> busProjectDisfollowList,List<BusProjPartnerEntity> busProjPartnerList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (BusProjectEntity busProject) throws Exception;
}
