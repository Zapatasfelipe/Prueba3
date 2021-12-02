<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Usuario</title>
</head>
<body>
	<div class="container">
		<h1>Registro de Usuario Nuevo</h1>
		<form action="../usuario/registroLogin" method="post">
			<table class="table table-bordered">
				<tr>
					<td><label for="rut">rut: </label></td>
					<td><input type="text" name="rut" id="rut" > (sin puntos y con guion)</td>
			

				</tr>
				<tr>
					<td><label for="nombreCompleto">Nombre y Apellido: </label></td>
					<td><input type="text" name="nombreCompleto" id="nombreCompleto" ></td>

				</tr>
				<tr>
					<td><label for="password">Password: </label></td>
					<td><input type="password" name="password" id="password"></td>

				</tr>
				<tr>
					<td><label for="passwordConfirmation">Password Confirmation: </label></td>
					<td><input type="password" name="passwordConfirmation" id="passwordConfirmation"></td>

				</tr>
				<tr>
					<td><label for="email">email: </label></td>
					<td><input type="email" name="email" id="email" ></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="reset" value="limpiar" class="btn btn-warning"> <input type="submit" value="enviar" class="btn btn-success"></td>
					
				</tr>
			</table>
		</form>
		<c:forEach items="${errores}" var="element">
						<tr>
							<td><span style="color:red;">${element}</span><br></td>
						</tr>
		</c:forEach>	
	</div>
</body>
</html>