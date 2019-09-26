package com.action.actaccount.service;
import com.action.actaccount.entity.BsSubmitEntity;
import com.action.actaccount.entity.BusSubmitDetailEntity;
import com.action.actaccount.entity.BusPayInfoEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface BsSubmitServiceI extends CommonService{
 	public void delete(BsSubmitEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BsSubmitEntity bsSubmit,
	        List<BusSubmitDetailEntity> busSubmitDetailList,List<BusPayInfoEntity> busPayInfoList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BsSubmitEntity bsSubmit,
	        List<BusSubmitDetailEntity> busSubmitDetailList,List<BusPayInfoEntity> busPayInfoList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (BsSubmitEntity bsSubmit) throws Exception;
}
