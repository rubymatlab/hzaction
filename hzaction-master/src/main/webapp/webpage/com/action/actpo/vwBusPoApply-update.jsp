<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>采购申请视图</title>
<style>
.ui-button {
	display: inline-block;
	padding: 2px 2px;
	margin-bottom: 0;
	font-size: 8px;
	font-weight: normal;
	line-height: 1.42857143;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 4px;
}
</style>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:base type="uploadify"></t:base>
<script type="text/javascript">

		
		
	
	//--------------下拉菜单—------------------

	$(function() {
		$("#bpmName")
				.dropDownSelect(
						{
							url : "vwBusPoApplyController/loadSuggestData.do?type=project&keyword="
						});

	})
	$.fn
			.extend({
				dropDownSelect : function(options) {
					var _this = this;
					var dropdowMenu = null;
					var oData = new Array();
					var timer = null;
					var attrs = new Array();
					var URL = options.url || ""
					options.index = options.index || 0
					init();
					function init() {
						createView();
						dropdowMenu = $(_this).parent().find(".dropdown-menu")
								.eq(0);
						dropdowMenu.hide();
						getData("");
						bindEvent();
					}
					function createView() {
						//找到父级 生成一个div.dropdown,将元素放进去
						var template = "<div class='dropdown'><button type='button'>▼</button><ul class='dropdown-menu' role='menu'></ul><div>"
						if (options.pos != "before") {
							$(_this).before($(template))
						} else {
							$(_this).parent().append($(template))
						}
						$(_this).parent().find(".dropdown").find('button')
								.before(_this)
						$(".dropdown").css({
							"position" : "relative",
							"display" : "inline-block",
							"border-collapse" : "separate"
						})
						$(".dropdown button").css({
							"position" : "absolute",
							"right" : "0px",
							"font-size" : "10px",
							"height" : "100%",
							"width" : "20px",
							"padding" : "0px"
						})
						$(".dropdown ul.dropdown-menu").css({
							"position" : "absolute",
							"z-index" : "999",
							"background" : "#e1e1e1",
							"max-height" : "200px",
							"overflow-y" : "scroll",
							"width" : "420px",
							"display" : "none"
						})
					}
					function bindEvent() {
						$(_this).blur(function() {
							dropdowMenu.hide();
						}).focus(function() {
							dropdowMenu.show();
						})
						// 输入筛选
						.on("input", function(e) {
							clearTimeout(timer);
							timer = setTimeout(function() {
								getData($(_this).val());
							}, 200)
						})
						$(_this).parent().find("button").on("click",
								function() {
									_this[0].focus();
								})
					}
					function getData(keyword) {
						$.ajax({
							method : "GET",
							url : URL + keyword,
							success : function(res) {

								renderData(JSON.parse(res))
							},
							fail : function(err) {
								console.log(err)
							}
						})
					}
					function renderData(data) {
						if (data.code == 200) {
							
							oData = data.value
							var html = "<table style='width:100%;background:#e1e1e1)'><tbody>"
							oData
									.forEach(function(item, index) {
										html += "<tr>"
										for ( var key in item) {
											html += "<td data-" + key + " style='-webkit-user-select: none'>"
													+ item[key] + "</td>"
										}
									})
							html += "</tbody></table>"
							//				显示
							dropdowMenu.html(html)
							bindEvent2tr();
						}
					}
					function bindEvent2tr() {
						dropdowMenu
								.find("table")
								.eq(0)
								.on(
										"mousedown",
										"tr",
										function(e) {
											if (options.pos == 'before') {
												$(_this)
														.val(
																$(
																		e.currentTarget)
																		.find(
																				"td")
																		.eq(
																				options.index)
																		.html())
											} else {

												var index = $(e.currentTarget)
														.index();

												dealbpaApplyNo(oData[index]['bp_proj_id']);

												for ( var key in oData[index]) {
													var tId = key
															.replace(
																	/_\w/g,
																	function($) {
																		return $
																				.slice(
																						1)
																				.toUpperCase()
																	})
													$("#" + tId)
															&& $("#" + tId)
																	.val(
																			oData[index][key])

												}

											}
										}).find('tr').hover(
										function(e) {
											$(this).find("td").css(
													"backgroundColor",
													"#ffffff")
										},
										function() {
											$(this).find("td").css(
													"backgroundColor",
													"transparent")
										})
					}

					//处理采购编号						

					function dealbpaApplyNo(BpProjId) {
						var url2 = "vwBusPoApplyController/creatBpProjId.do?type=project&BpProjId="
						$
								.ajax({
									method : "GET",
									url : url2 + BpProjId,
									success : function(res) {

										var data = JSON.parse(res);
										if (data.value.length == 0) {

											$("#bpaApplyNo").val(
													BpProjId + "-CG-001")
										} else {
											//最大的采购申请编号
											var bpa_apply_no = data.value[0].bpa_apply_no;
											//获取编号的后三位字符串

											var num = parseInt(bpa_apply_no
													.substring(
															bpa_apply_no.length - 3,
															bpa_apply_no.length)) + 1;

											var newnum = num + "";
											if (num < 10) {
												newnum = "00" + num;
											} else if (num < 100) {
												newnum = "0" + num;
											}
											//重新拼字符串，实现在原来的申请编号基础上加1；
											bpa_apply_no = bpa_apply_no
													.substring(
															0,
															bpa_apply_no.length - 3)
													+ newnum;

											$("#bpaApplyNo").val(bpa_apply_no);
										}

									},
									fail : function(err) {
										console.log(err)
									}
								})
					}
				}
			});
	$(document).ready(function() {
		$('#tt').tabs({
			onSelect : function(title) {
				$('#tt .panel-body').css('width', 'auto');
			}
		});
		$(".tabs-wrap").css('width', '100%');
	});
	
