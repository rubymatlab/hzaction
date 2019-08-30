<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 0px; border: 0px">
	<t:tabs id="listTabs" iframe="true" heigth="650px" fit="false">
		<t:tab href="vwBusBidController.do?list0" icon="icon-search" title="未审核" id="tab1"></t:tab>
		<t:tab href="vwBusBidController.do?list1" icon="icon-search" title="已审核" id="tab2"></t:tab>
	</t:tabs>
</div>
</div>
