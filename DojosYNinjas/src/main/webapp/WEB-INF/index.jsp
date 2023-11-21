<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body class="bg-success">
	<nav class="navbar navbar-expand-lg bg-dark bg-gradient">
  <div class="container-md">
    <a class="navbar-brand text-light" href="#">Bienvenidos a Dojos y Ninjas</a>
  </div>
</nav>
 	<div class="container grid gap-0 row-gap-3">
	 	 <div class="p-2 g-col-6">
	 		<a href="/dojo/new" class=" text-white">Click aqui para crear nuevos Dojos!</a>
	 	</div>
	 	<div class="p-2 g-col-6">
	 		<a href="/ninja/new" class="text-white" >Click aqui para crear nuevos Ninjas!</a>
	 	</div>
	 	<div class="d box text-white">
	 	 	 <table class="table text-white">
                <div class="container">
					  <thead>
					    <tr>
					   
					      <th scope="col">Dojo name</th>
					    </tr>
					    
					  </thead>
				<tbody>
			 		<c:forEach items="${dojos}" var="dojo">
			 		<tr>
			 		  <td> <a href="/dojos/${dojo.id}">${dojo.id} ${dojo.name}</a> </td>
			 		</tr>
			 		</c:forEach>
	 			</tbody>
	 			</div>
 	</div>
</body>
</html>