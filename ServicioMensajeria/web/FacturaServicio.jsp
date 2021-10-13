<%-- 
    Document   : FacturaServicio
    Created on : 12/10/2021, 05:32:36 PM
    Author     : CRISTIAN CAMILO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    Object ciudadServicio = (String) sesion.getAttribute("ciudadServicio");
    Object fInicio = (String) sesion.getAttribute("fInicio");
    Object fHoraInicio = (String) sesion.getAttribute("fHoraInicio");
    Object tipoServicio = (String) sesion.getAttribute("tipoServicio");
    Object medioPago = (String) sesion.getAttribute("medioPago");
    Object volumenPaquete = (String) sesion.getAttribute("volumenPaquete");
    String i_tipoPaquete = "";
    if (volumenPaquete.equals("DC")) {
        i_tipoPaquete = "Documentos";
    } else {
        if (volumenPaquete.equals("PQ")) {
            i_tipoPaquete = "Paquete pequeño";
        } else {
            if (volumenPaquete.equals("PM")) {
                i_tipoPaquete = "Paquete mediano";
            }else{
                if (volumenPaquete.equals("PG")) {
                i_tipoPaquete = "Paquete grande";
            }
            }
        }
    };
    Object nroDir = sesion.getAttribute("nroDir");
    Object nroDirecciones = (Integer) nroDir;
    Object direcciones[] = new String[(Integer) nroDirecciones];
    Object indicaciones[] = new String[(Integer) nroDirecciones];
    String dir = "direccion";
    String com = "comentario";
    int temp = 0;
    for (int i = 0; i < (Integer) nroDirecciones; i++) {
        temp = i + 1;
        dir = dir + String.valueOf(temp);
        com = com + String.valueOf(temp);
        direcciones[i] = (String) sesion.getAttribute(dir);
        indicaciones[i] = (String) sesion.getAttribute(com);
        dir = "direccion";
        com = "comentario";
    }
    Object costoServicio = sesion.getAttribute("costoServicio");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Solicitud de servicio</h1>
        <label>Ciudad del servicio: <%= ciudadServicio%></label><br>
        <label>Fecha del servicio: <%= fInicio%></label><br>
        <label>Hora del servicio: <%= fHoraInicio%></label><br>
        <label>Tipo de servicio: <%= tipoServicio%></label><br>
        <label>Medio de pago: <%= medioPago%></label><br> 
        <label>Tipo de paquete: <%= i_tipoPaquete%></label><br>
        <label>Numero de direcciones: <%= nroDir%></label><br>
        <%
            for (int i = 0; i < (Integer) nroDirecciones; i++) {%>
        <label>Direccion <%= i + 1%>: <%= direcciones[i]%></label><br>
        <label>Indicacion <%= i + 1%>: <%= indicaciones[i]%></label><br>
        <%
            }
        %>
        <label>El valor del servicio será de: $<%= costoServicio%></label><br>
        <button onclick="location.href = 'InicioSesionCliente.jsp'">Cancelar Servicio</button>
        <button type="button" class="btn btn-primary" onclick="location.href = 'AgregarServicio'">Programar Servicio</button>
    </body>
</html>
