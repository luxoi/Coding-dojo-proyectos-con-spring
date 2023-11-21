<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Persons</title>
</head>
<body>	
		<div>
			<h1>${person.name}</h1>
		</div>	
		<div>
			License number:
			State: ${person.license.id}
			expirationDate: ${person.license.expirationDate}
		</div>

</body>
</html>