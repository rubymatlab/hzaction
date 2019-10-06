package com.action.actsale.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.action.actproject.entity.BusCollectPlanEntity;
import com.action.actproject.entity.BusProjectManagerEntity;
import com.action.actsale.dao.BusContractMiniDao;
import com.action.actsale.entity.BusConQuotedPriceEntity;
import com.action.actsale.entity.BusContractEntity;
import com.action.actsale.entity.BusContractPaymentEntity;
import com.action.actsale.entity.BusCostBudgetingEntity;
import com.action.actsale.service.BusContractServiceI;

@Service("busContractService")
@Transactional
public class BusContractServiceImpl extends CommonServiceImpl implements BusContractServiceI {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BusContractServiceImpl.class);
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private BusContractMiniDao busContractMiniDao;
	
	/**
	 * 自定义按钮-[确认合同]业务处理
	 * @param id
	 * @return
	 */
	public void affirmButton(BusContractEntity t){
		//-----------------sql增强 start----------------------------
		//sql增强第1条
		//把合同状态修改成已审核(1)
		String sqlEnhance_1 ="update bus_contract set bc_contract_state = 1 where id = '#{id}'";
		this.executeSqlEnhance(sqlEnhance_1,t);
		
	 	String sqlEnhance_2 ="update bus_project set bpm_status='3' where id= '#{from_proj_id}'";
	 	this.executeSqlEnhance(sqlEnhance_2,t);
		//logger.info("-- 合同确定成功 --");


		//确定合同了，则向项目管理初始化添加一个项目管理对象
		BusProjectManagerEntity projectManagerEntity = this.addBusProjectManager(t);
		logger.info("-- 项目管理初始化添加1个数据对象 --");


		/**
		 * 1.根据合同管理主键获取该主键在合同约定收款的所有数据
		 * 2.合同约定收款有多少条记录就向项目收款计划表添加多少条数据（只需赋值：进度款分期，项目编号，项目管理外键，合同约定收款外键）
		 */
		List<BusContractPaymentEntity> contractPaymentList = busContractMiniDao.getListContractPayment(t.getId());
		//如果合同约定收款表有多少条数据,就向项目收款计划表添加多少个对象
		if(contractPaymentList.size()!=0) {
			String projectManagerId = projectManagerEntity.getId();//项目管理表主键
			for (BusContractPaymentEntity contractPaymentEntity : contractPaymentList) {
				//new项目收款计划对象
				BusCollectPlanEntity collectPlanEntity = new BusCollectPlanEntity();
				collectPlanEntity.setBrpProgressStages(contractPaymentEntity.getBcpProgrePayment());
				collectPlanEntity.setFromId(projectManagerId);//项目管理外键
				collectPlanEntity.setFromConpayId(contractPaymentEntity.getId());//合同约定收款外键
				this.save(collectPlanEntity);
			}
		}
		logger.info("-- 项目收款计划表添加"+contractPaymentList.size()+"个数据对象 --");
		//-----------------sql增强 end------------------------------



		//-----------------java增强 start---------------------------
		//-----------------java增强 end-----------------------------
	}
	public BusProjectManagerEntity addBusProjectManager(BusContractEntity t) {
		//String sqlInsert="insert into bus_project_manager values(:id,:bpm_name,:bpm_proj_prog,:bpm_prog_per,:bpm_status,:bpm_follow_remark,:from_proj_id,:from_cust_id)";
		BusProjectManagerEntity projectManagerEntity = new BusProjectManagerEntity();
		projectManagerEntity.setBpmName(t.getFromProjName());
		projectManagerEntity.setBpmStatus("0");
		projectManagerEntity.setBpmFollowRemark(t.getBcContAmount());
		projectManagerEntity.setFromProjId(t.getFromProjId());
		projectManagerEntity.setFromCustId(t.getFromCustId());
		
		projectManagerEntity.setBpmProjId(t.getBcProjectCode());//项目编号
		projectManagerEntity.setFromContractId(t.getId());	//合同管理外键
		
		this.save(projectManagerEntity);
		return projectManagerEntity;
	}

	private void executeSqlEnhance(String sqlEnhance,BusContractEntity t){
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
	private Map<String,Object> populationMap(BusContractEntity t){
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
		map.put("bc_customer_code", t.getBcCustomerCode());
		map.put("bc_customer_name", t.getBcCustomerName());
		map.put("bc_project_code", t.getBcProjectCode());
		map.put("bc_contract_name", t.getBcContractName());
		map.put("bc_cust_contractor", t.getBcCustContractor());
		map.put("bc_comp_contractor", t.getBcCompContractor());
		map.put("bc_conclude_time", t.getBcConcludeTime());
		map.put("bc_cont_start_time", t.getBcContStartTime());
		map.put("bc_cont_end_time", t.getBcContEndTime());
		map.put("bc_cont_amount", t.getBcContAmount());
		map.put("bc_contract_state", t.getBcContractState());
		map.put("from_proj_id", t.getFromProjId());
		map.put("from_proj_name", t.getFromProjName());
		map.put("from_cust_id", t.getFromCustId());
		return map;
	}

	public void getList() {
		String sql="UPDATE bus_contract set from_proj_name=:from_proj_name where bc_contract_state = 1;";
		Map map = new HashMap<String, String>();
		map.put("from_proj_name", "jeff");
		namedParameterJdbcTemplate.update(sql, map);
		System.out.println("更新完毕");
	}
	
	
 	public void delete(BusContractEntity entity) throws Exception{
 		super.delete(entity);
 	}
	public void addMain(BusContractEntity busContract,
	        List<BusConQuotedPriceEntity> busConQuotedPriceList,List<BusContractPaymentEntity> busContractPaymentList,List<BusCostBudgetingEntity> busCostBudgetingList) throws Exception{
			//保存主信息
			this.save(busContract);
		
			/**保存-合同明细报价附表*/
			for(BusConQuotedPriceEntity busConQuotedPrice:busConQuotedPriceList){
				//外键设置
				busConQuotedPrice.setBusContractId(busContract.getId());
				this.save(busConQuotedPrice);
			}
			/**保存-合同约定收款附表*/
			for(BusContractPaymentEntity busContractPayment:busContractPaymentList){
				//外键设置
				busContractPayment.setBusContractId(busContract.getId());
				this.save(busContractPayment);
			}
			/**保存-成本预算附表*/
			for(BusCostBudgetingEntity busCostBudgeting:busCostBudgetingList){
				//外键设置
				busCostBudgeting.setBusContractId(busContract.getId());
				this.save(busCostBudgeting);
			}
	}

	public void updateMain(BusContractEntity busContract,
	        List<BusConQuotedPriceEntity> busConQuotedPriceList,List<BusContractPaymentEntity> busContractPaymentList,List<BusCostBudgetingEntity> busCostBudgetingList) throws Exception {
		//保存主表信息
		if(StringUtil.isNotEmpty(busContract.getId())){
			try {
				BusContractEntity temp = findUniqueByProperty(BusContractEntity.class, "id", busContract.getId());
				MyBeanUtils.copyBeanNotNull2Bean(busContract, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(busContract);
		}
		//===================================================================================
		//获取参数
		Object id0 = busContract.getId();
		Object id1 = busContract.getId();
		Object id2 = busContract.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-合同明细报价附表
	    String hql0 = "from BusConQuotedPriceEntity where 1 = 1 AND busContractId = ? ";
	    List<BusConQuotedPriceEntity> busConQuotedPriceOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-合同明细报价附表
		if(busConQuotedPriceList!=null&&busConQuotedPriceList.size()>0){
		for(BusConQuotedPriceEntity oldE:busConQuotedPriceOldList){
			boolean isUpdate = false;
				for(BusConQuotedPriceEntity sendE:busConQuotedPriceList){
					//需要更新的明细数据-合同明细报价附表
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-合同明细报价附表
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-合同明细报价附表
			for(BusConQuotedPriceEntity busConQuotedPrice:busConQuotedPriceList){
				if(oConvertUtils.isEmpty(busConQuotedPrice.getId())){
					//外键设置
					busConQuotedPrice.setBusContractId(busContract.getId());
					this.save(busConQuotedPrice);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-合同约定收款附表
	    String hql1 = "from BusContractPaymentEntity where 1 = 1 AND busContractId = ? ";
	    List<BusContractPaymentEntity> busContractPaymentOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-合同约定收款附表
		if(busContractPaymentList!=null&&busContractPaymentList.size()>0){
		for(BusContractPaymentEntity oldE:busContractPaymentOldList){
			boolean isUpdate = false;
				for(BusContractPaymentEntity sendE:busContractPaymentList){
					//需要更新的明细数据-合同约定收款附表
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-合同约定收款附表
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-合同约定收款附表
			for(BusContractPaymentEntity busContractPayment:busContractPaymentList){
				if(oConvertUtils.isEmpty(busContractPayment.getId())){
					//外键设置
					busContractPayment.setBusContractId(busContract.getId());
					this.save(busContractPayment);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-成本预算附表
	    String hql2 = "from BusCostBudgetingEntity where 1 = 1 AND busContractId = ? ";
	    List<BusCostBudgetingEntity> busCostBudgetingOldList = this.findHql(hql2,id2);
		//2.筛选更新明细数据-成本预算附表
		if(busCostBudgetingList!=null&&busCostBudgetingList.size()>0){
		for(BusCostBudgetingEntity oldE:busCostBudgetingOldList){
			boolean isUpdate = false;
				for(BusCostBudgetingEntity sendE:busCostBudgetingList){
					//需要更新的明细数据-成本预算附表
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-成本预算附表
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-成本预算附表
			for(BusCostBudgetingEntity busCostBudgeting:busCostBudgetingList){
				if(oConvertUtils.isEmpty(busCostBudgeting.getId())){
					//外键设置
					busCostBudgeting.setBusContractId(busContract.getId());
					this.save(busCostBudgeting);
				}
			}
		}
	}

	public void delMain(BusContractEntity busContract) throws Exception{
		//删除主表信息
		this.delete(busContract);
		//===================================================================================
		//获取参数
		Object id0 = busContract.getId();
		Object id1 = busContract.getId();
		Object id2 = busContract.getId();
		//===================================================================================
		//删除-合同明细报价附表
	    String hql0 = "from BusConQuotedPriceEntity where 1 = 1 AND busContractId = ? ";
	    List<BusConQuotedPriceEntity> busConQuotedPriceOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(busConQuotedPriceOldList);
		//===================================================================================
		//删除-合同约定收款附表
	    String hql1 = "from BusContractPaymentEntity where 1 = 1 AND busContractId = ? ";
	    List<BusContractPaymentEntity> busContractPaymentOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(busContractPaymentOldList);
		//===================================================================================
		//删除-成本预算附表
	    String hql2 = "from BusCostBudgetingEntity where 1 = 1 AND busContractId = ? ";
	    List<BusCostBudgetingEntity> busCostBudgetingOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(busCostBudgetingOldList);
		
	}
 	
}