<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver´s License</title>
</head>
<body>
	<h1>New person</h1>
	<form:form action="/person/create" method="POST" modelAttribute="person">
		<div>
			<form:label path="name">name:</form:label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</div>
		<div>
			<form:label path="lastName">Last name:</form:label>
			<form:input path="lastName"/>
			<form:errors path="lastName"/>
		</div>
		<input type="submit" value="Save">
	
	</form:form>
</body>
</html>