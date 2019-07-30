package com.action.actproject.service.impl;
import com.action.actproject.service.BusProjectManagerServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.action.actproject.entity.BusProjectManagerEntity;
import com.action.actproject.entity.BusCollectPlanEntity;
import com.action.actproject.entity.BusProjectFollowEntity_manager;

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

@Service("busProjectManagerService")
@Transactional
public class BusProjectManagerServiceImpl extends CommonServiceImpl implements BusProjectManagerServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(BusProjectManagerEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus((BusProjectManagerEntity)entity);
 	}
	public void addMain(BusProjectManagerEntity busProjectManager,
	        List<BusCollectPlanEntity> busCollectPlanList,List<BusProjectFollowEntity_manager> busProjectFollowList) throws Exception{
			//保存主信息
			this.save(busProjectManager);
		
			/**保存-回款计划*/
			for(BusCollectPlanEntity busCollectPlan:busCollectPlanList){
				//外键设置
				busCollectPlan.setFromId(busProjectManager.getId());
				this.save(busCollectPlan);
			}
			/**保存-项目跟进*/
			for(BusProjectFollowEntity_manager busProjectFollow:busProjectFollowList){
				//外键设置
				busProjectFollow.setFromId(busProjectManager.getId());
				this.save(busProjectFollow);
			}
			//执行新增操作增强业务
 			this.doAddBus(busProjectManager);
	}

	public void updateMain(BusProjectManagerEntity busProjectManager,
	        List<BusCollectPlanEntity> busCollectPlanList,List<BusProjectFollowEntity_manager> busProjectFollowList) throws Exception {
		//保存主表信息
		if(StringUtil.isNotEmpty(busProjectManager.getId())){
			try {
				BusProjectManagerEntity temp = findUniqueByProperty(BusProjectManagerEntity.class, "id", busProjectManager.getId());
				MyBeanUtils.copyBeanNotNull2Bean(busProjectManager, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(busProjectManager);
		}
		//===================================================================================
		//获取参数
		Object id0 = busProjectManager.getId();
		Object id1 = busProjectManager.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-回款计划
	    String hql0 = "from BusCollectPlanEntity where 1 = 1 AND fromId = ? ";
	    List<BusCollectPlanEntity> busCollectPlanOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-回款计划
		if(busCollectPlanList!=null&&busCollectPlanList.size()>0){
		for(BusCollectPlanEntity oldE:busCollectPlanOldList){
			boolean isUpdate = false;
				for(BusCollectPlanEntity sendE:busCollectPlanList){
					//需要更新的明细数据-回款计划
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-回款计划
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-回款计划
			for(BusCollectPlanEntity busCollectPlan:busCollectPlanList){
				if(oConvertUtils.isEmpty(busCollectPlan.getId())){
					//外键设置
					busCollectPlan.setFromId(busProjectManager.getId());
					this.save(busCollectPlan);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-项目跟进
	    String hql1 = "from BusProjectFollowEntity_manager where 1 = 1 AND fromId = ? ";
	    List<BusProjectFollowEntity_manager> busProjectFollowOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-项目跟进
		if(busProjectFollowList!=null&&busProjectFollowList.size()>0){
		for(BusProjectFollowEntity_manager oldE:busProjectFollowOldList){
			boolean isUpdate = false;
				for(BusProjectFollowEntity_manager sendE:busProjectFollowList){
					//需要更新的明细数据-项目跟进
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-项目跟进
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-项目跟进
			for(BusProjectFollowEntity_manager busProjectFollow:busProjectFollowList){
				if(oConvertUtils.isEmpty(busProjectFollow.getId())){
					//外键设置
					busProjectFollow.setFromId(busProjectManager.getId());
					this.save(busProjectFollow);
				}
			}
		}
		//执行更新操作增强业务
 		this.doUpdateBus(busProjectManager);
	}

	public void delMain(BusProjectManagerEntity busProjectManager) throws Exception{
		//删除主表信息
		this.delete(busProjectManager);
		//===================================================================================
		//获取参数
		Object id0 = busProjectManager.getId();
		Object id1 = busProjectManager.getId();
		//===================================================================================
		//删除-回款计划
	    String hql0 = "from BusCollectPlanEntity where 1 = 1 AND fromId = ? ";
	    List<BusCollectPlanEntity> busCollectPlanOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(busCollectPlanOldList);
		//===================================================================================
		//删除-项目跟进
	    String hql1 = "from BusProjectFollowEntity_manager where 1 = 1 AND fromId = ? ";
	    List<BusProjectFollowEntity_manager> busProjectFollowOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(busProjectFollowOldList);
		
 		////执行删除操作增强业务
		this.doDelBus((BusProjectManagerEntity)busProjectManager);
	}
 	/**
	 * 自定义按钮-[审核]业务处理
	 * @param id
	 * @return
	 */
	 public void doUpdateStatusBus(BusProjectManagerEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update bus_project_manager set bpm_status='2' where id='#{id}'";
	 	this.executeSqlEnhance(sqlEnhance_1,t);
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(BusProjectManagerEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(BusProjectManagerEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(BusProjectManagerEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,BusProjectManagerEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{bpm_status}",String.valueOf(t.getBpmStatus()));
 		sql  = sql.replace("#{bpm_name}",String.valueOf(t.getBpmName()));
 		sql  = sql.replace("#{bpm_proj_prog}",String.valueOf(t.getBpmProjProg()));
 		sql  = sql.replace("#{bpm_prog_per}",String.valueOf(t.getBpmProgPer()));
 		sql  = sql.replace("#{bpm_follow_remark}",String.valueOf(t.getBpmFollowRemark()));
 		sql  = sql.replace("#{from_proj_id}",String.valueOf(t.getFromProjId()));
 		sql  = sql.replace("#{from_cust_id}",String.valueOf(t.getFromCustId()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("bus_project_manager",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
 	
 	private Map<String,Object> populationMap(BusProjectManagerEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("update_date", t.getUpdateDate());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("bpm_status", t.getBpmStatus());
		map.put("bpm_name", t.getBpmName());
		map.put("bpm_proj_prog", t.getBpmProjProg());
		map.put("bpm_prog_per", t.getBpmProgPer());
		map.put("bpm_follow_remark", t.getBpmFollowRemark());
		map.put("from_proj_id", t.getFromProjId());
		map.put("from_cust_id", t.getFromCustId());
		return map;
	}
	
 	private void executeSqlEnhance(String sqlEnhance,BusProjectManagerEntity t){
	 	Map<String,Object> data = populationMap(t);
	 	sqlEnhance = ResourceUtil.formateSQl(sqlEnhance, data);
	 	boolean isMiniDao = false;
	 	try {
	 		data = ResourceUtil.minidaoReplaceExtendSqlSysVar(data);
	 		sqlEnhance = FreemarkerParseFactory.parseTemplateContent(sqlEnhance, data);
			isMiniDao = true;
		} catch (Exception e) {
		}
	 	String [] sqls = sqlEnhance.split(";");
		for(String sql:sqls){
			if(sql == null || sql.toLowerCase().trim().equals("")){
				continue;
			}
			int num = 0;
			if(isMiniDao){
				num = namedParameterJdbcTemplate.update(sql, data);
			}else{
				num = this.executeSql(sql);
			}
		}
 	}
}