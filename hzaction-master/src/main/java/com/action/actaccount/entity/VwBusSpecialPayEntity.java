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
 * @Description: 零星支出单
 * @author onlineGenerator
 * @date 2019-08-19 13:46:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_bus_special_pay", schema = "")
@SuppressWarnings("serial")
public class VwBusSpecialPayEntity implements java.io.Serializable {
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
	/**单号*/
	@Excel(name="单号",width=15)
	private java.lang.String bsspSmspId;
	/**单据类型*/
	@Excel(name="单据类型",width=15)
	private java.lang.String bsspType;
	/**申请人*/
	@Excel(name="申请人",width=15)
	private java.lang.String bsspApplyPeople;
	/**申请日期*/
	@Excel(name="申请日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date bsspApplyDate;
	/**付款内容*/
	@Excel(name="付款内容",width=15)
	private java.lang.String bsspContent;
	/**发票金额*/
	@Excel(name="发票金额",width=15)
	private java.lang.Double bsspInvAmount;
	/**支付类型*/
	@Excel(name="支付类型",width=15)
	private java.lang.String bsspPayType;
	/**发票类型*/
	@Excel(name="发票类型",width=15)
	private java.lang.String bsspInvType;
	/**税率*/
	@Excel(name="税率",width=15)
	private java.lang.Double bsspTax;
	/**收款人开户行*/
	@Excel(name="收款人开户行",width=15)
	private java.lang.String bsspRecBank;
	/**收款单位*/
	@Excel(name="收款单位",width=15)
	private java.lang.String bsspRecCompany;
	/**委托收款人*/
	@Excel(name="委托收款人",width=15)
	private java.lang.String bsspEntrustRec;
	/**收款账号*/
	@Excel(name="收款账号",width=15)
	private java.lang.String bsspRecAccNo;
	/**请求支付日期*/
	@Excel(name="请求支付日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date bsspApplyPayDate;
	/**付款金额*/
	@Excel(name="付款金额",width=15)
	private java.lang.Double bsspPayAmount;
	/**单据状态*/
	@Excel(name="单据状态",width=15)
	private java.lang.String bsspState;
	/**项目管理外键*/
	@Excel(name="项目管理外键",width=15)
	private java.lang.String fromProjmId;
	/**供应商资料外键*/
	@Excel(name="供应商资料外键",width=15)
	private java.lang.String fromSuppId;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpProjId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpProjName;
	/**项目经理*/
	@Excel(name="项目经理",width=15)
	private java.lang.String bpManager;
	/**供应商名称*/
	@Excel(name="供应商名称",width=15)
	private java.lang.String bsName;
	/**附件*/
	@Excel(name="附件",width=15)
	private java.lang.String bsspFile;
	
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
	 *@return: java.lang.String  单号
	 */

	@Column(name ="BSSP_SMSP_ID",nullable=true,length=40)
	public java.lang.String getBsspSmspId(){
		return this.bsspSmspId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单号
	 */
	public void setBsspSmspId(java.lang.String bsspSmspId){
		this.bsspSmspId = bsspSmspId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单据类型
	 */

	@Column(name ="BSSP_TYPE",nullable=true,length=32)
	public java.lang.String getBsspType(){
		return this.bsspType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单据类型
	 */
	public void setBsspType(java.lang.String bsspType){
		this.bsspType = bsspType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请人
	 */

	@Column(name ="BSSP_APPLY_PEOPLE",nullable=true,length=32)
	public java.lang.String getBsspApplyPeople(){
		return this.bsspApplyPeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人
	 */
	public void setBsspApplyPeople(java.lang.String bsspApplyPeople){
		this.bsspApplyPeople = bsspApplyPeople;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请日期
	 */

	@Column(name ="BSSP_APPLY_DATE",nullable=true,length=32)
	public java.util.Date getBsspApplyDate(){
		return this.bsspApplyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请日期
	 */
	public void setBsspApplyDate(java.util.Date bsspApplyDate){
		this.bsspApplyDate = bsspApplyDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款内容
	 */

	@Column(name ="BSSP_CONTENT",nullable=true,length=400)
	public java.lang.String getBsspContent(){
		return this.bsspContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款内容
	 */
	public void setBsspContent(java.lang.String bsspContent){
		this.bsspContent = bsspContent;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  发票金额
	 */

	@Column(name ="BSSP_INV_AMOUNT",nullable=true,scale=2,length=12)
	public java.lang.Double getBsspInvAmount(){
		return this.bsspInvAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  发票金额
	 */
	public void setBsspInvAmount(java.lang.Double bsspInvAmount){
		this.bsspInvAmount = bsspInvAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付类型
	 */

	@Column(name ="BSSP_PAY_TYPE",nullable=true,length=32)
	public java.lang.String getBsspPayType(){
		return this.bsspPayType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付类型
	 */
	public void setBsspPayType(java.lang.String bsspPayType){
		this.bsspPayType = bsspPayType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票类型
	 */

	@Column(name ="BSSP_INV_TYPE",nullable=true,length=32)
	public java.lang.String getBsspInvType(){
		return this.bsspInvType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票类型
	 */
	public void setBsspInvType(java.lang.String bsspInvType){
		this.bsspInvType = bsspInvType;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  税率
	 */

	@Column(name ="BSSP_TAX",nullable=true,scale=2,length=32)
	public java.lang.Double getBsspTax(){
		return this.bsspTax;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  税率
	 */
	public void setBsspTax(java.lang.Double bsspTax){
		this.bsspTax = bsspTax;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款人开户行
	 */

	@Column(name ="BSSP_REC_BANK",nullable=true,length=40)
	public java.lang.String getBsspRecBank(){
		return this.bsspRecBank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款人开户行
	 */
	public void setBsspRecBank(java.lang.String bsspRecBank){
		this.bsspRecBank = bsspRecBank;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款单位
	 */

	@Column(name ="BSSP_REC_COMPANY",nullable=true,length=100)
	public java.lang.String getBsspRecCompany(){
		return this.bsspRecCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款单位
	 */
	public void setBsspRecCompany(java.lang.String bsspRecCompany){
		this.bsspRecCompany = bsspRecCompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  委托收款人
	 */

	@Column(name ="BSSP_ENTRUST_REC",nullable=true,length=40)
	public java.lang.String getBsspEntrustRec(){
		return this.bsspEntrustRec;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托收款人
	 */
	public void setBsspEntrustRec(java.lang.String bsspEntrustRec){
		this.bsspEntrustRec = bsspEntrustRec;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款账号
	 */

	@Column(name ="BSSP_REC_ACC_NO",nullable=true,length=40)
	public java.lang.String getBsspRecAccNo(){
		return this.bsspRecAccNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款账号
	 */
	public void setBsspRecAccNo(java.lang.String bsspRecAccNo){
		this.bsspRecAccNo = bsspRecAccNo;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  请求支付日期
	 */

	@Column(name ="BSSP_APPLY_PAY_DATE",nullable=true,length=32)
	public java.util.Date getBsspApplyPayDate(){
		return this.bsspApplyPayDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  请求支付日期
	 */
	public void setBsspApplyPayDate(java.util.Date bsspApplyPayDate){
		this.bsspApplyPayDate = bsspApplyPayDate;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  付款金额
	 */

	@Column(name ="BSSP_PAY_AMOUNT",nullable=true,scale=2,length=12)
	public java.lang.Double getBsspPayAmount(){
		return this.bsspPayAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  付款金额
	 */
	public void setBsspPayAmount(java.lang.Double bsspPayAmount){
		this.bsspPayAmount = bsspPayAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单据状态
	 */

	@Column(name ="BSSP_STATE",nullable=true,length=32)
	public java.lang.String getBsspState(){
		return this.bsspState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单据状态
	 */
	public void setBsspState(java.lang.String bsspState){
		this.bsspState = bsspState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目管理外键
	 */

	@Column(name ="FROM_PROJM_ID",nullable=true,length=36)
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
	 *@return: java.lang.String  供应商资料外键
	 */

	@Column(name ="FROM_SUPP_ID",nullable=true,length=36)
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
	 *@return: java.lang.String  项目编号
	 */

	@Column(name ="BP_PROJ_ID",nullable=true,length=40)
	public java.lang.String getBpProjId(){
		return this.bpProjId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目编号
	 */
	public void setBpProjId(java.lang.String bpProjId){
		this.bpProjId = bpProjId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */

	@Column(name ="BP_PROJ_NAME",nullable=true,length=200)
	public java.lang.String getBpProjName(){
		return this.bpProjName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setBpProjName(java.lang.String bpProjName){
		this.bpProjName = bpProjName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目经理
	 */

	@Column(name ="BP_MANAGER",nullable=true,length=40)
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
	 *@return: java.lang.String  附件
	 */

	@Column(name ="BSSP_FILE",nullable=true,length=100)
	public java.lang.String getBsspFile(){
		return this.bsspFile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setBsspFile(java.lang.String bsspFile){
		this.bsspFile = bsspFile;
	}
}
