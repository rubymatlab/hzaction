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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="busContractController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${busContractPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">客户编号:</label>
			</td>
			<td class="value">
		     	 <input id="bcCustomerCode" name="bcCustomerCode" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户名称:</label>
			</td>
			<td class="value">
					 <input id="bcCustomerName" name="bcCustomerName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
		     	 <input id="bcProjectCode" name="bcProjectCode" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">合同名称:</label>
			</td>
			<td class="value">
		     	 <input id="bcContractName" name="bcContractName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">客户签约人:</label>
			</td>
			<td class="value">
		     	 <input id="bcCustContractor" name="bcCustContractor" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户签约人</label>
			</td>
			<td align="right">
				<label class="Validform_label">我方签约人:</label>
			</td>
			<td class="value">
		     	 <input id="bcCompContractor" name="bcCompContractor" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">我方签约人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">签订时间:</label>
			</td>
			<td class="value">
					  <input id="bcConcludeTime" name="bcConcludeTime" type="text" style="width: 150px"  
					  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">签订时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">合同开始时间:</label>
			</td>
			<td class="value">
					  <input id="bcContStartTime" name="bcContStartTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同开始时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">合同结束时间:</label>
			</td>
			<td class="value">
					  <input id="bcContEndTime" name="bcContEndTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同结束时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">合同金额:</label>
			</td>
			<td class="value">
		     	 <input id="bcContAmount" name="bcContAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同金额</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td class="value">
		     	 <input id="fromProjName" name="fromProjName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">合同完成状态:</label>
			</td>
			<td class="value">
				<t:dictSelect field="bcContractState" type="list"  typeGroupCode="state" readonly="readonly"
					defaultVal="1" hasLabel="false"  title="合同完成状态" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同完成状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目立项外键:</label>
			</td>
			<td class="value">
		     	 <input id="fromProjId" name="fromProjId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目立项外键</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户资料外键:</label>
			</td>
			<td class="value">
		     	 <input id="fromCustId" name="fromCustId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户资料外键</label>
			</td>
		</tr>
		
		
		<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<tr>
			<td align="right">
				<label class="Validform_label">中标方:</label>
			</td>
			<td class="value">
		     	 <input id="bcWinBidder" name="bcWinBidder" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">中标方</label>
			</td>
			<td align="right">
				<label class="Validform_label">中标服务费:</label>
			</td>
			<td class="value">
		     	 <input id="bcWinSfee" name="bcWinSfee" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">中标服务费</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">管理费%:</label>
			</td>
			<td class="value">
		     	 <input id="bcManPer" name="bcManPer" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">管理费百分比</label>
			</td>
			<td align="right">
				<label class="Validform_label">安信金额:</label>
			</td>
			<td class="value">
		     	 <input id="bcActionAmount" name="bcActionAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">安信金额</label>
			</td>
		</tr>
		
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="busContractController.do?busCostBudgetingList&id=${busContractPage.id}" icon="icon-search" title="成本预算明细" id="busCostBudgeting"></t:tab>
				 <t:tab href="busContractController.do?busContractPaymentList&id=${busContractPage.id}" icon="icon-search" title="约定收款" id="busContractPayment"></t:tab>
				 <t:tab href="busContractController.do?busConQuotedPriceList&id=${busContractPage.id}" icon="icon-search" title="明细报价(支持excel导入)" id="busConQuotedPrice"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			
	<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_busCostBudgeting_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
							<t:dictSelect field="busCostBudgetingList[#index#].bcbCostType" type="list"    typeGroupCode="cost_type"  defaultVal="" hasLabel="false"  title="费用类型"></t:dictSelect>     
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
			</tr>
		 </tbody>
	<tbody id="add_busContractPayment_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
							<t:dictSelect field="busContractPaymentList[#index#].bcpProgrePayment" type="list"    typeGroupCode="gathering"  defaultVal="" hasLabel="false"  title="进度款分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">进度款分期</label>
				  </td>
				  <td align="left">
					  	<input name="busContractPaymentList[#index#].bcpContractAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">合同金额</label>
				  </td>
				  <td align="left">
					  	<input name="busContractPaymentList[#index#].bcpPaymentClause" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">付款条件</label>
				  </td>
			</tr>
 	</tbody>
	<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<tbody id="add_busConQuotedPrice_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
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
					  	<input name="busConQuotedPriceList[#index#].bcqpQty" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  	<input name="busConQuotedPriceList[#index#].bcqpPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  	<input name="busConQuotedPriceList[#index#].bcqpAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">金额</label>
				  </td>
				  <td align="left" hidden="hidden">
					  	<input name="busConQuotedPriceList[#index#].busContractId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">合同管理外键</label>
				  </td>
			</tr>
		</tbody>
	</table>
 </body>
 <script src = "webpage/com/jeecg/wmt/busContract.js"></script>
	