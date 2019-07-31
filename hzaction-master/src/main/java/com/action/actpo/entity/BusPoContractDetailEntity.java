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
 * @Description: 采购合同明细
 * @author onlineGenerator
 * @date 2019-07-30 13:14:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_po_contract_detail", schema = "")
@SuppressWarnings("serial")
public class BusPoContractDetailEntity implements java.io.Serializable {
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
	/**费用类型*/
	@Excel(name="费用类型",width=15,dicCode="cost_type")
	private java.lang.String bpcdPayType;
	/**名称*/
	@Excel(name="名称",width=15)
	private java.lang.String bpcdName;
	/**品牌*/
	@Excel(name="品牌",width=15)
	private java.lang.String bpcdBrand;
	/**型号*/
	@Excel(name="型号",width=15)
	private java.lang.String bpcdModel;
	/**数量*/
	@Excel(name="数量",width=15)
	private java.lang.String bpcdNumber;
	/**单价*/
	@Excel(name="单价",width=15)
	private java.lang.String bpcdPrice;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.lang.String bpcdAmount;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String bpcdRemark;
	/**采购合同外键*/
	@Excel(name="采购合同外键",width=15)
	private java.lang.String fromId;
	
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
	 *@return: java.lang.String  费用类型
	 */
	
	@Column(name ="BPCD_PAY_TYPE",nullable=true,length=32)
	public java.lang.String getBpcdPayType(){
		return this.bpcdPayType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用类型
	 */
	public void setBpcdPayType(java.lang.String bpcdPayType){
		this.bpcdPayType = bpcdPayType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */
	
	@Column(name ="BPCD_NAME",nullable=true,length=32)
	public java.lang.String getBpcdName(){
		return this.bpcdName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setBpcdName(java.lang.String bpcdName){
		this.bpcdName = bpcdName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品牌
	 */
	
	@Column(name ="BPCD_BRAND",nullable=true,length=32)
	public java.lang.String getBpcdBrand(){
		return this.bpcdBrand;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品牌
	 */
	public void setBpcdBrand(java.lang.String bpcdBrand){
		this.bpcdBrand = bpcdBrand;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  型号
	 */
	
	@Column(name ="BPCD_MODEL",nullable=true,length=32)
	public java.lang.String getBpcdModel(){
		return this.bpcdModel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  型号
	 */
	public void setBpcdModel(java.lang.String bpcdModel){
		this.bpcdModel = bpcdModel;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数量
	 */
	
	@Column(name ="BPCD_NUMBER",nullable=true,length=32)
	public java.lang.String getBpcdNumber(){
		return this.bpcdNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数量
	 */
	public void setBpcdNumber(java.lang.String bpcdNumber){
		this.bpcdNumber = bpcdNumber;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单价
	 */
	
	@Column(name ="BPCD_PRICE",nullable=true,length=32)
	public java.lang.String getBpcdPrice(){
		return this.bpcdPrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单价
	 */
	public void setBpcdPrice(java.lang.String bpcdPrice){
		this.bpcdPrice = bpcdPrice;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  金额
	 */
	
	@Column(name ="BPCD_AMOUNT",nullable=true,length=32)
	public java.lang.String getBpcdAmount(){
		return this.bpcdAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  金额
	 */
	public void setBpcdAmount(java.lang.String bpcdAmount){
		this.bpcdAmount = bpcdAmount;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="BPCD_REMARK",nullable=true,length=32)
	public java.lang.String getBpcdRemark(){
		return this.bpcdRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBpcdRemark(java.lang.String bpcdRemark){
		this.bpcdRemark = bpcdRemark;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购合同外键
	 */
	
	@Column(name ="FROM_ID",nullable=true,length=32)
	public java.lang.String getFromId(){
		return this.fromId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购合同外键
	 */
	public void setFromId(java.lang.String fromId){
		this.fromId = fromId;
	}
	
}
