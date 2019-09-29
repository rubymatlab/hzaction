<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwRpPoPayPlanTotalList" checkbox="true" pagination="true" fitColumns="false" title="采购付款计划总表" sortName="id" actionUrl="vwRpPoPayPlanTotalController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bpProjId"  query="true"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpmName"  query="true"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="项目经理"  field="bpManager"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="bcName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="签订时间"  field="bcConcludeTime"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="费用分期"  field="bpcpProgre"  dictionary="cost_stag"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="计划付款日期"  field="bpcpDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="计划付款金额"  field="bpcpPayAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="付款金额"  field="bppdPayAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="未付款金额"  field="notPayAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="vwRpPoPayPlanTotalController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="vwRpPoPayPlanTotalController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="vwRpPoPayPlanTotalController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vwRpPoPayPlanTotalController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vwRpPoPayPlanTotalController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vwRpPoPayPlanTotalController.do?upload', "vwRpPoPayPlanTotalList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vwRpPoPayPlanTotalController.do?exportXls","vwRpPoPayPlanTotalList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vwRpPoPayPlanTotalController.do?exportXlsByT","vwRpPoPayPlanTotalList");
}

 </script>
