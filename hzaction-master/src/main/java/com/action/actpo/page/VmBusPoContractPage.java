
package com.action.actpo.page;
import com.action.actpo.entity.VmBusPoContractEntity;
import com.action.actpo.entity.VmMergeBusPoApplyDetailEntity;
import com.action.actpo.entity.BusPoContractPayEntity;
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
 * @Description: 采购合同视图
 * @author onlineGenerator
 * @date 2019-07-30 13:14:33
 * @version V1.0   
 *
 */
public class VmBusPoContractPage implements java.io.Serializable {
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
	/**采购合同编号*/
    @Excel(name="采购合同编号")
	private java.lang.String bpcPoNo;
	/**项目编号*/
    @Excel(name="项目编号")
	private java.lang.String bpmProjId;
	/**项目名称*/
    @Excel(name="项目名称")
	private java.lang.String bpmProjName;
	/**项目管理外键*/
	private java.lang.String fromProjmId;
	/**供应商资料外键*/
	private java.lang.String fromSuppId;
	/**供应商*/
    @Excel(name="供应商")
	private java.lang.String bsName;
	/**采购是否已完成*/
    @Excel(name="采购是否已完成")
	private java.lang.String bpcPoOver;
	/**供应商联系人*/
    @Excel(name="供应商联系人")
	private java.lang.String bsContact;
	/**供应商联系人电话*/
    @Excel(name="供应商联系人电话")
	private java.lang.String bsTelNo;
	/**收货人*/
    @Excel(name="收货人")
	private java.lang.String bpcRecPeople;
	/**收货人电话*/
    @Excel(name="收货人电话")
	private java.lang.String bpcRecTel;
	/**收货地址*/
    @Excel(name="收货地址")
	private java.lang.String bpcRecAddr;
	/**采购员*/
    @Excel(name="采购员")
	private java.lang.String bpcPoPeople;
	/**采购日期*/
    @Excel(name="采购日期",format = "yyyy-MM-dd")
	private java.util.Date bpcPoDate;
	/**总金额*/
	private java.lang.String allAmount;
	/**预计付款日期*/
	private java.util.Date bpExpPayDate;
	/**采购情况汇报*/
    @Excel(name="采购情况汇报")
	private java.lang.String bpSitReport;
	/**项目经理*/
	private java.lang.String bpManager;
	/**客户名称*/
	private java.lang.String bcName;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
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
	 *@return: java.lang.String  项目编号
	 */
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商
	 */
	public java.lang.String getBsName(){
		return this.bsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商
	 */
	public void setBsName(java.lang.String bsName){
		this.bsName = bsName;
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
	 *@return: java.lang.String  供应商联系人
	 */
	public java.lang.String getBsContact(){
		return this.bsContact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商联系人
	 */
	public void setBsContact(java.lang.String bsContact){
		this.bsContact = bsContact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商联系人电话
	 */
	public java.lang.String getBsTelNo(){
		return this.bsTelNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商联系人电话
	 */
	public void setBsTelNo(java.lang.String bsTelNo){
		this.bsTelNo = bsTelNo;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  总金额
	 */
	public java.lang.String getAllAmount(){
		return this.allAmount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  总金额
	 */
	public void setAllAmount(java.lang.String allAmount){
		this.allAmount = allAmount;
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

	/**保存-采购申请明细*/
    @ExcelCollection(name="采购申请明细")
	private List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailList = new ArrayList<VmMergeBusPoApplyDetailEntity>();
		public List<VmMergeBusPoApplyDetailEntity> getVmMergeBusPoApplyDetailList() {
		return vmMergeBusPoApplyDetailList;
		}
		public void setVmMergeBusPoApplyDetailList(List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailList) {
		this.vmMergeBusPoApplyDetailList = vmMergeBusPoApplyDetailList;
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
