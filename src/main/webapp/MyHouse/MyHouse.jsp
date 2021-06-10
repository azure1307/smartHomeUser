<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My House</title>
</head>
<body>
<h1>마이 하우스</h1>
<hr>

	<table border="1">
		<tr>
			<td>NUM</td><td>${vo2.userNum}</td>
		</tr>
		<tr>
			<td>ID</td><td>${vo2.userId}</td>
		</tr>
		<tr>
			<td>PW</td><td>${vo2.userPw}</td>
		</tr>
		<tr>
			<td>이름</td><td>${vo2.userName}</td>
		</tr>
		<tr>
			<td>전화번호</td><td>${vo2.userPhone}</td>
		</tr>
		<tr>
			<td>주소</td><td>${vo2.AddSi} ${vo2.AddGu } ${vo2.AddDong } </td>
		</tr>
		<tr>
			<td></td><td>${vo2.vuserAddDetail}</td>
		</tr>
		<tr>
			<td>생년월일</td><td>${vo2.userBirth }</td>
		</tr>
		<tr>
			<td>나이</td><td>${vo2.userAge}</td>
		</tr>
		<tr>
			<td>닉네임</td><td>${vo2.userNick}</td>
		</tr>		
		<tr>
			<td><a href="u_update.do?id=${vo2.userId}">회원정보수정</a></td>
			<td><a href="u_delete.do?id=${vo2.userId}">회원탈퇴</a></td>
		</tr>
	</table><hr>
<a href="WindowControl.do">창문 제어</a>
<a href="LightContro.do"> 전등 제어</a><hr>
<a href="Board.do">나의 게시글</a>
<a href="Reservation.do">나의 예약</a><hr>
<a href="DisPw.do">일회용 비밀번호 발급</a>
</body>
