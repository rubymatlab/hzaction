package com.action.actsale.service.impl;
import com.action.actsale.service.VwBusProjectServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.action.actsale.entity.VwBusProjectEntity;
import com.action.actsale.entity.BusProjectFeeDetailEntity;
import com.action.actsale.entity.BusProjectDisfollowEntity;
import com.action.actsale.entity.BusProjPartnerEntity;

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
	        List<BusProjectFeeDetailEntity> busProjectFeeDetailList,List<BusProjectDisfollowEntity> busProjectDisfollowList,List<BusProjPartnerEntity> busProjPartnerList) throws Exception{
			//保存主信息
			this.save(vwBusProject);
		
			/**保存-项目立项费用明细*/
			for(BusProjectFeeDetailEntity busProjectFeeDetail:busProjectFeeDetailList){
				//外键设置
				busProjectFeeDetail.setFromId(vwBusProject.getId());
				this.save(busProjectFeeDetail);
			}
			/**保存-分配跟进明细*/
			for(BusProjectDisfollowEntity busProjectDisfollow:busProjectDisfollowList){
				//外键设置
				busProjectDisfollow.setFromId(vwBusProject.getId());
				this.save(busProjectDisfollow);
			}
			/**保存-立项合作伙伴资料*/
			for(BusProjPartnerEntity busProjPartner:busProjPartnerList){
				//外键设置
				busProjPartner.setFromId(vwBusProject.getId());
				this.save(busProjPartner);
			}
	}

	public void updateMain(VwBusProjectEntity vwBusProject,
	        List<BusProjectFeeDetailEntity> busProjectFeeDetailList,List<BusProjectDisfollowEntity> busProjectDisfollowList,List<BusProjPartnerEntity> busProjPartnerList) throws Exception {
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
		Object id2 = vwBusProject.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-项目立项费用明细
	    String hql0 = "from BusProjectFeeDetailEntity where 1 = 1 AND fromId = ? ";
	    List<BusProjectFeeDetailEntity> busProjectFeeDetailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-项目立项费用明细
		if(busProjectFeeDetailList!=null&&busProjectFeeDetailList.size()>0){
		for(BusProjectFeeDetailEntity oldE:busProjectFeeDetailOldList){
			boolean isUpdate = false;
				for(BusProjectFeeDetailEntity sendE:busProjectFeeDetailList){
					//需要更新的明细数据-项目立项费用明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-项目立项费用明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-项目立项费用明细
			for(BusProjectFeeDetailEntity busProjectFeeDetail:busProjectFeeDetailList){
				if(oConvertUtils.isEmpty(busProjectFeeDetail.getId())){
					//外键设置
					busProjectFeeDetail.setFromId(vwBusProject.getId());
					this.save(busProjectFeeDetail);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-分配跟进明细
	    String hql1 = "from BusProjectDisfollowEntity where 1 = 1 AND fromId = ? ";
	    List<BusProjectDisfollowEntity> busProjectDisfollowOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-分配跟进明细
		if(busProjectDisfollowList!=null&&busProjectDisfollowList.size()>0){
		for(BusProjectDisfollowEntity oldE:busProjectDisfollowOldList){
			boolean isUpdate = false;
				for(BusProjectDisfollowEntity sendE:busProjectDisfollowList){
					//需要更新的明细数据-分配跟进明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-分配跟进明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-分配跟进明细
			for(BusProjectDisfollowEntity busProjectDisfollow:busProjectDisfollowList){
				if(oConvertUtils.isEmpty(busProjectDisfollow.getId())){
					//外键设置
					busProjectDisfollow.setFromId(vwBusProject.getId());
					this.save(busProjectDisfollow);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-立项合作伙伴资料
	    String hql2 = "from BusProjPartnerEntity where 1 = 1 AND fromId = ? ";
	    List<BusProjPartnerEntity> busProjPartnerOldList = this.findHql(hql2,id2);
		//2.筛选更新明细数据-立项合作伙伴资料
		if(busProjPartnerList!=null&&busProjPartnerList.size()>0){
		for(BusProjPartnerEntity oldE:busProjPartnerOldList){
			boolean isUpdate = false;
				for(BusProjPartnerEntity sendE:busProjPartnerList){
					//需要更新的明细数据-立项合作伙伴资料
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-立项合作伙伴资料
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-立项合作伙伴资料
			for(BusProjPartnerEntity busProjPartner:busProjPartnerList){
				if(oConvertUtils.isEmpty(busProjPartner.getId())){
					//外键设置
					busProjPartner.setFromId(vwBusProject.getId());
					this.save(busProjPartner);
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
		Object id2 = vwBusProject.getId();
		//===================================================================================
		//删除-项目立项费用明细
	    String hql0 = "from BusProjectFeeDetailEntity where 1 = 1 AND fromId = ? ";
	    List<BusProjectFeeDetailEntity> busProjectFeeDetailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(busProjectFeeDetailOldList);
		//===================================================================================
		//删除-分配跟进明细
	    String hql1 = "from BusProjectDisfollowEntity where 1 = 1 AND fromId = ? ";
	    List<BusProjectDisfollowEntity> busProjectDisfollowOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(busProjectDisfollowOldList);
		//===================================================================================
		//删除-立项合作伙伴资料
	    String hql2 = "from BusProjPartnerEntity where 1 = 1 AND fromId = ? ";
	    List<BusProjPartnerEntity> busProjPartnerOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(busProjPartnerOldList);
		
	}
 	/**
	 * 自定义按钮-[立项转投标]业务处理
	 * @param id
	 * @return
	 */
	 public void doBidBus(VwBusProjectEntity t) throws Exception{
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
	 public void doContractBus(VwBusProjectEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	
}