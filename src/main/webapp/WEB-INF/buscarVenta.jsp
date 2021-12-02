<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Categoria</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>


	<div class="container">
	<h1>Buscar usuarios</h1>
		<h1>Carro de Compras</h1>
		<table class="table">
					<thead >
						<tr>
							<th>Id</th>
							<th>Usuario</th>
							<th>cantidad</th>
							<th>Producto</th>
							<th>Total</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${listaVentas}" var="lista">
						<tr>
							<td>${lista.id}</td>
							<td>${lista.usuario.getRut()}</td>
							<td>${lista.cantidad}</td>
							<td><c:forEach items="${lista.productos}" var="producto">
							<span>${producto.nombre}    $${producto.precio} </span>
							</c:forEach></td>
							<td><c:forEach items="${lista.productos}" var="producto">
							<span>$ ${producto.precio*lista.cantidad }</span>
							</c:forEach></td>
							<td>
							<a class="btn btn-danger" href="../venta/eliminar/${lista.id}">Eliminar</a></td>
						</tr>
					</c:forEach>
					
		</table>
	<a href="../venta"  class="btn btn-primary">Agregar otro producto</a>	
	<a class="btn btn-danger" href="../venta/eliminarTodos/">Vaciar carrito</a>	
	</div>
</body>
</html>