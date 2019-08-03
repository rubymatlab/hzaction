<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vmBusPoContractList" checkbox="true" fitColumns="true" title="采购合同视图" sortName="createDate" actionUrl="vmBusPoContractController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购合同编号"  field="bpcPoNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bpmProjId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpmProjName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目管理外键"  field="fromProjmId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="供应商资料外键"  field="fromSuppId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="供应商"  field="bsName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="采购是否已完成"  field="bpcPoOver"  hidden="true"  queryMode="group"  dictionary="is_over"  width="120"></t:dgCol>
   <t:dgCol title="供应商联系人"  field="bsContact"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="供应商联系人电话"  field="bsTelNo"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收货人"  field="bpcRecPeople"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收货人电话"  field="bpcRecTel"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收货地址"  field="bpcRecAddr"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购员"  field="bpcPoPeople"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购日期"  field="bpcPoDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="总金额"  field="allAmount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预计付款日期"  field="bpExpPayDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购情况汇报"  field="bpSitReport"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目经理"  field="bpManager"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="bcName"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="vmBusPoContractController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="vmBusPoContractController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="vmBusPoContractController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vmBusPoContractController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vmBusPoContractController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 

$("#vmBusPoContractListForm input[name=bpmProjName]").addClass("easyui-combogrid").attr("data-options",
			"panelWidth: 500,"+ 
            "idField: 'id', "+ 
            "textField: 'bpmProjName', "+
            "url: 'vmBusProjectManagerController.do?datagrid&field=id,bpmProjId,bpmProjName', "+ 
            "columns: [[ "+
             "   {field:'bpmProjId',title:'项目编号',width:80}, "+
              "  {field:'bpmProjName',title:'项目名称',width:120} "+ 
            "]], "+ 
             "fitColumns: true,"
		)


//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vmBusPoContractController.do?upload', "vmBusPoContractList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vmBusPoContractController.do?exportXls","vmBusPoContractList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vmBusPoContractController.do?exportXlsByT","vmBusPoContractList");
}
 </script>
