<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vmBusPoPayWmtList" checkbox="true" fitColumns="true" title="采购付款单视图_wmt" sortName="createDate" actionUrl="vmBusPoPayWmtController.do?datagrid&state=${state }" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   
   
   <t:dgCol title="项目管理外键"  field="fromProjId" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bpmProjId" hidden="true" queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="项目名称"  field="bpmName"  query="true"  queryMode="single"  dictionary="bus_project_manager,bpmName,bpm_name"  popup="true"  width="120"></t:dgCol>
   
   <t:dgCol title="付款单号"  field="bppPayId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="供应商资料外键"  field="fromSuppId" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="供应商编号"  field="bsId" hidden="true" queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="供应商名称"  field="bsName"  query="true"  queryMode="single"  dictionary="bas_supplier,bsName,bs_name"  popup="true"  width="120"></t:dgCol>
   
   <t:dgCol title="付款金额"  field="bppMoney"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单据状态"  field="bppState"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发票金额"  field="bppInvAmount" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发票类型"  field="bppInvType" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="税率百分比"  field="bppTaxRate" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="实际付款时间"  field="bppPayDate" hidden="true" formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="附件"  field="bppAccessory" hidden="true" queryMode="single"  downloadName="附件下载"  width="120"></t:dgCol>
   
   
   <!-- 工具栏 -->
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="vmBusPoPayWmtController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="新增" icon="icon-add" url="vmBusPoPayWmtController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="修改" icon="icon-edit" url="vmBusPoPayWmtController.do?goUpdate&pay=0" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vmBusPoPayWmtController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <!-- 状态改为2 -->
   <t:dgToolBar title="送审" icon="icon-edit"  url="vmBusPoPayWmtController.do?doSendAudit" funname="doSendAudit" ></t:dgToolBar>
   <!-- 状态改为3 -->
   <t:dgToolBar title="审核完成" icon="icon-edit"  url="vmBusPoPayWmtController.do?doAuditFinish" funname="doAuditFinish" ></t:dgToolBar>
   <!-- 支付 -->
   <t:dgToolBar title="支付" icon="icon-edit" url="vmBusPoPayWmtController.do?goUpdate&pay=1" funname="update" width="100%" height="100%"></t:dgToolBar>
   
   <%--<t:dgToolBar title="查看" icon="icon-search" url="vmBusPoPayWmtController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 
 <!-- 模糊下拉搜索 -->
 <script>
 changeStager()
 function changeStager(){
	 $("#bpmName").combogrid({
	     panelWidth: 150,
	     idField: "brpProgressStages",
	     textField: "brpProgressStages",
	     url: "vmBusCollectPlanController.do?datagrid&fromId="+$('#fromProjmId').val()+"&field=id,brpProgressStages,brpBackAmount,brpExtBackDate,fromId",
	     columns: [[
	              {field:'brpProgressStages',title:'进度款分期' , width:80},   
	     ]],
	     onSelect: function(row, data){
	      $("#brpExtBackDate").val(data.brpExtBackDate)
	      $("#brpBackAmount").val(data.brpBackAmount)
	     },
	     fifle:function(q,row){
	      console.log(q)
	      console.log(row)
	     },
	     fitColumns: true
	    })
 }
 $("#bcProgressStages").combogrid({
     panelWidth: 150,
     idField: "brpProgressStages",
     textField: "brpProgressStages",
     url: "vmBusCollectPlanController.do?datagrid&fromId="+$('#fromProjmId').val()+"&field=id,brpProgressStages,brpBackAmount,brpExtBackDate,fromId",
     columns: [[
              {field:'brpProgressStages',title:'进度款分期' , width:80},   
     ]],
     onSelect: function(row, data){
      $("#brpExtBackDate").val(data.brpExtBackDate)
      $("#brpBackAmount").val(data.brpBackAmount)
     },
     fifle:function(q,row){
      console.log(q)
      console.log(row)
     },
     fitColumns: true
    })
 </script>
 <script type="text/javascript">
 	//自定义按钮-sql增强-审核完成
 	function doAuditFinish(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择审核完成项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-送审
 	function doSendAudit(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择送审项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vmBusPoPayWmtController.do?upload', "vmBusPoPayWmtList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vmBusPoPayWmtController.do?exportXls","vmBusPoPayWmtList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vmBusPoPayWmtController.do?exportXlsByT","vmBusPoPayWmtList");
}
 </script>
