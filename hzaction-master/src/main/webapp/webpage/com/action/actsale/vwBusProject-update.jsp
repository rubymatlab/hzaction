<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目立项视图</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="vwBusProjectController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${vwBusProjectPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
		     	 <input id="bpProId" name="bpProId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bpProId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td class="value">
		     	 <input id="bpProName" name="bpProName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bpProName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">立项时间:</label>
			</td>
			<td class="value">
					  <input id="bpDate" name="bpDate" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${vwBusProjectPage.bpDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">立项时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目关键人:</label>
			</td>
			<td class="value">
		     	 <input id="bpKeyPeople" name="bpKeyPeople" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bpKeyPeople}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目关键人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目简介:</label>
			</td>
			<td class="value">
		     	 <input id="bpIntroduction" name="bpIntroduction" type="text" maxlength="500" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bpIntroduction}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目简介</label>
			</td>
			<td align="right">
				<label class="Validform_label">问题or协助:</label>
			</td>
			<td class="value">
		     	 <input id="bpQuestions" name="bpQuestions" type="text" maxlength="500" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bpQuestions}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">问题or协助</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">产品解决方案:</label>
			</td>
			<td class="value">
		     	 <input id="bpProSolutions" name="bpProSolutions" type="text" maxlength="500" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bpProSolutions}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">产品解决方案</label>
			</td>
			<td align="right">
				<label class="Validform_label">竞争情况:</label>
			</td>
			<td class="value">
		     	 <input id="bpCompetition" name="bpCompetition" type="text" maxlength="500" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bpCompetition}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">竞争情况</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目经理:</label>
			</td>
			<td class="value">
		     	 <input id="bpManager" name="bpManager" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bpManager}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目经理</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目组成员:</label>
			</td>
			<td class="value">
		     	 <input id="bpTeam" name="bpTeam" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bpTeam}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目组成员</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">方案输出时间:</label>
			</td>
			<td class="value">
					  <input id="bpOutTime" name="bpOutTime" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${vwBusProjectPage.bpOutTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">方案输出时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">方案定稿时间:</label>
			</td>
			<td class="value">
					  <input id="bpFinishTime" name="bpFinishTime" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${vwBusProjectPage.bpFinishTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">方案定稿时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">正式挂网时间:</label>
			</td>
			<td class="value">
					  <input id="bpOnlineTime" name="bpOnlineTime" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${vwBusProjectPage.bpOnlineTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">正式挂网时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">跟进结果:</label>
			</td>
			<td class="value">
		     	 <input id="bpFollowResults" name="bpFollowResults" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bpFollowResults}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">跟进结果</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">客户资料外键:</label>
			</td>
			<td class="value">
		     	 <input id="fromCustId" name="fromCustId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.fromCustId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户资料外键</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户编号:</label>
			</td>
			<td class="value">
		     	 <input id="bcId" name="bcId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bcId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">客户名称:</label>
			</td>
			<td class="value">
		     	 <input id="bcName" name="bcName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bcName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户名称</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="vwBusProjectController.do?busProjectDetailList&id=${vwBusProjectPage.id}" icon="icon-search" title="项目费用明细" id="busProjectDetail"></t:tab>
				 <t:tab href="vwBusProjectController.do?busProjectFollowList&id=${vwBusProjectPage.id}" icon="icon-search" title="项目跟进分配" id="busProjectFollow"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_busProjectDetail_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="busProjectDetailList[#index#].bpdSeq" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">序号</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectDetailList[#index#].bpdType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用类型</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectDetailList[#index#].bpdAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">金额</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectDetailList[#index#].bpdRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">详细描述</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectDetailList[#index#].fromBpid" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_busProjectFollow_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="busProjectFollowList[#index#].bpfCount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">跟进次数</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectFollowList[#index#].bpfDate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">跟进日期</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectFollowList[#index#].bpfStage" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目阶段</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectFollowList[#index#].bpfInfo" maxlength="500" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">反馈信息</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectFollowList[#index#].fromBpid" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actsale/vwBusProject.js"></script>	
