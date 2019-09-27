<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>费用报销</title>
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
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
  
  /*金额大写*/
  var digitUppercase = function(n) {
	    var fraction = ['角', '分'];
	    var digit = [
	        '零', '壹', '贰', '叁', '肆',
	        '伍', '陆', '柒', '捌', '玖'
	    ];
	    var unit = [
	        ['元', '万', '亿'],
	        ['', '拾', '佰', '仟']
	    ];
	    var head = n < 0 ? '欠' : '';
	    n = Math.abs(n);
	    var s = '';
	    for (var i = 0; i < fraction.length; i++) {
	        s += (digit[Math.floor(n * 10 * Math.pow(10, i)) % 10] + fraction[i]).replace(/零./, '');
	    }
	    s = s || '整';
	    n = Math.floor(n);
	    for (var i = 0; i < unit[0].length && n > 0; i++) {
	        var p = '';
	        for (var j = 0; j < unit[1].length && n > 0; j++) {
	            p = digit[n % 10] + unit[1][j] + p;
	            n = Math.floor(n / 10);
	        }
	        s = p.replace(/(零.)*零$/, '').replace(/^$/, '零') + unit[0][i] + s;
	    }
	    return head + s.replace(/(零.)*零元/, '元')
	        .replace(/(零.)+/g, '零')
	        .replace(/^整$/, '零元整');
	}
  
  function handleInput()
  {
	  var digitNumber=digitUppercase($('#totalMoney').val());
	  $('#totalMoneyCn').val(digitNumber);
  }
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="bsSubmitController.do?doAdd" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${bsSubmitPage.id }"/>
					<input id="fromProjmId" name="fromProjmId" type="hidden" />
				
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td class="value">
		     	<input id="projectName" name="projectName" type="text" maxlength="100" style="width: 150px" class="easyui-combogrid"  ignore="ignore"
		     	 data-options="panelWidth: 500,
		     	 idField: 'bpProjName',
		     	 textField: 'bpProjName',
		     	 url: 'vwBusProjectController.do?datagrid&field=id,bpProjId,bpProjName',
		     	 columns: [[  
	                {field:'bpProjId',title:'项目编码',width:80}, 
	                {field:'bpProjName',title:'项目名称',width:120} 
                ]],
                onSelect: function (row,data) {
                	$('#fromProjmId').val(data.id);
                	$('#projectId').val(data.bpProjId);
				},
                fitColumns: true" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目编号:</label>
			</td>
			<td class="value">
		     	 <input id="projectId" name="projectId" readonly="true" type="text" maxlength="32" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">报销人:</label>
			</td>
			<td class="value">
		     	 <input id="bsSubmiter" name="bsSubmiter" type="text" maxlength="30" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">报销人</label>
			</td>
			<td align="right">
				<label class="Validform_label">报销单号:</label>
			</td>
			<td class="value">
		     	 <input id="bsSubmitId" name="bsSubmitId" type="text" maxlength="40" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">报销单号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">部门:</label>
			</td>
			<td class="value">
		     	 <input id="bsDept" name="bsDept" type="text" maxlength="20" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">部门</label>
			</td>
			<td align="right">
				<label class="Validform_label">申请日期:</label>
			</td>
			<td class="value">
					  <input id="bsBeginDate" name="bsBeginDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">申请日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">报销日期:</label>
			</td>
			<td class="value">
					  <input id="bsSubmitDate" name="bsSubmitDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">报销日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
		     	 <input id="bsRemarks" name="bsRemarks" type="text" maxlength="500" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">票据类型:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="bsBillType" type="radio"   typeGroupCode="bill_type"  defaultVal="${bsSubmitPage.bsBillType}" hasLabel="false"  title="票据类型" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">票据类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">单据状态:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="bsState" type="list"   typeGroupCode="bs_state"  defaultVal="${bsSubmitPage.bsState}" hasLabel="false"  title="单据状态" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">单据状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">报销总金额:</label>
			</td>
			<td class="value">
		     	 <input id="totalMoney" name="totalMoney" oninput="handleInput()" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">报销总金额</label>
			</td>
			<td align="right">
				<label class="Validform_label">报销总金额大写:</label>
			</td>
			<td class="value">
		     	 <input id="totalMoneyCn" name="totalMoneyCn" type="text" readonly="true" maxlength="32" style="width: 150px;background-color:#F0F0F0;" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">报销总金额大写</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">附件:</label>
			</td>
			<td class="value">
				<div class="form jeecgDetail">
					<t:upload name="bsAnnex" id="bsAnnex" queueID="filediv_bsAnnex" outhtml="false" uploader="cgUploadController.do?saveFiles"  extend="office" buttonText='添加文件'  onUploadStart="bsAnnexOnUploadStart"> </t:upload>
					<div class="form" id="filediv_bsAnnex"></div>
					<script type="text/javascript">
						function bsAnnexOnUploadStart(file){
							var cgFormId=$("input[name='id']").val();
							$('#bsAnnex').uploadify("settings", "formData", {
								'cgFormId':cgFormId,
								'cgFormName':'bs_submit',
								'cgFormField':'BS_ANNEX'
							});
						}
					</script>
				</div>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">附件</label>
			</td>
			<td>
			</td>
			<td class="value"></td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="bsSubmitController.do?busSubmitDetailList&id=${bsSubmitPage.id}" icon="icon-search" title="费用报销明细" id="busSubmitDetail"></t:tab>
				 <t:tab href="bsSubmitController.do?busPayInfoList&id=${bsSubmitPage.id}" icon="icon-search" title="支付信息" id="busPayInfo"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_busSubmitDetail_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="busSubmitDetailList[#index#].bsdSeqNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">序号</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="busSubmitDetailList[#index#].bsdFeeType" type="list"    typeGroupCode="cost_type"  defaultVal="" hasLabel="false"  title="费用类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类型</label>
				  </td>
				  <td align="left">
					  	<input name="busSubmitDetailList[#index#].bsdAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">报销金额</label>
				  </td>
				  <td align="left">
					  	<input name="busSubmitDetailList[#index#].bsdDesc" maxlength="500" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">详细描述</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_busPayInfo_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="busPayInfoList[#index#].bpiClass" maxlength="30" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">功能分类</label>
				  </td>
				  <td align="left">
					  	<input name="busPayInfoList[#index#].bpiPayMethod" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">支付方式</label>
				  </td>
				  <td align="left">
							<input name="busPayInfoList[#index#].bpiPayDate" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">支付时间</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="busPayInfoList[#index#].bpiFeeType" type="list"    typeGroupCode="cost_type"  defaultVal="" hasLabel="false"  title="费用类别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类别</label>
				  </td>
				  <td align="left">
					  	<input name="busPayInfoList[#index#].bpiFeeDetail" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用明细</label>
				  </td>
				  <td align="left">
					  	<input name="busPayInfoList[#index#].bpiContent" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">内容</label>
				  </td>
				  <td align="left">
					  	<input name="busPayInfoList[#index#].bpiVoucherno" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">凭证号</label>
				  </td>
				  <td>
					  	<input name="busPayInfoList[#index#].fromProjmId" maxlength="32" type="hidden" />
					  	<input name="busPayInfoList[#index#].fromPayId" maxlength="32" type="hidden" />
					  	<input name="busPayInfoList[#index#].fromBankAccId" maxlength="32" type="hidden" />
					  	<input name="busPayInfoList[#index#].fromId" maxlength="32" type="hidden"  />
				 </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/action/actaccount/bsSubmit.js"></script>
  	<script type="text/javascript">
  		function jeecgFormFileCallBack(data){
  			if (data.success == true) {
				uploadFile(data);
			} else {
				if (data.responseText == '' || data.responseText == undefined) {
					$.messager.alert('错误', data.msg);
					$.Hidemsg();
				} else {
					try {
						var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
						$.messager.alert('错误', emsg);
						$.Hidemsg();
					} catch(ex) {
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
				$('#bsAnnex').uploadify('upload', '*');
		}
		
		var neibuClickFlag = false;
		function neibuClick() {
			neibuClickFlag = true; 
			$('#btn_sub').trigger('click');
		}
		function cancel() {
				$('#bsAnnex').uploadify('cancel', '*');
		}
		function uploadFile(data){
			if(!$("input[name='id']").val()){
				if(data.obj!=null && data.obj!='undefined'){
					$("input[name='id']").val(data.obj.id);
				}
			}
			if($(".uploadify-queue-item").length>0){
				upload();
			}else{
				if (neibuClickFlag){
					alert(data.msg);
					neibuClickFlag = false;
				}else {
					var win = frameElement.api.opener;
					win.reloadTable();
					win.tip(data.msg);
					frameElement.api.close();
				}
			}
		}
  	</script>
	