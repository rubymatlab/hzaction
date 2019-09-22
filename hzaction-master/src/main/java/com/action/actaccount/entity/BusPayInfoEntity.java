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
 * @Description: 支付信息
 * @author onlineGenerator
 * @date 2019-09-22 16:05:41
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_pay_info", schema = "")
@SuppressWarnings("serial")
public class BusPayInfoEntity implements java.io.Serializable {
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
	/**功能分类*/
	@Excel(name="功能分类",width=15)
	private java.lang.String bpiClass;
	/**业务外键*/
	private java.lang.String bpiBusId;
	/**支付方式*/
	@Excel(name="支付方式",width=15)
	private java.lang.String bpiPayMethod;
	/**支付时间*/
	@Excel(name="支付时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpiPayDate;
	/**费用类别*/
	@Excel(name="费用类别",width=15,dicCode="cost_type")
	private java.lang.String bpiFeeType;
	/**费用明细*/
	@Excel(name="费用明细",width=15)
	private java.lang.String bpiFeeDetail;
	/**内容*/
	@Excel(name="内容",width=15)
	private java.lang.String bpiContent;
	/**凭证号*/
	@Excel(name="凭证号",width=15)
	private java.lang.String bpiVoucherno;
	/**项目管理外键*/
	@Excel(name="项目管理外键",width=15)
	private java.lang.String fromProjmId;
	/**采购付款单外键*/
	@Excel(name="采购付款单外键",width=15)
	private java.lang.String fromPayId;
	/**银行账号信息外键*/
	@Excel(name="银行账号信息外键",width=15)
	private java.lang.String fromBankAccId;
	/**费用报销外键*/
	@Excel(name="费用报销外键",width=15)
	private java.lang.String fromId;
	/**帐号简称*/
	@Excel(name="帐号简称",width=15)
	private java.lang.String bbaiSname;
	
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
	 *@return: java.lang.String  功能分类
	 */
	
	@Column(name ="BPI_CLASS",nullable=true,length=30)
	public java.lang.String getBpiClass(){
		return this.bpiClass;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  功能分类
	 */
	public void setBpiClass(java.lang.String bpiClass){
		this.bpiClass = bpiClass;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务外键
	 */
	
	@Column(name ="BPI_BUS_ID",nullable=true,length=32)
	public java.lang.String getBpiBusId(){
		return this.bpiBusId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务外键
	 */
	public void setBpiBusId(java.lang.String bpiBusId){
		this.bpiBusId = bpiBusId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付方式
	 */
	
	@Column(name ="BPI_PAY_METHOD",nullable=true,length=20)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  支付时间
	 */
	
	@Column(name ="BPI_PAY_DATE",nullable=true,length=32)
	public java.util.Date getBpiPayDate(){
		return this.bpiPayDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  支付时间
	 */
	public void setBpiPayDate(java.util.Date bpiPayDate){
		this.bpiPayDate = bpiPayDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用类别
	 */
	
	@Column(name ="BPI_FEE_TYPE",nullable=true,length=20)
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
	
	@Column(name ="BPI_FEE_DETAIL",nullable=true,length=20)
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
	 *@return: java.lang.String  内容
	 */
	
	@Column(name ="BPI_CONTENT",nullable=true,length=20)
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
	
	@Column(name ="BPI_VOUCHERNO",nullable=true,length=20)
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
	 *@return: java.lang.String  采购付款单外键
	 */
	
	@Column(name ="FROM_PAY_ID",nullable=true,length=32)
	public java.lang.String getFromPayId(){
		return this.fromPayId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购付款单外键
	 */
	public void setFromPayId(java.lang.String fromPayId){
		this.fromPayId = fromPayId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  银行账号信息外键
	 */
	
	@Column(name ="FROM_BANK_ACC_ID",nullable=true,length=32)
	public java.lang.String getFromBankAccId(){
		return this.fromBankAccId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  银行账号信息外键
	 */
	public void setFromBankAccId(java.lang.String fromBankAccId){
		this.fromBankAccId = fromBankAccId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用报销外键
	 */
	
	@Column(name ="FROM_ID",nullable=true,length=32)
	public java.lang.String getFromId(){
		return this.fromId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用报销外键
	 */
	public void setFromId(java.lang.String fromId){
		this.fromId = fromId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  帐号简称
	 */
	
	@Column(name ="BBAI_SNAME",nullable=true,length=32)
	public java.lang.String getBbaiSname(){
		return this.bbaiSname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  帐号简称
	 */
	public void setBbaiSname(java.lang.String bbaiSname){
		this.bbaiSname = bbaiSname;
	}
	
}
