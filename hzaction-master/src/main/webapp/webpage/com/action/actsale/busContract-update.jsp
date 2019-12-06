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
  <t:formvalid formid="formobj" dialog="true" beforeSubmit="judge" usePlugin="password" layout="table" tiptype="1" action="busContractController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${busContractPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr hidden="hidden">
			<td align="right">
				<label class="Validform_label">创建人名称:</label>
			</td>
			<td class="value">
		     	 <input id="createName" name="createName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.createName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">创建人名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">创建人登录名称:</label>
			</td>
			<td class="value">
		     	 <input id="createBy" name="createBy" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.createBy}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">创建人登录名称</label>
			</td>
		</tr>
		<tr hidden="hidden">
			<td align="right">
				<label class="Validform_label">创建日期:</label>
			</td>
			<td class="value">
					  <input id="createDate" name="createDate" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${busContractPage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">创建日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">更新人名称:</label>
			</td>
			<td class="value">
		     	 <input id="updateName" name="updateName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.updateName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">更新人名称</label>
			</td>
		</tr>
		<tr hidden="hidden">
			<td align="right">
				<label class="Validform_label">更新人登录名称:</label>
			</td>
			<td class="value">
		     	 <input id="updateBy" name="updateBy" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.updateBy}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">更新人登录名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">更新日期:</label>
			</td>
			<td class="value">
					  <input id="updateDate" name="updateDate" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${busContractPage.updateDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">更新日期</label>
			</td>
		</tr>
		<tr hidden="hidden">
			<td align="right">
				<label class="Validform_label">所属部门:</label>
			</td>
			<td class="value">
		     	 <input id="sysOrgCode" name="sysOrgCode" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.sysOrgCode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">所属部门</label>
			</td>
			<td align="right">
				<label class="Validform_label">所属公司:</label>
			</td>
			<td class="value">
		     	 <input id="sysCompanyCode" name="sysCompanyCode" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.sysCompanyCode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">所属公司</label>
			</td>
		</tr>
		<tr>
			<td align="right" hidden="hidden">
				<label class="Validform_label">流程状态:</label>
			</td>
			<td class="value" hidden="hidden">
		     	 <input id="bpmStatus" name="bpmStatus" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.bpmStatus}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">流程状态</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户编号:</label>
			</td>
			<td class="value">
		     	 <input id="bcCustomerCode" name="bcCustomerCode" disabled="disabled" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.bcCustomerCode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">合同金额:</label>
			</td>
			<td class="value">
		     	 <input id="bcContAmount" name="bcContAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.bcContAmount}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同金额</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">客户名称:</label>
			</td>
			<td class="value">
					<input id="bcCustomerName" name="bcCustomerName" disabled="disabled" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"   onclick="popupClick(this,'bcCustomerName','bas_customer ')"  value='${busContractPage.bcCustomerName}'/>			    
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
		     	 <input id="bcProjectCode" name="bcProjectCode" disabled="disabled" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.bcProjectCode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">合同名称:</label>
			</td>
			<td class="value">
		     	 <input id="bcContractName" name="bcContractName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.bcContractName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">签订时间:</label>
			</td>
			<td class="value">
					  <%-- <input id="bcConcludeTime" name="bcConcludeTime" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${busContractPage.bcConcludeTime}' type="date" pattern="yyyy-MM-dd"/>'/> --%>
				<input id="bcConcludeTime" name="bcConcludeTime" onClick="WdatePicker()"  type="text" style="width: 150px" class="Wdate"  ignore="ignore"  value="<fmt:formatDate value='${busContractPage.bcConcludeTime}' type='date' pattern='yyyy-MM-dd' />" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">签订时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">初验时间:</label>
			</td>
			<td class="value">
					  <input id="bcContStartTime" name="bcContStartTime" onClick="WdatePicker()"  type="text" style="width: 150px" class="Wdate"  ignore="ignore"  value="<fmt:formatDate value='${busContractPage.bcContStartTime}' type='date' pattern='yyyy-MM-dd' />" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">初验时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">终验时间:</label>
			</td>
			<td class="value">
					  <input id="bcContEndTime" name="bcContEndTime" onClick="WdatePicker()" type="text" class="Wdate" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${busContractPage.bcContEndTime}' type="date" pattern="yyyy-MM-dd"/>' />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">终验时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">合同完成状态:</label>
			</td>
			<td class="value" >
					<t:dictSelect field="bcContractState" type="list" readonly="readonly" typeGroupCode="state"  
						defaultVal="${busContractPage.bcContractState}" hasLabel="false"  title="合同完成状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同完成状态</label>
			</td>
			<td align="right">
				<label class="Validform_label">我方签约人:</label>
			</td>
			<td class="value">
		     	 <input id="bcCompContractor" name="bcCompContractor" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.bcCompContractor}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">我方签约人</label>
			</td>
		</tr>
		<tr>
			<td align="right" hidden="hidden">
				<label class="Validform_label">项目立项外键:</label>
			</td>
			<td class="value" hidden="hidden">
		     	 <input id="fromProjId" name="fromProjId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.fromProjId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目立项外键</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">成本预算:</label>
			</td>
			<td class="value">
		     	 <input id="bcCosting" name="bcCosting" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.bcCosting}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">成本预算</label>
			</td>
			<td align="right">
				<label class="Validform_label">安信金额:</label>
			</td>
			<td class="value">
		     	 <input id="bcActionAmount" name="bcActionAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.bcActionAmount}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">安信金额</label>
			</td>
			<td align="right" hidden="hidden">
				<label class="Validform_label">客户资料外键:</label>
			</td>
			<td class="value" hidden="hidden">
		     	 <input id="fromCustId" name="fromCustId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.fromCustId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户资料外键</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td class="value">
		     	 <input id="fromProjName" name="fromProjName" disabled="disabled" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.fromProjName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">管理费%:</label>
			</td>
			<td class="value">
		     	 <input id="bcManPer" name="bcManPer" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.bcManPer}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">管理费%</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">中标方:</label>
			</td>
			<td class="value">
		     	 <input id="bcWinBidder" name="bcWinBidder" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.bcWinBidder}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">中标方</label>
			</td>
			<td align="right">
				<label class="Validform_label">中标服务费:</label>
			</td>
			<td class="value">
		     	 <input id="bcWinSfee" name="bcWinSfee" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busContractPage.bcWinSfee}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">中标服务费</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">合同电子档:</label>
			</td>
			<td class="value" colspan="4">
		<table id="bc_contract_file_fileTable"></table>
		<div class="form jeecgDetail">
			<t:upload name="bcContractFile" id="bcContractFile" queueID="filediv_bcContractFile" outhtml="false" 
				uploader="cgUploadController.do?saveFiles&bafAttachClass=1"  extend="office" buttonText='添加文件'  onUploadStart="bcContractFileOnUploadStart"> </t:upload>
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
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="busContractController.do?busContractPaymentList&id=${busContractPage.id}" icon="icon-search" title="合同约定收款附表" id="busContractPayment"></t:tab>
				 <t:tab href="busContractController.do?busCostBudgetingList&id=${busContractPage.id}" icon="icon-search" title="成本预算附表" id="busCostBudgeting"></t:tab>
				 <t:tab href="busContractController.do?busConQuotedPriceList&id=${busContractPage.id}" icon="icon-search" title="合同明细报价附表" id="busConQuotedPrice"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_busConQuotedPrice_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left" hidden="hidden">
					  		<input name="busConQuotedPriceList[#index#].createName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建人名称</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busConQuotedPriceList[#index#].createBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建人登录名称</label>
				  </td>
				  <td align="left" hidden="hidden">
							<input name="busConQuotedPriceList[#index#].createDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建日期</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busConQuotedPriceList[#index#].updateName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新人名称</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busConQuotedPriceList[#index#].updateBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新人登录名称</label>
				  </td>
				  <td align="left" hidden="hidden">
							<input name="busConQuotedPriceList[#index#].updateDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新日期</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busConQuotedPriceList[#index#].sysOrgCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属部门</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busConQuotedPriceList[#index#].sysCompanyCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属公司</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busConQuotedPriceList[#index#].bpmStatus" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">流程状态</label>
				  </td>
				  <td align="left">
					  		<input name="busConQuotedPriceList[#index#].bcqpName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">名称</label>
				  </td>
				  <td align="left">
					  		<input name="busConQuotedPriceList[#index#].bcqpBrand" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">品牌</label>
				  </td>
				  <td align="left">
					  		<input name="busConQuotedPriceList[#index#].bcqpModel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">型号</label>
				  </td>
				  <td align="left">
					  		<input name="busConQuotedPriceList[#index#].bcqpQty" maxlength="22" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  		<input name="busConQuotedPriceList[#index#].bcqpUnit" maxlength="22" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单位</label>
				  </td>
				  <td align="left">
					  		<input name="busConQuotedPriceList[#index#].bcqpPrice" maxlength="22" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  		<input name="busConQuotedPriceList[#index#].bcqpAmount" maxlength="22" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">金额</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busConQuotedPriceList[#index#].busContractId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">合同管理外键</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_busContractPayment_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left" hidden="hidden">
					  		<input name="busContractPaymentList[#index#].createName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建人名称</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busContractPaymentList[#index#].createBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建人登录名称</label>
				  </td>
				  <td align="left" hidden="hidden">
							<input name="busContractPaymentList[#index#].createDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建日期</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busContractPaymentList[#index#].updateName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新人名称</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busContractPaymentList[#index#].updateBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新人登录名称</label>
				  </td>
				  <td align="left" hidden="hidden">
							<input name="busContractPaymentList[#index#].updateDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新日期</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busContractPaymentList[#index#].sysOrgCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属部门</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busContractPaymentList[#index#].sysCompanyCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属公司</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busContractPaymentList[#index#].bpmStatus" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">流程状态</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busContractPaymentList[#index#].bcpSeqNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">序号</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="busContractPaymentList[#index#].bcpProgrePayment" type="list"   typeGroupCode="cost_stag"  defaultVal="" hasLabel="false"  title="进度款分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">进度款分期</label>
				  </td>
				  <td align="left">
					  		<input name="busContractPaymentList[#index#].bcpPaymentProportion" maxlength="10" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">付款比例</label>
				  </td>
				  <td align="left">
					  		<input name="busContractPaymentList[#index#].bcpContractAmount" maxlength="10" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">合同金额</label>
				  </td>
				  <td align="left">
					  		<input name="busContractPaymentList[#index#].bcpPaymentClause" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">付款条件</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busContractPaymentList[#index#].busContractId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">合同管理外键</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_busCostBudgeting_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left" hidden="hidden">
					  		<input name="busCostBudgetingList[#index#].bpmStatus" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">流程状态</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busCostBudgetingList[#index#].createName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建人名称</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busCostBudgetingList[#index#].createBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建人登录名称</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busCostBudgetingList[#index#].updateName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新人名称</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busCostBudgetingList[#index#].updateBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新人登录名称</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busCostBudgetingList[#index#].sysOrgCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属部门</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busCostBudgetingList[#index#].sysCompanyCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属公司</label>
				  </td>
				  <td align="left" hidden="hidden">
							<input name="busCostBudgetingList[#index#].createDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建日期</label>
				  </td>
				  <td align="left" hidden="hidden">
							<input name="busCostBudgetingList[#index#].updateDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新日期</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="busCostBudgetingList[#index#].bcbCostType" type="list"   typeGroupCode="cost_type"  defaultVal="" hasLabel="false"  title="费用类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类型</label>
				  </td>
				  <td align="left">
					  		<input name="busCostBudgetingList[#index#].bcbBudget" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">预算</label>
				  </td>
				  <td align="left">
					  		<input name="busCostBudgetingList[#index#].bcbRemark" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left" hidden="hidden">
					  		<input name="busCostBudgetingList[#index#].busContractId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">合同管理主表外键</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actsale/busContract.js"></script>	
  	<script type="text/javascript">
	  	//加载 已存在的 文件
	  	$(function(){
	  		var cgFormId=$("input[name='id']").val();
	  		$.ajax({
	  		   type: "post",
	  		   url: "busContractController.do?getFiles&id=" +  cgFormId,
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
		  					//obj.parentNode.parentNode.parentNode.deleteRow(obj.parentNode.parentNode);
		  					//wmt
		  					var tbody = document.getElementById("bc_contract_file_fileTable").firstChild;
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
		
		
		//wmt-start
		function judge(){
			var bcContractName = $("#bcContractName").val().replace(/(^\s*)|(\s*$)/g, "")
			if(bcContractName!=""){
				return true;
			}
			alert("合同名称不能为空!")
			return false;
		}
		//wmt-end
		
  	</script>
  	
