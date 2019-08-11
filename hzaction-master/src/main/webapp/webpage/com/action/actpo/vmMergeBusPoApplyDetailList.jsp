<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addVmMergeBusPoApplyDetailBtn" href="#">选择新增</a> <a id="delVmMergeBusPoApplyDetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="vmMergeBusPoApplyDetail_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
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
						备注
				  </td>
<!-- 				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						采购合同外键
				  </td> -->
	</tr>
	<tbody id="add_vmMergeBusPoApplyDetail_table">
	<c:if test="${fn:length(vmMergeBusPoApplyDetailList)  <= 0 && false }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="vmMergeBusPoApplyDetailList[0].id" type="hidden"/>
					<input name="vmMergeBusPoApplyDetailList[0].createName" type="hidden"/>
					<input name="vmMergeBusPoApplyDetailList[0].createBy" type="hidden"/>
					<input name="vmMergeBusPoApplyDetailList[0].createDate" type="hidden"/>
					<input name="vmMergeBusPoApplyDetailList[0].updateName" type="hidden"/>
					<input name="vmMergeBusPoApplyDetailList[0].updateBy" type="hidden"/>
					<input name="vmMergeBusPoApplyDetailList[0].updateDate" type="hidden"/>
					<input name="vmMergeBusPoApplyDetailList[0].sysOrgCode" type="hidden"/>
					<input name="vmMergeBusPoApplyDetailList[0].sysCompanyCode" type="hidden"/>
					<input name="vmMergeBusPoApplyDetailList[0].bpmStatus" type="hidden"/>
				  <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[0].bpadName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">名称</label>
					</td>
				  <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[0].bpadBrand" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">品牌</label>
					</td>
				  <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[0].bpadModel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">型号</label>
					</td>
				  <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[0].bpadNumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">数量</label>
					</td>
				  <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[0].bpadRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
<!-- 				  <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[0].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
					</td> -->
   			</tr>
	</c:if>
	<c:if test="${fn:length(vmMergeBusPoApplyDetailList)  > 0 }">
		<c:forEach items="${vmMergeBusPoApplyDetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="vmMergeBusPoApplyDetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="vmMergeBusPoApplyDetailList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="vmMergeBusPoApplyDetailList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="vmMergeBusPoApplyDetailList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="vmMergeBusPoApplyDetailList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="vmMergeBusPoApplyDetailList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="vmMergeBusPoApplyDetailList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="vmMergeBusPoApplyDetailList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="vmMergeBusPoApplyDetailList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="vmMergeBusPoApplyDetailList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[${stuts.index }].bpadName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpadName }"/>
					  <label class="Validform_label" style="display: none;">名称</label>
				   </td>
				   <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[${stuts.index }].bpadBrand" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpadBrand }"/>
					  <label class="Validform_label" style="display: none;">品牌</label>
				   </td>
				   <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[${stuts.index }].bpadModel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpadModel }"/>
					  <label class="Validform_label" style="display: none;">型号</label>
				   </td>
				   <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[${stuts.index }].bpadNumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpadNumber }"/>
					  <label class="Validform_label" style="display: none;">数量</label>
				   </td>
				   <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[${stuts.index }].bpadRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpadRemark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
<%-- 				   <td align="left">
					  	<input name="vmMergeBusPoApplyDetailList[${stuts.index }].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				   </td> --%>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>

<script type="text/javascript">
	$('#addVmMergeBusPoApplyDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delVmMergeBusPoApplyDetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addVmMergeBusPoApplyDetailBtn').bind('click', function(){   
		popupClickMerge(this,'id,bpad_name,bpad_brand,bpad_model,bpad_number,bpad_remark','id,bpadName,bpadBrand,bpadModel,bpadNumber,bpadRemark','rf_bus_po_apply_detail')
	 	 return false;
		
		
/*  		 var tr =  $("#add_vmMergeBusPoApplyDetail_table_template tr").clone();
	 	 $("#add_vmMergeBusPoApplyDetail_table").append(tr);
	 	 resetTrNum('add_vmMergeBusPoApplyDetail_table'); */
    });  
	$('#delVmMergeBusPoApplyDetailBtn').bind('click', function(){   
		$("#add_vmMergeBusPoApplyDetail_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_vmMergeBusPoApplyDetail_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
// 重新popupClick 方法
function popupClickMerge(pobj, tablefield, inputnames, pcode) {
	
    if (inputnames == "" || pcode == "") {
        alert($.i18n.prop('popup.param.error.msg'));
        return;
    }
        $.dialog({
            content: "url:cgReportController.do?popup&id=" + pcode + "&idkey="+ window.projectId,
            zIndex: getzIndex(),
            lock: true,
            title: $.i18n.prop('common.select'),
            width: 800,
            height: 400,
            parent: windowapi,
            cache: false,
            ok: function () {
                iframe = this.iframe.contentWindow;
                var selected = iframe.getSelectRows();
               	console.log(selected)
                if (selected == '' || selected == null) {
                    alert($.i18n.prop('common.select.please'));
                    return false;
                } else {
                    //对应数据库字段不为空的情况下,根据表单中字典TEXT的值来取popup的值 
                    if (tablefield != "" && tablefield != null) {
                        var iNames = inputnames.split(",");
                        var tableF = tablefield.split(",");
                     	for(var i = 0; i < selected.length; i++){
                     		 var tr =  $("#add_vmMergeBusPoApplyDetail_table_template tr").clone();
                	 		 $("#add_vmMergeBusPoApplyDetail_table").append(tr);
                	 		resetTrNum('add_vmMergeBusPoApplyDetail_table');
                     		//busPoContractDetailList[#index#].bpcdNumber
                     		var name = $(tr).find("input").eq(2).attr("name")
                     		var inputs = name.split(".");
                     		iNames.forEach(function(item, index){
                     			$("input[name='"+inputs[0]+"."+ item +"']").val(selected[i][tableF[index]])
                     		}) 
                     	}
                     	resetTrNum('add_vmMergeBusPoApplyDetail_table');
                    }
                }
            },
            cancelVal: $.i18n.prop('dialog.close'),
            cancel: true // 为true等价于function(){}
        });
}
</script>





