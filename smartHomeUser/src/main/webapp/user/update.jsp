<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>User Update</h1>
	
	<form action="" method="post">
		<input type="hidden" name="num" value="${ vo.userNum }">
		<input type="text" name="id" value="${ vo.userId }" placeholder="ID">
		<input type="password" name="pw" value="${ vo.userPw }" placeholder="PW">
		<input type="text" name="name" value="${ vo.userName }" placeholder="Name">
		<input type="tel" name="phone" value="${ vo.userPhone }" placeholder="Phone">
		<input type="text" name="si" value="${ vo.userAddSi }" placeholder="Si">
		<input type="text" name="gu" value="${ vo.userAddGu }" placeholder="Gu">
		<input type="text" name="dong" value="${ vo.userAddDong }" placeholder="Dong">
		<input type="text" name="detail" value="${ vo.serAddDetail }" placeholder="Detail">
		<input type="text" name="nick" value="${ vo.userNick }" placeholder="NickName">
		<input type="text" name="age" value="${ vo.userAge }" placeholder="Age">
		<input type="date" name="birth" value="${ vo.userBirth }" placeholder="Birth">
	</form>
	
</body>
</html>