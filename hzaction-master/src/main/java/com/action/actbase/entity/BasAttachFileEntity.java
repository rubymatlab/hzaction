package com.action.actbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 附件文件
 * @author onlineGenerator
 * @date 2019-08-05 13:40:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bas_attach_file", schema = "")
@SuppressWarnings("serial")
public class BasAttachFileEntity implements java.io.Serializable {
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
	/**附件分类*/
	@Excel(name="附件分类",width=15)
	private java.lang.String bafAttachClass;
	/**业务外键*/
	@Excel(name="业务外键",width=15)
	private java.lang.String bafBusId;
	/**序号*/
	@Excel(name="序号",width=15)
	private java.lang.Integer bafSeqNo;
	/**文件路径*/
	@Excel(name="文件路径",width=15)
	private java.lang.String bafPath;
	/**文件名称*/
	@Excel(name="文件名称",width=15)
	private java.lang.String bafFilename;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
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
	 *@return: java.lang.String  附件分类
	 */

	@Column(name ="BAF_ATTACH_CLASS",nullable=true,length=30)
	public java.lang.String getBafAttachClass(){
		return this.bafAttachClass;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件分类
	 */
	public void setBafAttachClass(java.lang.String bafAttachClass){
		this.bafAttachClass = bafAttachClass;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务外键
	 */

	@Column(name ="BAF_BUS_ID",nullable=true,length=32)
	public java.lang.String getBafBusId(){
		return this.bafBusId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务外键
	 */
	public void setBafBusId(java.lang.String bafBusId){
		this.bafBusId = bafBusId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  序号
	 */

	@Column(name ="BAF_SEQ_NO",nullable=true,length=32)
	public java.lang.Integer getBafSeqNo(){
		return this.bafSeqNo;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  序号
	 */
	public void setBafSeqNo(java.lang.Integer bafSeqNo){
		this.bafSeqNo = bafSeqNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件路径
	 */

	@Column(name ="BAF_PATH",nullable=true,length=200)
	public java.lang.String getBafPath(){
		return this.bafPath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件路径
	 */
	public void setBafPath(java.lang.String bafPath){
		this.bafPath = bafPath;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件名称
	 */

	@Column(name ="BAF_FILENAME",nullable=true,length=100)
	public java.lang.String getBafFilename(){
		return this.bafFilename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件名称
	 */
	public void setBafFilename(java.lang.String bafFilename){
		this.bafFilename = bafFilename;
	}
}
