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
		<p>
			Hai, ${user.firstName} ${user.lastName } welcome to <b>SLURP</b>.
		</p>
	</center>
	<sec:authorize access="hasAuthority('user')">
		<div align="center">
			<a href="userDetails">User Profile</a>
		</div>
		<div align="center">
			<a href="hotelsList">List Of Hotels</a>
		</div>
	</sec:authorize>
	<sec:authorize access="hasAuthority('merchant')">
		<div align="center">
			<a href="userDetails">Merchant Profile</a>
		</div>
		<div align="center">
			<a href="merchantHotels">Your Hotels</a>
		</div>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<div align="center">
			<c:url var="logoutUrl" value="/logout" />
			<form action="${logoutUrl}" method="post">
				<input type="submit" value="Logout" /> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</sec:authorize>
</body>
</html>