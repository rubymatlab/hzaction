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
	createProjectId();
  });
  function createProjectId(){
	//项目编号
	var myDate = new Date();
	var rand = Math.floor(Math.random () * 900) + 100;
	$("#bpProjId").val('AX-'+myDate.getFullYear()+'-'+$('#bcId').val()+'-'+rand);
  }
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="vwBusProjectController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${vwBusProjectPage.id }"/>
					<input id="bcId" name="bcId" type="hidden" />
					<input id="fromCustId" name="fromCustId" type="hidden" />
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
		     	 <input id="bpProjId" name="bpProjId" type="text" maxlength="40" style="width: 150px;background-color:#F0F0F0;" readonly="true"  class="inputxt"  datatype="*" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td class="value">
		     	 <input id="bpProjName" name="bpProjName" type="text" maxlength="200" style="width: 150px" class="inputxt"  datatype="*" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">立项时间:</label>
			</td>
			<td class="value">
					  <input id="bpDate" name="bpDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">立项时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目关键人:</label>
			</td>
			<td class="value">
		     	 <input id="bpKeyPeople" name="bpKeyPeople" type="text" maxlength="20" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目关键人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目经理:</label>
			</td>
			<td class="value">
		     	 <input id="bpManager" name="bpManager" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore" />
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
                	createProjectId();
				},
                fitColumns: true" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目组成员:</label>
			</td>
			<td class="value">
		     	 <input id="bpTeam" name="bpTeam" type="text" maxlength="200" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目组成员</label>
			</td>
			<td align="right">
				<label class="Validform_label">方案输出时间:</label>
			</td>
			<td class="value">
					  <input id="bpOutTime" name="bpOutTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">方案输出时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">方案定稿时间:</label>
			</td>
			<td class="value">
					  <input id="bpFinishTime" name="bpFinishTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">方案定稿时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">正式挂网时间:</label>
			</td>
			<td class="value">
					  <input id="bpOnlineTime" name="bpOnlineTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">正式挂网时间</label>
			</td>
		</tr>
		
	
		<tr>
			<td align="right">
				<label class="Validform_label">项目简介:</label>
			</td>
			<td class="value" colspan="3">
					<!-- <script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
					<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
			    	<textarea name="bpIntroduction" id="bpIntroduction" style="width: 650px;height:300px"></textarea>
				    <script type="text/javascript">
				        var bpIntroduction_editor = UE.getEditor('bpIntroduction');
				    </script> -->
				<textarea style="height:auto;width:95%" class="inputxt" rows="2" id="bpIntroduction" name="bpIntroduction"  ignore="ignore" ></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目简介</label>
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<label class="Validform_label">问题or协助:</label>
			</td>
			<td class="value">
		     	 <textarea id="bpQuestions" name="bpQuestions" style="height:auto;width:95%" class="inputxt" rows="2"   ignore="ignore"></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">问题or协助</label>
			</td>
			<td align="right">
				<label class="Validform_label">产品解决方案:</label>
			</td>
			<td class="value">
		     	 <textarea id="bpProSolutions" name="bpProSolutions" style="height:auto;width:95%" class="inputxt" rows="2"   ignore="ignore"></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">产品解决方案</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">跟进结果:</label>
			</td>
			<td class="value">
				<textarea id="bpFollowResults" name="bpFollowResults" style="height:auto;width:95%" class="inputxt" rows="2"   ignore="ignore"></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">跟进结果</label>
			</td>
			
			<td align="right">
				<label class="Validform_label">竞争情况:</label>
			</td>
			<td class="value">
		     	 <textarea id="bpCompetition" name="bpCompetition" style="height:auto;width:95%" class="inputxt" rows="2"   ignore="ignore"></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">竞争情况</label>
			</td>
		</tr>
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="vwBusProjectController.do?busProjectFeeDetailList&id=${vwBusProjectPage.id}" icon="icon-search" title="项目立项费用明细" id="busProjectFeeDetail"></t:tab>
				 <t:tab href="vwBusProjectController.do?busProjectDisfollowList&id=${vwBusProjectPage.id}" icon="icon-search" title="分配跟进明细" id="busProjectDisfollow"></t:tab>
				 <t:tab href="vwBusProjectController.do?busProjPartnerList&id=${vwBusProjectPage.id}" icon="icon-search" title="立项合作伙伴资料" id="busProjPartner"></t:tab>
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
				  <td align="left">
					  	<input name="busProjectDisfollowList[#index#].bpdDisNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">跟进次数</label>
				  </td>
				  <td align="left">
							<input name="busProjectDisfollowList[#index#].bpdFollowDate" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">跟进日期</label>
				  </td>
				  <td align="left">
					  	<input name="busProjectDisfollowList[#index#].bpdStage" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目阶段</label>
				  </td>
				  <td align="left">
					  	<input name="busProjectDisfollowList[#index#].bpdFeedbackInto" maxlength="400" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">反馈信息</label>
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
	