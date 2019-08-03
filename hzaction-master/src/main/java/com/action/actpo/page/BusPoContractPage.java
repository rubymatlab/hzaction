
package com.action.actpo.page;
import com.action.actpo.entity.BusPoContractEntity;
import com.action.actpo.entity.BusPoContractPayEntity;
import com.action.actpo.entity.BusPoApplyDetailConEntity;
import com.action.actpo.entity.BusPoContractDetailEntity;

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
 * @Description: 采购合同
 * @author onlineGenerator
 * @date 2019-08-01 18:12:42
 * @version V1.0   
 *
 */
public class BusPoContractPage implements java.io.Serializable {
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
    @Excel(name="流程状态")
	private java.lang.String bpmStatus;
	/**采购合同编号*/
    @Excel(name="采购合同编号")
	private java.lang.String bpcPoNo;
	/**采购员*/
    @Excel(name="采购员")
	private java.lang.String bpcPoPeople;
	/**采购日期*/
    @Excel(name="采购日期",format = "yyyy-MM-dd")
	private java.util.Date bpcPoDate;
	/**预计付款日期*/
    @Excel(name="预计付款日期",format = "yyyy-MM-dd")
	private java.util.Date bpExpPayDate;
	/**采购是否已完成*/
    @Excel(name="采购是否已完成")
	private java.lang.String bpcPoOver;
	/**收货人*/
    @Excel(name="收货人")
	private java.lang.String bpcRecPeople;
	/**收货人电话*/
    @Excel(name="收货人电话")
	private java.lang.String bpcRecTel;
	/**收货地址*/
    @Excel(name="收货地址")
	private java.lang.String bpcRecAddr;
	/**采购情况汇报*/
    @Excel(name="采购情况汇报")
	private java.lang.String bpSitReport;
	/**项目管理外键*/
	private java.lang.String fromProjmId;
	/**供应商资料外键*/
	private java.lang.String fromSuppId;
	
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
	 *@return: java.lang.String  创建人名称
	 */
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
	 *@return: java.lang.String  采购合同编号
	 */
	public java.lang.String getBpcPoNo(){
		return this.bpcPoNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购合同编号
	 */
	public void setBpcPoNo(java.lang.String bpcPoNo){
		this.bpcPoNo = bpcPoNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购员
	 */
	public java.lang.String getBpcPoPeople(){
		return this.bpcPoPeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购员
	 */
	public void setBpcPoPeople(java.lang.String bpcPoPeople){
		this.bpcPoPeople = bpcPoPeople;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  采购日期
	 */
	public java.util.Date getBpcPoDate(){
		return this.bpcPoDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  采购日期
	 */
	public void setBpcPoDate(java.util.Date bpcPoDate){
		this.bpcPoDate = bpcPoDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计付款日期
	 */
	public java.util.Date getBpExpPayDate(){
		return this.bpExpPayDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计付款日期
	 */
	public void setBpExpPayDate(java.util.Date bpExpPayDate){
		this.bpExpPayDate = bpExpPayDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购是否已完成
	 */
	public java.lang.String getBpcPoOver(){
		return this.bpcPoOver;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购是否已完成
	 */
	public void setBpcPoOver(java.lang.String bpcPoOver){
		this.bpcPoOver = bpcPoOver;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货人
	 */
	public java.lang.String getBpcRecPeople(){
		return this.bpcRecPeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货人
	 */
	public void setBpcRecPeople(java.lang.String bpcRecPeople){
		this.bpcRecPeople = bpcRecPeople;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货人电话
	 */
	public java.lang.String getBpcRecTel(){
		return this.bpcRecTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货人电话
	 */
	public void setBpcRecTel(java.lang.String bpcRecTel){
		this.bpcRecTel = bpcRecTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货地址
	 */
	public java.lang.String getBpcRecAddr(){
		return this.bpcRecAddr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货地址
	 */
	public void setBpcRecAddr(java.lang.String bpcRecAddr){
		this.bpcRecAddr = bpcRecAddr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购情况汇报
	 */
	public java.lang.String getBpSitReport(){
		return this.bpSitReport;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购情况汇报
	 */
	public void setBpSitReport(java.lang.String bpSitReport){
		this.bpSitReport = bpSitReport;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目管理外键
	 */
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
	 *@return: java.lang.String  供应商资料外键
	 */
	public java.lang.String getFromSuppId(){
		return this.fromSuppId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商资料外键
	 */
	public void setFromSuppId(java.lang.String fromSuppId){
		this.fromSuppId = fromSuppId;
	}

	/**保存-采购合同付款明细*/
    @ExcelCollection(name="采购合同付款明细")
	private List<BusPoContractPayEntity> busPoContractPayList = new ArrayList<BusPoContractPayEntity>();
		public List<BusPoContractPayEntity> getBusPoContractPayList() {
		return busPoContractPayList;
		}
		public void setBusPoContractPayList(List<BusPoContractPayEntity> busPoContractPayList) {
		this.busPoContractPayList = busPoContractPayList;
		}
	/**保存-采购申请明细*/
    @ExcelCollection(name="采购申请明细")
	private List<BusPoApplyDetailConEntity> busPoApplyDetailConList = new ArrayList<BusPoApplyDetailConEntity>();
		public List<BusPoApplyDetailConEntity> getBusPoApplyDetailConList() {
		return busPoApplyDetailConList;
		}
		public void setBusPoApplyDetailConList(List<BusPoApplyDetailConEntity> busPoApplyDetailConList) {
		this.busPoApplyDetailConList = busPoApplyDetailConList;
		}
	/**保存-采购合同明细*/
    @ExcelCollection(name="采购合同明细")
	private List<BusPoContractDetailEntity> busPoContractDetailList = new ArrayList<BusPoContractDetailEntity>();
		public List<BusPoContractDetailEntity> getBusPoContractDetailList() {
		return busPoContractDetailList;
		}
		public void setBusPoContractDetailList(List<BusPoContractDetailEntity> busPoContractDetailList) {
		this.busPoContractDetailList = busPoContractDetailList;
		}
}
