<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
</head>

<% 
String error=(String)request.getAttribute("error");	
%>
<body class="container">
	<h1 class="text-center">Acceso a la aplicación</h1>

	<% if(error!=null){ %>
		<div class="alert alert-danger">
	  		<%=error %>
		</div>
	<%} %>
	

	<form class="form-horizontal" role="form" action="Login" method="POST">
		<div class="form-group">
			<%--  usuario --%>
			<label class="control-label col-sm-2" for="usuario">Usuario:</label>
			<div class="col-sm-5">
				<input type="text" class="form-control"
					placeholder="Introducir usuario" name="usuario" id="usuario">
			</div>
		</div>

		<%-- Password --%>
		<div class="form-group">
			<label class="control-label col-sm-2" for="clave">Clave:</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="clave" name="clave"
					placeholder="Introducir clave">
			</div>

		</div>
		<%-- Botón crear --%>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary" value="Acceder">Acceder</button>
			</div>
		</div>
	</form>

</body>
</html>