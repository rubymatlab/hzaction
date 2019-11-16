<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwRpBusBidTotalList" checkbox="false" pagination="true" fitColumns="true" title="投标阶段汇总表" sortName="id" actionUrl="vwRpBusBidTotalController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="投标日期"  field="bdBidDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bpProjId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpProjName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="拟中标方"  field="bdWinBidder"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目金额"  field="bdBidAmout"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目经理"  field="bpManager"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="主标人员"  field="bdMainBidder"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="配合人员"  field="bdCoordinator"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="商务负责人"  field="bdBusinessCharge"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="辅助人员"  field="bdAuxiliaryStaff"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="预计挂网时间"  field="bpOnlineTime"  formatter="yyyy-MM-dd"  hidden="true"  query="true"  queryMode="group"  width="130"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100" hidden="true"></t:dgCol>
   <t:dgDelOpt title="删除" url="vwRpBusBidTotalController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="vwRpBusBidTotalController.do?goAdd" funname="add" operationCode="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="vwRpBusBidTotalController.do?goUpdate" funname="update" operationCode="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vwRpBusBidTotalController.do?doBatchDel" operationCode="deleteALLSelect" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vwRpBusBidTotalController.do?goUpdate" operationCode="detail" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls" operationCode="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT" operationCode="ExportXlsByT"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls" operationCode="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vwRpBusBidTotalController.do?upload', "vwRpBusBidTotalList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vwRpBusBidTotalController.do?exportXls","vwRpBusBidTotalList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vwRpBusBidTotalController.do?exportXlsByT","vwRpBusBidTotalList");
}

 </script>
