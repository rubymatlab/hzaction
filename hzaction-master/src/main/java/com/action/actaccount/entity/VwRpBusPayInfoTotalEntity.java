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
 * @Description: 出纳日记账报表
 * @author onlineGenerator
 * @date 2019-09-26 23:49:29
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_rp_bus_pay_info_total", schema = "")
@SuppressWarnings("serial")
public class VwRpBusPayInfoTotalEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**支付时间*/
	@Excel(name="支付时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bpiPayDate;
	/**凭证号*/
	@Excel(name="凭证号",width=15)
	private java.lang.String bpiVoucherno;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpmName;
	/**账号简称*/
	@Excel(name="账号简称",width=15)
	private java.lang.String bbaiSname;
	/**费用类别*/
	@Excel(name="费用类别",width=15,dicCode="cost_type")
	private java.lang.String bpiFeeType;
	/**费用明细*/
	@Excel(name="费用明细",width=15,dicCode="bc_fee_dtl")
	private java.lang.String bpiFeeDetail;
	/**内容*/
	@Excel(name="内容",width=15,dicCode="bus_pa_con")
	private java.lang.String bpiContent;
	/**报销人*/
	@Excel(name="报销人",width=15)
	private java.lang.String bsSubmiter;
	/**供应商名称*/
	@Excel(name="供应商名称",width=15)
	private java.lang.String bsName;
	/**收款单位*/
	private java.lang.String bsspRecCompany;
	/**收款单位*/
	@Excel(name="收款单位",width=15)
	private java.lang.String recCompany;
	/**收款金额_贷方*/
	@Excel(name="收款金额_贷方",width=15)
	private java.lang.String lenderAmount;
	/**报销金额_借方*/
	@Excel(name="报销金额_借方",width=15)
	private java.lang.Double submitAmount;
	/**采购付款金额_借方*/
	@Excel(name="采购付款金额_借方",width=15)
	private java.lang.Double poPayAmount;
	/**付款金额_借方*/
	@Excel(name="付款金额_借方",width=15)
	private java.lang.Double bsspPayAmount;
	/**借方*/
	@Excel(name="借方",width=15)
	private java.lang.Double debtorAmount;
	/**期初余额*/
	@Excel(name="期初余额",width=15)
	private java.lang.Double bbaiIniBalance;
	
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  支付时间
	 */

	@Column(name ="BPI_PAY_DATE",nullable=true)
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
	 *@return: java.lang.String  账号简称
	 */

	@Column(name ="BBAI_SNAME",nullable=true,length=32)
	public java.lang.String getBbaiSname(){
		return this.bbaiSname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账号简称
	 */
	public void setBbaiSname(java.lang.String bbaiSname){
		this.bbaiSname = bbaiSname;
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
	 *@return: java.lang.String  报销人
	 */

	@Column(name ="BS_SUBMITER",nullable=true,length=30)
	public java.lang.String getBsSubmiter(){
		return this.bsSubmiter;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报销人
	 */
	public void setBsSubmiter(java.lang.String bsSubmiter){
		this.bsSubmiter = bsSubmiter;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商名称
	 */

	@Column(name ="BS_NAME",nullable=true,length=100)
	public java.lang.String getBsName(){
		return this.bsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商名称
	 */
	public void setBsName(java.lang.String bsName){
		this.bsName = bsName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款单位
	 */

	@Column(name ="BSSP_REC_COMPANY",nullable=true,length=100)
	public java.lang.String getBsspRecCompany(){
		return this.bsspRecCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款单位
	 */
	public void setBsspRecCompany(java.lang.String bsspRecCompany){
		this.bsspRecCompany = bsspRecCompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款单位
	 */

	@Column(name ="REC_COMPANY",nullable=false,length=100)
	public java.lang.String getRecCompany(){
		return this.recCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款单位
	 */
	public void setRecCompany(java.lang.String recCompany){
		this.recCompany = recCompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款金额_贷方
	 */

	@Column(name ="LENDER_AMOUNT",nullable=true,length=32)
	public java.lang.String getLenderAmount(){
		return this.lenderAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款金额_贷方
	 */
	public void setLenderAmount(java.lang.String lenderAmount){
		this.lenderAmount = lenderAmount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  报销金额_借方
	 */

	@Column(name ="SUBMIT_AMOUNT",nullable=true,scale=2,length=19)
	public java.lang.Double getSubmitAmount(){
		return this.submitAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  报销金额_借方
	 */
	public void setSubmitAmount(java.lang.Double submitAmount){
		this.submitAmount = submitAmount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  采购付款金额_借方
	 */

	@Column(name ="PO_PAY_AMOUNT",nullable=true,length=23)
	public java.lang.Double getPoPayAmount(){
		return this.poPayAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  采购付款金额_借方
	 */
	public void setPoPayAmount(java.lang.Double poPayAmount){
		this.poPayAmount = poPayAmount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  付款金额_借方
	 */

	@Column(name ="BSSP_PAY_AMOUNT",nullable=true,scale=2,length=12)
	public java.lang.Double getBsspPayAmount(){
		return this.bsspPayAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  付款金额_借方
	 */
	public void setBsspPayAmount(java.lang.Double bsspPayAmount){
		this.bsspPayAmount = bsspPayAmount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  借方
	 */

	@Column(name ="DEBTOR_AMOUNT",nullable=true,length=23)
	public java.lang.Double getDebtorAmount(){
		return this.debtorAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  借方
	 */
	public void setDebtorAmount(java.lang.Double debtorAmount){
		this.debtorAmount = debtorAmount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  期初余额
	 */

	@Column(name ="BBAI_INI_BALANCE",nullable=true,scale=3,length=12)
	public java.lang.Double getBbaiIniBalance(){
		return this.bbaiIniBalance;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  期初余额
	 */
	public void setBbaiIniBalance(java.lang.Double bbaiIniBalance){
		this.bbaiIniBalance = bbaiIniBalance;
	}
}
