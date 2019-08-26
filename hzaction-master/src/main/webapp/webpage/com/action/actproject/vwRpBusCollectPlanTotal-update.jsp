<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>回款计划汇总</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vwRpBusCollectPlanTotalController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${vwRpBusCollectPlanTotalPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目经理:
							</label>
						</td>
						<td class="value">
						    <input id="bpManager" name="bpManager" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusCollectPlanTotalPage.bpManager}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目经理</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								项目编号:
							</label>
						</td>
						<td class="value">
						    <input id="bpProjId" name="bpProjId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusCollectPlanTotalPage.bpProjId}'/>
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
						    <input id="bpmName" name="bpmName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusCollectPlanTotalPage.bpmName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								进度款分期:
							</label>
						</td>
						<td class="value">
						    <input id="brpProgressStages" name="brpProgressStages" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusCollectPlanTotalPage.brpProgressStages}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">进度款分期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								合同金额:
							</label>
						</td>
						<td class="value">
						    <input id="brpContractAmount" name="brpContractAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusCollectPlanTotalPage.brpContractAmount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								已收金额:
							</label>
						</td>
						<td class="value">
						    <input id="brpAcceptAmount" name="brpAcceptAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusCollectPlanTotalPage.brpAcceptAmount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">已收金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								预计回款金额:
							</label>
						</td>
						<td class="value">
						    <input id="brpBackAmount" name="brpBackAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusCollectPlanTotalPage.brpBackAmount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预计回款金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								是否开发票:
							</label>
						</td>
						<td class="value">
						    <input id="brpIsInvoice" name="brpIsInvoice" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusCollectPlanTotalPage.brpIsInvoice}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否开发票</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								跟踪情况:
							</label>
						</td>
						<td class="value">
						    <input id="followDesc" name="followDesc" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusCollectPlanTotalPage.followDesc}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">跟踪情况</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								客户名称:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="bcName" type="list"  typeGroupCode=""   defaultVal="${vwRpBusCollectPlanTotalPage.bcName}" hasLabel="false"  title="客户名称" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								签订时间:
							</label>
						</td>
						<td class="value">
						    <input id="bcConcludeTime" name="bcConcludeTime" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwRpBusCollectPlanTotalPage.bcConcludeTime}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">签订时间</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
