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
 * @Description: 项目管理视图
 * @author onlineGenerator
 * @date 2019-07-26 20:14:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vm_bus_project_manager", schema = "")
@SuppressWarnings("serial")
public class VmBusProjectManagerEntity implements java.io.Serializable {
	/**id*/
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
	@Excel(name="流程状态",width=15,dicCode="state")
	private java.lang.String bpmStatus;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpmProjId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpmProjName;
	/**客户名称*/
	@Excel(name="客户名称",width=15)
	private java.lang.String bpmCustName;
	/**项目经理*/
	private java.lang.String bpmManager;
	/**应收总金额*/
	private java.lang.String bpmReceAllAmou;
	/**已收总金额*/
	private java.lang.String bpmReceAllAmouD;
	/**项目进度*/
	@Excel(name="项目进度",width=15,dicCode="proj_prog")
	private java.lang.String bpmProjProg;
	/**进度百分比*/
	@Excel(name="进度百分比",width=15,dicCode="proj_per")
	private java.lang.String bpmProgPer;
	/**验收结果*/
	@Excel(name="验收结果",width=15,dicCode="check_res")
	private java.lang.String bpmCheckRes;
	/**验收时间*/
	private java.util.Date bpmCheckDate;
	/**施工问题*/
	private java.lang.String bpmQues;
	/**下一步计划*/
	private java.lang.String bpmNextPlan;
	/**项目立项外键*/
	private java.lang.String fromProjId;
	/**客户资料外键*/
	private java.lang.String fromCustId;
	/**立项时间*/
	private java.util.Date bpmCreDate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
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
	
	@Column(name ="BPM_PROJ_NAME",nullable=true,length=32)
	public java.lang.String getBpmProjName(){
		return this.bpmProjName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setBpmProjName(java.lang.String bpmProjName){
		this.bpmProjName = bpmProjName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	
	@Column(name ="BPM_CUST_NAME",nullable=true,length=32)
	public java.lang.String getBpmCustName(){
		return this.bpmCustName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setBpmCustName(java.lang.String bpmCustName){
		this.bpmCustName = bpmCustName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目经理
	 */
	
	@Column(name ="BPM_MANAGER",nullable=true,length=32)
	public java.lang.String getBpmManager(){
		return this.bpmManager;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目经理
	 */
	public void setBpmManager(java.lang.String bpmManager){
		this.bpmManager = bpmManager;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应收总金额
	 */
	
	@Column(name ="BPM_RECE_ALL_AMOU",nullable=true,length=32)
	public java.lang.String getBpmReceAllAmou(){
		return this.bpmReceAllAmou;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应收总金额
	 */
	public void setBpmReceAllAmou(java.lang.String bpmReceAllAmou){
		this.bpmReceAllAmou = bpmReceAllAmou;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  已收总金额
	 */
	
	@Column(name ="BPM_RECE_ALL_AMOU_D",nullable=true,length=32)
	public java.lang.String getBpmReceAllAmouD(){
		return this.bpmReceAllAmouD;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  已收总金额
	 */
	public void setBpmReceAllAmouD(java.lang.String bpmReceAllAmouD){
		this.bpmReceAllAmouD = bpmReceAllAmouD;
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
	 *@return: java.lang.String  验收结果
	 */
	
	@Column(name ="BPM_CHECK_RES",nullable=true,length=32)
	public java.lang.String getBpmCheckRes(){
		return this.bpmCheckRes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  验收结果
	 */
	public void setBpmCheckRes(java.lang.String bpmCheckRes){
		this.bpmCheckRes = bpmCheckRes;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  验收时间
	 */
	
	@Column(name ="BPM_CHECK_DATE",nullable=true)
	public java.util.Date getBpmCheckDate(){
		return this.bpmCheckDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  验收时间
	 */
	public void setBpmCheckDate(java.util.Date bpmCheckDate){
		this.bpmCheckDate = bpmCheckDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  施工问题
	 */
	
	@Column(name ="BPM_QUES",nullable=true,length=32)
	public java.lang.String getBpmQues(){
		return this.bpmQues;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  施工问题
	 */
	public void setBpmQues(java.lang.String bpmQues){
		this.bpmQues = bpmQues;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下一步计划
	 */
	
	@Column(name ="BPM_NEXT_PLAN",nullable=true,length=32)
	public java.lang.String getBpmNextPlan(){
		return this.bpmNextPlan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下一步计划
	 */
	public void setBpmNextPlan(java.lang.String bpmNextPlan){
		this.bpmNextPlan = bpmNextPlan;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  立项时间
	 */
	
	@Column(name ="BPM_CRE_DATE",nullable=true)
	public java.util.Date getBpmCreDate(){
		return this.bpmCreDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  立项时间
	 */
	public void setBpmCreDate(java.util.Date bpmCreDate){
		this.bpmCreDate = bpmCreDate;
	}
	
}
