<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
	<t:tabs id="tabsThree" iframe="false" tabPosition="top" fit="true">
	 <t:tab iframe="vmBusProjectManagerController.do?index&bpmStatus=0" icon="icon-search" title="项目跟进清单" id="checking"></t:tab>
	 <t:tab iframe="vmBusProjectManagerController.do?index&bpmStatus=1" icon="icon-search" title="项目完工清单" id="checked"></t:tab>
	</t:tabs>
	</div>
 </div>
