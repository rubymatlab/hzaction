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
 * @Description: 项目立项
 * @author onlineGenerator
 * @date 2019-08-14 22:03:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_bus_project", schema = "")
@SuppressWarnings("serial")
public class VwBusProjectEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpProjId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpProjName;
	/**立项时间*/
	@Excel(name="立项时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpDate;
	/**项目关键人*/
	@Excel(name="项目关键人",width=15)
	private java.lang.String bpKeyPeople;
	/**项目预算*/
	@Excel(name="项目预算",width=15)
	private java.math.BigDecimal bpAmount;
	/**项目简介*/
	@Excel(name="项目简介",width=15)
	private java.lang.String bpIntroduction;
	/**问题or协助*/
	@Excel(name="问题or协助",width=15)
	private java.lang.String bpQuestions;
	/**项目情况*/
	@Excel(name="项目情况",width=15)
	private java.lang.String bpdFeedbackInto;
	/**产品解决方案*/
	@Excel(name="产品解决方案",width=15)
	private java.lang.String bpProSolutions;
	/**竞争情况*/
	@Excel(name="竞争情况",width=15)
	private java.lang.String bpCompetition;
	/**项目经理*/
	@Excel(name="项目经理",width=15)
	private java.lang.String bpManager;
	/**项目阶段*/
	@Excel(name="项目阶段",width=15,dicCode="bp_type")
	private java.lang.String bpTeam;
	/**方案输出时间*/
	@Excel(name="方案输出时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpOutTime;
	/**方案定稿时间*/
	@Excel(name="方案定稿时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpFinishTime;
	/**预计挂网时间*/
	@Excel(name="预计挂网时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpOnlineTime;
	/**跟进结果*/
	@Excel(name="跟进结果",width=15)
	private java.lang.String bpFollowResults;
	/**客户资料外键*/
	@Excel(name="客户资料外键",width=15)
	private java.lang.String fromCustId;
	/**客户编号*/
	@Excel(name="客户编号",width=15)
	private java.lang.String bcId;
	/**客户名称*/
	@Excel(name="客户名称",width=15)
	private java.lang.String bcName;
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
	
	@Column(name ="BP_PROJ_NAME",nullable=true,length=200)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  立项时间
	 */
	
	@Column(name ="BP_DATE",nullable=true)
	public java.util.Date getBpDate(){
		return this.bpDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  立项时间
	 */
	public void setBpDate(java.util.Date bpDate){
		this.bpDate = bpDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目关键人
	 */
	
	@Column(name ="BP_KEY_PEOPLE",nullable=true,length=20)
	public java.lang.String getBpKeyPeople(){
		return this.bpKeyPeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目关键人
	 */
	public void setBpKeyPeople(java.lang.String bpKeyPeople){
		this.bpKeyPeople = bpKeyPeople;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  项目预算
	 */

	@Column(name ="BP_AMOUNT",nullable=true,length=32)
	public java.math.BigDecimal getBpAmount(){
		return this.bpAmount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  项目预算
	 */
	public void setBpAmount(java.math.BigDecimal bpAmount){
		this.bpAmount = bpAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目简介
	 */
	
	@Column(name ="BP_INTRODUCTION",nullable=true,length=500)
	public java.lang.String getBpIntroduction(){
		return this.bpIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目简介
	 */
	public void setBpIntroduction(java.lang.String bpIntroduction){
		this.bpIntroduction = bpIntroduction;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  问题or协助
	 */
	
	@Column(name ="BP_QUESTIONS",nullable=true,length=500)
	public java.lang.String getBpQuestions(){
		return this.bpQuestions;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  问题or协助
	 */
	public void setBpQuestions(java.lang.String bpQuestions){
		this.bpQuestions = bpQuestions;
	}
	
	@Column(name ="BPD_FEEDBACK_INTO",nullable=true,length=3000)
	public java.lang.String getBpdFeedbackInto(){
		return this.bpdFeedbackInto;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目情况
	 */
	public void setBpdFeedbackInto(java.lang.String bpdFeedbackInto){
		this.bpdFeedbackInto = bpdFeedbackInto;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品解决方案
	 */
	
	@Column(name ="BP_PRO_SOLUTIONS",nullable=true,length=500)
	public java.lang.String getBpProSolutions(){
		return this.bpProSolutions;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品解决方案
	 */
	public void setBpProSolutions(java.lang.String bpProSolutions){
		this.bpProSolutions = bpProSolutions;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  竞争情况
	 */
	
	@Column(name ="BP_COMPETITION",nullable=true,length=500)
	public java.lang.String getBpCompetition(){
		return this.bpCompetition;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  竞争情况
	 */
	public void setBpCompetition(java.lang.String bpCompetition){
		this.bpCompetition = bpCompetition;
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
	 *@return: java.lang.String  项目阶段
	 */
	
	@Column(name ="BP_TEAM",nullable=true,length=200)
	public java.lang.String getBpTeam(){
		return this.bpTeam;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目阶段
	 */
	public void setBpTeam(java.lang.String bpTeam){
		this.bpTeam = bpTeam;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  方案输出时间
	 */
	
	@Column(name ="BP_OUT_TIME",nullable=true)
	public java.util.Date getBpOutTime(){
		return this.bpOutTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  方案输出时间
	 */
	public void setBpOutTime(java.util.Date bpOutTime){
		this.bpOutTime = bpOutTime;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  方案定稿时间
	 */
	
	@Column(name ="BP_FINISH_TIME",nullable=true)
	public java.util.Date getBpFinishTime(){
		return this.bpFinishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  方案定稿时间
	 */
	public void setBpFinishTime(java.util.Date bpFinishTime){
		this.bpFinishTime = bpFinishTime;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计挂网时间
	 */
	
	@Column(name ="BP_ONLINE_TIME",nullable=true)
	public java.util.Date getBpOnlineTime(){
		return this.bpOnlineTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计挂网时间
	 */
	public void setBpOnlineTime(java.util.Date bpOnlineTime){
		this.bpOnlineTime = bpOnlineTime;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  跟进结果
	 */
	
	@Column(name ="BP_FOLLOW_RESULTS",nullable=true,length=20)
	public java.lang.String getBpFollowResults(){
		return this.bpFollowResults;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  跟进结果
	 */
	public void setBpFollowResults(java.lang.String bpFollowResults){
		this.bpFollowResults = bpFollowResults;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户资料外键
	 */
	
	@Column(name ="FROM_CUST_ID",nullable=true,length=36)
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
	 *@return: java.lang.String  客户编号
	 */
	
	@Column(name ="BC_ID",nullable=true,length=20)
	public java.lang.String getBcId(){
		return this.bcId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编号
	 */
	public void setBcId(java.lang.String bcId){
		this.bcId = bcId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	
	@Column(name ="BC_NAME",nullable=true,length=100)
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
	
}
