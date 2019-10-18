<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="busContractList" checkbox="true" fitColumns="true" title="合同管理" sortName="createDate" actionUrl="busContractController.do?datagrid&contractState=0" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="客户编号"  field="bcCustomerCode"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="bcCustomerName"  query="true"  queryMode="single"  dictionary="bas_customer ,bcCustomerName,bc_name"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bcProjectCode"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合同名称"  field="bcContractName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="fromProjName" hidden="true" query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="签订时间"  field="bcConcludeTime"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合同开始时间"  field="bcContStartTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合同结束时间"  field="bcContEndTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合同完成状态"  field="bcContractState" hidden="true" queryMode="group"  dictionary="state"  width="120"></t:dgCol>
   <t:dgCol title="我方签约人"  field="bcCompContractor" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <%-- <t:dgCol title="合同金额万元"  field="bcContAmount" width="120"></t:dgCol> --%>
   <%-- <t:dgCol title="项目立项外键"  field="fromProjId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="客户资料外键"  field="fromCustId" hidden="true" queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="客户签约人"  field="bcCustContractor" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="管理费百分比"  field="bcManPer" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="中标方"  field="bcWinBidder" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="中标服务费"  field="bcWinSfee" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="安信金额"  field="bcActionAmount" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合同电子档"  field="bcContractFile" hidden="true" queryMode="single"  downloadName="附件下载"  width="120"></t:dgCol>
   
   <!-- 工具栏 -->
   <t:dgCol title="操作" field="opt" width="0"></t:dgCol>
   <t:dgToolBar title="合同维护" icon="icon-edit" url="busContractController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="合同确定" icon="icon-save"  url="busContractController.do?affirmButton" funname="affirmButton" ></t:dgToolBar>
   <t:dgToolBar title="汇出excel" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
	<%--<t:dgDelOpt title="删除" url="busContractController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>--%>
   <%-- <t:dgToolBar title="录入" icon="icon-add" url="busContractController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="busContractController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="busContractController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
//自定义按钮-sql增强-测试button
	function affirmButton(title,url,id){
		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择合同');
			return;
		}
		var rowsDataS = $('#'+id).datagrid('getSelections');
		if (rowsDataS.length>1) {
			tip('请选择一条记录');
			return;
		}
		url = url+"&id="+rowData['id'];
		bc_createdialog('确认 ', title+'吗 ?', url,gridname);
	}

	/**
	 * 创建询问窗口
	 * 
	 * @param title
	 * @param content
	 * @param url
	 * @param noShade 不赋值则有遮罩
	 */

	function bc_createdialog(title, content, url,name,noShade) {
		$.dialog.setting.zIndex = getzIndex(true);
//		$.dialog.confirm(content, function(){
//			doSubmit(url,name);
//			rowid = '';
//		}, function(){
//		});

		var navigatorName = "Microsoft Internet Explorer"; 

		if( navigator.appName == navigatorName ||"default,shortcut".indexOf(getCookie("JEECGINDEXSTYLE"))>=0){ 

			$.dialog.confirm(content, function(){
				doSubmit(url,name);
				rowid = '';
			}, function(){
			});
		}else{
			layer.open({
				title:title,
				content:content,
				icon:7,
				shade: !noShade?0.3:0,
				yes:function(index){
					doSubmit(url,name);
					rowid = '';
					
				},
				btn:['确定','取消'],
				btn2:function(index){
					layer.close(index);
				}
			});
		}

	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'busContractController.do?upload', "busContractList");
}

//导出
function ExportXls() {
	console.log(0)
	JeecgExcelExport("busContractController.do?exportXls&contractState=0","busContractList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("busContractController.do?exportXlsByT","busContractList");
}
 </script>
