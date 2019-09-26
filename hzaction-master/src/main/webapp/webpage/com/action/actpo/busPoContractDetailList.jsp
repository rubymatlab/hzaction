<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addBusPoContractDetailBtn" href="#">添加</a>
	 <a id="delBusPoContractDetailBtn" href="#">删除</a> 
	<a id="selectAddBusPoContractDetailBtn" href="#">选择新增</a>
	<a id="importBusPoContractDetailBtn" href="#">excel导入</a>
	<a id="exportBusPoContractDetailBtn" href="#">excel模板下载</a>
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
<!-- 	  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
			采购合同外键
	  </td> -->
	</tr>
	<tbody id="add_busPoContractDetail_table">
	<c:if test="${fn:length(busPoContractDetailList)  <= 0 && false }">
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
							 <input  id="busPoContractDetailList[0].bpcdName" name="busPoContractDetailList[0].bpcdName" type="text" style="width: 150px" class="searchbox-inputtext"  value="${poVal.bpcdName }"   ignore="ignore"   onclick="popupClick(this,'bpad_name,bpad_brand,bpad_model,bpad_number','bpcdName,bpcdBrand,bpcdModel,bpcdNumber','rf_bus_po_apply_detail')"/> 			 
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
					  	<input name="busPoContractDetailList[0].fromId"  maxlength="32" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore" >
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
							 <input  id="busPoContractDetailList[${stuts.index }].bpcdName" name="busPoContractDetailList[${stuts.index }].bpcdName"  type="text" style="width: 12	0px" class="inputxt"   ignore="ignore"      value="${poVal.bpcdName }" /> 			 
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
					  	<input name="busPoContractDetailList[${stuts.index }].bpcdAmount" maxlength="32" type="text" readonly="readonly" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcdAmount }"/>
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
				   <td align="left">
					  	<input name="busPoContractDetailList[${stuts.index }].bpcdRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcdRemark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
 				   <td align="left">
					  	<input name="busPoContractDetailList[${stuts.index }].fromId" maxlength="32" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				   </td> 
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>

<table>
	<tbody>
	<tr>
			<td align="right">
				<label class="Validform_label">采购金额：</label>
			</td>
			<td class="value">
		     	 <input id="purAmount" name="purAmount" type="text" disabled='disabled'  maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
			</td>
<%-- 			<td align="right">
				<label class="Validform_label">已购金额：</label>
			</td>
			<td class="value">
		     	 <input id="puredAmount" name="puredAmount" disabled='disabled' value="${puredAmount} "  type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"/>
			</td> --%>
		</tr>
	</tbody>
</table>


<script type="text/javascript">
	$('#selectAddBusPoContractDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	}); 
	$('#addBusPoContractDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBusPoContractDetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#importBusPoContractDetailBtn').linkbutton({   
	    iconCls: 'icon-put'  
	}); 
	$('#exportBusPoContractDetailBtn').linkbutton({   
	    iconCls: 'icon-putout'  
	}); 
	// 选择新增
	$('#selectAddBusPoContractDetailBtn').bind('click', function(){   
		popupClickContractDetail(this,'bpad_name,bpad_brand,bpad_model,bpad_number,bpad_remark','bpcdName,bpcdBrand,bpcdModel,bpcdNumber,bpcdRemark','rf_bus_po_apply_detail')
 		/*  var tr =  $("#add_busPoContractDetail_table_template tr").clone();
	 	 $("#add_busPoContractDetail_table").append(tr);
	 	 resetTrNum('add_busPoContractDetail_table'); */
	 	 return false;
    });  
	$("#addBusPoContractDetailBtn").bind("click",function(){
		var tr =  $("#add_busPoContractDetail_table_template tr").clone();
	 	 $("#add_busPoContractDetail_table").append(tr);
	 	 resetTrNum('add_busPoContractDetail_table');
	 	inputBindEvents(tr)
	})
	$('#delBusPoContractDetailBtn').bind('click', function(){   
		$("#add_busPoContractDetail_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_busPoContractDetail_table'); 
        return false;
    }); 
	
	// 模板下载
	$('#exportBusPoContractDetailBtn').bind("click",function(e){   
		location.href = "vmBusPoContractController.do?exportContDetailExcel"
	}); 
	
	
	// 导入excel
	$('#importBusPoContractDetailBtn').bind("click",function(e){   
		importBPCDExcel('Excel导入', 'vmBusPoContractController.do?uploadContDetail', "vmBusPoContractList");
	}); 
	
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
	// 导入文件重写
    function importBPCDExcel(title, url,name,width, height) {
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
    					var row = this.iframe
    					return false;
    	            },
    	            uploaded(row){
    	            	var data = row.obj;
    	            	var flag = false;
    	            	for(var key in data[0]){
    	            		if(data[0][key] != null){
    	            			flag = true
    	            		}
    	            	}
    	            	if(flag != true) return false;
    	            	for(var i = 0; i< data.length; i++){
    	            		 var tr =  $("#add_busPoContractDetail_table_template tr").clone();
	            	 			 $("#add_busPoContractDetail_table").append(tr);
	            	 			inputBindEvents(tr) // 绑定事件
	            	 			resetTrNum('add_busPoContractDetail_table');
	                 		//busPoContractDetailList[#index#].bpcdNumber
	                 		var name = $(tr).find("input").eq(2).attr("name")
	                 		var inputs = name.split(".");
	                 		for(var key in data[i]){
	                 			var tInp = $("input[name='"+inputs[0]+"."+ key +"']");
	                 			tInp.length != 0 && tInp.val(data[i][key]);
	                 			if(tInp.length == 0){
	                 				var tSel = $("select[name='"+inputs[0]+"."+ key +"']");
	                 				tSel.length != 0 
	                 				&& 
	                 				tSel.find("option").each(function(index,item){
	                 					$(item).attr("value") == data[i][key] && $(item).attr("selected", "selected");
	                 				})
	                 			}
	                 			// 添加select标签的选择
	                 		}
    	            	}
    	            	firstCompute();
    	            },
    	            focus: true
    	        },
    	        {
    	            name: $.i18n.prop('upload.file.cancel'),
    	            callback: function(){
    	            	iframe = this.iframe.contentWindow;
    					iframe.cancel();
    	            }
    	        }
    	    ]
    	});
    }
    
   // popup事件重写 
