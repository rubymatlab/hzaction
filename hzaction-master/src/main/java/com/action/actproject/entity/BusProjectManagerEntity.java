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
 * @Description: 项目管理
 * @author onlineGenerator
 * @date 2019-07-26 20:09:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_project_manager", schema = "")
@SuppressWarnings("serial")
public class BusProjectManagerEntity implements java.io.Serializable {
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
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpmName;
	/**项目进度*/
	@Excel(name="项目进度",width=15)
	private java.lang.String bpmProjProg;
	/**进度百分比*/
	@Excel(name="进度百分比",width=15)
	private java.lang.String bpmProgPer;
	/**收款计划备注*/
	@Excel(name="收款计划备注",width=15)
	private java.lang.String bpmFollowRemark;
	/**项目立项外键*/
	@Excel(name="项目立项外键",width=15)
	private java.lang.String fromProjId;
	/**客户资料外键*/
	@Excel(name="客户资料外键",width=15)
	private java.lang.String fromCustId;
	
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpmProjId;
	/**合同管理外键*/
	@Excel(name="合同管理外键",width=15)
	private java.lang.String fromContractId;
	
	
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
	 *@return: java.lang.String  项目进度
	 */
	
	@Column(name ="BPM_PROJ_PROG",nullable=true,length=32)
	public java.lang.String getBpmProjProg(){
		return this.bpmProjProg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目进度
	 */
	public void setBpmProjProg(java.lang.String bpmProjProg){
		this.bpmProjProg = bpmProjProg;
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
	 *@return: java.lang.String  收款计划备注
	 */
	
	@Column(name ="BPM_FOLLOW_REMARK",nullable=true,length=32)
	public java.lang.String getBpmFollowRemark(){
		return this.bpmFollowRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款计划备注
	 */
	public void setBpmFollowRemark(java.lang.String bpmFollowRemark){
		this.bpmFollowRemark = bpmFollowRemark;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目立项外键
	 */
	
	@Column(name ="FROM_PROJ_ID",nullable=true,length=32)
	public java.lang.String getFromProjId(){
		return this.fromProjId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目立项外键
	 */
	public void setFromProjId(java.lang.String fromProjId){
		this.fromProjId = fromProjId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户资料外键
	 */
	
	@Column(name ="FROM_CUST_ID",nullable=true,length=32)
	public java.lang.String getFromCustId(){
		return this.fromCustId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户资料外键
	 */
	public void setFromCustId(java.lang.String fromCustId){
		this.fromCustId = fromCustId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目编号
	 */
	@Column(name ="bpm_proj_id",nullable=true,length=32)
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
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同管理外键
	 */
	@Column(name ="from_contract_id",nullable=true,length=32)
	public java.lang.String getFromContractId() {
		return fromContractId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同管理外键
	 */
	public void setFromContractId(java.lang.String fromContractId) {
		this.fromContractId = fromContractId;
	}
	
}
