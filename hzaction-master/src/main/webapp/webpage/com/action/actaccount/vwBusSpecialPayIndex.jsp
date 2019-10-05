<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
	<t:tabs id="tt" iframe="true" tabPosition="top" heigth="580px" fit="false">
		<t:tab href="vwBusSpecialPayController.do?list" icon="icon-edit" title="未审核" id="tab1"></t:tab>
		<t:tab href="vwBusSpecialPayController.do?listNo" icon="icon-save" title="待审核" id="tab2"></t:tab>
		<t:tab href="vwBusSpecialPayController.do?listYes" icon="icon-save" title="已审核" id="tab3"></t:tab>
	</t:tabs>
	</div>
 </div>
