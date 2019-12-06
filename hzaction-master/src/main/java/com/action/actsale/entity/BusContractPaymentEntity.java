package com.action.actsale.entity;
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
 * @Description: 合同约定收款附表
 * @author onlineGenerator
 * @date 2019-08-07 14:26:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_contract_payment", schema = "")
@SuppressWarnings("serial")
public class BusContractPaymentEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
//	@Excel(name="创建人名称",width=15)
	private java.lang.String createName;
	/**创建人登录名称*/
//	@Excel(name="创建人登录名称",width=15)
	private java.lang.String createBy;
	/**创建日期*/
//	@Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**更新人名称*/
//	@Excel(name="更新人名称",width=15)
	private java.lang.String updateName;
	/**更新人登录名称*/
//	@Excel(name="更新人登录名称",width=15)
	private java.lang.String updateBy;
	/**更新日期*/
//	@Excel(name="更新日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date updateDate;
	/**所属部门*/
//	@Excel(name="所属部门",width=15)
	private java.lang.String sysOrgCode;
	/**所属公司*/
//	@Excel(name="所属公司",width=15)
	private java.lang.String sysCompanyCode;
	/**流程状态*/
//	@Excel(name="流程状态",width=15)
	private java.lang.String bpmStatus;
	/**序号*/
//	@Excel(name="序号",width=15)
	private java.lang.String bcpSeqNo;
	/**合同金额*/
	@Excel(name="合同金额",width=15)
	private java.lang.Integer bcpContractAmount;
	/**付款条件*/
	@Excel(name="付款条件",width=15)
	private java.lang.String bcpPaymentClause;
	/**付款比例*/
	@Excel(name="付款比例",width=15)
	private java.lang.String bcpPaymentProportion;
	/**进度款分期*/
	@Excel(name="进度款分期",width=15,dicCode="cost_stag")
	private java.lang.String bcpProgrePayment;
	/**合同管理外键*/
//	@Excel(name="合同管理外键",width=15)
	private java.lang.String busContractId;
	
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
	 *@return: java.lang.String  付款比例
	 */
	
	@Column(name ="BCP_PAYMENT_PROPORTION",nullable=true,length=50)
	public java.lang.String getBcpPaymentProportion(){
		return this.bcpPaymentProportion;
	}
	
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款比例
	 */
	public void setBcpPaymentProportion(java.lang.String bcpPaymentProportion){
		this.bcpPaymentProportion = bcpPaymentProportion;
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
	
	@Column(name ="BCP_SEQ_NO",nullable=true,length=32)
	public java.lang.String getBcpSeqNo(){
		return this.bcpSeqNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  序号
	 */
	public void setBcpSeqNo(java.lang.String bcpSeqNo){
		this.bcpSeqNo = bcpSeqNo;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  合同金额
	 */
	
	@Column(name ="BCP_CONTRACT_AMOUNT",nullable=true,length=10)
	public java.lang.Integer getBcpContractAmount(){
		return this.bcpContractAmount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  合同金额
	 */
	public void setBcpContractAmount(java.lang.Integer bcpContractAmount){
		this.bcpContractAmount = bcpContractAmount;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款条件
	 */
	
	@Column(name ="BCP_PAYMENT_CLAUSE",nullable=true,length=32)
	public java.lang.String getBcpPaymentClause(){
		return this.bcpPaymentClause;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款条件
	 */
	public void setBcpPaymentClause(java.lang.String bcpPaymentClause){
		this.bcpPaymentClause = bcpPaymentClause;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  进度款分期
	 */
	
	@Column(name ="BCP_PROGRE_PAYMENT",nullable=true,length=32)
	public java.lang.String getBcpProgrePayment(){
		return this.bcpProgrePayment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进度款分期
	 */
	public void setBcpProgrePayment(java.lang.String bcpProgrePayment){
		this.bcpProgrePayment = bcpProgrePayment;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同管理外键
	 */
	
	@Column(name ="BUS_CONTRACT_ID",nullable=true,length=32)
	public java.lang.String getBusContractId(){
		return this.busContractId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同管理外键
	 */
	public void setBusContractId(java.lang.String busContractId){
		this.busContractId = busContractId;
	}
	
}
