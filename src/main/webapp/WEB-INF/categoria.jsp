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
		<h1>Registro de categorias</h1>
		<form action="categoria/createCategoria" method="post">
			<table class="table table-bordered">
				<tr>
					<td><label for="nombre">Nombre </label></td>
					<td><input type="text" name="nombre" id="nombre" ></td>

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