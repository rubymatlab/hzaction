package com.action.actbase.entity;

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
 * @Description: 供应商资料
 * @author onlineGenerator
 * @date 2019-08-02 18:09:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bas_supplier", schema = "")
@SuppressWarnings("serial")
public class BasSupplierEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**供应商编号*/
	@Excel(name="供应商编号",width=15)
	private java.lang.String bsId;
	/**供应商名称*/
	@Excel(name="供应商名称",width=15)
	private java.lang.String bsName;
	/**供应商简称*/
	@Excel(name="供应商简称",width=15)
	private java.lang.String bsSname;
	/**供应商地址*/
	@Excel(name="供应商地址",width=15)
	private java.lang.String bsAddress;
	/**开户行*/
	@Excel(name="开户行",width=15)
	private java.lang.String bsBankId;
	/**开户帐号*/
	@Excel(name="开户帐号",width=15)
	private java.lang.String bsBankAcc;
	/**供应商联系人*/
	@Excel(name="供应商联系人",width=15)
	private java.lang.String bsContact;
	/**供应商联系人电话*/
	@Excel(name="供应商联系人电话",width=15)
	private java.lang.String bsTelNo;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String bsRemark;
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
	 *@return: java.lang.String  供应商编号
	 */

	@Column(name ="BS_ID",nullable=true,length=20)
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

	@Column(name ="BS_NAME",nullable=true,length=100)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商简称
	 */

	@Column(name ="BS_SNAME",nullable=true,length=32)
	public java.lang.String getBsSname(){
		return this.bsSname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商简称
	 */
	public void setBsSname(java.lang.String bsSname){
		this.bsSname = bsSname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商地址
	 */

	@Column(name ="BS_ADDRESS",nullable=true,length=100)
	public java.lang.String getBsAddress(){
		return this.bsAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商地址
	 */
	public void setBsAddress(java.lang.String bsAddress){
		this.bsAddress = bsAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户行
	 */

	@Column(name ="BS_BANK_ID",nullable=true,length=50)
	public java.lang.String getBsBankId(){
		return this.bsBankId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户行
	 */
	public void setBsBankId(java.lang.String bsBankId){
		this.bsBankId = bsBankId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户帐号
	 */

	@Column(name ="BS_BANK_ACC",nullable=true,length=50)
	public java.lang.String getBsBankAcc(){
		return this.bsBankAcc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户帐号
	 */
	public void setBsBankAcc(java.lang.String bsBankAcc){
		this.bsBankAcc = bsBankAcc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商联系人
	 */

	@Column(name ="BS_CONTACT",nullable=true,length=32)
	public java.lang.String getBsContact(){
		return this.bsContact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商联系人
	 */
	public void setBsContact(java.lang.String bsContact){
		this.bsContact = bsContact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商联系人电话
	 */

	@Column(name ="BS_TEL_NO",nullable=true,length=40)
	public java.lang.String getBsTelNo(){
		return this.bsTelNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商联系人电话
	 */
	public void setBsTelNo(java.lang.String bsTelNo){
		this.bsTelNo = bsTelNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="BS_REMARK",nullable=true,length=500)
	public java.lang.String getBsRemark(){
		return this.bsRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBsRemark(java.lang.String bsRemark){
		this.bsRemark = bsRemark;
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
}
