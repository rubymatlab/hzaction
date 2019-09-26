<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<script type="text/javascript">



</script>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding: 0px; border: 0px">
		<t:datagrid name="vwBusPoApplyList" checkbox="true" fitColumns="true"
			title="采购申请" sortName="createDate"
			actionUrl="vwBusPoApplyController.do?datagrid&state=2" idField="id"
			fit="true" queryMode="group">
			<t:dgCol title="主键" field="id" hidden="true" queryMode="single"
				width="120"></t:dgCol>
			<t:dgCol title="创建人名称" field="createName" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="创建人登录名称" field="createBy" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd"
				hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="更新人名称" field="updateName" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="更新人登录名称" field="updateBy" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="更新日期" field="updateDate" formatter="yyyy-MM-dd"
				hidden="true" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="所属部门" field="sysOrgCode" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="所属公司" field="sysCompanyCode" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="流程状态" field="bpmStatus" hidden="true"
				queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>
			<t:dgCol title="收货人" field="bpaRecPeople" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="收货人电话" field="bpaRecTel" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="收货地址" field="bpaRecAddr" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="单据状态" field="bpaState" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="项目管理外键" field="fromProjmId" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="名称" field="bpadName" hidden="true" queryMode="single"
				width="120"></t:dgCol>
			<t:dgCol title="品牌" field="bpadBrand" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="型号" field="bpadModel" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="数量" field="bpadNumber" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="备注" field="bpadRemark" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="项目编号" field="bpProjId" queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="项目名称" field="bpmName" query="true" queryMode="single" 
				width="120" dictionary="bpm_name_msg,bpmName,bpm_name"  popup="true"></t:dgCol>
			<t:dgCol title="采购申请编号" field="bpaApplyNo" queryMode="single"
				width="120"></t:dgCol>
			<t:dgCol title="申请人" field="bpaApplyPeople" queryMode="single"
				width="120"></t:dgCol>
			<t:dgCol title="客户名称" field="bcName" hidden="true" query="true"
				queryMode="single" width="120" dictionary="msg_customerName,bcName,bc_name"  popup="true" ></t:dgCol>
			<t:dgCol title="项目经理" field="bpManager" hidden="true" query="true" dictionary="msg_managerName,bpManager,bp_manager"  popup="true"  
				queryMode="single" width="120"></t:dgCol>

			<t:dgCol title="申请日期" field="bpaApplyDate" formatter="yyyy-MM-dd"
				query="true" queryMode="group" width="120"></t:dgCol>
			<t:dgCol title="采购申请外键" field="fromId" hidden="true"
				queryMode="single" width="120"></t:dgCol>


			<t:dgCol title="采购申请明细外键" field="fromPoApplyDetId" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="项目管理id" field="busProjectManagerId" hidden="true"
				queryMode="single" width="120"></t:dgCol>
			<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
			
		
			<t:dgToolBar title="查看" icon="icon-search"
				url="vwBusPoApplyController.do?goUpdate" funname="detail"
				width="100%" height="100%"></t:dgToolBar>
			
		</t:datagrid>
	</div>
</div>
<script src="webpage/com/action/actpo/dropdown.js">
$(function(){ 
	  
	$("#vwBusPoApplyListForm input[name=bpmName]").addClass("easyui-combogrid").attr("data-options",
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
		
})
</script>
<script type="text/javascript">
	//自定义按钮-sql增强-审核完成
	function doBtn_shwc(title, url, id) {

		var rowData = $('#' + id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择审核完成项目');
			alert("请选择审核完成项目");
			return;
		}
		url = url + "&id=" + rowData['id'];
		$.dialog.confirm('你确定要宬成项目审核吗?', function(r) {
			if (r) {
				$.ajax({
					url : url,
					type : 'post',
					data : {

					},
					cache : false,
					success : function(data) {
						var d = $.parseJSON(data);
						if (d.success) {
							var msg = d.msg;
							alert(msg);
						}
					}
				});
			}
		})
	}
	//自定义按钮-sql增强-送审
	function doBtn_submit(title, url, id) {
		var rowData = $('#' + id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择送审项目');
			alert("请选择送审项目");
			return;
		}
		url = url + "&id=" + rowData['id'];
		$.dialog.confirm('你确定要宬成项目审核吗?', function(r) {
			if (r) {
				$.ajax({
					url : url,
					type : 'post',
					data : {

					},
					cache : false,
					success : function(data) {
						var d = $.parseJSON(data);
						if (d.success) {
							var msg = d.msg;
							alert(msg);
						}
					}
				});
			}
		})
	}

	//导入
	function ImportXls() {
		openuploadwin('Excel导入', 'vwBusPoApplyController.do?upload',
				"vwBusPoApplyList");
	}

	//导出
	function ExportXls() {
		JeecgExcelExport("vwBusPoApplyController.do?exportXls",
				"vwBusPoApplyList");
	}

	//模板下载
	function ExportXlsByT() {
		JeecgExcelExport("vwBusPoApplyController.do?exportXlsByT",
				"vwBusPoApplyList");
			
	}
	
	
</script>
