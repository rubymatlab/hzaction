<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目管理视图</title>
    <style>
  .ui-button {
  	  display: inline-block;
	  padding: 2px 2px;
	  margin-bottom: 0;
	  font-size: 8px;
	  font-weight: normal;
	  line-height: 1.42857143;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
      touch-action: manipulation;
	  cursor: pointer;
	  -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
	  background-image: none;
	  border: 1px solid transparent;
	  border-radius: 4px;
  }
  </style>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="vmBusProjectManagerController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${vmBusProjectManagerPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
		     	 <input id="bpmProjId" name="bpmProjId" type="text" maxlength="32" readonly="readonly" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusProjectManagerPage.bpmProjId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td class="value">
		     	 <input id="bpmProjName" name="bpmProjName" type="text" readonly="readonly" maxlength="32" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusProjectManagerPage.bpmProjName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">客户名称:</label>
			</td>
			<td class="value">
		     	 <input id="bpmCustName" name="bpmCustName" type="text" readonly="readonly" maxlength="32" style="width: 60%" class="inputxt"  ignore="ignore"  value='${vmBusProjectManagerPage.bpmCustName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目进度:</label>
			</td>
			<td class="value">
					<t:dictSelect field="bpmProjProg" type="list"   typeGroupCode="proj_prog"  defaultVal="${vmBusProjectManagerPage.bpmProjProg}" hasLabel="false"  title="项目进度"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目进度</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">进度百分比:</label>
			</td>
			<td class="value">
					<t:dictSelect field="bpmProgPer" type="list"   typeGroupCode="proj_per"  defaultVal="${vmBusProjectManagerPage.bpmProgPer}" hasLabel="false"  title="进度百分比"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">进度百分比</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="vmBusProjectManagerController.do?vmBusCollectPlanList&id=${vmBusProjectManagerPage.id}" icon="icon-search" title="回款计划" id="vmBusCollectPlan"></t:tab>
				 <t:tab href="vmBusProjectManagerController.do?busProjectFollowList&id=${vmBusProjectManagerPage.id}" icon="icon-search" title="项目跟进" id="busProjectFollow"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_vmBusCollectPlan_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
<!-- 			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td> -->
				  <td align="left">
							<t:dictSelect field="vmBusCollectPlanList[#index#].brpProgressStages" type="list"   typeGroupCode="gathering"  defaultVal="" hasLabel="false"  title="进度款分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">进度款分期</label>
				  </td>
				  <td align="left">
					  		<input name="vmBusCollectPlanList[#index#].brpContractAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">合同金额</label>
				  </td>
				  <td align="left">
							<input name="vmBusCollectPlanList[#index#].brpExtBackDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">预计回款日期</label>
				  </td>
				  <td align="left">
					  		<input name="vmBusCollectPlanList[#index#].brpBackAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">回款金额</label>
				  </td>
  				  <td align="left">
					  <input name="vmBusCollectPlanList[#index#].brpPlanInvoiceDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划开票日期</label>
				  </td>
				  <td align="left">
					  		<input name="vmBusCollectPlanList[#index#].brpAcceptAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">已收金额</label>
				  </td>
				  <td align="left">
					  		<input name="vmBusCollectPlanList[#index#].brpIsInvoice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">发票金额</label>
				  </td>
				  <td align="left">
							<input name="vmBusCollectPlanList[#index#].brpInvoiceDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">开票日期</label>
				  </td>
				  <td align="left">
					  		<input name="vmBusCollectPlanList[#index#].brpRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
<!-- 				  <td align="left">
					  		<input name="vmBusCollectPlanList[#index#].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目管理外键</label>
				  </td>
				  <td align="left">
					  		<input name="vmBusCollectPlanList[#index#].fromConpayId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">合同约定收款外键</label>
				  </td> -->
			</tr>
		 </tbody>
		<tbody id="add_busProjectFollow_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
				  <input name="busProjectFollowList[#index#].xh" type="hidden">
							<input name="busProjectFollowList[#index#].bpfFollowDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">跟进日期</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectFollowList[#index#].bpfFollowReport" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">跟进情况汇报</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectFollowList[#index#].bpfQuestions" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">施工困难_问题</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectFollowList[#index#].bpfNextPlan" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">下一步计划</label>
				  </td>
				  <td align="left">
							<input name="busProjectFollowList[#index#].bpfCheckDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计划验收时间</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="busProjectFollowList[#index#].bpfCheckResult" type="list"   typeGroupCode="check_res"  defaultVal="" hasLabel="false"  title="验收结果"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">验收结果</label>
				  </td>
<!-- 				  <td align="left">
					  		<input name="busProjectFollowList[#index#].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目管理外键</label>
				  </td> -->
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actproject/vmBusProjectManager.js"></script>
