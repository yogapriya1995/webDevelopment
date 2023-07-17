<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1> Login Form</h1>
		<form  id="loginForm"  action="<%=request.getContextPath()%>/login" method="post">
			</fieldset>
			<table style="with: 100%">
				<tr>
					<td>UserId     : </td>
					<td><input type="text" id ="username" name="username" required/></td>
				</tr>
				<tr>
					<td>Password : </td>
					
					<td><input type="password" id="password" name="password"  required/></td>
				</tr>

			</table>
			<br>
			<input STYLE="background-color:#a9a9a9;" type="submit" value="Login" />
			</fieldset>
		</form>
	</div>
</body>
</html>