<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>productos</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h1>Edicion de productos</h1>
		<form action="../editarProducto" method="post">
			<table class="table table-bordered">
				<tr>
					<td><label for="nombre">Nombre: </label></td>
					<td><input type="text" name="nombre" id="nombre" value="${producto.nombre}" ></td>

				</tr>
				<tr>
					<td><label for="marca">Marca: </label></td>
					<td><input type="text" name="marca" id="marca" value="${producto.marca}" ></td>

				</tr>
				<tr>
					<td><label for="descripcion">Descripcion: </label></td>
					<td><input type="text" name="descripcion" id="descripcion" value="${producto.descripcion}"></td>

				</tr>
				<tr>
					<td><label for="precio">Precio: </label></td>
					<td><input type="number" name="precio" id="precio" value="${producto.precio}"></td>

				</tr>
				<tr>
				<td><label for="categoria">Categoria: </label></td>
					<td><select class="form-select" name="categorias">
							<c:forEach items="${listaCategorias}" var="categoria">
<%-- 								<c:if test="${categoria.id == productos.categoria.id}"> --%>
<%-- 									<option selected value="${categoria.id}">${categoria.nombre}</option> --%>
<%-- 								</c:if> --%>
								<option value="${categoria.id}">${categoria.nombre}</option>
							</c:forEach></select></td>
							<tr>
							
					<td><input type="hidden" name="id" id="id" value="${producto.id}"></td>
					<td><input type="submit" value="Editar" class="btn btn-success"></td>
					
				</tr>
			</table>
			<c:forEach items="${errores}" var="element">
				<tr>
					<td><span style="color: red;">${element}</span><br></td>
				</tr>
			</c:forEach>
		</form>
		<a href="../listaProducto" class="btn btn-primary">Volver</a>	
	</div>
</body>
</html>