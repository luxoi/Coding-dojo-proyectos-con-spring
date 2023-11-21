<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear nuevo estudiante</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
	<body>
		<div>
			<h1>New Student</h1>
		</div>
		<form:form action="/crear/estudiante" method="POST" modelAttribute="estudiante">
		<div>
			<form:label path="name">First name:</form:label>
			<form:input path="name"/>
			<form:errors path="name"></form:errors>
		
		</div>
		<div>
			<form:label path="lastname">Lastname:</form:label>
			<form:input path="lastname"/>
			<form:errors path="lastname"></form:errors>
		
		</div>	
		<div>
			<form:label path="age">age:</form:label>
			<form:input path="age"/>
			<form:errors path="age"></form:errors>
		
		</div>	
		<input type="submit" value="Guardar estudiante" class="btn btn-success">		
		</form:form>
		
	
	</body>
</html>