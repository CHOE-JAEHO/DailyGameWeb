<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<%@include file="../main/stylepackage.jsp" %>
<link rel="stylesheet" href="/resources/css/Mwindow.css">
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/boardDetail.js"></script>
<script type="text/javascript" src="/resources/js/wreply.js"></script>

<title>${Detail.ti}</title>
</head>

<body>
	
<body>
	
<div id="BDetailMain">
	<form name="boardUD"action="/wboard/boardUpdate" method="get">
		<input type="hidden" id="bno" name="bno" value="${Wdetail.bno }">
		<input type="hidden" id="Lname" name="Lname" value="${Lname }">
	<div id="TCW">	
			
		
	
			<div id="aTitle">
				<h1 > ${Wdetail.ti }</h1>
 				<div id="writeAdate">				
					<div>작성자 : ${Wdetail.name }</div>
					<div>작성일자 : ${Wdetail.regdate }</div>
				</div>	
			</div>
		
			<div id="aContent">
				<div id="Ctext">
				<br>
					${Wdetail.ct }
				</div>
				<div id="Cimg">
					<div class="uploadResult">
							<ul>
		
		
		
							</ul>
					</div>
				</div>
			</div>
			
		
		
	</div>
		<div id="pnud">
		 
			<c:choose>
				<c:when test="${Lname ==Wdetail.name }">
		<!-- if로그인, 글쓴이. -->
			<div id="ud">		
					<div id="update"><input type="submit"  class="Ubbtn" value="수정" onclick="wbtn_click('update')" style="padding-top:1px;"></div>
					 &nbsp;<div id="delete"><input type="submit" class="Ubbtn" value="삭제" onclick="wbtn_click('delete')" style="padding-top:1px;"></div>
			</div>
				</c:when>
				<c:when	test="${Lname !=Wdetail.name }">
				</c:when>
			</c:choose>
			</div>	
	</form>
	
			<!-- 댓글자리. -->
			<div>
			댓글
			<ul id="replies">
				
			</ul>
			</div>			
			
				<c:choose>
			<c:when test="${Lname != null }">
		<textarea id="reply" rows="6" cols="64"></textarea><br>
		<input id="name" type="text" name="name" value="${Lname}" readOnly>
		<button id="replyAdd">댓글작성</button> 
			</c:when>
			<c:when test="${Lname==null }">
				댓글을 쓰시려면 로그인 하세요.	
			</c:when>
		</c:choose>
			
			
			

			<div id="pn">
				<div id="prev"></div>
				<div id="Wlist" onclick="Wlist()">목록</div>
				<div id="next"></div>
			</div>	
			
		


	
	

	
</div>

	
	
	
	
	

</body>
</html>