
package com.action.actpo.page;
import com.action.actpo.entity.VwBusPoApplyEntity;
import com.action.actpo.entity.BusPoApplyDetailEntity;

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
 * @Description: 采购申请视图
 * @author onlineGenerator
 * @date 2019-08-10 15:43:49
 * @version V1.0   
 *
 */
public class VwBusPoApplyPage implements java.io.Serializable {
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
    @Excel(name="采购申请编号")
	private java.lang.String bpaApplyNo;
	/**申请日期*/
    @Excel(name="申请日期",format = "yyyy-MM-dd")
	private java.util.Date bpaApplyDate;
	/**收货人*/
    @Excel(name="收货人")
	private java.lang.String bpaRecPeople;
	/**收货人电话*/
    @Excel(name="收货人电话")
	private java.lang.String bpaRecTel;
	/**收货地址*/
    @Excel(name="收货地址")
	private java.lang.String bpaRecAddr;
	/**申请人*/
    @Excel(name="申请人")
	private java.lang.String bpaApplyPeople;
	/**单据状态*/
    @Excel(name="单据状态")
	private java.lang.String bpaState;
	/**项目管理外键*/
    @Excel(name="项目管理外键")
	private java.lang.String fromProjmId;
	/**名称*/
    @Excel(name="名称")
	private java.lang.String bpadName;
	/**品牌*/
    @Excel(name="品牌")
	private java.lang.String bpadBrand;
	/**型号*/
    @Excel(name="型号")
	private java.lang.String bpadModel;
	/**数量*/
    @Excel(name="数量")
	private java.lang.Double bpadNumber;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String bpadRemark;
	/**采购申请外键*/
    @Excel(name="采购申请外键")
	private java.lang.String fromId;
	/**项目名称*/
    @Excel(name="项目名称")
	private java.lang.String bpmName;
	/**客户名称*/
    @Excel(name="客户名称")
	private java.lang.String bcName;
	/**项目经理*/
    @Excel(name="项目经理")
	private java.lang.String bpManager;
	/**是否采购*/
    @Excel(name="是否采购")
	private java.lang.String purchaseOrNot;
	/**项目编号*/
    @Excel(name="项目编号")
	private java.lang.String bpProjId;
	/**项目管理id*/
    @Excel(name="项目管理id")
	private java.lang.String busProjectManagerId;
	/**采购申请附件*/
    @Excel(name="采购申请附件")
	private java.lang.String bpaFile;
	
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
	 *@return: java.lang.String  采购申请编号
	 */
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
	 *@return: java.lang.String  名称
	 */
	public java.lang.String getBpadName(){
		return this.bpadName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setBpadName(java.lang.String bpadName){
		this.bpadName = bpadName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品牌
	 */
	public java.lang.String getBpadBrand(){
		return this.bpadBrand;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品牌
	 */
	public void setBpadBrand(java.lang.String bpadBrand){
		this.bpadBrand = bpadBrand;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  型号
	 */
	public java.lang.String getBpadModel(){
		return this.bpadModel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  型号
	 */
	public void setBpadModel(java.lang.String bpadModel){
		this.bpadModel = bpadModel;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  数量
	 */
	public java.lang.Double getBpadNumber(){
		return this.bpadNumber;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  数量
	 */
	public void setBpadNumber(java.lang.Double bpadNumber){
		this.bpadNumber = bpadNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	public java.lang.String getBpadRemark(){
		return this.bpadRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBpadRemark(java.lang.String bpadRemark){
		this.bpadRemark = bpadRemark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购申请外键
	 */
	public java.lang.String getFromId(){
		return this.fromId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购申请外键
	 */
	public void setFromId(java.lang.String fromId){
		this.fromId = fromId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
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

	/**保存-采购申请明细*/
    @ExcelCollection(name="采购申请明细")
	private List<BusPoApplyDetailEntity> busPoApplyDetailList = new ArrayList<BusPoApplyDetailEntity>();
		public List<BusPoApplyDetailEntity> getBusPoApplyDetailList() {
		return busPoApplyDetailList;
		}
		public void setBusPoApplyDetailList(List<BusPoApplyDetailEntity> busPoApplyDetailList) {
		this.busPoApplyDetailList = busPoApplyDetailList;
		}
}
