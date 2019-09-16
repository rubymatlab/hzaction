package com.action.actpo.service.impl;
import com.action.actpo.service.VwBusPoApplyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.action.actpo.entity.VwBusPoApplyEntity;
import com.action.actpo.entity.BusPoApplyDetailEntity;

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

@Service("vwBusPoApplyService")
@Transactional
public class VwBusPoApplyServiceImpl extends CommonServiceImpl implements VwBusPoApplyServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(VwBusPoApplyEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus((VwBusPoApplyEntity)entity);
 	}
	public void addMain(VwBusPoApplyEntity vwBusPoApply,
	        List<BusPoApplyDetailEntity> busPoApplyDetailList) throws Exception{
			//保存主信息
			this.save(vwBusPoApply);
		
			/**保存-采购申请明细*/
			for(BusPoApplyDetailEntity busPoApplyDetail:busPoApplyDetailList){
				//外键设置
				busPoApplyDetail.setFromId(vwBusPoApply.getId());
				this.save(busPoApplyDetail);
			}
			//执行新增操作增强业务
 			this.doAddBus(vwBusPoApply);
	}

	public void updateMain(VwBusPoApplyEntity vwBusPoApply,
	        List<BusPoApplyDetailEntity> busPoApplyDetailList) throws Exception {
		//保存主表信息
		if(StringUtil.isNotEmpty(vwBusPoApply.getId())){
			try {
				VwBusPoApplyEntity temp = findUniqueByProperty(VwBusPoApplyEntity.class, "id", vwBusPoApply.getId());
				MyBeanUtils.copyBeanNotNull2Bean(vwBusPoApply, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(vwBusPoApply);
		}
		//===================================================================================
		//获取参数
		Object id0 = vwBusPoApply.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-采购申请明细
	    String hql0 = "from BusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
	    List<BusPoApplyDetailEntity> busPoApplyDetailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-采购申请明细
		if(busPoApplyDetailList!=null&&busPoApplyDetailList.size()>0){
		for(BusPoApplyDetailEntity oldE:busPoApplyDetailOldList){
			boolean isUpdate = false;
				for(BusPoApplyDetailEntity sendE:busPoApplyDetailList){
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
			for(BusPoApplyDetailEntity busPoApplyDetail:busPoApplyDetailList){
				if(oConvertUtils.isEmpty(busPoApplyDetail.getId())){
					//外键设置
					busPoApplyDetail.setFromId(vwBusPoApply.getId());
					this.save(busPoApplyDetail);
				}
			}
		}
		//执行更新操作增强业务
 		this.doUpdateBus(vwBusPoApply);
	}

	public void delMain(VwBusPoApplyEntity vwBusPoApply) throws Exception{
		//删除主表信息
		this.delete(vwBusPoApply);
		//===================================================================================
		//获取参数
		Object id0 = vwBusPoApply.getId();
		//===================================================================================
		//删除-采购申请明细
	    String hql0 = "from BusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
	    List<BusPoApplyDetailEntity> busPoApplyDetailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(busPoApplyDetailOldList);
		
 		////执行删除操作增强业务
		this.doDelBus((VwBusPoApplyEntity)vwBusPoApply);
	}
 	/**
	 * 自定义按钮-[审核完成]业务处理
	 * @param id
	 * @return
	 */
	 public void doBtn_shwcBus(VwBusPoApplyEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update bus_po_apply set bpa_state=2 ";
	 	this.executeSqlEnhance(sqlEnhance_1,t);
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[送审]业务处理
	 * @param id
	 * @return
	 */
	 public void doBtn_submitBus(VwBusPoApplyEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update bus_po_apply set bpa_state=2 ";
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
	private void doAddBus(VwBusPoApplyEntity t) throws Exception{
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
	private void doUpdateBus(VwBusPoApplyEntity t) throws Exception{
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
	private void doDelBus(VwBusPoApplyEntity t) throws Exception{
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
 	public String replaceVal(String sql,VwBusPoApplyEntity t){
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
 		sql  = sql.replace("#{bpa_apply_no}",String.valueOf(t.getBpaApplyNo()));
 		sql  = sql.replace("#{bpa_apply_date}",String.valueOf(t.getBpaApplyDate()));
 		sql  = sql.replace("#{bpa_rec_people}",String.valueOf(t.getBpaRecPeople()));
 		sql  = sql.replace("#{bpa_rec_tel}",String.valueOf(t.getBpaRecTel()));
 		sql  = sql.replace("#{bpa_rec_addr}",String.valueOf(t.getBpaRecAddr()));
 		sql  = sql.replace("#{bpa_apply_people}",String.valueOf(t.getBpaApplyPeople()));
 		sql  = sql.replace("#{bpa_state}",String.valueOf(t.getBpaState()));
 		sql  = sql.replace("#{from_projm_id}",String.valueOf(t.getFromProjmId()));
 		sql  = sql.replace("#{bpm_name}",String.valueOf(t.getBpmName()));
 		sql  = sql.replace("#{bc_name}",String.valueOf(t.getBcName()));
 		sql  = sql.replace("#{bp_manager}",String.valueOf(t.getBpManager()));
 		sql  = sql.replace("#{purchase_or_not}",String.valueOf(t.getPurchaseOrNot()));
 		sql  = sql.replace("#{bp_proj_id}",String.valueOf(t.getBpProjId()));
 		sql  = sql.replace("#{bus_project_manager_id}",String.valueOf(t.getBusProjectManagerId()));
 		sql  = sql.replace("#{bpa_file}",String.valueOf(t.getBpaFile()));
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
					javaInter.execute("vw_bus_po_apply",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
 	
 	private Map<String,Object> populationMap(VwBusPoApplyEntity t){
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
		map.put("bpa_apply_no", t.getBpaApplyNo());
		map.put("bpa_apply_date", t.getBpaApplyDate());
		map.put("bpa_rec_people", t.getBpaRecPeople());
		map.put("bpa_rec_tel", t.getBpaRecTel());
		map.put("bpa_rec_addr", t.getBpaRecAddr());
		map.put("bpa_apply_people", t.getBpaApplyPeople());
		map.put("bpa_state", t.getBpaState());
		map.put("from_projm_id", t.getFromProjmId());
		map.put("bpm_name", t.getBpmName());
		map.put("bc_name", t.getBcName());
		map.put("bp_manager", t.getBpManager());
		map.put("purchase_or_not", t.getPurchaseOrNot());
		map.put("bp_proj_id", t.getBpProjId());
		map.put("bus_project_manager_id", t.getBusProjectManagerId());
		map.put("bpa_file", t.getBpaFile());
		return map;
	}
	
 	private void executeSqlEnhance(String sqlEnhance,VwBusPoApplyEntity t){
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