<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../main/stylepackage.jsp" %>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/resources/js/file.js"></script>
<link rel="stylesheet" href="/resources/css/Mwindow.css">
<title>글쓰기</title>
</head>
<body style="min-height:1000px;">
	
	<div id="WBmain">
	<h1 id="WBtitle">자유게시판</h1>
	<form role="boardwrite" method="post" enctype="multipart/form-data">
	
	<table id="WBtable">
		<tr>
		<td class="WBTD1">제목</td><td><input id="BWti"  type="text" name="ti" placeholder="제목을 입력해주세요"></td>
		</tr>
		<tr>
		<td class="WBTD1">작성자</td><td><input type="text" name="name" value="${Lname }" readOnly></td>
		</tr>
		<tr>
		<td class="WBTD1">내용</td><td><textarea id="BWct" name="ct" style="width:640px; height:320px;resize: vertical; font-size:18px;" ></textarea></td>
		</tr>
 		<tr>
		<td class="WBTD1">파일업로드</td><td>&nbsp <input type="file" name="uploadFile" multiple></td></tr>
		<tr>
		<td colspan="2" class="WBTD2"><input class="BWbtn" type="submit" value="글쓰기"> <a onclick="back()"><input class="BWbtn" id="back" type="button" value="취소" ></a></td>
				
		</tr>
	
	</table>
	</form>
	</div>

<div class="uploadResult">
<ul>
</ul>
</div>	




</body>
</html>