<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>u_join.jsp</title>
</head>
<body>
	<h1> Join us! (회원가입) </h1>
	<jsp:include page="../index.jsp"></jsp:include>
	
	<form action="u_joinOK.do" method="post" encType="multipart/form-data">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="userId" placeholder="ID를 입력하세요." value="testID"></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPw" placeholder="비밀번호를 입력하세요." value="testPW"></td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" placeholder="이름을 입력하세요." value="testName"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="userPhone" placeholder="전화번호를 입력하세요" value="testPhonNum"></td>
			</tr>
			<tr>
				<td> 살고 있는 지역의 "시" (ex. 서울시) </td>
				<td><input type="text" name="userAddSi" placeholder="살고 있는 지역의 '시'를 입력하세요" value="test서울시"></td>
			</tr>
			<tr>
				<td> 살고 있는 지역의 "구" (ex. 금천구) </td>
				<td><input type="text" name="userAddGu" placeholder="살고 있는 지역의 '구'를 입력하세요" value="test금천구"></td>
			</tr>
			<tr>
				<td> 살고 있는 지역의 "동" (ex. 북가좌동) </td>
				<td><input type="text" name="userAddDong" placeholder="살고 있는 지역의 '동'을 입력하세요" value="test북가좌동"></td>
			</tr>
			<tr>
				<td> 살고 있는 지역에 대해 자세히 입력해주세요. (ex. ) </td>
				<td><input type="text" name="userAddDetail" placeholder="살고 있는 지역에 대해 자세히 입력해주세요." value="testDetail"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="userBirth" placeholder="생년월일을 입력하세요" value="testBday"></td>
			</tr>
			<tr>
				<td>현재 나이를 입력해주세요.</td>
				<td><input type="number" name="userAge" placeholder="나이" value="100"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="userNick" placeholder="닉네임을 입력하세요" value="test조글렛"></td>
			</tr>
			
			
			<tr>
				<td></td>
				<td><input type="submit" value="OK"></td>
			</tr>
		</table>
		
	</form>
	
</body>
</html>