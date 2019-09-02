<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addVwBusPoContractPayBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delVwBusPoContractPayBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addVwBusPoContractPayBtn').bind('click', function(){   
 		 var tr =  $("#add_vwBusPoContractPay_table_template tr").clone();
	 	 $("#add_vwBusPoContractPay_table").append(tr);
	 	 resetTrNum('add_vwBusPoContractPay_table');
	 	 return false;
    });  
	$('#delVwBusPoContractPayBtn').bind('click', function(){   
		$("#add_vwBusPoContractPay_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_vwBusPoContractPay_table'); 
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
<!-- <div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addVwBusPoContractPayBtn" href="#">添加</a> <a id="delVwBusPoContractPayBtn" href="#">删除</a> 
</div> -->
<table border="0" cellpadding="2" cellspacing="0" id="vwBusPoContractPay_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<!-- <td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td> -->
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						项目编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						项目名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用分期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						计划付款日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						计划付款金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						实际付款日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						付款金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						项目结算id
				  </td>
	</tr>
	<tbody id="add_vwBusPoContractPay_table">
	<c:if test="${fn:length(vwBusPoContractPayList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<!-- <td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td> -->
					<input name="vwBusPoContractPayList[0].id" type="hidden"/>
				  <td align="left">
					  	<input name="vwBusPoContractPayList[0].bpmProjId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目编号</label>
					</td>
				  <td align="left">
					  	<input name="vwBusPoContractPayList[0].bpmName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目名称</label>
					</td>
				  <td align="left">
					  	<input name="vwBusPoContractPayList[0].bpcpProgreName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用分期</label>
					</td>
				  <td align="left">
					  	<input name="vwBusPoContractPayList[0].bpcpDate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">计划付款日期</label>
					</td>
				  <td align="left">
					  	<input name="vwBusPoContractPayList[0].bpcpPayAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">计划付款金额</label>
					</td>
				  <td align="left">
					  	<input name="vwBusPoContractPayList[0].bppPayDate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">实际付款日期</label>
					</td>
				  <td align="left">
					  	<input name="vwBusPoContractPayList[0].payAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">付款金额</label>
					</td>
				  <td align="left">
					  	<input name="vwBusPoContractPayList[0].formCostAccountId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目结算id</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(vwBusPoContractPayList)  > 0 }">
		<c:forEach items="${vwBusPoContractPayList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<!-- <td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td> -->
						<input name="vwBusPoContractPayList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				   <td align="left">
					  	<input name="vwBusPoContractPayList[${stuts.index }].bpmProjId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpmProjId }"/>
					  <label class="Validform_label" style="display: none;">项目编号</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusPoContractPayList[${stuts.index }].bpmName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpmName }"/>
					  <label class="Validform_label" style="display: none;">项目名称</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusPoContractPayList[${stuts.index }].bpcpProgreName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcpProgreName }"/>
					  <label class="Validform_label" style="display: none;">费用分期</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusPoContractPayList[${stuts.index }].bpcpDate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcpDate }"/>
					  <label class="Validform_label" style="display: none;">计划付款日期</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusPoContractPayList[${stuts.index }].bpcpPayAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcpPayAmount }"/>
					  <label class="Validform_label" style="display: none;">计划付款金额</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusPoContractPayList[${stuts.index }].bppPayDate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bppPayDate }"/>
					  <label class="Validform_label" style="display: none;">实际付款日期</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusPoContractPayList[${stuts.index }].payAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.payAmount }"/>
					  <label class="Validform_label" style="display: none;">付款金额</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusPoContractPayList[${stuts.index }].formCostAccountId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.formCostAccountId }"/>
					  <label class="Validform_label" style="display: none;">项目结算id</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
