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
 * @Description: 银行账号信息
 * @author onlineGenerator
 * @date 2019-08-02 18:09:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bas_bank_account_info", schema = "")
@SuppressWarnings("serial")
public class BasBankAccountInfoEntity implements java.io.Serializable {
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
	/**账号简称*/
	@Excel(name="账号简称",width=15)
	private java.lang.String bbaiSname;
	/**户名*/
	@Excel(name="户名",width=15)
	private java.lang.String bbaiName;
	/**开户行名称*/
	@Excel(name="开户行名称",width=15)
	private java.lang.String bbaiBankName;
	/**账号*/
	@Excel(name="账号",width=15)
	private java.lang.String bbaiAccountNo;
	/**开户网点*/
	@Excel(name="开户网点",width=15)
	private java.lang.String bbaiBankAddr;
	/**期初余额*/
	@Excel(name="期初余额",width=15)
	private java.lang.Double bbaiIniBalance;
	
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
	 *@return: java.lang.String  账号简称
	 */

	@Column(name ="BBAI_SNAME",nullable=true,length=32)
	public java.lang.String getBbaiSname(){
		return this.bbaiSname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账号简称
	 */
	public void setBbaiSname(java.lang.String bbaiSname){
		this.bbaiSname = bbaiSname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户名
	 */

	@Column(name ="BBAI_NAME",nullable=true,length=40)
	public java.lang.String getBbaiName(){
		return this.bbaiName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户名
	 */
	public void setBbaiName(java.lang.String bbaiName){
		this.bbaiName = bbaiName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户行名称
	 */

	@Column(name ="BBAI_BANK_NAME",nullable=true,length=40)
	public java.lang.String getBbaiBankName(){
		return this.bbaiBankName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户行名称
	 */
	public void setBbaiBankName(java.lang.String bbaiBankName){
		this.bbaiBankName = bbaiBankName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账号
	 */

	@Column(name ="BBAI_ACCOUNT_NO",nullable=true,length=40)
	public java.lang.String getBbaiAccountNo(){
		return this.bbaiAccountNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账号
	 */
	public void setBbaiAccountNo(java.lang.String bbaiAccountNo){
		this.bbaiAccountNo = bbaiAccountNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户网点
	 */

	@Column(name ="BBAI_BANK_ADDR",nullable=true,length=100)
	public java.lang.String getBbaiBankAddr(){
		return this.bbaiBankAddr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户网点
	 */
	public void setBbaiBankAddr(java.lang.String bbaiBankAddr){
		this.bbaiBankAddr = bbaiBankAddr;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  期初余额
	 */

	@Column(name ="BBAI_INI_BALANCE",nullable=true,scale=2,length=12)
	public java.lang.Double getBbaiIniBalance(){
		return this.bbaiIniBalance;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  期初余额
	 */
	public void setBbaiIniBalance(java.lang.Double bbaiIniBalance){
		this.bbaiIniBalance = bbaiIniBalance;
	}
}
