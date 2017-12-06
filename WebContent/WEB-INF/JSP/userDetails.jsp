<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SLURP</title>
</head>
<body>

	<center>
		<table>
			<tr>
				<td><label>First Name : </label>
				<td><label>${user.firstName }</label>
			<tr>
				<td><label>Last Name : </label>
				<td><label>${user.lastName }</label>
			<tr>
				<td><label>Email-ID :</label>
				<td><label>${user.username }</label>
		</table>
		<div align="center">
			<sec:authorize access="hasAuthority('user')">
				<a href="addUserAddress">Add Address</a>
			</sec:authorize>
		</div>
		<sec:authorize access="isAuthenticated()">
			<div align="center">
				<c:url var="logoutUrl" value="/logout" />
				<form action="${logoutUrl}" method="post">
					<input type="submit" value="Logout" /> <input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</sec:authorize>
	</center>

</body>
</html>