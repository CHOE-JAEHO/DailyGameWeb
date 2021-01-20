<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@include file="../main/stylepackage.jsp" %>
<script type="text/javascript" src="/resources/js/memberJoin.js"></script>
<link rel="stylesheet" href="/resources/css/Mwindow.css">

</head>
<body>
	<form id="joinFrom"action="/member/memberJoin" method="post">
		<table id="MJtable">
			<tr>
			<td id="dotE" colspan="3" style="color:red;vertical-align:bottom;text-align:left;font-size:8px;">
			 * 는 필수입력조건입니다.</td><td></td><td></td><td></td>
		 	</tr>
		 	<tr>
		 	<td class="dot">*</td><td>아이디</td><td><input type="text" id="id"  name="id" maxlength="12" oninput="AN(this)">
		 	 <br id="idL"><span class="idOp">아이디는 5~12자리 영문,숫자만 입력 가능합니다.</span>
		 	 </td><td><input class="cbtn"  type="button" value="중복확인" onclick="idC()"></td>
		 	
		 	</tr>
		 	<tr>
		 	<td class="dot">*</td><td>비밀번호</td><td><input type="password" id="pw" name="pw">
		 	<br id="pwL">
		 	<span class="pwOp" style="text-align:left">5~12자리의 영문,숫자만 가능합니다.</span>
		 	</td>
		 	<td></td>
		 	</tr>
		 	<tr>
		 	<td class="dot"></td><td>비밀번호<br>확인</td><td style="vertical-align:top;">
		 	<input type="password" id="pwc" name="pwc"><br id="pwcL">
		 	<span class="pwcOp">  </span></td><td></td>
		 	</tr>
		 	<tr>
		 	<td class="dot">*</td><td>별명</td><td><input type="text" id="name" name="name" maxlength="10"><br>
		 		<span style="text-align:left">10자 이내</span></td>
		 	<td><input class="cbtn" type="button" value="중복확인" onclick="NickC()"></td>
		 	</tr>
		 	<tr>
		 	<td class="dot"></td><td>성별</td><td><input type="radio" name="gen" value="남자">남자 
		 						<input type="radio" name="gen" value="여자">여자</td><td></td>
		 	</tr>
		 	<tr>
		 	<td class="dot"></td><td>생일</td><td><input type="date" name="birth"></td><td></td>
		 	</tr>
		 	<tr>
		 	<td class="dot"></td><td>E-MAIL</td><td><input type="email" name="email"></td><td></td>
		 	</tr>
		 	<tr>
		 	<td class="dot"></td><td>전화번호</td><td>
		 	<select class="phoneBox" id="ph1" name="phone1">
		 		<option value="010">010</option>
		 		<option value="010">011</option>
		 		<option value="010">016</option>
		 	</select>
		 	-<input class="phoneBox" id="ph2" type="text"  name="phone" maxlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
		 	-<input class="phoneBox" id="ph3" type="text"  name="phone" maxlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></td><td></td>
		 	</tr>
		 	<tr>
		 	<td></td><td colspan="3" style="text-align:center"><input type="submit" id="Join" value="가입">
		 	 </td>
		 	</tr>
		</table>
	
	</form>
</body>
</html>