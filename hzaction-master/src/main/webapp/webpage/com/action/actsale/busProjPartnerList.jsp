<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBusProjPartnerBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusProjPartnerBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBusProjPartnerBtn').bind('click', function(){   
 		 var tr =  $("#add_busProjPartner_table_template tr").clone();
	 	 $("#add_busProjPartner_table").append(tr);
	 	 resetTrNum('add_busProjPartner_table');
	 	 return false;
    });  
	$('#delBusProjPartnerBtn').bind('click', function(){   
		$("#add_busProjPartner_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busProjPartner_table'); 
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
	<a id="addBusProjPartnerBtn" href="#">添加</a> <a id="delBusProjPartnerBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busProjPartner_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						公司名称
				  </td>
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
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						项目立项外键
				  </td>
	</tr>
	<tbody id="add_busProjPartner_table">
	<c:if test="${fn:length(busProjPartnerList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busProjPartnerList[0].id" type="hidden"/>
					<input name="busProjPartnerList[0].createName" type="hidden"/>
					<input name="busProjPartnerList[0].createBy" type="hidden"/>
					<input name="busProjPartnerList[0].createDate" type="hidden"/>
					<input name="busProjPartnerList[0].updateName" type="hidden"/>
					<input name="busProjPartnerList[0].updateBy" type="hidden"/>
					<input name="busProjPartnerList[0].updateDate" type="hidden"/>
					<input name="busProjPartnerList[0].sysOrgCode" type="hidden"/>
					<input name="busProjPartnerList[0].sysCompanyCode" type="hidden"/>
					<input name="busProjPartnerList[0].bpmStatus" type="hidden"/>
				  <td align="left">
					  	<input name="busProjPartnerList[0].bppCompany" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">公司名称</label>
					</td>
				  <td align="left">
					  	<input name="busProjPartnerList[0].bppName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">姓名</label>
					</td>
				  <td align="left">
					  	<input name="busProjPartnerList[0].bppDept" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">部门</label>
					</td>
				  <td align="left">
					  	<input name="busProjPartnerList[0].bppPost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">职务</label>
					</td>
				  <td align="left">
					  	<input name="busProjPartnerList[0].bppTel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">电话</label>
					</td>
				  <td align="left">
					  	<input name="busProjPartnerList[0].bppRemark" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				  <td align="left">
					  	<input name="busProjPartnerList[0].fromId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(busProjPartnerList)  > 0 }">
		<c:forEach items="${busProjPartnerList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busProjPartnerList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="busProjPartnerList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="busProjPartnerList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="busProjPartnerList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="busProjPartnerList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="busProjPartnerList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="busProjPartnerList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="busProjPartnerList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="busProjPartnerList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="busProjPartnerList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
					  	<input name="busProjPartnerList[${stuts.index }].bppCompany" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bppCompany }"/>
					  <label class="Validform_label" style="display: none;">公司名称</label>
				   </td>
				   <td align="left">
					  	<input name="busProjPartnerList[${stuts.index }].bppName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bppName }"/>
					  <label class="Validform_label" style="display: none;">姓名</label>
				   </td>
				   <td align="left">
					  	<input name="busProjPartnerList[${stuts.index }].bppDept" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bppDept }"/>
					  <label class="Validform_label" style="display: none;">部门</label>
				   </td>
				   <td align="left">
					  	<input name="busProjPartnerList[${stuts.index }].bppPost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bppPost }"/>
					  <label class="Validform_label" style="display: none;">职务</label>
				   </td>
				   <td align="left">
					  	<input name="busProjPartnerList[${stuts.index }].bppTel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bppTel }"/>
					  <label class="Validform_label" style="display: none;">电话</label>
				   </td>
				   <td align="left">
					  	<input name="busProjPartnerList[${stuts.index }].bppRemark" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bppRemark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
				   <td align="left">
					  	<input name="busProjPartnerList[${stuts.index }].fromId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">项目立项外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
