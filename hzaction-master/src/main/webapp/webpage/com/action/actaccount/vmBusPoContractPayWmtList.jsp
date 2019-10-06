<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<!--<a id="addVmBusPoContractPayWmtBtn" href="#">添加</a>--> 
	<a id="delVmBusPoContractPayWmtBtn" href="#">删除</a>
	<a id="chooseVmBusPoContractPayWmtBtn" href="#">选择</a>
	<input id="chooseClick" name="chooseClick" type="text" style="width: 150px;display: none;" class="searchbox-inputtext"  ignore="ignore"   
		 onclick="popupClickBus(this,'bpc_po_no,bpcp_progre,bpcp_pay_amount,bpcp_date,from_id,bus_po_pay_id,from_projm_id,from_supp_id,bpcp_id',
		 'bpcPoNo,bpcpProgre,bpcpPayAmount,bpcpDate,fromId,busPoPayId,fromProjmIdF,fromSuppIdF,bpcpId',
		 'bus_po_contract_pay_wmt')" />
	<!-- <input id="testClick" name="testClick" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"   
		onclick="popupClickBus(this,'bpc_po_no,bpcp_progre,bpcp_pay_amount,bpcp_date,from_id,bus_po_pay_id,pay_amount,bpcp_remark,from_projm_id,from_supp_id',
		 'bpcPoNo,bpcpProgre,bpcpPayAmount,bpcpDate,fromId,busPoPayId,payAmount,bpcpRemark,fromProjmIdF,fromSuppIdF',
		 'bus_po_contract_pay_wmt')" /> -->
</div>
<table border="0" cellpadding="2" cellspacing="0" id="vmBusPoContractPayWmt_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						采购合同编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用分期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						计划付款金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						计划付款日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						采购合同外键
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						付款金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						采购付款单外键
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;" hidden="hidden">
						【实体表】采购付款单明细附表外键
				  </td>
	</tr>
	<tbody id="add_vmBusPoContractPayWmt_table">
	<c:if test="${fn:length(vmBusPoContractPayWmtList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="vmBusPoContractPayWmtList[0].id" type="hidden"/>
					<input name="vmBusPoContractPayWmtList[0].createName" type="hidden"/>
					<input name="vmBusPoContractPayWmtList[0].createBy" type="hidden"/>
					<input name="vmBusPoContractPayWmtList[0].createDate" type="hidden"/>
					<input name="vmBusPoContractPayWmtList[0].updateName" type="hidden"/>
					<input name="vmBusPoContractPayWmtList[0].updateBy" type="hidden"/>
					<input name="vmBusPoContractPayWmtList[0].updateDate" type="hidden"/>
					<input name="vmBusPoContractPayWmtList[0].sysOrgCode" type="hidden"/>
					<input name="vmBusPoContractPayWmtList[0].sysCompanyCode" type="hidden"/>
					<input name="vmBusPoContractPayWmtList[0].bpmStatus" type="hidden"/>
				  <td align="left">
					  	<input name="vmBusPoContractPayWmtList[0].bpcPoNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">采购合同编号</label>
					</td>
				 <td align="left">
							<t:dictSelect field="vmBusPoContractPayWmtList[0].bpcpProgre" type="list" typeGroupCode="cost_stag"  hasLabel="false"  title="费用分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用分期</label>
					</td> 
				  <td align="left">
					  	<input name="vmBusPoContractPayWmtList[0].bpcpPayAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">计划付款金额</label>
					</td>
				  <td align="left">
							<input name="vmBusPoContractPayWmtList[0].bpcpDate" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">计划付款日期</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="vmBusPoContractPayWmtList[0].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
					</td>
				  <td align="left">
					  	<input name="vmBusPoContractPayWmtList[0].payAmount" maxlength="32" type="text" class="inputxt" onchange="handleInput()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">付款金额</label>
					</td>
				  <td align="left">
					  	<input name="vmBusPoContractPayWmtList[0].bpcpRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="vmBusPoContractPayWmtList[0].busPoPayId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">采购付款单外键</label>
					</td>
				  <td align="left" hidden="hidden">
					  	<input name="vmBusPoContractPayWmtList[0].bpcpId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">采购付款单明细附表外键</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(vmBusPoContractPayWmtList)  > 0 }">
		<c:forEach items="${vmBusPoContractPayWmtList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="vmBusPoContractPayWmtList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="vmBusPoContractPayWmtList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="vmBusPoContractPayWmtList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="vmBusPoContractPayWmtList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="vmBusPoContractPayWmtList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="vmBusPoContractPayWmtList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="vmBusPoContractPayWmtList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="vmBusPoContractPayWmtList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="vmBusPoContractPayWmtList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="vmBusPoContractPayWmtList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
					  	<input name="vmBusPoContractPayWmtList[${stuts.index }].bpcPoNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcPoNo }"/>
					  <label class="Validform_label" style="display: none;">采购合同编号</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="vmBusPoContractPayWmtList[${stuts.index }].bpcpProgre" type="list" typeGroupCode="cost_stag"  defaultVal="${poVal.bpcpProgre }" title="费用分期"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">费用分期</label>
				   </td>
				   <td align="left">
					  	<input name="vmBusPoContractPayWmtList[${stuts.index }].bpcpPayAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcpPayAmount }"/>
					  <label class="Validform_label" style="display: none;">计划付款金额</label>
				   </td>
				   <td align="left">
							<input name="vmBusPoContractPayWmtList[${stuts.index }].bpcpDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:150px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.bpcpDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">计划付款日期</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="vmBusPoContractPayWmtList[${stuts.index }].fromId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fromId }"/>
					  <label class="Validform_label" style="display: none;">采购合同外键</label>
				   </td>
				   <td align="left">
					  	<input name="vmBusPoContractPayWmtList[${stuts.index }].payAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.payAmount }"/>
					  <label class="Validform_label" style="display: none;">付款金额</label>
				   </td>
				   <td align="left">
					  	<input name="vmBusPoContractPayWmtList[${stuts.index }].bpcpRemark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcpRemark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="vmBusPoContractPayWmtList[${stuts.index }].busPoPayId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.busPoPayId }"/>
					  <label class="Validform_label" style="display: none;">采购付款单外键</label>
				   </td>
				   <td align="left" hidden="hidden">
					  	<input name="vmBusPoContractPayWmtList[${stuts.index }].bpcpId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.bpcpId }"/>
					  <label class="Validform_label" style="display: none;">采购付款单明细附表外键</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
