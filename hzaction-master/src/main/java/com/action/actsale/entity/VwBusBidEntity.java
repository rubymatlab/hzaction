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
 * @Description: 报价_投标审核
 * @author onlineGenerator
 * @date 2019-08-29 16:56:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_bus_bid", schema = "")
@SuppressWarnings("serial")
public class VwBusBidEntity implements java.io.Serializable {
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
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpProjId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpProjName;
	/**立项时间*/
	private java.util.Date bpDate;
	/**客户编号*/
	private java.lang.String bcId;
	/**客户名称*/
	@Excel(name="客户名称",width=15,dictTable ="bas_customer",dicCode ="bc_name",dicText ="bc_name")
	private java.lang.String bcName;
	/**客户简称*/
	private java.lang.String bcSname;
	/**拟中标方*/
	@Excel(name="拟中标方",width=15)
	private java.lang.String bdWinBidder;
	/**项目类型*/
	@Excel(name="项目类型",width=15,dicCode="bp_type1")
	private java.lang.String bdProjType;
	/**主标人员*/
	@Excel(name="主标人员",width=15)
	private java.lang.String bdMainBidder;
	/**配合人员*/
	@Excel(name="配合人员",width=15)
	private java.lang.String bdCoordinator;
	/**商务负责人*/
	@Excel(name="商务负责人",width=15)
	private java.lang.String bdBusinessCharge;
	/**辅助人员*/
	@Excel(name="辅助人员",width=15)
	private java.lang.String bdAuxiliaryStaff;
	/**投标预算*/
	@Excel(name="投标预算",width=15)
	private java.lang.Double bdBidAmout;
	/**投标日期*/
	@Excel(name="投标日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date bdBidDate;
	/**投标内容*/
	@Excel(name="投标内容",width=15)
	private java.lang.String bdBidContent;
	/**审核状态*/
	@Excel(name="审核状态",width=15,dicCode="state")
	private java.lang.String bdState;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String bdBidRemark;
	/**项目立项外键*/
	private java.lang.String fromProjId;
	/**客户资料外键*/
	private java.lang.String fromCustjId;
	/**附件*/
	//@Excel(name="附件",width=15)
	private java.lang.String bdFile;
	/**项目成本*/
	@Excel(name="项目成本",width=15)
	private java.lang.String bdProjCost;
	
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

	@Column(name ="BP_DATE",nullable=true,length=500)
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
	 *@return: java.lang.String  客户简称
	 */

	@Column(name ="BC_SNAME",nullable=true,length=20)
	public java.lang.String getBcSname(){
		return this.bcSname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户简称
	 */
	public void setBcSname(java.lang.String bcSname){
		this.bcSname = bcSname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  拟中标方
	 */

	@Column(name ="BD_WIN_BIDDER",nullable=true,length=40)
	public java.lang.String getBdWinBidder(){
		return this.bdWinBidder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  拟中标方
	 */
	public void setBdWinBidder(java.lang.String bdWinBidder){
		this.bdWinBidder = bdWinBidder;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目类型
	 */

	@Column(name ="BD_PROJ_TYPE",nullable=true,length=20)
	public java.lang.String getBdProjType(){
		return this.bdProjType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目类型
	 */
	public void setBdProjType(java.lang.String bdProjType){
		this.bdProjType = bdProjType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主标人员
	 */

	@Column(name ="BD_MAIN_BIDDER",nullable=true,length=100)
	public java.lang.String getBdMainBidder(){
		return this.bdMainBidder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主标人员
	 */
	public void setBdMainBidder(java.lang.String bdMainBidder){
		this.bdMainBidder = bdMainBidder;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  配合人员
	 */

	@Column(name ="BD_COORDINATOR",nullable=true,length=100)
	public java.lang.String getBdCoordinator(){
		return this.bdCoordinator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配合人员
	 */
	public void setBdCoordinator(java.lang.String bdCoordinator){
		this.bdCoordinator = bdCoordinator;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商务负责人
	 */

	@Column(name ="BD_BUSINESS_CHARGE",nullable=true,length=100)
	public java.lang.String getBdBusinessCharge(){
		return this.bdBusinessCharge;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商务负责人
	 */
	public void setBdBusinessCharge(java.lang.String bdBusinessCharge){
		this.bdBusinessCharge = bdBusinessCharge;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  辅助人员
	 */

	@Column(name ="BD_AUXILIARY_STAFF",nullable=true,length=100)
	public java.lang.String getBdAuxiliaryStaff(){
		return this.bdAuxiliaryStaff;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  辅助人员
	 */
	public void setBdAuxiliaryStaff(java.lang.String bdAuxiliaryStaff){
		this.bdAuxiliaryStaff = bdAuxiliaryStaff;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  投标金额
	 */

	@Column(name ="BD_BID_AMOUT",nullable=true,scale=2,length=12)
	public java.lang.Double getBdBidAmout(){
		return this.bdBidAmout;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  投标金额
	 */
	public void setBdBidAmout(java.lang.Double bdBidAmout){
		this.bdBidAmout = bdBidAmout;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  投标日期
	 */

	@Column(name ="BD_BID_DATE",nullable=true,length=32)
	public java.util.Date getBdBidDate(){
		return this.bdBidDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  投标日期
	 */
	public void setBdBidDate(java.util.Date bdBidDate){
		this.bdBidDate = bdBidDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投标内容
	 */

	@Column(name ="BD_BID_CONTENT",nullable=true,length=500)
	public java.lang.String getBdBidContent(){
		return this.bdBidContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投标内容
	 */
	public void setBdBidContent(java.lang.String bdBidContent){
		this.bdBidContent = bdBidContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核状态
	 */

	@Column(name ="BD_STATE",nullable=true,length=20)
	public java.lang.String getBdState(){
		return this.bdState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核状态
	 */
	public void setBdState(java.lang.String bdState){
		this.bdState = bdState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="BD_BID_REMARK",nullable=true,length=500)
	public java.lang.String getBdBidRemark(){
		return this.bdBidRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBdBidRemark(java.lang.String bdBidRemark){
		this.bdBidRemark = bdBidRemark;
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

	@Column(name ="FROM_CUSTJ_ID",nullable=true,length=32)
	public java.lang.String getFromCustjId(){
		return this.fromCustjId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户资料外键
	 */
	public void setFromCustjId(java.lang.String fromCustjId){
		this.fromCustjId = fromCustjId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件
	 */

	@Column(name ="BD_FILE",nullable=true,length=500)
	public java.lang.String getBdFile(){
		return this.bdFile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setBdFile(java.lang.String bdFile){
		this.bdFile = bdFile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目成本
	 */

	@Column(name ="BD_PROJ_COST",nullable=true,length=32)
	public java.lang.String getBdProjCost(){
		return this.bdProjCost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目成本
	 */
	public void setBdProjCost(java.lang.String bdProjCost){
		this.bdProjCost = bdProjCost;
	}
}
