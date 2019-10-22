<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addBusConQuotedPriceBtn" href="#">添加</a>
	<a id="delBusConQuotedPriceBtn" href="#">删除</a>
	<a id="putout-excel" href="#">模板下载</a>
	<a id="inport-excel" href="#">导入文件</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="busConQuotedPrice_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
			创建人名称
		</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
			创建人登录名称
		</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
			创建日期
		</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
			更新人名称
		</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
			更新人登录名称
		</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
			更新日期
		</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
			所属部门
		</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
			所属公司
		</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
			流程状态
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
		<td hidden="hidden" align="left" bgcolor="#EEEEEE" style="width: 126px;">
			合同管理外键
		</td>
	</tr>
	<tbody id="add_busConQuotedPrice_table">
		<%-- <c:if test="${fn:length(busConQuotedPriceList)  <= 0 }">
			<tr>
				<td align="center">
					<div style="width: 25px;" name="xh">1</div>
				</td>
				<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
				<input name="busConQuotedPriceList[0].id" type="hidden" />
				<td align="left" hidden="hidden">
					<input name="busConQuotedPriceList[0].createName" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">创建人名称</label>
				</td>
				<td align="left" hidden="hidden">
					<input name="busConQuotedPriceList[0].createBy" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">创建人登录名称</label>
				</td>
				<td align="left" hidden="hidden">
					<input name="busConQuotedPriceList[0].createDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()" style="width:150px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">创建日期</label>
				</td>
				<td align="left" hidden="hidden">
					<input name="busConQuotedPriceList[0].updateName" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">更新人名称</label>
				</td>
				<td align="left" hidden="hidden">
					<input name="busConQuotedPriceList[0].updateBy" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">更新人登录名称</label>
				</td>
				<td align="left" hidden="hidden">
					<input name="busConQuotedPriceList[0].updateDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()" style="width:150px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">更新日期</label>
				</td>
				<td align="left" hidden="hidden">
					<input name="busConQuotedPriceList[0].sysOrgCode" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">所属部门</label>
				</td>
				<td align="left" hidden="hidden">
					<input name="busConQuotedPriceList[0].sysCompanyCode" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">所属公司</label>
				</td>
				<td align="left" hidden="hidden">
					<input name="busConQuotedPriceList[0].bpmStatus" maxlength="32" type="text" class="inputxt" style="width:120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">流程状态</label>
				</td>
				<td align="left">
					<input name="busConQuotedPriceList[0].bcqpName" maxlength="32" type="text" class="inputxt" style="width:120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">名称</label>
				</td>
				<td align="left">
					<input name="busConQuotedPriceList[0].bcqpBrand" maxlength="32" type="text" class="inputxt" style="width:120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">品牌</label>
				</td>
				<td align="left">
					<input name="busConQuotedPriceList[0].bcqpModel" maxlength="32" type="text" class="inputxt" style="width:120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">型号</label>
				</td>
				<td align="left">
					<input name="busConQuotedPriceList[0].bcqpQty" maxlength="22" type="text" class="inputxt" style="width:120px;" datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore">
					<label class="Validform_label" style="display: none;">数量</label>
				</td>
				<td align="left">
					<input name="busConQuotedPriceList[0].bcqpPrice" maxlength="22" type="text" class="inputxt" style="width:120px;" datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore">
					<label class="Validform_label" style="display: none;">单价</label>
				</td>
				<td align="left">
					<input name="busConQuotedPriceList[0].bcqpAmount" maxlength="22" type="text" class="inputxt" style="width:120px;" datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore">
					<label class="Validform_label" style="display: none;">金额</label>
				</td>
				<td align="left" hidden="hidden">
					<input name="busConQuotedPriceList[0].busContractId" maxlength="32" type="text" class="inputxt" style="width:120px;" ignore="ignore">
					<label class="Validform_label" style="display: none;">合同管理外键</label>
				</td>
			</tr>
		</c:if> --%>
		<c:if test="${fn:length(busConQuotedPriceList)  > 0 }">
			<c:forEach items="${busConQuotedPriceList}" var="poVal" varStatus="stuts">
				<tr>
					<td align="center">
						<div style="width: 25px;" name="xh">${stuts.index+1 }</div>
					</td>
					<td align="center"><input style="width:20px;" type="checkbox" name="ck" /></td>
					<input name="busConQuotedPriceList[${stuts.index }].id" type="hidden" value="${poVal.id }" />
					<td align="left" hidden="hidden">
						<input name="busConQuotedPriceList[${stuts.index }].createName" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore" value="${poVal.createName }" />
						<label class="Validform_label" style="display: none;">创建人名称</label>
					</td>
					<td align="left" hidden="hidden">
						<input name="busConQuotedPriceList[${stuts.index }].createBy" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore" value="${poVal.createBy }" />
						<label class="Validform_label" style="display: none;">创建人登录名称</label>
					</td>
					<td align="left" hidden="hidden">
						<input name="busConQuotedPriceList[${stuts.index }].createDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()" style="width:150px;" ignore="ignore" value="<fmt:formatDate value='${poVal.createDate}' type="date" pattern="yyyy-MM-dd"/>"/>
						<label class="Validform_label" style="display: none;">创建日期</label>
					</td>
					<td align="left" hidden="hidden">
						<input name="busConQuotedPriceList[${stuts.index }].updateName" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore" value="${poVal.updateName }" />
						<label class="Validform_label" style="display: none;">更新人名称</label>
					</td>
					<td align="left" hidden="hidden">
						<input name="busConQuotedPriceList[${stuts.index }].updateBy" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore" value="${poVal.updateBy }" />
						<label class="Validform_label" style="display: none;">更新人登录名称</label>
					</td>
					<td align="left" hidden="hidden">
						<input name="busConQuotedPriceList[${stuts.index }].updateDate" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()" style="width:150px;" ignore="ignore" value="<fmt:formatDate value='${poVal.createDate}' type="date" pattern="yyyy-MM-dd"/>"/>
						<label class="Validform_label" style="display: none;">更新日期</label>
					</td>
					<td align="left" hidden="hidden">
						<input name="busConQuotedPriceList[${stuts.index }].sysOrgCode" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore" value="${poVal.sysOrgCode }" />
						<label class="Validform_label" style="display: none;">所属部门</label>
					</td>
					<td align="left" hidden="hidden">
						<input name="busConQuotedPriceList[${stuts.index }].sysCompanyCode" maxlength="50" type="text" class="inputxt" style="width:120px;" ignore="ignore" value="${poVal.sysCompanyCode }" />
						<label class="Validform_label" style="display: none;">所属公司</label>
					</td>
					<td align="left" hidden="hidden">
						<input name="busConQuotedPriceList[${stuts.index }].bpmStatus" maxlength="32" type="text" class="inputxt" style="width:120px;" ignore="ignore" value="${poVal.bpmStatus }" />
						<label class="Validform_label" style="display: none;">流程状态</label>
					</td>
					<td align="left">
						<input name="busConQuotedPriceList[${stuts.index }].bcqpName" maxlength="32" type="text" class="inputxt" style="width:120px;" ignore="ignore" value="${poVal.bcqpName }" />
						<label class="Validform_label" style="display: none;">名称</label>
					</td>
					<td align="left">
						<input name="busConQuotedPriceList[${stuts.index }].bcqpBrand" maxlength="32" type="text" class="inputxt" style="width:120px;" ignore="ignore" value="${poVal.bcqpBrand }" />
						<label class="Validform_label" style="display: none;">品牌</label>
					</td>
					<td align="left">
						<input name="busConQuotedPriceList[${stuts.index }].bcqpModel" maxlength="32" type="text" class="inputxt" style="width:120px;" ignore="ignore" value="${poVal.bcqpModel }" />
						<label class="Validform_label" style="display: none;">型号</label>
					</td>
					<td align="left">
						<input name="busConQuotedPriceList[${stuts.index }].bcqpQty" maxlength="22" type="text" class="inputxt" style="width:120px;" datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" value="${poVal.bcqpQty }" />
						<label class="Validform_label" style="display: none;">数量</label>
					</td>
					<td align="left">
						<input name="busConQuotedPriceList[${stuts.index }].bcqpPrice" maxlength="22" type="text" class="inputxt" style="width:120px;" datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" value="${poVal.bcqpPrice }" />
						<label class="Validform_label" style="display: none;">单价</label>
					</td>
					<td align="left">
						<input name="busConQuotedPriceList[${stuts.index }].bcqpAmount" readonly="readonly" maxlength="22" type="text" class="inputxt" style="width:120px;" datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" value="${poVal.bcqpAmount }" />
						<label class="Validform_label" style="display: none;">金额</label>
					</td>
					<td align="left" hidden="hidden">
						<input name="busConQuotedPriceList[${stuts.index }].busContractId" maxlength="32" type="text" class="inputxt" style="width:120px;" ignore="ignore" value="${poVal.busContractId }" />
						<label class="Validform_label" style="display: none;">合同管理外键</label>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>


