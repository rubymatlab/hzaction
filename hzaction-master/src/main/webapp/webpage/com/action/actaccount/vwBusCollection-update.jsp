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
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vwBusCollectionController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${vwBusCollectionPage.id }"/>
		<table style="width: 650px;" cellpadding="0" cellspacing="1" class="formtable">
					 <tr>
						<td align="right">
							<label class="Validform_label">
								项目名称:
							</label>
						</td>
						<td class="value">
						   	<input id="bpmName" class="inputxt" ignore="ignore" readonly="readonly"  value='${vwBusCollectionPage.bpmName}' style="width:150px" >	
			        <input type="hidden" id="fromProjmId" name="fromProjmId" ignore="ignore" class="inputxt" value="${vwBusCollectionPage.fromProjmId }">
			        <span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								项目编号:
							</label>
						</td>
						<td class="value">
						    <input id="bpmProjId" name="bpmProjId" type="text" readonly="readonly" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusCollectionPage.bpmProjId}'/>
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
						    <input id="bcCustContractor" name="bcCustContractor" readonly="readonly" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusCollectionPage.bcCustContractor}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户</label>
						</td>
					
						<td align="right">
							<label class="Validform_label">
								收款单号:
							</label>
						</td>
						<td class="value">
						    <input id="bcCollectId" name="bcCollectId" type="text" readonly="readonly" maxlength="32" style="width: 180px" class="inputxt"  ignore="ignore"  value='${vwBusCollectionPage.bcCollectId}'/>
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
						    <%-- <input id="bcProgressStages" name="bcProgressStages" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusCollectionPage.bcProgressStages}'/> --%>
							<t:dictSelect field="bcProgressStages" type="list" readonly="readonly"  typeGroupCode="gathering"   defaultVal="${vwBusCollectionPage.bcProgressStages}" hasLabel="false"  title="进度款分期" ></t:dictSelect>  
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">进度款分期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								开票税率:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="bcTaxPer" type="list"  typeGroupCode="bc_tax_pe"   defaultVal="${vwBusCollectionPage.bcTaxPer}" hasLabel="false"  title="开票税率" ></t:dictSelect>     
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
						    <input id="brpBackAmount" name="brpBackAmount" type="text" maxlength="32" readonly="readonly" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusCollectionPage.brpBackAmount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预计回款金额</label>
						</td>
						
						<td align="right">
							<label class="Validform_label">
								预计回款时间:
							</label>
						</td>
						<td class="value">
									  <input id="brpExtBackDate" name="brpExtBackDate" disabled="disabled" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vwBusCollectionPage.brpExtBackDate}' type="date" pattern="yyyy-MM-dd"/>'/>
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
						    <input id="bcInvAmount" name="bcInvAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusCollectionPage.bcInvAmount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开票金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								开票时间:
							</label>
						</td>
						<td class="value">
									  <input id="bcInvoiceDate" name="bcInvoiceDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vwBusCollectionPage.bcInvoiceDate}' type="date" pattern="yyyy-MM-dd"/>'/>
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
						    <input id="bcColAmount" name="bcColAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusCollectionPage.bcColAmount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								收款时间:
							</label>
						</td>
						<td class="value">
									  <input id="bcColDate" name="bcColDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vwBusCollectionPage.bcColDate}' type="date" pattern="yyyy-MM-dd"/>'/>
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
							<table id="bc_file_fileTable"></table>
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
						<tr >
							<td align="right">
								<label class="Validform_label">
									回款状态:
								</label>
							</td>
							<td class="value" colspan="3">
								  <t:dictSelect field="bcColState" type="list"  typeGroupCode="bc_back"  defaultVal="${vwBusCollectionPage.bcColState}" hasLabel="false"  title="回款状态" ></t:dictSelect>     
								<span class="Validform_checktip"></span>
								<label class="Validform_label" style="display: none;">回款状态</label>
						</td>
				
						</tr>>
						<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value"  colspan="3" >
						  	 	<textarea id="bcRemark" style="height:auto;width:95%;" class="inputxt" rows="6" name="bcRemark"  ignore="ignore" >${vwBusCollectionPage.bcRemark}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
				</table>
			<c:if test="${ payment == true }">
				<p style="font-weight: bold; font-size: 18px;">支付</p>
				<table style="width: 650px;" cellpadding="0" cellspacing="1" class="formtable">
					 <tr>
					<td align="right">
						<label class="Validform_label">
							支付方式:
						</label>
					</td>
					<td class="value">
							<t:dictSelect field="bpiPayMethod" type="list"  typeGroupCode="bus_pa_way" defaultVal="${vwBusCollectionPage.bpiPayMethod }"   hasLabel="false"  title="支付方式" ></t:dictSelect>
					     	 <!-- <input id="bpiPayMethod" name="bpiPayMethod" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">支付方式</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							银行帐号:
						</label>
					</td>
					<td class="value">
		        		<input id="fromPayinfoId" name="fromPayinfoId"  type="hidden"  maxlength="32" value="${ vwBusCollectionPage.fromPayinfoId }" />
		        		<input id="tempBbaiAcountNo" type="hidden" value="${vwBusCollectionPage.bbaiAccountNo }">
		        		<t:dictSelect  id="paySelect" field="bbaiAccountNo" type="select" dictTable="bas_bank_account_info"  dictField="id" dictText="bbai_sname"  defaultVal="${vwBusCollectionPage.bbaiAccountNo }"   hasLabel="false"  title="银行账号" ></t:dictSelect>
			        	<%-- <input id="bbaiAccountNo" class="easyui-combogrid" name="bbaiAccountNo" style="width:150px" value="${vwBusCollectionPage.bbaiAccountNo }" data-options="
				        	panelWidth: 150,
				            idField: 'bbaiAccountNo',
				            textField: 'bbaiAccountNo',
				            url: 'basBankAccountInfoController.do?datagrid&field=bbaiAccountNo,id,bbaiSname',
				            columns: [[
				             {field:'bbaiAccountNo',title:'银行账号',width:80},
				             {field: 'bbaiSname',title: '简称'}
							
							]],
							onSelect(row,data){
								$('#from_bank_acc_id').val(data.id)
							},
							 fitColumns: true
							 
				        "> --%>
				        	<input id="from_bank_acc_id" name="fromBankAccId"  type="hidden"  maxlength="32" value="${ vwBusCollectionPage.fromBankAccId }" />

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
						<t:dictSelect  field="bpiFeeType" type="list"  typeGroupCode="bc_fee_nam"  defaultVal="${vwBusCollectionPage.bpiFeeType }"   hasLabel="false"  title="费用类别" ></t:dictSelect>
					     	<!--  <input id="bpiFeeType" name="bpiFeeType" type="text"  maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用类别</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							费用明细:
						</label>
					</td>
					<td class="value">
							<t:dictSelect field="bpiFeeDetail"  type="list"  typeGroupCode="bc_fee_dtl" defaultVal="${vwBusCollectionPage.bpiFeeDetail }"    hasLabel="false"  title="费用明细" ></t:dictSelect>
					     	<!--  <input id="bpiFeeDetail" name="bpiFeeDetail" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
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
					     	 <input id="bpiPayDate" name="bpiPayDate" type="text" maxlength="32" value="${vwBusCollectionPage.bpiPayDate }"  style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"   ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">支付时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							内容:
						</label>
					</td>
					<td class="value">
						<t:dictSelect field="bpiContent" type="list"  typeGroupCode="bus_pa_con"  defaultVal="${vwBusCollectionPage.bpiContent }"  hasLabel="false"  title="内容" ></t:dictSelect>
					     	 <!-- <input id="bpiContent" name="bpiContent" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内容</label>
						</td>
					</tr> 
					 <tr  >
					<td align="right">
						<label class="Validform_label">
							凭证号:
						</label>
					</td>
					<td class="value" colspan="3">
					     	 <input id="bpiVoucherno" name="bpiVoucherno" readonly="readonly"  type="text" maxlength="32" value="${vwBusCollectionPage.bpiVoucherno}" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">凭证号</label>
						</td>
					</tr>
					<%-- <tr>
						<td align="right">
							<label class="Validform_label">
								附件:
							</label>
						</td>
						<td class="value" colspan="3">
						<table id="bpi_accessory_fileTable"></table>
						<div class="form jeecgDetail">
							<t:upload name="bpiAccessory" id="bpiAccessory" queueID="filediv_bpiAccessory" outhtml="false" uploader="cgUploadController.do?saveFiles"  extend="office" buttonText='添加文件'  onUploadStart="bcFileOnUploadStart"> </t:upload>
							<div class="form" id="filediv_bcFile"></div>
							<script type="text/javascript">
								function bcFileOnUploadStart(file){
									var cgFormId=$("input[name='id']").val();
									$('#bpiAccessory').uploadify("settings", "formData", {
										'cgFormId':cgFormId,
										'cgFormName':'bus_pay_info',
										'cgFormField':'BPI_ACCESSORY'
									});
								}
							</script>
						</div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文件</label>
						</td>
					</tr> --%>
					
			</table>
				</c:if>
		</t:formvalid>
		<input id="isPayment" type="hidden" value="${payment}">
 </body>
 	<script src = "webpage/com/action/actpo/dropdown.js"></script>
	  	<script type="text/javascript">	
	  	
			$(function(){
				$("#paySelect").on("change",function(e){
					console.log("触发")
					$("#from_bank_acc_id").val($(this).val());
				})
				
				
				$("#paySelect").find("option[value="+ $("#from_bank_acc_id").val() +"]").attr("selected","selected");
				
				if($("#isPayment").val() == "true"){
					$("table").eq(0).find(".value").each(function(index, item){
						var oDiv = $("<div></div>").css({
							"position": "absolute",
							"width": "100%",
							"height": "100%",
							"z-index": "99",
							"left": "0px",	
							"top": "0px"
						})
						$(item).css("position","relative").append(oDiv)
					})
				}
			});
			
			//  加载进度款分期
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
			
			
			// 获取已存在的文件
			$(function(){
	  			var cgFormId=$("input[name='id']").val();
		  		$.ajax({
		  		   type: "post",
		  		   url: "vwBusCollectionController.do?getFiles&id=" +  cgFormId,
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
				// id 获取
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
