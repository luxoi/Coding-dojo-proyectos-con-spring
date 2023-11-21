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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<nav class="d-flex justify-content-between align-items-center">
			<h1>!bIENVENIDO ${usuarioEnSesion.nombre}¡</h1>
			<a href="/logout" class="btn btn-danger">Cerrar Sesion</a>
		</nav>
		<div class="row">
				<h2>Eventos en mi estado</h2>
				<table class="table table-hover table-striped">
					<thead>
					<tr>
						<th>Evento</th>
						<th>Fecha</th>	
						<th>Ubicacion</th>
						<th>Estado</th>
						<th>Host</th>
						<th>Acciones</th>		
					</tr>			
					</thead>
					<tbody>
						<c:forEach items="${eventosMiEstado}" var="evento">
							<tr>
								<td><a href="/evento/${evento.id}">${evento.nombre}</a></td>
								<td>${evento.fecha}</td>
								<td>${evento.ubicacion}</td>
								<td>${evento.estado}</td>
								<td>${evento.host.nombre}</td>
								<td>
									<c:if test="${evento.host.id == usuario.id}">
										<a href="/editar/${evento.id}" class="btn btn-warning">Editar</a>
										<form action="/borrar/${evento.id}" method="post">
											<input type="hidden" name="_method" value="DELETE"/>
											<input type="submit" value="Borrar" class="btn btn-danger"/>
										</form>
																				
									</c:if>		
									<c:if test="${evento.host.id != usuario.id}">
										<c:choose>
											<c:when test="${evento.asistentes.contains(usuario)}">
												<span>Voy a ir al evento</span>
												<a href="/quitar/${evento.id}" class="btn btn-danger">Cancelar asistencia</a>
											</c:when>
											<c:otherwise>
												<a href="/unir/${evento.id}" class="btn btn-primary">Asistir al evento</a>
											</c:otherwise>
										</c:choose>
									</c:if>						
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
		<div class="row">
				<h2>Eventos otro estado</h2>
				<table class="table table-hover table-striped">
					<thead>
					<tr>
						<th>Evento</th>
						<th>Fecha</th>	
						<th>Ubicacion</th>
						<th>Estado</th>
						<th>Host</th>
						<th>Acciones</th>		
					</tr>			
					</thead>
					<tbody>
						<c:forEach items="${eventosOtroEstado}" var="evento">
							<tr>
								<td><a href="/evento/${evento.id}">${evento.nombre}</a></td>
								<td>${evento.fecha}</td>
								<td>${evento.ubicacion}</td>
								<td>${evento.estado}</td>
								<td>${evento.host.nombre}</td>
								<td>
									<c:if test="${evento.host.id == usuario.id}">
										<a href="/editar/${evento.id}" class="btn btn-warning">Editar</a>
										<form action="/borrar/${evento.id}" method="post">
											<input type="hidden" name="_method" value="DELETE"/>
											<input type="submit" value="Borrar" class="btn btn-danger"/>
										</form>
																				
									</c:if>		
									<c:if test="${evento.host.id != usuario.id}">
										<c:choose>
											<c:when test="${evento.asistentes.contains(usuario)}">
												<span>Voy a ir al evento</span>
												<a href="/quitar/${evento.id}" class="btn btn-danger">Cancelar asistencia</a>
											</c:when>
											<c:otherwise>
												<a href="/unir/${evento.id}" class="btn btn-primary">Asistir al evento</a>
											</c:otherwise>
										</c:choose>
									</c:if>						
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		<div class="row">
			<h2>Crear evento</h2>
			<form:form action="/crear" method="post" modelAttribute="nuevoEvento">
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
				
				<input type="submit" value="Crear evento" class="btn btn-success">
			</form:form>
		</div>
	</div>
</body>
</html>