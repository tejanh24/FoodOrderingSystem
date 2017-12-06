<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SLURP</title>
</head>
<body>
	<center>
		<sf:form method="post" action="saveHotel" commandName="hotels">
			<table>
				<tr>
					<td>Hotel Name :
					<td><sf:input type="text" path="hotelName" />
					<td><sf:errors path="hotelName"></sf:errors>
				<tr>
					<td>Street :
					<td><sf:input path="streetName" type="text" />
					<td><sf:errors path="streetName"></sf:errors>
				<tr>
					<td>City :
					<td><sf:input path="city" type="text" />
					<td><sf:errors path="city"></sf:errors>
				<tr>
					<td>State :
					<td><sf:input path="state" type="text" />
					<td><sf:errors path="state"></sf:errors>
				<tr>
					<td>GST Number :
					<td><sf:input path="gstNumber" type="text" />
					<td><sf:errors path="gstNumber"></sf:errors>
				<tr>
					<td>
					<td align="center"><input type="submit" value="Add Hotel" />
			</table>
		</sf:form>
	</center>
</body>
</html>