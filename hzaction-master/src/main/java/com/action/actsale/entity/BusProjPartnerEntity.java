package com.action.actsale.entity;
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
 * @Description: 合作伙伴资料
 * @author onlineGenerator
 * @date 2019-08-14 22:03:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "bus_proj_partner", schema = "")
@SuppressWarnings("serial")
public class BusProjPartnerEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**公司名称*/
	@Excel(name="公司名称",width=15)
	private java.lang.String bppCompany;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String bppName;
	/**部门*/
	@Excel(name="部门",width=15)
	private java.lang.String bppDept;
	/**职务*/
	@Excel(name="职务",width=15)
	private java.lang.String bppPost;
	/**电话*/
	@Excel(name="电话",width=15)
	private java.lang.String bppTel;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String bppRemark;
	/**项目立项外键*/
	/* @Excel(name="项目立项外键",width=15) */
	private java.lang.String fromId;
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
	 *@return: java.lang.String  公司名称
	 */
	
	@Column(name ="BPP_COMPANY",nullable=true,length=100)
	public java.lang.String getBppCompany(){
		return this.bppCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名称
	 */
	public void setBppCompany(java.lang.String bppCompany){
		this.bppCompany = bppCompany;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	
	@Column(name ="BPP_NAME",nullable=true,length=32)
	public java.lang.String getBppName(){
		return this.bppName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setBppName(java.lang.String bppName){
		this.bppName = bppName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门
	 */
	
	@Column(name ="BPP_DEPT",nullable=true,length=32)
	public java.lang.String getBppDept(){
		return this.bppDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门
	 */
	public void setBppDept(java.lang.String bppDept){
		this.bppDept = bppDept;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职务
	 */
	
	@Column(name ="BPP_POST",nullable=true,length=32)
	public java.lang.String getBppPost(){
		return this.bppPost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职务
	 */
	public void setBppPost(java.lang.String bppPost){
		this.bppPost = bppPost;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */
	
	@Column(name ="BPP_TEL",nullable=true,length=32)
	public java.lang.String getBppTel(){
		return this.bppTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setBppTel(java.lang.String bppTel){
		this.bppTel = bppTel;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="BPP_REMARK",nullable=true,length=100)
	public java.lang.String getBppRemark(){
		return this.bppRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBppRemark(java.lang.String bppRemark){
		this.bppRemark = bppRemark;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目立项外键
	 */
	
	@Column(name ="FROM_ID",nullable=true,length=36)
	public java.lang.String getFromId(){
		return this.fromId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目立项外键
	 */
	public void setFromId(java.lang.String fromId){
		this.fromId = fromId;
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
	
}
