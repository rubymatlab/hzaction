<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBusPoContractPayBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusPoContractPayBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#uploadBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#uploadBtn2').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBusPoContractPayBtn').bind('click', function(){   
 		 var tr =  $("#add_busPoContractPay_table_template tr").clone();
	 	 $("#add_busPoContractPay_table").append(tr);
	 	 resetTrNum('add_busPoContractPay_table');
	 	 return false;
    });  
	$('#delBusPoContractPayBtn').bind('click', function(){   
		$("#add_busPoContractPay_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busPoContractPay_table'); 
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
	<a id="addBusPoContractPayBtn" href="#">添加</a> 
	<a id="delBusPoContractPayBtn" href="#">删除</a>
 	<a id="uploadBtn" href="#">	采购情况汇报</a>
 	<a id="uploadBtn2" href="#">附件</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busPoContractPay_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用分期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						计划付款金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						计划付款日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						采购合同外键
				  </td>
	</tr>
	<tbody id="add_busPoContractPay_table">
	<c:if test="${fn:length(busPoContractPayList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busPoContractPayList[0].id" type="hidden"/>
					<input name="busPoContractPayList[0].createName" type="hidden"/>
					<input name="busPoContractPayList[0].createBy" type="hidden"/>
					<input name="busPoContractPayList[0].createDate" type="hidden"/>
					<input name="busPoContractPayList[0].updateName" type="hidden"/>
					<input name="busPoContractPayList[0].updateBy" type="hidden"/>
					<input name="busPoContractPayList[0].updateDate" type="hidden"/>
					<input name="busPoContractPayList[0].sysOrgCode" type="hidden"/>
					<input name="busPoContractPayList[0].sysCompanyCode" type="hidden"/>
					<input name="busPoContractPayList[0].bpmStatus" type="hidden"/>
				  <td align="left">
							<t:dictSelect field="busPoContractPayList[0].bpcpProgre" type="list"   typeGroupCode="cost_stag"  defaultVal="${busPoContractPayPage.bpcpProgre}" hasLabel="false"  title="费用分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用分期</label>
					</td>
				  <td align="left">
					  	<input name="busPoContractPayList[0].bpcpPayAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">计划付款金额</label>
					</td>
				  <td align="left">
							<input name="busPoContractPayList[0].bpcpDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">计划付款日期</label>
					</td>
				  <td align="left">
					  	<input name="busPoContractPayList[0].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(busPoContractPayList)  > 0 }">
		<c:forEach items="${busPoContractPayList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busPoContractPayList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="busPoContractPayList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="busPoContractPayList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="busPoContractPayList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="busPoContractPayList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="busPoContractPayList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="busPoContractPayList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="busPoContractPayList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="busPoContractPayList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="busPoContractPayList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
							<t:dictSelect field="busPoContractPayList[${stuts.index }].bpcpProgre" type="list"   typeGroupCode="cost_stag"  defaultVal="${poVal.bpcpProgre }" hasLabel="false"  title="费用分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用分期</label>
				   </td>
				   <td align="left">
					  	<input name="busPoContractPayList[${stuts.index }].bpcpPayAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcpPayAmount }"/>
					  <label class="Validform_label" style="display: none;">计划付款金额</label>
				   </td>
				   <td align="left">
							<input name="busPoContractPayList[${stuts.index }].bpcpDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.bpcpDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">计划付款日期</label>
				   </td>
				   <td align="left">
					  	<input name="busPoContractPayList[${stuts.index }].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
<script>
	$('#uploadBtn').linkbutton({   
	    iconCls: 'icon-undo'  
	}); 
	$('#uploadBtn2').linkbutton({   
	    iconCls: 'icon-undo'  
	}); 
	// 绑定采购请款汇报
	$('#uploadBtn').bind("click",function(e){
		 add("文件录入", "jeecgFormDemoController.do?addFiles","fList")
	})
</script>