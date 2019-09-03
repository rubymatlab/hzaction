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
 * @Description: 其他支出汇总
 * @author onlineGenerator
 * @date 2019-09-02 18:55:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_bus_others_proj_pay", schema = "")
@SuppressWarnings("serial")
public class VwBusOthersProjPayEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpmProjId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpmName;
	/**付款金额*/
	@Excel(name="付款金额",width=15)
	private java.lang.String payTamount;
	
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
	 *@return: java.lang.String  付款金额
	 */
	
	@Column(name ="PAY_TAMOUNT",nullable=true,length=32)
	public java.lang.String getPayTamount(){
		return this.payTamount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款金额
	 */
	public void setPayTamount(java.lang.String payTamount){
		this.payTamount = payTamount;
	}
	
}
