<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
		}
    });
</script>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:auto;">
<table cellpadding="0" cellspacing="1" class="formtable" id="busPayInfo_table" >
	<tbody id="add_busPayInfo_table" >	
	<c:if test="${fn:length(busPayInfoList)  <= 0 }">
			<tr>
					<input name="busPayInfoList[0].id" type="hidden"  value="${poVal.id}"/>
					<input name="busPayInfoList[0].createName" type="hidden"  value="${poVal.createName}"/>
					<input name="busPayInfoList[0].createBy" type="hidden"  value="${poVal.createBy}"/>
					<input name="busPayInfoList[0].createDate" type="hidden"  value="${poVal.createDate}"/>
					<input name="busPayInfoList[0].updateName" type="hidden"  value="${poVal.updateName}"/>
					<input name="busPayInfoList[0].updateBy" type="hidden"  value="${poVal.updateBy}"/>
					<input name="busPayInfoList[0].updateDate" type="hidden"  value="${poVal.updateDate}"/>
					<input name="busPayInfoList[0].sysOrgCode" type="hidden"  value="${poVal.sysOrgCode}"/>
					<input name="busPayInfoList[0].sysCompanyCode" type="hidden"  value="${poVal.sysCompanyCode}"/>
					<input name="busPayInfoList[0].bpmStatus" type="hidden"  value="${poVal.bpmStatus}"/>
					<input name="busPayInfoList[0].bpiClass" type="hidden"  value="${poVal.bpiClass}"/>
					<input name="busPayInfoList[0].bpiBusId" type="hidden"  value="${poVal.bpiBusId}"/>
					<input name="busPayInfoList[0].fromProjmId" type="hidden"  value="${poVal.fromProjmId}"/>
					<input name="busPayInfoList[0].fromPayId" type="hidden"  value="${poVal.fromPayId}"/>
			</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										支付方式:
									</label>
					</td>
				  <td class="value">
						<t:dictSelect field="busPayInfoList[0].bpiPayMethod" type="list"   typeGroupCode=""  defaultVal="${busPayInfoPage.bpiPayMethod}" hasLabel="false"  title="支付方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">支付方式</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										银行账号:
									</label>
					</td>
				  <td class="value">
						<t:dictSelect field="busPayInfoList[0].bpiBankNo" type="list"   typeGroupCode=""  defaultVal="${busPayInfoPage.bpiBankNo}" hasLabel="false"  title="银行账号"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">银行账号</label>
					</td>
				</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										支付时间:
									</label>
					</td>
				  <td class="value">
					      	<input name="busPayInfoList[0].bpiPayDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">支付时间</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										费用类别:
									</label>
					</td>
				  <td class="value">
						<t:dictSelect field="busPayInfoList[0].bpiFeeType" type="list"   typeGroupCode="cost_type"  defaultVal="${busPayInfoPage.bpiFeeType}" hasLabel="false"  title="费用类别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类别</label>
					</td>
				</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										费用明细:
									</label>
					</td>
				  <td class="value">
						<t:dictSelect field="busPayInfoList[0].bpiFeeDetail" type="list"   typeGroupCode=""  defaultVal="${busPayInfoPage.bpiFeeDetail}" hasLabel="false"  title="费用明细"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用明细</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										内容:
									</label>
					</td>
				  <td class="value">
						<t:dictSelect field="busPayInfoList[0].bpiContent" type="list"   typeGroupCode=""  defaultVal="${busPayInfoPage.bpiContent}" hasLabel="false"  title="内容"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">内容</label>
					</td>
				</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										凭证号:
									</label>
					</td>
				  <td class="value">
					  	<input name="busPayInfoList[0].bpiVoucherno" maxlength="20" type="text" class="inputxt"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">凭证号</label>
					</td>
				</tr>
	</c:if>
	<c:if test="${fn:length(busPayInfoList)  > 0 }">
		<c:forEach items="${busPayInfoList}" var="poVal" varStatus="stuts" begin="0" end="0">
			<tr>
					<input name="busPayInfoList[0].id" type="hidden" value="${poVal.id}"/>
					<input name="busPayInfoList[0].createName" type="hidden" value="${poVal.createName}"/>
					<input name="busPayInfoList[0].createBy" type="hidden" value="${poVal.createBy}"/>
					<input name="busPayInfoList[0].createDate" type="hidden" value="${poVal.createDate}"/>
					<input name="busPayInfoList[0].updateName" type="hidden" value="${poVal.updateName}"/>
					<input name="busPayInfoList[0].updateBy" type="hidden" value="${poVal.updateBy}"/>
					<input name="busPayInfoList[0].updateDate" type="hidden" value="${poVal.updateDate}"/>
					<input name="busPayInfoList[0].sysOrgCode" type="hidden" value="${poVal.sysOrgCode}"/>
					<input name="busPayInfoList[0].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode}"/>
					<input name="busPayInfoList[0].bpmStatus" type="hidden" value="${poVal.bpmStatus}"/>
					<input name="busPayInfoList[0].bpiClass" type="hidden" value="${poVal.bpiClass}"/>
					<input name="busPayInfoList[0].bpiBusId" type="hidden" value="${poVal.bpiBusId}"/>
					<input name="busPayInfoList[0].fromProjmId" type="hidden" value="${poVal.fromProjmId}"/>
					<input name="busPayInfoList[0].fromPayId" type="hidden" value="${poVal.fromPayId}"/>
			</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										支付方式:
									</label>
					</td>
				  <td class="value">
							<t:dictSelect field="busPayInfoList[0].bpiPayMethod" type="list"  typeGroupCode=""  defaultVal="${poVal.bpiPayMethod}" hasLabel="false"  title="支付方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">支付方式</label>
					</td>
				  <td align="right">

					<label class="Validform_label">
										银行账号:
									</label>
					</td>
				  <td class="value">
							<t:dictSelect field="busPayInfoList[0].bpiBankNo" type="list"  typeGroupCode=""  defaultVal="${poVal.bpiBankNo}" hasLabel="false"  title="银行账号"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">银行账号</label>
					</td>
				</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										支付时间:
									</label>
					</td>
				  <td class="value">
					      	<input name="busPayInfoList[0].bpiPayDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value="<fmt:formatDate value='${poVal.bpiPayDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>"/>
					  <label class="Validform_label" style="display: none;">支付时间</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										费用类别:
									</label>
					</td>
				  <td class="value">
							<t:dictSelect field="busPayInfoList[0].bpiFeeType" type="list"  typeGroupCode="cost_type"  defaultVal="${poVal.bpiFeeType}" hasLabel="false"  title="费用类别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用类别</label>
					</td>
				</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										费用明细:
									</label>
					</td>
				  <td class="value">
							<t:dictSelect field="busPayInfoList[0].bpiFeeDetail" type="list"  typeGroupCode=""  defaultVal="${poVal.bpiFeeDetail}" hasLabel="false"  title="费用明细"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用明细</label>
					</td>
				  <td align="right">
					<label class="Validform_label">
										内容:
									</label>
					</td>
				  <td class="value">
							<t:dictSelect field="busPayInfoList[0].bpiContent" type="list"  typeGroupCode=""  defaultVal="${poVal.bpiContent}" hasLabel="false"  title="内容"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">内容</label>
					</td>
				</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										凭证号:
									</label>
					</td>
				  <td class="value">
					  	<input name="busPayInfoList[0].bpiVoucherno" maxlength="20" type="text" class="inputxt"  ignore="ignore"  value="${poVal.bpiVoucherno }"/>
					  <label class="Validform_label" style="display: none;">凭证号</label>
					</td>
				</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>