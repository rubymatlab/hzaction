package com.action.actaccount.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 采购付款单明细附表视图_wmt
 * @author onlineGenerator
 * @date 2019-08-18 00:41:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vm_bus_po_contract_pay_wmt", schema = "")
@SuppressWarnings("serial")
public class VmBusPoContractPayWmtEntity implements java.io.Serializable {
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
	/**采购合同编号*/
	@Excel(name="采购合同编号",width=15)
	private java.lang.String bpcPoNo;
	/**费用分期*/
	@Excel(name="费用分期",width=15,dicCode="cost_stag")
	private java.lang.String bpcpProgre;
	/**计划付款金额*/
	@Excel(name="计划付款金额",width=15)
	private java.math.BigDecimal bpcpPayAmount;
	/**计划付款日期*/
	@Excel(name="计划付款日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpcpDate;
	/**采购合同外键*/
	@Excel(name="采购合同外键",width=15)
	private java.lang.String fromId;
	/**付款金额*/
	@Excel(name="付款金额",width=15)
	private java.math.BigDecimal payAmount;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String bpcpRemark;
	/**采购付款单明细附表外键*/
	@Excel(name="采购付款单明细附表外键",width=15)
	private java.lang.String bpcpId;
	/**采购付款单外键*/
	@Excel(name="采购付款单外键",width=15)
	private java.lang.String busPoPayId;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
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

	@Column(name ="CREATE_NAME",nullable=true,length=50)
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

	@Column(name ="CREATE_BY",nullable=true,length=50)
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

	@Column(name ="CREATE_DATE",nullable=true,length=20)
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

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
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

	@Column(name ="UPDATE_BY",nullable=true,length=50)
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

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
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

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
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

	@Column(name ="BPM_STATUS",nullable=true,length=32)
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
	 *@return: java.lang.String  采购合同编号
	 */

	@Column(name ="BPC_PO_NO",nullable=true,length=32)
	public java.lang.String getBpcPoNo(){
		return this.bpcPoNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购合同编号
	 */
	public void setBpcPoNo(java.lang.String bpcPoNo){
		this.bpcPoNo = bpcPoNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用分期
	 */

	@Column(name ="BPCP_PROGRE",nullable=true,length=32)
	public java.lang.String getBpcpProgre(){
		return this.bpcpProgre;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用分期
	 */
	public void setBpcpProgre(java.lang.String bpcpProgre){
		this.bpcpProgre = bpcpProgre;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  计划付款金额
	 */

	@Column(name ="BPCP_PAY_AMOUNT",nullable=true,length=32)
	public java.math.BigDecimal getBpcpPayAmount(){
		return this.bpcpPayAmount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  计划付款金额
	 */
	public void setBpcpPayAmount(java.math.BigDecimal bpcpPayAmount){
		this.bpcpPayAmount = bpcpPayAmount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计划付款日期
	 */

	@Column(name ="BPCP_DATE",nullable=true,length=32)
	public java.util.Date getBpcpDate(){
		return this.bpcpDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计划付款日期
	 */
	public void setBpcpDate(java.util.Date bpcpDate){
		this.bpcpDate = bpcpDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购合同外键
	 */

	@Column(name ="FROM_ID",nullable=true,length=32)
	public java.lang.String getFromId(){
		return this.fromId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购合同外键
	 */
	public void setFromId(java.lang.String fromId){
		this.fromId = fromId;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  付款金额
	 */

	@Column(name ="PAY_AMOUNT",nullable=true,length=32)
	public java.math.BigDecimal getPayAmount(){
		return this.payAmount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  付款金额
	 */
	public void setPayAmount(java.math.BigDecimal payAmount){
		this.payAmount = payAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="BPCP_REMARK",nullable=true,length=32)
	public java.lang.String getBpcpRemark(){
		return this.bpcpRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBpcpRemark(java.lang.String bpcpRemark){
		this.bpcpRemark = bpcpRemark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购付款单外键
	 */

	@Column(name ="BUS_PO_PAY_ID",nullable=true,length=32)
	public java.lang.String getBusPoPayId(){
		return this.busPoPayId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购付款单外键
	 */
	public void setBusPoPayId(java.lang.String busPoPayId){
		this.busPoPayId = busPoPayId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购付款单明细附表外键
	 */

	@Column(name ="BPCP_ID",nullable=true,length=32)
	public java.lang.String getBpcpId(){
		return this.bpcpId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购付款单明细附表外键
	 */
	public void setBpcpId(java.lang.String bpcpId){
		this.bpcpId = bpcpId;
	}

	@Override
	public String toString() {
		return "VmBusPoContractPayWmtEntity [id=" + id + ", bpcPoNo=" + bpcPoNo + ", bpcpProgre=" + bpcpProgre
				+ ", bpcpPayAmount=" + bpcpPayAmount + ", bpcpDate=" + bpcpDate + ", fromId=" + fromId + ", payAmount="
				+ payAmount + ", bpcpRemark=" + bpcpRemark + ", bpcpId=" + bpcpId + ", busPoPayId=" + busPoPayId + "]";
	}
	
}
