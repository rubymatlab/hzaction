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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="busProjectController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${busProjectPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
		     	 <input id="bpProjId" name="bpProjId" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td class="value">
		     	 <input id="bpProjName" name="bpProjName" type="text" maxlength="200" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">立项时间:</label>
			</td>
			<td class="value">
					  <input id="bpDate" name="bpDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
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
				<label class="Validform_label">产品解决方案:</label>
			</td>
			<td class="value">
		     	 <input id="bpProSolutions" name="bpProSolutions" type="text" maxlength="500" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">产品解决方案</label>
			</td>
			<td align="right">
				<label class="Validform_label">问题or协助:</label>
			</td>
			<td class="value">
		     	 <input id="bpQuestions" name="bpQuestions" type="text" maxlength="500" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">问题or协助</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">竞争情况:</label>
			</td>
			<td class="value">
		     	 <input id="bpCompetition" name="bpCompetition" type="text" maxlength="500" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">竞争情况</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目经理:</label>
			</td>
			<td class="value">
		     	 <input id="bpManager" name="bpManager" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目经理</label>
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
				<label class="Validform_label">跟进结果:</label>
			</td>
			<td class="value">
		     	 <input id="bpFollowResults" name="bpFollowResults" type="text" maxlength="20" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">跟进结果</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户资料外键:</label>
			</td>
			<td class="value">
		     	 <input id="fromCustId" name="fromCustId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户资料外键</label>
			</td>
		</tr>
	
		<tr>
			<td align="right">
				<label class="Validform_label">项目简介:</label>
			</td>
			<td class="value" colspan="3">
					<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
					<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
			    	<textarea name="bpIntroduction" id="bpIntroduction" style="width: 650px;height:300px"></textarea>
				    <script type="text/javascript">
				        var bpIntroduction_editor = UE.getEditor('bpIntroduction');
				    </script>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目简介</label>
			</td>
		</tr>
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="busProjectController.do?busProjectFeeDetailList&id=${busProjectPage.id}" icon="icon-search" title="项目立项费用明细" id="busProjectFeeDetail"></t:tab>
				 <t:tab href="busProjectController.do?busProjectDisfollowList&id=${busProjectPage.id}" icon="icon-search" title="分配跟进明细" id="busProjectDisfollow"></t:tab>
				 <t:tab href="busProjectController.do?busProjPartnerList&id=${busProjectPage.id}" icon="icon-search" title="立项合作伙伴资料" id="busProjPartner"></t:tab>
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
					  	<input name="busProjectFeeDetailList[#index#].bpfFeeType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
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
					  	<input name="busProjectFeeDetailList[#index#].fromId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
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
					  	<input name="busProjectDisfollowList[#index#].fromId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
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
					  	<input name="busProjPartnerList[#index#].fromId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actsale/busProject.js"></script>
	