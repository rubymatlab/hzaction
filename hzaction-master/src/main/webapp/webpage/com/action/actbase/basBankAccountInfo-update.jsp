<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>银行账号信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="basBankAccountInfoController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${basBankAccountInfoPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								账号简称:
							</label>
						</td>
						<td class="value">
						    <input id="bbaiSname" name="bbaiSname" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basBankAccountInfoPage.bbaiSname}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">账号简称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								户名:
							</label>
						</td>
						<td class="value">
						    <input id="bbaiName" name="bbaiName" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basBankAccountInfoPage.bbaiName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开户行名称:
							</label>
						</td>
						<td class="value">
						    <input id="bbaiBankName" name="bbaiBankName" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basBankAccountInfoPage.bbaiBankName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开户行名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								账号:
							</label>
						</td>
						<td class="value">
						    <input id="bbaiAccountNo" name="bbaiAccountNo" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basBankAccountInfoPage.bbaiAccountNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">账号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开户网点:
							</label>
						</td>
						<td class="value">
						    <input id="bbaiBankAddr" name="bbaiBankAddr" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basBankAccountInfoPage.bbaiBankAddr}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开户网点</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								期初余额:
							</label>
						</td>
						<td class="value">
						    <input id="bbaiIniBalance" name="bbaiIniBalance" type="text" maxlength="12" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${basBankAccountInfoPage.bbaiIniBalance}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">期初余额</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
