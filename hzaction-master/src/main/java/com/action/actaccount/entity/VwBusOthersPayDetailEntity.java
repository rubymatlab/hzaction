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
 * @Description: 其他支出明细
 * @author onlineGenerator
 * @date 2019-09-02 18:55:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_bus_others_pay_detail", schema = "")
@SuppressWarnings("serial")
public class VwBusOthersPayDetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpmProjId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpmName;
	/**单号*/
	@Excel(name="单号",width=15)
	private java.lang.String busId;
	/**单据_费用类型*/
	@Excel(name="单据_费用类型",width=15,dicCode="cost_type")
	private java.lang.String busType;
	/**申请日期*/
	@Excel(name="申请日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date applyDate;
	/**付款金额*/
	@Excel(name="付款金额",width=15)
	private java.lang.String payAmount;
	
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
	 *@return: java.lang.String  单号
	 */
	
	@Column(name ="BUS_ID",nullable=true,length=32)
	public java.lang.String getBusId(){
		return this.busId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单号
	 */
	public void setBusId(java.lang.String busId){
		this.busId = busId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单据_费用类型
	 */
	
	@Column(name ="BUS_TYPE",nullable=true,length=32)
	public java.lang.String getBusType(){
		return this.busType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单据_费用类型
	 */
	public void setBusType(java.lang.String busType){
		this.busType = busType;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请日期
	 */
	
	@Column(name ="APPLY_DATE",nullable=true,length=32)
	public java.util.Date getApplyDate(){
		return this.applyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请日期
	 */
	public void setApplyDate(java.util.Date applyDate){
		this.applyDate = applyDate;
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
	
}
