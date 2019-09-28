<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="bsSubmitList" checkbox="true" fitColumns="true" title="费用报销" sortName="createDate" actionUrl="bsSubmitController.do?datagrid&bsstate=1" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="projectName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="projectId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="报销人"  field="bsSubmiter"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="报销单号"  field="bsSubmitId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="部门"  field="bsDept"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请日期"  field="bsBeginDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="报销日期"  field="bsSubmitDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bsRemarks"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="票据类型"  field="bsBillType"  hidden="true"  queryMode="single"  dictionary="bill_type"  width="120"></t:dgCol>
   <t:dgCol title="单据状态"  field="bsState"  hidden="true"  queryMode="single"  dictionary="bs_state"  width="120"></t:dgCol>
   <t:dgCol title="报销总金额"  field="totalMoney"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="报销总金额大写"  field="totalMoneyCn"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="附件"  field="bsAnnex"  hidden="true"  queryMode="single"  downloadName="附件下载"  width="120"></t:dgCol>
   <t:dgCol title="项目管理外键"  field="fromProjmId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="bsSubmitController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="bsSubmitController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="bsSubmitController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <%-- <t:dgToolBar title="批量删除"  icon="icon-remove" url="bsSubmitController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
   <t:dgToolBar title="查看" icon="icon-search" url="bsSubmitController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <%-- <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <%-- <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%> 
   	<t:dgToolBar title="审核完成" icon="icon-edit"  url="bsSubmitController.do?doAudited" funname="doAudited" ></t:dgToolBar>
   	
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 	//自定义按钮-sql增强-送审
 	function doUnaudited(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择送审项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-审核完成
 	function doAudited(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择审核完成项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-支付
 	function doPay(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择支付项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-打印
 	function doPrint(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择打印项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'bsSubmitController.do?upload', "bsSubmitList");
}

//导出
function ExportXls() {
	JeecgExcelExport("bsSubmitController.do?exportXls","bsSubmitList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("bsSubmitController.do?exportXlsByT","bsSubmitList");
}
 </script>
