<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Venta</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h1>Registro de Venta</h1>
		<form action="venta/createVenta" method="post">
			<table class="table table-bordered">
			<tr>
					<td><label for="Rut">Usuario: </label></td>
					<td><select name="usuario">
				<c:forEach items="${listaUsuario}" var="usuario" >
					<option value="${usuario.getId()}">
						${usuario.getRut()} ${usuario.getNombreCompleto()}
			     	</option>
				</c:forEach>
			</select></tr>
			<tr>
					<td><label for="producto">Productos: </label></td>
					<td><select name="productos">
				<c:forEach items="${listaProductos}" var="producto" >
					<option value="${producto.getId()}">
						${producto.getNombre()} $ ${producto.getPrecio()}
			     	</option>
				</c:forEach></select></td>
				<tr>
			
				<tr>
					<td><label for="cantidad">Cantidad </label></td>
					<td><input type="number" name="cantidad" id="cantidad" value="1"></td>

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