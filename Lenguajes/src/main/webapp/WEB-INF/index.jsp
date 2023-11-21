<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
</head>
<body>
		<h1>Bienvenido!</h1>
		<a href="/new">Add languages</a>
		
		<table>
			<thead>
				<tr>	
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Actions</th>
				</tr>	
			</thead>
			<tbody>
			<c:forEach items="${languages}" var="language">
			<tr>
				<td>${language.name}</td>
				<td>${language.creator}</td>
				<td>${language.currentVersion}</td>
				<td><a href="/edit/${language.id}">editar</a>
				<form action="/delete/${language.id}" method="POST">	
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="delete">
				</form>
				</td>
			
			</tr>
			</c:forEach> 
			
			</tbody>
		</table>
		
</body>
</html>