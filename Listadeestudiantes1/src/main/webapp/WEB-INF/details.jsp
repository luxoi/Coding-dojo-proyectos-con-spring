<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dormitory</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>${ dormitory.name } Dormitory</h1>	
		<form action="/dormitory/${ dormitory.id }/add" method="POST"> 
		    <select name="student" class="form-select">
		        <c:forEach items="${ estudiantes}" var="estudiante">
		            <option value="${ estudiante.id }">${ estudiante.name } ${ estudiante.lastname }</option>
		        </c:forEach>
		    </select>
		    <input type="submit" class="btn btn-success mt-3" value="Save"/>
		</form>

		<table class="table table-hover">
			<thead>
				<th>Name</th>	
				<th>Action</th>
			</thead>	
			<tbody>
				<c:forEach items="${ dormitory.estudiantes }" var ="estudiante">
					<tr>
						<td>${ estudiante.name }</td>	
						<td>
							<form action="/dormitory/${ dormitory.id }/remove/${ estudiante.id }" method="post">
								<input type="hidden" name="_method" value="DELETE"/>
								<input type="submit" value="Delete" class="btn btn-danger"/>
							</form>
						</td>
					</tr>	
				</c:forEach>	
			</tbody>
		</table>
		<a href="/" class="btn btn-success">Dashboard</a>
	</div>
</body>
</html>