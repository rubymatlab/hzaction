<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>采购付款单视图</title>
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
  function handleInput()
	{
		 var totalM=0.0;
		 var trList = $("#add_vmBusPoContractPayWmt_table").children("tr");
		 for (var i=0;i<trList.length;i++) {
		      var tdArr = trList.eq(i).find("td");
		      var totalmoney = tdArr.eq(7).find('input').val();//付款金额 
		      if(!(totalmoney=="" || totalmoney==null))
		      	totalM=parseFloat(totalM)+parseFloat(totalmoney);
		 }
		 $('#bppMoney').val(totalM);
	}
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="vmBusPoPayWmtController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${vmBusPoPayWmtPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable" >
		<tr>
			<td align="right">
				<label class="Validform_label">付款单号:</label>
			</td>
			<td class="value" colspan="7">
		     	 <input id="bppPayId" name="bppPayId" type="text" maxlength="32" disabled="disabled" style="width: 80%" class="inputxt"  ignore="ignore"  value='${vmBusPoPayWmtPage.bppPayId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">付款单号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目名称<b style="color:red">*</b> :</label>
			</td>
			<td class="value">
					<input id="bpmName" name="bpmName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"   
					onclick="popupClick(this,'bpm_name,bpm_proj_id,id','bpmName,bpmProjId,fromProjId','bus_project_manager')"  value='${vmBusPoPayWmtPage.bpmName}'/>			    
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
		     	 <input id="bpmProjId" name="bpmProjId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vmBusPoPayWmtPage.bpmProjId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">供应商名称<b style="color:red">*</b> :</label>
			</td>
			<td class="value">
					<input id="bsName" name="bsName" type="text" style="width: 150px" 
					class="searchbox-inputtext"  ignore="ignore"   onclick="popupClick(this,'bs_name,bs_id,id','bsName,bsId,fromSuppId','bas_supplier')"  value='${vmBusPoPayWmtPage.bsName}'/>			    
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">供应商编号:</label>
			</td>
			<td class="value">
		     	 <input id="bsId" name="bsId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vmBusPoPayWmtPage.bsId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商编号</label>
			</td>
			
		</tr>
		<tr >
			<td align="right">
				<label class="Validform_label">项目管理外键:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="fromProjId" name="fromProjId" type="text" maxlength="32" style="width: 80%" class="inputxt"  ignore="ignore"  value='${vmBusPoPayWmtPage.fromProjId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目管理外键</label>
			</td>
			<td align="right">
				<label class="Validform_label">供应商资料外键:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="fromSuppId" name="fromSuppId" type="text" maxlength="32" style="width: 80%" class="inputxt"  ignore="ignore"  value='${vmBusPoPayWmtPage.fromSuppId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商资料外键</label>
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<label class="Validform_label">发票类型:</label>
			</td>
			<td class="value">
		     	 <input id="bppInvType" name="bppInvType" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vmBusPoPayWmtPage.bppInvType}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发票类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">实际付款时间:</label>
			</td>
			<td class="value">
					  <input id="bppPayDate" name="bppPayDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" ignore="ignore"  value='<fmt:formatDate value='${vmBusPoPayWmtPage.bppPayDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">实际付款时间</label>
			</td>
			<td align="right" hidden="hidden">
				<label class="Validform_label">采购总金额:</label>
			</td>
			<td class="value" hidden="hidden">
		     	 <input id="bppMoneySum" name="bppMoneySum" type="text" maxlength="32" placeholder="自动计算" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购总金额</label>
			</td>
			
			<td align="right">
				<label class="Validform_label">单据状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="bppState" type="list"  typeGroupCode="bs_state"  defaultVal="${vmBusPoPayWmtPage.bppState}" hasLabel="false" readonly="readonly" title="单据状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">单据状态</label>
			</td>
			<td align="right">
				<label class="Validform_label">税率%:</label>
			</td>
			<td class="value">
		     	 <input id="bppTaxRate" name="bppTaxRate" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vmBusPoPayWmtPage.bppTaxRate}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">税率百分比</label>
			</td>
		</tr>
		
		<tr>
			<td align="right" hidden="hidden">
				<label class="Validform_label">发票未开金额:</label>
			</td>
			<td class="value" hidden="hidden">
		     	 <input id="bppInvAmountNot" name="bppInvAmountNot" placeholder="自动计算" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发票未开金额</label>
			</td>
			<td align="right">
				<label class="Validform_label">付款金额:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="bppMoney" name="bppMoney" type="text" maxlength="32" readonly="true" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore"  value='${vmBusPoPayWmtPage.bppMoney}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">付款金额</label>
			</td>
			<td align="right">
				<label class="Validform_label">发票金额:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="bppInvAmount" name="bppInvAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vmBusPoPayWmtPage.bppInvAmount}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发票金额</label>
			</td>
		</tr>
		<tr>
		<td align="right">
				<label class="Validform_label">附件:</label>
			</td>
		<td class="value" colspan="7">
		<table id="bpp_accessory_fileTable"></table>
		<div class="form jeecgDetail">
			<t:upload name="bppAccessory" id="bppAccessory" queueID="filediv_bppAccessory" outhtml="false" 
				uploader="cgUploadController.do?saveFiles&bafAttachClass=4"  extend="office" buttonText='添加文件'  onUploadStart="bppAccessoryOnUploadStart"> </t:upload>
			<div class="form" id="filediv_bppAccessory"></div>
			<script type="text/javascript">
				function bppAccessoryOnUploadStart(file){
					var cgFormId=$("input[name='id']").val();
					$('#bppAccessory').uploadify("settings", "formData", {
						'cgFormId':cgFormId,
						'cgFormName':'vm_bus_po_pay_wmt',
						'cgFormField':'BPP_ACCESSORY',
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
				 <c:if test="${pay==0 }">
				 	<t:tab href="vmBusPoPayWmtController.do?vmBusPoContractPayWmtList&id=${vmBusPoPayWmtPage.id}" icon="icon-search" title="采购付款单" id="vmBusPoContractPayWmt"></t:tab>
				 </c:if>
				 <c:if test="${pay==1 }">
				 	<t:tab href="vmBusPoPayWmtController.do?busPayInfoList&id=${vmBusPoPayWmtPage.id}" icon="icon-search" title="财务支付" id="busPayInfo"></t:tab>
				 </c:if>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_vmBusPoContractPayWmt_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="vmBusPoContractPayWmtList[#index#].bpcPoNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购合同编号</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="vmBusPoContractPayWmtList[#index#].bpcpProgre" type="list"   typeGroupCode="cost_stag"  hasLabel="false"  title="费用分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用分期</label>
				  </td>
				  <td align="left">
					  		<input name="vmBusPoContractPayWmtList[#index#].bpcpPayAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划付款金额</label>
				  </td>
				  <td align="left">
							<input name="vmBusPoContractPayWmtList[#index#].bpcpDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划付款日期</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="vmBusPoContractPayWmtList[#index#].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				  </td>
				  <td align="left">
					  		<input name="vmBusPoContractPayWmtList[#index#].payAmount" maxlength="32" type="text" class="inputxt" onchange="handleInput()" style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">付款金额</label>
				  </td>
				  <td align="left">
					  		<input name="vmBusPoContractPayWmtList[#index#].bpcpRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="vmBusPoContractPayWmtList[#index#].busPoPayId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购付款单外键</label>
				  </td>
				   <td align="left" hidden="hidden">
					  	<input name="vmBusPoContractPayWmtList[#index#].bpcpId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  />
					  <label class="Validform_label" style="display: none;">采购付款单明细附表外键</label>
				   </td>
			</tr>
		 </tbody>
		 
		 <!-- 添加 财务支付信息 模版 -->
		<tbody id="add_busPayInfo_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="busPayInfoList[#index#].bpiClass" maxlength="30" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"/>
					  <label class="Validform_label" style="display: none;">功能分类</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="busPayInfoList[#index#].bpiPayMethod" type="list" typeGroupCode="bus_pa_way"  defaultVal="" hasLabel="false"  title="支付方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">支付方式</label>
				  </td>
				  <td align="left">
							<input name="busPayInfoList[#index#].bpiPayDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">支付时间</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="busPayInfoList[#index#].bpiFeeType" type="list" typeGroupCode="cost_type"  defaultVal="" hasLabel="false"  title="费用类别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类别</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="busPayInfoList[#index#].bpiFeeDetail"  type="list"   typeGroupCode="bc_fee_dtl"  defaultVal=""  hasLabel="false"  title="费用明细"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用明细</label>
				  </td>
				  <td align="left">
					  		<input name="busPayInfoList[#index#].bpiContent" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">内容</label>
				  </td>
				  <td align="left">
					  		<input name="busPayInfoList[#index#].bpiVoucherno" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">凭证号</label>
				  </td>
				  
				  <td align="left">
					  		<input name="busPayInfoList[#index#].bpiBusId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">业务外键</label>
				  </td>
				  <td align="left">
					  		<input name="busPayInfoList[#index#].fromProjmId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目管理外键</label>
				  </td>
				  <td align="left">
					  		<input name="busPayInfoList[#index#].fromBankAccId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">银行账号信息外键</label>
				  </td>
				  <td align="left">
					  	<input name="busPayInfoList[#index#].bbaiSname" name="busPayInfoList[#index#].bbaiSname" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"    onclick="popupClick(this,'bbai_sname,id','bbaiSname,fromBankAccId','ax_bas_bank_account_info')" value="${poVal.bbaiSname }" />
					  <label class="Validform_label" style="display: none;">账号简称</label>
				  </td>
				  <td align="left">
					  	<input name="busPayInfoList[#index#].fromPayId" name="busPayInfoList[#index#].fromPayId" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore" value="${poVal.fromPayId }" />
					  <label class="Validform_label" style="display: none;">采购付款单外键</label>
				  </td>
				  
				 <!--  <td align="left">
						<input type="hidden" id="busPayInfoList[#index#].bpiAccessory" name="busPayInfoList[#index#].bpiAccessory" />
					    <input class="ui-button" type="button" value="上传附件" name="busPayInfoList[#index#].imgBtn"
								onclick="commonUpload(commonUploadDefaultCallBack,'busPayInfoList\\[#index#\\]\\.bpiAccessory')"/>
						<a  target="_blank" id="busPayInfoList[#index#].bpiAccessory_href"></a>
					  <label class="Validform_label" style="display: none;">附件</label>
				  </td> -->
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actaccount/vmBusPoPayWmt.js"></script>	
  	<script type="text/javascript">
	  	//加载 已存在的 文件
	  	$(function(){
	  		var cgFormId=$("input[name='id']").val();
	  		$.ajax({
	  		   type: "post",
	  		   url: "vmBusPoPayWmtController.do?getFiles&id=" +  cgFormId,
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
	  	})
	  	
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
//		  					obj.parentNode.parentNode.parentNode.deleteRow(obj.parentNode.parentNode);
		  					//wmt
		  					var tbody = document.getElementById("bpp_accessory_fileTable").firstChild;
		  			  		var delDom = obj.parentNode.parentNode;
		  			  		tbody.removeChild(delDom)
		  					//wmt
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
					$('#bppAccessory').uploadify('upload', '*');
				
		}
		
		var neibuClickFlag = false;
		function neibuClick() {
			neibuClickFlag = true; 
			$('#btn_sub').trigger('click');
		}
		function cancel() {
					$('#bppAccessory').uploadify('cancel', '*');
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
