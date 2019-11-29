<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>附件查看</title>
<script type="text/javascript" src="plug-in/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="plug-in/jquery/jquery.media.js"></script>
<script type="text/javascript">
$(function(){
	var url="${swfpath}";
    $("#pdf_page").attr("src",url);  
    $(".pdf").media();  
})
</script>
<style type="text/css" media="screen">  
html,body {  
    height: 100%;  
}  
   
body {  
    margin: 0;  
    padding: 0;  
    overflow: auto;  
}  
   
#flashContent {  
    display: none;  
}  
</style>  
</head>
<body>
	<div class="pdf">
		<iframe id="pdf_page" name="pdf_page"
			style="width: 1500px; height: 640px"> </iframe>
	</div>
</body>
</html>



















