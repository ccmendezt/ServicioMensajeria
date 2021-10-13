<%-- 
    Document   : MostrarServicio
    Created on : 13/10/2021, 04:14:35 AM
    Author     : CRISTIAN CAMILO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="negocio.Servicio"%>
<%@page import="javax.servlet.http.HttpSession"%>

<% 
    HttpSession sesion = request.getSession();
    ResultSet servicio = (ResultSet)sesion.getAttribute("consultaServicio"); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle servicio</title>
    </head>
    <body>
        <h1>Detalle servicio</h1>
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
