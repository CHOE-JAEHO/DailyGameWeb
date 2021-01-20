<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js"></script>

<link rel="stylesheet" href="/resources/css/Mwindow.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="WBmain">
	<h1 id="WBtitle">자유게시판</h1>
	<form action="/board/boardUpdate" method="post">
	<input type="hidden" name="bno" value="${Detail.bno }">
	<table id="WBtable">
		<tr>
		<td class="WBTD1">제목</td><td><input id="BWti"  type="text" name="ti" value='${Detail.ti }'></td>
		</tr>
		<tr>
		<td class="WBTD1">작성자</td><td>${Detail.name }</td>
		<tr>
		<td class="WBTD1">내용</td><td><textarea id="BWct" name="ct" style="width:640px; height:320px;resize: vertical; font-size:18px;" >${Detail.ct }</textarea></td>
		</tr>
		<tr>
		<td colspan="2" class="WBTD2"><input class="BWbtn" type="submit" value="수정"> <a href='/board/boardDetail?bno=${Detail.bno }'><input class="BWbtn" id="back" type="button" value="취소" ></a></td>
				
		</tr>
	
	</table>
	</form>
	</div>
		
	

</body>
</html>