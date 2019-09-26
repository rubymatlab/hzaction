package com.action.actpo.entity;

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
 * @Description: 采购付款计划表
 * @author onlineGenerator
 * @date 2019-09-25 00:08:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_rp_po_pay_plan", schema = "")
@SuppressWarnings("serial")
public class VwRpPoPayPlanEntity implements java.io.Serializable {
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
	/**供应商名称*/
	@Excel(name="供应商名称",width=15)
	private java.lang.String bsName;
	/**签订时间*/
	@Excel(name="签订时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bcConcludeTime;
	/**费用分期*/
	@Excel(name="费用分期",width=15)
	private java.lang.String bpcpProgre;
	/**计划付款日期*/
	@Excel(name="计划付款日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpcpDate;
	/**计划付款金额*/
	@Excel(name="计划付款金额",width=15)
	private java.lang.String bpcpPayAmount;
	/**付款金额*/
	@Excel(name="付款金额",width=15)
	private java.lang.String bppdPayAmount;
	/**未付款金额*/
	@Excel(name="未付款金额",width=15)
	private java.lang.Double notPayAmount;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=true,length=36)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签订时间
	 */

	@Column(name ="BC_CONCLUDE_TIME",nullable=true)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计划付款日期
	 */

	@Column(name ="BPCP_DATE",nullable=true)
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
	 *@return: java.lang.String  计划付款金额
	 */

	@Column(name ="BPCP_PAY_AMOUNT",nullable=true,length=32)
	public java.lang.String getBpcpPayAmount(){
		return this.bpcpPayAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划付款金额
	 */
	public void setBpcpPayAmount(java.lang.String bpcpPayAmount){
		this.bpcpPayAmount = bpcpPayAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款金额
	 */

	@Column(name ="BPPD_PAY_AMOUNT",nullable=true,length=32)
	public java.lang.String getBppdPayAmount(){
		return this.bppdPayAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款金额
	 */
	public void setBppdPayAmount(java.lang.String bppdPayAmount){
		this.bppdPayAmount = bppdPayAmount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  未付款金额
	 */

	@Column(name ="NOT_PAY_AMOUNT",nullable=true,length=23)
	public java.lang.Double getNotPayAmount(){
		return this.notPayAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  未付款金额
	 */
	public void setNotPayAmount(java.lang.Double notPayAmount){
		this.notPayAmount = notPayAmount;
	}
}
