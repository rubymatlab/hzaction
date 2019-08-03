package com.action.actpo.service.impl;
import com.action.actpo.service.BusPoContractServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.action.actpo.entity.BusPoContractEntity;
import com.action.actpo.entity.BusPoContractPayEntity;
import com.action.actpo.entity.BusPoApplyDetailConEntity;
import com.action.actpo.entity.BusPoContractDetailEntity;

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

@Service("busPoContractService")
@Transactional
public class BusPoContractServiceImpl extends CommonServiceImpl implements BusPoContractServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(BusPoContractEntity entity) throws Exception{
 		super.delete(entity);
 	}
	public void addMain(BusPoContractEntity busPoContract,
	        List<BusPoContractPayEntity> busPoContractPayList,List<BusPoApplyDetailConEntity> busPoApplyDetailConList,List<BusPoContractDetailEntity> busPoContractDetailList) throws Exception{
			//保存主信息
			this.save(busPoContract);
		
			/**保存-采购合同付款明细*/
			for(BusPoContractPayEntity busPoContractPay:busPoContractPayList){
				//外键设置
				busPoContractPay.setFromId(busPoContract.getId());
				this.save(busPoContractPay);
			}
			/**保存-采购申请明细*/
			for(BusPoApplyDetailConEntity busPoApplyDetailCon:busPoApplyDetailConList){
				//外键设置
				busPoApplyDetailCon.setFromPoApplyDetId(busPoContract.getId());
				this.save(busPoApplyDetailCon);
			}
			/**保存-采购合同明细*/
			for(BusPoContractDetailEntity busPoContractDetail:busPoContractDetailList){
				//外键设置
				busPoContractDetail.setFromId(busPoContract.getId());
				this.save(busPoContractDetail);
			}
	}

	public void updateMain(BusPoContractEntity busPoContract,
	        List<BusPoContractPayEntity> busPoContractPayList,List<BusPoApplyDetailConEntity> busPoApplyDetailConList,List<BusPoContractDetailEntity> busPoContractDetailList) throws Exception {
		//保存主表信息
		if(StringUtil.isNotEmpty(busPoContract.getId())){
			try {
				BusPoContractEntity temp = findUniqueByProperty(BusPoContractEntity.class, "id", busPoContract.getId());
				MyBeanUtils.copyBeanNotNull2Bean(busPoContract, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(busPoContract);
		}
		//===================================================================================
		//获取参数
		Object id0 = busPoContract.getId();
		Object id1 = busPoContract.getId();
		Object id2 = busPoContract.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-采购合同付款明细
	    String hql0 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
	    List<BusPoContractPayEntity> busPoContractPayOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-采购合同付款明细
		if(busPoContractPayList!=null&&busPoContractPayList.size()>0){
		for(BusPoContractPayEntity oldE:busPoContractPayOldList){
			boolean isUpdate = false;
				for(BusPoContractPayEntity sendE:busPoContractPayList){
					//需要更新的明细数据-采购合同付款明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-采购合同付款明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-采购合同付款明细
			for(BusPoContractPayEntity busPoContractPay:busPoContractPayList){
				if(oConvertUtils.isEmpty(busPoContractPay.getId())){
					//外键设置
					busPoContractPay.setFromId(busPoContract.getId());
					this.save(busPoContractPay);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-采购申请明细
	    String hql1 = "from BusPoApplyDetailConEntity where 1 = 1 AND fromPoApplyDetId = ? ";
	    List<BusPoApplyDetailConEntity> busPoApplyDetailConOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-采购申请明细
		if(busPoApplyDetailConList!=null&&busPoApplyDetailConList.size()>0){
		for(BusPoApplyDetailConEntity oldE:busPoApplyDetailConOldList){
			boolean isUpdate = false;
				for(BusPoApplyDetailConEntity sendE:busPoApplyDetailConList){
					//需要更新的明细数据-采购申请明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-采购申请明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-采购申请明细
			for(BusPoApplyDetailConEntity busPoApplyDetailCon:busPoApplyDetailConList){
				if(oConvertUtils.isEmpty(busPoApplyDetailCon.getId())){
					//外键设置
					busPoApplyDetailCon.setFromPoApplyDetId(busPoContract.getId());
					this.save(busPoApplyDetailCon);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-采购合同明细
	    String hql2 = "from BusPoContractDetailEntity where 1 = 1 AND fromId = ? ";
	    List<BusPoContractDetailEntity> busPoContractDetailOldList = this.findHql(hql2,id2);
		//2.筛选更新明细数据-采购合同明细
		if(busPoContractDetailList!=null&&busPoContractDetailList.size()>0){
		for(BusPoContractDetailEntity oldE:busPoContractDetailOldList){
			boolean isUpdate = false;
				for(BusPoContractDetailEntity sendE:busPoContractDetailList){
					//需要更新的明细数据-采购合同明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-采购合同明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-采购合同明细
			for(BusPoContractDetailEntity busPoContractDetail:busPoContractDetailList){
				if(oConvertUtils.isEmpty(busPoContractDetail.getId())){
					//外键设置
					busPoContractDetail.setFromId(busPoContract.getId());
					this.save(busPoContractDetail);
				}
			}
		}
	}

	public void delMain(BusPoContractEntity busPoContract) throws Exception{
		//删除主表信息
		this.delete(busPoContract);
		//===================================================================================
		//获取参数
		Object id0 = busPoContract.getId();
		Object id1 = busPoContract.getId();
		Object id2 = busPoContract.getId();
		//===================================================================================
		//删除-采购合同付款明细
	    String hql0 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
	    List<BusPoContractPayEntity> busPoContractPayOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(busPoContractPayOldList);
		//===================================================================================
		//删除-采购申请明细
	    String hql1 = "from BusPoApplyDetailConEntity where 1 = 1 AND fromPoApplyDetId = ? ";
	    List<BusPoApplyDetailConEntity> busPoApplyDetailConOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(busPoApplyDetailConOldList);
		//===================================================================================
		//删除-采购合同明细
	    String hql2 = "from BusPoContractDetailEntity where 1 = 1 AND fromId = ? ";
	    List<BusPoContractDetailEntity> busPoContractDetailOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(busPoContractDetailOldList);
		
	}
 	
}