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
  /* Author: Yang  */
  .dropdown{
		position: relative;
		display: inline-block;
		border-collapse: separate;
	}
	.dropdown button{
		position: absolute;
		right: 0;
		font-size:10px;
		height:100%;
		width:20px;
		padding:0px;
	}
	.dropdown ul.dropdown-menu{
		position: absolute;
		z-index: 999;
		background: #ffffff;
		max-height: 200px;
		overflow-y:scroll;
		width: 420px;
		display:none;
		
	}
	.dropdown ul.dropdown-menu table{
		width: 100%;
	}
	.dropdown ul.dropdown-menu table tbody tr td{
		-webkit-user-select: none;
		-moz-user-select: none;
		-ms-user-select: none;
	}
	.dropdown ul.dropdown-menu table tbody tr:hover td{
		background: #fff;
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="vmBusPoContractController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${vmBusPoContractPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">采购合同编号:</label>
			</td>
			<td class="value">
		     	 <input id="bpcPoNo" name="bpcPoNo" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购合同编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
		     	 <input id="bpmProjId" name="bpmProjId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td class="value">
		     	<!--  <input id="bpmProjName" name="bpmProjName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label> -->

				<div class="dropdown">
					<input type="text" class="inputxt" id="bpmProjName" name="bpmProjName" maxlength="50" ignore="ignore" >
					<button type="button">▼</button>
					<ul class="dropdown-menu" role="menu">
					</ul>
				</div>
			</td>
			<td align="right">
				<label class="Validform_label">供应商:</label>
			</td>
			<td class="value">
<!-- 		     	 <input id="bsName" name="bsName" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商</label> -->
				<div class="dropdown">
					<input type="text" class="inputxt" id="bsName" name="bsName" maxlength="100" ignore="ignore" >
					<button type="button">▼</button>
					<ul class="dropdown-menu" role="menu">
					</ul>
				</div>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">采购是否已完成:</label>
			</td>
			<td class="value">
		     	 <input id="bpcPoOver" name="bpcPoOver" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购是否已完成</label>
			</td>
			<td align="right">
				<label class="Validform_label">供应商联系人:</label>
			</td>
			<td class="value">
		     	 <input id="bsContact" name="bsContact" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商联系人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">收货人:</label>
			</td>
			<td class="value">
		     	 <input id="bpcRecPeople" name="bpcRecPeople" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收货人</label>
			</td>
			<td align="right">
				<label class="Validform_label">供应商联系人电话:</label>
			</td>
			<td class="value">
		     	 <input id="bsTelNo" name="bsTelNo" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="m" ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商联系人电话</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">收货人电话:</label>
			</td>
			<td class="value">
		     	 <input id="bpcRecTel" name="bpcRecTel" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="m" ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收货人电话</label>
			</td>
			<td align="right">
				<label class="Validform_label">收货地址:</label>
			</td>
			<td class="value">
		     	 <input id="bpcRecAddr" name="bpcRecAddr" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收货地址</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">采购员:</label>
			</td>
			<td class="value">
		     	 <input id="bpcPoPeople" name="bpcPoPeople" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购员</label>
			</td>
			<td align="right">
				<label class="Validform_label">采购日期:</label>
			</td>
			<td class="value">
					  <input id="bpcPoDate" name="bpcPoDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">采购情况汇报:</label>
			</td>
			<td class="value">
		     	 <input id="bpSitReport" name="bpSitReport" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购情况汇报</label>
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
					  	<input name="vmMergeBusPoApplyDetailList[#index#].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_busPoContractPay_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
							<t:dictSelect field="busPoContractPayList[#index#].bpcpProgre" type="list"    typeGroupCode="cost_stag"  defaultVal="" hasLabel="false"  title="费用分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用分期</label>
				  </td>
				  <td align="left">
					  	<input name="busPoContractPayList[#index#].bpcpPayAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划付款金额</label>
				  </td>
				  <td align="left">
							<input name="busPoContractPayList[#index#].bpcpDate" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划付款日期</label>
				  </td>
				  <td align="left">
					  	<input name="busPoContractPayList[#index#].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_busPoContractDetail_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
							<t:dictSelect field="busPoContractDetailList[#index#].bpcdPayType" type="list"    typeGroupCode="cost_type"  defaultVal="" hasLabel="false"  title="费用类型"></t:dictSelect>     
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
					  	<input name="busPoContractDetailList[#index#].bpcdNumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  	<input name="busPoContractDetailList[#index#].bpcdPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  	<input name="busPoContractDetailList[#index#].bpcdAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">金额</label>
				  </td>
				  <td align="left">
					  	<input name="busPoContractDetailList[#index#].bpcdRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left">
					  	<input name="busPoContractDetailList[#index#].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actpo/vmBusPoContract.js"></script>
 
	