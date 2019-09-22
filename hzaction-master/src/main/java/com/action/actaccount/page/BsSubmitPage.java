
package com.action.actaccount.page;
import com.action.actaccount.entity.BsSubmitEntity;
import com.action.actaccount.entity.BusSubmitDetailEntity;
import com.action.actaccount.entity.BusPayInfoEntity;

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
 * @Description: 费用报销
 * @author onlineGenerator
 * @date 2019-09-22 16:05:42
 * @version V1.0   
 *
 */
public class BsSubmitPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新日期*/
	private java.util.Date updateDate;
	/**项目名称*/
    @Excel(name="项目名称")
	private java.lang.String projectName;
	/**项目编号*/
    @Excel(name="项目编号")
	private java.lang.String projectId;
	/**报销人*/
    @Excel(name="报销人")
	private java.lang.String bsSubmiter;
	/**报销单号*/
    @Excel(name="报销单号")
	private java.lang.String bsSubmitId;
	/**部门*/
    @Excel(name="部门")
	private java.lang.String bsDept;
	/**申请日期*/
    @Excel(name="申请日期",format = "yyyy-MM-dd")
	private java.util.Date bsBeginDate;
	/**报销日期*/
    @Excel(name="报销日期",format = "yyyy-MM-dd")
	private java.util.Date bsSubmitDate;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String bsRemarks;
	/**票据类型*/
    @Excel(name="票据类型")
	private java.lang.String bsBillType;
	/**单据状态*/
    @Excel(name="单据状态")
	private java.lang.String bsState;
	/**报销总金额*/
    @Excel(name="报销总金额")
	private java.lang.Double totalMoney;
	/**报销总金额大写*/
    @Excel(name="报销总金额大写")
	private java.lang.String totalMoneyCn;
	/**附件*/
    @Excel(name="附件")
	private java.lang.String bsAnnex;
	/**项目管理外键*/
    @Excel(name="项目管理外键")
	private java.lang.String fromProjmId;
	
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
	 *@return: java.lang.String  项目名称
	 */
	public java.lang.String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setProjectName(java.lang.String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目编号
	 */
	public java.lang.String getProjectId(){
		return this.projectId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目编号
	 */
	public void setProjectId(java.lang.String projectId){
		this.projectId = projectId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报销人
	 */
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
	 *@return: java.lang.String  报销单号
	 */
	public java.lang.String getBsSubmitId(){
		return this.bsSubmitId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报销单号
	 */
	public void setBsSubmitId(java.lang.String bsSubmitId){
		this.bsSubmitId = bsSubmitId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门
	 */
	public java.lang.String getBsDept(){
		return this.bsDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门
	 */
	public void setBsDept(java.lang.String bsDept){
		this.bsDept = bsDept;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请日期
	 */
	public java.util.Date getBsBeginDate(){
		return this.bsBeginDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请日期
	 */
	public void setBsBeginDate(java.util.Date bsBeginDate){
		this.bsBeginDate = bsBeginDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  报销日期
	 */
	public java.util.Date getBsSubmitDate(){
		return this.bsSubmitDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  报销日期
	 */
	public void setBsSubmitDate(java.util.Date bsSubmitDate){
		this.bsSubmitDate = bsSubmitDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	public java.lang.String getBsRemarks(){
		return this.bsRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBsRemarks(java.lang.String bsRemarks){
		this.bsRemarks = bsRemarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  票据类型
	 */
	public java.lang.String getBsBillType(){
		return this.bsBillType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  票据类型
	 */
	public void setBsBillType(java.lang.String bsBillType){
		this.bsBillType = bsBillType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单据状态
	 */
	public java.lang.String getBsState(){
		return this.bsState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单据状态
	 */
	public void setBsState(java.lang.String bsState){
		this.bsState = bsState;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  报销总金额
	 */
	public java.lang.Double getTotalMoney(){
		return this.totalMoney;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  报销总金额
	 */
	public void setTotalMoney(java.lang.Double totalMoney){
		this.totalMoney = totalMoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报销总金额大写
	 */
	public java.lang.String getTotalMoneyCn(){
		return this.totalMoneyCn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报销总金额大写
	 */
	public void setTotalMoneyCn(java.lang.String totalMoneyCn){
		this.totalMoneyCn = totalMoneyCn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件
	 */
	public java.lang.String getBsAnnex(){
		return this.bsAnnex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setBsAnnex(java.lang.String bsAnnex){
		this.bsAnnex = bsAnnex;
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

	/**保存-费用报销明细*/
    @ExcelCollection(name="费用报销明细")
	private List<BusSubmitDetailEntity> busSubmitDetailList = new ArrayList<BusSubmitDetailEntity>();
		public List<BusSubmitDetailEntity> getBusSubmitDetailList() {
		return busSubmitDetailList;
		}
		public void setBusSubmitDetailList(List<BusSubmitDetailEntity> busSubmitDetailList) {
		this.busSubmitDetailList = busSubmitDetailList;
		}
	/**保存-支付信息*/
    @ExcelCollection(name="支付信息")
	private List<BusPayInfoEntity> busPayInfoList = new ArrayList<BusPayInfoEntity>();
		public List<BusPayInfoEntity> getBusPayInfoList() {
		return busPayInfoList;
		}
		public void setBusPayInfoList(List<BusPayInfoEntity> busPayInfoList) {
		this.busPayInfoList = busPayInfoList;
		}
}
