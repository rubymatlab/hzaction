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
 * @Description: 采购总表
 * @author onlineGenerator
 * @date 2019-09-25 00:29:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_rp_po_total", schema = "")
@SuppressWarnings("serial")
public class VwRpPoTotalEntity implements java.io.Serializable {
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
	/**项目年份*/
	@Excel(name="项目年份",width=15)
	private java.lang.String projYear;
	/**采购金额*/
	@Excel(name="采购金额",width=15)
	private java.lang.Double poAmount;
	/**付款金额*/
	@Excel(name="付款金额",width=15)
	private java.lang.Double payAmount;
	/**未付款金额*/
	@Excel(name="未付款金额",width=15)
	private java.lang.Double notPayAmount;
	/**发票金额*/
	@Excel(name="发票金额",width=15)
	private java.lang.Double invAmount;
	/**未开发票金额*/
	@Excel(name="未开发票金额",width=15)
	private java.lang.Double notInvAmount;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目年份
	 */

	@Column(name ="PROJ_YEAR",nullable=true,length=4)
	public java.lang.String getProjYear(){
		return this.projYear;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目年份
	 */
	public void setProjYear(java.lang.String projYear){
		this.projYear = projYear;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  采购金额
	 */

	@Column(name ="PO_AMOUNT",nullable=true,length=23)
	public java.lang.Double getPoAmount(){
		return this.poAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  采购金额
	 */
	public void setPoAmount(java.lang.Double poAmount){
		this.poAmount = poAmount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  付款金额
	 */

	@Column(name ="PAY_AMOUNT",nullable=true,length=23)
	public java.lang.Double getPayAmount(){
		return this.payAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  付款金额
	 */
	public void setPayAmount(java.lang.Double payAmount){
		this.payAmount = payAmount;
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
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  发票金额
	 */

	@Column(name ="INV_AMOUNT",nullable=true,length=23)
	public java.lang.Double getInvAmount(){
		return this.invAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  发票金额
	 */
	public void setInvAmount(java.lang.Double invAmount){
		this.invAmount = invAmount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  未开发票金额
	 */

	@Column(name ="NOT_INV_AMOUNT",nullable=false,length=23)
	public java.lang.Double getNotInvAmount(){
		return this.notInvAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  未开发票金额
	 */
	public void setNotInvAmount(java.lang.Double notInvAmount){
		this.notInvAmount = notInvAmount;
	}
}
