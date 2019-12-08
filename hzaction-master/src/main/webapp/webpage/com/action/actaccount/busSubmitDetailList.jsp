<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBusSubmitDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusSubmitDetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBusSubmitDetailBtn').bind('click', function(){   
 		 var tr =  $("#add_busSubmitDetail_table_template tr").clone();
	 	 $("#add_busSubmitDetail_table").append(tr);
	 	 resetTrNum('add_busSubmitDetail_table');
	 	 return false;
    });  
	$('#delBusSubmitDetailBtn').bind('click', function(){   
		$("#add_busSubmitDetail_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busSubmitDetail_table'); 
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
	<a id="addBusSubmitDetailBtn" href="#">添加</a> <a id="delBusSubmitDetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busSubmitDetail_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <!-- <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						序号
				  </td> -->
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						报销金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						详细描述
				  </td>
	</tr>
	<tbody id="add_busSubmitDetail_table">
	<c:if test="${fn:length(busSubmitDetailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busSubmitDetailList[0].id" type="hidden"/>
					<input name="busSubmitDetailList[0].bpmStatus" type="hidden"/>
					<input name="busSubmitDetailList[0].createName" type="hidden"/>
					<input name="busSubmitDetailList[0].createBy" type="hidden"/>
					<input name="busSubmitDetailList[0].updateName" type="hidden"/>
					<input name="busSubmitDetailList[0].updateBy" type="hidden"/>
					<input name="busSubmitDetailList[0].sysOrgCode" type="hidden"/>
					<input name="busSubmitDetailList[0].sysCompanyCode" type="hidden"/>
					<input name="busSubmitDetailList[0].createDate" type="hidden"/>
					<input name="busSubmitDetailList[0].updateDate" type="hidden"/>
					<input name="busSubmitDetailList[0].fromId" type="hidden"/>
				  <!-- <td align="left">
					  	<input name="busSubmitDetailList[0].bsdSeqNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">序号</label>
					</td> -->
				  <td align="left">
							<t:dictSelect field="busSubmitDetailList[0].bsdFeeType" type="list"   typeGroupCode="cost_type"  defaultVal="${busSubmitDetailPage.bsdFeeType}" hasLabel="false"  title="费用类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类型</label>
					</td>
				  <td align="left">
					  	<input name="busSubmitDetailList[0].bsdAmount" onchange="handleInput()" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">报销金额</label>
					</td>
				  <td align="left">
					  	<input name="busSubmitDetailList[0].bsdDesc" maxlength="500" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">详细描述</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(busSubmitDetailList)  > 0 }">
		<c:forEach items="${busSubmitDetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busSubmitDetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="busSubmitDetailList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
						<input name="busSubmitDetailList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="busSubmitDetailList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="busSubmitDetailList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="busSubmitDetailList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="busSubmitDetailList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="busSubmitDetailList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="busSubmitDetailList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="busSubmitDetailList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="busSubmitDetailList[${stuts.index }].fromId" type="hidden" value="${poVal.fromId }"/>
				   <%-- <td align="left">
					  	<input name="busSubmitDetailList[${stuts.index }].bsdSeqNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore"  value="${poVal.bsdSeqNo }"/>
					  <label class="Validform_label" style="display: none;">序号</label>
				   </td> --%>
				   <td align="left">
							<t:dictSelect field="busSubmitDetailList[${stuts.index }].bsdFeeType" type="list"   typeGroupCode="cost_type"  defaultVal="${poVal.bsdFeeType }" hasLabel="false"  title="费用类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类型</label>
				   </td>
				   <td align="left">
					  	<input name="busSubmitDetailList[${stuts.index }].bsdAmount" maxlength="32" type="text" onchange="handleInput()" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.bsdAmount }"/>
					  <label class="Validform_label" style="display: none;">报销金额</label>
				   </td>
				   <td align="left">
					  	<input name="busSubmitDetailList[${stuts.index }].bsdDesc" maxlength="500" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bsdDesc }"/>
					  <label class="Validform_label" style="display: none;">详细描述</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
