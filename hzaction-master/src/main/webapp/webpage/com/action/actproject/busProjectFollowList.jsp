<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addBusProjectFollowBtn" href="#">添加</a> <a id="delBusProjectFollowBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busProjectFollow_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						跟进日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						跟进情况汇报
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						施工困难_问题
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						下一步计划
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						计划验收时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						验收结果
				  </td>
<!-- 				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						项目管理外键
				  </td> -->
	</tr>
	<tbody id="add_busProjectFollow_table">
	<c:if test="${fn:length(busProjectFollowList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busProjectFollowList[0].id" type="hidden"/>
					<input name="busProjectFollowList[0].createName" type="hidden"/>
					<input name="busProjectFollowList[0].createBy" type="hidden"/>
					<input name="busProjectFollowList[0].createDate" type="hidden"/>
					<input name="busProjectFollowList[0].updateName" type="hidden"/>
					<input name="busProjectFollowList[0].updateBy" type="hidden"/>
					<input name="busProjectFollowList[0].updateDate" type="hidden"/>
					<input name="busProjectFollowList[0].sysOrgCode" type="hidden"/>
					<input name="busProjectFollowList[0].sysCompanyCode" type="hidden"/>
					<input name="busProjectFollowList[0].bpmStatus" type="hidden"/>
				  <td align="left">
							<input name="busProjectFollowList[0].bpfFollowDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">跟进日期</label>
					</td>
				  <td align="left">
					  	<input name="busProjectFollowList[0].bpfFollowReport" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">跟进情况汇报</label>
					</td>
				  <td align="left">
					  	<input name="busProjectFollowList[0].bpfQuestions" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">施工困难_问题</label>
					</td>
				  <td align="left">
					  	<input name="busProjectFollowList[0].bpfNextPlan" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">下一步计划</label>
					</td>
				  <td align="left">
							<input name="busProjectFollowList[0].bpfCheckDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">验收时间</label>
					</td>
				  <td align="left">
							<t:dictSelect field="busProjectFollowList[0].bpfCheckResult" type="list"   typeGroupCode="check_res"  defaultVal="${busProjectFollowPage.bpfCheckResult}" hasLabel="false"  title="验收结果"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">验收结果</label>
					</td>
<!-- 				  <td align="left">
					  	<input name="busProjectFollowList[0].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目管理外键</label>
					</td> -->
   			</tr>
	</c:if>
	<c:if test="${fn:length(busProjectFollowList)  > 0 }">
		<c:forEach items="${busProjectFollowList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busProjectFollowList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="busProjectFollowList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="busProjectFollowList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="busProjectFollowList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="busProjectFollowList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="busProjectFollowList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="busProjectFollowList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="busProjectFollowList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="busProjectFollowList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="busProjectFollowList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
							<input name="busProjectFollowList[${stuts.index }].bpfFollowDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.bpfFollowDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">跟进日期</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectFollowList[${stuts.index }].bpfFollowReport" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpfFollowReport }"/>
					  <label class="Validform_label" style="display: none;">跟进情况汇报</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectFollowList[${stuts.index }].bpfQuestions" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpfQuestions }"/>
					  <label class="Validform_label" style="display: none;">施工困难_问题</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectFollowList[${stuts.index }].bpfNextPlan" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpfNextPlan }"/>
					  <label class="Validform_label" style="display: none;">下一步计划</label>
				   </td>
				   <td align="left">
							<input name="busProjectFollowList[${stuts.index }].bpfCheckDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.bpfCheckDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">验收时间</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="busProjectFollowList[${stuts.index }].bpfCheckResult" type="list"   typeGroupCode="check_res"  defaultVal="${poVal.bpfCheckResult }" hasLabel="false"  title="验收结果"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">验收结果</label>
				   </td>
<%-- 				   <td align="left">
					  	<input name="busProjectFollowList[${stuts.index }].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">项目管理外键</label>
				   </td> --%>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
<script type="text/javascript">
	$('#addBusProjectFollowBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusProjectFollowBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBusProjectFollowBtn').bind('click', function(){   
 		 var tr =  $("#add_busProjectFollow_table_template tr").clone();
	 	 $("#add_busProjectFollow_table").append(tr);
	 	 resetTrNum('add_busProjectFollow_table');
	 	 return false;
    });  
	$('#delBusProjectFollowBtn').bind('click', function(){   
		$("#add_busProjectFollow_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busProjectFollow_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
</script>
