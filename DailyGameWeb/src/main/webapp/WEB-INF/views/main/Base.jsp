<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=5" >
<meta charset="UTF-8">
<title>홈</title>
<%@include file="stylepackage.jsp" %>
<link rel="stylesheet" href="/resources/css/Base.css">
<script type="text/javascript" src="/resources/js/iframe.js"></script>
<script type="text/javascript">
</script>

</head>
<body>

		<%@include file="top.jsp" %>
	
<div id="wholeContainer">	
<div class="main">
	

			<%@include file="main.jsp" %>
			
			<div id="innerRight">
		
					<div id="SboardBox">
						<iframe id="Bframe" src="http://localhost:8080/board/SboardList" width="1280px" height="100%"  frameborder="0" scrolling="no" marginwidth="0" margin-height="0" allowtransparency="true" allowfullscreen onLoad="setIFrameHeight(this)">
						</iframe>
					</div>
			
		
			
					<div id="GframeBox">
						<iframe id="Gframe" src="http://localhost:8080/game/gameList" width="1280px"  height="100%"  frameborder="0" scrolling="no" marginwidth="0" margin-height="0" allowtransparency="true" allowfullscreen onLoad="setIFrameHeight(this)">
						</iframe>
					</div>		
		
			</div>
	
	
</div><!--메인끝-->

</div>
	<%@include file="footer.jsp" %>

</body>
</html>