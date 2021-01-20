<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@include file="../main/stylepackage.jsp" %>
<link rel="stylesheet" href="/resources/css/Mwindow.css">
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<div>
	<input type="hidden" id="dbno" name="dbno" value="">
	<h1 id="boardList">자유게시판</h1>
	<table id="BLT">
	<tr style="background-color:#dfdfdf;border-bottom:1px solid gray;">
	<td class="bno">NO</td><td class="ti">TITLE</td><td class="name">NAME</td><td class="date">DATE</td>
	</tr>

	<c:forEach items="${List}" var="List">
	<tr style="border-bottom:1px solid gray;">
	<td>${List.bno }</td><td class="ti"><a href="/board/boardDetail?bno=${List.bno}">${List.ti }</a></td><td>${List.name }</td><td>${List.regdate }</td>
	</tr>
	
	</c:forEach>
	<tr>
	<td colspan="4" >
<c:if test="${page.prev}"><a href="boardList?pageNum=${page.startPage-1}"> 이전</a> </c:if>

	
<c:forEach var="num" begin="${page.startPage }" end="${page.endPage }">
	<a href="boardList?pageNum=${num}&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}">${num}</a>
</c:forEach>
	 
<c:if test="${page.next}"><a href="boardList?pageNum=${page.endPage+1}"> 다음 </a></c:if>



	</td>
	</tr>
	</table>
</div>


	<div>
	<form action="boardList" method="get">
	<table style="margin-top:10px;">
	<tr>
	<td><select name="type">
		<option value="t">제목</option>
		<option value="c">내용</option>
		<option value="n">작성자</option>
	</select></td>
	
	
	
	<td><input type="text" name="keyword"></td>
	
	<td><input type="submit" value="검색"></td>
	</tr>
	
	</table>
	</form>

	
	
	</div>
	
<c:if test="${Lname!=null }">
		<div style="position:relative;left:84%; top:-10px;">		
		<a href="boardWrite" style="text-align:right"><input id="BWfromL" type="button" value="글쓰기"> </a>
		</div>
	</c:if>	
	

	
	
</body>
</html>