<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<div>
	
	<t:tabs id="tabsOne" iframe="true" heigth="700px" tabPosition="top" fit="false">
		<t:tab href="vwBusPoApplyController.do?list&bpmStatus=0" icon="icon-caret-down" title="制作中" id="tab1"></t:tab>
		<t:tab href="vwBusPoApplyController.do?list&bpmStatus=1" icon="icon-caret-down" title="待审核" id="tab1"></t:tab>
		<t:tab href="vwBusPoApplyController.do?list&bpmStatus=2" icon="icon-caret-down" title="已审核" id="tab1"></t:tab>
		</t:tabs>
	
</div> 