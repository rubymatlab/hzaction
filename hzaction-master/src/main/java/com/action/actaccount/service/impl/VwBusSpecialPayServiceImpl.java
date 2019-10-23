package com.action.actaccount.service.impl;
import com.action.actaccount.service.VwBusSpecialPayServiceI;
import com.action.actproject.entity.BusProjectManagerEntity;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.action.actaccount.entity.BusPayInfoEntity;
import com.action.actaccount.entity.VwBusSpecialPayEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("vwBusSpecialPayService")
@Transactional
public class VwBusSpecialPayServiceImpl extends CommonServiceImpl implements VwBusSpecialPayServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(VwBusSpecialPayEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(VwBusSpecialPayEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(VwBusSpecialPayEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	/**
	 * 自定义按钮-[送审]业务处理
	 * @param id
	 * @return
	 */
	 public void doAccessBus(VwBusSpecialPayEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[支付]业务处理
	 * @param id
	 * @return
	 */
	 public void doPayBus(VwBusSpecialPayEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }

		public void addMain(VwBusSpecialPayEntity vwBusSpecialPay,
		        List<BusPayInfoEntity> busPayInfoList) throws Exception{
				//保存主信息
				this.save(vwBusSpecialPay);
			
				/**保存-支付信息*/
				for(BusPayInfoEntity busPayInfo:busPayInfoList){
					//外键设置
					//busPayInfo.setBpiBusId(vwBusSpecialPay.getId());
					//外键设置
					//busPayInfo.setFromPayId(vwBusSpecialPay.getId());
					//外键设置
					//busPayInfo.setFromBankAccId(vwBusSpecialPay.getId());
					//外键设置
					//busPayInfo.setFromId(vwBusSpecialPay.getId());
					//外键设置
					busPayInfo.setFromSpecialId(vwBusSpecialPay.getId());
					this.save(busPayInfo);
				}
		}

		public void updateMain(VwBusSpecialPayEntity vwBusSpecialPay,
		        List<BusPayInfoEntity> busPayInfoList) throws Exception {
			//保存主表信息
			if(StringUtil.isNotEmpty(vwBusSpecialPay.getId())){
				try {
					VwBusSpecialPayEntity temp = findUniqueByProperty(VwBusSpecialPayEntity.class, "id", vwBusSpecialPay.getId());
					MyBeanUtils.copyBeanNotNull2Bean(vwBusSpecialPay, temp);
					this.saveOrUpdate(temp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				this.saveOrUpdate(vwBusSpecialPay);
			}
			
			List<BusProjectManagerEntity> listBusProjectManager=this.findByProperty(BusProjectManagerEntity.class, "bpmProjId", vwBusSpecialPay.getBpProjId());
			//===================================================================================
			//获取参数
			Object id0 = vwBusSpecialPay.getId();
			//===================================================================================
			//1.查询出数据库的明细数据-支付信息
		    String hql0 = "from BusPayInfoEntity where 1 = 1 AND fromSpecialId = ? ";
		    List<BusPayInfoEntity> busPayInfoOldList = this.findHql(hql0,id0);
			//2.筛选更新明细数据-支付信息
			if(busPayInfoList!=null&&busPayInfoList.size()>0){
			for(BusPayInfoEntity oldE:busPayInfoOldList){
				boolean isUpdate = false;
					for(BusPayInfoEntity sendE:busPayInfoList){
						//需要更新的明细数据-支付信息
						if(oldE.getId().equals(sendE.getId())){
			    			try {
			    				if(listBusProjectManager.size()>0)
			    					sendE.setFromProjmId(listBusProjectManager.get(0).getId());
								//外键设置
			    				sendE.setBpiBusId(vwBusSpecialPay.getId());
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
			    		//如果数据库存在的明细，前台没有传递过来则是删除-支付信息
			    		super.delete(oldE);
		    		}
		    		
				}
				//3.持久化新增的数据-支付信息
				for(BusPayInfoEntity busPayInfo:busPayInfoList){
					if(oConvertUtils.isEmpty(busPayInfo.getId())){
						if(listBusProjectManager.size()>0)
							busPayInfo.setFromProjmId(listBusProjectManager.get(0).getId());
						//外键设置
						busPayInfo.setBpiBusId(vwBusSpecialPay.getId());
						//busPayInfo.setFromPayId(vwBusSpecialPay.getId());
						//busPayInfo.setFromBankAccId(vwBusSpecialPay.getId());
						//busPayInfo.setFromId(vwBusSpecialPay.getId());
						busPayInfo.setFromSpecialId(vwBusSpecialPay.getId());
						this.save(busPayInfo);
					}
				}
			}
		}

		public void delMain(VwBusSpecialPayEntity vwBusSpecialPay) throws Exception{
			//删除主表信息
			this.delete(vwBusSpecialPay);
			//===================================================================================
			//获取参数
			Object id0 = vwBusSpecialPay.getId();
			//===================================================================================
			//删除-支付信息
		    String hql0 = "from BusPayInfoEntity where 1 = 1 AND fromSpecialId = ? ";
		    List<BusPayInfoEntity> busPayInfoOldList = this.findHql(hql0,id0);
			this.deleteAllEntitie(busPayInfoOldList);
			
		}
}