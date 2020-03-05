<%-- 
    Document   : login
    Created on : 21-ene-2020, 22:48:36
    Author     : HOME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
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
      <li><a href="registrouser.jsp"><span class="glyphicon glyphicon-user"></span> Registro </a></li>
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav> -->
		
<nav class="navbar navbar-dark bg-dark">
        <a style="color: white" class="navbar-toggler"><span class="navbar-toggler-icon"></span>Sistema de Reservas de Citas Médicas</a>
        <div class="dropdown">
            <a style="color: white" class="nav-link dropdown-toggle"  href="registrouser.jsp">Registrar Usuario</a>
           
        </div>
    </nav>

    <div class="container col-lg-3">


	<form action="logincontroller.do" method="post" class="needs-validation" novalidate>
            <div class="form-group text-center">
                <img src="imagen/admin_person_user_man_2839.png"/>
                <p><strong>Bienvenidos al Sistema de Login</strong></p>
            </div>
            <div class="form-group">
                <label>Usuario:</label>
                <input class="form-control" type="email" name="txtCorreo" placeholder="Ingrese Correo" required>
                    <div class="valid-feedback">Ok VALIDO</div>
                    <div class="invalid-feedback">Complete el campo</div>
            </div>
            <div class="form-group">
                <label>Contraseña</label>
                <input class="form-control" type="password" name="txtClave" placeholder="Ingrese Contraseña" required>
                    <div class="valid-feedback">Ok VALIDO</div>
                    <div class="invalid-feedback">Complete el campo</div>
            </div>
		<input class="btn btn-danger btn-block" type="submit" name="accion" value="Ingresar">
	</form>
        
    </div>
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/validarForm.js" type="text/javascript"></script>
</body>
</html>