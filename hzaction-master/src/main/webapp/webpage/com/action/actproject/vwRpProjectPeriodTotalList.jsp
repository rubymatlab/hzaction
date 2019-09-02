<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwRpProjectPeriodTotalList" checkbox="false" pagination="true" fitColumns="true" title="项目整体周期汇总表" sortName="id" actionUrl="vwRpProjectPeriodTotalController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  query="true" field="bpProjId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  query="true" field="bpProjName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目经理"  query="true" field="bpManager"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="立项时间"  query="true" field="bpDate"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合同签定时间"  query="true" field="bcConcludeTime"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合同天数"  field="contractDays"  queryMode="single" formatter="yyyy-MM-dd" width="120"></t:dgCol>
   <t:dgCol title="验收时间"  field="maxBpfCheckDate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="验收天数"  field="checkDays"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="最后收款时间"  field="maxBcColDate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收款天数"  field="colDays"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="bcName"  queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="vwRpProjectPeriodTotalController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="vwRpProjectPeriodTotalController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="vwRpProjectPeriodTotalController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vwRpProjectPeriodTotalController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vwRpProjectPeriodTotalController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vwRpProjectPeriodTotalController.do?upload', "vwRpProjectPeriodTotalList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vwRpProjectPeriodTotalController.do?exportXls","vwRpProjectPeriodTotalList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vwRpProjectPeriodTotalController.do?exportXlsByT","vwRpProjectPeriodTotalList");
}

 </script>
