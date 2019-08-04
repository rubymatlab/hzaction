<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBusContractPaymentBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusContractPaymentBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBusContractPaymentBtn').bind('click', function(){   
 		 var tr =  $("#add_busContractPayment_table_template tr").clone();
	 	 $("#add_busContractPayment_table").append(tr);
	 	 resetTrNum('add_busContractPayment_table');
	 	 return false;
    });  
	$('#delBusContractPaymentBtn').bind('click', function(){   
		$("#add_busContractPayment_table").find("input[name$='ck']:checked").parent().parent().remove();  
		resetTrNum('add_busContractPayment_table'); 
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
	<a id="addBusContractPaymentBtn" href="#">添加</a> <a id="delBusContractPaymentBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busContractPayment_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						进度款分期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						合同金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						付款条件
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						合同管理外键
				  </td>
	</tr>
	<tbody id="add_busContractPayment_table">
	<c:if test="${fn:length(busContractPaymentList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busContractPaymentList[0].id" type="hidden"/>
					<input name="busContractPaymentList[0].createName" type="hidden"/>
					<input name="busContractPaymentList[0].createBy" type="hidden"/>
					<input name="busContractPaymentList[0].createDate" type="hidden"/>
					<input name="busContractPaymentList[0].updateName" type="hidden"/>
					<input name="busContractPaymentList[0].updateBy" type="hidden"/>
					<input name="busContractPaymentList[0].updateDate" type="hidden"/>
					<input name="busContractPaymentList[0].sysOrgCode" type="hidden"/>
					<input name="busContractPaymentList[0].sysCompanyCode" type="hidden"/>
					<input name="busContractPaymentList[0].bpmStatus" type="hidden"/>
				  <td align="left">
							<t:dictSelect field="busContractPaymentList[0].bcpProgrePayment" type="list"   typeGroupCode="gathering"  defaultVal="${busContractPaymentPage.bcpProgrePayment}" hasLabel="false"  title="进度款分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">进度款分期</label>
					</td>
				  <td align="left">
					  	<input name="busContractPaymentList[0].bcpContractAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">合同金额</label>
					</td>
				  <td align="left">
					  	<input name="busContractPaymentList[0].bcpPaymentClause" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">付款条件</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[0].busContractId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">合同管理外键</label>
				  </td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(busContractPaymentList)  > 0 }">
		<c:forEach items="${busContractPaymentList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busContractPaymentList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="busContractPaymentList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="busContractPaymentList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="busContractPaymentList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="busContractPaymentList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="busContractPaymentList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="busContractPaymentList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="busContractPaymentList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="busContractPaymentList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="busContractPaymentList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
							<t:dictSelect field="busContractPaymentList[${stuts.index }].bcpProgrePayment" type="list"   typeGroupCode="gathering"  defaultVal="${poVal.bcpProgrePayment }" hasLabel="false"  title="进度款分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">进度款分期</label>
				   </td>
				   <td align="left">
					  	<input name="busContractPaymentList[${stuts.index }].bcpContractAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcpContractAmount }"/>
					  <label class="Validform_label" style="display: none;">合同金额</label>
				   </td>
				   <td align="left">
					  	<input name="busContractPaymentList[${stuts.index }].bcpPaymentClause" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcpPaymentClause }"/>
					  <label class="Validform_label" style="display: none;">付款条件</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[${stuts.index }].busContractId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.busContractId }"/>
					  <label class="Validform_label" style="display: none;">合同管理外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
