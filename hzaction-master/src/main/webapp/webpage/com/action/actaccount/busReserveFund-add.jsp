<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>备用金或借款领用单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="busReserveFundController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${busReserveFundPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							申请人:
						</label>
					</td>
					<td class="value">
					     	 <input id="brfApplicant" name="brfApplicant" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部门:
						</label>
					</td>
					<td class="value">
					     	 <input id="brfDep" name="brfDep" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">部门</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							领取人:
						</label>
					</td>
					<td class="value">
					     	 <input id="brfReceiver" name="brfReceiver" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">领取人</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							借款金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="brfAmount" name="brfAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">借款金额</label>
						</td>
				</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							借款事由:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="height:auto;width:95%" class="inputxt" rows="6" id="brfCause" name="brfCause"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">借款事由</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							借款原因:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="height:auto;width:95%" class="inputxt" rows="6" id="brfReason" name="brfReason"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">借款原因</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="height:auto;width:95%" class="inputxt" rows="6" id="befRemark" name="befRemark"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
