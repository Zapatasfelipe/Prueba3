<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Producto</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h1>Registro de Productos</h1>
			
		<form action="producto/login" method="post">
			<table class="table table-bordered">
					<tr>
					<td><label for="nombre">Nombre: </label></td>
					<td><input type="text" name="nombre" id="nombre" ></td>
				</tr>
				<tr>
					<td><label for="marca">Marca: </label></td>
					<td><input type="text" name="marca" id="marca" ></td>

				</tr>
				<tr>
					<td><label for="descripcion">Descripcion: </label></td>
					<td><input type="text" name="descripcion" id="descripcion"></td>

				</tr>
				<tr>
					<td><label for="precio">Precio: </label></td>
					<td><input type="number" name="precio" id="precio" ></td>

				</tr>
				<tr>
					<td><label for="categoria">Categoria: </label></td>
					<td><select name="categorias">
				<c:forEach items="${listaCategorias}" var="categoria" >
					<option value="${categoria.getId()}">
						${categoria.getNombre()}
			     	</option>
				</c:forEach></select></td>
				<tr>
					<td></td>
					<td><input type="reset" value="limpiar" class="btn btn-warning">
					 <input type="submit" value="enviar" class="btn btn-success"></td>
					
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