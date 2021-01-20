<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/Mwindow.css">
</head>
<body>
<div id="window">
<table border="1">
	<tr>
	<td>ID</td><td>NICKNAME</td><td>gen</td><td>E-MAIL</td>
	</tr>
	<c:forEach items="${list}" var="Mlist">
	<tr>
	<td><a href="/member/memberDetail?id=${Mlist.id }">${Mlist.id }</a></td><td>${Mlist.name }</td><td>${Mlist.gen}</td><td>${Mlist.email}</td>
	</tr>
	</c:forEach>

</table>
</div>
</body>
</html>