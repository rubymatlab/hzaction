<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>合同管理</title>
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
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="busContractController.do?doAdd" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${busContractPage.id }"/>
					<input id="fromProjId" name="fromProjId" type="hidden" value="${busContractPage.fromProjId }"/>
					<input id="fromCustId" name="fromCustId" type="hidden" value="${busContractPage.fromCustId }"/>
					<input id="bcCustomerCode" name="bcCustomerCode" type="hidden" value="${busContractPage.bcCustomerCode }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		
		<tr>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
		     	 <input id="bcProjectCode" name="bcProjectCode" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" value='${busContractPage.bcProjectCode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">合同完成状态:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="bcContractState" type="list" readonly="readonly"   typeGroupCode="state"  defaultVal="${busContractPage.bcContractState}" hasLabel="false"  title="合同完成状态" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同完成状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td class="value">
		     	 <input id="fromProjName" name="fromProjName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" value='${busContractPage.fromProjName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户名称:</label>
			</td>
			<td class="value">
				<input id="bcCustomerName" name="bcCustomerName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"  value='${busContractPage.bcCustomerName}'/>			 
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">我方签约人:</label>
			</td>
			<td class="value">
		     	 <input id="bcCompContractor" name="bcCompContractor" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">我方签约人</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户签约人:</label>
			</td>
			<td class="value">
		     	 <input id="bcCustContractor" name="bcCustContractor" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户签约人</label>
			</td>
			</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">合同名称:</label>
			</td>
			<td class="value">
		     	 <input id="bcContractName" name="bcContractName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">签订时间:</label>
			</td>
			<td class="value">
					  <input id="bcConcludeTime" name="bcConcludeTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">签订时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">合同开始时间:</label>
			</td>
			<td class="value">
					  <input id="bcContStartTime" name="bcContStartTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同开始时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">合同结束时间:</label>
			</td>
			<td class="value">
					  <input id="bcContEndTime" name="bcContEndTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同结束时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">合同金额:</label>
			</td>
			<td class="value">
		     	 <input id="bcContAmount" name="bcContAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同金额</label>
			</td>
			<td align="right">
				<label class="Validform_label">管理费百分比:</label>
			</td>
			<td class="value">
		     	 <input id="bcManPer" name="bcManPer" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">管理费百分比</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">中标方:</label>
			</td>
			<td class="value">
		     	 <input id="bcWinBidder" name="bcWinBidder" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">中标方</label>
			</td>
			<td align="right">
				<label class="Validform_label">中标服务费:</label>
			</td>
			<td class="value">
		     	 <input id="bcWinSfee" name="bcWinSfee" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">中标服务费</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">安信金额:</label>
			</td>
			<td class="value">
		     	 <input id="bcActionAmount" name="bcActionAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">安信金额</label>
			</td>
			<td align="right">
				<label class="Validform_label">合同电子档:</label>
			</td>
			<td class="value">
		<div class="form jeecgDetail">
			<t:upload name="bcContractFile" id="bcContractFile" queueID="filediv_bcContractFile" outhtml="false" uploader="cgUploadController.do?saveFiles&bafAttachClass=1"  extend="office" buttonText='添加文件'  onUploadStart="bcContractFileOnUploadStart"> </t:upload>
			<div class="form" id="filediv_bcContractFile"></div>
			<script type="text/javascript">
				function bcContractFileOnUploadStart(file){
					var cgFormId=$("input[name='id']").val();
					$('#bcContractFile').uploadify("settings", "formData", {
						'cgFormId':cgFormId,
						'cgFormName':'bus_contract',
						'cgFormField':'BC_CONTRACT_FILE',
						'fileName':file.name
					});
				}
			</script>
		</div>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同电子档</label>
			</td>
		</tr>
	
	</table>
  
  </t:formvalid>
			
 </body>
 
 <script src = "webpage/com/action/actsale/busContract.js"></script>
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
				$('#bcContractFile').uploadify('upload', '*');
		}
		
		var neibuClickFlag = false;
		function neibuClick() {
			neibuClickFlag = true; 
			$('#btn_sub').trigger('click');
		}
		function cancel() {
				$('#bcContractFile').uploadify('cancel', '*');
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
	