</script>
</head>
<body style="overflow-x: hidden;">
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" tiptype="1" action="vwBusPoApplyController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
		<input id="id" name="id" type="hidden" value="${vwBusPoApplyPage.id }" />
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right"><label class="Validform_label">采购申请编号:</label>
				</td>
				<td class="value"><input id="bpaApplyNo" name="bpaApplyNo"
					type="text" maxlength="40" style="width: 150px" class="inputxt"
					ignore="ignore" value='${vwBusPoApplyPage.bpaApplyNo}' readonly="readonly"/> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">采购申请编号</label></td>
				<td align="right"><label class="Validform_label">申请日期:</label>
				</td>
				<td class="value"><input id="bpaApplyDate" name="bpaApplyDate"
					type="text" style="width: 150px" ignore="ignore"
					value='<fmt:formatDate value='${vwBusPoApplyPage.bpaApplyDate}' type="date" pattern="yyyy-MM-dd"/>' />
					<span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">申请日期</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">项目名称:</label>
				</td>
				<td class="value"><input id="bpmName" name="bpmName"
					type="text" style="width: 150px" class="searchbox-inputtext"
					ignore="ignore" disabled="disabled"
					value='${vwBusPoApplyPage.bpmName}' /> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">项目名称</label></td>
				<td align="right"><label class="Validform_label">项目编号:</label>
				</td>
				<td class="value"><input id="bpProjId" name="bpProjId"
					type="text" maxlength="40" style="width: 150px" class="inputxt" readonly="readonly"
					ignore="ignore" value='${vwBusPoApplyPage.bpProjId}' /> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">项目编号</label></td>
			</tr>

			<tr>
				<td align="right"><label class="Validform_label">收货人:</label></td>
				<td class="value"><input id="bpaRecPeople" name="bpaRecPeople"
					type="text" maxlength="40" style="width: 150px" class="inputxt"
					ignore="ignore" value='${vwBusPoApplyPage.bpaRecPeople}' /> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">收货人</label></td>
				<td align="right"><label class="Validform_label">收货人电话:</label>
				</td>
				<td class="value"><input id="bpaRecTel" name="bpaRecTel"
					type="text" maxlength="40" style="width: 150px" class="inputxt"
					ignore="ignore" value='${vwBusPoApplyPage.bpaRecTel}' /> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">收货人电话</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">收货地址:</label>
				</td>
				<td class="value"><input id="bpaRecAddr" name="bpaRecAddr"
					type="text" maxlength="200" style="width: 150px" class="inputxt"
					ignore="ignore" value='${vwBusPoApplyPage.bpaRecAddr}' /> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">收货地址</label></td>				
			</tr>

		</table>
		<div style="overflow: scroll; width: auto; height: 300px;">
			<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
			<div style="width: 800px; height: 1px;"></div>
			<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				<t:tab
					href="vwBusPoApplyController.do?busPoApplyDetailList&id=${vwBusPoApplyPage.id}"
					icon="icon-search" title="采购申请明细" id="busPoApplyDetail"></t:tab>
			</t:tabs>
		</div>
	</t:formvalid>
	<!-- 添加 附表明细 模版 -->
	<table style="display: none">
		<tbody id="add_busPoApplyDetail_table_template">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh"></div></td>
				<td align="center"><input style="width: 20px;" type="checkbox"
					name="ck" /></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].bpadName" maxlength="200"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore" />
					<label class="Validform_label" style="display: none;">名称</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].bpadBrand" maxlength="200"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore" />
					<label class="Validform_label" style="display: none;">品牌</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].bpadModel" maxlength="200"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore" />
					<label class="Validform_label" style="display: none;">型号</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].bpadNumber" maxlength="22"
					type="text" class="inputxt" style="width: 120px;"
					datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" /> <label
					class="Validform_label" style="display: none;">数量</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].bpadRemark" maxlength="0"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore" />
					<label class="Validform_label" style="display: none;">备注</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].purchaseOrNot" maxlength="32"
					type="text" class="inputxt" style="width: 120px;" ignore="ignore" />
					<label class="Validform_label" style="display: none;">是否采购</label></td>
				<td align="left"><input
					name="busPoApplyDetailList[#index#].fromId" maxlength="32"
					type="hidden" class="inputxt" style="width: 120px;" ignore="ignore" />
					<label class="Validform_label" style="display: none;">采购申请外键</label>
				</td>
			</tr>
		</tbody>
	</table>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right"><label class="Validform_label">申请人:</label></td>
			<td class="value"><input id="bpaApplyPeople"
				name="bpaApplyPeople" type="text" maxlength="40"
				style="width: 150px" class="inputxt" ignore="ignore"
				value='${vwBusPoApplyPage.bpaApplyPeople}' /> <span
				class="Validform_checktip"></span> <label class="Validform_label"
				style="display: none;">申请人</label></td>
			<td align="right"><label class="Validform_label">单据状态:</label></td>
			<td class="value"><input id="bpaState" name="bpaState"
				type="text" maxlength="20" style="width: 150px" class="inputxt"
				ignore="ignore" value='' /> <span
				class="Validform_checktip"></span> <label class="Validform_label"
				style="display: none;">单据状态</label></td>

		</tr>
		<tr>
			<td align="right"><label class="Validform_label">采购申请附件:</label>
			</td>
			<td class="value">
				<table id="bpa_file_fileTable"></table>
				<div class="form jeecgDetail">
					<t:upload name="bpaFile" id="bpaFile" queueID="filediv_bpaFile"
						outhtml="false" uploader="vwBusPoApplyController.do?saveFiles"
						extend="office" buttonText='添加文件'
						onUploadStart="bpaFileOnUploadStart">
					</t:upload>
					<div class="form" id="filediv_bpaFile"></div>
					<script type="text/javascript">
						function bpaFileOnUploadStart(file) {
							var cgFormId = $("input[name='id']").val();
							$('#bpaFile').uploadify("settings", "formData", {
								'cgFormId' : cgFormId,
								'cgFormName' : 'bus_po_apply',
								'cgFormField' : 'BPA_FILE',
								'fileName':file.name
							});
						}
					</script>
				</div> <span class="Validform_checktip"></span> <label
				class="Validform_label" style="display: none;">采购申请附件</label>
			</td>
		</tr>
	</table>
