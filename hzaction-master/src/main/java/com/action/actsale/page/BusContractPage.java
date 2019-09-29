
package com.action.actsale.page;
import com.action.actsale.entity.BusContractEntity;
import com.action.actsale.entity.BusConQuotedPriceEntity;
import com.action.actsale.entity.BusContractPaymentEntity;
import com.action.actsale.entity.BusCostBudgetingEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

/**   
 * @Title: Entity
 * @Description: 合同管理
 * @author onlineGenerator
 * @date 2019-08-07 14:26:12
 * @version V1.0   
 *
 */
public class BusContractPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
//    @Excel(name="创建人名称")
	private java.lang.String createName;
	/**创建人登录名称*/
//    @Excel(name="创建人登录名称")
	private java.lang.String createBy;
	/**创建日期*/
//    @Excel(name="创建日期",format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**更新人名称*/
//    @Excel(name="更新人名称")
	private java.lang.String updateName;
	/**更新人登录名称*/
//    @Excel(name="更新人登录名称")
	private java.lang.String updateBy;
	/**更新日期*/
//    @Excel(name="更新日期",format = "yyyy-MM-dd")
	private java.util.Date updateDate;
	/**所属部门*/
//    @Excel(name="所属部门")
	private java.lang.String sysOrgCode;
	/**所属公司*/
//    @Excel(name="所属公司")
	private java.lang.String sysCompanyCode;
	/**流程状态*/
//    @Excel(name="流程状态")
	private java.lang.String bpmStatus;
	/**客户编号*/
    @Excel(name="客户编号")
	private java.lang.String bcCustomerCode;
	/**客户名称*/
    @Excel(name="客户名称")
	private java.lang.String bcCustomerName;
	/**项目编号*/
    @Excel(name="项目编号")
	private java.lang.String bcProjectCode;
	/**合同名称*/
    @Excel(name="合同名称")
	private java.lang.String bcContractName;
	/**签订时间*/
    @Excel(name="签订时间",format = "yyyy-MM-dd")
	private java.util.Date bcConcludeTime;
	/**合同开始时间*/
    @Excel(name="合同开始时间",format = "yyyy-MM-dd")
	private java.util.Date bcContStartTime;
	/**合同结束时间*/
    @Excel(name="合同结束时间",format = "yyyy-MM-dd")
	private java.util.Date bcContEndTime;
	/**合同完成状态*/
    @Excel(name="合同完成状态")
	private java.lang.String bcContractState;
	/**我方签约人*/
    @Excel(name="我方签约人")
	private java.lang.String bcCompContractor;
	/**合同金额万元*/
    @Excel(name="合同金额万元")
	private java.lang.String bcContAmount;
	/**项目立项外键*/
//    @Excel(name="项目立项外键")
	private java.lang.String fromProjId;
	/**客户签约人*/
    @Excel(name="客户签约人")
	private java.lang.String bcCustContractor;
	/**客户资料外键*/
