<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目整体结算表</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="vwRpCostAccountController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${vwRpCostAccountPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="vwRpCostAccountController.do?vwBusPoContractPayList&id=${vwRpCostAccountPage.id}" icon="icon-search" title="采购应付/已付明细" id="vwBusPoContractPay"></t:tab>
				 <%-- <t:tab href="vwRpCostAccountController.do?vwBusOthersProjPayList&id=${vwRpCostAccountPage.id}" icon="icon-search" title="其他支出汇总" id="vwBusOthersProjPay"></t:tab> --%>
				 <t:tab href="vwRpCostAccountController.do?vwBusOthersPayDetailList&id=${vwRpCostAccountPage.id}" icon="icon-search" title="其他支出明细" id="vwBusOthersPayDetail"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_vwBusPoContractPay_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="vwBusPoContractPayList[#index#].bpmProjId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目编号</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusPoContractPayList[#index#].bpmName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目名称</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusPoContractPayList[#index#].bpcpProgreName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用分期</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusPoContractPayList[#index#].bpcpDate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划付款日期</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusPoContractPayList[#index#].bpcpPayAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划付款金额</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusPoContractPayList[#index#].bppPayDate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">实际付款日期</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusPoContractPayList[#index#].payAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">付款金额</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusPoContractPayList[#index#].formCostAccountId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目结算id</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_vwBusOthersProjPay_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="vwBusOthersProjPayList[#index#].bpmProjId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目编号</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusOthersProjPayList[#index#].bpmName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目名称</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusOthersProjPayList[#index#].payTamount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">付款金额</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_vwBusOthersPayDetail_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="vwBusOthersPayDetailList[#index#].bpmProjId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目编号</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusOthersPayDetailList[#index#].bpmName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目名称</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusOthersPayDetailList[#index#].busId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单号</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusOthersPayDetailList[#index#].busType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单据_费用类型</label>
				  </td>
				  <td align="left">
							<input name="vwBusOthersPayDetailList[#index#].applyDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">申请日期</label>
				  </td>
				  <td align="left">
					  		<input name="vwBusOthersPayDetailList[#index#].payAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">付款金额</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actaccount/vwRpCostAccount.js"></script>	
