<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
	<div class="container">
			<div class="row">
			<h2>Editar evento</h2>
			<form:form action="/editar" method="PUT" modelAttribute="editarEvento">
			<input type="hidden" name="_method" value="PUT" />
				<div>
					<form:label path="nombre">Nombre:</form:label>
					<form:input path="nombre" class="form-control"/>
					<form:errors path="nombre" class="text-danger"></form:errors>
				</div>
					<div>
					<form:label path="fecha">Fecha:</form:label>
					<form:input type="date" path="fecha" class="form-control"/>
					<form:errors path="fecha" class="text-danger"></form:errors>
				</div>
					<div>
					<form:label path="ubicacion">Ubicacion:</form:label>
					<form:input  path="ubicacion" class="form-control"/>
					<form:errors path="ubicacion" class="text-danger"></form:errors>
				</div>
				<div>
					<form:label path="estado">Estado</form:label>
					<form:select path="estado" class="form-select">
						<c:forEach items="${estados}" var="estado">
						 <form:option value="${estado}">${estado}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<form:hidden value="${usuarioEnSesion.id}" path="host"/>
				<form:hidden value="${evento.id}" path="id" />
				
				<input type="submit" value="Editar evento" class="btn btn-success">
			</form:form>
		</div>
	</div>
</body>
</html>