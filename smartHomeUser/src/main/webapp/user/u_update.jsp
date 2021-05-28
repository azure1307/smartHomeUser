<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> u_update.jsp </title>
</head>
<body>
	<form action="u_updateOK.do" method="post">
		<table border="1">
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPw" placeholder="비밀번호를 입력해주세요." value="testPw55"></td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" placeholder="이름을 입력해주세요." value="testName김"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="userPhone" placeholder="전화번호를 입력해주세요." value="test0105555"></td>
			</tr>
			<tr>
				<td>현재 살고 있는 지역의 '시' (ex. 서울시)</td>
				<td><input type="text" name="userAddSi" placeholder="'시'를 입력해주세요." value="test수원시"></td>
			</tr>
			<tr>
				<td>현재 살고 있는 지역의 '구' (ex. 강남구)</td>
				<td><input type="text" name="userAddGu" placeholder="'구'를 입력해주세요." value="test강남구"></td>
			</tr>
			<tr>
				<td>현재 살고 있는 지역의 '동' (ex. 강남구)</td>
				<td><input type="text" name="userAddDong" placeholder="'동'을 입력해주세요." value="test정자동"></td>
			</tr>
			<tr>
				<td>현재 살고 있는 지역의 자세한 정보</td>
				<td><input type="text" name="userAddDetail" placeholder="지역의 자세한 정보를 입력해주세요." value="test강남구천천동힐스테이트"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="userBirth" placeholder="생일을 입력해주세요." value="test0405"></td>
			</tr>
			
			<tr>
				<td>나이</td>
				<td><input type="number" name="userAge" placeholder="나이를 입력해주세요." value="test50"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="userNick" placeholder="닉네임을 입력해주세요." value="test유나킴"></td>
			</tr>
			<tr>
				<td>데시벨</td>
				<td><input type="number" name="decibel" placeholder="데시벨을 입력해주세요." value="45데시벨"></td>
			</tr>
			<tr>
				<td>사용자 상태</td>
				<td><input type="number" name="userState" placeholder="사용자 상태를 입력해주세요." value="True/False"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="OK"></td>
			</tr>
		</table>	
	</form>
</body>
</html>