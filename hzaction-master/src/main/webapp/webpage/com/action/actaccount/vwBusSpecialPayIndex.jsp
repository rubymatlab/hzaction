<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
	<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
	 <t:tab iframe="vwBusSpecialPayController.do?list" icon="icon-search" title="未审核" id="checking"></t:tab>
	 <t:tab iframe="vwBusSpecialPayController.do?listYes" icon="icon-search" title="已审核" id="checked"></t:tab>
	</t:tabs>
	</div>
 </div>
