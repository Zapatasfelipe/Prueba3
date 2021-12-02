
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Usuario</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h1>Edicion de usuarios</h1>
		<form action="../editarUsuario" method="post">
			<table class="table table-bordered">
				<tr>
					<td><label for="rut">Rut: </label></td>
					<td><input type="text" name="rut" id="rut" value="${usuario.rut}" ></td>

				</tr>
				<tr>
					<td><label for="nombre">Nombre Completo: </label></td>
					<td><input type="text" name="nombreCompleto" id="nombreCompleto" value="${usuario.nombreCompleto}" ></td>

				</tr>
				<tr>
					<td><label for="password">password: </label></td>
					<td><input type="text" name="password" id="password" value="${usuario.password}"></td>

				</tr>
				<tr>
					<td><label for="email">Email: </label></td>
					<td><input type="email" name="email" id="email" value="${usuario.email}"></td>

				</tr>
				<tr>
					<td><input type="hidden" name="id" id="id" value="${usuario.id}"></td>
					<td><input type="submit" value="Editar" class="btn btn-success"></td>
					
				</tr>
			</table>
			<c:forEach items="${errores}" var="element">
				<tr>
					<td><span style="color: red;">${element}</span><br></td>
				</tr>
			</c:forEach>
		</form>
		<a href="../lista" class="btn btn-primary">Volver</a>	
	</div>
</body>
</html>