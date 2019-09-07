
package com.action.actaccount.page;
import com.action.actaccount.entity.VwRpCostAccountEntity;
import com.action.actaccount.entity.VwBusPoContractPayEntity;
import com.action.actaccount.entity.VwBusOthersProjPayEntity;
import com.action.actaccount.entity.VwBusOthersPayDetailEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

/**   
 * @Title: Entity
 * @Description: 项目整体结算表
 * @author onlineGenerator
 * @date 2019-09-02 18:55:26
 * @version V1.0   
 *
 */
public class VwRpCostAccountPage implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**项目编号*/
	@Excel(name="项目编号")
	private java.lang.String bpProjId;
	/**项目名称*/
	@Excel(name="项目名称")
	private java.lang.String bpProjName;
	/**项目经理*/
	@Excel(name="项目经理")
	private java.lang.String bpManager;
	/**立项时间*/
	@Excel(name="立项时间")
	private java.util.Date bpDate;
	/**客户名称*/
	@Excel(name="客户名称")
	private java.lang.String bcName;
	/**项目立项外键*/
	private java.lang.String fromProjId;
	/**合同管理外键*/
	private java.lang.String fromContractId;
	/**中标金额*/
	@Excel(name="中标金额")
	private java.lang.String bcContAmount;
	/**管理费*/
	@Excel(name="管理费")
	private java.lang.String projManAmount;
	/**中标服务费*/
	@Excel(name="中标服务费")
	private java.lang.String bcWinSfee;
	/**中标方*/
	@Excel(name="中标方")
	private java.lang.String bcWinBidder;
	/**合同金额*/
	@Excel(name="合同金额")
	private java.lang.String bcActionAmount;
	/**签定日期*/
	@Excel(name="签定日期")
	private java.util.Date bcConcludeTime;
	/**开票时间*/
	@Excel(name="开票时间")
	private java.util.Date maxBcInvoiceDate;
	/**开票金额*/
	@Excel(name="开票金额")
	private java.lang.String bcInvAmount;
	/**已开票待回款*/
	@Excel(name="已开票待回款")
	private java.lang.String invBackAmount;
	/**回款时间*/
	@Excel(name="回款时间")
	private java.util.Date maxBcColDate;
	/**回款总额*/
	@Excel(name="回款总额")
	private java.lang.String brpBackAmountD;
	/**应收金额*/
	@Excel(name="应收金额")
	private java.lang.String receivableAmount;
	/**未收占比*/
	@Excel(name="未收占比")
	private java.lang.String notReceivablePer;
	/**采购应付*/
	@Excel(name="采购应付")
	private java.lang.String poPayableTamount;
	/**采购已付*/
	@Excel(name="采购已付")
	private java.lang.String poPayTamount;
	/**采购未付*/
	@Excel(name="采购未付")
	private java.lang.String poNotPayTamount;
	/**其他支出*/
	@Excel(name="其他支付")
	private java.lang.String othersPayAmount;
	/**支出合计*/
	@Excel(name="支出合计")
	private java.lang.String projPayTotal;
	/**垫资金额*/
	@Excel(name="垫资金额")
	private java.lang.String padBranchAmount;
	/**资金成本*/
	@Excel(name="资金成本")
	private java.lang.String padBranchCost;
	/**现金毛利*/
	@Excel(name="现金毛利")
	private java.lang.String cashMarginAmount;
	/**应收毛利*/
	@Excel(name="应收毛利")
	private java.lang.String payableMarginAmount;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
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
	 *@return: java.lang.String  项目编号
	 */
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目经理
	 */
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  立项时间
	 */
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
	 *@return: java.lang.String  客户名称
	 */
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
	 *@return: java.lang.String  项目立项外键
	 */
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
	 *@return: java.lang.String  合同管理外键
	 */
	public java.lang.String getFromContractId(){
		return this.fromContractId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同管理外键
	 */
	public void setFromContractId(java.lang.String fromContractId){
		this.fromContractId = fromContractId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中标金额
	 */
	public java.lang.String getBcContAmount(){
		return this.bcContAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中标金额
	 */
	public void setBcContAmount(java.lang.String bcContAmount){
		this.bcContAmount = bcContAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管理费
	 */
	public java.lang.String getProjManAmount(){
		return this.projManAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理费
	 */
	public void setProjManAmount(java.lang.String projManAmount){
		this.projManAmount = projManAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中标服务费
	 */
	public java.lang.String getBcWinSfee(){
		return this.bcWinSfee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中标服务费
	 */
	public void setBcWinSfee(java.lang.String bcWinSfee){
		this.bcWinSfee = bcWinSfee;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中标方
	 */
	public java.lang.String getBcWinBidder(){
		return this.bcWinBidder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中标方
	 */
	public void setBcWinBidder(java.lang.String bcWinBidder){
		this.bcWinBidder = bcWinBidder;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同金额
	 */
	public java.lang.String getBcActionAmount(){
		return this.bcActionAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同金额
	 */
	public void setBcActionAmount(java.lang.String bcActionAmount){
		this.bcActionAmount = bcActionAmount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签定日期
	 */
	public java.util.Date getBcConcludeTime(){
		return this.bcConcludeTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  签定日期
	 */
	public void setBcConcludeTime(java.util.Date bcConcludeTime){
		this.bcConcludeTime = bcConcludeTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开票时间
	 */
	public java.util.Date getMaxBcInvoiceDate(){
		return this.maxBcInvoiceDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开票时间
	 */
	public void setMaxBcInvoiceDate(java.util.Date maxBcInvoiceDate){
		this.maxBcInvoiceDate = maxBcInvoiceDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开票金额
	 */
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
	 *@return: java.lang.String  已开票待回款
	 */
	public java.lang.String getInvBackAmount(){
		return this.invBackAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  已开票待回款
	 */
	public void setInvBackAmount(java.lang.String invBackAmount){
		this.invBackAmount = invBackAmount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  回款时间
	 */
	public java.util.Date getMaxBcColDate(){
		return this.maxBcColDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  回款时间
	 */
	public void setMaxBcColDate(java.util.Date maxBcColDate){
		this.maxBcColDate = maxBcColDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  回款总额
	 */
	public java.lang.String getBrpBackAmountD(){
		return this.brpBackAmountD;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回款总额
	 */
	public void setBrpBackAmountD(java.lang.String brpBackAmountD){
		this.brpBackAmountD = brpBackAmountD;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应收金额
	 */
	public java.lang.String getReceivableAmount(){
		return this.receivableAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应收金额
	 */
	public void setReceivableAmount(java.lang.String receivableAmount){
		this.receivableAmount = receivableAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  未收占比
	 */
	public java.lang.String getNotReceivablePer(){
		return this.notReceivablePer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  未收占比
	 */
	public void setNotReceivablePer(java.lang.String notReceivablePer){
		this.notReceivablePer = notReceivablePer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购应付
	 */
	public java.lang.String getPoPayableTamount(){
		return this.poPayableTamount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购应付
	 */
	public void setPoPayableTamount(java.lang.String poPayableTamount){
		this.poPayableTamount = poPayableTamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购已付
	 */
	public java.lang.String getPoPayTamount(){
		return this.poPayTamount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购已付
	 */
	public void setPoPayTamount(java.lang.String poPayTamount){
		this.poPayTamount = poPayTamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购未付
	 */
	public java.lang.String getPoNotPayTamount(){
		return this.poNotPayTamount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购未付
	 */
	public void setPoNotPayTamount(java.lang.String poNotPayTamount){
		this.poNotPayTamount = poNotPayTamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他支出
	 */
	public java.lang.String getOthersPayAmount(){
		return this.othersPayAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他支出
	 */
	public void setOthersPayAmount(java.lang.String othersPayAmount){
		this.othersPayAmount = othersPayAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支出合计
	 */
	public java.lang.String getProjPayTotal(){
		return this.projPayTotal;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支出合计
	 */
	public void setProjPayTotal(java.lang.String projPayTotal){
		this.projPayTotal = projPayTotal;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  垫资金额
	 */
	public java.lang.String getPadBranchAmount(){
		return this.padBranchAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  垫资金额
	 */
	public void setPadBranchAmount(java.lang.String padBranchAmount){
		this.padBranchAmount = padBranchAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  资金成本
	 */
	public java.lang.String getPadBranchCost(){
		return this.padBranchCost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  资金成本
	 */
	public void setPadBranchCost(java.lang.String padBranchCost){
		this.padBranchCost = padBranchCost;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现金毛利
	 */
	public java.lang.String getCashMarginAmount(){
		return this.cashMarginAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现金毛利
	 */
	public void setCashMarginAmount(java.lang.String cashMarginAmount){
		this.cashMarginAmount = cashMarginAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应收毛利
	 */
	public java.lang.String getPayableMarginAmount(){
		return this.payableMarginAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应收毛利
	 */
	public void setPayableMarginAmount(java.lang.String payableMarginAmount){
		this.payableMarginAmount = payableMarginAmount;
	}

	/**保存-采购应付/已付明细*/
    @ExcelCollection(name="采购应付/已付明细")
	private List<VwBusPoContractPayEntity> vwBusPoContractPayList = new ArrayList<VwBusPoContractPayEntity>();
		public List<VwBusPoContractPayEntity> getVwBusPoContractPayList() {
		return vwBusPoContractPayList;
		}
		public void setVwBusPoContractPayList(List<VwBusPoContractPayEntity> vwBusPoContractPayList) {
		this.vwBusPoContractPayList = vwBusPoContractPayList;
		}
	/**保存-其他支出汇总*/
    @ExcelCollection(name="其他支出汇总")
	private List<VwBusOthersProjPayEntity> vwBusOthersProjPayList = new ArrayList<VwBusOthersProjPayEntity>();
		public List<VwBusOthersProjPayEntity> getVwBusOthersProjPayList() {
		return vwBusOthersProjPayList;
		}
		public void setVwBusOthersProjPayList(List<VwBusOthersProjPayEntity> vwBusOthersProjPayList) {
		this.vwBusOthersProjPayList = vwBusOthersProjPayList;
		}
	/**保存-其他支出明细*/
    @ExcelCollection(name="其他支出明细")
	private List<VwBusOthersPayDetailEntity> vwBusOthersPayDetailList = new ArrayList<VwBusOthersPayDetailEntity>();
		public List<VwBusOthersPayDetailEntity> getVwBusOthersPayDetailList() {
		return vwBusOthersPayDetailList;
		}
		public void setVwBusOthersPayDetailList(List<VwBusOthersPayDetailEntity> vwBusOthersPayDetailList) {
		this.vwBusOthersPayDetailList = vwBusOthersPayDetailList;
		}
}
