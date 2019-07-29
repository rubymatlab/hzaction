package com.action.actsale.service.impl;
import com.action.actsale.entity.BusProjectDetailEntity;
import com.action.actsale.entity.BusProjectFollowEntity;
import com.action.actsale.entity.VwBusProjectEntity;
import com.action.actsale.service.VwBusProjectServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;

import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("vwBusProjectService")
@Transactional
public class VwBusProjectServiceImpl extends CommonServiceImpl implements VwBusProjectServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(VwBusProjectEntity entity) throws Exception{
 		super.delete(entity);
 	}
	public void addMain(VwBusProjectEntity vwBusProject,
	        List<BusProjectDetailEntity> busProjectDetailList,List<BusProjectFollowEntity> busProjectFollowList) throws Exception{
			//保存主信息
			this.save(vwBusProject);
		
			/**保存-项目费用明细*/
			for(BusProjectDetailEntity busProjectDetail:busProjectDetailList){
				//外键设置
				busProjectDetail.setFromBpid(vwBusProject.getId());
				this.save(busProjectDetail);
			}
			/**保存-项目跟进分配*/
			for(BusProjectFollowEntity busProjectFollow:busProjectFollowList){
				//外键设置
				busProjectFollow.setFromBpid(vwBusProject.getId());
				this.save(busProjectFollow);
			}
	}

	public void updateMain(VwBusProjectEntity vwBusProject,
	        List<BusProjectDetailEntity> busProjectDetailList,List<BusProjectFollowEntity> busProjectFollowList) throws Exception {
		//保存主表信息
		if(StringUtil.isNotEmpty(vwBusProject.getId())){
			try {
				VwBusProjectEntity temp = findUniqueByProperty(VwBusProjectEntity.class, "id", vwBusProject.getId());
				MyBeanUtils.copyBeanNotNull2Bean(vwBusProject, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(vwBusProject);
		}
		//===================================================================================
		//获取参数
		Object id0 = vwBusProject.getId();
		Object id1 = vwBusProject.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-项目费用明细
	    String hql0 = "from BusProjectDetailEntity where 1 = 1 AND fromBpid = ? ";
	    List<BusProjectDetailEntity> busProjectDetailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-项目费用明细
		if(busProjectDetailList!=null&&busProjectDetailList.size()>0){
		for(BusProjectDetailEntity oldE:busProjectDetailOldList){
			boolean isUpdate = false;
				for(BusProjectDetailEntity sendE:busProjectDetailList){
					//需要更新的明细数据-项目费用明细
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-项目费用明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-项目费用明细
			for(BusProjectDetailEntity busProjectDetail:busProjectDetailList){
				if(oConvertUtils.isEmpty(busProjectDetail.getId())){
					//外键设置
					busProjectDetail.setFromBpid(vwBusProject.getId());
					this.save(busProjectDetail);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-项目跟进分配
	    String hql1 = "from BusProjectFollowEntity where 1 = 1 AND fromBpid = ? ";
	    List<BusProjectFollowEntity> busProjectFollowOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-项目跟进分配
		if(busProjectFollowList!=null&&busProjectFollowList.size()>0){
		for(BusProjectFollowEntity oldE:busProjectFollowOldList){
			boolean isUpdate = false;
				for(BusProjectFollowEntity sendE:busProjectFollowList){
					//需要更新的明细数据-项目跟进分配
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-项目跟进分配
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-项目跟进分配
			for(BusProjectFollowEntity busProjectFollow:busProjectFollowList){
				if(oConvertUtils.isEmpty(busProjectFollow.getId())){
					//外键设置
					busProjectFollow.setFromBpid(vwBusProject.getId());
					this.save(busProjectFollow);
				}
			}
		}
	}

	public void delMain(VwBusProjectEntity vwBusProject) throws Exception{
		//删除主表信息
		this.delete(vwBusProject);
		//===================================================================================
		//获取参数
		Object id0 = vwBusProject.getId();
		Object id1 = vwBusProject.getId();
		//===================================================================================
		//删除-项目费用明细
	    String hql0 = "from BusProjectDetailEntity where 1 = 1 AND fromBpid = ? ";
	    List<BusProjectDetailEntity> busProjectDetailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(busProjectDetailOldList);
		//===================================================================================
		//删除-项目跟进分配
	    String hql1 = "from BusProjectFollowEntity where 1 = 1 AND fromBpid = ? ";
	    List<BusProjectFollowEntity> busProjectFollowOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(busProjectFollowOldList);
		
	}
 	/**
	 * 自定义按钮-[立项转投标]业务处理
	 * @param id
	 * @return
	 */
	 public void doBtnAccessBus(VwBusProjectEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[立项转合同]业务处理
	 * @param id
	 * @return
	 */
	 public void doBtnAccessContentBus(VwBusProjectEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	
}