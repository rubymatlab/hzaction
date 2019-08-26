<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>投标阶段汇总表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vwRpBusBidTotalController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${vwRpBusBidTotalPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								投标日期:
							</label>
						</td>
						<td class="value">
									  <input id="bdBidDate" name="bdBidDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vwRpBusBidTotalPage.bdBidDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">投标日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目编号:
							</label>
						</td>
						<td class="value">
						    <input id="bpProjId" name="bpProjId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusBidTotalPage.bpProjId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目名称:
							</label>
						</td>
						<td class="value">
						    <input id="bpProjName" name="bpProjName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusBidTotalPage.bpProjName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								拟中标方:
							</label>
						</td>
						<td class="value">
						    <input id="bdWinBidder" name="bdWinBidder" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusBidTotalPage.bdWinBidder}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">拟中标方</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目金额:
							</label>
						</td>
						<td class="value">
						    <input id="bdBidAmout" name="bdBidAmout" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusBidTotalPage.bdBidAmout}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目经理:
							</label>
						</td>
						<td class="value">
						    <input id="bpManager" name="bpManager" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusBidTotalPage.bpManager}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目经理</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								主标人员:
							</label>
						</td>
						<td class="value">
						    <input id="bdMainBidder" name="bdMainBidder" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusBidTotalPage.bdMainBidder}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">主标人员</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								配合人员:
							</label>
						</td>
						<td class="value">
						    <input id="bdCoordinator" name="bdCoordinator" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusBidTotalPage.bdCoordinator}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">配合人员</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								商务负责人:
							</label>
						</td>
						<td class="value">
						    <input id="bdBusinessCharge" name="bdBusinessCharge" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusBidTotalPage.bdBusinessCharge}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商务负责人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								辅助人员:
							</label>
						</td>
						<td class="value">
						    <input id="bdAuxiliaryStaff" name="bdAuxiliaryStaff" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusBidTotalPage.bdAuxiliaryStaff}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">辅助人员</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
