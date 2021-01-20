<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside>

<div id="profil">
	<div id="innerpro">
		<div id="imgproM"><img src="/resources/images/develop.png"></div>
		<div id="textpro"><p>반갑습니다.<br> 주인장 아겔입니다.</p>${bno}</div>	
	</div>
</div>
<div id="loginfo">
 <c:set var="Lname" value="${Lname}"/>
 <c:choose>
 
		<c:when test="${Lname != null }">
		
<div id="thumnail">
<c:choose>
	<c:when test="${Lgen =='남자' }">	
	<div id="imgpro"><img src="/resources/images/proWhite.png"></div>
	</c:when>
	<c:when test="${Lgen =='여자' }">
	<div id="imgpro"><img src="/resources/images/proBlack.png"></div>
	
	</c:when>
	<c:when test="${Lgen !='여자'||Lgen !='남자' }">
	<div id="imgpro"><img src="/resources/images/proColor.png"></div>
	
	</c:when>
	</c:choose>
 	<h4 id="welcome">${Lname}님 환영합니다.</h4>
 </div>
 <div id="login">
	<table class=login>
		<tr>
		<input type="hidden" id="id" value="${Lid}">
		<td><input id="loginbtn"type="button" value="내 정보" onclick="goUrl('Detail')">
		</tr>
		<tr>
		<td><a href="/member/memberLogout">로그아웃</a></td>
		</tr>
	</table>
 </div>	
	</c:when>
	
	<c:when test="${Lname == null }">
	 <div id="thumnail">
	<div id="imgpro"><img src="/resources/images/proColor.png"></div>
 	<h3 id="welcome">Guest님 환영합니다.</h3>
 	</div>
 <div id="login">

	<table>
		<tr>
		<td colspan="3"><input id="loginbtn" type="button" value="Login" onclick="login()"></td>
		</tr>
		<tr>
		<td colspan="3"><a href="#" onclick="goUrl('join')" >회원가입</a></td>
		</tr>
	</table>

 </div>	
	</c:when>
 
 </c:choose>
</div>

<div id="menu">

</div>

</aside>
