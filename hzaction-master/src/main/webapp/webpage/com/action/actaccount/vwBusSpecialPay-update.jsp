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
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vwBusSpecialPayController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${vwBusSpecialPayPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								单号:
							</label>
						</td>
						<td class="value">
						    <input id="bsspSmspId" name="bsspSmspId" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspSmspId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								单据类型:
							</label>
						</td>
						<td class="value">
						    <input id="bsspType" name="bsspType" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspType}'/>
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
						    <input id="bsspApplyPeople" name="bsspApplyPeople" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspApplyPeople}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								申请日期:
							</label>
						</td>
						<td class="value">
									  <input id="bsspApplyDate" name="bsspApplyDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vwBusSpecialPayPage.bsspApplyDate}' type="date" pattern="yyyy-MM-dd"/>'/>
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
						    <input id="bsspContent" name="bsspContent" type="text" maxlength="400" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspContent}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款内容</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								发票金额:
							</label>
						</td>
						<td class="value">
						    <input id="bsspInvAmount" name="bsspInvAmount" type="text" maxlength="12" style="width: 150px" class="inputxt"  datatype="d" ignore="ignore"  value='${vwBusSpecialPayPage.bsspInvAmount}'/>
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
						    <input id="bsspPayType" name="bsspPayType" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspPayType}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">支付类型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								发票类型:
							</label>
						</td>
						<td class="value">
						    <input id="bsspInvType" name="bsspInvType" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspInvType}'/>
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
						    <input id="bsspTax" name="bsspTax" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspTax}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">税率</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								收款人开户行:
							</label>
						</td>
						<td class="value">
						    <input id="bsspRecBank" name="bsspRecBank" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspRecBank}'/>
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
						    <input id="bsspRecCompany" name="bsspRecCompany" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspRecCompany}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款单位</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								委托收款人:
							</label>
						</td>
						<td class="value">
						    <input id="bsspEntrustRec" name="bsspEntrustRec" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspEntrustRec}'/>
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
						    <input id="bsspRecAccNo" name="bsspRecAccNo" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspRecAccNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款账号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								请求支付日期:
							</label>
						</td>
						<td class="value">
									  <input id="bsspApplyPayDate" name="bsspApplyPayDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vwBusSpecialPayPage.bsspApplyPayDate}' type="date" pattern="yyyy-MM-dd"/>'/>
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
						    <input id="bsspPayAmount" name="bsspPayAmount" type="text" maxlength="12" style="width: 150px" class="inputxt"  datatype="d" ignore="ignore"  value='${vwBusSpecialPayPage.bsspPayAmount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								单据状态:
							</label>
						</td>
						<td class="value">
						    <input id="bsspState" name="bsspState" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsspState}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单据状态</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目管理外键:
							</label>
						</td>
						<td class="value">
						    <input id="fromProjmId" name="fromProjmId" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.fromProjmId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目管理外键</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								供应商资料外键:
							</label>
						</td>
						<td class="value">
						    <input id="fromSuppId" name="fromSuppId" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.fromSuppId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供应商资料外键</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目编号:
							</label>
						</td>
						<td class="value">
						    <input id="bpProjId" name="bpProjId" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bpProjId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目编号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								项目名称:
							</label>
						</td>
						<td class="value">
						    <input id="bpProjName" name="bpProjName" type="text" maxlength="200" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bpProjName}'/>
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
						    <input id="bpManager" name="bpManager" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bpManager}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目经理</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								供应商名称:
							</label>
						</td>
						<td class="value">
						    <input id="bsName" name="bsName" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusSpecialPayPage.bsName}'/>
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
						<td class="value">
		<table id="bssp_file_fileTable"></table>
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
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
	  	<script type="text/javascript">
		  	//加载 已存在的 文件
		  	$(function(){
	  			var cgFormId=$("input[name='id']").val();
		  		$.ajax({
		  		   type: "post",
		  		   url: "vwBusSpecialPayController.do?getFiles&id=" +  cgFormId,
		  		   success: function(data){
		  			 var arrayFileObj = jQuery.parseJSON(data).obj;
		  			 
		  			$.each(arrayFileObj,function(n,file){
		  				var fieldName = file.field.toLowerCase();
		  				var table = $("#"+fieldName+"_fileTable");
		  				var tr = $("<tr style=\"height:34px;\"></tr>");
		  				var title = file.title;
		  				if(title.length > 15){
		  					title = title.substring(0,12) + "...";
		  				}
		  				var td_title = $("<td>" + title + "</td>");
		  		  		var td_download = $("<td><a style=\"margin-left:10px;\" href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
		  		  		var td_view = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
		  		  		tr.appendTo(table);
		  		  		td_title.appendTo(tr);
		  		  		td_download.appendTo(tr);
		  		  		td_view.appendTo(tr);
		  		  		if(location.href.indexOf("load=detail")==-1){
			  		  		var td_del = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0)\" class=\"jeecgDetail\" onclick=\"del('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
			  		  		td_del.appendTo(tr);
		  		  		}
		  			 });
		  		   }
		  		});
		  	});
		  	
		  	/**
		 	 * 删除图片数据资源
		 	 */
		  	function del(url,obj){
		  		var content = "请问是否要删除该资源";
		  		var navigatorName = "Microsoft Internet Explorer"; 
		  		if( navigator.appName == navigatorName ){ 
		  			$.dialog.confirm(content, function(){
		  				submit(url,obj);
		  			}, function(){
		  			});
		  		}else{
		  			layer.open({
						title:"提示",
						content:content,
						icon:7,
						yes:function(index){
							submit(url,obj);
						},
						btn:['确定','取消'],
						btn2:function(index){
							layer.close(index);
						}
					});
		  		}
		  	}
		  	
		  	function submit(url,obj){
		  		$.ajax({
		  			async : false,
		  			cache : false,
		  			type : 'POST',
		  			url : url,// 请求的action路径
		  			error : function() {// 请求失败处理函数
		  			},
		  			success : function(data) {
		  				var d = $.parseJSON(data);
		  				if (d.success) {
		  					var msg = d.msg;
		  					tip(msg);
		  					obj.parentNode.parentNode.parentNode.deleteRow(obj.parentNode.parentNode);
		  				} else {
		  					tip(d.msg);
		  				}
		  			}
		  		});
		  	}
		  	
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