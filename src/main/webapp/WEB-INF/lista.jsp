<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
		<h1>Lista de usuarios</h1>
		
		<table class="table">
					<thead >
						<tr>
							<th>Id</th>
							<th>rut</th>
							<th>nombreCompleto</th>
							<th>password</th>
							<th>email</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${listaUsuarios}" var="lista">
						<tr>
							<td>${lista.id}</td>
							<td>${lista.rut}</td>
							<td>${lista.nombreCompleto}</td>
							<td>${lista.password}</td>
							<td>${lista.email}</td>
							<td><a class="btn btn-primary" href="../usuario/editar/${lista.id}">Editar</a> 
							<a class="btn btn-danger" href="../usuario/eliminar/${lista.id}">Eliminar</a></td>
						</tr>
					</c:forEach>
		</table>
	<a href="../usuario" class="btn btn-primary">Volver</a>	
	</div>
</body>
</html>