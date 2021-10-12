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
        <h1>Solicitud de servicio</h1>
        <form action="ProgramarServicio" method="POST">
            <label>Ciudad de servicio:</label>
            <select name="ciudad" required>
                <option value="bog">Bogota</option>
                <option value="tun">Tunja</option>
            </select><br>
            <label>Dia:</label>
            <input type="date" id="fInicio" name="fInicio" min="" required><br>
            <label>Hora:</label>
            <input type="time" id="fHoraInicio" name="fHoraInicio" min="" onchange="_validarHora()" required><br>
            <label>Tipo de servicio:</label>
            <select name="tipoServicio" required>
                <option value="ida">Ida</option>
                <option value="vuelta">Ida y vuelta</option>
            </select><br>
            <label>Medio de pago:</label>
            <select name="medioPago" required>
                <option value="efectivo">Efectivo</option>
                <option value="pse">PSE</option>
            </select><br>
            <label>Volumen de paquete:</label>
            <select name="volumenPaquete" required>
                <option value="DC">Documentos</option>
                <option value="PQ">Paquete pequeño</option>
                <option value="PM">Paquete mediano</option>
                <option value="PG">Paquete grande</option>
            </select><br>
            <label>Numero de direcciones:</label>
            <select name="nroDir" required>
                <option value="1">1 Direccion</option>
                <option value="2">2 Direcciones</option>
                <option value="3">3 Direcciones</option>
                <option value="4">4 Direcciones</option>
            </select><br>
            
            
            <input type="submit" value="Solicitar servicio" />
         </form>
    </body>
</html>
