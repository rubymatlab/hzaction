<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>采购申请</title>
<style>
.ui-button {
	display: inline-block;
	padding: 2px 2px;
	margin-bottom: 0;
	font-size: 8px;
	font-weight: normal;
	line-height: 1.42857143;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 4px;
}
</style>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:base type="uploadify"></t:base>

<script type="text/javascript">
	
	function dealbpaApplyNo(BpProjId) {
		var url2 = "vwBusPoApplyController/creatBpProjId.do?type=project&BpProjId="
		$.ajax({
			method : "GET",
			url : url2 + BpProjId,
			success : function(res) {

				var data = JSON.parse(res);
				if (data.value.length == 0) {

					$("#bpaApplyNo").val(
							BpProjId + "-CG-001")
				} else {
					//最大的采购申请编号
					var bpa_apply_no = data.value[0].bpa_apply_no;
					//获取编号的后三位字符串

					var num = parseInt(bpa_apply_no
							.substring(
									bpa_apply_no.length - 3,
									bpa_apply_no.length)) + 1;

					var newnum = num + "";
					if (num < 10) {
						newnum = "00" + num;
					} else if (num < 100) {
						newnum = "0" + num;
					}
					//重新拼字符串，实现在原来的申请编号基础上加1；
					bpa_apply_no = bpa_apply_no
							.substring(
									0,
									bpa_apply_no.length - 3)
							+ newnum;

					$("#bpaApplyNo").val(bpa_apply_no);

				}

			},
			fail : function(err) {
				console.log(err)
			}
		})
	}
			
	$(document).ready(function() {

		$('#tt').tabs({
			onSelect : function(title) {
				$('#tt .panel-body').css('width', 'auto');
			}
		});
		$(".tabs-wrap").css('width', '100%');
	});
</script>

</head>
<body style="overflow-x: hidden;">
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" tiptype="1" action="vwBusPoApplyController.do?doAdd" callback="jeecgFormFileCallBack@Override">
		<input id="id" name="id" type="hidden" value="${vwBusPoApplyPage.id }" />
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right"><label class="Validform_label ">采购申请编号:</label>
				</td>
				<td class="value test"><input id="bpaApplyNo" name="bpaApplyNo"
					type="text" maxlength="40" style="width: 60%;background-color:#F0F0F0;" class="inputxt" readonly="readonly"
					ignore="ignore" /> <span class="Validform_checktip"></span></td>

				<td align="right"><label class="Validform_label">申请日期:</label>
				</td>
				<td class="value"><input id="bpaApplyDate" name="bpaApplyDate"
					type="text" style="width: 60%" class="Wdate"
					onClick="WdatePicker()" ignore="ignore" /> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">申请日期</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">项目名称:</label>
				</td>
				<td class="value">
					<div class="dropdown">
						<input type="text" class="inputxt " name="bpmName" id="bpmName"
							maxlength="50" ignore="ignore" style="width:300px;">
						<ul class="dropdown-menu" role="menu">
						</ul>
					</div>

				</td>

				<td align="right"><label class="Validform_label">项目编号:</label>
				</td>
				<td class="value"><input id="bpProjId" name="bpProjId"
					type="text" maxlength="40" style="width: 60%;background-color:#F0F0F0;" class="inputxt"
					ignore="ignore"  readonly="readonly"/> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">项目编号</label></td>

			</tr>

			<tr>
				<td align="right"><label class="Validform_label">收货人:</label></td>
				<td class="value"><input id="bpaRecPeople" name="bpaRecPeople"
					type="text" maxlength="40" style="width: 60%" class="inputxt"
					ignore="ignore" /> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">收货人</label></td>
				<td align="right"><label class="Validform_label">收货人电话:</label>
				</td>
				<td class="value"><input id="bpaRecTel" name="bpaRecTel"
					type="text" maxlength="40" style="width: 60%" class="inputxt"
					ignore="ignore" /> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">收货人电话</label></td>
			</tr>
			<tr >
				<td align="right"><label class="Validform_label">收货地址:
				</label></td>
				<td class="value" colspan="3"><input id="bpaRecAddr" name="bpaRecAddr"
					type="text" maxlength="200" style="width: 400px" class="inputxt"
					ignore="ignore" /> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">收货地址</label></td>
				</td>


			</tr>



		</table>
		<div style="overflow: scroll; width: auto; height: 300px;">
			<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
			<div style="width: 800px; height: 1px;"></div>
			<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				<t:tab
					href="vwBusPoApplyController.do?busPoApplyDetailList&id=${vwBusPoApplyPage.id}"
					icon="icon-search" title="采购申请明细" id="busPoApplyDetail"></t:tab>
			</t:tabs>
		</div>
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right"><label class="Validform_label">申请人:</label></td>
				<td class="value"><input id="bpaApplyPeople"
					name="bpaApplyPeople" type="text" maxlength="40"
					style="width: 60%" class="inputxt" ignore="ignore" /> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">申请人</label></td>
				<td align="right"><label class="Validform_label">单据状态:</label></td>
				<td class="value"><!-- <input id="bpaState" name="bpaState"
					type="text" maxlength="20" style="width: 60%" class="inputxt" readonly="readonly"
					ignore="ignore" /> -->
					<t:dictSelect readonly="readonly" field="bpaState" type="list"   typeGroupCode="bs_state"  defaultVal="0" hasLabel="false"  title="审核状态" ></t:dictSelect>
					 <span class="Validform_checktip"></span>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">采购申请附件:</label>
				</td>
				<td class="value">
					<div class="form jeecgDetail">
						<t:upload name="bpaFile" id="bpaFile" queueID="filediv_bpaFile"
							outhtml="false"
							uploader="vwBusPoApplyController.do?saveFiles"
							extend="office" buttonText='添加文件'
							onUploadStart="bpaFileOnUploadStart">
						</t:upload>
						<div class="form" id="filediv_bpaFile"></div>
						<script type="text/javascript">
							function bpaFileOnUploadStart(file) {
								var cgFormId = $("input[name='id']").val();
								console.log(cgFormId);
								$('#bpaFile').uploadify("settings", "formData",
										{
											'cgFormId' : cgFormId,
											'cgFormName' : 'bus_po_apply',
											'cgFormField' : 'BPA_FILE',
											'fileName':file.name
										});
							}
						</script>
					</div> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">采购申请附件</label>
				</td>

				<td class="value"></td>
				<td class="value"><input id="fromProjmId" name="fromProjmId"
					type="hidden" maxlength="32" style="width: 60%"
					class="inputxt" ignore="ignore" /> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">项目管理外键</label></td>
			</tr>

		</table>
		
		
	</t:formvalid>
	<!-- 添加 附表明细 模版 -->
	<table style="display: none">
		<tbody id="add_busPoApplyDetail_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width: 20px;" type="checkbox"
					name="ck" /></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].bpadName" maxlength="200"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore" />
					<label class="Validform_label" style="display: none;">名称</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].bpadBrand" maxlength="200"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore" />
					<label class="Validform_label" style="display: none;">品牌</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].bpadModel" maxlength="200"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore" />
					<label class="Validform_label" style="display: none;">型号</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].bpadNumber" maxlength="22"
					type="text" class="inputxt" style="width: 120px;"
					datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" /> <label
					class="Validform_label" style="display: none;">数量</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].bpadRemark" maxlength="500"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore" />
					<label class="Validform_label" style="display: none;">备注</label></td>
								<td align="left"><input
									name="busPoApplyDetailList[#index#].purchaseOrNot" maxlength="32"
									 type="text" class="inputxt" style="width: 120px;background-color:#F0F0F0;"
									ignore="ignore" readonly="readonly" value="未采购" /> <label class="Validform_label"
									style="display: none;">是否采购</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].fromId" maxlength="32"
					type=hidden class="inputxt" style="width: 120px;" ignore="ignore" />
					<label class="Validform_label" style="display: none;">采购申请外键</label></td>
			</tr>
		</tbody>
	</table>


