<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta charset="UTF-8">
<title>두더지를 잡아라</title>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="/resources/js/jquery.innerfade.js"></script>
<script type="text/javascript" src="/resources/js/MoleMain.js" charset="utf-8"></script>
<link rel="stylesheet" href="/resources/css/moleMain.css" >
</head>
<body>
<div id="board">
<input type="hidden" id="id" name="id" value="${ Lid}">
<input type="hidden" id="name" name="name" value="${Lname }">
  <div id="Gamebox">
	<div id="GameBoard">
	
	</div>
	
	<div id="start"><button id="startbtn">start</button></div>
	</div>
<div id=Mright>
	<div class="info">
		<div id="Score">
			<table style="border-collapse:collapse">
			<tr id="Rank1">
			<td>1st: </td><td id="Rank1Name"></td><td id="Rank1Score"></td>
			</tr>
			<c:forEach items="${RList}" var="List">
			<tr class="rank">
			<td>${List.ranking }</td><td>${List.name }</td><td>${List.mscore }</td>
			</tr>
			</c:forEach>
		<c:choose>
			<c:when test="${Lname !=null}">
			<tr id="MyScore">
			<td>${Lname}</td><td colspan="2" id="NowS" >0</td>
			</tr>
			</c:when>
			<c:when test="${Lname ==null}">
			<tr id="MyScore">
			<td>Guest</td><td colspan="2" id="NowS" >0</td>
			</tr>
			</c:when>
			</c:choose>
			</table>
			</div>
		
	<div class="ActionMole">
		<div class="AMoleHole">
		
			<img id="mole13" src="/resources/images/mole.png" >
		
		</div>
	</div>
</div>


</div>
</div>
</body>
</html>