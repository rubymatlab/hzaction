<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:tabs id="tabsThree" iframe="false" tabPosition="top" fit="true">
	<t:tab iframe="busContractController.do?list1"  icon="icon-edit" title="未审核" id="tab1"></t:tab>
	<t:tab iframe="busContractController.do?list2" closable="true"  icon="icon-save" title="已审核" id="tab2"></t:tab>
  </t:tabs>
 </div>
 </div>
 <script type="text/javascript">
 </script>
