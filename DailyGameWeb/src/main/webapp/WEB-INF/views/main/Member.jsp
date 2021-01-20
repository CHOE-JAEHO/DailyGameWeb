<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="stylepackage.jsp" %>
 <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=5" >
<meta charset="UTF-8">
<title>홈</title>
<link rel="stylesheet" href="/resources/css/Base.css">
<script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/resources/js/iframe.js"></script>
<script>
var Did=sessionStorage.getItem("InfoID");
$(document).ready(function(){	
	if(Did){

		$("#Cframe").attr('src',"http://localhost:8080/member/memberDetail?id="+Did)
	}
}) 
</script>
</head>
<body>



	<%@include file="top.jsp" %>
	
<div id="wholeContainer">		
	<div class="main">

			<%@include file="main.jsp" %>
		
			<div id="GframeBox">
				<iframe id="Cframe" src="http://localhost:8080/member/gomemberJoin" width="1280px"  height="100%"  frameborder="0" scrolling="no" marginwidth="0" margin-height="0" allowtransparency="true" allowfullscreen onLoad="setIFrameHeight(this)">
				</iframe>
			</div>
	
	</div>

</div>
 	 		<%@include file="footer.jsp" %>
</body>
</html>