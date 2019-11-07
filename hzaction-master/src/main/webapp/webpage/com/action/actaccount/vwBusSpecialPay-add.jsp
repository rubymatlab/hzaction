<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>零星支出单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <t:base type="uploadify"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  function createBsspSmspId(bsspSmspId){
		//报销单号,传入项目编号
		$.ajax({
			type : "POST",　　　　　　　　　　　
			url : 'vwBusSpecialPayController.do?doBsspSmspId',　　　　　 
			data: {bpProjId:bsspSmspId},　　　　　　
			success : function(data) {
				var temp = jQuery.parseJSON(data);
				$("#bsspSmspId").val(temp.msg);
			},
			error:function(){
				tip("产生报销单号错误！");
			}
		})
		
	  }
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vwBusSpecialPayController.do?doAdd" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${vwBusSpecialPayPage.id }"/>
					<input id="fromProjmId" name="fromProjmId" type="hidden" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore" />
					<input id="fromSuppId" name="fromSuppId" type="hidden" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore" />
		<table style="width: 680px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsspSmspId" name="bsspSmspId" readonly="true" type="text" maxlength="40" style="width: 200px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							单据类型:
						</label>
					</td>
					<td class="value">
					     	<t:dictSelect field="bsspType" type="radio"  typeGroupCode="bill_type"   defaultVal="0" hasLabel="false"  title="单据类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单据类型</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申请人:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsspApplyPeople" name="bsspApplyPeople" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							申请日期:
						</label>
					</td>
					<td class="value">
							   <input id="bsspApplyDate" name="bsspApplyDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							付款内容:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsspContent" name="bsspContent" type="text" maxlength="400" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款内容</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							发票金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsspInvAmount" name="bsspInvAmount" type="text" maxlength="12" style="width: 150px" class="inputxt"  datatype="d" ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发票金额</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							支付类型:
						</label>
					</td>
					<td class="value">
					     	 <!-- <input id="bsspPayType" name="bsspPayType" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
							<t:dictSelect field="bsspPayType" type="list"  typeGroupCode="bus_pa_way"  hasLabel="false" defaultVal="1"  title="支付方式"></t:dictSelect> 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">支付类型</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							发票类型:
						</label>
					</td>
					<td class="value">
					     	 <t:dictSelect field="bsspInvType" type="list"  typeGroupCode="bc_invoice"  defaultVal="1" hasLabel="false"  title="发票类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发票类型</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							税率:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsspTax" name="bsspTax" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">税率</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							收款人开户行:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsspRecBank" name="bsspRecBank" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款人开户行</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收款单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsspRecCompany" name="bsspRecCompany" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款单位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							委托收款人:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsspEntrustRec" name="bsspEntrustRec" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">委托收款人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收款账号:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsspRecAccNo" name="bsspRecAccNo" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款账号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							请求支付日期:
						</label>
					</td>
					<td class="value">
							   <input id="bsspApplyPayDate" name="bsspApplyPayDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请求支付日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							付款金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsspPayAmount" name="bsspPayAmount" type="text" maxlength="12" style="width: 150px" class="inputxt"  datatype="d" ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款金额</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							单据状态:
						</label>
					</td>
					<td class="value">
					     	 <!-- <input id="bsspState" name="bsspState" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
							<t:dictSelect readonly="readonly" field="bsspState" type="list"   typeGroupCode="bs_state"  defaultVal="0" hasLabel="false"  title="审核状态" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单据状态</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="bpProjId" name="bpProjId" readonly="readonly" type="text" maxlength="40" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目编号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							项目名称:
						</label>
					</td>
					<td class="value">
					     	 <!-- <input id="bpProjName" name="bpProjName" type="text" maxlength="200" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
							
							<input id="bpProjName" name="bpProjName" type="text" maxlength="100" style="width: 150px" class="easyui-combogrid"  ignore="ignore"
						     	 data-options="panelWidth: 500,
						     	 idField: 'bpmProjName',
						     	 textField: 'bpmProjName',
						     	 url: 'vmBusProjectManagerController.do?datagrid&field=id,fromProjId,bpmProjId,bpmProjName,bpmManager',
						     	 columns: [[ 
					                {field:'bpmProjId',title:'项目编号',width:80}, 
					                {field:'bpmProjName',title:'项目名称',width:120} , 
					                {field:'bpmManager',title:'项目经理',width:120} 
				                ]],
				                onSelect: function (row,data) {
				                	$('#fromProjmId').val(data.fromProjId);
				                	$('#bpProjId').val(data.bpmProjId);
				                	$('#bpManager').val(data.bpmManager);
				                	createBsspSmspId(data.bpmProjId);
								},
				                fitColumns: true" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目经理:
						</label>
					</td>
					<td class="value">
					     	 <input id="bpManager" name="bpManager" type="text" readonly="readonly"  maxlength="40" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目经理</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							供应商名称:
						</label>
					</td>
					<td class="value">
					     	 <!-- <input id="bsName" name="bsName" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
							<input id="bsName" name="bsName" type="text" maxlength="100" style="width: 150px" class="easyui-combogrid"  ignore="ignore"
						     	 data-options="panelWidth: 500,
						     	 idField: 'bsName',
						     	 textField: 'bsName',
						     	 url: 'basSupplierController.do?datagrid&field=id,bsId,bsSname,bsName',
						     	 columns: [[ 
					                {field:'bsId',title:'供应商编号',width:80}, 
					                {field:'bsSname',title:'供应商简称',width:120} , 
					                {field:'bsName',title:'供应商名称',width:120} 
				                ]],
				                onSelect: function (row,data) {
				                	$('#fromSuppId').val(data.id);
								},
				                fitColumns: true" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供应商名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							附件:
						</label>
					</td>
					<td class="value" colspan="3">
		<div class="form jeecgDetail">
			<t:upload name="bsspFile" id="bsspFile" queueID="filediv_bsspFile" outhtml="false" uploader="cgUploadController.do?saveFiles"  extend="office" buttonText='添加文件'  onUploadStart="bsspFileOnUploadStart"> </t:upload>
			<div class="form" id="filediv_bsspFile"></div>
			<script type="text/javascript">
				function bsspFileOnUploadStart(file){
					var cgFormId=$("input[name='id']").val();
					$('#bsspFile').uploadify("settings", "formData", {
						'cgFormId':cgFormId,
						'cgFormName':'vw_bus_special_pay',
						'cgFormField':'BSSP_FILE'
					});
				}
			</script>
		</div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">附件</label>
						</td>
				<!-- <td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td> -->
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
	  	<script type="text/javascript">
	  		function jeecgFormFileCallBack(data){
	  			if (data.success == true) {
					uploadFile(data);
				} else {
					if (data.responseText == '' || data.responseText == undefined) {
						$.messager.alert('错误', data.msg);
						$.Hidemsg();
					} else {
						try {
							var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
							$.messager.alert('错误', emsg);
							$.Hidemsg();
						} catch(ex) {
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
					$('#bsspFile').uploadify('upload', '*');	
			}
			
			var neibuClickFlag = false;
			function neibuClick() {
				neibuClickFlag = true; 
				$('#btn_sub').trigger('click');
			}
			function cancel() {
					$('#bsspFile').uploadify('cancel', '*');
			}
			function uploadFile(data){
				if(!$("input[name='id']").val()){
					if(data.obj!=null && data.obj!='undefined'){
						$("input[name='id']").val(data.obj.id);
					}
				}
				if($(".uploadify-queue-item").length>0){
					upload();
				}else{
					if (neibuClickFlag){
						alert(data.msg);
						neibuClickFlag = false;
					}else {
						var win = frameElement.api.opener;
						win.reloadTable();
						win.tip(data.msg);
						frameElement.api.close();
					}
				}
			}
	  	</script>
