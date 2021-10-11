<%-- 
    Document   : login
    Created on : 10/10/2021, 11:52:46 PM
    Author     : CRISTIAN CAMILO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login" method="POST">
            <label>Iniciar sesion como:</label>
            <select name="tipoUsuario">
                <option value="1">Cliente</option> 
                <option value="2" selected>Mensajero</option> 
            </select><br>
            <label>Usuario</label>
            <input type="text" name="user" placeholder="ejemplo@gmail.com" /><br>
            <label>Contraseña</label>
            <input type="password" name="password" placeholder="contraseña" /><br>
            <input type="submit" value="Enviar" />
         </form>
    </body>
</html>
