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
 * @Description: 项目收款单视图
 * @author onlineGenerator
 * @date 2019-08-22 15:34:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_bus_collection", schema = "")
@SuppressWarnings("serial")
public class VwBusCollectionEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpmName;
	/**项目名称*/
	@Excel(name="预计回款时间",width=15)
	private java.util.Date brpExtBackDate;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpmProjId;
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
	@Excel(name="开票税率",width=15,dicCode="bc_tax_pe")
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
	/**客户资料外键*/
	private java.lang.String fromCustId;
	/**项目管理外键*/
	private java.lang.String fromProjmId;
	/**合同管理外键*/
	private java.lang.String fromContId;
	/**文件*/
	@Excel(name="文件",width=15)
	private java.lang.String bcFile;
	/**回款状态*/
	@Excel(name="回款状态",width=15,dicCode="bc_back")
	private java.lang.String bcColState;
	/**回款金额*/
	@Excel(name="回款金额",width=15)
	private java.lang.String brpBackAmount;
	/**客户*/
	@Excel(name="客户",width=15)
	private java.lang.String bcCustContractor;
	/**支付方式*/
	@Excel(name="支付方式",width=15,dicCode="bus_pa_way")
	private java.lang.String bpiPayMethod;
	/**银行帐号*/
	@Excel(name="银行帐号",width=15,dicCode="ba_acc_no")
	private java.lang.String bbaiAccountNo;
	/**费用类别*/
	@Excel(name="费用类别",width=15,dicCode="cost_type")
	private java.lang.String bpiFeeType;
	/**费用明细*/
	@Excel(name="费用明细",width=15,dicCode="bus_pa_way")
	private java.lang.String bpiFeeDetail;
	/**支付时间*/
	@Excel(name="支付时间",width=15)
	private java.util.Date bpiPayDate;
	/*银行卡外键*/
	private java.lang.String fromBankAccId;
	/**内容*/
	@Excel(name="内容",width=15,dicCode="bus_pa_way")
	private java.lang.String bpiContent;
	/**凭证号*/
	@Excel(name="凭证号",width=15)
	private java.lang.String bpiVoucherno;
	/**项目负责人*/
	@Excel(name="项目负责人",width=15)
	private java.lang.String bpKeyPeople;
	/**财务支付id*/
	private java.lang.String fromPayinfoId;
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
	 *@return: java.lang.String  项目编号
	 */

	@Column(name ="BPM_PROJ_ID",nullable=true,length=32)
	public java.lang.String getBpmProjId(){
		return this.bpmProjId;
	}
	@Column(name ="BRP_EXT_BACK_DATE",nullable=true,length=32)
	public java.util.Date getBrpExtBackDate(){
		return this.brpExtBackDate;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目编号
	 */
	public void setBpmProjId(java.lang.String bpmProjId){
		this.bpmProjId = bpmProjId;
	}
	
	public void setBrpExtBackDate(java.util.Date brpBackAmount){
	 this.brpExtBackDate = brpExtBackDate;
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
	 *@return: java.lang.String  合同管理外键
	 */

	@Column(name ="FROM_BANK_ACC_ID",nullable=true,length=32)
	public java.lang.String getFromBankAccId(){
		return this.fromBankAccId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同管理外键
	 */
	public void setFromBankAccId(java.lang.String fromBankAccId){
		this.fromBankAccId = fromBankAccId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件
	 */

	@Column(name ="BC_FILE",nullable=true,length=30)
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

	@Column(name ="BC_COL_STATE",nullable=true,length=30)
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
	 *@return: java.lang.String  回款金额
	 */

	@Column(name ="BRP_BACK_AMOUNT",nullable=true,length=32)
	public java.lang.String getBrpBackAmount(){
		return this.brpBackAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回款金额
	 */
	public void setBrpBackAmount(java.lang.String brpBackAmount){
		this.brpBackAmount = brpBackAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户
	 */

	@Column(name ="BC_CUST_CONTRACTOR",nullable=true,length=32)
	public java.lang.String getBcCustContractor(){
		return this.bcCustContractor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户
	 */
	public void setBcCustContractor(java.lang.String bcCustContractor){
		this.bcCustContractor = bcCustContractor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付方式
	 */

	@Column(name ="BPI_PAY_METHOD",nullable=true,length=32)
	public java.lang.String getBpiPayMethod(){
		return this.bpiPayMethod;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付方式
	 */
	public void setBpiPayMethod(java.lang.String bpiPayMethod){
		this.bpiPayMethod = bpiPayMethod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  银行帐号
	 */

	@Column(name ="BBAI_ACCOUNT_NO",nullable=true,length=32)
	public java.lang.String getBbaiAccountNo(){
		return this.bbaiAccountNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  银行帐号
	 */
	public void setBbaiAccountNo(java.lang.String bbaiAccountNo){
		this.bbaiAccountNo = bbaiAccountNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用类别
	 */

	@Column(name ="BPI_FEE_TYPE",nullable=true,length=32)
	public java.lang.String getBpiFeeType(){
		return this.bpiFeeType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用类别
	 */
	public void setBpiFeeType(java.lang.String bpiFeeType){
		this.bpiFeeType = bpiFeeType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用明细
	 */

	@Column(name ="BPI_FEE_DETAIL",nullable=true,length=32)
	public java.lang.String getBpiFeeDetail(){
		return this.bpiFeeDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用明细
	 */
	public void setBpiFeeDetail(java.lang.String bpiFeeDetail){
		this.bpiFeeDetail = bpiFeeDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付时间
	 */

	@Column(name ="BPI_PAY_DATE",nullable=true,length=32)
	public java.util.Date getBpiPayDate(){
		return this.bpiPayDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付时间
	 */
	public void setBpiPayDate(java.util.Date bpiPayDate){
		this.bpiPayDate = bpiPayDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */

	@Column(name ="BPI_CONTENT",nullable=true,length=32)
	public java.lang.String getBpiContent(){
		return this.bpiContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setBpiContent(java.lang.String bpiContent){
		this.bpiContent = bpiContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  凭证号
	 */

	@Column(name ="BPI_VOUCHERNO",nullable=true,length=32)
	public java.lang.String getBpiVoucherno(){
		return this.bpiVoucherno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  凭证号
	 */
	public void setBpiVoucherno(java.lang.String bpiVoucherno){
		this.bpiVoucherno = bpiVoucherno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目负责人
	 */

	@Column(name ="BP_KEY_PEOPLE",nullable=true,length=32)
	public java.lang.String getBpKeyPeople(){
		return this.bpKeyPeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目负责人
	 */
	public void setBpKeyPeople(java.lang.String bpKeyPeople){
		this.bpKeyPeople = bpKeyPeople;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="FROM_PAYINFO_ID",nullable=true,length=50)
	public java.lang.String getFromPayinfoId(){
		return this.fromPayinfoId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setFromPayinfoId(java.lang.String fromPayinfoId){
		this.fromPayinfoId = fromPayinfoId;
	}
}
