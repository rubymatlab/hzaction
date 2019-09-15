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
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						流程状态
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						创建人名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						创建人登录名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						更新人名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						更新人登录名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						所属部门
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						所属公司
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						创建日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						更新日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						预算
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
				  <td hidden="hidden" align="left" bgcolor="#EEEEEE" style="width: 126px;">
						合同管理主表外键
				  </td>
	</tr>
	<tbody id="add_busCostBudgeting_table">
	<c:if test="${fn:length(busCostBudgetingList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busCostBudgetingList[0].id" type="hidden"/>
				  <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[0].bpmStatus" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">流程状态</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[0].createName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">创建人名称</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[0].createBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">创建人登录名称</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[0].updateName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">更新人名称</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[0].updateBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">更新人登录名称</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[0].sysOrgCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">所属部门</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[0].sysCompanyCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">所属公司</label>
					</td>
				  <td align="left" hidden="hidden">
							<input name="busCostBudgetingList[0].createDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">创建日期</label>
					</td>
				  <td align="left" hidden="hidden">
							<input name="busCostBudgetingList[0].updateDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">更新日期</label>
					</td>
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
				   <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[${stuts.index }].bpmStatus" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpmStatus }"/>
					  <label class="Validform_label" style="display: none;">流程状态</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[${stuts.index }].createName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.createName }"/>
					  <label class="Validform_label" style="display: none;">创建人名称</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[${stuts.index }].createBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.createBy }"/>
					  <label class="Validform_label" style="display: none;">创建人登录名称</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[${stuts.index }].updateName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.updateName }"/>
					  <label class="Validform_label" style="display: none;">更新人名称</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[${stuts.index }].updateBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.updateBy }"/>
					  <label class="Validform_label" style="display: none;">更新人登录名称</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[${stuts.index }].sysOrgCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.sysOrgCode }"/>
					  <label class="Validform_label" style="display: none;">所属部门</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busCostBudgetingList[${stuts.index }].sysCompanyCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.sysCompanyCode }"/>
					  <label class="Validform_label" style="display: none;">所属公司</label>
				   </td>
				   <td align="left" hidden="hidden">
							<input name="busCostBudgetingList[${stuts.index }].createDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.createDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">创建日期</label>
				   </td>
				   <td align="left" hidden="hidden">
							<input name="busCostBudgetingList[${stuts.index }].updateDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.updateDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">更新日期</label>
				   </td>
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
