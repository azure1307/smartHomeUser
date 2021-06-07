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
<table>
			<tr>
				<td></td><td>NUM${vo2.CSNum}</td>
			</tr>
			<tr>
				<td>Q</td>
				<td>${vo2.csQuestion}</td>
			</tr>
			<tr>
				<td>A</td>
				<td>${vo2.csAnswer}</td>

			</tr>
</table>			
</body>
</html>