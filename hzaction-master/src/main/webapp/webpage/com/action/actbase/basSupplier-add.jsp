<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>供应商资料</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码


  function createSupID(){
      $.ajax({
          type : "POST",
          url : 'basSupplierController.do?doCreateSupplierId',
          data: {id:""},
          success : function(res) {
              var data = JSON.parse(res);
              $("#bsId").val(data.msg)
          },
          error:function(){
              tip("产生客户编号错误！");
          }
      })
  }
  createSupID();
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="basSupplierController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${basSupplierPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							供应商编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsId" name="bsId" readonly="readonly" type="text" maxlength="20" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供应商编号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							供应商名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsName" name="bsName" type="text" maxlength="100" style="width: 300px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供应商名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							供应商简称:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsSname" name="bsSname" type="text" maxlength="32" style="width: 300px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供应商简称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							供应商地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsAddress" name="bsAddress" type="text" maxlength="100" style="width: 300px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供应商地址</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开户行:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsBankId" name="bsBankId" type="text" maxlength="50" style="width: 300px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开户行</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开户帐号:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsBankAcc" name="bsBankAcc" type="text" maxlength="50" style="width: 300px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开户帐号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							供应商联系人:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsContact" name="bsContact" type="text" maxlength="32" style="width: 300px"  class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供应商联系人</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							供应商联系人电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="bsTelNo" name="bsTelNo" type="text" maxlength="40" style="width: 300px" class="inputxt" datatype="m"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供应商联系人电话</label>
						</td>
				</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="height:auto;width:95%" class="inputxt" rows="6" id="bsRemark" name="bsRemark"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
