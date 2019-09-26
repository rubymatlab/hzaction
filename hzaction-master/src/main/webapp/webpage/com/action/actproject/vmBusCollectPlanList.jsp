<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addVmBusCollectPlanBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delVmBusCollectPlanBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addVmBusCollectPlanBtn').bind('click', function(){   
 		 var tr =  $("#add_vmBusCollectPlan_table_template tr").clone();
	 	 $("#add_vmBusCollectPlan_table").append(tr);
	 	 resetTrNum('add_vmBusCollectPlan_table');
	 	 return false;
    });  
	$('#delVmBusCollectPlanBtn').bind('click', function(){   
		$("#add_vmBusCollectPlan_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_vmBusCollectPlan_table'); 
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
	<!-- <a id="addVmBusCollectPlanBtn" href="#">添加</a> <a id="delVmBusCollectPlanBtn" href="#">删除</a>  -->
</div>
<table border="0" cellpadding="2" cellspacing="0" id="vmBusCollectPlan_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
<!-- 		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td> -->
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						进度款分期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						合同金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						预计回款日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						预计回款金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						计划开票时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						已收金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						发票金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						开票日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
<!-- 				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						项目管理外键
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						合同约定收款外键
				  </td> -->
	</tr>
	<tbody id="add_vmBusCollectPlan_table">
	<c:if test="${fn:length(vmBusCollectPlanList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
<!-- 				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td> -->
					<input name="vmBusCollectPlanList[0].id" type="hidden"/>
					<input name="vmBusCollectPlanList[0].createName" type="hidden"/>
					<input name="vmBusCollectPlanList[0].createBy" type="hidden"/>
					<input name="vmBusCollectPlanList[0].createDate" type="hidden"/>
					<input name="vmBusCollectPlanList[0].updateName" type="hidden"/>
					<input name="vmBusCollectPlanList[0].updateBy" type="hidden"/>
					<input name="vmBusCollectPlanList[0].updateDate" type="hidden"/>
					<input name="vmBusCollectPlanList[0].sysOrgCode" type="hidden"/>
					<input name="vmBusCollectPlanList[0].sysCompanyCode" type="hidden"/>
					<input name="vmBusCollectPlanList[0].bpmStatus" type="hidden"/>
				  <td align="left">
							<t:dictSelect field="vmBusCollectPlanList[0].brpProgressStages" type="list"   typeGroupCode="gathering"  defaultVal="${vmBusCollectPlanPage.brpProgressStages}" hasLabel="false"  title="进度款分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">进度款分期</label>
					</td>
				  <td align="left">
					  	<input name="vmBusCollectPlanList[0].brpContractAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">合同金额</label>
					</td>
				  <td align="left">
							<input name="vmBusCollectPlanList[0].brpExtBackDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">预计回款日期</label>
					</td>
				  <td align="left">
					  	<input name="vmBusCollectPlanList[0].brpBackAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">预计回款金额</label>
					</td>
				  <td align="left">
					  	<input name="vmBusCollectPlanList[0].brpAcceptAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">已收金额</label>
					</td>
				  <td align="left">
					  	<input name="vmBusCollectPlanList[0].brpIsInvoice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">发票金额</label>
					</td>
				  <td align="left">
							<input name="vmBusCollectPlanList[0].brpInvoiceDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">开票日期</label>
					</td>
				  <td align="left">
					  	<input name="vmBusCollectPlanList[0].brpRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
<!-- 				  <td align="left">
					  	<input name="vmBusCollectPlanList[0].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目管理外键</label>
					</td>
				  <td align="left">
					  	<input name="vmBusCollectPlanList[0].fromConpayId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">合同约定收款外键</label>
					</td> -->
   			</tr>
	</c:if>
	<c:if test="${fn:length(vmBusCollectPlanList)  > 0 }">
		<c:forEach items="${vmBusCollectPlanList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
<!-- 				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td> -->
						<input name="vmBusCollectPlanList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="vmBusCollectPlanList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="vmBusCollectPlanList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="vmBusCollectPlanList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="vmBusCollectPlanList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="vmBusCollectPlanList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="vmBusCollectPlanList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="vmBusCollectPlanList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="vmBusCollectPlanList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="vmBusCollectPlanList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
							<t:dictSelect field="vmBusCollectPlanList[${stuts.index }].brpProgressStages" type="list" readonly="readonly"  typeGroupCode="gathering"  defaultVal="${poVal.brpProgressStages }" hasLabel="false"  title="进度款分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">进度款分期</label>
				   </td>
				   <td align="left">
					  	<input name="vmBusCollectPlanList[${stuts.index }].brpContractAmount" readonly="readonly" maxlength="32" type="text" class="inputxt all_amount"  style="width:120px;"  ignore="ignore"  value="${poVal.brpContractAmount }"/>
					  <label class="Validform_label" style="display: none;">合同金额</label>
				   </td>
				   <td align="left">
							<input name="vmBusCollectPlanList[${stuts.index }].brpExtBackDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.brpExtBackDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">预计回款日期</label>
				   </td>
				   <td align="left">
					  	<input name="vmBusCollectPlanList[${stuts.index }].brpBackAmount" maxlength="32" type="text" class="inputxt back_amount"  style="width:120px;"  ignore="ignore"  value="${poVal.brpBackAmount }"/>
					  <label class="Validform_label" style="display: none;">预计回款金额</label>
				   </td>
				   <td align="left">
							<input name="vmBusCollectPlanList[${stuts.index }].brpPlanInvoiceDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.brpPlanInvoiceDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">计划开票日期</label>
				   </td>
				   <td align="left">
					  	<input name="vmBusCollectPlanList[${stuts.index }].brpAcceptAmount" maxlength="32" readonly="readonly" type="text" class="inputxt backed_amount"  style="width:120px;"  ignore="ignore"  value="${poVal.brpAcceptAmount }"/>
					  <label class="Validform_label" style="display: none;">已收金额</label>
				   </td>
				   <td align="left">
					  	<input name="vmBusCollectPlanList[${stuts.index }].brpIsInvoice" maxlength="32" readonly="readonly" type="text" class="inputxt invoice_amount"  style="width:120px;"  ignore="ignore"  value="${poVal.brpIsInvoice }"/>
					  <label class="Validform_label" style="display: none;">发票金额</label>
				   </td>
				   <td align="left">
							<input name="vmBusCollectPlanList[${stuts.index }].brpInvoiceDate" maxlength="0" readonly="readonly" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.brpInvoiceDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">开票日期</label>
				   </td>
				   <td align="left">
					  	<input name="vmBusCollectPlanList[${stuts.index }].brpRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.brpRemark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
<%-- 				   <td align="left">
					  	<input name="vmBusCollectPlanList[${stuts.index }].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">项目管理外键</label>
				   </td>
				   <td align="left">
					  	<input name="vmBusCollectPlanList[${stuts.index }].fromConpayId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromConpayId }"/>
					  <label class="Validform_label" style="display: none;">合同约定收款外键</label>
				   </td> --%>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>



<!-- start -->

<style>
.y_follow_table{
	width: 800px;
	margin-top: 30px;
}

.y_follow_table  tr label{
	width: 120px;
	display: inline-block;
	text-align: right;
}

</style>

<table class="y_follow_table">
	<tr>
		<td>
			<label for="name">合同金额:</label>
    		<input class="easyui-validatebox res_total_amount" disabled="disabled" type="text" name="name" />
		</td>
		<td>
			<label for="name">预计回款金额:</label>
    		<input class="easyui-validatebox res_back_amount" disabled="disabled" type="text" name="name" />
		</td>
	</tr>
	<tr>
		<td>
			<label for="name">已收总金额:</label>
    		<input class="easyui-validatebox res_backed_amount" disabled="disabled" type="text" name="name" />
		</td>
		<td>
			<label for="name">未收总金额:</label>
    		<input class="easyui-validatebox res_backed_amount_surplus" disabled="disabled" type="text" name="name" />
		</td>
	</tr>
	<tr>
		<td>
			<label for="name">已开票金额:</label>
    		<input class="easyui-validatebox res_invoice_amount"  disabled="disabled" type="text" name="name" />
		</td>
		<td>
			<label for="name">未开票金额:</label>
    		<input class="easyui-validatebox res_invoice_amount_surplus" disabled="disabled" type="text" name="name" />
		</td>
	</tr>
</table>


<script>
$(function(){
	//  合同金额
	var totalAmountList = $(".all_amount");
	
	//	预计回款金额
	var backAmountList = $(".back_amount");
	//  已收金额
	var backedAmountList = $(".backed_amount");
	//  发票金额
	var invoiceAmountList =  $(".invoice_amount");
	console.log(invoiceAmountList)
	// 
	var resTotalAmount = 0,
		resBackAmount = 0,
		resBackedAmount = 0,
		resInvoiceAmount = 0;
		
	$(".all_amount").each(function(index, item){
		resTotalAmount += +$(totalAmountList[index]).val();
		resBackAmount += +$(backAmountList[index]).val();
		resBackedAmount += +$(backedAmountList[index]).val();
		resInvoiceAmount += +$(invoiceAmountList[index]).val();
	})
	
	$(".res_total_amount").eq(0).val(resTotalAmount);	//合同金额
	$(".res_back_amount").eq(0).val(resBackAmount);		// 预计回款金额
	$(".res_backed_amount").eq(0).val(resBackedAmount);		// 已收金额
	$(".res_invoice_amount").eq(0).val(resInvoiceAmount);	// 发票金额
	
	$(".res_backed_amount_surplus").eq(0).val(resBackAmount - resBackedAmount);		// 未收金额 =  预计回款金额 - 已收金额
	$(".res_invoice_amount_surplus").eq(0).val(resBackAmount -resInvoiceAmount );		// 未开发票金额 =  预计回款金额 - 发票金额

})



</script>




