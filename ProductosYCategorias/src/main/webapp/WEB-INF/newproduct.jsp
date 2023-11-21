<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Producto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
	<form:form method="POST" action="/create/product" modelAttribute="producto">
		<form:label path="name">Nombre</form:label>
		<form:input path="name"/>
		<form:errors path="name" class=""></form:errors>
		
		<form:label path="description">Descripcion</form:label>
		<form:input path="description"/>
		<form:errors path="description" class=""></form:errors>
		
		<form:label path="price">Precio</form:label>
		<form:input path="price"/>
		<form:errors path="price" class=""></form:errors>
		
		<input type="submit" class="btn btn-success" value="Crear nuevo producto">
	</form:form>
</body>
</html>