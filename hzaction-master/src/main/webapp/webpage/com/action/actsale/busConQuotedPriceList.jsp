<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBusConQuotedPriceBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusConQuotedPriceBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBusConQuotedPriceBtn').bind('click', function(){   
 		 var tr =  $("#add_busConQuotedPrice_table_template tr").clone();
	 	 $("#add_busConQuotedPrice_table").append(tr);
	 	 resetTrNum('add_busConQuotedPrice_table');
	 	 return false;
    });  
	$('#delBusConQuotedPriceBtn').bind('click', function(){   
		$("#add_busConQuotedPrice_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busConQuotedPrice_table'); 
        return false;
    }); 
   
	$(document).ready(function() {
		$(".datagrid-toolbar").parent().css("width", "auto");
		if (location.href.indexOf("load=detail") != -1) {
			$(":input").attr("disabled", "true");
			$(".datagrid-toolbar").hide();
		}
	});
	

	//导入
	function ImportXls() {
		/* openuploadwin('Excel导入', 'busContractController.do?upload',"busContractList"); */
		var id = $("#id").val();
 		openuploadwinUpload('Excel导入', "busContractController.do?upload&detail=1&id="+id,"busContractList");
	}
	function openuploadwinUpload(title, url,name,width, height) {
		gridname=name;
		$.dialog({
		    content: 'url:'+url,
			zIndex: getzIndex(),
		    cache:false,
		    button: [
		        {
		            name: $.i18n.prop('upload.file.begin'),
		            callback: function(){
		            	iframe = this.iframe.contentWindow;
						iframe.upload();
		            	console.log(1);
						return false;
		            },
		            focus: true,
		        },
		        {
		            name: $.i18n.prop('upload.file.cancel'),
		            callback: function(){
		            	iframe = this.iframe.contentWindow;
		            	console.log(2);
						iframe.cancel();
		            }
		        }
		    ]
		});
	}
</script>
<style>
.excel {
	padding: 6px 12px;
	border: 1px solid #c3c3c3;
	border-radius: 4px;
	color: #000000;
	background: white;
}

.excel:hover {
	color: #1aa025;
	border: 1px solid #1aa025;
}

#excelButton {
	display: none;
}
</style>
<span id="id" hidden="hidden">${id }</span>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addBusConQuotedPriceBtn" href="#">添加</a> 
	<a id="delBusConQuotedPriceBtn" href="#">删除</a>
    <label id="lab-file"  onclick="ImportXls()" class="excel">导入文件</label>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busConQuotedPrice_table">
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
						单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						合同管理外键
				  </td>
	</tr>
	<tbody id="add_busConQuotedPrice_table">
	<c:if test="${fn:length(busConQuotedPriceList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="busConQuotedPriceList[0].id" type="hidden"/>
					<input name="busConQuotedPriceList[0].createName" type="hidden"/>
					<input name="busConQuotedPriceList[0].createBy" type="hidden"/>
					<input name="busConQuotedPriceList[0].createDate" type="hidden"/>
					<input name="busConQuotedPriceList[0].updateName" type="hidden"/>
					<input name="busConQuotedPriceList[0].updateBy" type="hidden"/>
					<input name="busConQuotedPriceList[0].updateDate" type="hidden"/>
					<input name="busConQuotedPriceList[0].sysOrgCode" type="hidden"/>
					<input name="busConQuotedPriceList[0].sysCompanyCode" type="hidden"/>
					<input name="busConQuotedPriceList[0].bpmStatus" type="hidden"/>
				  <td align="left">
					  	<input name="busConQuotedPriceList[0].bcqpName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">名称</label>
					</td>
				  <td align="left">
					  	<input name="busConQuotedPriceList[0].bcqpBrand" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">品牌</label>
					</td>
				  <td align="left">
					  	<input name="busConQuotedPriceList[0].bcqpModel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">型号</label>
					</td>
				  <td align="left">
					  	<input name="busConQuotedPriceList[0].bcqpQty" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">数量</label>
					</td>
				  <td align="left">
					  	<input name="busConQuotedPriceList[0].bcqpPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="busConQuotedPriceList[0].bcqpAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">金额</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="busConQuotedPriceList[0].busContractId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">合同管理外键</label>
				  </td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(busConQuotedPriceList)  > 0 }">
		<c:forEach items="${busConQuotedPriceList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="busConQuotedPriceList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="busConQuotedPriceList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="busConQuotedPriceList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="busConQuotedPriceList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="busConQuotedPriceList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="busConQuotedPriceList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="busConQuotedPriceList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="busConQuotedPriceList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="busConQuotedPriceList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="busConQuotedPriceList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
					  	<input name="busConQuotedPriceList[${stuts.index }].bcqpName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcqpName }"/>
					  <label class="Validform_label" style="display: none;">名称</label>
				   </td>
				   <td align="left">
					  	<input name="busConQuotedPriceList[${stuts.index }].bcqpBrand" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcqpBrand }"/>
					  <label class="Validform_label" style="display: none;">品牌</label>
				   </td>
				   <td align="left">
					  	<input name="busConQuotedPriceList[${stuts.index }].bcqpModel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcqpModel }"/>
					  <label class="Validform_label" style="display: none;">型号</label>
				   </td>
				   <td align="left">
					  	<input name="busConQuotedPriceList[${stuts.index }].bcqpQty" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcqpQty }"/>
					  <label class="Validform_label" style="display: none;">数量</label>
				   </td>
				   <td align="left">
					  	<input name="busConQuotedPriceList[${stuts.index }].bcqpPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcqpPrice }"/>
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="busConQuotedPriceList[${stuts.index }].bcqpAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bcqpAmount }"/>
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
				   <td align="left"  hidden="hidden">
					  	<input name="busConQuotedPriceList[${stuts.index }].busContractId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.busContractId }"/>
					  <label class="Validform_label" style="display: none;">合同管理外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
