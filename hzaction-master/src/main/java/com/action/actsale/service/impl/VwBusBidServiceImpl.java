package com.action.actsale.service.impl;
import com.action.actsale.service.VwBusBidServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.action.actsale.entity.VwBusBidEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("vwBusBidService")
@Transactional
public class VwBusBidServiceImpl extends CommonServiceImpl implements VwBusBidServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(VwBusBidEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(VwBusBidEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(VwBusBidEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	/**
	 * 自定义按钮-[审核]业务处理
	 * @param id
	 * @return
	 */
	 public void doVerifyBtnBus(VwBusBidEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update bus_bid set bd_state='1' where id= '#{id}'";
	 	this.executeSqlEnhance(sqlEnhance_1,t);
	 	String sqlEnhance_2 ="update bus_project set bpm_status='3' where id= '#{from_proj_id}'";
	 	this.executeSqlEnhance(sqlEnhance_2,t);
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(VwBusBidEntity t) throws Exception{
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
	private void doUpdateBus(VwBusBidEntity t) throws Exception{
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
	private void doDelBus(VwBusBidEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(VwBusBidEntity t){
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
		map.put("bp_proj_id", t.getBpProjId());
		map.put("bp_proj_name", t.getBpProjName());
		map.put("bp_date", t.getBpDate());
		map.put("bc_id", t.getBcId());
		map.put("bc_name", t.getBcName());
		map.put("bc_sname", t.getBcSname());
		map.put("bd_win_bidder", t.getBdWinBidder());
		map.put("bd_proj_type", t.getBdProjType());
		map.put("bd_main_bidder", t.getBdMainBidder());
		map.put("bd_coordinator", t.getBdCoordinator());
		map.put("bd_business_charge", t.getBdBusinessCharge());
		map.put("bd_auxiliary_staff", t.getBdAuxiliaryStaff());
		map.put("bd_bid_amout", t.getBdBidAmout());
		map.put("bd_bid_date", t.getBdBidDate());
		map.put("bd_bid_content", t.getBdBidContent());
		map.put("bd_state", t.getBdState());
		map.put("bd_bid_remark", t.getBdBidRemark());
		map.put("from_proj_id", t.getFromProjId());
		map.put("from_custj_id", t.getFromCustjId());
		map.put("bd_file", t.getBdFile());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,VwBusBidEntity t){
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
 		sql  = sql.replace("#{bp_proj_id}",String.valueOf(t.getBpProjId()));
 		sql  = sql.replace("#{bp_proj_name}",String.valueOf(t.getBpProjName()));
 		sql  = sql.replace("#{bp_date}",String.valueOf(t.getBpDate()));
 		sql  = sql.replace("#{bc_id}",String.valueOf(t.getBcId()));
 		sql  = sql.replace("#{bc_name}",String.valueOf(t.getBcName()));
 		sql  = sql.replace("#{bc_sname}",String.valueOf(t.getBcSname()));
 		sql  = sql.replace("#{bd_win_bidder}",String.valueOf(t.getBdWinBidder()));
 		sql  = sql.replace("#{bd_proj_type}",String.valueOf(t.getBdProjType()));
 		sql  = sql.replace("#{bd_main_bidder}",String.valueOf(t.getBdMainBidder()));
 		sql  = sql.replace("#{bd_coordinator}",String.valueOf(t.getBdCoordinator()));
 		sql  = sql.replace("#{bd_business_charge}",String.valueOf(t.getBdBusinessCharge()));
 		sql  = sql.replace("#{bd_auxiliary_staff}",String.valueOf(t.getBdAuxiliaryStaff()));
 		sql  = sql.replace("#{bd_bid_amout}",String.valueOf(t.getBdBidAmout()));
 		sql  = sql.replace("#{bd_bid_date}",String.valueOf(t.getBdBidDate()));
 		sql  = sql.replace("#{bd_bid_content}",String.valueOf(t.getBdBidContent()));
 		sql  = sql.replace("#{bd_state}",String.valueOf(t.getBdState()));
 		sql  = sql.replace("#{bd_bid_remark}",String.valueOf(t.getBdBidRemark()));
 		sql  = sql.replace("#{from_proj_id}",String.valueOf(t.getFromProjId()));
 		sql  = sql.replace("#{from_custj_id}",String.valueOf(t.getFromCustjId()));
 		sql  = sql.replace("#{bd_file}",String.valueOf(t.getBdFile()));
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
					javaInter.execute("vw_bus_bid",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
 	
 	private void executeSqlEnhance(String sqlEnhance,VwBusBidEntity t){
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