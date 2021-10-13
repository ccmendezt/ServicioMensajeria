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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <h1>Consultar servicio</h1>
        <form action="ConsultarServicio" method="POST" novalidate>
            <table class="inicio">
                <tr>
                    <th><label>Consultar servicio por:</label></th>
                    <th><select name="tipoConsultaS" id="tipoConsultaS">
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
