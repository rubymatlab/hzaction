<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="busPoContractList" checkbox="true" fitColumns="true" title="采购合同" sortName="createDate" actionUrl="busPoContractController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购合同编号"  field="bpcPoNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购员"  field="bpcPoPeople"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购日期"  field="bpcPoDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预计付款日期"  field="bpExpPayDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购是否已完成"  field="bpcPoOver"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收货人"  field="bpcRecPeople"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收货人电话"  field="bpcRecTel"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收货地址"  field="bpcRecAddr"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购情况汇报"  field="bpSitReport"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目管理外键"  field="fromProjmId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="供应商资料外键"  field="fromSuppId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="busPoContractController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="新建" icon="icon-add" url="busPoContractController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="busPoContractController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="busPoContractController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="busPoContractController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'busPoContractController.do?upload', "busPoContractList");
}

//导出
function ExportXls() {
	JeecgExcelExport("busPoContractController.do?exportXls","busPoContractList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("busPoContractController.do?exportXlsByT","busPoContractList");
}
 </script>
