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
 * @Description: 施工进度报表
 * @author onlineGenerator
 * @date 2019-08-01 11:16:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_rp_bus_progress_info", schema = "")
@SuppressWarnings("serial")
public class VwRpBusProgressInfoEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpProjId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpmName;
	/**项目经理*/
	@Excel(name="项目经理",width=15)
	private java.lang.String bpManager;
	/**客户名称*/
	@Excel(name="客户名称",width=15)
	private java.lang.String bcName;
	/**合同金额万元*/
	@Excel(name="合同金额万元",width=15)
	private java.lang.String bcContAmount;
	/**brpBackAmountD*/
	@Excel(name="brpBackAmountD",width=15)
	private java.lang.Double brpBackAmountD;
	/**进度百分比*/
	@Excel(name="进度百分比",width=15,dicCode="proj_per")
	private java.lang.String bpmProgPer;
	/**验收结果*/
	@Excel(name="验收结果",width=15,dicCode="check_res")
	private java.lang.String bpfCheckResult;
	/**验收时间*/
	@Excel(name="验收时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpfCheckDate;
	/**施工困难_问题*/
	@Excel(name="施工困难_问题",width=15)
	private java.lang.String bpfQuestions;
	/**下一步计划*/
	@Excel(name="下一步计划",width=15)
	private java.lang.String bpfNextPlan;
	
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
	 *@return: java.lang.String  客户名称
	 */

	@Column(name ="BC_NAME",nullable=true,length=100)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同金额万元
	 */

	@Column(name ="BC_CONT_AMOUNT",nullable=true,length=32)
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
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  brpBackAmountD
	 */

	@Column(name ="BRP_BACK_AMOUNT_D",nullable=true,length=23)
	public java.lang.Double getBrpBackAmountD(){
		return this.brpBackAmountD;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  brpBackAmountD
	 */
	public void setBrpBackAmountD(java.lang.Double brpBackAmountD){
		this.brpBackAmountD = brpBackAmountD;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  进度百分比
	 */

	@Column(name ="BPM_PROG_PER",nullable=true,length=32)
	public java.lang.String getBpmProgPer(){
		return this.bpmProgPer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进度百分比
	 */
	public void setBpmProgPer(java.lang.String bpmProgPer){
		this.bpmProgPer = bpmProgPer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  验收结果
	 */

	@Column(name ="BPF_CHECK_RESULT",nullable=true,length=32)
	public java.lang.String getBpfCheckResult(){
		return this.bpfCheckResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  验收结果
	 */
	public void setBpfCheckResult(java.lang.String bpfCheckResult){
		this.bpfCheckResult = bpfCheckResult;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  验收时间
	 */

	@Column(name ="BPF_CHECK_DATE",nullable=true)
	public java.util.Date getBpfCheckDate(){
		return this.bpfCheckDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  验收时间
	 */
	public void setBpfCheckDate(java.util.Date bpfCheckDate){
		this.bpfCheckDate = bpfCheckDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  施工困难_问题
	 */

	@Column(name ="BPF_QUESTIONS",nullable=true,length=32)
	public java.lang.String getBpfQuestions(){
		return this.bpfQuestions;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  施工困难_问题
	 */
	public void setBpfQuestions(java.lang.String bpfQuestions){
		this.bpfQuestions = bpfQuestions;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下一步计划
	 */

	@Column(name ="BPF_NEXT_PLAN",nullable=true,length=32)
	public java.lang.String getBpfNextPlan(){
		return this.bpfNextPlan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下一步计划
	 */
	public void setBpfNextPlan(java.lang.String bpfNextPlan){
		this.bpfNextPlan = bpfNextPlan;
	}
}
