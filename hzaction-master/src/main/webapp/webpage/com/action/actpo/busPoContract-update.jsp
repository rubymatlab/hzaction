<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>采购合同</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="busPoContractController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${busPoContractPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">流程状态:</label>
			</td>
			<td class="value">
		     	 <input id="bpmStatus" name="bpmStatus" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busPoContractPage.bpmStatus}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">流程状态</label>
			</td>
			<td align="right">
				<label class="Validform_label">采购合同编号:</label>
			</td>
			<td class="value">
		     	 <input id="bpcPoNo" name="bpcPoNo" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busPoContractPage.bpcPoNo}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购合同编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">采购员:</label>
			</td>
			<td class="value">
		     	 <input id="bpcPoPeople" name="bpcPoPeople" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busPoContractPage.bpcPoPeople}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购员</label>
			</td>
			<td align="right">
				<label class="Validform_label">采购日期:</label>
			</td>
			<td class="value">
					  <input id="bpcPoDate" name="bpcPoDate" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${busPoContractPage.bpcPoDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">预计付款日期:</label>
			</td>
			<td class="value">
					  <input id="bpExpPayDate" name="bpExpPayDate" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${busPoContractPage.bpExpPayDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">预计付款日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">采购是否已完成:</label>
			</td>
			<td class="value">
		     	 <input id="bpcPoOver" name="bpcPoOver" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busPoContractPage.bpcPoOver}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购是否已完成</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">收货人:</label>
			</td>
			<td class="value">
		     	 <input id="bpcRecPeople" name="bpcRecPeople" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busPoContractPage.bpcRecPeople}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收货人</label>
			</td>
			<td align="right">
				<label class="Validform_label">收货人电话:</label>
			</td>
			<td class="value">
		     	 <input id="bpcRecTel" name="bpcRecTel" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busPoContractPage.bpcRecTel}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收货人电话</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">收货地址:</label>
			</td>
			<td class="value">
		     	 <input id="bpcRecAddr" name="bpcRecAddr" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busPoContractPage.bpcRecAddr}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收货地址</label>
			</td>
			<td align="right">
				<label class="Validform_label">采购情况汇报:</label>
			</td>
			<td class="value">
		     	 <input id="bpSitReport" name="bpSitReport" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${busPoContractPage.bpSitReport}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购情况汇报</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="busPoContractController.do?busPoContractPayList&id=${busPoContractPage.id}" icon="icon-search" title="采购合同付款明细" id="busPoContractPay"></t:tab>
				 <t:tab href="busPoContractController.do?busPoApplyDetailConList&id=${busPoContractPage.id}" icon="icon-search" title="采购申请明细" id="busPoApplyDetailCon"></t:tab>
				 <t:tab href="busPoContractController.do?busPoContractDetailList&id=${busPoContractPage.id}" icon="icon-search" title="采购合同明细" id="busPoContractDetail"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
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
					  		<input name="busPoContractPayList[#index#].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_busPoApplyDetailCon_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="busPoApplyDetailConList[#index#].createName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建人名称</label>
				  </td>
				  <td align="left">
					  		<input name="busPoApplyDetailConList[#index#].createBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建人登录名称</label>
				  </td>
				  <td align="left">
							<input name="busPoApplyDetailConList[#index#].createDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">创建日期</label>
				  </td>
				  <td align="left">
					  		<input name="busPoApplyDetailConList[#index#].updateName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新人名称</label>
				  </td>
				  <td align="left">
					  		<input name="busPoApplyDetailConList[#index#].updateBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新人登录名称</label>
				  </td>
				  <td align="left">
							<input name="busPoApplyDetailConList[#index#].updateDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">更新日期</label>
				  </td>
				  <td align="left">
					  		<input name="busPoApplyDetailConList[#index#].sysOrgCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属部门</label>
				  </td>
				  <td align="left">
					  		<input name="busPoApplyDetailConList[#index#].sysCompanyCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属公司</label>
				  </td>
				  <td align="left">
					  		<input name="busPoApplyDetailConList[#index#].bpmStatus" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">流程状态</label>
				  </td>
				  <td align="left">
					  		<input name="busPoApplyDetailConList[#index#].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				  </td>
				  <td align="left">
					  		<input name="busPoApplyDetailConList[#index#].fromPoApplyDetId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购申请明细外键</label>
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
					  				<input name="busPoContractDetailList[#index#].bpcdName" name="busPoContractDetailList[#index#].bpcdName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"    onclick="popupClick(this,'bpad_name,bpad_brand,bpad_model,bpad_number','bpcdName,bpcdBrand,bpcdModel,bpcdNumber','rf_bus_po_apply_detail')" value="${poVal.bpcdName }" />
					     						
					       
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
 <script src = "webpage/com/action/actpo/busPoContract.js"></script>	
