<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../main/stylepackage.jsp" %>
<script type="text/javascript" src="/resources/js/WBdelete.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form role="WBDelete" action="/wboard/boardDelete" method="post">
		<table style="margin:auto;margin-top:200px;background:#d4d4d4;padding:4px 4px;">
		<input type="hidden"name="bno" value="${Wdetail.bno}">
		<input type="hidden" id="Lpw" name="Lpw" value="${Lpw }">
			<tr>
			<td colspan="2">삭제를위해 비밀번호를 입력하십시오.</td>
			</tr>
			<tr>
			<td>PASSWORD</td><td><input type="password" id="pw" name="pw"></td>
			</tr>
			<tr>
			<td colspan="2" style="text-align:center"><input type="submit" value="삭제">
			 <a> <input type="button" value="취소"></a></td>
			</tr>
		</table>
	
	</form>

</body>
</html>