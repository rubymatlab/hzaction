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
 * @Description: 采购申请视图
 * @author onlineGenerator
 * @date 2019-08-10 15:43:49
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_bus_po_apply", schema = "")
@SuppressWarnings("serial")
public class VwBusPoApplyEntity implements java.io.Serializable {
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
	/**采购申请编号*/
	@Excel(name="采购申请编号",width=15)
	private java.lang.String bpaApplyNo;
	/**申请日期*/
	@Excel(name="申请日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpaApplyDate;
	/**收货人*/
	@Excel(name="收货人",width=15)
	private java.lang.String bpaRecPeople;
	/**收货人电话*/
	@Excel(name="收货人电话",width=15)
	private java.lang.String bpaRecTel;
	/**收货地址*/
	@Excel(name="收货地址",width=15)
	private java.lang.String bpaRecAddr;
	/**申请人*/
	@Excel(name="申请人",width=15)
	private java.lang.String bpaApplyPeople;
	/**单据状态*/
	@Excel(name="单据状态",width=15)
	private java.lang.String bpaState;
	/**项目管理外键*/
	@Excel(name="项目管理外键",width=15)
	private java.lang.String fromProjmId;

	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpmName;
	/**客户名称*/
	@Excel(name="客户名称",width=15)
	private java.lang.String bcName;
	/**项目经理*/
	@Excel(name="项目经理",width=15)
	private java.lang.String bpManager;
	/**是否采购*/
	@Excel(name="是否采购",width=15)
	private java.lang.String purchaseOrNot;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpProjId;
	/**项目管理id*/
	@Excel(name="项目管理id",width=15)
	private java.lang.String busProjectManagerId;
	/**采购申请附件*/
	@Excel(name="采购申请附件",width=15)
	private java.lang.String bpaFile;
	
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
	 *@return: java.lang.String  采购申请编号
	 */
	
	@Column(name ="BPA_APPLY_NO",nullable=true,length=40)
	public java.lang.String getBpaApplyNo(){
		return this.bpaApplyNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购申请编号
	 */
	public void setBpaApplyNo(java.lang.String bpaApplyNo){
		this.bpaApplyNo = bpaApplyNo;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请日期
	 */
	
	@Column(name ="BPA_APPLY_DATE",nullable=true,length=32)
	public java.util.Date getBpaApplyDate(){
		return this.bpaApplyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请日期
	 */
	public void setBpaApplyDate(java.util.Date bpaApplyDate){
		this.bpaApplyDate = bpaApplyDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货人
	 */
	
	@Column(name ="BPA_REC_PEOPLE",nullable=true,length=40)
	public java.lang.String getBpaRecPeople(){
		return this.bpaRecPeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货人
	 */
	public void setBpaRecPeople(java.lang.String bpaRecPeople){
		this.bpaRecPeople = bpaRecPeople;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货人电话
	 */
	
	@Column(name ="BPA_REC_TEL",nullable=true,length=40)
	public java.lang.String getBpaRecTel(){
		return this.bpaRecTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货人电话
	 */
	public void setBpaRecTel(java.lang.String bpaRecTel){
		this.bpaRecTel = bpaRecTel;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货地址
	 */
	
	@Column(name ="BPA_REC_ADDR",nullable=true,length=200)
	public java.lang.String getBpaRecAddr(){
		return this.bpaRecAddr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货地址
	 */
	public void setBpaRecAddr(java.lang.String bpaRecAddr){
		this.bpaRecAddr = bpaRecAddr;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请人
	 */
	
	@Column(name ="BPA_APPLY_PEOPLE",nullable=true,length=40)
	public java.lang.String getBpaApplyPeople(){
		return this.bpaApplyPeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人
	 */
	public void setBpaApplyPeople(java.lang.String bpaApplyPeople){
		this.bpaApplyPeople = bpaApplyPeople;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单据状态
	 */
	
	@Column(name ="BPA_STATE",nullable=true,length=20)
	public java.lang.String getBpaState(){
		return this.bpaState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单据状态
	 */
	public void setBpaState(java.lang.String bpaState){
		this.bpaState = bpaState;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目管理外键
	 */
	
	@Column(name ="FROM_PROJM_ID",nullable=true,length=32)
	public java.lang.String getFromProjmId(){
		return this.fromProjmId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目管理外键
	 */
	public void setFromProjmId(java.lang.String fromProjmId){
		this.fromProjmId = fromProjmId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	
	@Column(name ="BPM_NAME",nullable=true,length=200)
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
	 *@return: java.lang.String  是否采购
	 */
	
	@Column(name ="PURCHASE_OR_NOT",nullable=true,length=32)
	public java.lang.String getPurchaseOrNot(){
		return this.purchaseOrNot;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否采购
	 */
	public void setPurchaseOrNot(java.lang.String purchaseOrNot){
		this.purchaseOrNot = purchaseOrNot;
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
	 *@return: java.lang.String  项目管理id
	 */
	
	@Column(name ="BUS_PROJECT_MANAGER_ID",nullable=true,length=32)
	public java.lang.String getBusProjectManagerId(){
		return this.busProjectManagerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目管理id
	 */
	public void setBusProjectManagerId(java.lang.String busProjectManagerId){
		this.busProjectManagerId = busProjectManagerId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购申请附件
	 */
	
	@Column(name ="BPA_FILE",nullable=true,length=32)
	public java.lang.String getBpaFile(){
		return this.bpaFile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购申请附件
	 */
	public void setBpaFile(java.lang.String bpaFile){
		this.bpaFile = bpaFile;
	}
	
}
