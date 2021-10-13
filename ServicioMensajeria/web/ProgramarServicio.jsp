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
        <script defer src="js/programarServicio.js"></script>
        <title>Programar Servicio</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body onload="validarFecha()">
        <h1>Solicitud de servicio</h1>
        <form action="ProgramarServicio" method="POST">
            <label>Ciudad de servicio:</label>
            <select name="ciudad" required>
                <option value="11001">Bogota</option>
                <option value="15001">Tunja</option>
            </select><br>
            <label>Dia:</label>
            <input type="date" id="fInicio" name="fInicio" min="" required><br>
            <label>Hora:</label>
            <input type="time" id="fHoraInicio" name="fHoraInicio" min="" required><br>
            <label>Tipo de servicio:</label>
            <select name="tipoServicio" id="tipoServicio" required>
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
            <select name="nroDir" id="nroDir" required>
                <option value="0">Seleccionar</option>
                <!-- <option value="1">1 Direccion</option> -->
                <option value="2">2 Direcciones</option>
                <option value="3">3 Direcciones</option>
                <option value="4">4 Direcciones</option>
            </select><br>
            
            <div  id="texto1" style="display: none">
                <label class="form-label">Ingrese la direccion:</label>
                <input type="text" class="form-control-inline" id="direccion1" name="direccion1" placeholder="Ejemplo: Cra 43 # 24 - 43"></input>
                <label class="form-label">Ingrese una breve descripcion:</label>
                <textarea class="form-control-inline" id="exampleFormControlTextarea1" name="comentario1" rows="1" placeholder="Descripcion"></textarea>
            </div>
            <div id="texto2" style="display: none">
                <label class="form-label">Ingrese la direccion:</label>
                <input type="text" id="direccion2" name="direccion2" placeholder="Ejemplo: Cra 43 # 24 - 43" ></input>
                <label class="form-label">Ingrese una breve descripcion:</label>
                <textarea class="form-control-inline" id="exampleFormControlTextarea1" name="comentario2" rows="1" placeholder="Descripcion"></textarea>
            </div>
            <div id="texto3" style="display: none">
                <label class="form-label">Ingrese la direccion:</label>
                <input type="text" id="direccion3" name="direccion3" placeholder="Ejemplo: Cra 43 # 24 - 43"></input>
                <label class="form-label">Ingrese una breve descripcion:</label>
                <textarea class="form-control-inline" id="exampleFormControlTextarea1" name="comentario3" rows="1" placeholder="Descripcion"></textarea>
            </div>
            <div id="texto4" style="display: none">
                <label class="form-label">Ingrese la direccion:</label>
                <input type="text" id="direccion4" name="direccion4" placeholder="Ejemplo: Cra 43 # 24 - 43"></input> 
                <label class="form-label">Ingrese una breve descripcion:</label> 
                <textarea class="form-control-inline" id="exampleFormControlTextarea1" name="comentario4" rows="1" placeholder="Descripcion"></textarea>
            </div>
            <!-- <input type="submit" value="Solicitar servicio" /> -->
            <button type="submit" class="btn btn-primary" value="Solicitar servicio">Solicitar servicio</button>
         </form>
    </body>
</html>
