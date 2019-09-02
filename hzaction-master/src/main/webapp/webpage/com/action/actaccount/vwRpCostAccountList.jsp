<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwRpCostAccountList" checkbox="false" fitColumns="false" title="vw_rp_cost_account" sortName="id" actionUrl="vwRpCostAccountController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bpProjId"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpProjName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目经理"  field="bpManager"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="立项时间"  field="bpDate"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="bcName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目立项外键"  field="fromProjId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合同管理外键"  field="fromContractId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="中标金额"  field="bcContAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="管理费"  field="projManAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="中标服务费"  field="bcWinSfee"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="中标方"  field="bcWinBidder"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合同金额"  field="bcActionAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="签定日期"  field="bcConcludeTime"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开票时间"  field="maxBcInvoiceDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开票金额"  field="bcInvAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="已开票待回款"  field="invBackAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="回款时间"  field="maxBcColDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="回款总额"  field="brpBackAmountD"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="应收金额"  field="receivableAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="未收占比"  field="notReceivablePer"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购应付"  field="poPayableTamount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购已付"  field="poPayTamount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购未付"  field="poNotPayTamount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="其他支出"  field="othersPayAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="支出合计"  field="projPayTotal"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="垫资金额"  field="padBranchAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="资金成本"  field="padBranchCost"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="现金毛利"  field="cashMarginAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="应收毛利"  field="payableMarginAmount"  queryMode="group"  width="120"></t:dgCol>
   <%-- <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
   <%-- <t:dgDelOpt title="删除" url="vwRpCostAccountController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/> --%>
   <%-- <t:dgToolBar title="录入" icon="icon-add" url="vwRpCostAccountController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar> --%>
   <t:dgToolBar title="明细" icon="icon-edit" url="vwRpCostAccountController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <%-- <t:dgToolBar title="批量删除"  icon="icon-remove" url="vwRpCostAccountController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vwRpCostAccountController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  <%--  <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vwRpCostAccountController.do?upload', "vwRpCostAccountList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vwRpCostAccountController.do?exportXls","vwRpCostAccountList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vwRpCostAccountController.do?exportXlsByT","vwRpCostAccountList");
}
 </script>
