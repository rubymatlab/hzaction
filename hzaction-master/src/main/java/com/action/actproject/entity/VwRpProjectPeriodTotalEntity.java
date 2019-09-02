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
 * @Description: 项目整体周期汇总表
 * @author onlineGenerator
 * @date 2019-07-31 16:02:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_rp_project_period_total", schema = "")
@SuppressWarnings("serial")
public class VwRpProjectPeriodTotalEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpProjId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpProjName;
	/**项目经理*/
	@Excel(name="项目经理",width=15)
	private java.lang.String bpManager;
	/**立项时间*/
	@Excel(name="立项时间",width=15)
	private java.util.Date bpDate;
	/**合同签定时间*/
	@Excel(name="合同签定时间",width=15)
	private java.util.Date bcConcludeTime;
	/**合同天数*/
	@Excel(name="合同天数",width=15)
	private java.lang.String contractDays;
	/**验收时间*/
	@Excel(name="验收时间",width=15)
	private java.lang.String maxBpfCheckDate;
	/**验收天数*/
	@Excel(name="验收天数",width=15)
	private java.lang.String checkDays;
	/**最后收款时间*/
	@Excel(name="最后收款时间",width=15)
	private java.lang.String maxBcColDate;
	/**收款天数*/
	@Excel(name="收款天数",width=15)
	private java.lang.String colDays;
	/**客户名称*/
	@Excel(name="客户名称",width=15)
	private java.lang.String bcName;
	
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

	@Column(name ="BP_PROJ_NAME",nullable=true,length=32)
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
	 *@return: java.lang.String  立项时间
	 */

	@Column(name ="BP_DATE",nullable=true,length=32)
	public java.util.Date getBpDate(){
		return this.bpDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  立项时间
	 */
	public void setBpDate(java.util.Date bpDate){
		this.bpDate = bpDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同签定时间
	 */

	@Column(name ="BC_CONCLUDE_TIME",nullable=true,length=32)
	public java.util.Date getBcConcludeTime(){
		return this.bcConcludeTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同签定时间
	 */
	public void setBcConcludeTime(java.util.Date bcConcludeTime){
		this.bcConcludeTime = bcConcludeTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同天数
	 */

	@Column(name ="CONTRACT_DAYS",nullable=true,length=32)
	public java.lang.String getContractDays(){
		return this.contractDays;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同天数
	 */
	public void setContractDays(java.lang.String contractDays){
		this.contractDays = contractDays;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  验收时间
	 */

	@Column(name ="MAX_BPF_CHECK_DATE",nullable=true,length=32)
	public java.lang.String getMaxBpfCheckDate(){
		return this.maxBpfCheckDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  验收时间
	 */
	public void setMaxBpfCheckDate(java.lang.String maxBpfCheckDate){
		this.maxBpfCheckDate = maxBpfCheckDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  验收天数
	 */

	@Column(name ="CHECK_DAYS",nullable=true,length=32)
	public java.lang.String getCheckDays(){
		return this.checkDays;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  验收天数
	 */
	public void setCheckDays(java.lang.String checkDays){
		this.checkDays = checkDays;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  最后收款时间
	 */

	@Column(name ="MAX_BC_COL_DATE",nullable=true,length=32)
	public java.lang.String getMaxBcColDate(){
		return this.maxBcColDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最后收款时间
	 */
	public void setMaxBcColDate(java.lang.String maxBcColDate){
		this.maxBcColDate = maxBcColDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款天数
	 */

	@Column(name ="COL_DAYS",nullable=true,length=32)
	public java.lang.String getColDays(){
		return this.colDays;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款天数
	 */
	public void setColDays(java.lang.String colDays){
		this.colDays = colDays;
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
}
