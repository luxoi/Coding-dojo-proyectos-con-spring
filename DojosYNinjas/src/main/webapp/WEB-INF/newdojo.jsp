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
</head>
<body>
 	<div class="container">
 		<div>
 			<h1>New dojo!</h1>
 		</div>
 		<div>
 			<form:form method="POST" action="/crear" modelAttribute="dojo">
 				<div>
 					<form:label path="name">Dojo</form:label>
 					<form:input path="name" class="form-control"/>
 					<form:errors path="name" class="text-danger" />
 										
					<input type="submit" value="Create Dojo">
				
 				</div>			
				
 			</form:form>
 		</div>
 	</div>
</body>
</html>