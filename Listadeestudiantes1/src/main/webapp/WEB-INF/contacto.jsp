<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear contacto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div>
            <h1>Contact info</h1>
        </div>
        <form:form action="/crear/contacto" method="POST" modelAttribute="contacto">
            <div>
                <form:label path="estudiante">estudiante:</form:label>
                <form:select path="estudiante">
                    <c:forEach items="${estudiantes}" var="estudianteItem"> <!-- Cambio el nombre de la variable en el bucle -->
                        <form:option value="${estudianteItem.id}">${estudianteItem.name}</form:option> <!-- Cambio el nombre de la variable en el bucle -->
                    </c:forEach>
                </form:select>
            </div>
            <div>
                <form:label path="address">address:</form:label>
                <form:input path="address"/>
                <form:errors path="address"></form:errors>
            </div>
            <div>
                <form:label path="city">city:</form:label>
                <form:input path="city"/>
                <form:errors path="city"></form:errors>
            </div>
            <div>
                <form:label path="state">State:</form:label>
                <form:input path="state"/>
                <form:errors path="state"></form:errors>
            </div>
            <input type="submit" value="Guardar contacto" class="btn btn-success">        
        </form:form>
    </div>
</body>
</html>
