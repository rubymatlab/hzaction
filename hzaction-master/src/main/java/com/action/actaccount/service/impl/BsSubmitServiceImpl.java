package com.action.actaccount.service.impl;
import com.action.actaccount.service.BsSubmitServiceI;
import com.action.actproject.entity.BusProjectManagerEntity;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.action.actaccount.dao.ActaccountDao;
import com.action.actaccount.entity.BsSubmitEntity;
import com.action.actaccount.entity.BusSubmitDetailEntity;
import com.action.actaccount.entity.BusPayInfoEntity;

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

@Service("bsSubmitService")
@Transactional
public class BsSubmitServiceImpl extends CommonServiceImpl implements BsSubmitServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private ActaccountDao actaccountDao;
 	public void delete(BsSubmitEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus((BsSubmitEntity)entity);
 	}
	public void addMain(BsSubmitEntity bsSubmit,
	        List<BusSubmitDetailEntity> busSubmitDetailList,List<BusPayInfoEntity> busPayInfoList) throws Exception{
			//保存主信息
			this.save(bsSubmit);
		
			/**保存-费用报销明细*/
			for(BusSubmitDetailEntity busSubmitDetail:busSubmitDetailList){
				//外键设置
				busSubmitDetail.setFromId(bsSubmit.getId());
				this.save(busSubmitDetail);
			}
			/**保存-支付信息*/
			for(BusPayInfoEntity busPayInfo:busPayInfoList){
				//外键设置
				busPayInfo.setBpiBusId(bsSubmit.getId());
				//外键设置
				busPayInfo.setFromPayId(bsSubmit.getId());
				//外键设置
				busPayInfo.setFromBankAccId(bsSubmit.getId());
				//外键设置
				busPayInfo.setFromId(bsSubmit.getId());
				this.save(busPayInfo);
			}
			//执行新增操作增强业务
 			this.doAddBus(bsSubmit);
	}

	public void updateMain(BsSubmitEntity bsSubmit,
	        List<BusSubmitDetailEntity> busSubmitDetailList,List<BusPayInfoEntity> busPayInfoList) throws Exception {
		//保存主表信息
		if(StringUtil.isNotEmpty(bsSubmit.getId())){
			try {
				BsSubmitEntity temp = findUniqueByProperty(BsSubmitEntity.class, "id", bsSubmit.getId());
				MyBeanUtils.copyBeanNotNull2Bean(bsSubmit, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(bsSubmit);
		}
		//===================================================================================
		//获取参数
		Object id0 = bsSubmit.getId();
		Object id1 = bsSubmit.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-费用报销明细
	    String hql0 = "from BusSubmitDetailEntity where 1 = 1 AND fromId = ? ";
	    List<BusSubmitDetailEntity> busSubmitDetailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-费用报销明细
		if(busSubmitDetailList!=null&&busSubmitDetailList.size()>0){
		for(BusSubmitDetailEntity oldE:busSubmitDetailOldList){
			boolean isUpdate = false;
				for(BusSubmitDetailEntity sendE:busSubmitDetailList){
					//需要更新的明细数据-费用报销明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-费用报销明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-费用报销明细
			for(BusSubmitDetailEntity busSubmitDetail:busSubmitDetailList){
				if(oConvertUtils.isEmpty(busSubmitDetail.getId())){
					//外键设置
					busSubmitDetail.setFromId(bsSubmit.getId());
					this.save(busSubmitDetail);
				}
			}
		}
		List<BusProjectManagerEntity> listBusProjectManager=this.findByProperty(BusProjectManagerEntity.class, "fromProjId", bsSubmit.getFromProjmId());
		//===================================================================================
		//1.查询出数据库的明细数据-支付信息
	    String hql1 = "from BusPayInfoEntity where 1 = 1 AND fromId = ? ";
	    List<BusPayInfoEntity> busPayInfoOldList = this.findHql(hql1,id1);
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
		    				sendE.setBpiBusId(bsSubmit.getId());
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
					busPayInfo.setBpiBusId(bsSubmit.getId());
					//busPayInfo.setFromPayId(bsSubmit.getId());
					//busPayInfo.setFromBankAccId(bsSubmit.getId());
					busPayInfo.setFromId(bsSubmit.getId());
					this.save(busPayInfo);
				}
			}
		}
		//执行更新操作增强业务
 		this.doUpdateBus(bsSubmit);
	}

	public void delMain(BsSubmitEntity bsSubmit) throws Exception{
		//删除主表信息
		this.delete(bsSubmit);
		//===================================================================================
		//获取参数
		Object id0 = bsSubmit.getId();
		Object id1 = bsSubmit.getId();
		//===================================================================================
		//删除-费用报销明细
	    String hql0 = "from BusSubmitDetailEntity where 1 = 1 AND fromId = ? ";
	    List<BusSubmitDetailEntity> busSubmitDetailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(busSubmitDetailOldList);
		//===================================================================================
		//删除-支付信息
	    String hql1 = "from BusPayInfoEntity where 1 = 1 AND fromId = ? ";
	    List<BusPayInfoEntity> busPayInfoOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(busPayInfoOldList);
		
 		////执行删除操作增强业务
		this.doDelBus((BsSubmitEntity)bsSubmit);
	}
 	/**
	 * 自定义按钮-[送审]业务处理
	 * @param id
	 * @return
	 */
	 public void doUnauditedBus(BsSubmitEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="UPDATE  bs_submit SET   bs_state=1 WHERE id = #{id}";
	 	this.executeSqlEnhance(sqlEnhance_1,t);
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[审核完成]业务处理
	 * @param id
	 * @return
	 */
	 public void doAuditedBus(BsSubmitEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="UPDATE bs_submit  SET  bs_state=2 WHERE id = #{id}";
	 	this.executeSqlEnhance(sqlEnhance_1,t);
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[支付]业务处理
	 * @param id
	 * @return
	 */
	 public void doPayBus(BsSubmitEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="UPDATE  bs_submit SET   bs_state=1 WHERE id = #{id}";
	 	this.executeSqlEnhance(sqlEnhance_1,t);
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[打印]业务处理
	 * @param id
	 * @return
	 */
	 public void doPrintBus(BsSubmitEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="UPDATE  bs_submit SET   bs_state=1 WHERE id = #{id}";
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
	private void doAddBus(BsSubmitEntity t) throws Exception{
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
	private void doUpdateBus(BsSubmitEntity t) throws Exception{
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
	private void doDelBus(BsSubmitEntity t) throws Exception{
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
 	public String replaceVal(String sql,BsSubmitEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{bpm_status}",String.valueOf(t.getBpmStatus()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{project_name}",String.valueOf(t.getProjectName()));
 		sql  = sql.replace("#{project_id}",String.valueOf(t.getProjectId()));
 		sql  = sql.replace("#{bs_submiter}",String.valueOf(t.getBsSubmiter()));
 		sql  = sql.replace("#{bs_submit_id}",String.valueOf(t.getBsSubmitId()));
 		sql  = sql.replace("#{bs_dept}",String.valueOf(t.getBsDept()));
 		sql  = sql.replace("#{bs_begin_date}",String.valueOf(t.getBsBeginDate()));
 		sql  = sql.replace("#{bs_submit_date}",String.valueOf(t.getBsSubmitDate()));
 		sql  = sql.replace("#{bs_remarks}",String.valueOf(t.getBsRemarks()));
 		sql  = sql.replace("#{bs_bill_type}",String.valueOf(t.getBsBillType()));
 		sql  = sql.replace("#{bs_state}",String.valueOf(t.getBsState()));
 		sql  = sql.replace("#{total_money}",String.valueOf(t.getTotalMoney()));
 		sql  = sql.replace("#{total_money_cn}",String.valueOf(t.getTotalMoneyCn()));
 		sql  = sql.replace("#{bs_annex}",String.valueOf(t.getBsAnnex()));
 		sql  = sql.replace("#{from_projm_id}",String.valueOf(t.getFromProjmId()));
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
					javaInter.execute("bs_submit",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
 	
 	private Map<String,Object> populationMap(BsSubmitEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("bpm_status", t.getBpmStatus());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("create_date", t.getCreateDate());
		map.put("update_date", t.getUpdateDate());
		map.put("project_name", t.getProjectName());
		map.put("project_id", t.getProjectId());
		map.put("bs_submiter", t.getBsSubmiter());
		map.put("bs_submit_id", t.getBsSubmitId());
		map.put("bs_dept", t.getBsDept());
		map.put("bs_begin_date", t.getBsBeginDate());
		map.put("bs_submit_date", t.getBsSubmitDate());
		map.put("bs_remarks", t.getBsRemarks());
		map.put("bs_bill_type", t.getBsBillType());
		map.put("bs_state", t.getBsState());
		map.put("total_money", t.getTotalMoney());
		map.put("total_money_cn", t.getTotalMoneyCn());
		map.put("bs_annex", t.getBsAnnex());
		map.put("from_projm_id", t.getFromProjmId());
		return map;
	}
	
 	private void executeSqlEnhance(String sqlEnhance,BsSubmitEntity t){
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
	@Override
	public String getBsSubmitId(String bsSubmitId) {
		// TODO Auto-generated method stub
		return actaccountDao.findByBsSubmitId(bsSubmitId);
	}
}