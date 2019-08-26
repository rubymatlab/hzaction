<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>通用Excel导入${controller_name}</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
	<t:formvalid formid="formobj" layout="div" dialog="true"
		beforeSubmit="upload">
		<fieldset class="step">
			<div class="form">
				<t:upload name="fiels" dialog="false"
					onUploadSuccess="handleSuccess" callback="uploadCallback" width="120"
					buttonText="选择要导入的excel文件"
					uploader="vwBusPoApplyController.do?importContDetailExcel"
					extend="*.xls;*.xlsx" id="file_upload" formData="documentTitle"></t:upload>
			</div>
			<div class="form" id="filediv" style="height: 50px"></div>
		</fieldset>
	</t:formvalid>
	<script type="text/javascript">
		function handleSuccess(row, files, info) {
			console.log("handleSuccess")
			frameElement.api.config.button[0].uploaded(row)
			frameElement.api.close();
		}
		function uploadCallback(){
			console.log("Callback")
   
            
    }
	</script>
</body>
</html>
