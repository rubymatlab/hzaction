
package com.action.actbase.page;
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

import com.action.actbase.entity.BasCustomerContactsEntity;
import com.action.actbase.entity.BasCustomerEntity;

/**   
 * @Title: Entity
 * @Description: 客户资料
 * @author onlineGenerator
 * @date 2019-07-18 23:41:34
 * @version V1.0   
 *
 */
public class BasCustomerPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**客户编号*/
    @Excel(name="客户编号")
	private java.lang.String bcId;
	/**客户名称*/
    @Excel(name="客户名称")
	private java.lang.String bcName;
	/**客户简称*/
    @Excel(name="客户简称")
	private java.lang.String bcSname;
	/**客户地址*/
    @Excel(name="客户地址")
	private java.lang.String bcAddress;
	/**开户行*/
    @Excel(name="开户行")
	private java.lang.String bcBankId;
	/**开户帐号*/
    @Excel(name="开户帐号")
	private java.lang.String bcBankAcc;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String bcRemark;
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
	 *@return: java.lang.String  客户编号
	 */
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
	 *@return: java.lang.String  客户地址
	 */
	public java.lang.String getBcAddress(){
		return this.bcAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户地址
	 */
	public void setBcAddress(java.lang.String bcAddress){
		this.bcAddress = bcAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户行
	 */
	public java.lang.String getBcBankId(){
		return this.bcBankId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户行
	 */
	public void setBcBankId(java.lang.String bcBankId){
		this.bcBankId = bcBankId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户帐号
	 */
	public java.lang.String getBcBankAcc(){
		return this.bcBankAcc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户帐号
	 */
	public void setBcBankAcc(java.lang.String bcBankAcc){
		this.bcBankAcc = bcBankAcc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
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

	/**保存-客户资料明细*/
    @ExcelCollection(name="客户资料明细")
	private List<BasCustomerContactsEntity> basCustomerContactsList = new ArrayList<BasCustomerContactsEntity>();
		public List<BasCustomerContactsEntity> getBasCustomerContactsList() {
		return basCustomerContactsList;
		}
		public void setBasCustomerContactsList(List<BasCustomerContactsEntity> basCustomerContactsList) {
		this.basCustomerContactsList = basCustomerContactsList;
		}
}
