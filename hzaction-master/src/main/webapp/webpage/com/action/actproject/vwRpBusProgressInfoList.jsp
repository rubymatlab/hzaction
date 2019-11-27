<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwRpBusProgressInfoList" checkbox="true" pagination="true" fitColumns="false" title="施工进度报表" sortName="id" actionUrl="vwRpBusProgressInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bpProjId" query="true"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpmName" query="true" queryMode="single"  width="250"></t:dgCol>
   <t:dgCol title="项目经理"  field="bpManager" query="true" queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="客户名称"  field="bcName" query="true" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户行业"  field="bcClass"  query="true"   dictionary="bc_class" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同金额"  field="bcContAmount"  queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="已回款金额"  field="brpBackAmountD"  queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="进度百分比"  field="bpmProgPer"  queryMode="group"  dictionary="proj_per"  width="80"></t:dgCol>
   <t:dgCol title="验收时间"  field="bpfCheckDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="跟进情况汇总"  field="bpfCheckResult"  queryMode="group"  dictionary="check_res"  width="350"></t:dgCol>
   <t:dgCol title="施工困难_问题"  field="bpfQuestions"  queryMode="group"  width="350"></t:dgCol>
   <t:dgCol title="下一步计划"  field="bpfNextPlan"  queryMode="group"  width="350"></t:dgCol>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="vwRpBusProgressInfoController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="新建" icon="icon-add" url="vwRpBusProgressInfoController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="vwRpBusProgressInfoController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vwRpBusProgressInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vwRpBusProgressInfoController.do?goUpdate" funname="detail"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'vwRpBusProgressInfoController.do?upload', "vwRpBusProgressInfoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vwRpBusProgressInfoController.do?exportXls","vwRpBusProgressInfoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vwRpBusProgressInfoController.do?exportXlsByT","vwRpBusProgressInfoList");
}

 </script>
