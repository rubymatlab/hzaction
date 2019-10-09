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
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vwBusBidController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${vwBusBidPage.id }"/>
		<table style="width: 680px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目编号:
							</label>
						</td>
						<td class="value">
						    <input id="bpProjId" readonly="true"  name="bpProjId" type="text" maxlength="40" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore"  value='${vwBusBidPage.bpProjId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目编号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								项目名称:
							</label>
						</td>
						<td class="value">
						    <input id="bpProjName" readonly="true" name="bpProjName" type="text" maxlength="200" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore"  value='${vwBusBidPage.bpProjName}'/>
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
						    <input id="bcName" readonly="true"  name="bcName" type="text" maxlength="100" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore"  value='${vwBusBidPage.bcName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								拟中标方:
							</label>
						</td>
						<td class="value">
						    <input id="bdWinBidder" readonly="true"  name="bdWinBidder" type="text" maxlength="40" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore"  value='${vwBusBidPage.bdWinBidder}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">拟中标方</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目类型:
							</label>
						</td>
						<td class="value">
						    <input id="bdProjType" readonly="true"  name="bdProjType" type="text" maxlength="20" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore"  value='${vwBusBidPage.bdProjType}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目类型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								投标预算:
							</label>
						</td>
						<td class="value">
						    <input id="bdBidAmout" readonly="true" name="bdBidAmout" type="text" maxlength="12" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vwBusBidPage.bdBidAmout}'/>
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
									  <input id="bdBidDate" readonly="true" name="bdBidDate" type="text" style="width: 150px;background-color:#F0F0F0;"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vwBusBidPage.bdBidDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">投标日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								审核状态:
							</label>
						</td>
						<td class="value">
						    <%-- <input id="bdState" readonly="true" name="bdState" type="text" maxlength="20" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore"  value='${vwBusBidPage.bdState}'/> --%>
							<t:dictSelect readonly="readonly" field="bdState" type="list"   typeGroupCode="state"  defaultVal="${vwBusBidPage.bdState}" hasLabel="false"  title="审核状态" ></t:dictSelect> 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核状态</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								主标人员:
							</label>
						</td>
						<td class="value">
						    <input id="bdMainBidder" name="bdMainBidder" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusBidPage.bdMainBidder}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">主标人员</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								配合人员:
							</label>
						</td>
						<td class="value">
						    <input id="bdCoordinator" name="bdCoordinator" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusBidPage.bdCoordinator}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">配合人员</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								商务负责人:
							</label>
						</td>
						<td class="value">
						    <input id="bdBusinessCharge" name="bdBusinessCharge" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusBidPage.bdBusinessCharge}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商务负责人</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								辅助人员:
							</label>
						</td>
						<td class="value">
						    <input id="bdAuxiliaryStaff" name="bdAuxiliaryStaff" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusBidPage.bdAuxiliaryStaff}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">辅助人员</label>
						</td>
					</tr>
					
					<tr>
						<td align="right">
							<label class="Validform_label">
								附件:
							</label>
						</td>
						<td class="value">
		<table id="bd_file_fileTable"></table>
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
				<td align="right">
						<label class="Validform_label">
							项目成本:
						</label>
					</td>
					<td class="value">
					     	 <input id="bdProjCost" name="bdProjCost" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" value='${vwBusBidPage.bdProjCost}' />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目成本</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								投标内容:
							</label>
						</td>
						<td class="value"  colspan="3" >
						  	 	<textarea id="bdBidContent" style="height:auto;width:95%;background-color:#F0F0F0;" class="inputxt" rows="6" name="bdBidContent"  ignore="ignore" >${vwBusBidPage.bdBidContent}</textarea>
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
						  	 	<textarea id="bdBidRemark" style="height:auto;width:95%;" class="inputxt" rows="6" name="bdBidRemark"  ignore="ignore" >${vwBusBidPage.bdBidRemark}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
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
		  		   url: "vwBusBidController.do?getFiles&id=" +  cgFormId,
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
