package com.action.actbase.service.impl;
import com.action.actbase.entity.BasCustomerContactsEntity;
import com.action.actbase.entity.BasCustomerEntity;
import com.action.actbase.service.BasCustomerServiceI;

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

@Service("basCustomerService")
@Transactional
public class BasCustomerServiceImpl extends CommonServiceImpl implements BasCustomerServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(BasCustomerEntity entity) throws Exception{
 		super.delete(entity);
 	}
	public void addMain(BasCustomerEntity basCustomer,
	        List<BasCustomerContactsEntity> basCustomerContactsList) throws Exception{
			//保存主信息
			this.save(basCustomer);
		
			/**保存-客户资料明细*/
			for(BasCustomerContactsEntity basCustomerContacts:basCustomerContactsList){
				//外键设置
				basCustomerContacts.setFromId(basCustomer.getId());
				this.save(basCustomerContacts);
			}
	}

	public void updateMain(BasCustomerEntity basCustomer,
	        List<BasCustomerContactsEntity> basCustomerContactsList) throws Exception {
		//保存主表信息
		if(StringUtil.isNotEmpty(basCustomer.getId())){
			try {
				BasCustomerEntity temp = findUniqueByProperty(BasCustomerEntity.class, "id", basCustomer.getId());
				MyBeanUtils.copyBeanNotNull2Bean(basCustomer, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(basCustomer);
		}
		//===================================================================================
		//获取参数
		Object id0 = basCustomer.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-客户资料明细
	    String hql0 = "from BasCustomerContactsEntity where 1 = 1 AND fromId = ? ";
	    List<BasCustomerContactsEntity> basCustomerContactsOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-客户资料明细
		if(basCustomerContactsList!=null&&basCustomerContactsList.size()>0){
		for(BasCustomerContactsEntity oldE:basCustomerContactsOldList){
			boolean isUpdate = false;
				for(BasCustomerContactsEntity sendE:basCustomerContactsList){
					//需要更新的明细数据-客户资料明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-客户资料明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-客户资料明细
			for(BasCustomerContactsEntity basCustomerContacts:basCustomerContactsList){
				if(oConvertUtils.isEmpty(basCustomerContacts.getId())){
					//外键设置
					basCustomerContacts.setFromId(basCustomer.getId());
					this.save(basCustomerContacts);
				}
			}
		}
	}

	public void delMain(BasCustomerEntity basCustomer) throws Exception{
		//删除主表信息
		this.delete(basCustomer);
		//===================================================================================
		//获取参数
		Object id0 = basCustomer.getId();
		//===================================================================================
		//删除-客户资料明细
	    String hql0 = "from BasCustomerContactsEntity where 1 = 1 AND fromId = ? ";
	    List<BasCustomerContactsEntity> basCustomerContactsOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(basCustomerContactsOldList);
		
	}
 	
}