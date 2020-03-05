<%-- 
    Document   : usuario
    Created on : 21-ene-2020, 22:53:00
    Author     : HOME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Página de usuario</title>
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
      <li><a href="registrouser.jsp"><span class="glyphicon glyphicon-user"></span> Registro </a></li>
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-out"></span> Cerrar sesión</a></li>
    </ul>
</nav>

          	<ul>
		<li><a href="">Reservar cita</a></li>
		<li><a href="">Consultar cita</a></li>
	</ul>-->
    
    
      <nav class="navbar navbar-expand-lg navbar-light bg-info">
        
          <div class="collapse navbar-collapse">   
<!--            <a style="color: white" class="navbar-toggler"><span class="navbar-toggler-icon"></span>Mantenimiento de Usuarios</a>-->
         
        <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="btn btn-outline-light" href=""><span class="navbar-toggler-icon"></span>Portal de Citas Médicas</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="MenuController?menu=Usuario&accion=Listar" target="myFrame">USUARIOS</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="MenuController?menu=Medico" target="myFrame">MEDICOS</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="MenuController?menu=Especialidad" target="myFrame">ESPECIALIDADES</a>
                </li>
                <li class="nav-item active">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="MenuController?menu=CitaMedica" target="myFrame">CITAS MEDICAS</a>
                </li>
            </ul>
          </div>
        <div class="dropdown">
            <a style="color: white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Cerrar Sesion</a>
            <div class="dropdown-menu text-center">
                <a><img src="imagen/usuario.png" height="80" width=80"></a><br>
                <a>${datos}</a>
                <a>${correo}</a>
                <div class="dropdown-divider"></div>
                <a href="index.jsp" class="dropdown-item">Salir</a>
            </div>
        </div>
      </nav>
                
                
                <div class="m-4" style="height: 550px;">
                    <iframe name="myFrame" style="display:block; height:100%; width:100%; border:none" ></iframe>
                </div>

<!--        <div class="container mt-4">
            <h1>Bienvenido al Sistema... <strong>Usuario: ${datos}</strong></h1>
            <ul>
                        <li><a href="">Administrar usuarios</a></li>
                        <li><a href="">Administrar médicos</a></li>
                        <li><a href="">Administrar especialidades</a></li>
                        <li><a href="">Administrar citas</a></li>
                </ul>
        </div>-->
    
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>