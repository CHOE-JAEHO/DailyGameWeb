<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/Mwindow.css">
<script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/resources/js/memberLogin.js"></script>
</head>
<body>
<input type="hidden" id="failid" name="failid"value="${failid }">
<input type="hidden" id="failpw" name="failpw"value="${failpw }">

<input type="hidden" id="name" name="name" value="${Lname}">
		<div id="imgpro" style="margin:auto;max-width:100px;max-height:100px;overflow:hidden;
		border-radius:50px; 
		/*radius를 절반을 주면 원을 만들있다*/">
		<img style="width:100%;	height:auto;"src="/resources/images/lion.jpg">
		</div>
	<form name="loginPop"action="memberLogin" method="post">
		<table>
			<tr>
			<td colspan="2"><input type="text" name="id" style="width:280px;height:28px;font-size:16px;" placeholder="아이디"></td>
			</tr>
			<tr>
			<td colspan="2"><input type="password" name="pw" style="width:280px;height:28px;font-size:16px;" placeholder="비밀번호"></td>
			</tr>
			<tr>
			<td colspan="2" style="text-align:center"><input type="submit" value="LOGIN" onclick="loginAndBack()" 
			style="border:none;	background:#dfdfdf;
			width:290px;height:32px;cursor:pointer;">
			</td>
			</tr>
		
		</table>	
	</form>


</body>
</html>