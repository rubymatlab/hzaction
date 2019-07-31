package com.action.actpo.service.impl;
import com.action.actpo.service.VmBusPoContractServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.action.actpo.entity.VmBusPoContractEntity;
import com.action.actpo.entity.VmMergeBusPoApplyDetailEntity;
import com.action.actpo.entity.BusPoContractPayEntity;
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

@Service("vmBusPoContractService")
@Transactional
public class VmBusPoContractServiceImpl extends CommonServiceImpl implements VmBusPoContractServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(VmBusPoContractEntity entity) throws Exception{
 		super.delete(entity);
 	}
	public void addMain(VmBusPoContractEntity vmBusPoContract,
	        List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailList,List<BusPoContractPayEntity> busPoContractPayList,List<BusPoContractDetailEntity> busPoContractDetailList) throws Exception{
			//保存主信息
			this.save(vmBusPoContract);
		
			/**保存-采购申请明细*/
			for(VmMergeBusPoApplyDetailEntity vmMergeBusPoApplyDetail:vmMergeBusPoApplyDetailList){
				//外键设置
				vmMergeBusPoApplyDetail.setFromId(vmBusPoContract.getId());
				this.save(vmMergeBusPoApplyDetail);
			}
			/**保存-采购合同付款明细*/
			for(BusPoContractPayEntity busPoContractPay:busPoContractPayList){
				//外键设置
				busPoContractPay.setFromId(vmBusPoContract.getId());
				this.save(busPoContractPay);
			}
			/**保存-采购合同明细*/
			for(BusPoContractDetailEntity busPoContractDetail:busPoContractDetailList){
				//外键设置
				busPoContractDetail.setFromId(vmBusPoContract.getId());
				this.save(busPoContractDetail);
			}
	}

	public void updateMain(VmBusPoContractEntity vmBusPoContract,
	        List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailList,List<BusPoContractPayEntity> busPoContractPayList,List<BusPoContractDetailEntity> busPoContractDetailList) throws Exception {
		//保存主表信息
		if(StringUtil.isNotEmpty(vmBusPoContract.getId())){
			try {
				VmBusPoContractEntity temp = findUniqueByProperty(VmBusPoContractEntity.class, "id", vmBusPoContract.getId());
				MyBeanUtils.copyBeanNotNull2Bean(vmBusPoContract, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(vmBusPoContract);
		}
		//===================================================================================
		//获取参数
		Object id0 = vmBusPoContract.getId();
		Object id1 = vmBusPoContract.getId();
		Object id2 = vmBusPoContract.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-采购申请明细
	    String hql0 = "from VmMergeBusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
	    List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-采购申请明细
		if(vmMergeBusPoApplyDetailList!=null&&vmMergeBusPoApplyDetailList.size()>0){
		for(VmMergeBusPoApplyDetailEntity oldE:vmMergeBusPoApplyDetailOldList){
			boolean isUpdate = false;
				for(VmMergeBusPoApplyDetailEntity sendE:vmMergeBusPoApplyDetailList){
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
			for(VmMergeBusPoApplyDetailEntity vmMergeBusPoApplyDetail:vmMergeBusPoApplyDetailList){
				if(oConvertUtils.isEmpty(vmMergeBusPoApplyDetail.getId())){
					//外键设置
					vmMergeBusPoApplyDetail.setFromId(vmBusPoContract.getId());
					this.save(vmMergeBusPoApplyDetail);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-采购合同付款明细
	    String hql1 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
	    List<BusPoContractPayEntity> busPoContractPayOldList = this.findHql(hql1,id1);
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
					busPoContractPay.setFromId(vmBusPoContract.getId());
					this.save(busPoContractPay);
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
					busPoContractDetail.setFromId(vmBusPoContract.getId());
					this.save(busPoContractDetail);
				}
			}
		}
	}

	public void delMain(VmBusPoContractEntity vmBusPoContract) throws Exception{
		//删除主表信息
		this.delete(vmBusPoContract);
		//===================================================================================
		//获取参数
		Object id0 = vmBusPoContract.getId();
		Object id1 = vmBusPoContract.getId();
		Object id2 = vmBusPoContract.getId();
		//===================================================================================
		//删除-采购申请明细
	    String hql0 = "from VmMergeBusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
	    List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(vmMergeBusPoApplyDetailOldList);
		//===================================================================================
		//删除-采购合同付款明细
	    String hql1 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
	    List<BusPoContractPayEntity> busPoContractPayOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(busPoContractPayOldList);
		//===================================================================================
		//删除-采购合同明细
	    String hql2 = "from BusPoContractDetailEntity where 1 = 1 AND fromId = ? ";
	    List<BusPoContractDetailEntity> busPoContractDetailOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(busPoContractDetailOldList);
		
	}
 	
}