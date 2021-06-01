<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>u_login.jsp</title>
</head>
<body>
	<h1>로그인에 ${sessionScope.login} 했습니다!</h1>
	<c:if test='${sessionScope.login != "successed"}'>

		<form action="u_loginOK.do" method="post">
			<table border="1">
				<tr>
					<td>ID</td>
					<td><input type="text" name="userId" value="testID"></td>
				</tr>

				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="userPw" value="testPW"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="login"></td>
				</tr>
			</table>
		</form>
	</c:if>
	
</body>
</html>