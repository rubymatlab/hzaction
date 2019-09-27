<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>报价_投标审核</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <t:base type="uploadify"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vwBusBidController.do?doAdd" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden"/>
					<input id="fromProjId" name="fromProjId" type="hidden" value="${vwBusBidPage.fromProjId }"/>
					<input id="fromCustjId" name="fromCustjId" type="hidden" value="${vwBusBidPage.fromCustjId }"/>
					<input id="bdState" name="bdState" type="hidden" value="${vwBusBidPage.bdState }"/>
		<table style="width: 800px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value">
					     	 <input readonly="true" id="bpProjId" name="bpProjId" type="text" maxlength="40" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore" value='${vwBusBidPage.bpProjId}' />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目编号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							项目名称:
						</label>
					</td>
					<td class="value">
					     	 <input readonly="true" id="bpProjName" name="bpProjName" type="text" maxlength="200" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore" value='${vwBusBidPage.bpProjName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							客户名称:
						</label>
					</td>
					<td class="value">
					     	 <input readonly="true" id="bcName" name="bcName" type="text" maxlength="100" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore" value='${vwBusBidPage.bcName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户名称</label>
						</td>
					
					<td align="right">
						<label class="Validform_label">
							项目类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="bdProjType" name="bdProjType" type="text" maxlength="20" style="width: 150px;" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目类型</label>
						</td>
					
					</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							拟中标方:
						</label>
					</td>
					<td class="value">
					     	 <input id="bdWinBidder" name="bdWinBidder" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">拟中标方</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							投标预算:
						</label>
					</td>
					<td class="value">
					     	 <input id="bdBidAmout" name="bdBidAmout" type="text" maxlength="12" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">投标金额</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							投标日期:
						</label>
					</td>
					<td class="value">
							   <input id="bdBidDate" name="bdBidDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">投标日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							附件:
						</label>
					</td>
					<td class="value">
		<div class="form jeecgDetail">
			<t:upload name="bdFile" id="bdFile" queueID="filediv_bdFile" outhtml="false" uploader="cgUploadController.do?saveFiles"  extend="office" buttonText='添加文件'  onUploadStart="bdFileOnUploadStart"> </t:upload>
			<div class="form" id="filediv_bdFile"></div>
			<script type="text/javascript">
				function bdFileOnUploadStart(file){
					var cgFormId=$("input[name='id']").val();
					$('#bdFile').uploadify("settings", "formData", {
						'cgFormId':cgFormId,
						'cgFormName':'bus_bid',
						'cgFormField':'BD_FILE'
					});
				}
			</script>
		</div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">附件</label>
						</td>
					</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							投标内容:
						</label>
					</td>
					<td class="value"  colspan="3" >
						  	 <textarea style="height:auto;width:95%" class="inputxt" rows="6" id="bdBidContent" name="bdBidContent"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">投标内容</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value"  colspan="3" >
						  	 <textarea style="height:auto;width:95%" class="inputxt" rows="6" id="bdBidRemark" name="bdBidRemark"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
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
					$('#bdFile').uploadify('upload', '*');	
			}
			
			var neibuClickFlag = false;
			function neibuClick() {
				neibuClickFlag = true; 
				$('#btn_sub').trigger('click');
			}
			function cancel() {
					$('#bdFile').uploadify('cancel', '*');
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
