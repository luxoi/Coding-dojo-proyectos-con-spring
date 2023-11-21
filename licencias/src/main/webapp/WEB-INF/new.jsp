<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva licensia</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

	<h1>New license</h1>
	<form:form action="/license/create" method="POST" modelAttribute="license">
		<div>
			<form:label path="person">Person:</form:label>
			<form:select path="person">
						<c:forEach items="${people}" var="person">
							<form:option value="${person.id}">${person.name}</form:option>
						</c:forEach>			
			</form:select>
		
		</div>
		<div>
			<form:label path="state" >state:</form:label>
			<form:input path="state"/>
			<form:errors path="state"/>
		</div>
		
		
		<div>
			<form:label path="expirationDate" >Expiration Date:</form:label>
			<form:input type="date" path="expirationDate"/>
			<form:errors path="expirationDate"/>
		</div>
		<input type="submit" value="Save">
	
	
	</form:form>
</body>
</html>