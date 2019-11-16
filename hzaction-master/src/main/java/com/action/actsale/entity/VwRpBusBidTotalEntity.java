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
 * @Description: 投标阶段汇总表
 * @author onlineGenerator
 * @date 2019-08-01 14:17:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vw_rp_bus_bid_total", schema = "")
@SuppressWarnings("serial")
public class VwRpBusBidTotalEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**投标日期*/
	@Excel(name="投标日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date bdBidDate;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private java.lang.String bpProjId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String bpProjName;
	/**拟中标方*/
	@Excel(name="拟中标方",width=15)
	private java.lang.String bdWinBidder;
	/**项目金额*/
	@Excel(name="项目金额",width=15)
	private java.lang.String bdBidAmout;
	/**项目经理*/
	@Excel(name="项目经理",width=15)
	private java.lang.String bpManager;
	/**主标人员*/
	@Excel(name="主标人员",width=15)
	private java.lang.String bdMainBidder;
	/**配合人员*/
	@Excel(name="配合人员",width=15)
	private java.lang.String bdCoordinator;
	/**商务负责人*/
	@Excel(name="商务负责人",width=15)
	private java.lang.String bdBusinessCharge;
	/**辅助人员*/
	@Excel(name="辅助人员",width=15)
	private java.lang.String bdAuxiliaryStaff;
	/**预计挂网时间*/
	private java.util.Date bpOnlineTime;
	
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
	 *@return: java.util.Date  投标日期
	 */

	@Column(name ="BD_BID_DATE",nullable=true,length=32)
	public java.util.Date getBdBidDate(){
		return this.bdBidDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  投标日期
	 */
	public void setBdBidDate(java.util.Date bdBidDate){
		this.bdBidDate = bdBidDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目编号
	 */

	@Column(name ="BP_PROJ_ID",nullable=true,length=32)
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

	@Column(name ="BP_PROJ_NAME",nullable=true,length=32)
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
	 *@return: java.lang.String  拟中标方
	 */

	@Column(name ="BD_WIN_BIDDER",nullable=true,length=32)
	public java.lang.String getBdWinBidder(){
		return this.bdWinBidder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  拟中标方
	 */
	public void setBdWinBidder(java.lang.String bdWinBidder){
		this.bdWinBidder = bdWinBidder;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目金额
	 */

	@Column(name ="BD_BID_AMOUT",nullable=true,length=32)
	public java.lang.String getBdBidAmout(){
		return this.bdBidAmout;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目金额
	 */
	public void setBdBidAmout(java.lang.String bdBidAmout){
		this.bdBidAmout = bdBidAmout;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目经理
	 */

	@Column(name ="BP_MANAGER",nullable=true,length=32)
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
	 *@return: java.lang.String  主标人员
	 */

	@Column(name ="BD_MAIN_BIDDER",nullable=true,length=32)
	public java.lang.String getBdMainBidder(){
		return this.bdMainBidder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主标人员
	 */
	public void setBdMainBidder(java.lang.String bdMainBidder){
		this.bdMainBidder = bdMainBidder;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  配合人员
	 */

	@Column(name ="BD_COORDINATOR",nullable=true,length=32)
	public java.lang.String getBdCoordinator(){
		return this.bdCoordinator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配合人员
	 */
	public void setBdCoordinator(java.lang.String bdCoordinator){
		this.bdCoordinator = bdCoordinator;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商务负责人
	 */

	@Column(name ="BD_BUSINESS_CHARGE",nullable=true,length=32)
	public java.lang.String getBdBusinessCharge(){
		return this.bdBusinessCharge;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商务负责人
	 */
	public void setBdBusinessCharge(java.lang.String bdBusinessCharge){
		this.bdBusinessCharge = bdBusinessCharge;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  辅助人员
	 */

	@Column(name ="BD_AUXILIARY_STAFF",nullable=true,length=32)
	public java.lang.String getBdAuxiliaryStaff(){
		return this.bdAuxiliaryStaff;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  辅助人员
	 */
	public void setBdAuxiliaryStaff(java.lang.String bdAuxiliaryStaff){
		this.bdAuxiliaryStaff = bdAuxiliaryStaff;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计挂网时间
	 */

	@Column(name ="BP_ONLINE_TIME",nullable=true,length=32)
	public java.util.Date getBpOnlineTime(){
		return this.bpOnlineTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计挂网时间
	 */
	public void setBpOnlineTime(java.util.Date bpOnlineTime){
		this.bpOnlineTime = bpOnlineTime;
	}
}
