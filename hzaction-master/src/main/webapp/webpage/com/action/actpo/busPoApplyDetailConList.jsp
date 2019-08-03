<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBusPoApplyDetailConBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusPoApplyDetailConBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBusPoApplyDetailConBtn').bind('click', function(){   
 		 var tr =  $("#add_busPoApplyDetailCon_table_template tr").clone();
	 	 $("#add_busPoApplyDetailCon_table").append(tr);
	 	 resetTrNum('add_busPoApplyDetailCon_table');
	 	 return false;
    });  
	$('#delBusPoApplyDetailConBtn').bind('click', function(){   
		$("#add_busPoApplyDetailCon_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busPoApplyDetailCon_table'); 
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
	<a id="addBusPoApplyDetailConBtn" href="#">添加</a> <a id="delBusPoApplyDetailConBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busPoApplyDetailCon_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						创建人名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						创建人登录名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						创建日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						更新人名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						更新人登录名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						更新日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						所属部门
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						所属公司
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						流程状态
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						采购合同外键
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						采购申请明细外键
				  </td>
	</tr>
	<tbody id="add_busPoApplyDetailCon_table">
	<c:if test="${fn:length(busPoApplyDetailConList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busPoApplyDetailConList[0].id" type="hidden"/>
				  <td align="left">
					  	<input name="busPoApplyDetailConList[0].createName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">创建人名称</label>
					</td>
				  <td align="left">
					  	<input name="busPoApplyDetailConList[0].createBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">创建人登录名称</label>
					</td>
				  <td align="left">
							<input name="busPoApplyDetailConList[0].createDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">创建日期</label>
					</td>
				  <td align="left">
					  	<input name="busPoApplyDetailConList[0].updateName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">更新人名称</label>
					</td>
				  <td align="left">
					  	<input name="busPoApplyDetailConList[0].updateBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">更新人登录名称</label>
					</td>
				  <td align="left">
							<input name="busPoApplyDetailConList[0].updateDate" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">更新日期</label>
					</td>
				  <td align="left">
					  	<input name="busPoApplyDetailConList[0].sysOrgCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">所属部门</label>
					</td>
				  <td align="left">
					  	<input name="busPoApplyDetailConList[0].sysCompanyCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">所属公司</label>
					</td>
				  <td align="left">
					  	<input name="busPoApplyDetailConList[0].bpmStatus" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">流程状态</label>
					</td>
				  <td align="left">
					  	<input name="busPoApplyDetailConList[0].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
					</td>
				  <td align="left">
					  	<input name="busPoApplyDetailConList[0].fromPoApplyDetId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">采购申请明细外键</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(busPoApplyDetailConList)  > 0 }">
		<c:forEach items="${busPoApplyDetailConList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busPoApplyDetailConList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				   <td align="left">
					  	<input name="busPoApplyDetailConList[${stuts.index }].createName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.createName }"/>
					  <label class="Validform_label" style="display: none;">创建人名称</label>
				   </td>
				   <td align="left">
					  	<input name="busPoApplyDetailConList[${stuts.index }].createBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.createBy }"/>
					  <label class="Validform_label" style="display: none;">创建人登录名称</label>
				   </td>
				   <td align="left">
							<input name="busPoApplyDetailConList[${stuts.index }].createDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.createDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">创建日期</label>
				   </td>
				   <td align="left">
					  	<input name="busPoApplyDetailConList[${stuts.index }].updateName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.updateName }"/>
					  <label class="Validform_label" style="display: none;">更新人名称</label>
				   </td>
				   <td align="left">
					  	<input name="busPoApplyDetailConList[${stuts.index }].updateBy" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.updateBy }"/>
					  <label class="Validform_label" style="display: none;">更新人登录名称</label>
				   </td>
				   <td align="left">
							<input name="busPoApplyDetailConList[${stuts.index }].updateDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.updateDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">更新日期</label>
				   </td>
				   <td align="left">
					  	<input name="busPoApplyDetailConList[${stuts.index }].sysOrgCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.sysOrgCode }"/>
					  <label class="Validform_label" style="display: none;">所属部门</label>
				   </td>
				   <td align="left">
					  	<input name="busPoApplyDetailConList[${stuts.index }].sysCompanyCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.sysCompanyCode }"/>
					  <label class="Validform_label" style="display: none;">所属公司</label>
				   </td>
				   <td align="left">
					  	<input name="busPoApplyDetailConList[${stuts.index }].bpmStatus" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpmStatus }"/>
					  <label class="Validform_label" style="display: none;">流程状态</label>
				   </td>
				   <td align="left">
					  	<input name="busPoApplyDetailConList[${stuts.index }].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				   </td>
				   <td align="left">
					  	<input name="busPoApplyDetailConList[${stuts.index }].fromPoApplyDetId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromPoApplyDetId }"/>
					  <label class="Validform_label" style="display: none;">采购申请明细外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
