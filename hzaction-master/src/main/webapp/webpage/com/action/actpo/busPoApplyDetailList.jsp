<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
    var num = 0;//添加与删除行的记录   
	var $this;//当前对象
//-----------------------当用户点前文本框时获取当前文本框对象，为弹窗提供操作对象------------------
	$(":input").on('click', function() {
		$this = $(this)		
	});
	
	
	//-----------------------从后台接收是否购买的结果并显示于前端---------------------
	$(function() {
		   var res='${purchase_or_not}';
		   var data = JSON.parse(res);		   
		 // console.log(data.length+"");
		   for(var i=0;i<data.length;i++){
				$("input[name='busPoApplyDetailList["+i+"].purchaseOrNot']").val(data[i]['purchase_or_not']);
			   //console.log(data[i]['purchase_or_not']);
			}
		
	})

	$('#addBusPoApplyDetailBtn').linkbutton({
		iconCls : 'icon-add'
	});
	$('#delBusPoApplyDetailBtn').linkbutton({
		iconCls : 'icon-remove'
	});
	$('#ImportXlsBusPoApplyDetailBtn').linkbutton({
		iconCls : 'icon-putout'
	});
	$('#choiceaddBusPoApplyDetailBtn').linkbutton({
		iconCls : 'icon-sum'
	});
	$('#ExportXlsByTBtn').linkbutton({
		iconCls : 'icon-put'
	});
	
	//-------------模板下载功能-----------------
	
	$('#ExportXlsByTBtn').bind('click', function() {
		location.href = "vwBusPoApplyController.do?exportXlsByT";
		//location.href ="jeecgDemoExcelController.do?exportXlsByT";
		//JeecgExcelExport("vwBusPoApplyController.do?exportXlsByT","busPoApplyDetailList");
	})
	
	//----------添加功能----------------
	$('#addBusPoApplyDetailBtn').bind('click', function() {
		var tr = $("#add_busPoApplyDetail_table_template tr").clone();
		$("#add_busPoApplyDetail_table").append(tr);
		resetTrNum('add_busPoApplyDetail_table');
		getobject();//为每个新增加的input绑定单击监听
		num++;
		$("input[name='busPoApplyDetailList["+num+"].purchaseOrNot']").val("未采购");
		return false;
	});
	
	
	
	$('#delBusPoApplyDetailBtn')
			.bind(
					'click',
					function() {
						$("#add_busPoApplyDetail_table").find(
								"input[name$='ck']:checked").parent().parent()
								.remove();
						resetTrNum('add_busPoApplyDetail_table');
						num--;
						return false;
					});
	
	//为当前文本框绑定当击监听，触发单击事件获取触发对象
	function getobject() {
		$(":input").on('click', function() {
			$this = $(this)
			
		})
		
	}
	//excel导入按钮单击事件
	$('#ImportXlsBusPoApplyDetailBtn').bind('click', function() {
		

	importExcel('excel导入','vwBusPoApplyController.do?upload');
	
	})
    
	//导入文件重写 
	function importExcel(title, url) {
    	
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
    	            	if (data.length==0){
    	            		alert("excel模块不正确")
    	            	}

    	            	var flag = false;
    	            	for(var key in data[0]){
    	            		if(data[0][key] != null){
    	            			flag = true
    	            		}
    	            	}
    	            	
    	            	if(flag != true) return false;
    	            	
    	            	var fristRowFlag=true;
    	            	//判断第一行是否为空,fristRowFlag为true表示第一行为空
    	            	for(var key in data[0]){
                 			
                 			if($("input[name='busPoApplyDetailList[0]."+ key +"']").val()!=''){
                 				fristRowFlag=false;
                 				break;
                 			}
                 		}
    	            	
    	            	//若第一行为空则从第一行开始幅值，否则在一下行追加
    	            	var start=0;
    	            	if(fristRowFlag){
    	            		start=1;
    	            		for(var key in data[0]){
                     			
                     		$("input[name='busPoApplyDetailList[0]."+ key +"']").val(data[0][key]);
                     				
                     			}
                     		}
    	            
    	           
    	            	for(var i = start; i< data.length; i++){    	            		   	            		
    	            		var tr = $("#add_busPoApplyDetail_table_template tr").clone();
    	            		num++;
    	            		$("#add_busPoApplyDetail_table").append(tr);
    	            		resetTrNum('add_busPoApplyDetail_table');

    	            		
	                 		var name = $(tr).find("input").eq(2).attr("name")
	                 		
	                 		var inputs = name.split(".");
	                 		$("input[name='"+inputs[0]+".purchaseOrNot']").val("未采购");
	                 		
	                 		for(var key in data[i]){
	                 			$("input[name='"+inputs[0]+"."+ key +"']")
	                 			&& 
	                 			$("input[name='"+inputs[0]+"."+ key +"']").val(data[i][key])
	                 		}
	                 		
    	            	}
    	            	
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



	    
	
	//选择新增

	$('#choiceaddBusPoApplyDetailBtn').bind('click',function() {
						//$("input[name='busPoApplyDetailList[0].bpadName']")
						//if($.isEmptyObject($this)){alert("请点击要插入数据行的任一文本框");}else{
							/*popupClick(
									$this,
									'bpcd_name,bpcd_brand,bpcd_model,bpcd_number,bpcd_remark',
									'bpadName,bpadBrand,bpadModel,bpadNumber,bpadRemark',
									'rf_bus_po_apply_detail'); */
							popupClickContractDetail(this,'bcqp_name,bcqp_brand,bcqp_model,bcqp_qty,bcqp_remark','bpadName,bpadBrand,bpadModel,bpadNumber,bpadRemark','rf_bus_con_quoted_price');
							return false;
									//$this=null;
						//}
					});

	// popup事件重写 
	function popupClickContractDetail(pobj, tablefield, inputnames, pcode) {
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
	            if (selected == '' || selected == null) {
	                alert($.i18n.prop('common.select.please'));
	                return false;
	            } else {
	                //对应数据库字段不为空的情况下,根据表单中字典TEXT的值来取popup的值 
	                if (tablefield != "" && tablefield != null) {
	                    var fields = inputnames.split(",");
	                    var tableF = tablefield.split(",");
	                 	for(var i = 0; i < selected.length; i++){
	                 		 var tr = $("#add_busPoApplyDetail_table_template tr").clone();
	            	 			 $("#add_busPoApplyDetail_table").append(tr);
	            	 			inputBindEvents(tr)
	            	 			resetTrNum('add_busPoApplyDetail_table');
	                 		//busPoContractDetailList[#index#].bpcdNumber
	                 		var name = $(tr).find("input").eq(2).attr("name")
	                 		var inputs = name.split(".");
	                		fields.forEach(function(item, index){
	                 			$("input[name='"+inputs[0]+"."+ item +"']").val(selected[i][tableF[index]])
	                 		}) 
	                 	}
	                }
	                //firstCompute();
	            }
	        },
	        cancelVal: $.i18n.prop('dialog.close'),
	        cancel: true // 为true等价于function(){}
	    });
	}
	
	function inputBindEvents(tr){
		var $tr = $(tr);
		var pInp = $tr.find("input[name$='.bpcdPrice']"),
			nInp = $tr.find("input[name$='.bpcdNumber']"),
			aInp = $tr.find("input[name$='.bpcdAmount']");
		pInp.bind("change",function(e){
			aInp.val(+pInp.val() * +nInp.val())
			computeTotal();
		})
		nInp.bind("change",function(e){
			aInp.val(+pInp.val() * +nInp.val())
			computeTotal();
		})
	}
	
	$(document).ready(function() {
		
		
		$("input[name='busPoApplyDetailList[0].purchaseOrNot']").val("未采购");
		$(".datagrid-toolbar").parent().css("width", "auto");
		if (location.href.indexOf("load=detail") != -1) {
			$(":input").attr("disabled", "true");
			$(".datagrid-toolbar").hide();
		}
	});
