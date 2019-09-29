<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwRpBusPayInfoTotalList" checkbox="false" pagination="true" fitColumns="false" title="出纳日记账报表" sortName="id" actionUrl="vwRpBusPayInfoTotalController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="支付时间"  field="bpiPayDate"  formatter="yyyy-MM-dd hh:mm:ss"  query="true"  queryMode="group"  width="140"></t:dgCol>
   <t:dgCol title="凭证号"  field="bpiVoucherno"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpmName"  query="true"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="账号简称"  field="bbaiSname"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="费用类别"  field="bpiFeeType" dictionary="cost_type"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="费用明细"  field="bpiFeeDetail" dictionary="bc_fee_dtl" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="内容"  field="bpiContent" dictionary="bus_pa_con" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="报销人"  field="bsSubmiter"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="供应商名称"  field="bsName"    queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="收款单位"  field="bsspRecCompany"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收款单位"  field="recCompany"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收款金额_贷方"  field="lenderAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="报销金额_借方"  field="submitAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购付款金额_借方"  field="poPayAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="付款金额_借方"  field="bsspPayAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="借方"  field="debtorAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="期初余额"  field="bbaiIniBalance"  queryMode="group"  width="120"></t:dgCol>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="vwRpBusPayInfoTotalController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="vwRpBusPayInfoTotalController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="vwRpBusPayInfoTotalController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vwRpBusPayInfoTotalController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vwRpBusPayInfoTotalController.do?goUpdate" funname="detail"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'vwRpBusPayInfoTotalController.do?upload', "vwRpBusPayInfoTotalList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vwRpBusPayInfoTotalController.do?exportXls","vwRpBusPayInfoTotalList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vwRpBusPayInfoTotalController.do?exportXlsByT","vwRpBusPayInfoTotalList");
}

 </script>