</body>
<script src="webpage/com/action/actpo/vwBusPoApply.js"></script>
<script src = "webpage/com/action/actpo/dropdown.js"></script>
<script type="text/javascript">

$("#bpaState").val("制作中");//将新增的单据状态设置为“制作中”
$(document).ready(function() {
	$("#bpmName").combogrid({
		panelWidth: 500,
		idField: "bpmName",
		textField: "bpmName",
		url: "busProjectManagerController.do?datagrid&field=fromProjId,bpmProjId,bpmName",
		columns: [[
			{field:'bpmProjId',title:'项目编号',width:80},
			{field:'bpmName',title:'项目名称',width:80},
		]],
		onSelect:function(row,data){
			$("#bpProjId").val(data.bpmProjId);
			$("#fromProjmId").val(data.fromProjId);
			dealbpaApplyNo(data.bpmProjId);
		},
		fitColumns: true
	})
})



//--------------------------------------------------------
	function jeecgFormFileCallBack(data) {
		if (data.success == true) {
			
			uploadFile(data);
		} else {
			if (data.responseText == '' || data.responseText == undefined) {
				$.messager.alert('错误', data.msg);
				$.Hidemsg();
			} else {
				try {
					var emsg = data.responseText
							.substring(data.responseText.indexOf('错误描述'),
									data.responseText.indexOf('错误信息'));
					$.messager.alert('错误', emsg);
					$.Hidemsg();
				} catch (ex) {
					$.messager.alert('错误', data.responseText + '');
				}
			}
			return false;
		}
		if (!neibuClickFlag) {
			var win = frameElement.api.opener;
			win.reloadTable();
		}
	}
	function upload() {
		$('#bpaFile').uploadify('upload', '*');
	}

	var neibuClickFlag = false;
	function neibuClick() {
		neibuClickFlag = true;
		$('#btn_sub').trigger('click');
	}
	function cancel() {
		$('#bpaFile').uploadify('cancel', '*');
	}
	function uploadFile(data) {
		
			
				$("input[name='id']").val(data.obj.id);
				console.log(data.obj.id);
		
		if ($(".uploadify-queue-item").length > 0) {
			upload();
		} else {
			if (neibuClickFlag) {
				alert(data.msg);
				neibuClickFlag = false;
			} else {
				var win = frameElement.api.opener;
				win.reloadTable();
				win.tip(data.msg);
				frameElement.api.close();
			}
		}
	}
</script>