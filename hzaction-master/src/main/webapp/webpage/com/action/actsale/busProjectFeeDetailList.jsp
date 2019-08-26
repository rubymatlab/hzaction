<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBusProjectFeeDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusProjectFeeDetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBusProjectFeeDetailBtn').bind('click', function(){   
 		 var tr =  $("#add_busProjectFeeDetail_table_template tr").clone();
	 	 $("#add_busProjectFeeDetail_table").append(tr);
	 	 resetTrNum('add_busProjectFeeDetail_table');
	 	 return false;
    });  
	$('#delBusProjectFeeDetailBtn').bind('click', function(){   
		$("#add_busProjectFeeDetail_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busProjectFeeDetail_table'); 
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
	<a id="addBusProjectFeeDetailBtn" href="#">添加</a> <a id="delBusProjectFeeDetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busProjectFeeDetail_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
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
	<tbody id="add_busProjectFeeDetail_table">
	<c:if test="${fn:length(busProjectFeeDetailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busProjectFeeDetailList[0].id" type="hidden"/>
					<input name="busProjectFeeDetailList[0].createName" type="hidden"/>
					<input name="busProjectFeeDetailList[0].createBy" type="hidden"/>
					<input name="busProjectFeeDetailList[0].createDate" type="hidden"/>
					<input name="busProjectFeeDetailList[0].updateName" type="hidden"/>
					<input name="busProjectFeeDetailList[0].updateBy" type="hidden"/>
					<input name="busProjectFeeDetailList[0].updateDate" type="hidden"/>
					<input name="busProjectFeeDetailList[0].sysOrgCode" type="hidden"/>
					<input name="busProjectFeeDetailList[0].sysCompanyCode" type="hidden"/>
					<input name="busProjectFeeDetailList[0].bpmStatus" type="hidden"/>
				  <td align="left">
					  	<input name="busProjectFeeDetailList[0].bpfFeeType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用类型</label>
					</td>
				  <td align="left">
					  	<input name="busProjectFeeDetailList[0].bpfAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">金额</label>
					</td>
				  <td align="left">
					  	<input name="busProjectFeeDetailList[0].bpfDesc" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">详细描述</label>
					</td>
				  <td align="left">
					  	<input name="busProjectFeeDetailList[0].fromId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(busProjectFeeDetailList)  > 0 }">
		<c:forEach items="${busProjectFeeDetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busProjectFeeDetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="busProjectFeeDetailList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="busProjectFeeDetailList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="busProjectFeeDetailList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="busProjectFeeDetailList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="busProjectFeeDetailList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="busProjectFeeDetailList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="busProjectFeeDetailList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="busProjectFeeDetailList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="busProjectFeeDetailList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
					  	<input name="busProjectFeeDetailList[${stuts.index }].bpfFeeType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpfFeeType }"/>
					  <label class="Validform_label" style="display: none;">费用类型</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectFeeDetailList[${stuts.index }].bpfAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.bpfAmount }"/>
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectFeeDetailList[${stuts.index }].bpfDesc" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpfDesc }"/>
					  <label class="Validform_label" style="display: none;">详细描述</label>
				   </td>
				   <td align="left">
					  	<input name="busProjectFeeDetailList[${stuts.index }].fromId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
