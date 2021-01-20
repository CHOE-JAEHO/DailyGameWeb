<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@include file="stylepackage.jsp" %>
 <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=5" >
<meta charset="UTF-8">
<title>게시판메인</title>
<link rel="stylesheet" href="/resources/css/Base.css">
<script type="text/javascript" src="/resources/js/iframe.js"></script>
<script type="text/javascript">
var dbno=sessionStorage.getItem("dbno");
	$(document).ready(function(){	
		if(dbno!=null){
			$("#Cframe").attr('src','/board/boardDetail?bno='+dbno)
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
						<iframe id="Cframe" src="http://localhost:8080/board/boardList" width="1280px"  height="100%"  frameborder="0" scrolling="no" marginwidth="0" margin-height="0" allowtransparency="true" allowfullscreen onLoad="setIFrameHeight(this)" >
						</iframe>
					</div>
			
			</div>
		</div>


 	 
 	 		<%@include file="footer.jsp" %>
</body>
</html>