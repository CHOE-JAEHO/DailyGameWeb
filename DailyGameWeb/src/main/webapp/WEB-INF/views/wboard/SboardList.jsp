<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/Mwindow.css">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/resources/js/iframe.js"></script>
</head>
<body>
<h1 id="boardList">자유게시판</h1>

	<table id="BLT" >
	<tr>
	<td class="bno">NO</td><td class="ti">TITLE</td><td class="name">NAME</td><td class="date">DATE</td>
	</tr>

	<c:forEach items="${List}" var="List">
	<tr>
	<input type="hidden" value="${List.bno}">
	<td>${List.bno }</td><td class="ti"><a href="#" onclick="DfromM('${List.bno}')">${List.ti }</a></td><td>${List.name }</td><td>${List.regdate }</td>
	</tr>
	
	</c:forEach>
	<tr>
	<td colspan="4" style="text-align:right;" onclick="moreBoard()">+더보기</td>
	</tr>
	</table>
	
</body>
</html>