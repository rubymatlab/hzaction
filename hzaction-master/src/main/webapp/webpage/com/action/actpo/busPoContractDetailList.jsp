<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBusPoContractDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusPoContractDetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBusPoContractDetailBtn').bind('click', function(){   
 		 var tr =  $("#add_busPoContractDetail_table_template tr").clone();
	 	 $("#add_busPoContractDetail_table").append(tr);
	 	 resetTrNum('add_busPoContractDetail_table');
	 	 return false;
    });  
	$('#delBusPoContractDetailBtn').bind('click', function(){   
		$("#add_busPoContractDetail_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busPoContractDetail_table'); 
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
	<a id="addBusPoContractDetailBtn" href="#">添加</a> <a id="delBusPoContractDetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busPoContractDetail_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						品牌
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						型号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						数量
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						采购合同外键
				  </td>
	</tr>
	<tbody id="add_busPoContractDetail_table">
	<c:if test="${fn:length(busPoContractDetailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busPoContractDetailList[0].id" type="hidden"/>
					<input name="busPoContractDetailList[0].createName" type="hidden"/>
					<input name="busPoContractDetailList[0].createBy" type="hidden"/>
					<input name="busPoContractDetailList[0].createDate" type="hidden"/>
					<input name="busPoContractDetailList[0].updateName" type="hidden"/>
					<input name="busPoContractDetailList[0].updateBy" type="hidden"/>
					<input name="busPoContractDetailList[0].updateDate" type="hidden"/>
					<input name="busPoContractDetailList[0].sysOrgCode" type="hidden"/>
					<input name="busPoContractDetailList[0].sysCompanyCode" type="hidden"/>
					<input name="busPoContractDetailList[0].bpmStatus" type="hidden"/>
				  <td align="left">
							<t:dictSelect field="busPoContractDetailList[0].bpcdPayType" type="list"   typeGroupCode="cost_type"  defaultVal="${busPoContractDetailPage.bpcdPayType}" hasLabel="false"  title="费用类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类型</label>
					</td>
				  <td align="left">
					  	<input name="busPoContractDetailList[0].bpcdName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">名称</label>
					</td>
				  <td align="left">
					  	<input name="busPoContractDetailList[0].bpcdBrand" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">品牌</label>
					</td>
				  <td align="left">
					  	<input name="busPoContractDetailList[0].bpcdModel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">型号</label>
					</td>
				  <td align="left">
					  	<input name="busPoContractDetailList[0].bpcdNumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">数量</label>
					</td>
				  <td align="left">
					  	<input name="busPoContractDetailList[0].bpcdPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="busPoContractDetailList[0].bpcdAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">金额</label>
					</td>
				  <td align="left">
					  	<input name="busPoContractDetailList[0].bpcdRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				  <td align="left">
					  	<input name="busPoContractDetailList[0].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(busPoContractDetailList)  > 0 }">
		<c:forEach items="${busPoContractDetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busPoContractDetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="busPoContractDetailList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="busPoContractDetailList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="busPoContractDetailList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="busPoContractDetailList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="busPoContractDetailList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="busPoContractDetailList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="busPoContractDetailList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="busPoContractDetailList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="busPoContractDetailList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
							<t:dictSelect field="busPoContractDetailList[${stuts.index }].bpcdPayType" type="list"   typeGroupCode="cost_type"  defaultVal="${poVal.bpcdPayType }" hasLabel="false"  title="费用类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类型</label>
				   </td>
				   <td align="left">
					  	<input name="busPoContractDetailList[${stuts.index }].bpcdName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcdName }"/>
					  <label class="Validform_label" style="display: none;">名称</label>
				   </td>
				   <td align="left">
					  	<input name="busPoContractDetailList[${stuts.index }].bpcdBrand" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcdBrand }"/>
					  <label class="Validform_label" style="display: none;">品牌</label>
				   </td>
				   <td align="left">
					  	<input name="busPoContractDetailList[${stuts.index }].bpcdModel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcdModel }"/>
					  <label class="Validform_label" style="display: none;">型号</label>
				   </td>
				   <td align="left">
					  	<input name="busPoContractDetailList[${stuts.index }].bpcdNumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcdNumber }"/>
					  <label class="Validform_label" style="display: none;">数量</label>
				   </td>
				   <td align="left">
					  	<input name="busPoContractDetailList[${stuts.index }].bpcdPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcdPrice }"/>
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="busPoContractDetailList[${stuts.index }].bpcdAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcdAmount }"/>
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
				   <td align="left">
					  	<input name="busPoContractDetailList[${stuts.index }].bpcdRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcdRemark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
				   <td align="left">
					  	<input name="busPoContractDetailList[${stuts.index }].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
