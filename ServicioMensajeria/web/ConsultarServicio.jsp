<%-- 
    Document   : ServiciosProgramados
    Created on : 13/10/2021, 02:15:38 AM
    Author     : CRISTIAN CAMILO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Consultar servicio</title>
        <script defer src="js/ConsultarServicio.js"></script>
        <link rel="stylesheet" href="css/consultaserv.css" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <div id="banner">  
    </div>
    <div id="img">
        <img src="data:image/png;base64,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" alt="alt"/>
    </div>
    <div id="banner2">  
    </div>
    <body>
        <h1>Consultar servicio</h1>
        <form action="ConsultarServicio" method="POST" novalidate>
            <table class="inicio">
                <tr>
                    <th><label>Consultar servicio por:</label></th>
                    <th>
                        <select name="tipoConsultaS" id="tipoConsultaS">
                            <option value="0">Seleccionar</option>
                            <option value="1">Id de servicio</option>
                            <option value="2">Fecha</option>
                            <option value="3">Documento de identidad del solicitante</option>
                        </select><br>
                    </th>
                </tr>
                
            </table>
            <div  id="texto1" style="display: none">
                <label class="form-label">Ingrese el id:</label>
                <input type="number" class="form-control-inline" id="id" name="idServicio" placeholder="Ejemplo: 1234"></input>
            </div>
            <div id="texto2" style="display: none">
                <label class="form-label">Ingrese la fecha:</label>
                <input type="date" class="form-control-inline" id="fechaBusqueda" name="fechaBusqueda" min="" required><br>
            </div>
            <div id="texto3" style="display: none">
                <label class="form-label">Ingrese su documento de identidad:</label>
                <input type="number" class="form-control-inline" id="documentoId" name="documentoId" placeholder="Ejemplo: 1010234567"></input>
            </div>
            <div id="boton"><input type="submit" class="btn btn-primary" value="Enviar" /></div>
        </form>
    </body>
</html>
