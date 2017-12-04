<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/static/js/reg.js">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SLURP</title>
</head>
<body>
	<center>
		<sf:form method="post" action="registerUser" commandName="user"
			onsubmit="checkPass()">
			<table>
				<tr>
					<td>First Name:
					<td><sf:input type="text" path="firstName" />
					<td><sf:errors path="firstName"></sf:errors>
				<tr>
					<td>Last Name:
					<td><sf:input type="text" path="lastName" />
					<td><sf:errors path="lastName"></sf:errors>
				<tr>
					<td>Email:
					<td><sf:input type="text" path="username" />
					<td><sf:errors path="username"></sf:errors>
				<tr>
					<td>Password:
					<td><sf:input type="password" path="password" id="password" />
					<td><sf:errors path="password"></sf:errors>
				<tr>
					<td>Confirm Password:
					<td><sf:input type="password" path="confrmPass"
							id="confrmPass" />
					<td><sf:errors path="confrmPass"></sf:errors>
				<tr>
					<td><c:choose>
							<c:when test="${param.merchant != null}">
								<sf:input type="hidden" name="type" value="merchant" path="role" />
							</c:when>
							<c:otherwise>
								<sf:input type="hidden" name="type" value="user" path="role" />
							</c:otherwise>
						</c:choose>
				<tr>
					<td><div id="errorDiv"></div>
				<tr>
					<td>
					<td align="center"><input type="submit" value="Register" />
			</table>
		</sf:form>
	</center>
</body>
</html>