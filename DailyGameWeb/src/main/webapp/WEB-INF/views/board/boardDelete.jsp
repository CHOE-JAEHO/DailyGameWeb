<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../main/stylepackage.jsp" %>
<script type="text/javascript" src="/resources/js/Bdelete.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div style="height:400px;">
	<form role="BDelete" action="/board/boardDelete" method="post">
		<table style="margin:auto;margin-top:200px;background:#d4d4d4;padding:4px 4px;">
		<input type="hidden"name="bno" value="${Detail.bno }">
		<input type="hidden" id="Lpw" name="Lpw" value="${Lpw }">
			<tr>
			<td colspan="2">삭제를 위해 비밀번호를 입력하십시오.</td>
			</tr>
			<tr>
			<td>PASSWORD</td><td><input type="password" id="pw"name="pw"></td>
			
			</tr>
			<tr>
			
			<td colspan="2" style="text-align:center"><input type="submit" value="삭제">
			 <a href='/board/boardDetail?bno=${Detail.bno }'> <input type="button" value="취소"></a></td>
			</tr>
		</table>
	
	</form>
	</div>
</body>
</html>