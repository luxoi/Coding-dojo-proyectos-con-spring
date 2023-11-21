<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="bg-success row align-items-center justify-content-center vh-100">
	<div class="col-sm-5 bg-white row border border-primary "> 
		<h1>Submitted info</h1>
		<p1>name: ${nombre}</p1>
		<p1>Dojo location: ${location}</p1>
		<p1>Favorite language: ${favorite}</p1>
		<p1>comment: ${comentario}</p1>
		<form action="/" method = "POST">
		<input type="submit" name="nombree" class="btn btn-success">
	</div>
</body>
</html>