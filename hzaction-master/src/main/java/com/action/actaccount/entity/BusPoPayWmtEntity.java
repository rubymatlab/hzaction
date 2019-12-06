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
 * @Description: 采购付款单
 * @author onlineGenerator
 * @date 2019-08-15 23:22:40
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_po_pay", schema = "")
@SuppressWarnings("serial")
public class BusPoPayWmtEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**付款单号*/
	@Excel(name="付款单号",width=15)
	private java.lang.String bppPayId;
	/**发票类型*/
	@Excel(name="发票类型",width=15)
	private java.lang.String bppInvType;
	/**发票金额*/
	@Excel(name="发票金额",width=15)
	private java.math.BigDecimal bppInvAmount;
	/**税率百分比*/
	@Excel(name="税率百分比",width=15,dicCode="tax_rate")
	private java.lang.String bppTaxRate;
	/**实际付款时间*/
	@Excel(name="申请付款时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bppPayDate;
	/**单据状态*/
	@Excel(name="单据状态",width=15,dicCode="bs_state")
	private java.lang.String bppState;
	/**付款金额*/
	@Excel(name="付款金额",width=15)
	private java.math.BigDecimal bppMoney;
	/**项目管理外键*/
	@Excel(name="项目管理外键",width=15)
	private java.lang.String fromProjmId;
	/**项目经理*/
	@Excel(name="项目经理",width=15)
	private java.lang.String bpManager;
	/**供应商资料外键*/
	@Excel(name="供应商资料外键",width=15)
	private java.lang.String fromSuppId;
	/**附件*/
	@Excel(name="附件",width=15)
	private java.lang.String bppAccessory;
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
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
//	@GeneratedValue(generator = "paymentableGenerator")
//	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
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
	 *@return: java.lang.String  付款单号
	 */

	@Column(name ="BPP_PAY_ID",nullable=true,length=32)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票类型
	 */

	@Column(name ="BPP_INV_TYPE",nullable=true,length=32)
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
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  发票金额
	 */

	@Column(name ="BPP_INV_AMOUNT",nullable=true,length=32)
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
	 *@return: java.lang.String  税率百分比
	 */

	@Column(name ="BPP_TAX_RATE",nullable=true,length=32)
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

	@Column(name ="BPP_PAY_DATE",nullable=true,length=32)
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
	 *@return: java.lang.String  单据状态
	 */

	@Column(name ="BPP_STATE",nullable=true,length=32)
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
	 *@return: java.math.BigDecimal  付款金额
	 */

	@Column(name ="BPP_MONEY",nullable=true,length=32)
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
	 *@return: java.lang.String  项目管理外键
	 */

	@Column(name ="FROM_PROJM_ID",nullable=true,length=32)
	public java.lang.String getFromProjmId(){
		return this.fromProjmId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目管理外键
	 */
	public void setFromProjmId(java.lang.String fromProjmId){
		this.fromProjmId = fromProjmId;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商资料外键
	 */

	@Column(name ="FROM_SUPP_ID",nullable=true,length=32)
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
	 *@return: java.lang.String  附件
	 */

	@Column(name ="BPP_ACCESSORY",nullable=true,length=32)
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

	@Column(name ="CREATE_DATE",nullable=true)
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

	@Column(name ="UPDATE_DATE",nullable=true)
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

	@Override
	public String toString() {
		return "BusPoPayWmtEntity [id=" + id + ", bppPayId=" + bppPayId + ", bppInvType=" + bppInvType
				+ ", bppInvAmount=" + bppInvAmount + ", bppTaxRate=" + bppTaxRate + ", bppPayDate=" + bppPayDate
				+ ", bppState=" + bppState + ", bppMoney=" + bppMoney + ", fromProjmId=" + fromProjmId + ", bpManager="
				+ bpManager + ", fromSuppId=" + fromSuppId + ", bppAccessory=" + bppAccessory + ", createName="
				+ createName + ", createBy=" + createBy + ", createDate=" + createDate + ", updateName=" + updateName
				+ ", updateBy=" + updateBy + ", updateDate=" + updateDate + ", sysOrgCode=" + sysOrgCode
				+ ", sysCompanyCode=" + sysCompanyCode + ", bpmStatus=" + bpmStatus + "]";
	}

}