<script type="text/javascript">


	function handleInput()
	{
		 var totalM=0.0;
		 var trList = $("#add_vmBusPoContractPayWmt_table").children("tr");
		 for (var i=0;i<trList.length;i++) {
		      var tdArr = trList.eq(i).find("td");
		      var totalmoney = tdArr.eq(7).find('input').val();//付款金额 
		      if(!(totalmoney=="" || totalmoney==null))
		      	totalM=parseFloat(totalM)+parseFloat(totalmoney);
		 }
		 $('#bppMoney').val(totalM);
	}
	$('#addVmBusPoContractPayWmtBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delVmBusPoContractPayWmtBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addVmBusPoContractPayWmtBtn').bind('click', function(){   
 		 var tr =  $("#add_vmBusPoContractPayWmt_table_template tr").clone();
	 	 $("#add_vmBusPoContractPayWmt_table").append(tr);
	 	 resetTrNum('add_vmBusPoContractPayWmt_table');
	 	 return false;
    });  
	$('#delVmBusPoContractPayWmtBtn').bind('click', function(){
		$("#add_vmBusPoContractPayWmt_table").find("input[name$='ck']:checked").parent().parent().remove();
        resetTrNum('add_vmBusPoContractPayWmt_table'); 
		//start_wmt
        if($("#add_vmBusPoContractPayWmt_table tr").size()==0)	addTr(1)		       	
        //end_wmt
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
    
    
    
  //选择按钮
	$('#chooseVmBusPoContractPayWmtBtn').linkbutton({   
	    iconCls: 'icon-search'  
	});
	$('#chooseVmBusPoContractPayWmtBtn').bind('click', function(){   
	 	 var bpmName = $("#bpmName").val(); 
	 	 var bsName = $("#bsName").val();
	 	 if(bpmName.length!=0&&bsName.length!=0){
//		 	console.log("项目名称:",bpmName)
//	 	 	console.log("供应商名称:",bsName)
			$("#chooseClick").trigger("click");
	 	 }else{
	 	 	alert("请先填【项目名称】和【供应商名称】");
	 	 }
	 	 return false;
    });  
    
    
    //添加tr节点
    function addTr(size){
    	for (var i = 0; i < size; i++) {
    		var tr = $("#add_vmBusPoContractPayWmt_table_template tr").clone();
		 	$("#add_vmBusPoContractPayWmt_table").append(tr);
			resetTrNum('add_vmBusPoContractPayWmt_table');	
    	}
    }
    
    /**
     *   object: pobj当前操作的文本框.
     *   tablefield:对应字典TEXT,要从popup报表中获取的字段.
     *   inputnames:对应字典CODE,当前需要回填数据的文本框名称.
     *   pcode:动态报表的code
     */
    function popupClickBus(pobj,tablefield,inputnames,pcode) {
    	var fromProjmId = $("#fromProjId").val(); 
    	var fromSuppId = $("#fromSuppId").val(); 
    	//from_projm_id,from_supp_id
//    	console.log("项目管理外键:"+fromProjmId)
//    	console.log("供应商资料外键:"+fromSuppId)
    	
    	 if(inputnames==""||pcode==""){
    		 alert("popup参数配置不全");
    		 return;
    	 }
    	 if(typeof(windowapi) == 'undefined'){
    		 $.dialog({
    				content: "url:cgReportController.do?popup&id="+pcode+"&fromProjmId="+fromProjmId+"&fromSuppId="+fromSuppId ,
    				zIndex: getzIndex(),
    				lock : true,
    				title:"选择",
    				width:800,
    				height: 400,
    				cache:false,
    			    ok: function(){
    			    	iframe = this.iframe.contentWindow;
    			    	var selected = iframe.getSelectRows();
    			    	if (selected == '' || selected == null ){
    				    	alert("请选择");
    			    		return false;
    				    }else {
    				    	//对应数据库字段不为空的情况下,根据表单中字典TEXT的值来取popup的值
    				    	if(tablefield != "" && tablefield != null){
    					    	var fields = tablefield.split(",");
    					    	var inputfield = inputnames.split(",");
    					    	
    					    	for(var i1=0;i1<fields.length;i1++){
    							   var str = "";
    						    	$.each( selected, function(i, n){ 
    						    		if (i==0)
    								    	str+= n[fields[i1]];
    							    	else{
    										str+= ",";
    										str+=n[fields[i1]];
    									}
    								 });
    						    	var inputname = $(pobj).attr("name"); 
    						    	var inputs = inputname.split(".");
    						    	//判断传入的this格式是否为 "AA[#index#].aa"的形式
    						    	if(str.indexOf("undefined")==-1){
    						    		if(inputs.length>1){
    						    		﻿	//update--begin--author:scott date:20171031 for:TASK #2385 online和代码生成器 一对多行popup多字段赋值问题解决-----------
    						    			var inpu = inputs[0]+"."+inputfield[i1];

    						    			$("input[name='"+inpu+"']").val(str);
    						    		}else{
    						    			$("input[name='"+inputfield[i1]+"']").val(str);
    						    		}
    						    	}else{
    						    		if(inputs.length>1){
    						    			var inpu = inputs[0]+"."+inputfield[i1];
    										$("input[name='"+inpu+"']").val("");
    						    		}else{
    						    			$("input[name='"+inputfield[i1]+"']").val("");
    						    		}
    						    	}
    					    	}
    				    	}else{
    				    		//对应数据库字段为空的情况下并且字典CODE传入多个值时，根据表单中字典CODE的值从popup中来取值
    				    		var inputfield = inputnames.split(",");
    				    		if(inputfield.length>1){
    				    			for(var i1=0;i1<inputfield.length;i1++){
    									   var str = "";
    								    	$.each( selected, function(i, n){ 
    							    			if (i==0)
    							    				str+= n[inputfield[i1]];
    							    			else{
    							    				str+= ",";
    							    				str+=n[inputfield[i1]];
    							    			}
    										 });
    								    	var inputname = $(pobj).attr("name"); 
    								    	var inputs = inputname.split(".");
    								    	if(str.indexOf("undefined")==-1){
    								    		if(inputs.length>1){
    								    			var inpu = inputs[i1]+"."+inputfield[i1];
    								    			$("input[name='"+inpu+"']").val(str);
    								    		}else{
    								    			$("input[name='"+inputfield[i1]+"']").val(str);
    								    		}
    								    	}else{
    								    		if(inputs.length>1){
    								    			var inpu = inputs[i1]+"."+inputfield[i1];
    								    			$("input[name='"+inpu+"']").val("");
    								    		}else{
    								    			$("input[name='"+inputfield[i1]+"']").val("");
    								    		}
    								    	}
    							    	}
    				    		}else{
    				    			//对应数据库字段为空的情况下并且字典CODE传入一个值时，根据表单中字典TEXT的值从popup中来取值
    				    			 var str = "";
    						    	$.each( selected, function(i, n){
    							    	if (i==0)
    							    	str+= n[inputfield];
    							    	else
    						    		str+= ","+n[inputfield];
    						    	});
    						    	var inputname = $(pobj).attr("name"); 
    						    	var inputs = inputname.split(".");
    						    	if(str.indexOf("undefined")==-1){
    						    		if(inputs.length>1){

    						    			var inpu = inputs[0]+"."+inputfield[i1];

    						    			$("input[name='"+inpu+"']").val(str);
    						    		}else{
    						    			$("input[name='"+inputfield+"']").val(str);
    						    		}
    						    	}else{
    						    		if(inputs.length>1){

    						    			var inpu = inputs[0]+"."+inputfield[i1];

    						    			$("input[name='"+inpu+"']").val("");
    						    		}else{
    						    			$("input[name='"+inputfield+"']").val("");
    						    		}
    						    	}
    				    		}
    				    	}
    				    	return true;
    				    }
    					
    			    },
    			    cancelVal: '关闭',
    			    cancel: true // 为true等价于function(){}
    			});
    		}else{
    			$.dialog({
    				content: "url:cgReportController.do?popup&id="+pcode+"&fromProjmId="+fromProjmId+"&fromSuppId="+fromSuppId  ,
    				zIndex: getzIndex(),
    				lock : true,
    				title:"选择",
    				width:800,
    				height: 400,
    				parent:windowapi,
    				cache:false,
    			    ok: function(){
    			    	iframe = this.iframe.contentWindow;
    			    	var selected = iframe.getSelectRows();
    			    	
    			    	//start_wmt
//						获取当前视图存在多少条数据节点						
						var trSize = document.getElementById("add_vmBusPoContractPayWmt_table").getElementsByTagName("tr").length - 1
						//console.log("判断当前用户是否是初始操作:",trSize==0&&$("input[name='vmBusPoContractPayWmtList[0].fromId']").val()=="")
						if(trSize==0 && $("input[name='vmBusPoContractPayWmtList[0].fromId']").val()==""){
							if(selected.length>1) addTr(selected.length-1)
							selected.map(function(obj,index){
//								console.log(obj)  //每条选中的对象
//								console.log(selected.length)	//从0开始
								$("input[name='vmBusPoContractPayWmtList["+index+"].bpcPoNo']").val(obj.bpc_po_no)
								//console.log(obj.bpcp_progre)
								$("select[name='vmBusPoContractPayWmtList["+(index+trSize)+"].bpcpProgre']")
   									.find("option:contains("+obj.bpcp_progre+")").attr('selected',true)
								
   								/* $("select[name='vmBusPoContractPayWmtList["+index+"].bpcpProgre']")
   									.find("option:contains("+obj.bpcp_progre+")").attr('selected',true) */
   								
								$("input[name='vmBusPoContractPayWmtList["+index+"].bpcpPayAmount']").val(obj.bpcp_pay_amount)
	 							$("input[name='vmBusPoContractPayWmtList["+index+"].bpcpDate']").val(obj.bpcp_date)
   	 							$("input[name='vmBusPoContractPayWmtList["+index+"].fromId']").val(obj.from_id)
   	 							$("input[name='vmBusPoContractPayWmtList["+index+"].bpcpId']").val(obj.bpcp_id)
							});
						}else{
							addTr(selected.length)	
							selected.map(function(obj,index){
								//console.log(obj)  //每条选中的对象
//								console.log(selected.length)	//从0开始
								trSize = document.getElementById("add_vmBusPoContractPayWmt_table").getElementsByTagName("tr").length-selected.length
//								console.log($trSize)
								$("input[name='vmBusPoContractPayWmtList["+(index+trSize)+"].bpcPoNo']").val(obj.bpc_po_no)
								
 								//$("select[name='vmBusPoContractPayWmtList["+(index+trSize)+"].bpcpProgre']").val(obj.bpcp_progre)
 								$("select[name='vmBusPoContractPayWmtList["+(index+trSize)+"].bpcpProgre']")
   									.find("option:contains("+obj.bpcp_progre+")").attr('selected',true)
 								
  								$("input[name='vmBusPoContractPayWmtList["+(index+trSize)+"].bpcpPayAmount']").val(obj.bpcp_pay_amount)
	 							$("input[name='vmBusPoContractPayWmtList["+(index+trSize)+"].bpcpDate']").val(obj.bpcp_date)
 	 							$("input[name='vmBusPoContractPayWmtList["+(index+trSize)+"].fromId']").val(obj.from_id)
 	 							$("input[name='vmBusPoContractPayWmtList["+(index+trSize)+"].bpcpId']").val(obj.bpcp_id)
							});
						}
			    		//end_wmt
    			    	
    			    	if (selected == '' || selected == null ){
    				    	alert("请选择");
    			    		return false;
    				    }else {
    				    	//对应数据库字段不为空的情况下,根据表单中字典TEXT的值来取popup的值
    				    	if(tablefield != "" && tablefield != null){
    					    	var fields = tablefield.split(",");
    					    	var inputfield = inputnames.split(",");
    					    	for(var i1=0;i1<fields.length;i1++){
//  					    		console.log(i1) 7个返回值的属性名下标
    							   var str = "";
    						    	$.each( selected, function(i, n){
										//i：数组下标	n：数组每个对象
    						    		if (i==0)
    								    	str+= n[fields[i1]];
    							    	else{
    										str+= ",";
    										str+=n[fields[i1]];
    									}
    								 });
    						    	var inputname = $(pobj).attr("name"); 
    						    	var inputs = inputname.split(".");
    						    	//判断传入的this格式是否为 "AA[#index#].aa"的形式
    						    	if(str.indexOf("undefined")==-1){
    						    		if(inputs.length>1){
    						    			var inpu = inputs[0]+"."+inputfield[i1];
    						    			$("input[name='"+inpu+"']").val(str);
    						    		}else{
											$("input[name='"+inputfield[i1]+"']").val(str);
    						    		}
    						    	}else{
    						    		if(inputs.length>1){
    						    			var inpu = inputs[0]+"."+inputfield[i1];
    						    			$("input[name='"+inpu+"']").val("");
    						    		}else{
    						    			$("input[name='"+inputfield[i1]+"']").val("");
    						    		}
    						    	}
    					    	}
    				    	}else{
    				    		//对应数据库字段为空的情况下并且字典CODE传入多个值时，根据表单中字典CODE的值从popup中来取值
    				    		var inputfield = inputnames.split(",");
    				    		if(inputfield.length>1){
    				    			for(var i1=0;i1<inputfield.length;i1++){
    									   var str = "";
    								    	$.each( selected, function(i, n){ 
    							    			if (i==0)
    							    				str+= n[inputfield[i1]];
    							    			else{
    							    				str+= ",";
    							    				str+=n[inputfield[i1]];
    							    			}
    										 });
    								    	var inputname = $(pobj).attr("name"); 
    								    	var inputs = inputname.split(".");
    								    	if(str.indexOf("undefined")==-1){
    								    		if(inputs.length>1){
    								    			var inpu = inputs[i1]+"."+inputfield[i1];
    								    			$("input[name='"+inpu+"']").val(str);
    								    		}else{
    								    			$("input[name='"+inputfield[i1]+"']").val(str);
    								    		}
    								    	}else{
    								    		if(inputs.length>1){
    								    			var inpu = inputs[i1]+"."+inputfield[i1];
    								    			$("input[name='"+inpu+"']").val("");
    								    		}else{
    								    			$("input[name='"+inputfield[i1]+"']").val("");
    								    		}
    								    	}
    							    	}
    				    		}else{
    				    			//对应数据库字段为空的情况下并且字典CODE传入一个值时，根据表单中字典TEXT的值从popup中来取值
    				    			 var str = "";
    						    	$.each( selected, function(i, n){
    							    	if (i==0)
    							    	str+= n[inputfield];
    							    	else
    						    		str+= ","+n[inputfield];
    						    	});
    						    	var inputname = $(pobj).attr("name"); 
    						    	var inputs = inputname.split(".");
    						    	if(str.indexOf("undefined")==-1){
    						    		if(inputs.length>1){
    						    			var inpu = inputs[i1]+"."+inputfield[i1];
    						    			$("input[name='"+inpu+"']").val(str);
    						    		}else{
    						    			$("input[name='"+inputfield+"']").val(str);
    						    		}
    						    	}else{
    						    		if(inputs.length>1){
    						    			var inpu = inputs[i1]+"."+inputfield[i1];
    						    			$("input[name='"+inpu+"']").val("");
    						    		}else{
    						    			$("input[name='"+inputfield+"']").val("");
    						    		}
    						    	}
    				    		}
    				    	}
    				    	return true;
    				    }
    					
    			    },
    			    cancelVal: '关闭',
    			    cancel: true // 为true等价于function(){}
    			});
    		}
    	}
    //add--end--Author:gengjiajia date:20160802 for: TASK #1175 批量添加数据的时popup多值的传递
</script>
