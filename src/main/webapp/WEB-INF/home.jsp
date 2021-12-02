<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Home</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<h1>Hola ${nombreCompleto_usuario} de id: ${usuario_id}</h1>
	<hr>
	
	</div>
</body>
</html>