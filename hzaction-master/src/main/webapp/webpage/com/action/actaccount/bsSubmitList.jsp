<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
    <t:tabs id="tt" iframe="false" tabPosition="top">
      <t:tab title="制作中" id="" closable="false" iframe="bsSubmitController.do?goMaking"></t:tab>
      <t:tab title="待审核" id="" closable="false" iframe="bsSubmitController.do?goUnaudited"></t:tab>
      <t:tab title="已审核" id="" closable="false" iframe="bsSubmitController.do?goAudited"></t:tab>
    </t:tabs>
  </div>
</div>

