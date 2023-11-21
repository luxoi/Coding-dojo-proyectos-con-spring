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
		<h1>New ninja!</h1>
		<div>
			<form:form action="/nuevo" method="POST" modelAttribute="ninja">
				<div>
						<form:label path="dojos">Dojo:</form:label>
						<form:select path="dojos">
						<c:forEach items="${dojos}" var="dojo">
						<form:option value="${dojo.id}">${dojo.name}</form:option>
						</c:forEach>			
						</form:select>
				</div>
				<div>
 					<form:label path="firstName">First name</form:label>
 					<form:input path="firstName" class="form-control"/>
 					<form:errors path="firstName" class="text-danger" />	
 				</div>		
 				<div>
 					<form:label path="lastName">Last name</form:label>
 					<form:input path="lastName" class="form-control"/>
 					<form:errors path="lastName" class="text-danger" />	
 				</div>	
 				<div>
 					<form:label path="age">Age</form:label>
 					<form:input path="age" class="form-control"/>
 					<form:errors path="age" class="text-danger" />	
 				</div>		
			<input type="submit" value="Create Ninja">		
			</form:form>
		</div>
	</div>
</body>
</html>