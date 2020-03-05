<%-- 
    Document   : registrouser
    Created on : 21-ene-2020, 22:49:54
    Author     : HOME
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!--    <nav class="navbar navbar-dark bg-dark">
        <a style="color: white" class="navbar-toggler"><span class="navbar-toggler-icon"></span>Mantenimiento de Usuarios</a>
        <div class="dropdown">
            <a style="color: white" href="index.jsp" class="nav-link dropdown-toggle" >Salir</a>
      
        </div>
    </nav>-->
<div class="d-flex">
    <div class="card col-sm-3">
        <div class="card-body">
            <form action="MenuController?menu=Usuario" method="post" class="needs-validation" novalidate>
                <div class="form-group">
                    <label>Nombres</label>
                    <input type="text" name="txtNombres" value="${usuar.getNombres()}" class="form-control" required>
                    <div class="valid-feedback">Ok VALIDO</div>
                    <div class="invalid-feedback">Complete el campo</div>
                </div>
                <div class="form-group">
                    <label>Apellidos</label>
                    <input type="text" name="txtApellidos" value="${usuar.getApellidos()}"  class="form-control" required>
                    <div class="valid-feedback">Ok VALIDO</div>
                    <div class="invalid-feedback">Complete el campo</div>
                </div>
                <div class="form-group">
                    <label>DNI</label>  
                    <input type="text" name="txtDni" value="${usuar.getDni()}" class="form-control"  required>
                    <div class="valid-feedback">Ok VALIDO</div>
                    <div class="invalid-feedback">Complete el campo</div>
                </div>          
                <div class="form-group">
                    <label>Sexo</label>
                    <select class="form-control" name="cboSexo">
                    <option>Masculino</option>
                    <option>Femenino</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Fecha de nacimiento</label>
                    <input type="Date" name="tblFechaNac" class="form-control"  required>
                    <div class="valid-feedback">Ok VALIDO</div>
                    <div class="invalid-feedback">Complete el campo</div>
                </div>
                <div class="form-group">
                    <label>Telefono</label>
                    <input type="number" name="txtTelefono" value="${usuar.getTelefono()}" class="form-control"  required>
                    <div class="valid-feedback">Ok VALIDO</div>
                    <div class="invalid-feedback">Complete el campo</div>
                </div>
                <div class="form-group">
                    <label>Dirección</label>
                    <input type="text" name="txtDireccion" value="${usuar.getDireccion()}" class="form-control"  required>
                    <div class="valid-feedback">Ok VALIDO</div>
                    <div class="invalid-feedback">Complete el campo</div>
                </div>
                <div class="form-group">
                    <label>Correo</label>
                    <input type="email" name="txtCorreo" value="${usuar.getCorreo()}" class="form-control"  required>
                    <div class="valid-feedback">Ok VALIDO</div>
                    <div class="invalid-feedback">Complete el campo</div>
                </div>

                <div class="form-group">
                    <label>Clave</label>
                    <input type="password" name="txtClave" class="form-control"  required>
                    <div class="valid-feedback">Ok VALIDO</div>
                    <div class="invalid-feedback">Complete el campo</div>
                </div>
                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
            </form>
        </div>
    </div>
    <div class="card col-sm-10">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>DNI</th>
                    <th>SEXO</th>
                    <th>FECHA NAC</th>
                    <th>TELEFONO</th>
                    <th>DIRECCION</th>
                    <th>EMAIL</th>
                    <th>ACCIONES</th>
               </tr>
            </thead>
            <tbody>
                <c:forEach var="usu" items="${listaUsuario}">
                    <tr>
                        <td>${usu.getId()}</td>
                        <td>${usu.getNombres()}</td>
                        <td>${usu.getApellidos()}</td>
                        <td>${usu.getDni()}</td>
                        <td>Masculino</td>
                        <td>03/03/1989</td>
                        <td>${usu.getTelefono()}</td>
                        <td>${usu.getDireccion()}</td>
                        <td>${usu.getCorreo()}</td>
                        <td>
                            <a class="btn btn-warning" href="MenuController?menu=Usuario&accion=Editar&idUsu=${usu.getId()}">Editar</a>
                            <a class="btn btn-danger" href="MenuController?menu=Usuario&accion=Eliminar&idUsu=${usu.getId()}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    
</div>


<!--
<style type="text/css">
	form{
		display: table;
		margin: auto;
	}
</style> -->
<!--            <div class="alert alert-success center" role="alert">
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
                </div>-->
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
		
<!--            </div>
	</form>-->
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/validarForm.js" type="text/javascript"></script>

</body>
</html>