<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBusProjectDisfollowBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusProjectDisfollowBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBusProjectDisfollowBtn').bind('click', function(){   
 		 var tr =  $("#add_busProjectDisfollow_table_template tr").clone();
	 	 $("#add_busProjectDisfollow_table").append(tr);
	 	 resetTrNum('add_busProjectDisfollow_table');
	 	 return false;
    });  
	$('#delBusProjectDisfollowBtn').bind('click', function(){   
		$("#add_busProjectDisfollow_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busProjectDisfollow_table'); 
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
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addBusProjectDisfollowBtn" href="#">添加</a> <a id="delBusProjectDisfollowBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busProjectDisfollow_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						跟进次数
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						跟进日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						项目阶段
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						反馈信息
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;display:none;">
						项目立项外键
				  </td>
	</tr>
	<tbody id="add_busProjectDisfollow_table">
	<c:if test="${fn:length(busProjectDisfollowList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busProjectDisfollowList[0].id" type="hidden"/>
					<input name="busProjectDisfollowList[0].createName" type="hidden"/>
					<input name="busProjectDisfollowList[0].createBy" type="hidden"/>
					<input name="busProjectDisfollowList[0].createDate" type="hidden"/>
					<input name="busProjectDisfollowList[0].updateName" type="hidden"/>
					<input name="busProjectDisfollowList[0].updateBy" type="hidden"/>
					<input name="busProjectDisfollowList[0].updateDate" type="hidden"/>
					<input name="busProjectDisfollowList[0].sysOrgCode" type="hidden"/>
					<input name="busProjectDisfollowList[0].sysCompanyCode" type="hidden"/>
					<input name="busProjectDisfollowList[0].bpmStatus" type="hidden"/>
				  <td align="left">
					  	<input name="busProjectDisfollowList[0].bpdDisNo" maxlength="32" type="text" class="inputxt" datatype="n"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">跟进次数</label>
					</td>
				  <td align="left">
							<input name="busProjectDisfollowList[0].bpdFollowDate" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">跟进日期</label>
					</td>
				  <td align="left">
					  	<input name="busProjectDisfollowList[0].bpdStage" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目阶段</label>
					</td>
				  <td align="left">
					  	<input name="busProjectDisfollowList[0].bpdFeedbackInto" maxlength="400" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">反馈信息</label>
					</td>
				  <td align="left" style="display:none;">
					  	<input name="busProjectDisfollowList[0].fromId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(busProjectDisfollowList)  > 0 }">
		<c:forEach items="${busProjectDisfollowList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busProjectDisfollowList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="busProjectDisfollowList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="busProjectDisfollowList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="busProjectDisfollowList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="busProjectDisfollowList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="busProjectDisfollowList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="busProjectDisfollowList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="busProjectDisfollowList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="busProjectDisfollowList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="busProjectDisfollowList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
					  	<input name="busProjectDisfollowList[${stuts.index }].bpdDisNo" maxlength="32" type="text" class="inputxt" datatype="n"  style="width:120px;"  ignore="ignore"  value="${poVal.bpdDisNo }"/>
					  <label class="Validform_label" style="display: none;">跟进次数</label>
				   </td>
				   <td align="left">
							<input name="busProjectDisfollowList[${stuts.index }].bpdFollowDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.bpdFollowDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">跟进日期</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectDisfollowList[${stuts.index }].bpdStage" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpdStage }"/>
					  <label class="Validform_label" style="display: none;">项目阶段</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectDisfollowList[${stuts.index }].bpdFeedbackInto" maxlength="400" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpdFeedbackInto }"/>
					  <label class="Validform_label" style="display: none;">反馈信息</label>
				   </td>
				   <td align="left" style="display:none;">
					  	<input name="busProjectDisfollowList[${stuts.index }].fromId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
