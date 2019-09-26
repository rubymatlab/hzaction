package com.action.actproject.entity;
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
 * @Description: 回款计划
 * @author onlineGenerator
 * @date 2019-07-26 20:09:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_collect_plan", schema = "")
@SuppressWarnings("serial")
public class BusCollectPlanEntity implements java.io.Serializable {
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
	/**序号*/
	private java.lang.String brpSeqNo;
	/**进度款分期*/
	@Excel(name="进度款分期",width=15)
	private java.lang.String brpProgressStages;
	/**预计回款日期*/
	@Excel(name="预计回款日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date brpExtBackDate;
	/**计划开票日期*/
	@Excel(name="计划开票日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date brpPlanInvoiceDate;
	/**回款金额*/
	@Excel(name="回款金额",width=15)
	private java.lang.String brpBackAmount;
	/**是否已开发票*/
	@Excel(name="是否已开发票",width=15)
	private java.lang.String brpIsInvoice;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String brpRemark;
	/**开票日期*/
	@Excel(name="开票日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date brpInvoiceDate;
	
	/**项目管理外键*/
	@Excel(name="项目管理外键",width=15)
	private java.lang.String fromId;
	/**合同约定收款外键*/
	@Excel(name="合同约定收款外键",width=15)
	private java.lang.String fromConpayId;
	
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
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  序号
	 */
	
	@Column(name ="BRP_SEQ_NO",nullable=true,length=32)
	public java.lang.String getBrpSeqNo(){
		return this.brpSeqNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  序号
	 */
	public void setBrpSeqNo(java.lang.String brpSeqNo){
		this.brpSeqNo = brpSeqNo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  进度款分期
	 */
	
	@Column(name ="BRP_PROGRESS_STAGES",nullable=true,length=32)
	public java.lang.String getBrpProgressStages(){
		return this.brpProgressStages;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进度款分期
	 */
	public void setBrpProgressStages(java.lang.String brpProgressStages){
		this.brpProgressStages = brpProgressStages;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计回款日期
	 */
	
	@Column(name ="BRP_EXT_BACK_DATE",nullable=true)
	public java.util.Date getBrpExtBackDate(){
		return this.brpExtBackDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计回款日期
	 */
	public void setBrpExtBackDate(java.util.Date brpExtBackDate){
		this.brpExtBackDate = brpExtBackDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  回款金额
	 */
	
	@Column(name ="BRP_BACK_AMOUNT",nullable=true,length=32)
	public java.lang.String getBrpBackAmount(){
		return this.brpBackAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回款金额
	 */
	public void setBrpBackAmount(java.lang.String brpBackAmount){
		this.brpBackAmount = brpBackAmount;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计划开票日期
	 */
	
	@Column(name ="BRP_PLAN_INVOICE_DATE",nullable=true)
	public java.util.Date getBrpPlanInvoiceDate(){
		return this.brpPlanInvoiceDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计划开票日期
	 */
	public void setBrpPlanInvoiceDate(java.util.Date brpPlanInvoiceDate){
		this.brpPlanInvoiceDate = brpPlanInvoiceDate;
	}
	
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否已开发票
	 */
	
	@Column(name ="BRP_IS_INVOICE",nullable=true,length=32)
	public java.lang.String getBrpIsInvoice(){
		return this.brpIsInvoice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否已开发票
	 */
	public void setBrpIsInvoice(java.lang.String brpIsInvoice){
		this.brpIsInvoice = brpIsInvoice;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="BRP_REMARK",nullable=true,length=32)
	public java.lang.String getBrpRemark(){
		return this.brpRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBrpRemark(java.lang.String brpRemark){
		this.brpRemark = brpRemark;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开票日期
	 */
	
	@Column(name ="BRP_INVOICE_DATE",nullable=true)
	public java.util.Date getBrpInvoiceDate(){
		return this.brpInvoiceDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开票日期
	 */
	public void setBrpInvoiceDate(java.util.Date brpInvoiceDate){
		this.brpInvoiceDate = brpInvoiceDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目管理外键
	 */
	
	@Column(name ="FROM_ID",nullable=true,length=32)
	public java.lang.String getFromId(){
		return this.fromId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目管理外键
	 */
	public void setFromId(java.lang.String fromId){
		this.fromId = fromId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同约定收款外键
	 */
	
	@Column(name ="FROM_CONPAY_ID",nullable=true,length=32)
	public java.lang.String getFromConpayId(){
		return this.fromConpayId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同约定收款外键
	 */
	public void setFromConpayId(java.lang.String fromConpayId){
		this.fromConpayId = fromConpayId;
	}
	
}
