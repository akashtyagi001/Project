<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
	<h1>LOGIN PAGE</h1>
		<form action="getSignInForm" method="post">
			<table>
				<tr>
					<td>EMPLOYEE Id : </td>
					<td><input type="text" name="userId"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="LOGIN"/></td>
				</tr>
			</table>
		</form>
		
</body>
</html>