<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwBusBidListNoVf" pagination="true" fitColumns="true" sortName="createDate" actionUrl="vwBusBidController.do?datagrid&bdState=0" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="附件文件表id"  field="bafSerId"  hidden="true"  queryMode="single"  downloadName="附件下载"  width="120"></t:dgCol>
   <t:dgCol title="附件分类"  field="bafAttachClass"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="文件路径"  field="bafPath"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="文件名称"  field="bafFilename"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目立项表id"  field="bpSerId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bpProjId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpProjName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户资料表id"  field="bcSerId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户编号"  field="bcId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="bcName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户简称"  field="bcSname"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="立项时间"  field="bpDate"  formatter="yyyy-MM-dd"  hidden="true"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="拟中标方"  field="bdWinBidder"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目类型"  field="bdProjType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="主标人员"  field="bdMainBidder"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="配合人员"  field="bdCoordinator"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="商务负责人"  field="bdBusinessCharge"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="辅助人员"  field="bdAuxiliaryStaff"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="投标金额"  field="bdBidAmout"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="投标日期"  field="bdBidDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="投标内容"  field="bdBidContent"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="bdState"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bdBidRemark"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目立项外键"  field="fromProjId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户资料外键"  field="fromCustjId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt title="修改" funname="modifyInfo(id)" urlclass="ace_button"  urlfont="fa-edit" />
   <t:dgFunOpt funname="doVerifyBtn(id)" title="审核" urlclass="ace_button" urlfont="fa-wrench" />
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
     	//自定义按钮-审核
	 	function doVerifyBtn(id,index){
	 	    var url = "vwBusBidController.do?doVerifyBtn";
			url = url+"&id="+id;
	 		createdialog('确认 ', '确定审核吗 ?', url,'vwBusBidListNoVf');
	 	} 
     	
     	//自定义按钮-修改
	 	 function modifyInfo(id) {
	 		createwindow('修改信息', 'vwBusBidController.do?goUpdate&id=' + id,650,400);
	    }
</script>
