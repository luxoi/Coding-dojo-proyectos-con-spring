<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Bienvenidos al Dojo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>All students</h1>
			<div>
				<p> <a href="/new/estudiante">Click here to create a new student</a> </p>
			</div>
			<div>
				<p> <a href="/new/contacto">Click here to crear el contacto del estudiante</a> </p>
				  <a href="/dormitory/new" class="btn btn-primary">Crear Dormitorio</a>
			</div>
			
			<div class="d box text-white">
	 	 	 <table class="table text-white">
                <div class="container">
					  <thead>
					    <tr>
					      <th scope="col">name</th>
					      <th scope="col">age</th>
					      <th scope="col">Address</th>
					      <th scope="col">City</th>
					      <th scope="col">State</th>
					    </tr>
					    
					  </thead>
				<tbody>
			 		<c:forEach items="${estudiantes}" var="estudiante">
			 		<tr>
						 <td><a href="/dormitory/${estudiante.id}">${estudiante.name} ${estudiante.lastname}</a> </td>
				         <td>${estudiante.age}</td>
				         <td>${estudiante.contacto.address}</td>
				         <td>${estudiante.contacto.city}</td>
				         <td>${estudiante.contacto.state}</td>
			 		</tr>
			 		</c:forEach>
	 			</tbody>
	 			</div>
		
		
	</div>
</body>
</html>