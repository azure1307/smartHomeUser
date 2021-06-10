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
	
	<form action="u_updateOK.do" method="post">
		<table>
			<tr>
				<td></td>
				<td><input type="hidden" name="userNum" value="${ vo2.userNum }"></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="userId" value="${ vo2.userId }" placeholder="ID"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="userPw" value="${ vo2.userPw }" placeholder="PW"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="userName" value="${ vo2.userName }" placeholder="Name"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="tel" name="userPhone" value="${ vo2.userPhone }" placeholder="Phone"></td>
			</tr>
			<tr>
				<td>시</td>
				<td><input type="text" name="userAddSi" value="${ vo2.userAddSi }" placeholder="Si"></td>
			</tr>
			<tr>
				<td>구</td>
				<td><input type="text" name="userAddGu" value="${ vo2.userAddGu }" placeholder="Gu"></td>
			</tr>
			<tr>
				<td>동</td>
				<td><input type="text" name="userAddDong" value="${ vo2.userAddDong }" placeholder="Dong"></td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td><input type="text" name="userAddDetail" value="${ vo2.userAddDetail }" placeholder="Detail"></td>
			</tr>
			<tr>
				<td>NickName</td>
				<td><input type="text" name="userNick" value="${ vo2.userNick }" placeholder="NickName"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="userAge" value="${ vo2.userAge }" placeholder="Age"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="userBirth" value="${ vo2.userBirth }" placeholder="Birth"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="save"></td>				
			</tr>
		</table>
	</form>
	
	<script>
		var resel = ${ sessionScope.uresult }
		console.log(resel);
		if (resel == 0){
			alert('Failed!');
		}else if(resel == 1){
			alert('Success!');
		}
	</script>
</body>
</html>