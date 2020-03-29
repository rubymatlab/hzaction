
package com.action.actaccount.page;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

import com.action.actaccount.entity.BusPayInfoEntity;
import com.action.actaccount.entity.VmBusPoContractPayWmtEntity;

/**   
 * @Title: Entity
 * @Description: 采购付款单视图_wmt
 * @author onlineGenerator
 * @date 2019-08-14 17:44:24
 * @version V1.0   
 *
 */
public class VmBusPoPayWmtPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**付款单号*/
	@Excel(name="付款单号")
	private java.lang.String bppPayId;
	/**付款金额*/
	@Excel(name="付款金额")
	private java.math.BigDecimal bppMoney;
	/**单据状态*/
	@Excel(name="单据状态")
	private java.lang.String bppState;
	/**发票金额*/
	@Excel(name="发票金额")
	private java.math.BigDecimal bppInvAmount;
	/**发票类型*/
	@Excel(name="发票类型")
	private java.lang.String bppInvType;
	/**项目经理*/
	@Excel(name="项目经理",width=15)
	private java.lang.String bpManager;
	/**税率百分比*/
	@Excel(name="税率百分比")
	private java.lang.String bppTaxRate;
	/**实际付款时间*/
	@Excel(name="实际付款时间",format = "yyyy-MM-dd")
	private java.util.Date bppPayDate;
	/**附件*/
	@Excel(name="附件")
	private java.lang.String bppAccessory;
	/**项目管理外键*/
//	@Excel(name="项目管理外键")
	private java.lang.String fromProjId;
	/**项目编号*/
	@Excel(name="项目编号")
	private java.lang.String bpmProjId;
	/**项目名称*/
	@Excel(name="项目名称")
	private java.lang.String bpmName;
	/**供应商资料外键*/
//	@Excel(name="供应商资料外键")
	private java.lang.String fromSuppId;
	/**供应商编号*/
	@Excel(name="供应商编号")
	private java.lang.String bsId;
	/**供应商名称*/
	@Excel(name="供应商名称")
	private java.lang.String bsName;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	public java.lang.String getUpdateName(){
		return this.updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目经理
	 */
	
	@Column(name ="BP_MANAGER",nullable=true,length=32)
	public java.lang.String getBpManager(){
		return this.bpManager;
	}
	
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目经理
	 */
	public void setBpManager(java.lang.String bpManager){
		this.bpManager = bpManager;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款单号
	 */
	public java.lang.String getBppPayId(){
		return this.bppPayId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款单号
	 */
	public void setBppPayId(java.lang.String bppPayId){
		this.bppPayId = bppPayId;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  付款金额
	 */
	public java.math.BigDecimal getBppMoney(){
		return this.bppMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  付款金额
	 */
	public void setBppMoney(java.math.BigDecimal bppMoney){
		this.bppMoney = bppMoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单据状态
	 */
	public java.lang.String getBppState(){
		return this.bppState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单据状态
	 */
	public void setBppState(java.lang.String bppState){
		this.bppState = bppState;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  发票金额
	 */
	public java.math.BigDecimal getBppInvAmount(){
		return this.bppInvAmount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  发票金额
	 */
	public void setBppInvAmount(java.math.BigDecimal bppInvAmount){
		this.bppInvAmount = bppInvAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票类型
	 */
	public java.lang.String getBppInvType(){
		return this.bppInvType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票类型
	 */
	public void setBppInvType(java.lang.String bppInvType){
		this.bppInvType = bppInvType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  税率百分比
	 */
	public java.lang.String getBppTaxRate(){
		return this.bppTaxRate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  税率百分比
	 */
	public void setBppTaxRate(java.lang.String bppTaxRate){
		this.bppTaxRate = bppTaxRate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  实际付款时间
	 */
	public java.util.Date getBppPayDate(){
		return this.bppPayDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  实际付款时间
	 */
	public void setBppPayDate(java.util.Date bppPayDate){
		this.bppPayDate = bppPayDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件
	 */
	public java.lang.String getBppAccessory(){
		return this.bppAccessory;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setBppAccessory(java.lang.String bppAccessory){
		this.bppAccessory = bppAccessory;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目管理外键
	 */
	public java.lang.String getFromProjId(){
		return this.fromProjId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目管理外键
	 */
	public void setFromProjId(java.lang.String fromProjId){
		this.fromProjId = fromProjId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目编号
	 */
	public java.lang.String getBpmProjId(){
		return this.bpmProjId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目编号
	 */
	public void setBpmProjId(java.lang.String bpmProjId){
		this.bpmProjId = bpmProjId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	public java.lang.String getBpmName(){
		return this.bpmName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setBpmName(java.lang.String bpmName){
		this.bpmName = bpmName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商资料外键
	 */
	public java.lang.String getFromSuppId(){
		return this.fromSuppId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商资料外键
	 */
	public void setFromSuppId(java.lang.String fromSuppId){
		this.fromSuppId = fromSuppId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商编号
	 */
	public java.lang.String getBsId(){
		return this.bsId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商编号
	 */
	public void setBsId(java.lang.String bsId){
		this.bsId = bsId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商名称
	 */
	public java.lang.String getBsName(){
		return this.bsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商名称
	 */
	public void setBsName(java.lang.String bsName){
		this.bsName = bsName;
	}

	/**保存-采购付款单附表视图_wmt*/
	@ExcelCollection(name="采购付款单")
	private List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtList = new ArrayList<VmBusPoContractPayWmtEntity>();
	public List<VmBusPoContractPayWmtEntity> getVmBusPoContractPayWmtList() {
		return vmBusPoContractPayWmtList;
	}
	public void setVmBusPoContractPayWmtList(List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtList) {
		this.vmBusPoContractPayWmtList = vmBusPoContractPayWmtList;
	}
	/**保存-财务支付信息实体*/
	@ExcelCollection(name="财务支付信息实体")
	private List<BusPayInfoEntity> busPayInfoList = new ArrayList<BusPayInfoEntity>();
	public List<BusPayInfoEntity> getBusPayInfoList() {
		return busPayInfoList;
	}
	public void setBusPayInfoList(List<BusPayInfoEntity> busPayInfoList) {
		this.busPayInfoList = busPayInfoList;
	}
}
