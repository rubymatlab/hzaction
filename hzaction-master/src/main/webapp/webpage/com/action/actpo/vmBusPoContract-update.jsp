<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>采购合同视图</title>
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
  <t:base type="jquery,easyui,tools,DatePicker,uploadify"></t:base>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="vmBusPoContractController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${vmBusPoContractPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">采购合同编号:</label>
			</td>
			<td class="value">
		     	 <input id="bpcPoNo" name="bpcPoNo" type="text" disabled="disabled" maxlength="32" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusPoContractPage.bpcPoNo}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购合同编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
				<input id="fromProjId" name="fromProjId" type="hidden"  value='${vmBusPoContractPage.fromProjmId}'/>
		     	 <input id="bpmProjId" name="bpmProjId" type="text" disabled="disabled" maxlength="32" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusPoContractPage.bpmProjId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td class="value">
		     	 <input id="bpmProjName" name="bpmProjName" type="text" disabled="disabled" maxlength="50" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusPoContractPage.bpmProjName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">供应商:</label>
			</td>
			<td class="value">
		     	 <input id="bsName" name="bsName" type="text" maxlength="100" disabled="disabled" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusPoContractPage.bsName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">采购是否已完成:</label>
			</td>
			<td class="value">
		     	 <input id="bpcPoOver" name="bpcPoOver" type="text" maxlength="32" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusPoContractPage.bpcPoOver}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购是否已完成</label>
			</td>
			<td align="right">
				<label class="Validform_label">供应商联系人:</label>
			</td>
			<td class="value">
		     	 <input id="bsContact" name="bsContact" type="text" disabled="disabled" maxlength="32" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusPoContractPage.bsContact}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商联系人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">收货人:</label>
			</td>
			<td class="value">
		     	 <input id="bpcRecPeople" name="bpcRecPeople" type="text" maxlength="32" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusPoContractPage.bpcRecPeople}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收货人</label>
			</td>
			<td align="right">
				<label class="Validform_label">供应商联系人电话:</label>
			</td>
			<td class="value">
		     	 <input id="bsTelNo" name="bsTelNo" type="text" maxlength="32" disabled="disabled" style="width: 60%" class="inputxt"  datatype="m" ignore="ignore"  value='${vmBusPoContractPage.bsTelNo}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商联系人电话</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">收货人电话:</label>
			</td>
			<td class="value">
		     	 <input id="bpcRecTel" name="bpcRecTel" type="text" maxlength="32" style="width: 60%" class="inputxt"  datatype="m" ignore="ignore"  value='${vmBusPoContractPage.bpcRecTel}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收货人电话</label>
			</td>
			<td align="right">
				<label class="Validform_label">收货地址:</label>
			</td>
			<td class="value">
		     	 <input id="bpcRecAddr" name="bpcRecAddr" type="text" maxlength="100" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusPoContractPage.bpcRecAddr}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收货地址</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">采购员:</label>
			</td>
			<td class="value">
		     	 <input id="bpcPoPeople" name="bpcPoPeople" type="text" maxlength="32" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusPoContractPage.bpcPoPeople}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购员</label>
			</td>
			<td align="right">
				<label class="Validform_label">采购日期:</label>
			</td>
			<td class="value">
					  <input id="bpcPoDate" name="bpcPoDate" type="text" style="width: 60%" class="Wdate"  ignore="ignore" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value='<fmt:formatDate value='${vmBusPoContractPage.bpcPoDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">采购情况汇报:</label>
			</td>
			<td class="value" colspan="3"> 
				<textarea  id="bpSitReport" style="height:auto;width:95%;" class="inputxt" rows="6" name="bpSitReport"  ignore="ignore" >${vmBusPoContractPage.bpSitReport}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购情况汇报</label>
			</td>
		</tr>
	<tr>
			<td align="right">
				<label class="Validform_label">附件:</label>
			</td>
			<td class="value" colspan="3">
				<table id="baf_path_fileTable"></table>
				<div class="form jeecgDetail">
					<t:upload name="bafPath" id="bafPath" queueID="filediv_bafPath" outhtml="false" 
						uploader="cgUploadController.do?saveFiles&bafAttachClass=4"  extend="office" buttonText='添加文件'  onUploadStart="busPoContractFileOnUploadStart"> </t:upload>
					<div class="form" id="filediv_bafPath"></div>
					<script type="text/javascript">
						function busPoContractFileOnUploadStart(file){
							var cgFormId=$("input[name='id']").val();
							$('#bafPath').uploadify("settings", "formData", {
								'cgFormId':cgFormId,
								'cgFormName':'bas_attach_file',
								'cgFormField':'BAF_PATH',
								'fileName':file.name
							});
						}
					</script>
				</div>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">附件</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				<t:tab href="vmBusPoContractController.do?vmMergeBusPoApplyDetailList&id=${vmBusPoContractPage.id}" icon="icon-search" title="采购申请明细" id="vmMergeBusPoApplyDetail"></t:tab>
				 <t:tab href="vmBusPoContractController.do?busPoContractPayList&id=${vmBusPoContractPage.id}" icon="icon-search" title="采购合同付款明细" id="busPoContractPay"></t:tab>
				 <t:tab href="vmBusPoContractController.do?busPoContractDetailList&id=${vmBusPoContractPage.id}" icon="icon-search" title="采购合同明细" id="busPoContractDetail"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_vmMergeBusPoApplyDetail_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="vmMergeBusPoApplyDetailList[#index#].bpadName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">名称</label>
				  </td>
				  <td align="left">
					  		<input name="vmMergeBusPoApplyDetailList[#index#].bpadBrand" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">品牌</label>
				  </td>
				  <td align="left">
					  		<input name="vmMergeBusPoApplyDetailList[#index#].bpadModel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">型号</label>
				  </td>
				  <td align="left">
					  		<input name="vmMergeBusPoApplyDetailList[#index#].bpadNumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  		<input name="vmMergeBusPoApplyDetailList[#index#].bpadRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left">
					  		<input name="vmMergeBusPoApplyDetailList[#index#].fromId" maxlength="32" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				  </td> 
				  <td align="left">
					  		<input name="vmMergeBusPoApplyDetailList[#index#].fromPoApplyDetId" maxlength="32" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购申请外键</label>
				  </td> 
			</tr>
		 </tbody>
		<tbody id="add_busPoContractPay_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
							<t:dictSelect field="busPoContractPayList[#index#].bpcpProgre" type="list"   typeGroupCode="cost_stag"  defaultVal="" hasLabel="false"  title="费用分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用分期</label>
				  </td>
				  <td align="left">
					  		<input name="busPoContractPayList[#index#].bpcpPayAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划付款金额</label>
				  </td>
				  <td align="left">
							<input name="busPoContractPayList[#index#].bpcpDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划付款日期</label>
				  </td>
 				  <td align="left">
					  		<input name="busPoContractPayList[#index#].fromId" maxlength="32" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				  </td> 
			</tr>
		 </tbody>
		<tbody id="add_busPoContractDetail_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
							<t:dictSelect field="busPoContractDetailList[#index#].bpcdPayType" type="list"   typeGroupCode="cost_type"  defaultVal="" hasLabel="false"  title="费用类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类型</label>
				  </td>
				  <td align="left">
					  		<input name="busPoContractDetailList[#index#].bpcdName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">名称</label>
				  </td>
				  <td align="left">
					  		<input name="busPoContractDetailList[#index#].bpcdBrand" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">品牌</label>
				  </td>
				  <td align="left">
					  		<input name="busPoContractDetailList[#index#].bpcdModel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">型号</label>
				  </td>
				  <td align="left">
					  		<input name="busPoContractDetailList[#index#].bpcdNumber" maxlength="32" type="text" class="inputxt" datatype="/^(-?\d+)(\.\d+)?$/" style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  		<input name="busPoContractDetailList[#index#].bpcdPrice" maxlength="32" type="text" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/" style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  		<input name="busPoContractDetailList[#index#].bpcdAmount" maxlength="32" type="text" class="inputxt" readonly="readonly"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">金额</label>
				  </td>
				  <td align="left">
					  		<input name="busPoContractDetailList[#index#].bpcdRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left">
					  		<input name="busPoContractDetailList[#index#].fromId" maxlength="32" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actpo/vmBusPoContract.js"></script>	
 <script src = "webpage/com/action/actpo/dropdown.js"></script>
 
 	  	<script type="text/javascript">
		  	//加载 已存在的 文件
		  	$(function(){
	  			var cgFormId=$("input[name='id']").val();
		  		$.ajax({
		  		   type: "post",
		  		   url: "vmBusPoContractController.do?getFiles&id=" +  cgFormId,
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
		  		  		var td_download = $("<td><a style=\"margin:0px 5px;\" href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
		  		  		var td_view = $("<td><a style=\"margin:0px 5px;\" href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
		  		  		tr.appendTo(table);
		  		  		td_title.appendTo(tr);
		  		  		td_download.appendTo(tr);
		  		  		td_view.appendTo(tr);
		  		  		if(location.href.indexOf("load=detail")==-1){
			  		  		var td_del = $("<td><a style=\"margin:0px 5px;\" href=\"javascript:void(0)\" class=\"jeecgDetail\" onclick=\"del('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
			  		  		td_del.appendTo(tr);
		  		  		}
		  			 });
		  		   }
		  		});
	  			
	  			// 获取项目管理的外键id
	  			window.projectId = $("#fromProjId").val();
	  			console.log(window.projectId)
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
		  					obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
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
					$('#bafPath').uploadify('upload', '*');	
			}
			
			var neibuClickFlag = false;
			function neibuClick() {
				neibuClickFlag = true; 
				$('#btn_sub').trigger('click');
			}
			function cancel() {
					$('#bafPath').uploadify('cancel', '*');	
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
 