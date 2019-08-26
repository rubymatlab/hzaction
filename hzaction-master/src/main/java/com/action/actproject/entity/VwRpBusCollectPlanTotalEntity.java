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
 * @Description: 回款计划汇总
 * @author onlineGenerator
 * @date 2019-08-01 17:23:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_rp_bus_collect_plan_total", schema = "")
@SuppressWarnings("serial")
public class VwRpBusCollectPlanTotalEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**项目经理*/
	@Excel(name="项目经理",width=15)
	private java.lang.String bpManager;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpProjId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpmName;
	/**进度款分期*/
	@Excel(name="进度款分期",width=15)
	private java.lang.String brpProgressStages;
	/**合同金额*/
	@Excel(name="合同金额",width=15)
	private java.lang.String brpContractAmount;
	/**已收金额*/
	@Excel(name="已收金额",width=15)
	private java.lang.String brpAcceptAmount;
	/**预计回款金额*/
	@Excel(name="预计回款金额",width=15)
	private java.lang.String brpBackAmount;
	/**是否开发票*/
	@Excel(name="是否开发票",width=15)
	private java.lang.String brpIsInvoice;
	/**跟踪情况*/
	@Excel(name="跟踪情况",width=15)
	private java.lang.String followDesc;
	/**客户名称*/
	@Excel(name="客户名称",width=15)
	private java.lang.String bcName;
	/**签订时间*/
	@Excel(name="签订时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bcConcludeTime;
	
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
	 *@return: java.lang.String  项目编号
	 */

	@Column(name ="BP_PROJ_ID",nullable=true,length=32)
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

	@Column(name ="BPM_NAME",nullable=true,length=32)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同金额
	 */

	@Column(name ="BRP_CONTRACT_AMOUNT",nullable=true,length=32)
	public java.lang.String getBrpContractAmount(){
		return this.brpContractAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同金额
	 */
	public void setBrpContractAmount(java.lang.String brpContractAmount){
		this.brpContractAmount = brpContractAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  已收金额
	 */

	@Column(name ="BRP_ACCEPT_AMOUNT",nullable=true,length=32)
	public java.lang.String getBrpAcceptAmount(){
		return this.brpAcceptAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  已收金额
	 */
	public void setBrpAcceptAmount(java.lang.String brpAcceptAmount){
		this.brpAcceptAmount = brpAcceptAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预计回款金额
	 */

	@Column(name ="BRP_BACK_AMOUNT",nullable=true,length=32)
	public java.lang.String getBrpBackAmount(){
		return this.brpBackAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预计回款金额
	 */
	public void setBrpBackAmount(java.lang.String brpBackAmount){
		this.brpBackAmount = brpBackAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否开发票
	 */

	@Column(name ="BRP_IS_INVOICE",nullable=true,length=32)
	public java.lang.String getBrpIsInvoice(){
		return this.brpIsInvoice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否开发票
	 */
	public void setBrpIsInvoice(java.lang.String brpIsInvoice){
		this.brpIsInvoice = brpIsInvoice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  跟踪情况
	 */

	@Column(name ="FOLLOW_DESC",nullable=true,length=32)
	public java.lang.String getFollowDesc(){
		return this.followDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  跟踪情况
	 */
	public void setFollowDesc(java.lang.String followDesc){
		this.followDesc = followDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */

	@Column(name ="BC_NAME",nullable=true,length=32)
	public java.lang.String getBcName(){
		return this.bcName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setBcName(java.lang.String bcName){
		this.bcName = bcName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签订时间
	 */

	@Column(name ="BC_CONCLUDE_TIME",nullable=true,length=32)
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
}
