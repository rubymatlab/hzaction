<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwRpBusCollectPlanTotalList" checkbox="false" pagination="true" fitColumns="false" title="回款计划汇总" sortName="id" actionUrl="vwRpBusCollectPlanTotalController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="客户名称"  field="bcName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目经理"  field="bpManager"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bpProjId"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpmName"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="进度款分期"  field="brpProgressStages"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同金额"  field="brpContractAmount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="已收金额"  field="brpAcceptAmount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="预计回款金额"  field="brpBackAmount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否开发票"  field="brpIsInvoice"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="跟踪情况"  field="followDesc"  queryMode="single"  width="220"></t:dgCol>
  
   <t:dgCol title="签订时间"  field="bcConcludeTime"  query="true"   queryMode="group"  width="120" formatter="yyyy-MM-dd"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" hidden="true" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="vwRpBusCollectPlanTotalController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="vwRpBusCollectPlanTotalController.do?goAdd" funname="add" operationCode="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="vwRpBusCollectPlanTotalController.do?goUpdate" funname="update" operationCode="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vwRpBusCollectPlanTotalController.do?doBatchDel" funname="deleteALLSelect" operationCode="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vwRpBusCollectPlanTotalController.do?goUpdate" funname="detail" operationCode="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls" operationCode="ImportXls"></t:dgToolBar>
  
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT" operationCode="ExportXlsByT"></t:dgToolBar> --%>
    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vwRpBusCollectPlanTotalController.do?upload', "vwRpBusCollectPlanTotalList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vwRpBusCollectPlanTotalController.do?exportXls","vwRpBusCollectPlanTotalList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vwRpBusCollectPlanTotalController.do?exportXlsByT","vwRpBusCollectPlanTotalList");
}

 </script>
