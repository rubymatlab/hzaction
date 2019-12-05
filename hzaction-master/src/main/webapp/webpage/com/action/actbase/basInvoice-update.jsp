<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>发票资料</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="basInvoiceController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${basInvoicePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								发票编号:
							</label>
						</td>
						<td class="value">
						    <input id="biCode" name="biCode" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${basInvoicePage.biCode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发票编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								发票金额:
							</label>
						</td>
						<td class="value">
						    <input id="biAmount" name="biAmount" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="d" ignore="ignore"  value='${basInvoicePage.biAmount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发票金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开票日期:
							</label>
						</td>
						<td class="value">
									  <input id="biDate" name="biDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${basInvoicePage.biDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开票日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								发票类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="biType" type="list"  typeGroupCode="bi_type"   defaultVal="${basInvoicePage.biType}" hasLabel="false"  title="发票类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发票类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								税率:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="biTaxRate" type="list"  typeGroupCode="bi_taxRate"   defaultVal="${basInvoicePage.biTaxRate}" hasLabel="false"  title="税率" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">税率</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
