<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:tabs id="tabsThree" iframe="true" tabPosition="top" fit="true">
	<t:tab href="busContractController.do?list1"  icon="icon-edit" title="未审核" id="tab1"></t:tab>
	<t:tab href="busContractController.do?list2"  icon="icon-save" title="已审核" id="tab2"></t:tab>
  </t:tabs>
 </div>
 </div>
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'busContractController.do?upload', "busContractList");
}

//导出
function ExportXls() {
	JeecgExcelExport("busContractController.do?exportXls","busContractList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("busContractController.do?exportXlsByT","busContractList");
}
 </script>
