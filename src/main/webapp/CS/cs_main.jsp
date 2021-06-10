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
<form action="csAnswer.do">
</form>
	<c:forEach var="vo" items="${list}">
			
			<tr><input type="button" value="${vo.csQuestion}"></tr>
			
		


	</c:forEach>

</body>
</html>