</script>
<div style="padding: 3px; height: 25px; width: auto;"
	class="datagrid-toolbar">
	<a id="addBusPoApplyDetailBtn" href="#">添加</a> <a
		id="delBusPoApplyDetailBtn" href="#">删除</a> <a
		id="choiceaddBusPoApplyDetailBtn" href="#">选择新增</a>
		<a id="ExportXlsByTBtn" href="#">excel模板下载</a><a
		id="ImportXlsBusPoApplyDetailBtn" href="#">excel导入</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0"
	id="busPoApplyDetail_table">

	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;">名称</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;">品牌</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;">型号</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;">数量</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;">备注</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;">是否采购</td>

	</tr>
	<tbody id="add_busPoApplyDetail_table">
		<c:if test="${fn:length(busPoApplyDetailList)  <= 0 }">

			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width: 20px;" type="checkbox"
					name="ck" /></td>
				<input name="busPoApplyDetailList[0].id" type="hidden" />
				<input name="busPoApplyDetailList[0].createName" type="hidden" />
				<input name="busPoApplyDetailList[0].createBy" type="hidden" />
				<input name="busPoApplyDetailList[0].createDate" type="hidden" />
				<input name="busPoApplyDetailList[0].updateName" type="hidden" />
				<input name="busPoApplyDetailList[0].updateBy" type="hidden" />
				<input name="busPoApplyDetailList[0].updateDate" type="hidden" />
				<input name="busPoApplyDetailList[0].sysOrgCode" type="hidden" />
				<input name="busPoApplyDetailList[0].sysCompanyCode" type="hidden" />
				<input name="busPoApplyDetailList[0].bpmStatus" type="hidden" />
				<td align="left"><input name="busPoApplyDetailList[0].bpadName"
					maxlength="200" type="text" class="inputxt" style="width: 120px;"
					ignore="ignore"> <label class="Validform_label"
					style="display: none;">名称</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[0].bpadBrand" maxlength="200"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">品牌</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[0].bpadModel" maxlength="200"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">型号</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[0].bpadNumber" maxlength="12"
					type="text" class="inputxt" style="width: 120px;"
					datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore"> <label
					class="Validform_label" style="display: none;">数量</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[0].bpadRemark" maxlength="500"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">备注</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[0].purchaseOrNot" maxlength="32"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore"
					readonly="readonly"> <label class="Validform_label"
					style="display: none;">是否采购</label></td>
				<td align="left"><input name="busPoApplyDetailList[0].fromId"
					maxlength="32" type="hidden" class="inputxt" style="width: 120px;"
					ignore="ignore"> <label class="Validform_label"
					style="display: none;">采购申请外键</label></td>

			</tr>
		</c:if>
		<c:if test="${fn:length(busPoApplyDetailList)  > 0 }">

			<c:forEach items="${busPoApplyDetailList}" var="poVal"
				varStatus="stuts">
				<tr>
					<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
					<td align="center"><input style="width: 20px;" type="checkbox"
						name="ck" /></td>
					<input name="busPoApplyDetailList[${stuts.index }].id"
						type="hidden" value="${poVal.id }" />
					<input name="busPoApplyDetailList[${stuts.index }].createName"
						type="hidden" value="${poVal.createName }" />
					<input name="busPoApplyDetailList[${stuts.index }].createBy"
						type="hidden" value="${poVal.createBy }" />
					<input name="busPoApplyDetailList[${stuts.index }].createDate"
						type="hidden" value="${poVal.createDate }" />
					<input name="busPoApplyDetailList[${stuts.index }].updateName"
						type="hidden" value="${poVal.updateName }" />
					<input name="busPoApplyDetailList[${stuts.index }].updateBy"
						type="hidden" value="${poVal.updateBy }" />
					<input name="busPoApplyDetailList[${stuts.index }].updateDate"
						type="hidden" value="${poVal.updateDate }" />
					<input name="busPoApplyDetailList[${stuts.index }].sysOrgCode"
						type="hidden" value="${poVal.sysOrgCode }" />
					<input name="busPoApplyDetailList[${stuts.index }].sysCompanyCode"
						type="hidden" value="${poVal.sysCompanyCode }" />
					<input name="busPoApplyDetailList[${stuts.index }].bpmStatus"
						type="hidden" value="${poVal.bpmStatus }" />
					<td align="left"><input
						name="busPoApplyDetailList[${stuts.index }].bpadName"
						maxlength="200" type="text" class="inputxt" style="width: 120px;"
						ignore="ignore" value="${poVal.bpadName }" /> <label
						class="Validform_label" style="display: none;">名称</label></td>
					<td align="left"><input
						name="busPoApplyDetailList[${stuts.index }].bpadBrand"
						maxlength="200" type="text" class="inputxt" style="width: 120px;"
						ignore="ignore" value="${poVal.bpadBrand }" /> <label
						class="Validform_label" style="display: none;">品牌</label></td>
					<td align="left"><input
						name="busPoApplyDetailList[${stuts.index }].bpadModel"
						maxlength="200" type="text" class="inputxt" style="width: 120px;"
						ignore="ignore" value="${poVal.bpadModel }" /> <label
						class="Validform_label" style="display: none;">型号</label></td>
					<td align="left"><input
						name="busPoApplyDetailList[${stuts.index }].bpadNumber"
						maxlength="12" type="text" class="inputxt" style="width: 120px;"
						datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore"
						value="${poVal.bpadNumber }" /> <label class="Validform_label"
						style="display: none;">数量</label></td>
					<td align="left"><input
						name="busPoApplyDetailList[${stuts.index }].bpadRemark"
						maxlength="500" type="text" class="inputxt" style="width: 120px;"
						ignore="ignore" value="${poVal.bpadRemark }" /> <label
						class="Validform_label" style="display: none;">备注</label></td>
					<td align="left"><input
						name="busPoApplyDetailList[${stuts.index }].purchaseOrNot"
						maxlength="32" type="text" class="inputxt" style="width: 120px;"
						ignore="ignore" value="" readonly="readonly" /> <label
						class="Validform_label" style="display: none;">是否采购</label></td>
					<td align="left"><input
						name="busPoApplyDetailList[${stuts.index }].fromId" maxlength="32"
						type="hidden" class="inputxt" style="width: 120px;"
						ignore="ignore" value="${poVal.fromId }" /> <label
						class="Validform_label" style="display: none;">采购申请外键</label></td>

				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>


