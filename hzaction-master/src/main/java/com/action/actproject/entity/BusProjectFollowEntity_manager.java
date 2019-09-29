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
 * @Description: 项目跟进
 * @author onlineGenerator
 * @date 2019-07-26 20:14:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_project_follow", schema = "")
@SuppressWarnings("serial")
public class BusProjectFollowEntity_manager implements java.io.Serializable {
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
	/**跟进日期*/
	@Excel(name="跟进日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpfFollowDate;
	/**跟进情况汇报*/
	@Excel(name="跟进情况汇报",width=15)
	private java.lang.String bpfFollowReport;
	/**施工困难_问题*/
	@Excel(name="施工困难_问题",width=15)
	private java.lang.String bpfQuestions;
	/**下一步计划*/
	@Excel(name="下一步计划",width=15)
	private java.lang.String bpfNextPlan;
	/**验收时间*/
	@Excel(name="验收时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpfCheckDate;
	/**验收结果*/
	@Excel(name="验收结果",width=15,dicCode="check_res")
	private java.lang.String bpfCheckResult;
	/**项目管理外键*/
//	@Excel(name="项目管理外键",width=15)
	private java.lang.String fromId;
	/** 序号 **/
	private java.lang.String xh;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  跟进日期
	 */
	
	@Column(name ="BPF_FOLLOW_DATE",nullable=true)
	public java.util.Date getBpfFollowDate(){
		return this.bpfFollowDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  跟进日期
	 */
	public void setBpfFollowDate(java.util.Date bpfFollowDate){
		this.bpfFollowDate = bpfFollowDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  跟进情况汇报
	 */
	
	@Column(name ="BPF_FOLLOW_REPORT",nullable=true,length=32)
	public java.lang.String getBpfFollowReport(){
		return this.bpfFollowReport;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  跟进情况汇报
	 */
	public void setBpfFollowReport(java.lang.String bpfFollowReport){
		this.bpfFollowReport = bpfFollowReport;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  施工困难_问题
	 */
	
	@Column(name ="BPF_QUESTIONS",nullable=true,length=32)
	public java.lang.String getBpfQuestions(){
		return this.bpfQuestions;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  施工困难_问题
	 */
	public void setBpfQuestions(java.lang.String bpfQuestions){
		this.bpfQuestions = bpfQuestions;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下一步计划
	 */
	
	@Column(name ="BPF_NEXT_PLAN",nullable=true,length=32)
	public java.lang.String getBpfNextPlan(){
		return this.bpfNextPlan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下一步计划
	 */
	public void setBpfNextPlan(java.lang.String bpfNextPlan){
		this.bpfNextPlan = bpfNextPlan;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  验收时间
	 */
	
	@Column(name ="BPF_CHECK_DATE",nullable=true)
	public java.util.Date getBpfCheckDate(){
		return this.bpfCheckDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  验收时间
	 */
	public void setBpfCheckDate(java.util.Date bpfCheckDate){
		this.bpfCheckDate = bpfCheckDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  验收结果
	 */
	
	@Column(name ="BPF_CHECK_RESULT",nullable=true,length=32)
	public java.lang.String getBpfCheckResult(){
		return this.bpfCheckResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  验收结果
	 */
	public void setBpfCheckResult(java.lang.String bpfCheckResult){
		this.bpfCheckResult = bpfCheckResult;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目管理外键
	 */
	
	@Column(name ="FROM_ID",nullable=true,length=32)
	public java.lang.String getFromId(){
		return this.fromId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目管理外键
	 */
	public void setFromId(java.lang.String fromId){
		this.fromId = fromId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  序号
	 */
	
	@Column(name ="XH",nullable=true,length=32)
	public java.lang.String getXh(){
		return this.xh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  序号
	 */
	public void setXh(java.lang.String xh){
		this.xh = xh;
	}
	
}
