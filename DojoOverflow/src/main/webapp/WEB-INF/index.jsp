<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dojo overflow</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <h1>Dashboard de Preguntas</h1>
        <a class="btn btn-success" href="/nueva">Nueva pregunta</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Pregunta</th>
                    <th>Etiqueta</th>						
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${preguntas}" var="pregunta">
                    <tr>							
                        <td><a href="/preguntas/${pregunta.id}">${pregunta.contenido}</a></td>
                        <td>
                            <c:forEach items="${pregunta.etiquetas}" var="etiqueta">
                                <span class="badge bg-secondary">${etiqueta.tema}</span>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
