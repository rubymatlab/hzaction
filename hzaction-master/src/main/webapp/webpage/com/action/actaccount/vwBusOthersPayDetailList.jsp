<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addVwBusOthersPayDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delVwBusOthersPayDetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addVwBusOthersPayDetailBtn').bind('click', function(){   
 		 var tr =  $("#add_vwBusOthersPayDetail_table_template tr").clone();
	 	 $("#add_vwBusOthersPayDetail_table").append(tr);
	 	 resetTrNum('add_vwBusOthersPayDetail_table');
	 	 return false;
    });  
	$('#delVwBusOthersPayDetailBtn').bind('click', function(){   
		$("#add_vwBusOthersPayDetail_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_vwBusOthersPayDetail_table'); 
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
	<a id="addVwBusOthersPayDetailBtn" href="#">添加</a> <a id="delVwBusOthersPayDetailBtn" href="#">删除</a> 
</div> -->
<table border="0" cellpadding="2" cellspacing="0" id="vwBusOthersPayDetail_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
	<!-- 	<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td> -->
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						项目编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						项目名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单据_费用类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						申请日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						付款金额
				  </td>
	</tr>
	<tbody id="add_vwBusOthersPayDetail_table">
	<c:if test="${fn:length(vwBusOthersPayDetailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
			<!-- 	<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td> -->
					<input name="vwBusOthersPayDetailList[0].id" type="hidden"/>
				  <td align="left">
					  	<input name="vwBusOthersPayDetailList[0].bpmProjId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目编号</label>
					</td>
				  <td align="left">
					  	<input name="vwBusOthersPayDetailList[0].bpmName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目名称</label>
					</td>
				  <td align="left">
					  	<input name="vwBusOthersPayDetailList[0].busId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单号</label>
					</td>
				  <td align="left">
					  	<input name="vwBusOthersPayDetailList[0].busType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单据_费用类型</label>
					</td>
				  <td align="left">
							<input name="vwBusOthersPayDetailList[0].applyDate" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">申请日期</label>
					</td>
				  <td align="left">
					  	<input name="vwBusOthersPayDetailList[0].payAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">付款金额</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(vwBusOthersPayDetailList)  > 0 }">
		<c:forEach items="${vwBusOthersPayDetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<!-- <td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td> -->
						<input name="vwBusOthersPayDetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				   <td align="left">
					  	<input name="vwBusOthersPayDetailList[${stuts.index }].bpmProjId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpmProjId }"/>
					  <label class="Validform_label" style="display: none;">项目编号</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusOthersPayDetailList[${stuts.index }].bpmName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpmName }"/>
					  <label class="Validform_label" style="display: none;">项目名称</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusOthersPayDetailList[${stuts.index }].busId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.busId }"/>
					  <label class="Validform_label" style="display: none;">单号</label>
				   </td>
				   <td align="left">
				   <t:dictSelect field="vwBusOthersPayDetailList[${stuts.index }].busType" type="list"  defaultVal="${poVal.busType }"  typeGroupCode="cost_type"  hasLabel="false"  title="单据_费用类型"></t:dictSelect> 
					  <label class="Validform_label" style="display: none;">单据_费用类型</label>
				   </td>
				   <td align="left">
							<input name="vwBusOthersPayDetailList[${stuts.index }].applyDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.applyDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">申请日期</label>
				   </td>
				   <td align="left">
					  	<input name="vwBusOthersPayDetailList[${stuts.index }].payAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.payAmount }"/>
					  <label class="Validform_label" style="display: none;">付款金额</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
