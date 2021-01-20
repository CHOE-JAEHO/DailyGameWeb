<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/Mwindow.css">
<script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/resources/js/Mdelete.js"></script>
</head>
<body>


 <table id="TMdelete" style="margin:auto;margin-top:200px;background:#d4d4d4;padding:4px 4px;" >
 	<tr>
 	<td colspan='2'>비밀번호를 입력해서 본인확인 해주십시오.</td>
 	</tr>
 	<tr>
 	<input type="hidden" name="id" id="id" value="${detail.id }">
 	<td>PASSWORD</td><td><input id="pw" type="password" name="pw"></td>
 	</tr>
 	<tr>
 	<td colspan="2" style="text-align:center;"><button id="Mdelete">탈퇴</button> 
 	<a href="/member/memberDetail?id=${detail.id }"><input type="button" value="취소"></a></td>
 	</tr>
 </table>
</body>
</html>