</body>
<script src="webpage/com/action/actpo/vwBusPoApply.js"></script>
<script type="text/javascript">
//审核状态的数据处理
$(function(){
	var bpaSate= '${vwBusPoApplyPage.bpaState}';
	var bpaSate_value='';
	switch(bpaSate){
	case '0':
		bpaSate_value='制作中'
		break;
	case '1':
		bpaSate_value='已驳回'
		break;
	case '2':
		bpaSate_value='待审核'
		break;
	case '3':
		bpaSate_value='项目经理已审核'
		break;
	case '5':
		bpaSate_value='市场部已审核'
		break;
	case '6':
		bpaSate_value='采购已审核'
		break;
	
	}
	
$("#bpaState").val(bpaSate_value);
})
	


	//加载 已存在的 文件
	$(function() {
		var cgFormId = $("input[name='id']").val();
	
		
		$
				.ajax({
					type : "post",
					url : "vwBusPoApplyController.do?getFiles&id=" + cgFormId,
					success : function(data) {
						
						
						
						var arrayFileObj = jQuery.parseJSON(data).obj;

						$.each(
										arrayFileObj,
										function(n, file) {
											var fieldName = file.field
													.toLowerCase();
											var table = $("#" + fieldName
													+ "_fileTable");
											var tr = $("<tr style=\"height:34px;\"></tr>");
											var title = file.title;
											if (title.length > 15) {
												title = title.substring(0, 12)
														+ "...";
											}
											var td_title = $("<td>" + title
													+ "</td>");
											var td_download = $("<td><a style=\"margin-left:10px;\" href=\"commonController.do?viewFile&fileid="
													+ file.fileKey
													+ "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
											var td_view = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid="
													+ file.fileKey
													+ "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
											tr.appendTo(table);
											td_title.appendTo(tr);
											td_download.appendTo(tr);
											td_view.appendTo(tr);
											if (location.href
													.indexOf("load=detail") == -1) {
												var td_del = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0)\" class=\"jeecgDetail\" onclick=\"del('cgUploadController.do?delFile&id="
														+ file.fileKey
														+ "',this)\">删除</a></td>");
												td_del.appendTo(tr);
											}

										});
					}
				});
	})

	/**
	 * 删除图片数据资源
	 */
	function del(url, obj) {
		var content = "请问是否要删除该资源";
		var navigatorName = "Microsoft Internet Explorer";
		if (navigator.appName == navigatorName) {
			$.dialog.confirm(content, function() {
				submit(url, obj);
			}, function() {
			});
		} else {
			layer.open({
				title : "提示",
				content : content,
				icon : 7,
				yes : function(index) {
					submit(url, obj);
				},
				btn : [ '确定', '取消' ],
				btn2 : function(index) {
					layer.close(index);
				}
			});
		}
	}

	function submit(url, obj) {
		$.ajax({
			async : false,
			cache : false,
			type : 'POST',
			url : url,// 请求的action路径
			error : function() {// 请求失败处理函数
			},
			success : function(data) {
				var d = $.parseJSON(data);
				if (d.success) {
					var msg = d.msg;
					tip(msg);
					obj.parentNode.parentNode.parentNode
							.deleteRow(obj.parentNode.parentNode);
				} else {
					tip(d.msg);
				}
			}
		});
	}

	function jeecgFormFileCallBack(data) {
		if (data.success == true) {
			uploadFile(data);
		} else {
			if (data.responseText == '' || data.responseText == undefined) {
				$.messager.alert('错误', data.msg);
				$.Hidemsg();
			} else {
				try {
					var emsg = data.responseText
							.substring(data.responseText.indexOf('错误描述'),
									data.responseText.indexOf('错误信息'));
					$.messager.alert('错误', emsg);
					$.Hidemsg();
				} catch (ex) {
					$.messager.alert('错误', data.responseText + '');
				}
			}
			return false;
		}
		if (!neibuClickFlag) {
			var win = frameElement.api.opener;
			win.reloadTable();
		}
	}
	function upload() {
		$('#bpaFile').uploadify('upload', '*');
	}

	var neibuClickFlag = false;
	function neibuClick() {
		neibuClickFlag = true;
		$('#btn_sub').trigger('click');
	}
	function cancel() {
		$('#bpaFile').uploadify('cancel', '*');
	}
	function uploadFile(data) {
		if (!$("input[name='id']").val()) {
			if (data.obj != null && data.obj != 'undefined') {
				$("input[name='id']").val(data.obj.id);
			}
		}
		if ($(".uploadify-queue-item").length > 0) {
			upload();
		} else {
			if (neibuClickFlag) {
				alert(data.msg);
				neibuClickFlag = false;
			} else {
				var win = frameElement.api.opener;
				win.reloadTable();
				win.tip(data.msg);
				frameElement.api.close();
			}
		}
	}
</script>