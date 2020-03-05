<%-- 
    Document   : registrouser
    Created on : 21-ene-2020, 22:49:54
    Author     : HOME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Registrarse</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	
</head>
<body>
<!--
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Portal de citas médicas</a>
    </div>
       <ul class="nav navbar-nav">
			<li><a href="index.jsp">Inicio</a></li>
			<li>Contacto</li>
    </ul>
<ul class="nav navbar-nav navbar-right">
      <li><a s  href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
    -->
    <nav class="navbar navbar-dark bg-dark">
        <a style="color: white" class="navbar-toggler"><span class="navbar-toggler-icon"></span>Mantenimiento de Usuarios</a>
        <div class="dropdown">
            <a style="color: white" href="index.jsp" class="nav-link dropdown-toggle" >Salir</a>
      
        </div>
    </nav>


<!--
<style type="text/css">
	form{
		display: table;
		margin: auto;
	}
</style> -->
            <div class="alert alert-success center" role="alert">
                    <p>${NOTIFICATION}</p>
                </div>

	<form action="<%=request.getContextPath()%>/registrousuario" method="post">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <label>Nombres</label>
                        <input type="text" name="nombres" class="form-control">
                        <label>Apellidos</label>
                        <input type="text" name="apellidos" class="form-control">
                        <label>DNI</label>
                        <input type="text" name="dni" class="form-control">
                    </div>
                    <div class="col-md-4">
                        <label>Sexo</label>
                        <select class="form-control">
			<option>Masculino</option>
			<option>Femenino</option>
                        </select>
                        <label>Fecha de nacimiento</label>
                        <input type="Date" name="" class="form-control">
                        <label>Telefono</label>
                        <input type="number" name="telefono" class="form-control">
                    </div>
               
                    <div class="col-md-4">
                        <label>Dirección</label>
                        <input type="text" name="direccion" class="form-control">
                        <label>Correo</label>
                        <input type="email" name="correo" class="form-control">
                        <label>Clave</label>
                        <input type="password" name="clave" class="form-control">
                    </div>
                    
                </div>
                <br>
                <br>
                <div class="text-right">
                        <input type="submit" name="" value="Registrarse" class="btn btn-dark">
                </div>
		<!--  <p>Nombres</p>
		<input type="" name="nombres">
		<p>Apellidos</p>
		<input type="" name="apellidos">
		<p>DNI</p>
		<input type="" name="dni">
		<p>Sexo</p>
		<select>
			<option>Masculino</option>
			<option>Femenino</option>
		</select>
		<p>Fecha de nacimiento</p>
		<input type="date" name="">
		<p>Teléfono</p>
		<input type="" name="telefono">
		<p>Dirección</p>
		<input type="" name="direccion">
                <p>Correo</p>
		<input type="email" name="correo">
                <p>Clave</p>
		<input type="password" name="clave">
		<br>
		<input type="submit" name="" value="Registrarse">
		<br>-->
		
            </div>
	</form>
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>