<script type="text/javascript">
	$('#addBusConQuotedPriceBtn').linkbutton({
		iconCls: 'icon-add'
	});
	$('#delBusConQuotedPriceBtn').linkbutton({
		iconCls: 'icon-remove'
	});

	$('#addBusConQuotedPriceBtn').bind('click', function() {
		var tr = $("#add_busConQuotedPrice_table_template tr").clone();
		$("#add_busConQuotedPrice_table").append(tr);
		resetTrNum('add_busConQuotedPrice_table');
		addEventChange()
		return false;
	});
	$('#delBusConQuotedPriceBtn').bind('click', function() {
		$("#add_busConQuotedPrice_table").find("input[name$='ck']:checked").parent().parent().remove();
		resetTrNum('add_busConQuotedPrice_table');
		
		if($("#add_busConQuotedPrice_table tr").size()==0) addTr(1)
		
		return false;
	});
	
	//添加tr节点
    function addTr(size){
    	for (var i = 0; i < size; i++) {
    		var tr = $("#add_busConQuotedPrice_table_template tr").clone();
			$("#add_busConQuotedPrice_table").append(tr);
			resetTrNum('add_busConQuotedPrice_table');
    	}
    	addEventChange()
    }
	
	
	$(document).ready(function() {
		$(".datagrid-toolbar").parent().css("width", "auto");
		if(location.href.indexOf("load=detail") != -1) {
			$(":input").attr("disabled", "true");
			$(".datagrid-toolbar").hide();
		}
		addEventChange()
	});
	
	//监听事件--进行自动计算
	function addEventChange(){
		//数量
		$("#add_busConQuotedPrice_table tr td input[name$=bcqpQty]").change(function(obj) {
			var $bcqpPrice = $(obj.target).parent().next().children(":first")
			if(+$(obj.target).val()>=0&&+$bcqpPrice.val()>=0){
				$bcqpPrice.parent().next().children(":first").val((+$(obj.target).val()*+$bcqpPrice.val()).toFixed(2))
			}
			console.log($bcqpPrice.parent().next().children(":first").val())
		})
		//单价
		$("#add_busConQuotedPrice_table tr td input[name$=bcqpPrice]").change(function(obj) {
			var $bcqpQty = $(obj.target).parent().prev().children(":first")
			if($(obj.target).val()>=0&&+$bcqpQty.val()>=0){
				$(obj.target).parent().next().children(":first").val((+$bcqpQty.val()*+$(obj.target).val()).toFixed(2))
			}
			console.log($(obj.target).parent().next().children(":first").val())
		})
	}
	
	
	//模板下载excel样式
	$('#putout-excel').linkbutton({
		iconCls: 'icon-putout'
	});
	//模板下载excel事件
	$('#putout-excel').bind('click', function() {
		location.href = "busContractController.do?exportXlsByT2"
	});
	
	//导入excel样式
	$('#inport-excel').linkbutton({
		iconCls: 'icon-undo'
	});
	//导入excel事件
	$('#inport-excel').bind('click', function() {
		openuploadwinUpload('Excel导入', 'busContractController.do?upload', 'busContractList');
		return false;
	});
	
	function openuploadwinUpload(title, url, name, width, height) {
		gridname = name;
		$.dialog({
			content: 'url:' + url,
			zIndex: getzIndex(),
			cache: false,
			button: [{
					name: $.i18n.prop('upload.file.begin'),
					callback: function() {
						iframe = this.iframe.contentWindow;
						iframe.upload();
						return false;
					},
					//自定义回调
					uploaded(row) {
						var data = row.obj;
						//console.log(data);
						for(var i = 0; i < data.length; i++) {
							var tr = $("#add_busConQuotedPrice_table_template tr").clone();	//克隆一个tr
							$("#add_busConQuotedPrice_table").append(tr);	//追加一个tr
							resetTrNum('add_busConQuotedPrice_table');
							var name = $(tr).find("input").eq(2).attr("name");
							var inputs = name.split(".")
							for(var key in data[i]) {
								$("input[name='" + inputs[0] + "." + key + "']") &&
								$("input[name='" + inputs[0] + "." + key + "']").val(data[i][key])
							} 
						}
					},
					focus: true,
				},
				{
					name: $.i18n.prop('upload.file.cancel'),
					callback: function() {
						iframe = this.iframe.contentWindow;
						iframe.cancel();
					}
				}
			]
		});
	}
	
</script>