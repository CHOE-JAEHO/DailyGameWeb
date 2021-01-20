<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세</title>
<link rel="stylesheet" href="/resources/css/Mwindow.css">
<%@include file="../main/stylepackage.jsp" %>
<script type="text/javascript" src="/resources/js/update.js"></script>
</head>	
<body>
<form name=mupdate action="memberUpdate" method="get">
	<table id="TmemberDetail">
		<tr style="border-top:1px solid gray">
		<input type="hidden" name="id" value="${detail.id }">
		<td class="kind">ID</td><td></td><td class="MDC">${detail.id }</td>
		</tr>
		<tr class="TrmemberDetail">
		<td class="kind">NICKNAME</td><td></td><td class="MDC">${detail.name }</td>
		</tr>
		<tr class="TrmemberDetail">
		<td class="kind">GENDER</td><td></td><td class="MDC">${detail.gen }</td>
		</tr>
		<tr class="TrmemberDetail">
		<td class="kind">BIRTH</td><td></td><td class="MDC">${detail.birth }</td>
		</tr>
		<tr class="TrmemberDetail">
		<td class="kind">E-MAIL</td><td></td><td class="MDC">${detail.email }</td>
		</tr>
		<tr class="TrmemberDetail">
		<td class="kind">PHONE</td><td></td><td class="MDC">${detail.phone }</td>
		</tr>
		<tr style="border-bottom:none">
		<td colspan="3"><input class="Mudbtn" id="up" type="submit" value="수정" onclick="btn_click('update')">
		 <input class="Mudbtn" id="del" type="submit" value="탈퇴" onclick="btn_click('delete')"></td>
		</tr>
	</table>
	</form>
<!-- <a href="/member/memberList">목록으로</a> -->
	

</body>
</html>