//    @Excel(name="客户资料外键")
	private java.lang.String fromCustId;
	/**项目名称*/
    @Excel(name="项目名称")
	private java.lang.String fromProjName;
	/**管理费百分比*/
    @Excel(name="管理费百分比")
	private java.math.BigDecimal bcManPer;
	/**中标方*/
    @Excel(name="中标方")
	private java.lang.String bcWinBidder;
	/**中标服务费*/
    @Excel(name="中标服务费")
	private java.math.BigDecimal bcWinSfee;
	/**安信金额*/
    @Excel(name="安信金额")
	private java.math.BigDecimal bcActionAmount;
	/**合同电子档*/
    @Excel(name="合同电子档")
	private java.lang.String bcContractFile;
	
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
	 *@return: java.lang.String  客户编号
	 */
	public java.lang.String getBcCustomerCode(){
		return this.bcCustomerCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编号
	 */
	public void setBcCustomerCode(java.lang.String bcCustomerCode){
		this.bcCustomerCode = bcCustomerCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	public java.lang.String getBcCustomerName(){
		return this.bcCustomerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setBcCustomerName(java.lang.String bcCustomerName){
		this.bcCustomerName = bcCustomerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目编号
	 */
	public java.lang.String getBcProjectCode(){
		return this.bcProjectCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目编号
	 */
	public void setBcProjectCode(java.lang.String bcProjectCode){
		this.bcProjectCode = bcProjectCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同名称
	 */
	public java.lang.String getBcContractName(){
		return this.bcContractName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同名称
	 */
	public void setBcContractName(java.lang.String bcContractName){
		this.bcContractName = bcContractName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签订时间
	 */
	public java.util.Date getBcConcludeTime(){
		return this.bcConcludeTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  签订时间
	 */
	public void setBcConcludeTime(java.util.Date bcConcludeTime){
		this.bcConcludeTime = bcConcludeTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  合同开始时间
	 */
	public java.util.Date getBcContStartTime(){
		return this.bcContStartTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  合同开始时间
	 */
	public void setBcContStartTime(java.util.Date bcContStartTime){
		this.bcContStartTime = bcContStartTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  合同结束时间
	 */
	public java.util.Date getBcContEndTime(){
		return this.bcContEndTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  合同结束时间
	 */
	public void setBcContEndTime(java.util.Date bcContEndTime){
		this.bcContEndTime = bcContEndTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同完成状态
	 */
	public java.lang.String getBcContractState(){
		return this.bcContractState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同完成状态
	 */
	public void setBcContractState(java.lang.String bcContractState){
		this.bcContractState = bcContractState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  我方签约人
	 */
	public java.lang.String getBcCompContractor(){
		return this.bcCompContractor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  我方签约人
	 */
	public void setBcCompContractor(java.lang.String bcCompContractor){
		this.bcCompContractor = bcCompContractor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同金额万元
	 */
	public java.lang.String getBcContAmount(){
		return this.bcContAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同金额万元
	 */
	public void setBcContAmount(java.lang.String bcContAmount){
		this.bcContAmount = bcContAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目立项外键
	 */
	public java.lang.String getFromProjId(){
		return this.fromProjId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目立项外键
	 */
	public void setFromProjId(java.lang.String fromProjId){
		this.fromProjId = fromProjId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户签约人
	 */
	public java.lang.String getBcCustContractor(){
		return this.bcCustContractor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户签约人
	 */
	public void setBcCustContractor(java.lang.String bcCustContractor){
		this.bcCustContractor = bcCustContractor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户资料外键
	 */
	public java.lang.String getFromCustId(){
		return this.fromCustId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户资料外键
	 */
	public void setFromCustId(java.lang.String fromCustId){
		this.fromCustId = fromCustId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	public java.lang.String getFromProjName(){
		return this.fromProjName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setFromProjName(java.lang.String fromProjName){
		this.fromProjName = fromProjName;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  管理费百分比
	 */
	public java.math.BigDecimal getBcManPer(){
		return this.bcManPer;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  管理费百分比
	 */
	public void setBcManPer(java.math.BigDecimal bcManPer){
		this.bcManPer = bcManPer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中标方
	 */
	public java.lang.String getBcWinBidder(){
		return this.bcWinBidder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中标方
	 */
	public void setBcWinBidder(java.lang.String bcWinBidder){
		this.bcWinBidder = bcWinBidder;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  中标服务费
	 */
	public java.math.BigDecimal getBcWinSfee(){
		return this.bcWinSfee;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  中标服务费
	 */
	public void setBcWinSfee(java.math.BigDecimal bcWinSfee){
		this.bcWinSfee = bcWinSfee;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  安信金额
	 */
	public java.math.BigDecimal getBcActionAmount(){
		return this.bcActionAmount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  安信金额
	 */
	public void setBcActionAmount(java.math.BigDecimal bcActionAmount){
		this.bcActionAmount = bcActionAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同电子档
	 */
	public java.lang.String getBcContractFile(){
		return this.bcContractFile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同电子档
	 */
	public void setBcContractFile(java.lang.String bcContractFile){
		this.bcContractFile = bcContractFile;
	}

	/**保存-合同明细报价附表*/
    @ExcelCollection(name="合同明细报价附表")
	private List<BusConQuotedPriceEntity> busConQuotedPriceList = new ArrayList<BusConQuotedPriceEntity>();
		public List<BusConQuotedPriceEntity> getBusConQuotedPriceList() {
		return busConQuotedPriceList;
		}
		public void setBusConQuotedPriceList(List<BusConQuotedPriceEntity> busConQuotedPriceList) {
		this.busConQuotedPriceList = busConQuotedPriceList;
		}
	/**保存-合同约定收款附表*/
    @ExcelCollection(name="合同约定收款附表")
	private List<BusContractPaymentEntity> busContractPaymentList = new ArrayList<BusContractPaymentEntity>();
		public List<BusContractPaymentEntity> getBusContractPaymentList() {
		return busContractPaymentList;
		}
		public void setBusContractPaymentList(List<BusContractPaymentEntity> busContractPaymentList) {
		this.busContractPaymentList = busContractPaymentList;
		}
	/**保存-成本预算附表*/
    @ExcelCollection(name="成本预算附表")
	private List<BusCostBudgetingEntity> busCostBudgetingList = new ArrayList<BusCostBudgetingEntity>();
		public List<BusCostBudgetingEntity> getBusCostBudgetingList() {
		return busCostBudgetingList;
		}
		public void setBusCostBudgetingList(List<BusCostBudgetingEntity> busCostBudgetingList) {
		this.busCostBudgetingList = busCostBudgetingList;
		}
}
