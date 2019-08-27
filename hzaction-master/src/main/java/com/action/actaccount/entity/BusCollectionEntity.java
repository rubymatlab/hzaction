package com.action.actaccount.entity;

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
 * @Description: 项目收款单
 * @author onlineGenerator
 * @date 2019-08-21 15:17:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_collection", schema = "")
@SuppressWarnings("serial")
public class BusCollectionEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	@Excel(name="创建人登录名称",width=15)
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
	/**收款单号*/
	@Excel(name="收款单号",width=15)
	private java.lang.String bcCollectId;
	/**进度款分期*/
	@Excel(name="进度款分期",width=15)
	private java.lang.String bcProgressStages;
	/**开票税率*/
	@Excel(name="开票税率",width=15)
	private java.lang.String bcTaxPer;
	/**开票时间*/
	@Excel(name="开票时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bcInvoiceDate;
	/**开票金额*/
	@Excel(name="开票金额",width=15)
	private java.lang.String bcInvAmount;
	/**收款金额*/
	@Excel(name="收款金额",width=15)
	private java.lang.String bcColAmount;
	/**收款时间*/
	@Excel(name="收款时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bcColDate;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String bcRemark;
	/**项目管理外键*/
	private java.lang.String fromProjmId;
	/**客户资料外键*/
	private java.lang.String fromCustId;
	/**合同管理外键*/
	private java.lang.String fromContId;
	/**文件*/
	@Excel(name="文件",width=15)
	private java.lang.String bcFile;
	/**回款状态*/
	@Excel(name="回款状态",width=15)
	private java.lang.String bcColState;
	/**审核状态*/
	@Excel(name="审核状态",width=15)
	private java.lang.String bcState;
	
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
	 *@return: java.lang.String  收款单号
	 */

	@Column(name ="BC_COLLECT_ID",nullable=true,length=32)
	public java.lang.String getBcCollectId(){
		return this.bcCollectId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款单号
	 */
	public void setBcCollectId(java.lang.String bcCollectId){
		this.bcCollectId = bcCollectId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  进度款分期
	 */

	@Column(name ="BC_PROGRESS_STAGES",nullable=true,length=32)
	public java.lang.String getBcProgressStages(){
		return this.bcProgressStages;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进度款分期
	 */
	public void setBcProgressStages(java.lang.String bcProgressStages){
		this.bcProgressStages = bcProgressStages;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开票税率
	 */

	@Column(name ="BC_TAX_PER",nullable=true,length=32)
	public java.lang.String getBcTaxPer(){
		return this.bcTaxPer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开票税率
	 */
	public void setBcTaxPer(java.lang.String bcTaxPer){
		this.bcTaxPer = bcTaxPer;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开票时间
	 */

	@Column(name ="BC_INVOICE_DATE",nullable=true,length=32)
	public java.util.Date getBcInvoiceDate(){
		return this.bcInvoiceDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开票时间
	 */
	public void setBcInvoiceDate(java.util.Date bcInvoiceDate){
		this.bcInvoiceDate = bcInvoiceDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开票金额
	 */

	@Column(name ="BC_INV_AMOUNT",nullable=true,length=32)
	public java.lang.String getBcInvAmount(){
		return this.bcInvAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开票金额
	 */
	public void setBcInvAmount(java.lang.String bcInvAmount){
		this.bcInvAmount = bcInvAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款金额
	 */

	@Column(name ="BC_COL_AMOUNT",nullable=true,length=32)
	public java.lang.String getBcColAmount(){
		return this.bcColAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款金额
	 */
	public void setBcColAmount(java.lang.String bcColAmount){
		this.bcColAmount = bcColAmount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收款时间
	 */

	@Column(name ="BC_COL_DATE",nullable=true,length=32)
	public java.util.Date getBcColDate(){
		return this.bcColDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收款时间
	 */
	public void setBcColDate(java.util.Date bcColDate){
		this.bcColDate = bcColDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="BC_REMARK",nullable=true,length=32)
	public java.lang.String getBcRemark(){
		return this.bcRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBcRemark(java.lang.String bcRemark){
		this.bcRemark = bcRemark;
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
	 *@return: java.lang.String  合同管理外键
	 */

	@Column(name ="FROM_CONT_ID",nullable=true,length=32)
	public java.lang.String getFromContId(){
		return this.fromContId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同管理外键
	 */
	public void setFromContId(java.lang.String fromContId){
		this.fromContId = fromContId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件
	 */

	@Column(name ="BC_FILE",nullable=true,length=32)
	public java.lang.String getBcFile(){
		return this.bcFile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件
	 */
	public void setBcFile(java.lang.String bcFile){
		this.bcFile = bcFile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  回款状态
	 */

	@Column(name ="BC_COL_STATE",nullable=true,length=32)
	public java.lang.String getBcColState(){
		return this.bcColState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回款状态
	 */
	public void setBcColState(java.lang.String bcColState){
		this.bcColState = bcColState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核状态
	 */

	@Column(name ="BC_STATE",nullable=true,length=32)
	public java.lang.String getBcState(){
		return this.bcState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核状态
	 */
	public void setBcState(java.lang.String bcState){
		this.bcState = bcState;
	}
}
