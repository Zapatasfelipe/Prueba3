<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Usuario</title>
</head>
<body>
	<div class="container">
		<h1>Ingreso al Sistema</h1>
			
			<form action="/usuario/login" method="post">
			<label for="email">Email:</label>
			<input type="email" class="form-control" name="email" placeholder="Ingresa tu email">
			<br>
			<label for="password">Password:</label>
			<input type="password" class="form-control" name="password" placeholder="Ingresa tu password">
			<br>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="submit" class="btn btn-primary" value= "Ingresar">
			
		</form>
	</div>
</body>
</html>