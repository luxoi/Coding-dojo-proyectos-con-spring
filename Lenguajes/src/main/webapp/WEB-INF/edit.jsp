<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit language</h1>
 	<form:form action="/update/${language.id}" method="POST" modelAttribute="language">
 	<input type="hidden" name="_method" value="put">
 		<div>
			<form:label path="name">Language name</form:label> 		
 			<form:input path="name"/>
 			<form:errors path="name"></form:errors>
 		</div>
 		<div>
			<form:label path="creator">Creador</form:label> 		
 			<form:input path="creator"/>
 			<form:errors path="creator"></form:errors>
 		</div>
 		<div>
			<form:label path="currentVersion">Current version</form:label> 		
 			<form:input path="currentVersion"/>
 			<form:errors path="currentVersion"></form:errors>
 		</div>
 		<input type="submit" value="Create new language">
 	</form:form>
</body>
</html>