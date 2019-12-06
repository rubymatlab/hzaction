<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwBusCollectionList" checkbox="false" pagination="true" fitColumns="true" title="项目收款单" sortName="createDate" actionUrl="vwBusCollectionController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="流程状态"  field="bpmStatus"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol> --%>
   <t:dgCol title="客户行业"  field="bcClass"  hidden="true" query="true" queryMode="single"  dictionary="bc_class"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bpmProjId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpmName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户"  field="bcCustContractor"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目经理"  field="bpKeyPeople"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="进度款分期"  field="bcProgressStages"  queryMode="single" dictionary="gathering" width="120"></t:dgCol>
   <t:dgCol title="开票税率"  field="bcTaxPer"  queryMode="single"  dictionary="bc_tax_pe"  width="120"></t:dgCol>
   <t:dgCol title="开票金额"  field="bcInvAmount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收款金额"  field="bcColAmount"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="支付时间"  field="bpiPayDate"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="回款状态"  field="bcColState"  queryMode="single"  dictionary="bc_back"  width="120"></t:dgCol>
   <t:dgCol title="收款单号"  field="bcCollectId"  hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="开票时间"  field="bcInvoiceDate"  hidden="true" formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收款时间"  field="bcColDate"  formatter="yyyy-MM-dd"  hidden="true"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bcRemark"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户资料外键"  field="fromCustId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目管理外键"  field="fromProjmId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同管理外键"  field="fromContId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="文件"  field="bcFile"  hidden="true"  queryMode="single"  downloadName="附件下载"  width="120"></t:dgCol>
   <t:dgCol title="回款金额"  field="brpBackAmount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="支付方式"  field="bpiPayMethod"  hidden="true"  queryMode="single"  dictionary="bus_pa_way"  width="120"></t:dgCol>
   <t:dgCol title="银行帐号"  field="bbaiAccountNo"  hidden="true"  queryMode="single"  dictionary="ba_acc_no"  width="120"></t:dgCol>
   <t:dgCol title="费用类别"  field="bpiFeeType"  hidden="true"  queryMode="single"  dictionary="bus_pa_way"  width="120"></t:dgCol>
   <t:dgCol title="费用明细"  field="bpiFeeDetail"  hidden="true"  queryMode="single"  dictionary="bus_pa_way"  width="120"></t:dgCol>
   <t:dgCol title="内容"  field="bpiContent"  hidden="true"  queryMode="single"  dictionary="bus_pa_way"  width="120"></t:dgCol>
   <t:dgCol title="凭证号"  field="bpiVoucherno"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="vwBusCollectionController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="新建" icon="icon-add" url="vwBusCollectionController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="修改" icon="icon-search" url="vwBusCollectionController.do?goUpdate" funname="update"></t:dgToolBar>
	<t:dgToolBar title="实收" icon="icon-edit" url="vwBusCollectionController.do?goUpdate&isPayment=1" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="vwBusCollectionController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>	
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
   --%></t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
	 $("#vwBusCollectionListForm input[name=bpmName]").combogrid({
			panelWidth: 500,
			idField: "bpmName",
			textField: "bpmName",
			url: "busProjectManagerController.do?datagrid&field=id,bpmProjId,bpmName",
			columns: [[
				{field:'bpmProjId',title:'项目编号',width:80},
				{field:'bpmName',title:'项目名称',width:80}
			]],
			fitColumns: true
		})
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vwBusCollectionController.do?upload', "vwBusCollectionList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vwBusCollectionController.do?exportXls","vwBusCollectionList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vwBusCollectionController.do?exportXlsByT","vwBusCollectionList");
}

 </script>
