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
		<h1>Lista de categoria</h1>
		
		<table class="table">
					<thead >
						<tr>
							<th>Id</th>
							<th>categoria</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${listaCategorias}" var="lista">
						<tr>
							<td>${lista.id}</td>
							<td>${lista.nombre}</td>
							<td><a class="btn btn-primary" href="../categoria/editar/${lista.id}">Editar</a> 
							<a class="btn btn-danger" href="../categoria/eliminar/${lista.id}">Eliminar</a></td>
						</tr>
					</c:forEach>
		</table>
	<a href="../categoria" class="btn btn-primary">Volver</a>	
	</div>
</body>
</html>