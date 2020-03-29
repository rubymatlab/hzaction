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
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" beforeSubmit="judge" usePlugin="password" layout="table" tiptype="1" action="vmBusPoPayWmtController.do?doAdd" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${vmBusPoPayWmtPage.id }"/>
					<input id="bpcpIds" name="bpcpIds" type="hidden" />
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">付款单号:</label>
			</td>
			<td class="value" colspan="7">
		     	 <input id="bppPayId" name="bppPayId" placeholder="自动生成" readonly="readonly" type="text" maxlength="32" style="width: 80%" class="inputxt"  ignore="ignore" />
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
					onclick="popupClick(this,'bpm_name,bpm_proj_id,id,from_projm_id,bp_manager','bpmName,bpmProjId,fromProjId,busPayInfoList[0].fromProjmId,bpManager','bus_project_manager')"/>			 
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value" >
		     	 <input id="bpmProjId" name="bpmProjId" type="text" maxlength="32" readonly="readonly" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
			
			<td align="right">
				<label class="Validform_label">供应商名称<b style="color:red">*</b> :</label>
			</td>
			<td class="value">
				<input id="bsName" name="bsName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"  onclick="popupClick(this,'bs_name,bs_id,id','bsName,bsId,fromSuppId','bas_supplier')"/>			 
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">供应商编号:</label>
			</td>
			<td class="value">
		     	 <input id="bsId" name="bsId" type="text" maxlength="32" readonly="readonly" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商编号</label>
			</td>
		</tr>
		<tr hidden>
			<td align="right">
				<label class="Validform_label">项目管理外键:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="fromProjId" name="fromProjId" type="text" maxlength="32" style="width: 80%" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目管理外键</label>
			</td>
			<td align="right">
				<label class="Validform_label">供应商资料外键:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="fromSuppId" name="fromSuppId" type="text" maxlength="32" style="width: 80%" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商资料外键</label>
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<label class="Validform_label">项目经理</label>
			</td>
			<td class="value">
		     	 <input id="bpManager" name="bpManager" type="text" readonly="readonly" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" value='${vmBusPoPayWmtPage.bpManager}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目经理</label>
			</td>
			
			<td align="right" hidden="hidden">
				<label class="Validform_label">采购总金额:</label>
			</td>
			<td class="value" hidden="hidden">
		     	 <input id="bppMoneySum" name="bppMoneySum" placeholder="自动计算" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购总金额</label>
			</td>
			<td align="right">
				<label class="Validform_label">申请付款时间:</label>
			</td>
			<td class="value">
					  <input id="bppPayDate" name="bppPayDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">申请付款时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">单据状态:</label>
			</td>
			<td class="value">
				<t:dictSelect field="bppState" type="list" typeGroupCode="bs_state" readonly="readonly" defaultVal="${vmBusPoPayWmtPage.bppState==null?0:vmBusPoPayWmtPage.bppState}" hasLabel="false"  title="单据状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">单据状态</label>
			</td>
			<td align="right">
				<label class="Validform_label">税率%:</label>
			</td>
			<td class="value">
				<input id="bppTaxRate" name="bppTaxRate" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
		    	<t:dictSelect field="bppTaxRate" type="list" typeGroupCode="tax_rate" defaultVal="${vmBusPoPayWmtPage.bppTaxRate==null?0:vmBusPoPayWmtPage.bppTaxRate}" hasLabel="false"  title="税率百分比"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">税率百分比</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">付款金额:</label>
			</td>
			<td class="value" >
		     	 <input id="bppMoney" name="bppMoney" placeholder="自动计算" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">付款金额</label>
			</td>
			
			<td align="right">
				<label class="Validform_label">发票类型:</label>
			</td>
			<td class="value">
		     	<t:dictSelect field="bppInvType" type="list"  typeGroupCode="bc_invoice"  defaultVal="${vmBusPoPayWmtPage.bppInvType}" hasLabel="false" title="发票类型"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发票类型</label>
			</td>
			
			<td align="right">
				<label class="Validform_label">发票金额:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="bppInvAmount" name="bppInvAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发票金额</label>
			</td>
			<td align="right" hidden="hidden">
				<label class="Validform_label">发票未开金额:</label>
			</td>
			<td class="value" hidden="hidden">
		     	 <input id="bppInvAmountNot" name="bppInvAmountNot" placeholder="自动计算" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发票未开金额</label>
			</td>
			
		</tr>
		
		<tr>
			<td align="right">
				<label class="Validform_label">附件:</label>
			</td>
			<td class="value" colspan="7">
		<div class="form jeecgDetail">
			<t:upload name="bppAccessory" id="bppAccessory" queueID="filediv_bppAccessory" outhtml="false" uploader="cgUploadController.do?saveFiles&bafAttachClass=4"  extend="office" buttonText='添加文件'  onUploadStart="bppAccessoryOnUploadStart"> </t:upload>
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
		
		<!-- <tr hidden="hidden">
			<td>采购合同编号:<input name="bpcPoNo" id="bpcPoNo" value="" /></td>
			<td>费用分期:<input name="bpcpProgre" id="bpcpProgre" value="" /></td>
			<td>计划付款金额:<input name="bpcpPayAmount" id="bpcpPayAmount" value="" /></td>
			<td>计划付款日期:<input name="bpcpDate" id="bpcpDate" value="" /></td>
			<td>采购合同外键:<input name="fromId" id="fromId" value="" /></td>
			<td>采购付款单外键:<input name="busPoPayId" id="busPoPayId" value="" /></td>
			<td>付款金额:<input name="payAmount" id="payAmount" value="" /></td>
			<td>备注:<input name="bpcpRemark" id="bpcpRemark" value="" /></td>
			<td>项目管理外键:<input name="fromProjmIdF" id="fromProjmIdF" value="" /></td>
			<td>供应商资料外键:<input name="fromSuppIdF" id="fromSuppIdF" value="" /></td>
			<td>【实体】采购付款单明细附表外键:<input name="bpcpId" id="bpcpId" value="" /></td>
		</tr> -->
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="vmBusPoPayWmtController.do?vmBusPoContractPayWmtList&id=${vmBusPoPayWmtPage.id}" icon="icon-search" title="采购付款单" id="vmBusPoContractPayWmt"></t:tab>
				 <%-- <t:tab href="vmBusPoPayWmtController.do?busPayInfoList&id=${vmBusPoPayWmtPage.id}" icon="icon-search" title="财务支付信息实体" id="busPayInfo"></t:tab> --%>
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
							<t:dictSelect field="vmBusPoContractPayWmtList[#index#].bpcpProgre" type="list"   typeGroupCode="cost_stag"  defaultVal="" hasLabel="false"  title="费用分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用分期</label>
				  </td> 
				  <td align="left">
					  	<input name="vmBusPoContractPayWmtList[#index#].bpcpPayAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划付款金额</label>
				  </td>
				  <td align="left">
							<input name="vmBusPoContractPayWmtList[#index#].bpcpDate" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划付款日期</label>
				  </td>
				  <td align="left" hidden="hidden">
					  	<input name="vmBusPoContractPayWmtList[#index#].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				  </td>
				  <td align="left">
					  	<input name="vmBusPoContractPayWmtList[#index#].payAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
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
		<tbody id="add_busPayInfo_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="busPayInfoList[#index#].bpiClass" maxlength="30" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">功能分类</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="busPayInfoList[#index#].bpiPayMethod" type="list"  typeGroupCode="ax_payment"  defaultVal="" hasLabel="false"  title="支付方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">支付方式</label>
				  </td>
				  <td align="left">
							<input name="busPayInfoList[#index#].bpiPayDate" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">支付时间</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="busPayInfoList[#index#].bpiFeeType" type="list"    typeGroupCode="cost_type"  defaultVal="" hasLabel="false"  title="费用类别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类别</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="busPayInfoList[#index#].bpiFeeDetail" type="list"  typeGroupCode="bc_fee_dtl"  defaultVal="" hasLabel="false"  title="费用明细"></t:dictSelect>     
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
				  <td align="left" hidden="hidden">
					  	<input name="busPayInfoList[#index#].bpiBusId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">业务外键</label>
				  </td>
				  <td align="left" hidden="hidden">
					  	<input name="busPayInfoList[#index#].fromProjmId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目管理外键</label>
				  </td>
				  <td align="left" hidden="hidden">
					  	<input name="busPayInfoList[#index#].fromBankAccId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">银行账号信息外键</label>
				  </td>
				  <td align="left">
					  		<input name="busPayInfoList[#index#].bbaiSname" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"  onclick="popupClick(this,'bbai_sname,id','bbaiSname,fromBankAccId','ax_bas_bank_account_info')"/>
					  <label class="Validform_label" style="display: none;">账号简称</label>
				  </td>
				  <td align="left">
					  	<input name="busPayInfoList[#index#].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用报销外键</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actaccount/vmBusPoPayWmt.js"></script>
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
		
		//wmt-start
		function judge(){
			var bpmNameVal = $("#bpmName").val().replace(/(^\s*)|(\s*$)/g, "")
			var bsNameVal = $("#bsName").val().replace(/(^\s*)|(\s*$)/g, "")
			if(bpmNameVal!=""&&bsNameVal!=""){
				return true;
			}
			alert("项目名称和供应商名称不能为空!")
			return false;
		}
		//wmt-end
  	</script>
	