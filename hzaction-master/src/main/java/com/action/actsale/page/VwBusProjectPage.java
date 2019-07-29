
package com.action.actsale.page;
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

import com.action.actsale.entity.BusProjectDetailEntity;
import com.action.actsale.entity.BusProjectFollowEntity;
import com.action.actsale.entity.VwBusProjectEntity;

/**   
 * @Title: Entity
 * @Description: 项目立项视图
 * @author onlineGenerator
 * @date 2019-07-25 07:20:01
 * @version V1.0   
 *
 */
public class VwBusProjectPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**项目编号*/
    @Excel(name="项目编号")
	private java.lang.String bpProId;
	/**项目名称*/
    @Excel(name="项目名称")
	private java.lang.String bpProName;
	/**立项时间*/
    @Excel(name="立项时间",format = "yyyy-MM-dd")
	private java.util.Date bpDate;
	/**项目关键人*/
    @Excel(name="项目关键人")
	private java.lang.String bpKeyPeople;
	/**项目简介*/
    @Excel(name="项目简介")
	private java.lang.String bpIntroduction;
	/**问题or协助*/
    @Excel(name="问题or协助")
	private java.lang.String bpQuestions;
	/**产品解决方案*/
    @Excel(name="产品解决方案")
	private java.lang.String bpProSolutions;
	/**竞争情况*/
    @Excel(name="竞争情况")
	private java.lang.String bpCompetition;
	/**项目经理*/
    @Excel(name="项目经理")
	private java.lang.String bpManager;
	/**项目组成员*/
    @Excel(name="项目组成员")
	private java.lang.String bpTeam;
	/**方案输出时间*/
    @Excel(name="方案输出时间",format = "yyyy-MM-dd")
	private java.util.Date bpOutTime;
	/**方案定稿时间*/
    @Excel(name="方案定稿时间",format = "yyyy-MM-dd")
	private java.util.Date bpFinishTime;
	/**正式挂网时间*/
    @Excel(name="正式挂网时间",format = "yyyy-MM-dd")
	private java.util.Date bpOnlineTime;
	/**跟进结果*/
    @Excel(name="跟进结果")
	private java.lang.String bpFollowResults;
	/**客户资料外键*/
    @Excel(name="客户资料外键")
	private java.lang.String fromCustId;
	/**客户编号*/
    @Excel(name="客户编号")
	private java.lang.String bcId;
	/**客户名称*/
    @Excel(name="客户名称")
	private java.lang.String bcName;
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
	 *@return: java.lang.String  项目编号
	 */
	public java.lang.String getBpProId(){
		return this.bpProId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目编号
	 */
	public void setBpProId(java.lang.String bpProId){
		this.bpProId = bpProId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	public java.lang.String getBpProName(){
		return this.bpProName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setBpProName(java.lang.String bpProName){
		this.bpProName = bpProName;
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
	 *@return: java.lang.String  项目关键人
	 */
	public java.lang.String getBpKeyPeople(){
		return this.bpKeyPeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目关键人
	 */
	public void setBpKeyPeople(java.lang.String bpKeyPeople){
		this.bpKeyPeople = bpKeyPeople;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目简介
	 */
	public java.lang.String getBpIntroduction(){
		return this.bpIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目简介
	 */
	public void setBpIntroduction(java.lang.String bpIntroduction){
		this.bpIntroduction = bpIntroduction;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  问题or协助
	 */
	public java.lang.String getBpQuestions(){
		return this.bpQuestions;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  问题or协助
	 */
	public void setBpQuestions(java.lang.String bpQuestions){
		this.bpQuestions = bpQuestions;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品解决方案
	 */
	public java.lang.String getBpProSolutions(){
		return this.bpProSolutions;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品解决方案
	 */
	public void setBpProSolutions(java.lang.String bpProSolutions){
		this.bpProSolutions = bpProSolutions;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  竞争情况
	 */
	public java.lang.String getBpCompetition(){
		return this.bpCompetition;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  竞争情况
	 */
	public void setBpCompetition(java.lang.String bpCompetition){
		this.bpCompetition = bpCompetition;
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
	 *@return: java.lang.String  项目组成员
	 */
	public java.lang.String getBpTeam(){
		return this.bpTeam;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目组成员
	 */
	public void setBpTeam(java.lang.String bpTeam){
		this.bpTeam = bpTeam;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  方案输出时间
	 */
	public java.util.Date getBpOutTime(){
		return this.bpOutTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  方案输出时间
	 */
	public void setBpOutTime(java.util.Date bpOutTime){
		this.bpOutTime = bpOutTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  方案定稿时间
	 */
	public java.util.Date getBpFinishTime(){
		return this.bpFinishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  方案定稿时间
	 */
	public void setBpFinishTime(java.util.Date bpFinishTime){
		this.bpFinishTime = bpFinishTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  正式挂网时间
	 */
	public java.util.Date getBpOnlineTime(){
		return this.bpOnlineTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  正式挂网时间
	 */
	public void setBpOnlineTime(java.util.Date bpOnlineTime){
		this.bpOnlineTime = bpOnlineTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  跟进结果
	 */
	public java.lang.String getBpFollowResults(){
		return this.bpFollowResults;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  跟进结果
	 */
	public void setBpFollowResults(java.lang.String bpFollowResults){
		this.bpFollowResults = bpFollowResults;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户资料外键
	 */
	public java.lang.String getFromCustId(){
		return this.fromCustId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户资料外键
	 */
	public void setFromCustId(java.lang.String fromCustId){
		this.fromCustId = fromCustId;
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

	/**保存-项目费用明细*/
    @ExcelCollection(name="项目费用明细")
	private List<BusProjectDetailEntity> busProjectDetailList = new ArrayList<BusProjectDetailEntity>();
		public List<BusProjectDetailEntity> getBusProjectDetailList() {
		return busProjectDetailList;
		}
		public void setBusProjectDetailList(List<BusProjectDetailEntity> busProjectDetailList) {
		this.busProjectDetailList = busProjectDetailList;
		}
	/**保存-项目跟进分配*/
    @ExcelCollection(name="项目跟进分配")
	private List<BusProjectFollowEntity> busProjectFollowList = new ArrayList<BusProjectFollowEntity>();
		public List<BusProjectFollowEntity> getBusProjectFollowList() {
		return busProjectFollowList;
		}
		public void setBusProjectFollowList(List<BusProjectFollowEntity> busProjectFollowList) {
		this.busProjectFollowList = busProjectFollowList;
		}
}
