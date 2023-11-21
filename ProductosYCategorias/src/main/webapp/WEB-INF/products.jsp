<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
	<div class="container">
    <div class="row">
        <h1>${producto.name}</h1>
        <div class="col-6">
          <h3>Categories</h3>
        </div>
        <div class="col-6">
           <form:form method="POST" modelAttribute="categoria" action="/crear/unir">
           <form:label path="name">Add categories:</form:label>
           <form:select path="name">
           		<c:forEach items="${categorias}" var="category">
           			<option value="${category.id}">${category.name}</option>
           		
           		</c:forEach>
           	
           </form:select>
           
           <form:errors path="name"></form:errors>
           <form:hidden path="productos" value="${producto.id}"/>
           <input type="submit" value="Enviar">
           
           </form:form>
        </div>
    </div>
</div>
</body>
</html>