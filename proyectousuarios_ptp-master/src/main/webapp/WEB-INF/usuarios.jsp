<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
</head>
<body>
	<h1>${titulo}</h1>
	<ul>
		<!-- {"Elena de Troya", "Juana de Arco", "Pablo Picasso"}
		usuario = "Elena de Troya"
		usuario = "Juana de Arco"
		usuario = "Pablo Picasso"
		  -->
		<c:forEach items="${listaUsuarios}" var="usuario" >
			<li>${usuario}</li>
		</c:forEach>
	</ul>
	
	<ol>
		<!-- paises.put("Mexico", "CDMX"); key = Mexico value=CDMX
		paises.put("Estados Unidos", "Washington DC");
		paises.put("El Salvador", "San Salvador");
		
		pais = key=Mexico value=CDMX
		pais = key:Estados Unidos value:Washington DC
		pais = key:El Salvador value:San Salvador
		 -->
		<c:forEach items="${paises}" var="pais">
			<li>
				${pais.key} - ${pais.value}
				<c:if test="${pais.key == 'Mexico'}">
					<b>México lindo y querido</b>
				</c:if>
			</li>
		</c:forEach>
	</ol>
	
</body>
</html>