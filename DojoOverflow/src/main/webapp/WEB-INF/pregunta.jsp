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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
	<body>
		<div class="container">
			<h1>${pregunta.contenido}</h1>
			<div>
				<h4>Etiquetas:</h4>
				<c:forEach items="${pregunta.etiquetas}" var="etiqueta">
					 <span class="badge bg-secondary">${etiqueta.tema}</span>
				</c:forEach>
			</div>
			<div class="row">
				<div class="col-6">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Respuesta</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pregunta.respuestas}" var="respuesta">
								<tr>
									<td>${respuesta.texto}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-6">
					<form:form method="POST" action="/respuesta" modelAttribute="respuesta">
						<form:label path="texto">Ingresa tu respuesta</form:label>
						<form:textarea class="form-control" path="texto"/>
						<form:errors path="texto" class="text-danger"></form:errors>
						<form:hidden path="pregunta" value="${pregunta.id}" />
						<input type="submit" class="btn btn-success" value="Guardar respuesta" />
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>