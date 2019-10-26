<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwBusSpecialPayList" checkbox="true" pagination="true" fitColumns="true" title="零星支出单" sortName="createDate" actionUrl="vwBusSpecialPayController.do?datagrid&bpmStatus=2" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="单号"  field="bsspSmspId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单据类型"  field="bsspType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请人"  field="bsspApplyPeople"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请日期"  field="bsspApplyDate"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="付款内容"  field="bsspContent"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发票金额"  field="bsspInvAmount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="支付类型"  field="bsspPayType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发票类型"  field="bsspInvType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="税率"  field="bsspTax"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收款人开户行"  field="bsspRecBank"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收款单位"  field="bsspRecCompany"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="委托收款人"  field="bsspEntrustRec"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收款账号"  field="bsspRecAccNo"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="请求支付日期"  field="bsspApplyPayDate"  formatter="yyyy-MM-dd"  hidden="true"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="付款金额"  field="bsspPayAmount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单据状态"  field="bsspState"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目管理外键"  field="fromProjmId"  queryMode="single" hidden="true"   width="120"></t:dgCol>
   <t:dgCol title="供应商资料外键"  field="fromSuppId"  queryMode="single" hidden="true"   width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bpProjId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpProjName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目经理"  field="bpManager"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="供应商名称"  field="bsName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="附件"  field="bsspFile"  queryMode="single"  downloadName="附件下载"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <%-- <t:dgDelOpt title="删除" url="vwBusSpecialPayController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
	<t:dgFunOpt title="驳回" funname="doReturn(id)"  urlclass="ace_button" urlfont="fa-trash-o"></t:dgFunOpt>
   <%--<t:dgFunOpt funname="doConfirm(id)" title="确认" urlclass="ace_button" urlfont="fa-wrench" />
    <t:dgToolBar title="录入" icon="icon-add" url="vwBusSpecialPayController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="vwBusSpecialPayController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vwBusSpecialPayController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
   <t:dgToolBar title="查看" icon="icon-search" url="vwBusSpecialPayController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%-- <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <%-- <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
     	<t:dgToolBar title="通过" icon="icon-edit"  url="vwBusSpecialPayController.do?doConfirm" funname="doConfirm" ></t:dgToolBar>
     	<%-- <t:dgToolBar title="支付" icon="icon-edit"  url="vwBusSpecialPayController.do?doPay" funname="doPay" ></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
 function doReturn(id){
		var tabName= 'bsSubmitListtb';
		var url="vwBusSpecialPayController.do?doReturn";
		url = url+"&id="+id;
		$.dialog.confirm('确定驳回吗？', function(){
			jQuery.ajax({  
		        async : false,  
		        cache:false,  
		        type: 'GET',  
		        dataType : "json",
		        url: url,//请求的action路径  
		        error: function () {//请求失败处理函数  
		            tip('请求失败');  
		        },  
		        success:function(data){ //请求成功后处理函数。
				    if(data.success){
				    	tip(data.msg);
				    }else{
				    	tip(data.msg);
				    }
			        //重新查询
			        vwBusSpecialPayListsearch();
		        }  
		    });  
		}, function(){
		});
	}
 
     	//自定义按钮-送审
	 	function doAccess(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择送审项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
     	//自定义按钮-支付
	 	function doPay(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择支付项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
   
		//自定义按钮-确认
	 	function doConfirm(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择通过项目');
				return;
			}
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vwBusSpecialPayController.do?upload', "vwBusSpecialPayList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vwBusSpecialPayController.do?exportXls","vwBusSpecialPayList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vwBusSpecialPayController.do?exportXlsByT","vwBusSpecialPayList");
}

 </script>
