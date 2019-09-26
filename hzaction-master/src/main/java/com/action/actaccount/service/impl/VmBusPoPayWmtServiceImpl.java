package com.action.actaccount.service.impl;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.action.actaccount.dao.ActaccountDao;
import com.action.actaccount.entity.BusPayInfoEntity;
import com.action.actaccount.entity.BusPoPayWmtEntity;
import com.action.actaccount.entity.VmBusPoContractPayWmtEntity;
import com.action.actaccount.entity.VmBusPoPayWmtEntity;
import com.action.actaccount.service.VmBusPoPayWmtServiceI;

@Service("vmBusPoPayWmtService")
@Transactional
public class VmBusPoPayWmtServiceImpl extends CommonServiceImpl implements VmBusPoPayWmtServiceI {
	private static final Logger logger = LoggerFactory.getLogger(VmBusPoPayWmtServiceImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private ActaccountDao actaccountDao;

	//把虚表【vm_bus_po_pay_wmt】的对象属性值赋值给实体表【bus_po_pay】
	public BusPoPayWmtEntity returnBusPoPayEntity(VmBusPoPayWmtEntity vmEntity) {
		BusPoPayWmtEntity busPoPayWmtEntity = new BusPoPayWmtEntity();
		busPoPayWmtEntity.setId(vmEntity.getId());
		busPoPayWmtEntity.setBppPayId(vmEntity.getBppPayId());
		busPoPayWmtEntity.setBppInvType(vmEntity.getBppInvType());
		busPoPayWmtEntity.setBppInvAmount(vmEntity.getBppInvAmount());
		busPoPayWmtEntity.setBppTaxRate(vmEntity.getBppTaxRate());
		busPoPayWmtEntity.setBppPayDate(vmEntity.getBppPayDate());
		busPoPayWmtEntity.setBppState(vmEntity.getBppState());
		busPoPayWmtEntity.setBppMoney(vmEntity.getBppMoney());
		busPoPayWmtEntity.setFromProjmId(vmEntity.getFromProjId());
		busPoPayWmtEntity.setFromSuppId(vmEntity.getFromSuppId());
		busPoPayWmtEntity.setBppAccessory(vmEntity.getBppAccessory());
		
		//赋值CG自带的系统属性值
		busPoPayWmtEntity.setCreateDate(vmEntity.getCreateDate());
		busPoPayWmtEntity.setCreateName(vmEntity.getCreateName());
		busPoPayWmtEntity.setCreateBy(vmEntity.getCreateBy());
		busPoPayWmtEntity.setUpdateName(vmEntity.getUpdateName());
		busPoPayWmtEntity.setUpdateBy(vmEntity.getUpdateBy());
		busPoPayWmtEntity.setUpdateDate(vmEntity.getUpdateDate());
		busPoPayWmtEntity.setSysOrgCode(vmEntity.getSysOrgCode());
		busPoPayWmtEntity.setSysCompanyCode(vmEntity.getSysCompanyCode());
		busPoPayWmtEntity.setBpmStatus(vmEntity.getBpmStatus());
		
		return busPoPayWmtEntity;
	}

	public void delete(VmBusPoPayWmtEntity entity) throws Exception{
		super.delete(entity);
		//执行删除操作增强业务
		this.doDelBus((VmBusPoPayWmtEntity)entity);
	}

	public String getNowBppPayId(String nowBppPayId) {
		//String nowBppPayId = "AX-2018-客户简称-项目编号-FK-002";	
		String year = Calendar.getInstance().get(Calendar.YEAR)+"";
		String[] split = nowBppPayId.split("-");
		String nowYear = split[1];
		String number = split[split.length-1];

		if(!year.equals(nowYear)) return nowBppPayId.replace(nowYear, year).replace(number,"001");
		int i = Integer.parseInt(number);
		String nowNumber = null;
		if(i>=0&&i<9) {
			nowNumber = "00"+(i+1);
		}else if(i>=9&&i<99) {
			nowNumber = "0"+(i+1);
		}else if(i>=99){
			nowNumber = ""+(i+1);
		}
		return nowBppPayId.replace(number, nowNumber);
	}

	public void addMain(VmBusPoPayWmtEntity vmBusPoPayWmt,
			List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtList,List<BusPayInfoEntity> busPayInfoList) throws Exception{
		//自动生成【采购付款单视图表】的付款单号bpp_pay_id，
		logger.info("自动生成付款单号：{}",vmBusPoPayWmt.getBppPayId());
		//获取当前最新付款单号
		String nowBppPayId1 = actaccountDao.getNowByBppPayId().get("bpp_pay_id");
		logger.info("-- 当前最新付款单号:{} --",nowBppPayId1);
		String nowBppPayId2 = getNowBppPayId(nowBppPayId1);
		logger.info("-- 更新付款单号:{} --",nowBppPayId2);
		vmBusPoPayWmt.setBppPayId(nowBppPayId2);

		//保存主信息
		this.save(vmBusPoPayWmt);

		/**保存-采购付款单附表视图_wmt*/
		for(VmBusPoContractPayWmtEntity vmBusPoContractPayWmt:vmBusPoContractPayWmtList){
			//外键设置
			vmBusPoContractPayWmt.setBusPoPayId(vmBusPoPayWmt.getId());
			this.save(vmBusPoContractPayWmt);
		}
		/**保存-财务支付信息实体*/
		for(BusPayInfoEntity busPayInfo:busPayInfoList){
			//外键设置
			busPayInfo.setBpiBusId(vmBusPoPayWmt.getId());
//			logger.info("=== add【测试】保存-财务支付信息实体:{} ===",busPayInfo);
			this.save(busPayInfo);
		}
		//执行新增操作增强业务
		this.doAddBus(vmBusPoPayWmt);
	}

	public void updateMain(VmBusPoPayWmtEntity vmBusPoPayWmt,
		List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtList,List<BusPayInfoEntity> busPayInfoList) throws Exception {
		//保存主表信息
		if(StringUtil.isNotEmpty(vmBusPoPayWmt.getId())){
			try {
				VmBusPoPayWmtEntity temp = findUniqueByProperty(VmBusPoPayWmtEntity.class, "id", vmBusPoPayWmt.getId());
				MyBeanUtils.copyBeanNotNull2Bean(vmBusPoPayWmt, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(vmBusPoPayWmt);
		}
		//===================================================================================
		//获取参数
		Object id0 = vmBusPoPayWmt.getId();
		Object id1 = vmBusPoPayWmt.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-采购付款单附表视图_wmt
		String hql0 = "from VmBusPoContractPayWmtEntity where 1 = 1 AND busPoPayId = ? ";
		List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-采购付款单附表视图_wmt
		if(vmBusPoContractPayWmtList!=null&&vmBusPoContractPayWmtList.size()>0){
			for(VmBusPoContractPayWmtEntity oldE:vmBusPoContractPayWmtOldList){
				boolean isUpdate = false;
				for(VmBusPoContractPayWmtEntity sendE:vmBusPoContractPayWmtList){
					//需要更新的明细数据-采购付款单附表视图_wmt
					if(oldE.getId().equals(sendE.getId())){
						try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							if(sendE.getPayAmount()==null) oldE.setPayAmount(null);
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
					//如果数据库存在的明细，前台没有传递过来则是删除-采购付款单附表视图_wmt
					super.delete(oldE);
				}

			}
			//3.持久化新增的数据-采购付款单附表视图_wmt
			for(VmBusPoContractPayWmtEntity vmBusPoContractPayWmt:vmBusPoContractPayWmtList){
				if(oConvertUtils.isEmpty(vmBusPoContractPayWmt.getId())){
					//外键设置
					vmBusPoContractPayWmt.setBusPoPayId(vmBusPoPayWmt.getId());
					this.save(vmBusPoContractPayWmt);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-财务支付信息实体
		String hql1 = "from BusPayInfoEntity where 1 = 1 AND bpiBusId = ? ";
		List<BusPayInfoEntity> busPayInfoOldList = this.findHql(hql1,id1);
		
		
//		logger.info("=== 【测试】查询出数据库的明细数据-财务支付信息实体 ：{} ===",busPayInfoOldList);
		//2.筛选更新明细数据-财务支付信息实体
		if(busPayInfoList!=null&&busPayInfoList.size()>0){
			for(BusPayInfoEntity oldE:busPayInfoOldList){
				boolean isUpdate = false;
				for(BusPayInfoEntity sendE:busPayInfoList){
					//需要更新的明细数据-财务支付信息实体
					if(oldE.getId().equals(sendE.getId())){
						try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							
							//wmt
							logger.info("-- [银行账号信息外键]和[账号简称]不为空则生成凭证号:{},{} --",oldE.getFromBankAccId(),oldE.getBbaiSname());
							//凭证号产生规则：201907001（年月流水号，自动生成）
							if(oldE.getFromBankAccId()!=null&&oldE.getBbaiSname()!=null
									&&oldE.getFromBankAccId().trim()!=""&&oldE.getBbaiSname().trim()!="") {
								String createBpiVoucherno = createBpiVoucherno(actaccountDao.findByBpiVoucherno());
								if(oldE.getBbaiSname()==null||oldE.getBpiVoucherno().trim()=="")
									oldE.setBpiVoucherno(createBpiVoucherno);
								logger.info("-- 自动生成支付凭证号成功!:{} --",createBpiVoucherno);
							}else {
								logger.info("-- 自动生成支付凭证号失败! --");
							}
							//wmt
							
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
					//如果数据库存在的明细，前台没有传递过来则是删除-财务支付信息实体
					super.delete(oldE);
//					logger.info("=== 【测试】如果数据库存在的明细，前台没有传递过来则是删除-财务支付信息实体 ===");
				}

			}
			//3.持久化新增的数据-财务支付信息实体
			for(BusPayInfoEntity busPayInfo:busPayInfoList){
				if(oConvertUtils.isEmpty(busPayInfo.getId())){
					//外键设置
					busPayInfo.setBpiBusId(vmBusPoPayWmt.getId());
					this.save(busPayInfo);
				}
			}
		}
		//执行更新操作增强业务
		this.doUpdateBus(vmBusPoPayWmt,vmBusPoContractPayWmtList);
	}
	
	//自动生成【bus_pay_info表】的最新凭证号
	public String createBpiVoucherno(String voucherno) {
		String nowYear = Calendar.getInstance().get(Calendar.YEAR)+"";
		int intNowMonth = Integer.parseInt(Calendar.getInstance().get(Calendar.MONTH)+"")+1;
		String nowMonth = intNowMonth<10?"0"+intNowMonth:""+intNowMonth;
		
		//判空，直接生成最新凭证号
		if(voucherno==null||voucherno.replace(" ","").equals("")) return nowYear+nowMonth+"001";
		
		String year = voucherno.substring(0,4);
		String month = voucherno.substring(4,6);
		int intMark = Integer.parseInt(voucherno.substring(6));
		
		++intMark;
		String mark = intMark<10?"00"+intMark:intMark<100?"0"+intMark:intMark+"";
		if(nowYear.equals(year)&&nowMonth.equals(month)) {
			//年月相等，年不变月不变，流水号自增
			return year+month+mark;
		}else if(nowYear.equals(year)&&!nowMonth.equals(month)){
			//年等月不等，年不变月变今，流水号自增
			return year+nowMonth+"001";
		}
		//年不等，年变今月变今，流水号自增
		return nowYear+nowMonth+"001";
	}
	

	public void delMain(VmBusPoPayWmtEntity vmBusPoPayWmt) throws Exception{
		//删除主表信息
		this.delete(vmBusPoPayWmt);

		//===================================================================================
		//获取参数
		Object id0 = vmBusPoPayWmt.getId();
		Object id1 = vmBusPoPayWmt.getId();
		//===================================================================================
		//删除-采购付款单附表视图_wmt
		String hql0 = "from VmBusPoContractPayWmtEntity where 1 = 1 AND busPoPayId = ? ";
		List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(vmBusPoContractPayWmtOldList);
		//===================================================================================
		//删除-财务支付信息实体
		String hql1 = "from BusPayInfoEntity where 1 = 1 AND bpiBusId = ? ";
		List<BusPayInfoEntity> busPayInfoOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(busPayInfoOldList);

		//执行删除操作增强业务
		this.doDelBus((VmBusPoPayWmtEntity)vmBusPoPayWmt);
	}
	/**
	 * 自定义按钮-[审核完成]业务处理
	 * @param id
	 * @return
	 */
	public void doAuditFinishSql(VmBusPoPayWmtEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
		//sql增强第1条
		String sqlEnhance_1 ="update vm_bus_po_pay_wmt set bpp_state = '2' where id=:id";
		this.executeSqlEnhance(sqlEnhance_1,t);
		actaccountDao.updateBusPoPayWmtEntityBppState("2", t.getId());
		//-----------------sql增强 end------------------------------

		//-----------------java增强 start---------------------------
		//-----------------java增强 end-----------------------------
	}
	/**
	 * 自定义按钮-[送审]业务处理
	 * @param id
	 * @return
	 */
	public void doSendAuditSql(VmBusPoPayWmtEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
		//sql增强第1条
		String sqlEnhance_1 ="update vm_bus_po_pay_wmt set bpp_state = '1' where id=:id";
		this.executeSqlEnhance(sqlEnhance_1,t);
		actaccountDao.updateBusPoPayWmtEntityBppState("1", t.getId());
		//-----------------sql增强 end------------------------------

		//-----------------java增强 start---------------------------
		//-----------------java增强 end-----------------------------
	}

	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(VmBusPoPayWmtEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
		//保存实体表信息
		BusPoPayWmtEntity busPoPayEntity = this.returnBusPoPayEntity(t);
		this.save(busPoPayEntity);
		//-----------------sql增强 end------------------------------

		//-----------------java增强 start---------------------------
		//-----------------java增强 end-----------------------------
	}
	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(VmBusPoPayWmtEntity t,List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtList) throws Exception{
		//-----------------sql增强 start----------------------------
		//采购付款单【bus_po_pay】主表更新操作
		BusPoPayWmtEntity busPoPayEntity = this.returnBusPoPayEntity(t);
		logger.info("-- 【bus_po_pay】实体主表更新操作增强业务：{} --",busPoPayEntity);
		actaccountDao.updateBusPoPayWmtEntity(
				busPoPayEntity.getId(),
				busPoPayEntity.getBppInvType(),
				busPoPayEntity.getBppInvAmount(),
				busPoPayEntity.getBppTaxRate(),
				busPoPayEntity.getBppPayDate(),
				busPoPayEntity.getBppState(),
				busPoPayEntity.getBppMoney(),
				busPoPayEntity.getFromProjmId(),
				busPoPayEntity.getFromSuppId(),
				busPoPayEntity.getBppAccessory()
		);

		//采购付款单附表【bus_po_contract_pay】附表更新操作
		logger.info("-- 【bus_po_contract_pay】实体附表更新操作增强业务：{} --",vmBusPoContractPayWmtList);
		for (VmBusPoContractPayWmtEntity vmBusPoContractPayWmtEntity : vmBusPoContractPayWmtList) {
			int i = actaccountDao.updateBusPoContractPayWmtEntity(vmBusPoContractPayWmtEntity.getBpcpId(),
					vmBusPoContractPayWmtEntity.getPayAmount(), vmBusPoContractPayWmtEntity.getBpcpRemark());
			logger.info("-- 【bus_po_contract_pay】实体附表更新操作增强业务成功否：{} --",i);
		}

		//-----------------sql增强 end------------------------------

		//-----------------java增强 start---------------------------
		//-----------------java增强 end-----------------------------
	}
	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(VmBusPoPayWmtEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
		//删除实体表信息
		BusPoPayWmtEntity busPoPayEntity = this.returnBusPoPayEntity(t);
		actaccountDao.deleteBusPoPayWmtEntity(busPoPayEntity.getId());
		//-----------------sql增强 end------------------------------

		//-----------------java增强 start---------------------------
		//-----------------java增强 end-----------------------------
	}

	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
	public String replaceVal(String sql,VmBusPoPayWmtEntity t){
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
		sql  = sql.replace("#{bpp_pay_id}",String.valueOf(t.getBppPayId()));
		sql  = sql.replace("#{bpp_money}",String.valueOf(t.getBppMoney()));
		sql  = sql.replace("#{bpp_state}",String.valueOf(t.getBppState()));
		sql  = sql.replace("#{bpp_inv_amount}",String.valueOf(t.getBppInvAmount()));
		sql  = sql.replace("#{bpp_inv_type}",String.valueOf(t.getBppInvType()));
		sql  = sql.replace("#{bpp_tax_rate}",String.valueOf(t.getBppTaxRate()));
		sql  = sql.replace("#{bpp_pay_date}",String.valueOf(t.getBppPayDate()));
		sql  = sql.replace("#{bpp_accessory}",String.valueOf(t.getBppAccessory()));
		sql  = sql.replace("#{from_proj_id}",String.valueOf(t.getFromProjId()));
		sql  = sql.replace("#{bpm_proj_id}",String.valueOf(t.getBpmProjId()));
		sql  = sql.replace("#{bpm_name}",String.valueOf(t.getBpmName()));
		sql  = sql.replace("#{from_supp_id}",String.valueOf(t.getFromSuppId()));
		sql  = sql.replace("#{bs_id}",String.valueOf(t.getBsId()));
		sql  = sql.replace("#{bs_name}",String.valueOf(t.getBsName()));
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
					javaInter.execute("vm_bus_po_pay_wmt",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
	}

	private Map<String,Object> populationMap(VmBusPoPayWmtEntity t){
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
		map.put("bpp_pay_id", t.getBppPayId());
		map.put("bpp_money", t.getBppMoney());
		map.put("bpp_state", t.getBppState());
		map.put("bpp_inv_amount", t.getBppInvAmount());
		map.put("bpp_inv_type", t.getBppInvType());
		map.put("bpp_tax_rate", t.getBppTaxRate());
		map.put("bpp_pay_date", t.getBppPayDate());
		map.put("bpp_accessory", t.getBppAccessory());
		map.put("from_proj_id", t.getFromProjId());
		map.put("bpm_proj_id", t.getBpmProjId());
		map.put("bpm_name", t.getBpmName());
		map.put("from_supp_id", t.getFromSuppId());
		map.put("bs_id", t.getBsId());
		map.put("bs_name", t.getBsName());
		return map;
	}

	private void executeSqlEnhance(String sqlEnhance,VmBusPoPayWmtEntity t){
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