<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CS</title>
</head>
<body>
<h1>CS</h1><hr>

	<form action="${pageContext.request.contextPath}/CSanswer.do">
		<c:forEach var="vo" items="${list}">

			<input type="submit" name="CSQuestion" value="${vo.csQuestion }">
			<br>

			<c:if test='${sessionScope.onclick=="yes" }'>
				${vo.csAnswer }
			</c:if>

			<br>

		</c:forEach>
	</form>


</body>
</html>