<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dormitory</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>New Dormitory</h1>
		<form:form action="/dormitory/create" method="POST" modelAttribute="dormitory">
			<form:label path="name">Name: </form:label>	
			<form:input path="name" class="form-control"/>
			<form:errors path="name" class="text-danger"/>
			<input type="submit" value="Save" class="btn btn-success"/>
		</form:form>
	</div>
</body>
</html>