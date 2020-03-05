<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

    
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
</nav>
    <form action="logincontroller.do" method="post">
		<p>Usuario</p>
		<input type="email" name="txtCorreo">
		<p>Contraseña</p>
		<input type="password" name="txtClave">
		<input type="submit" name="" value="Ingresar">
	</form>

<div class="container">
  <h2>Alerta</h2>
  <div class="alert alert-warning">
    <strong>Datos incorrectos</strong> Usuario y/o clave incorrecto.
  </div>
</div>

</body>
</html>