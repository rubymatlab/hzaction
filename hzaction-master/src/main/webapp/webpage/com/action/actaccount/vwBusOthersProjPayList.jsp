<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addVwBusOthersProjPayBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delVwBusOthersProjPayBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addVwBusOthersProjPayBtn').bind('click', function(){   
 		 var tr =  $("#add_vwBusOthersProjPay_table_template tr").clone();
	 	 $("#add_vwBusOthersProjPay_table").append(tr);
	 	 resetTrNum('add_vwBusOthersProjPay_table');
	 	 return false;
    });  
	$('#delVwBusOthersProjPayBtn').bind('click', function(){   
		$("#add_vwBusOthersProjPay_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_vwBusOthersProjPay_table'); 
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
	<a id="addVwBusOthersProjPayBtn" href="#">添加</a> <a id="delVwBusOthersProjPayBtn" href="#">删除</a> 
</div> -->
<table border="0" cellpadding="2" cellspacing="0" id="vwBusOthersProjPay_table">
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
						付款金额
				  </td>
	</tr>
	<tbody id="add_vwBusOthersProjPay_table">
	<c:if test="${fn:length(vwBusOthersProjPayList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<!-- <td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td> -->
					<input name="vwBusOthersProjPayList[0].id" type="hidden"/>
				  <td align="left">
					  	<input name="vwBusOthersProjPayList[0].bpmProjId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目编号</label>
					</td>
				  <td align="left">
					  	<input name="vwBusOthersProjPayList[0].bpmName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目名称</label>
					</td>
				  <td align="left">
					  	<input name="vwBusOthersProjPayList[0].payTamount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">付款金额</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(vwBusOthersProjPayList)  > 0 }">
		<c:forEach items="${vwBusOthersProjPayList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<!-- <td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td> -->
						<input name="vwBusOthersProjPayList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				   <td align="left">
					  	<input name="vwBusOthersProjPayList[${stuts.index }].bpmProjId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpmProjId }"/>
					  <label class="Validform_label" style="display: none;">项目编号</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusOthersProjPayList[${stuts.index }].bpmName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpmName }"/>
					  <label class="Validform_label" style="display: none;">项目名称</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusOthersProjPayList[${stuts.index }].payTamount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.payTamount }"/>
					  <label class="Validform_label" style="display: none;">付款金额</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
