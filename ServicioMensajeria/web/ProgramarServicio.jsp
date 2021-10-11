<%-- 
    Document   : ProgramarServicio
    Created on : 11/10/2021, 11:30:02 AM
    Author     : CRISTIAN CAMILO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/programarServicio.js"></script>
        <title>Programar Servicio</title>
    </head>
    <body onload="validarFecha()">
        <form action="Login" method="POST">
            <label>Fecha del servicio:</label>
            <input type="date" id="fInicio" name="fInicio" min=""><br>
            <label>Iniciar sesion como:</label>
            <select name="tipoUsuario">
                <option value="cli">Cliente</option> 
                <option value="men">Mensajero</option> 
            </select><br>
            <label>Usuario</label>
            <input type="text" name="user" placeholder="ejemplo@gmail.com" /><br>
            <label>Contraseña</label>
            <input type="password" name="pass" placeholder="contraseña" /><br>
            <input type="submit" value="Enviar" />
         </form>
    </body>
</html>
