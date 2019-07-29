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
 * @Description: 项目跟进分配
 * @author onlineGenerator
 * @date 2019-07-25 07:20:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_project_follow", schema = "")
@SuppressWarnings("serial")
public class BusProjectFollowEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**跟进次数*/
	@Excel(name="跟进次数",width=15)
	private java.lang.Integer bpfCount;
	/**跟进日期*/
	@Excel(name="跟进日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpfDate;
	/**项目阶段*/
	@Excel(name="项目阶段",width=15)
	private java.lang.String bpfStage;
	/**反馈信息*/
	@Excel(name="反馈信息",width=15)
	private java.lang.String bpfInfo;
	/**项目立项外键*/
	@Excel(name="项目立项外键",width=15)
	private java.lang.String fromBpid;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  跟进次数
	 */
	
	@Column(name ="BPF_COUNT",nullable=true,length=32)
	public java.lang.Integer getBpfCount(){
		return this.bpfCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  跟进次数
	 */
	public void setBpfCount(java.lang.Integer bpfCount){
		this.bpfCount = bpfCount;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  跟进日期
	 */
	
	@Column(name ="BPF_DATE",nullable=true,length=32)
	public java.util.Date getBpfDate(){
		return this.bpfDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  跟进日期
	 */
	public void setBpfDate(java.util.Date bpfDate){
		this.bpfDate = bpfDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目阶段
	 */
	
	@Column(name ="BPF_STAGE",nullable=true,length=32)
	public java.lang.String getBpfStage(){
		return this.bpfStage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目阶段
	 */
	public void setBpfStage(java.lang.String bpfStage){
		this.bpfStage = bpfStage;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  反馈信息
	 */
	
	@Column(name ="BPF_INFO",nullable=true,length=500)
	public java.lang.String getBpfInfo(){
		return this.bpfInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  反馈信息
	 */
	public void setBpfInfo(java.lang.String bpfInfo){
		this.bpfInfo = bpfInfo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目立项外键
	 */
	
	@Column(name ="FROM_BPID",nullable=true,length=36)
	public java.lang.String getFromBpid(){
		return this.fromBpid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目立项外键
	 */
	public void setFromBpid(java.lang.String fromBpid){
		this.fromBpid = fromBpid;
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
	
}
