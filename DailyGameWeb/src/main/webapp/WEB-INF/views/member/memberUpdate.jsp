<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberUpdate</title>
<%@include file="../main/stylepackage.jsp" %>
<link rel="stylesheet" href="/resources/css/Mwindow.css">
</head>
<body>
	
	<form action="/member/memberUpdate" method="post">
	<table id="TmemberDetail">
		<tr style="border-top:1px solid gray">
		<td class="kind">ID</td><td class="MUD"><input class="MU" type="text" name="id" value="${detail.id }" readOnly></td>
		</tr>
		<tr>
		<td class="kind">NICKNAME</td><td class="MUD"><input class="MU" type="text" name="name" value="${detail.name }"></td>
		</tr>
		<tr>
		<td class="kind" >BIRTH</td><td class="MUD"><input class="MU" type="date" name="birth" value="${detail.birth }"></td>
		</tr>
		<tr>
		<td class="kind">E-MAIL</td><td class="MUD"><input class="MU" type="email" name="email" value="${detail.email }"></td>
		</tr>
		<tr>
		<td class="kind">PHONE</td><td class="MUD"><input class="MU" type="text" name="phone" value="${detail.phone }"></td>
		</tr> 
		<tr>
		<td colspan="2"><input type="submit" value="수정"> <a href="/member/memberDetail?id=${detail.id }"><input type="button" value="취소" ></a></td>
		</tr>
		
	</table>

	</form>
</body>
</html>