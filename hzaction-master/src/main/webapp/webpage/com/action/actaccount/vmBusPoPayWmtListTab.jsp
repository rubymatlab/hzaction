<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
	<t:tabs id="tabsOne" iframe="true" tabPosition="top" fit="true">
    	<t:tab href="vmBusPoPayWmtController.do?list0" icon="icon-edit" title="制作中" id="tab1"></t:tab>
    	<t:tab href="vmBusPoPayWmtController.do?list1" icon="icon-search" title="待审核" id="tab2"></t:tab>
    	<t:tab href="vmBusPoPayWmtController.do?list2" icon="icon-save" title="已审核" id="tab3"></t:tab>
	</t:tabs>
  </div>
 </div>
 <script type="text/javascript">
 </script>
