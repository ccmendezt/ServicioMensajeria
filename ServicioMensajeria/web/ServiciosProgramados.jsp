<%-- 
    Document   : ServiciosProgramados
    Created on : 13/10/2021, 02:15:38 AM
    Author     : CRISTIAN CAMILO
--%>

<%@page import="negocio.Servicio"%>
<%@page import="datos.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    HttpSession sesion = request.getSession();
    ResultSet servicio = (ResultSet)sesion.getAttribute("serviciosProgramados"); 
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="0">
            <tr>
                <th>Id ciudad</th><th>Dia</th><th>Hora</th><th>Tipo de servicio</th><th>Medio de pago</th><th>Tipo de paquete</th><th>Costo</th>
            </tr>
            <% while (servicio.next()) {%>
            <tr>
                <td><%= servicio.getInt("k_idCiudad")%></td>
                <td><%= servicio.getString("f_inicial")%></td>
                <td><%= servicio.getString("f_horainicial")%></td>
                <td><%= servicio.getString("i_idayvuelta")%></td>
                <td><%= servicio.getString("i_mediopago")%></td>
                <td><%= servicio.getString("k_idtipopaquete")%></td>
                <td><%= servicio.getString("v_costo")%></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
