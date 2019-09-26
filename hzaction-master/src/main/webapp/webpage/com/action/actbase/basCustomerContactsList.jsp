<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBasCustomerContactsBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBasCustomerContactsBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBasCustomerContactsBtn').bind('click', function(){   
 		 var tr =  $("#add_basCustomerContacts_table_template tr").clone();
	 	 $("#add_basCustomerContacts_table").append(tr);
	 	 resetTrNum('add_basCustomerContacts_table');
	 	 return false;
    });  
	$('#delBasCustomerContactsBtn').bind('click', function(){   
		$("#add_basCustomerContacts_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_basCustomerContacts_table'); 
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
	<a id="addBasCustomerContactsBtn" href="#">添加</a> <a id="delBasCustomerContactsBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="basCustomerContacts_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						姓名
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						部门
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						职务
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						电话
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
<!-- 				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						客户资料外键
				  </td> -->
	</tr>
	<tbody id="add_basCustomerContacts_table">
	<c:if test="${fn:length(basCustomerContactsList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="basCustomerContactsList[0].id" type="hidden"/>
					<input name="basCustomerContactsList[0].createName" type="hidden"/>
					<input name="basCustomerContactsList[0].createBy" type="hidden"/>
					<input name="basCustomerContactsList[0].createDate" type="hidden"/>
					<input name="basCustomerContactsList[0].updateName" type="hidden"/>
					<input name="basCustomerContactsList[0].updateBy" type="hidden"/>
					<input name="basCustomerContactsList[0].updateDate" type="hidden"/>
					<input name="basCustomerContactsList[0].sysOrgCode" type="hidden"/>
					<input name="basCustomerContactsList[0].sysCompanyCode" type="hidden"/>
					<input name="basCustomerContactsList[0].bpmStatus" type="hidden"/>
				  <td align="left">
					  	<input name="basCustomerContactsList[0].bccName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">姓名</label>
					</td>
				  <td align="left">
					  	<input name="basCustomerContactsList[0].bccDept" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">部门</label>
					</td>
				  <td align="left">
					  	<input name="basCustomerContactsList[0].bccPost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">职务</label>
					</td>
				  <td align="left">
					  	<input name="basCustomerContactsList[0].bccTel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">电话</label>
					</td>
				  <td align="left">
					  	<input name="basCustomerContactsList[0].bcRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				  <td align="left">
					  	<input name="basCustomerContactsList[0].fromId" maxlength="36" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">客户资料外键</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(basCustomerContactsList)  > 0 }">
		<c:forEach items="${basCustomerContactsList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="basCustomerContactsList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="basCustomerContactsList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="basCustomerContactsList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="basCustomerContactsList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="basCustomerContactsList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="basCustomerContactsList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="basCustomerContactsList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="basCustomerContactsList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="basCustomerContactsList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="basCustomerContactsList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
					  	<input name="basCustomerContactsList[${stuts.index }].bccName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bccName }"/>
					  <label class="Validform_label" style="display: none;">姓名</label>
				   </td>
				   <td align="left">
					  	<input name="basCustomerContactsList[${stuts.index }].bccDept" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bccDept }"/>
					  <label class="Validform_label" style="display: none;">部门</label>
				   </td>
				   <td align="left">
					  	<input name="basCustomerContactsList[${stuts.index }].bccPost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bccPost }"/>
					  <label class="Validform_label" style="display: none;">职务</label>
				   </td>
				   <td align="left">
					  	<input name="basCustomerContactsList[${stuts.index }].bccTel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bccTel }"/>
					  <label class="Validform_label" style="display: none;">电话</label>
				   </td>
				   <td align="left">
					  	<input name="basCustomerContactsList[${stuts.index }].bcRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcRemark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
				   <td align="left">
					  	<input name="basCustomerContactsList[${stuts.index }].fromId" maxlength="36" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">客户资料外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
