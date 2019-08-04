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
 * @Description: 合同明细报价附表
 * @author onlineGenerator
 * @date 2019-07-26 16:28:39
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_con_quoted_price", schema = "")
@SuppressWarnings("serial")
public class BusConQuotedPriceEntity implements java.io.Serializable {
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
	/**名称*/
	@Excel(name="名称",width=15)
	private java.lang.String bcqpName;
	/**品牌*/
	@Excel(name="品牌",width=15)
	private java.lang.String bcqpBrand;
	/**型号*/
	@Excel(name="型号",width=15)
	private java.lang.String bcqpModel;
	/**数量*/
	@Excel(name="数量",width=15)
	private java.math.BigDecimal bcqpQty;
	/**单价*/
	@Excel(name="单价",width=15)
	private java.math.BigDecimal bcqpPrice;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.math.BigDecimal bcqpAmount;
	/**合同管理外键
	@Excel(name="合同管理外键",width=15)*/
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
	
	@Column(name ="CREATE_DATE",nullable=true,length=20)
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
	
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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
	 *@return: java.lang.String  名称
	 */
	
	@Column(name ="BCQP_NAME",nullable=true,length=32)
	public java.lang.String getBcqpName(){
		return this.bcqpName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setBcqpName(java.lang.String bcqpName){
		this.bcqpName = bcqpName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品牌
	 */
	
	@Column(name ="BCQP_BRAND",nullable=true,length=32)
	public java.lang.String getBcqpBrand(){
		return this.bcqpBrand;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品牌
	 */
	public void setBcqpBrand(java.lang.String bcqpBrand){
		this.bcqpBrand = bcqpBrand;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  型号
	 */
	
	@Column(name ="BCQP_MODEL",nullable=true,length=32)
	public java.lang.String getBcqpModel(){
		return this.bcqpModel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  型号
	 */
	public void setBcqpModel(java.lang.String bcqpModel){
		this.bcqpModel = bcqpModel;
	}
	
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  数量
	 */
	
	@Column(name ="BCQP_QTY",nullable=true,length=32)
	public java.math.BigDecimal getBcqpQty(){
		return this.bcqpQty;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  数量
	 */
	public void setBcqpQty(java.math.BigDecimal bcqpQty){
		this.bcqpQty = bcqpQty;
	}
	
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  单价
	 */
	
	@Column(name ="BCQP_PRICE",nullable=true,length=32)
	public java.math.BigDecimal getBcqpPrice(){
		return this.bcqpPrice;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  单价
	 */
	public void setBcqpPrice(java.math.BigDecimal bcqpPrice){
		this.bcqpPrice = bcqpPrice;
	}
	
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  金额
	 */
	
	@Column(name ="BCQP_AMOUNT",nullable=true,length=32)
	public java.math.BigDecimal getBcqpAmount(){
		return this.bcqpAmount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  金额
	 */
	public void setBcqpAmount(java.math.BigDecimal bcqpAmount){
		this.bcqpAmount = bcqpAmount;
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

	@Override
	public String toString() {
		return "BusConQuotedPriceEntity [id=" + id + ", createName=" + createName + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", updateName=" + updateName + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + ", sysOrgCode=" + sysOrgCode + ", sysCompanyCode=" + sysCompanyCode
				+ ", bpmStatus=" + bpmStatus + ", bcqpName=" + bcqpName + ", bcqpBrand=" + bcqpBrand + ", bcqpModel="
				+ bcqpModel + ", bcqpQty=" + bcqpQty + ", bcqpPrice=" + bcqpPrice + ", bcqpAmount=" + bcqpAmount
				+ ", busContractId=" + busContractId + "]";
	}
	
	
	
}
