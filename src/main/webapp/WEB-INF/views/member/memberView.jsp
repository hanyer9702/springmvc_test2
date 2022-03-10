<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>


<%-- <c:out value="${rt.ifcdSeq}"/> | <c:out value="${rt.ifcdName}"/> | <c:out value="${rt.ifcdDelNy}"/> <br>

<a href="/infra/code/codeForm2?ifcdSeq=<c:out value="${rt.ifcdSeq}"/>">수정</a> --%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="uTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>yerin's html projects</title>
<style type="text/css">
 	table, th, td {
 		border: 1px solid black;
 		border-collapse: collapse;
	 }
	 
	 th, td {
	 	padding: 5px;
	 }
	 textarea {
	    width: 99%;
	    height: 6.25em;
	    resize: none;
  }
</style>
</head>

<body>
	 memberForm.html<br>
	 <form action="" method="post" id="form" name="" enctype="multipart/form-data">
	<table border="1" width="1000px">
		<tr>
			<th>이름</th>
			<td><input type="text" id="name" name="name"></td>
			<th>성별</th>
			<td><input type="radio" id="gender" name="gender" value="m">남성 <input type="radio" id="gender" name="gender" value="w">여성</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" id="id" name="id"></td>
			<th>비밀번호</th>
			<td><input type="password" id="password" name="password"></td>
		</tr>
		<tr>
			<th>생일</th>
			<td><input type="date" id="birth" name="birth"></td>
			<th>국적</th>
			<td><input type="text" id="nation" name="nation"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td colspan="3"><input type="text" id="address" name="address"></td>
		</tr>
		<tr>
			<th>모바일</th>
			<td><select id="hp_com" name="hp_com" >
		 		<option  selected>SKT
		 		<option>KT
		 		<option>LG
		 		<option>알뜰폰
		 	</select>&nbsp;&nbsp;
			<input type="text" id="hp1" name="hp1" size="2"> - <input type="text" id="hp2" name="hp2" size="3"> - <input type="text" id="hp3" name="hp3" size="3"></td>
			<th>모바일 마케팅 수신 동의</th>
			<td><input type="radio" id="agree1" name="agree1" value="y">예 <input type="radio" id="agree1" name="agree1" value="n">아니오</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" id="email" name="email"></td>
			<th>이메일 마케팅 수신 동의</th>
			<td><input type="radio" id="agree2" name="agree2" value="y">예 <input type="radio" id="agree2" name="agree2" value="n">아니오</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" id="p1" name="p1" size="2"> - <input type="text" id="p2" name="p2" size="3"> - <input type="text" id="p3" name="p3" size="3"></td>
			<th>팩스번호</th>
			<td><input type="text" id="fp1" name="fp1" size="2"> - <input type="text" id="fp2" name="fp2" size="3"> - <input type="text" id="fp3" name="fp3" size="3"></td>
		</tr>
		<tr>
			<th>추천인</th>
			<td><input type="text" id="r_name" name="r_name"></td>
			<th>개인정보유효기간 동의</th>
			<td><select id="cu_agree" name="cu_agree" >
			 		<option selected value="y1">1년
			 		<option value="y3">3년
			 		<option value="y5">5년
			 	</select></td>
		</tr>
		<tr>
			<th>비밀번호 문제</th>
			<td colspan="3"><input type="text" id="pass_qu" name="pass_qu"></td>
		</tr>
		<tr>
			<th>비밀번호 답</th>
			<td colspan="3"><input type="text" id="pass_an" name="pass_an"></td>
		</tr>
		<tr>
			<th>sns</th>
			<td><select id="sns" name="sns" >
			 		<option selected value="s1">인스타그램
			 		<option value="s2">페이스북
			 		<option value="s3">트위터
			 	</select></td>
			<th>사진</th>
			<td><input type="file" id="photo" name="photo" accpet=".png, .jpg, .gif"></td>
		</tr>
		<tr>
			<th>홈페이지</th>
			<td><input type="text" id="homepg" name="homepg"></td>
			<th>직업(희망직업)</th>
			<td><input type="text" id="job" name="job"></td>
		</tr>
		<tr>
			<th>결혼여부</th>
			<td><input type="radio" id="marry" name="marry" value="y">기혼 <input type="radio" id="marry" name="marry" value="n">미혼</td>
			<th>결혼기념일</th>
			<td><input type="date" id="ma_day" name="ma_day"></td>
		</tr>
		<tr>
			<th>자녀유무</th>
			<td><input type="radio" id="child" name="child" value="y">유 <input type="radio" id="child" name="child" value="n">무</td>
			<th>좋아하는 색깔</th>
			<td><input type="color" id="color" name="color"></td>
		</tr>
		<tr>
			<th>취미</th>
			<td colspan="3"><input type="checkbox" id="hobby" name="hobby">독서
		 	<input type="checkbox" id="hobby" name="hobby">영화보기
		 	<input type="checkbox" id="hobby" name="hobby">음악감상
		 	<input type="checkbox" id="hobby" name="hobby">등산</td>
		</tr>
	</table>
	<hr>
	<table border="1" width="1000px">
		<tr>
			<th colspan="5">프로젝트 참여</th>
		</tr>
		<tr>
			<th>번호</th>
			<th>프로젝트명</th>
			<th>참여기간</th>
			<th>역할</th>
			<th>발주사</th>
		</tr>
		<tr>
			<th>1</th>
			<td><input type="text" id="pj_name" name="pj_name"></td>
			<td>시작일 : <input type="month" id="pj_month_s" name="pj_month_s"> 종료일 : <input type="month" id="pj_month_l" name="pj_month_l"></td>
			<td><input type="text" id="role" name="role" size="10"></td>
			<td><input type="text" id="company" name="company"></td>
		</tr>
		<tr>
			<th>2</th>
			<td><input type="text" id="pj_name" name="pj_name"></td>
			<td>시작일 : <input type="month" id="pj_month_s" name="pj_month_s"> 종료일 : <input type="month" id="pj_month_l" name="pj_month_l"></td>
			<td><input type="text" id="role" name="role" size="10"></td>
			<td><input type="text" id="company" name="company"></td>
		</tr>
		<tr>
			<th>3</th>
			<td><input type="text" id="pj_name" name="pj_name"></td>
			<td>시작일 : <input type="month" id="pj_month_s" name="pj_month_s"> 종료일 : <input type="month" id="pj_month_l" name="pj_month_l"></td>
			<td><input type="text" id="role" name="role" size="10"></td>
			<td><input type="text" id="company" name="company"></td>
		</tr>
		<tr>
			<th>4</th>
			<td><input type="text" id="pj_name" name="pj_name"></td>
			<td>시작일 : <input type="month" id="pj_month_s" name="pj_month_s"> 종료일 : <input type="month" id="pj_month_l" name="pj_month_l"></td>
			<td><input type="text" id="role" name="role" size="10"></td>
			<td><input type="text" id="company" name="company"></td>
		</tr>
	</table>
	<hr>
	<table border="1" width="650px">
		<tr>
			<th>본인 소개</th>
		</tr>
		<tr>
			<td><textarea></textarea></td>
		</tr>
	</table>
	</form>
	<a href="./memberList.html">목록</a>
</body>
</html>