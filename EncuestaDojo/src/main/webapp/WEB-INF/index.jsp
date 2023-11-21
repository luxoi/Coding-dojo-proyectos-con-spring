<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container bg-info">
<h1>Formulario</h1>
        <form action="/datos" method = "POST">
            <div >
                <label>Elige tu nombre</label>
                <input type="text" name ="nombre" placeholder="Ej:1" class="form-control" required>
            </div>
            
            <div>
            	<label>Elija su location</label>
                <select class="form-select" name = "location" aria-label="Default select example">
  				<option selected>Open this select menu</option>
  				<option value="San Jose">San jose</option>
  				<option value="Two">Two</option>
				</select>
            </div>

            <div>
                <label>favorite language</label>
                <select class="form-select" name = "favorite" aria-label="Default select example">
  				<option selected>Open this select menu</option>
  				<option value="Python">Python</option>
  				<option value="Javascript">Javascript</option>
				</select>
            </div>
			<div>
			<label>Comment(optional)</label>
			<input type="text" name="comentario" placeholder="Escriba aqui" class="form-control">
			</div>
            <input type="submit" name="enviar" class="btn btn-success">
		  </form>



</div>

</body>

</html>
