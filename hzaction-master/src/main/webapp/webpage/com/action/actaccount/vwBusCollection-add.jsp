<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目收款单视图</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <t:base type="uploadify"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vwBusCollectionController.do?doAdd" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${vwBusCollectionPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目名称:
						</label>
					</td>
					<td class="value">
					     	 	<input id="bpmProjName" class="easyui-combogrid" style="width:150px" data-options="
			            panelWidth: 500,
			            idField: 'bpmProjName',
			            textField: 'bpmProjName',	
			            url: 'vmBusProjectManagerController.do?datagrid&field=id,bpmProjName,bpmProjId,bpmCustName',
			            columns: [[
			             {field:'bpmProjName',title:'项目名称',width:80},
	               		{field:'bpmProjId',title:'项目编号',width:80},
						
						]],
						onSelect: function (row,data) {
			            	$('#bpmProjId').val(data.bpmProjId);
			            	$('#bcCustContractor').val(data.bpmCustName),
			            	$('#fromProjmId').val(data.id)
			            	changeStager();
			            	createBCollectId(data.bpmProjId,data.id)
					    },
						 fitColumns: true
			        ">	
					<input type="hidden" id="fromProjmId" name="fromProjmId" ignore="ignore" class="inputxt">			        
			        <span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="bpmProjId" name="bpmProjId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目编号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							客户:
						</label>
					</td>
					<td class="value">
					     	 <input id="bcCustContractor" name="bcCustContractor" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							收款单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="bcCollectId" name="bcCollectId"  type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款单号</label>
						</td>	
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							进度款分期:
						</label>
					</td>
					<td class="value">
							<input id="bcProgressStages" name="bcProgressStages"  type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">进度款分期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							开票税率:
						</label>
					</td>
					<td class="value">
						<t:dictSelect field="bcTaxPer" type="list"  typeGroupCode="bc_tax_pe"  defaultVal="${vwBusCollectionPage.bcTaxPer}" hasLabel="false"  title="开票税率" ></t:dictSelect>     
						
						 <span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开票税率</label>
						</td>
					</tr>
					<tr>
						
						<td align="right">
						<label class="Validform_label">
							预计回款金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="brpBackAmount" name="brpBackAmount" readonly="readonly" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预计回款金额</label>
						</td>
						<td align="right">
						<label class="Validform_label">
							预计回款时间:
						</label>
					</td>
					<td class="value">
							   <input id="brpExtBackDate"  name="brpExtBackDate" type="text" disabled="disabled" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预计回款时间</label>
						</td>
					</tr>
				<tr>
					
					<td align="right">
						<label class="Validform_label">
							开票金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="bcInvAmount" name="bcInvAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开票金额</label>
						</td>
						<td align="right">
						<label class="Validform_label">
							开票时间:
						</label>
					</td>
					<td class="value">
							   <input id="bcInvoiceDate" name="bcInvoiceDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开票时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收款金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="bcColAmount" name="bcColAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款金额</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							收款时间:
						</label>
					</td>
					<td class="value">
							   <input id="bcColDate" name="bcColDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							文件:
						</label>
					</td>
					<td class="value" colspan="3">
		<div class="form jeecgDetail">
			<t:upload name="bcFile" id="bcFile" queueID="filediv_bcFile" outhtml="false" uploader="cgUploadController.do?saveFiles"  extend="office" buttonText='添加文件'  onUploadStart="bcFileOnUploadStart"> </t:upload>
			<div class="form" id="filediv_bcFile"></div>
			<script type="text/javascript">
				function bcFileOnUploadStart(file){
					var cgFormId=$("input[name='id']").val();
					$('#bcFile').uploadify("settings", "formData", {
						'cgFormId':cgFormId,
						'cgFormName':'bus_collection',
						'cgFormField':'BC_FILE'
					});
				}
			</script>
		</div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文件</label>
						</td>
							</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							回款状态:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="bcColState" type="list"  typeGroupCode="bc_back"  defaultVal="${vwBusCollectionPage.bcColState}" hasLabel="false"  title="回款状态" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">回款状态</label>
						</td>
				
					
						
					<!-- 	<td align="right">
						<label class="Validform_label">
							创建人登录名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="createBy" name="createBy"  type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人登录名称</label>
						</td> -->

					</tr>
			<!-- 	<tr>
					<td align="right">
						<label class="Validform_label">
							支付方式:
						</label>
					</td>
					<td class="value">
					     	 <input id="bpiPayMethod" name="bpiPayMethod" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">支付方式</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							银行帐号:
						</label>
					</td>
					<td class="value">
					     	 <input id="bbaiAccountNo" name="bbaiAccountNo" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">银行帐号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							费用类别:
						</label>
					</td>
					<td class="value">
					     	 <input id="bpiFeeType" name="bpiFeeType" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用类别</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							费用明细:
						</label>
					</td>
					<td class="value">
					     	 <input id="bpiFeeDetail" name="bpiFeeDetail" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用明细</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							支付时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="bpiPayDate" name="bpiPayDate" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">支付时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							内容:
						</label>
					</td>
					<td class="value">
					     	 <input id="bpiContent" name="bpiContent" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内容</label>
						</td>
					</tr> -->
				<!-- <tr>
					<td align="right">
						<label class="Validform_label">
							凭证号:
						</label>
					</td>
					<td class="value">
					     	 <input id="bpiVoucherno" name="bpiVoucherno" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">凭证号</label>
						</td>
					<td align="right">
					
					</tr>
				 -->
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value"  colspan="3" >
						  	 <textarea style="height:auto;width:95%" class="inputxt" rows="6" id="bcRemark" name="bcRemark"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
  <script src = "webpage/com/action/actpo/dropdown.js"></script>
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
					$('#bcFile').uploadify('upload', '*');	
			}
			
			var neibuClickFlag = false;
			function neibuClick() {
				neibuClickFlag = true; 
				$('#btn_sub').trigger('click');
			}
			function cancel() {
					$('#bcFile').uploadify('cancel', '*');
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
			changeStager();
			function changeStager(){
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
			}
			var bpmProjIdList = []
			$.get("vwBusCollectionController.do?datagrid&field=bpmProjId,fromProjmId",function(row){
				bpmProjIdList = row.rows;
			})
			function createBCollectId(projID,fromId){
				var num = 1;
				bpmProjIdList.forEach(function(item){
					if(item.fromProjmId == fromId){
						num++
					}
				})
				$("#bcCollectId").val(projID+"-SK-"+("00"+num).slice(-3))
			}
			
	  	</script>
 </body>