function popupClickContractDetail(pobj, tablefield, inputnames, pcode) {
    if (inputnames == "" || pcode == "") {
        alert($.i18n.prop('popup.param.error.msg'));
        return;
    }
    if(!window.projectId){
    	 alert("请选择项目");
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
            if (selected == '' || selected == null) {
                alert($.i18n.prop('common.select.please'));
                return false;
            } else {
                //对应数据库字段不为空的情况下,根据表单中字典TEXT的值来取popup的值 
                if (tablefield != "" && tablefield != null) {
                    var fields = inputnames.split(",");
                    var tableF = tablefield.split(",");
                 	for(var i = 0; i < selected.length; i++){
                 		 var tr = $("#add_busPoContractDetail_table_template tr").clone();
            	 			 $("#add_busPoContractDetail_table").append(tr);
            	 			inputBindEvents(tr)
            	 			resetTrNum('add_busPoContractDetail_table');
                 		//busPoContractDetailList[#index#].bpcdNumber
                 		var name = $(tr).find("input").eq(2).attr("name")
                 		var inputs = name.split(".");
                		fields.forEach(function(item, index){
                 			$("input[name='"+inputs[0]+"."+ item +"']").val(selected[i][tableF[index]])
                 		}) 
                 	}
                } 
                firstCompute();
            }
        },
        cancelVal: $.i18n.prop('dialog.close'),
        cancel: true // 为true等价于function(){}
    });
}
// 输入框事件绑定
$(function(){
	// 初始化绑定事件
	$("#add_busPoContractDetail_table").find("tr").each(function(index,item){
		inputBindEvents(item )
	})
	firstCompute();
})
function firstCompute(){
	console.log(123)
	// 生成的时候计算一遍 （在进行监听）
	var oInput = $("input[name$='.bpcdPrice']").add("input[name$='.bpcdNumber']").add("input[name$='.bpcdAmount']");
	for(var i = 0; i < oInput.length; i += 3){
		var tRes = +$(oInput[i]).val() * +$(oInput[i+1]).val()
		$(oInput[i+2]).val(tRes.toFixed(2));	
	}
	computeTotal();
	
}
function inputBindEvents(tr){
	var $tr = $(tr);
	var pInp = $tr.find("input[name$='.bpcdPrice']"),
		nInp = $tr.find("input[name$='.bpcdNumber']"),
		aInp = $tr.find("input[name$='.bpcdAmount']");	
	pInp.bind("change",function(e){
		aInp.val((+pInp.val() * +nInp.val()).toFixed(2))
		computeTotal();
	})
	nInp.bind("change",function(e){
		aInp.val((+pInp.val() * +nInp.val()).toFixed(2))
		computeTotal();
	})
}
function computeTotal(){
	var aInp = $("input[name$='.bpcdAmount']")
	var tRes = 0;
	aInp.each(function(index, item){
		tRes += +$(item).val()
	})
	$("#purAmount").val(tRes.toFixed(2))
}


</script>
