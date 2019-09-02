package com.action.actaccount.service.impl;
import com.action.actaccount.service.VwRpCostAccountServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.action.actaccount.entity.VwRpCostAccountEntity;
import com.action.actaccount.entity.VwBusPoContractPayEntity;

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

@Service("vwRpCostAccountService")
@Transactional
public class VwRpCostAccountServiceImpl extends CommonServiceImpl implements VwRpCostAccountServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(VwRpCostAccountEntity entity) throws Exception{
 		super.delete(entity);
 	}
	public void addMain(VwRpCostAccountEntity vwRpCostAccount,
	        List<VwBusPoContractPayEntity> vwBusPoContractPayList) throws Exception{
			//保存主信息
			this.save(vwRpCostAccount);
		
			/**保存-采购应付/已付明细*/
			for(VwBusPoContractPayEntity vwBusPoContractPay:vwBusPoContractPayList){
				//外键设置
				vwBusPoContractPay.setFormCostAccountId(vwRpCostAccount.getId());
				this.save(vwBusPoContractPay);
			}
	}

	public void updateMain(VwRpCostAccountEntity vwRpCostAccount,
	        List<VwBusPoContractPayEntity> vwBusPoContractPayList) throws Exception {
		//保存主表信息
		if(StringUtil.isNotEmpty(vwRpCostAccount.getId())){
			try {
				VwRpCostAccountEntity temp = findUniqueByProperty(VwRpCostAccountEntity.class, "id", vwRpCostAccount.getId());
				MyBeanUtils.copyBeanNotNull2Bean(vwRpCostAccount, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(vwRpCostAccount);
		}
		//===================================================================================
		//获取参数
		Object id0 = vwRpCostAccount.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-采购应付/已付明细
	    String hql0 = "from VwBusPoContractPayEntity where 1 = 1 AND formCostAccountId = ? ";
	    List<VwBusPoContractPayEntity> vwBusPoContractPayOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-采购应付/已付明细
		if(vwBusPoContractPayList!=null&&vwBusPoContractPayList.size()>0){
		for(VwBusPoContractPayEntity oldE:vwBusPoContractPayOldList){
			boolean isUpdate = false;
				for(VwBusPoContractPayEntity sendE:vwBusPoContractPayList){
					//需要更新的明细数据-采购应付/已付明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-采购应付/已付明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-采购应付/已付明细
			for(VwBusPoContractPayEntity vwBusPoContractPay:vwBusPoContractPayList){
				if(oConvertUtils.isEmpty(vwBusPoContractPay.getId())){
					//外键设置
					vwBusPoContractPay.setFormCostAccountId(vwRpCostAccount.getId());
					this.save(vwBusPoContractPay);
				}
			}
		}
	}

	public void delMain(VwRpCostAccountEntity vwRpCostAccount) throws Exception{
		//删除主表信息
		this.delete(vwRpCostAccount);
		//===================================================================================
		//获取参数
		Object id0 = vwRpCostAccount.getId();
		//===================================================================================
		//删除-采购应付/已付明细
	    String hql0 = "from VwBusPoContractPayEntity where 1 = 1 AND formCostAccountId = ? ";
	    List<VwBusPoContractPayEntity> vwBusPoContractPayOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(vwBusPoContractPayOldList);
		
	}
 	
}