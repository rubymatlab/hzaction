<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目立项</title>
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
					<input type="hidden"  id="fromCustId" name="fromCustId" value='${vwBusProjectPage.fromCustId}'/>
					<input type="hidden"  id="bcId" name="bcId" value='${vwBusProjectPage.bcId}'/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
		     	 <input id="bpProjId" name="bpProjId" readonly="true" type="text" maxlength="40" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  datatype="*" ignore="checked"  value='${vwBusProjectPage.bpProjId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td class="value">
		     	 <input id="bpProjName" name="bpProjName" type="text" maxlength="200" style="width: 150px" class="inputxt"  datatype="*" ignore="checked" value='${vwBusProjectPage.bpProjName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">立项时间:</label>
			</td>
			<td class="value">
					  <input id="bpDate" name="bpDate" type="text" style="width: 150px"   ignore="ignore" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value='<fmt:formatDate value='${vwBusProjectPage.bpDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">立项时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目预算:</label>
			</td>
			<td class="value">
		     	 <input id="bpAmount" name="bpAmount" type="text" maxlength="20" style="width: 150px" class="inputxt" datatype="n" ignore="ignore"  value='${vwBusProjectPage.bpAmount}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目预算</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目经理:</label>
			</td>
			<td class="value">
		     	 <input id="bpManager" name="bpManager" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vwBusProjectPage.bpManager}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目经理</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户名称:</label>
			</td>
			<td class="value">
		     	 <input id="bcName" name="bcName" type="text" maxlength="100" style="width: 150px" class="easyui-combogrid"  ignore="ignore" 
		     	 data-options="required:true,panelWidth: 500,
		     	 idField: 'bcName',
		     	 textField: 'bcName',
		     	 url: 'basCustomerController.do?datagrid&field=id,bcId,bcName',
		     	 columns: [[ 
	                {field:'bcId',title:'客户编号',width:80}, 
	                {field:'bcName',title:'客户名称',width:120} 
                ]],
                onSelect: function (row,data) {
                	$('#fromCustId').val(data.id);
                	$('#bcId').val(data.bcId);
				},
                fitColumns: true"  value='${vwBusProjectPage.bcName}' />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目阶段:</label>
			</td>
			<td class="value">
				<t:dictSelect field="bpTeam" type="list"  typeGroupCode="bp_type"   defaultVal="${vwBusProjectPage.bpTeam}" hasLabel="false"  title="项目阶段" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目阶段</label>
			</td>
			<td align="right">
				<label class="Validform_label">方案输出时间:</label>
			</td>
			<td class="value">
					  <input id="bpOutTime" name="bpOutTime" type="text" style="width: 150px"   ignore="ignore" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value='<fmt:formatDate value='${vwBusProjectPage.bpOutTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">方案输出时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">方案定稿时间:</label>
			</td>
			<td class="value">
					  <input id="bpFinishTime" name="bpFinishTime" type="text" style="width: 150px"   ignore="ignore" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value='<fmt:formatDate value='${vwBusProjectPage.bpFinishTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">方案定稿时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">预计挂网时间:</label>
			</td>
			<td class="value">
					  <input id="bpOnlineTime" name="bpOnlineTime" type="text" style="width: 150px"   ignore="ignore" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value='<fmt:formatDate value='${vwBusProjectPage.bpOnlineTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">预计挂网时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目简介:</label>
			</td>
			<td class="value" colspan="3">
					<%-- <script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
					<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
                <textarea name="bpIntroduction" id="bpIntroduction" style="width: 650px;height:300px">${vwBusProjectPage.bpIntroduction }</textarea>
				    <script type="text/javascript">
				        var bpIntroduction_editor = UE.getEditor('bpIntroduction');
				    </script> --%>
				    <textarea id="bpIntroduction" name="bpIntroduction" style="height:auto;width:95%" class="inputxt" rows="3"   ignore="ignore"/>${vwBusProjectPage.bpIntroduction}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目简介</label>
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<label class="Validform_label">产品解决方案:</label>
			</td>
			<td class="value">
		     	 <textarea id="bpProSolutions" name="bpProSolutions" style="height:auto;width:95%" class="inputxt" rows="2"   ignore="ignore"/>${vwBusProjectPage.bpProSolutions}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">产品解决方案</label>
			</td>
			<td align="right">
				<label class="Validform_label">竞争情况:</label>
			</td>
			<td class="value">
				<textarea id="bpCompetition" name="bpCompetition" style="height:auto;width:95%" class="inputxt" rows="2"   ignore="ignore">${vwBusProjectPage.bpCompetition}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">竞争情况</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="vwBusProjectController.do?busProjectDisfollowList&id=${vwBusProjectPage.id}" icon="icon-search" title="项目跟进情况" id="busProjectDisfollow"></t:tab>
				 <t:tab href="vwBusProjectController.do?busProjectFeeDetailList&id=${vwBusProjectPage.id}" icon="icon-search" title="项目立项费用明细" id="busProjectFeeDetail"></t:tab>
				 <t:tab href="vwBusProjectController.do?busProjPartnerList&id=${vwBusProjectPage.id}" icon="icon-search" title="合作伙伴资料" id="busProjPartner"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_busProjectFeeDetail_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<!-- <input name="busProjectFeeDetailList[#index#].bpfFeeType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" /> -->
					  <t:dictSelect field="busProjectFeeDetailList[#index#].bpfFeeType" type="list"   typeGroupCode="cost_type"  defaultVal="1" hasLabel="false"  title="费用类型"></t:dictSelect>  
					  <label class="Validform_label" style="display: none;">费用类型</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectFeeDetailList[#index#].bpfAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">金额</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectFeeDetailList[#index#].bpfDesc" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">详细描述</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectFeeDetailList[#index#].fromId" maxlength="36" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_busProjectDisfollow_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <!-- <td align="left">
					  		<input name="busProjectDisfollowList[#index#].bpdDisNo" maxlength="32" type="text" class="inputxt" datatype="n"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">跟进次数</label>
				  </td> -->
				  <td align="left">
							<input name="busProjectDisfollowList[#index#].bpdFollowDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">跟进日期</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectDisfollowList[#index#].bpdFeedbackInto" maxlength="400" type="text" class="inputxt"  style="width:400px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目情况</label>
				  </td>
				  <td align="left">
				  		<input name="busProjectDisfollowList[#index#].bpdQuestions" maxlength="3000" type="text" class="inputxt"  style="width:400px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">问题or协助</label>
				  </td>
				  <td align="left">
					  		<input name="busProjectDisfollowList[#index#].fromId" maxlength="36" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_busProjPartner_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="busProjPartnerList[#index#].bppCompany" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">公司名称</label>
				  </td>
				  <td align="left">
					  		<input name="busProjPartnerList[#index#].bppName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">姓名</label>
				  </td>
				  <td align="left">
					  		<input name="busProjPartnerList[#index#].bppDept" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">部门</label>
				  </td>
				  <td align="left">
					  		<input name="busProjPartnerList[#index#].bppPost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">职务</label>
				  </td>
				  <td align="left">
					  		<input name="busProjPartnerList[#index#].bppTel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">电话</label>
				  </td>
				  <td align="left">
					  		<input name="busProjPartnerList[#index#].bppRemark" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left">
					  		<input name="busProjPartnerList[#index#].fromId" maxlength="36" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actsale/vwBusProject.js"></script>	
