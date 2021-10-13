<%-- 
    Document   : index
    Created on : 13/10/2021, 12:53:02 AM
    Author     : CRISTIAN CAMILO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    sesion.invalidate();
%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Iniciar de sesion</h1>
        <a href="login.jsp">Iniciar Sesion</a>
    </body>
</html>
