<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBusCostBudgetingBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusCostBudgetingBtn').linkbutton({
	    iconCls: 'icon-remove'
	}); 
	$('#addBusCostBudgetingBtn').bind('click', function(){   
 		 var tr =  $("#add_busCostBudgeting_table_template tr").clone();
	 	 $("#add_busCostBudgeting_table").append(tr);
	 	 resetTrNum('add_busCostBudgeting_table');
	 	 return false;
    });
	$('#delBusCostBudgetingBtn').bind('click', function(){   
		$("#add_busCostBudgeting_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busCostBudgeting_table'); 
        console.log("--bind click--");
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
	<a id="addBusCostBudgetingBtn" href="#">添加</a> <a id="delBusCostBudgetingBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busCostBudgeting_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						预算
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						合同管理主表外键
				  </td>
	</tr>
	<tbody id="add_busCostBudgeting_table">
	<c:if test="${fn:length(busCostBudgetingList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busCostBudgetingList[0].id" type="hidden"/>
					<input name="busCostBudgetingList[0].bpmStatus" type="hidden"/>
					<input name="busCostBudgetingList[0].createName" type="hidden"/>
					<input name="busCostBudgetingList[0].createBy" type="hidden"/>
					<input name="busCostBudgetingList[0].updateName" type="hidden"/>
					<input name="busCostBudgetingList[0].updateBy" type="hidden"/>
					<input name="busCostBudgetingList[0].sysOrgCode" type="hidden"/>
					<input name="busCostBudgetingList[0].sysCompanyCode" type="hidden"/>
					<input name="busCostBudgetingList[0].createDate" type="hidden"/>
					<input name="busCostBudgetingList[0].updateDate" type="hidden"/>
				  <td align="left">
							<t:dictSelect field="busCostBudgetingList[0].bcbCostType" type="list"   typeGroupCode="cost_type"  defaultVal="${busCostBudgetingPage.bcbCostType}" hasLabel="false"  title="费用类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类型</label>
					</td>
				  <td align="left">
					  	<input name="busCostBudgetingList[0].bcbBudget" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">预算</label>
					</td>
				  <td align="left">
					  	<input name="busCostBudgetingList[0].bcbRemark" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[0].busContractId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">合同管理主表外键</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(busCostBudgetingList)  > 0 }">
		<c:forEach items="${busCostBudgetingList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busCostBudgetingList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="busCostBudgetingList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
						<input name="busCostBudgetingList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="busCostBudgetingList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="busCostBudgetingList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="busCostBudgetingList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="busCostBudgetingList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="busCostBudgetingList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="busCostBudgetingList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="busCostBudgetingList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
				   <td align="left">
							<t:dictSelect field="busCostBudgetingList[${stuts.index }].bcbCostType" type="list"   typeGroupCode="cost_type"  defaultVal="${poVal.bcbCostType }" hasLabel="false"  title="费用类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类型</label>
				   </td>
				   <td align="left">
					  	<input name="busCostBudgetingList[${stuts.index }].bcbBudget" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcbBudget }"/>
					  <label class="Validform_label" style="display: none;">预算</label>
				   </td>
				   <td align="left">
					  	<input name="busCostBudgetingList[${stuts.index }].bcbRemark" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcbRemark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[${stuts.index }].busContractId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.busContractId }"/>
					  <label class="Validform_label" style="display: none;">合同管理主表外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
