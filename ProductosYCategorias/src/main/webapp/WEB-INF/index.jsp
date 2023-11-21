<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido!!</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			 <div class="p-2 g-col-6">
				<h3>aaaa</h3>
		 		<a href="/new/product" >Click aqui para crear nuevos Productos!</a>
		 	</div>
		 	<div class="p-2 g-col-6">
		 		<a href="/new/category">Click aqui para crear nuevas Categorias!</a>
		 	</div>
		 	<div>
		 		<table class="table table-hover table-striped-columns table-bordered border-primary">
		 			<thead>
		 				<tr>
		 					<th scope="col">name</th>
		 					<th scope="col">Description</th>
		 					<th scope="col">price</th>
		 					<th scope="col">Category Count</th>
		 				</tr>
		 			
		 			
		 			</thead>
		 			<tbody>
		 				 <c:forEach items="${productos}" var="producto">
			 				<tr>
			 					<td><a href="/products/${producto.id}">${producto.name}</a></td>
			 					<td>${producto.description}</td>
			 					<td>${producto.price}</td>		
			 					<td>${producto.categoryCount()}</td> 				
			 				</tr>		
		 				 </c:forEach>
		 			</tbody>
		 		
		 		</table>
		 	
		 	</div>
		</div>
	</div>
</body>
</html>