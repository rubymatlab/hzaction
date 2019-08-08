<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

  <t:datagrid name="busContractList" checkbox="true" fitColumns="true" title="合同管理" sortName="createDate" actionUrl="busContractController.do?datagrid&contractState=1" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   
   <t:dgCol title="客户编号"  field="bcCustomerCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="bcCustomerName"  query="true"  queryMode="single"  dictionary="bas_customer,bcCustomerName,bc_name"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="fromProjName" hidden="true" query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="bcProjectCode"  queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="合同名称"  field="bcContractName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户签约人"  field="bcCustContractor" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="我方签约人"  field="bcCompContractor" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="签订时间"  field="bcConcludeTime"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合同开始时间"  field="bcContStartTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同结束时间"  field="bcContEndTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同金额"  field="bcContAmount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同完成状态"  field="bcContractState"  hidden="true" queryMode="single"  dictionary="state"  width="120"></t:dgCol>
   <t:dgCol title="项目立项外键"  field="fromProjId" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户资料外键"  field="fromCustId" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   
   <!-- ++++++++++++ -->
   <t:dgCol title="中标方"  field="bcWinBidder"  queryMode="single"  hidden="true"  width="120"></t:dgCol>
   <t:dgCol title="管理费百分比"  field="bcManPer"  queryMode="single"  hidden="true"  width="120"></t:dgCol>
   <t:dgCol title="中标服务费"  field="bcWinSfee"  queryMode="single"  hidden="true"  width="120"></t:dgCol>
   <t:dgCol title="安信金额"  field="bcActionAmount"  queryMode="single"  hidden="true"  width="120"></t:dgCol>
   
   
   <!-- 工具栏 -->
   <t:dgCol title="操作" field="opt" ></t:dgCol>
   <t:dgDelOpt title="删除" url="busContractController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="查看" icon="icon-search" url="busContractController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>

   <t:dgToolBar title="合同维护" icon="icon-edit" url="busContractController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="合同确定" icon="icon-save"  url="busContractController.do?affirmButton" funname="affirmButton" ></t:dgToolBar>
   <t:dgToolBar title="汇出excel" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   
   
   <t:dgToolBar title="录入" icon="icon-add" url="busContractController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <%-- <t:dgToolBar title="批量删除"  icon="icon-remove" url="busContractController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
   <%-- <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  
 <script type="text/javascript">
 
//自定义按钮-sql增强-测试button
	function affirmButton(title,url,id){
		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择合同');
			return;
		}
		url = url+"&id="+rowData['id'];
		bc_createdialog('确认 ', title+'吗 ?', url,gridname);
	}

	/**
	 * 创建询问窗口
	 * 
	 * @param title
	 * @param content
	 * @param url
	 * @param noShade 不赋值则有遮罩
	 */

	function bc_createdialog(title, content, url,name,noShade) {
		$.dialog.setting.zIndex = getzIndex(true);
//		$.dialog.confirm(content, function(){
//			doSubmit(url,name);
//			rowid = '';
//		}, function(){
//		});

		var navigatorName = "Microsoft Internet Explorer"; 

		if( navigator.appName == navigatorName ||"default,shortcut".indexOf(getCookie("JEECGINDEXSTYLE"))>=0){ 

			$.dialog.confirm(content, function(){
				doSubmit(url,name);
				rowid = '';
			}, function(){
			});
		}else{
			layer.open({
				title:title,
				content:content,
				icon:7,
				shade: !noShade?0.3:0,
				yes:function(index){
					doSubmit(url,name);
					rowid = '';
					
				},
				btn:['确定','取消'],
				btn2:function(index){
					layer.close(index);
				}
			});
		}

	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'busContractController.do?upload', "busContractList");
}

//导出
function ExportXls() {
	JeecgExcelExport("busContractController.do?exportXls","busContractList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("busContractController.do?exportXlsByT","busContractList");
}



/**
 * 创建添加或编辑窗口
 * 
 * @param title
 * @param addurl
 * @param saveurl
 */
function bus_createwindow(title, addurl,width,height) {
	//--author：zhoujf---------date：20180718---------for：弹出窗口大小控制问题
	if(width=="100%" || height=="100%"){
		width = window.top.document.body.offsetWidth;
		height =window.top.document.body.offsetHeight-100;
	}else{
		width = isRealNum(width)?width:1000;
		height = isRealNum(height)?height:500;
		width=parseInt(width);
		height=parseInt(height);
	}
	//--author：zhoujf---------date：20180718---------for：弹出窗口大小控制问题
    //--author：JueYue---------date：20140427---------for：弹出bug修改,设置了zindex()函数
	if(typeof(windowapi) == 'undefined'){
		$.dialog({
			content: 'url:'+addurl,
			lock : true,
			zIndex: getzIndex(),
			width:width,
			height:height,
			title:title,
			opacity : 0.3,
			cache:false,
		    ok: function(){
		    	iframe = this.iframe.contentWindow;
				saveObj();
				return false;
		    },
		    okVal: $.i18n.prop('dialog.submit'),
		    cancelVal: $.i18n.prop('dialog.close'),
		    cancel: true /*为true等价于function(){}*/
		});
	}else{

		/*W.*/$.dialog({//使用W，即为使用顶级页面作为openner，造成打开的次级窗口获取不到关联的主窗口
			content: 'url:'+addurl,
			lock : true,
			width:width,
			zIndex:getzIndex(),
			height:height,
			parent:windowapi,
			title:title,
			opacity : 0.3,
			cache:false,
		    ok: function(){
		    	iframe = this.iframe.contentWindow;
				saveObj();
				return false;
		    },
		    okVal: $.i18n.prop('dialog.submit'),
		    cancelVal: $.i18n.prop('dialog.close'),
		    cancel: true /*为true等价于function(){}*/
		});

	}
    //--author：JueYue---------date：20140427---------for：弹出bug修改,设置了zindex()函数
	
}
 </script>
