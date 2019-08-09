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
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						创建人名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						创建人登录名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						创建日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						更新人名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						更新人登录名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						更新日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						所属部门
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						所属公司
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						流程状态
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						序号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						合同金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						付款条件
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						进度款分期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						合同管理外键
				  </td>
	</tr>
	<tbody id="add_busContractPayment_table">
	<c:if test="${fn:length(busContractPaymentList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busContractPaymentList[0].id" type="hidden"/>
				  <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[0].createName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">创建人名称</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[0].createBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">创建人登录名称</label>
					</td>
				  <td align="left" hidden="hidden">
							<input name="busContractPaymentList[0].createDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">创建日期</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[0].updateName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">更新人名称</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[0].updateBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">更新人登录名称</label>
					</td>
				  <td align="left" hidden="hidden">
							<input name="busContractPaymentList[0].updateDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">更新日期</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[0].sysOrgCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">所属部门</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[0].sysCompanyCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">所属公司</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[0].bpmStatus" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">流程状态</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[0].bcpSeqNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">序号</label>
					</td>
				  <td align="left">
					  	<input name="busContractPaymentList[0].bcpContractAmount" maxlength="10" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">合同金额</label>
					</td>
				  <td align="left">
					  	<input name="busContractPaymentList[0].bcpPaymentClause" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">付款条件</label>
					</td>
				  <td align="left">
							<t:dictSelect field="busContractPaymentList[0].bcpProgrePayment" type="list"   typeGroupCode="cost_stag"  defaultVal="${busContractPaymentPage.bcpProgrePayment}" hasLabel="false"  title="进度款分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">进度款分期</label>
					</td>
				  <td align="left">
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
				   <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[${stuts.index }].createName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.createName }"/>
					  <label class="Validform_label" style="display: none;">创建人名称</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[${stuts.index }].createBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.createBy }"/>
					  <label class="Validform_label" style="display: none;">创建人登录名称</label>
				   </td>
				   <td align="left" hidden="hidden">
							<input name="busContractPaymentList[${stuts.index }].createDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.createDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">创建日期</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[${stuts.index }].updateName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.updateName }"/>
					  <label class="Validform_label" style="display: none;">更新人名称</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[${stuts.index }].updateBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.updateBy }"/>
					  <label class="Validform_label" style="display: none;">更新人登录名称</label>
				   </td>
				   <td align="left" hidden="hidden">
							<input name="busContractPaymentList[${stuts.index }].updateDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.updateDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">更新日期</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[${stuts.index }].sysOrgCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.sysOrgCode }"/>
					  <label class="Validform_label" style="display: none;">所属部门</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[${stuts.index }].sysCompanyCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.sysCompanyCode }"/>
					  <label class="Validform_label" style="display: none;">所属公司</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[${stuts.index }].bpmStatus" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpmStatus }"/>
					  <label class="Validform_label" style="display: none;">流程状态</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="busContractPaymentList[${stuts.index }].bcpSeqNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcpSeqNo }"/>
					  <label class="Validform_label" style="display: none;">序号</label>
				   </td>
				   <td align="left">
					  	<input name="busContractPaymentList[${stuts.index }].bcpContractAmount" maxlength="10" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore"  value="${poVal.bcpContractAmount }"/>
					  <label class="Validform_label" style="display: none;">合同金额</label>
				   </td>
				   <td align="left">
					  	<input name="busContractPaymentList[${stuts.index }].bcpPaymentClause" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcpPaymentClause }"/>
					  <label class="Validform_label" style="display: none;">付款条件</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="busContractPaymentList[${stuts.index }].bcpProgrePayment" type="list"   typeGroupCode="cost_stag"  defaultVal="${poVal.bcpProgrePayment }" hasLabel="false"  title="进度款分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">进度款分期</label>
				   </td>
				   <td align="left">
					  	<input name="busContractPaymentList[${stuts.index }].busContractId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.busContractId }"/>
					  <label class="Validform_label" style="display: none;">合同管理外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
