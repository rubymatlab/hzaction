<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBusProjectDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusProjectDetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBusProjectDetailBtn').bind('click', function(){   
 		 var tr =  $("#add_busProjectDetail_table_template tr").clone();
	 	 $("#add_busProjectDetail_table").append(tr);
	 	 resetTrNum('add_busProjectDetail_table');
	 	 return false;
    });  
	$('#delBusProjectDetailBtn').bind('click', function(){   
		$("#add_busProjectDetail_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busProjectDetail_table'); 
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
	<a id="addBusProjectDetailBtn" href="#">添加</a> <a id="delBusProjectDetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busProjectDetail_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						序号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						详细描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						项目立项外键
				  </td>
	</tr>
	<tbody id="add_busProjectDetail_table">
	<c:if test="${fn:length(busProjectDetailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busProjectDetailList[0].id" type="hidden"/>
					<input name="busProjectDetailList[0].createName" type="hidden"/>
					<input name="busProjectDetailList[0].createBy" type="hidden"/>
					<input name="busProjectDetailList[0].createDate" type="hidden"/>
					<input name="busProjectDetailList[0].updateName" type="hidden"/>
					<input name="busProjectDetailList[0].updateBy" type="hidden"/>
					<input name="busProjectDetailList[0].updateDate" type="hidden"/>
					<input name="busProjectDetailList[0].sysOrgCode" type="hidden"/>
					<input name="busProjectDetailList[0].sysCompanyCode" type="hidden"/>
					<input name="busProjectDetailList[0].bpmStatus" type="hidden"/>
				  <td align="left">
					  	<input name="busProjectDetailList[0].bpdSeq" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">序号</label>
					</td>
				  <td align="left">
					  	<input name="busProjectDetailList[0].bpdType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用类型</label>
					</td>
				  <td align="left">
					  	<input name="busProjectDetailList[0].bpdAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">金额</label>
					</td>
				  <td align="left">
					  	<input name="busProjectDetailList[0].bpdRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">详细描述</label>
					</td>
				  <td align="left">
					  	<input name="busProjectDetailList[0].fromBpid" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(busProjectDetailList)  > 0 }">
		<c:forEach items="${busProjectDetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busProjectDetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="busProjectDetailList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="busProjectDetailList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="busProjectDetailList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="busProjectDetailList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="busProjectDetailList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="busProjectDetailList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="busProjectDetailList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="busProjectDetailList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="busProjectDetailList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
					  	<input name="busProjectDetailList[${stuts.index }].bpdSeq" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpdSeq }"/>
					  <label class="Validform_label" style="display: none;">序号</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectDetailList[${stuts.index }].bpdType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpdType }"/>
					  <label class="Validform_label" style="display: none;">费用类型</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectDetailList[${stuts.index }].bpdAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.bpdAmount }"/>
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectDetailList[${stuts.index }].bpdRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpdRemark }"/>
					  <label class="Validform_label" style="display: none;">详细描述</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectDetailList[${stuts.index }].fromBpid" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromBpid }"/>
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
