<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vwBusBidList" checkbox="true" pagination="true" fitColumns="true" title="报价_投标审核" sortName="createDate" actionUrl="vwBusBidController.do?datagrid&bdState=0" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="项目编号"  field="bpProjId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="bpProjName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目经理"  field="bpManager"  query="true"  queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="投标预算"  field="bdBidAmout"  queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="投标日期"  field="bdBidDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="商务负责人"  field="bdBusinessCharge"  queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="主标人员"  field="bdMainBidder" queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="配合人员"  field="bdCoordinator" queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="辅助人员"  field="bdAuxiliaryStaff" queryMode="single"  width="60"></t:dgCol>
   
  
   <t:dgCol title="立项时间"  field="bpDate"  formatter="yyyy-MM-dd"  hidden="true"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="客户编号"  field="bcId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="bcName" hidden="true" query="true"  queryMode="single"  dictionary="bas_customer,bc_name,bc_name"  width="120"></t:dgCol>
   <t:dgCol title="客户简称"  field="bcSname"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="拟中标方"  field="bdWinBidder"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目类型"  field="bdProjType"  hidden="true"  dictionary="bp_type1" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="投标内容"  field="bdBidContent"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="bdState"  hidden="true"  queryMode="single"  dictionary="state"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bdBidRemark" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目立项外键"  field="fromProjId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户资料外键"  field="fromCustjId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="附件"  field="bdFile" hidden="true" queryMode="single"  downloadName="附件下载"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <%-- <t:dgDelOpt title="打回" url="vwBusBidController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
	<t:dgFunOpt title="打回" funname="doReturn(id)"  urlclass="ace_button" urlfont="fa-trash-o"></t:dgFunOpt>
	<t:dgFunOpt funname="doVerifyBtn(id)" title="通过" urlclass="ace_button" urlfont="fa-wrench" />
   <%-- <t:dgToolBar title="新建" icon="icon-add" url="vwBusBidController.do?goAdd" funname="add"></t:dgToolBar> --%>
	<t:dgToolBar title="编辑" icon="icon-edit" url="vwBusBidController.do?goUpdate" funname="update"></t:dgToolBar>
   <%-- <t:dgToolBar title="批量删除"  icon="icon-remove" url="vwBusBidController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
   <t:dgToolBar title="查看" icon="icon-search" url="vwBusBidController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%-- <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <%-- <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
 function doReturn(id){
		var url="vwBusBidController.do?doDel";
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
			        vwBusBidListsearch();
		        }  
		    });  
		}, function(){
		});
	}
     	//自定义按钮-审核
	 	function doVerifyBtn(id,index){
	 	    var url = "vwBusBidController.do?doVerifyBtn";
			url = url+"&id="+id;
	 		createdialog('确认 ', '确定通过审核吗 ?', url,'vwBusBidList');
	 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vwBusBidController.do?upload', "vwBusBidList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vwBusBidController.do?exportXls","vwBusBidList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vwBusBidController.do?exportXlsByT","vwBusBidList");
}

 </script>
