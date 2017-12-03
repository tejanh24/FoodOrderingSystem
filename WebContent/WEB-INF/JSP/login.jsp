<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SLURP</title>
<sec:authorize access="isAuthenticated()">
	<%
		response.sendRedirect("userHome");
	%>
</sec:authorize>
</head>
<body>
	<center>
		<form action="checkLogin" method="post">
			<table>
				<tr>
					<td>Email:
					<td><input type="text" name="username" />
				<tr>
					<td>Password:
					<td><input type="password" name="password" />
				<tr>
					<td>Remember Me:
					<td><input type="checkbox" name="gurthupetuko" />
				<tr>
					<td><input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<td align="center"><input type="submit" value="Login" />
			</table>
		</form>
	</center>
</body>
</html>