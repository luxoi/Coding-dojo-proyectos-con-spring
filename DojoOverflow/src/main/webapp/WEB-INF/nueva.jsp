<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dojo overflow</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
	<body>
		<div class="container">
			<h1>Nueva pregunta</h1>
			<form:form action="/crear" method="POST" modelAttribute="pregunta">
				<div>
					<form:label path="contenido">Pregunta</form:label>
					<form:input path="contenido" class="form-control"/>
					<form:errors path="contenido"></form:errors>
				</div>
				<div>
					<label>Etiquetas</label>
					<input type="text" name="textoEtiquetas" class="form-control"/>					
				</div>
				<input type="submit" class="btn btn-success mt-3" value="Guardar" />
			</form:form>
		</div>
	</body>
</html>