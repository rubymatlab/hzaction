<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwBusProjectList" checkbox="true" fitColumns="true" title="项目立项" sortName="createDate" actionUrl="vwBusProjectController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目经理"  field="bpManager"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpProjName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="方案输出时间"  field="bpOutTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="方案定稿时间"  field="bpFinishTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="正式挂网时间"  field="bpOnlineTime"  formatter="yyyy-MM-dd hh:mm:ss"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="产品解决方案"  field="bpProSolutions"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="问题or协助"  field="bpQuestions"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus" dictionary="bpm_status"  queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="项目编号"  field="bpProjId" hidden="true"   query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="立项时间"  field="bpDate" hidden="true"   formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目关键人"  field="bpKeyPeople" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目简介"  field="bpIntroduction" hidden="true"   queryMode="single"  width="500"></t:dgCol>
   <t:dgCol title="竞争情况"  field="bpCompetition" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目组成员"  field="bpTeam" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="跟进结果"  field="bpFollowResults" hidden="true"   query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户资料外键"  field="fromCustId" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户编号"  field="bcId" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="bcName" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" exp="bpmStatus#eq#1" url="vwBusProjectController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="vwBusProjectController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="vwBusProjectController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vwBusProjectController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vwBusProjectController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
   	<t:dgToolBar title="立项转投标" icon="icon-edit"  url="vwBusBidController.do?goAdd" funname="doBid" ></t:dgToolBar>
   	<t:dgToolBar title="立项转合同" icon="icon-edit"  url="busContractController.do?goAdd" funname="doContract" ></t:dgToolBar>
   	<t:dgToolBar title="转已失败" icon="icon-edit"  url="vwBusProjectController.do?doFail" funname="doFail" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 	//自定义按钮-sql增强-立项转投标
 	function doBid(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择立项转投标项目');
			return;
		}
		if(rowData['bpmStatus']=="1")
		{
			url = url+"&fromProjId="+rowData['id'];
	 		createwindow(title,url,800,500);
		}
		else
			tip('该项目已转投标、合同');
 	}
 	//自定义按钮-sql增强-立项转合同
 	function doContract(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择立项转合同项目');
			return;
		}
		if(rowData['bpmStatus']=="1")
		{
			url = url+"&fromProjId="+rowData['id'];
			createwindow(title,url,800,500);
		}
		else
			tip('该项目已转投标、合同');
	}
 	
 	//自定义按钮-sql增强-转已失败
 	function doFail(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择转失败项目');
			return;
		}
		if(rowData['bpmStatus']=="4")
		{
			tip('该项目已转失败');
			return;
		}else
		{
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
		}
 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vwBusProjectController.do?upload', "vwBusProjectList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vwBusProjectController.do?exportXls","vwBusProjectList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vwBusProjectController.do?exportXlsByT","vwBusProjectList");
}
 </script>
