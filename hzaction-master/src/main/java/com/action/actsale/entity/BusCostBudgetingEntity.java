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
 * @Description: 成本预算附表
 * @author onlineGenerator
 * @date 2019-07-18 19:54:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_cost_budgeting", schema = "")
@SuppressWarnings("serial")
public class BusCostBudgetingEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新日期*/
	private java.util.Date updateDate;
	/**费用类型*/
	@Excel(name="费用类型",width=15,dicCode="cost_type")
	private java.lang.String bcbCostType;
	/**预算*/
	@Excel(name="预算",width=15)
	private java.lang.String bcbBudget;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String bcbRemark;
	/**合同管理主表外键*/
	private java.lang.String busContractId;
	
	
	@Override
	public String toString() {
		return "BusCostBudgetingEntity [id=" + id + ", bpmStatus=" + bpmStatus + ", createName=" + createName
				+ ", createBy=" + createBy + ", updateName=" + updateName + ", updateBy=" + updateBy + ", sysOrgCode="
				+ sysOrgCode + ", sysCompanyCode=" + sysCompanyCode + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", bcbCostType=" + bcbCostType + ", bcbBudget=" + bcbBudget + ", bcbRemark=" + bcbRemark
				+ ", busContractId=" + busContractId + "]";
	}

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
	 *@return: java.lang.String  费用类型
	 */
	
	@Column(name ="BCB_COST_TYPE",nullable=true,length=32)
	public java.lang.String getBcbCostType(){
		return this.bcbCostType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用类型
	 */
	public void setBcbCostType(java.lang.String bcbCostType){
		this.bcbCostType = bcbCostType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预算
	 */
	
	@Column(name ="BCB_BUDGET",nullable=true,length=32)
	public java.lang.String getBcbBudget(){
		return this.bcbBudget;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预算
	 */
	public void setBcbBudget(java.lang.String bcbBudget){
		this.bcbBudget = bcbBudget;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="BCB_REMARK",nullable=true,length=100)
	public java.lang.String getBcbRemark(){
		return this.bcbRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBcbRemark(java.lang.String bcbRemark){
		this.bcbRemark = bcbRemark;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同管理主表外键
	 */
	
	@Column(name ="BUS_CONTRACT_ID",nullable=true,length=32)
	public java.lang.String getBusContractId(){
		return this.busContractId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同管理主表外键
	 */
	public void setBusContractId(java.lang.String busContractId){
		this.busContractId = busContractId;
	}
	
}
