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
 * @Description: 采购应付/已付明细
 * @author onlineGenerator
 * @date 2019-09-01 10:48:56
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_bus_po_contract_pay", schema = "")
@SuppressWarnings("serial")
public class VwBusPoContractPayEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpmProjId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpmName;
	/**费用分期*/
	@Excel(name="费用分期",width=15)
	private java.lang.String bpcpProgreName;
	/**计划付款日期*/
	@Excel(name="计划付款日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpcpDate;
	/**计划付款金额*/
	@Excel(name="计划付款金额",width=15)
	private java.lang.String bpcpPayAmount;
	/**实际付款日期*/
	@Excel(name="实际付款日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date bppPayDate;
	/**付款金额*/
	@Excel(name="付款金额",width=15)
	private java.lang.String payAmount;
	/**项目结算id*/
	@Excel(name="项目结算id",width=15)
	private java.lang.String formCostAccountId;
	
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
	
	@Column(name ="BPM_PROJ_ID",nullable=true,length=32)
	public java.lang.String getBpmProjId(){
		return this.bpmProjId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目编号
	 */
	public void setBpmProjId(java.lang.String bpmProjId){
		this.bpmProjId = bpmProjId;
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
	 *@return: java.lang.String  费用分期
	 */
	
	@Column(name ="BPCP_PROGRE_NAME",nullable=true,length=32)
	public java.lang.String getBpcpProgreName(){
		return this.bpcpProgreName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用分期
	 */
	public void setBpcpProgreName(java.lang.String bpcpProgreName){
		this.bpcpProgreName = bpcpProgreName;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计划付款日期
	 */
	
	@Column(name ="BPCP_DATE",nullable=true,length=32)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  实际付款日期
	 */
	
	@Column(name ="BPP_PAY_DATE",nullable=true,length=32)
	public java.util.Date getBppPayDate(){
		return this.bppPayDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  实际付款日期
	 */
	public void setBppPayDate(java.util.Date bppPayDate){
		this.bppPayDate = bppPayDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款金额
	 */
	
	@Column(name ="PAY_AMOUNT",nullable=true,length=32)
	public java.lang.String getPayAmount(){
		return this.payAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款金额
	 */
	public void setPayAmount(java.lang.String payAmount){
		this.payAmount = payAmount;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目结算id
	 */
	
	@Column(name ="FORM_COST_ACCOUNT_ID",nullable=true,length=32)
	public java.lang.String getFormCostAccountId(){
		return this.formCostAccountId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目结算id
	 */
	public void setFormCostAccountId(java.lang.String formCostAccountId){
		this.formCostAccountId = formCostAccountId;
	}
	
}
