<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>客户资料</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="basCustomerController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${basCustomerPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">客户编号:</label>
			</td>
			<td class="value">
		     	 <input id="bcId" name="bcId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basCustomerPage.bcId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户名称:</label>
			</td>
			<td class="value">
		     	 <input id="bcName" name="bcName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basCustomerPage.bcName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">客户简称:</label>
			</td>
			<td class="value">
		     	 <input id="bcSname" name="bcSname" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basCustomerPage.bcSname}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户简称</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户地址:</label>
			</td>
			<td class="value">
		     	 <input id="bcAddress" name="bcAddress" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basCustomerPage.bcAddress}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户地址</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">开户行:</label>
			</td>
			<td class="value">
		     	 <input id="bcBankId" name="bcBankId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basCustomerPage.bcBankId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">开户行</label>
			</td>
			<td align="right">
				<label class="Validform_label">开户帐号:</label>
			</td>
			<td class="value">
		     	 <input id="bcBankAcc" name="bcBankAcc" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basCustomerPage.bcBankAcc}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">开户帐号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
		     	 <input id="bcRemark" name="bcRemark" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basCustomerPage.bcRemark}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="basCustomerController.do?basCustomerContactsList&id=${basCustomerPage.id}" icon="icon-search" title="客户资料明细" id="basCustomerContacts"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_basCustomerContacts_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="basCustomerContactsList[#index#].bccName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">姓名</label>
				  </td>
				  <td align="left">
					  		<input name="basCustomerContactsList[#index#].bccDept" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">部门</label>
				  </td>
				  <td align="left">
					  		<input name="basCustomerContactsList[#index#].bccPost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">职务</label>
				  </td>
				  <td align="left">
					  		<input name="basCustomerContactsList[#index#].bccTel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">电话</label>
				  </td>
				  <td align="left">
					  		<input name="basCustomerContactsList[#index#].bcRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left">
					  		<input name="basCustomerContactsList[#index#].fromId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">客户资料外键</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actbase/basCustomer.js"></script>	
