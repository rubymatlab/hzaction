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
 * @Description: 备用金或借款领用单
 * @author onlineGenerator
 * @date 2019-12-05 00:44:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_reserve_fund", schema = "")
@SuppressWarnings("serial")
public class BusReserveFundEntity implements java.io.Serializable {
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
	/**申请人*/
	@Excel(name="申请人",width=15)
	private java.lang.String brfApplicant;
	/**部门*/
	@Excel(name="部门",width=15)
	private java.lang.String brfDep;
	/**领取人*/
	@Excel(name="领取人",width=15)
	private java.lang.String brfReceiver;
	/**借款事由*/
	@Excel(name="借款事由",width=15)
	private java.lang.String brfCause;
	/**借款原因*/
	@Excel(name="借款原因",width=15)
	private java.lang.String brfReason;
	/**借款金额*/
	@Excel(name="借款金额",width=15)
	private java.lang.String brfAmount;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String befRemark;
	
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
	 *@return: java.lang.String  申请人
	 */

	@Column(name ="BRF_APPLICANT",nullable=true,length=32)
	public java.lang.String getBrfApplicant(){
		return this.brfApplicant;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人
	 */
	public void setBrfApplicant(java.lang.String brfApplicant){
		this.brfApplicant = brfApplicant;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门
	 */

	@Column(name ="BRF_DEP",nullable=true,length=32)
	public java.lang.String getBrfDep(){
		return this.brfDep;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门
	 */
	public void setBrfDep(java.lang.String brfDep){
		this.brfDep = brfDep;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  领取人
	 */

	@Column(name ="BRF_RECEIVER",nullable=true,length=32)
	public java.lang.String getBrfReceiver(){
		return this.brfReceiver;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  领取人
	 */
	public void setBrfReceiver(java.lang.String brfReceiver){
		this.brfReceiver = brfReceiver;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  借款事由
	 */

	@Column(name ="BRF_CAUSE",nullable=true,length=32)
	public java.lang.String getBrfCause(){
		return this.brfCause;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  借款事由
	 */
	public void setBrfCause(java.lang.String brfCause){
		this.brfCause = brfCause;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  借款原因
	 */

	@Column(name ="BRF_REASON",nullable=true,length=32)
	public java.lang.String getBrfReason(){
		return this.brfReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  借款原因
	 */
	public void setBrfReason(java.lang.String brfReason){
		this.brfReason = brfReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  借款金额
	 */

	@Column(name ="BRF_AMOUNT",nullable=true,length=32)
	public java.lang.String getBrfAmount(){
		return this.brfAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  借款金额
	 */
	public void setBrfAmount(java.lang.String brfAmount){
		this.brfAmount = brfAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="BEF_REMARK",nullable=true,length=32)
	public java.lang.String getBefRemark(){
		return this.befRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBefRemark(java.lang.String befRemark){
		this.befRemark = befRemark;
	}
}
