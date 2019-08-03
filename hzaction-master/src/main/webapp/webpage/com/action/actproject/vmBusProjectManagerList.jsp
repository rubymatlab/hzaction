<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vmBusProjectManagerList" checkbox="false" fitColumns="true" title="项目管理" sortName="createDate" actionUrl="vmBusProjectManagerController.do?datagrid&bpmStatus=${bpmStatus}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  dictionary="state" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bpmProjId"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpmProjName"  query="true" dictionary="bus_project_manager,id,bpm_name"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="bpmCustName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目经理"  field="bpmManager"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="应收总金额"  field="bpmReceAllAmou"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="已收总金额"  field="bpmReceAllAmouD"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目进度"  field="bpmProjProg"  queryMode="group"  dictionary="proj_prog"  width="120"></t:dgCol>
   <t:dgCol title="进度百分比"  field="bpmProgPer"  queryMode="group"  dictionary="proj_per"  width="120"></t:dgCol>
   <t:dgCol title="验收结果"  field="bpmCheckRes"   queryMode="group" dictionary="check_res" width="120"></t:dgCol>
   <t:dgCol title="验收时间"  field="bpmCheckDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="施工问题"  field="bpmQues"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="下一步计划"  field="bpmNextPlan"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目立项外键"  field="fromProjId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="客户资料外键"  field="fromCustId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="立项时间"  field="bpmCreDate"  formatter="yyyy-MM-dd"  hidden="true"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgToolBar title="项目跟进" icon="icon-edit" url="vmBusProjectManagerController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgDelOpt title="删除" url="vmBusProjectManagerController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="vmBusProjectManagerController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vmBusProjectManagerController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vmBusProjectManagerController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
   <c:if test="${bpmStatus == 0}">
   	<t:dgToolBar title="项目确认审核" icon="icon-edit"  url="vmBusProjectManagerController.do?doUpdateStatus" funname="doUpdateStatus" ></t:dgToolBar>
   </c:if>
   <c:if test="${bpmStatus == 1}">
   	<t:dgToolBar title="刷新" icon="icon-reload"  url="vmBusProjectManagerController.do?doReload" funname="doReload" ></t:dgToolBar>
   </c:if>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 	//自定义按钮-sql增强-项目确认审核
 	function doUpdateStatus(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择项目确认审核项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-刷新
 	function doReload(title,url,id){
/*  		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择刷新项目');
			return;
		}
		url = url+"&id="+rowData['id']; 
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 		*/
 		
 		$("#vmBusProjectManagerList").datagrid("reload");
 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vmBusProjectManagerController.do?upload', "vmBusProjectManagerList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vmBusProjectManagerController.do?exportXls","vmBusProjectManagerList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vmBusProjectManagerController.do?exportXlsByT","vmBusProjectManagerList");
}
 </script>
