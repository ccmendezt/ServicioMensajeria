/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function validarFecha() { 
    var fecha = new Date();
    var anio = fecha.getFullYear();
    var dia = fecha.getDate();
    var _mes = fecha.getMonth();//viene con valores de 0 al 11
    _mes = _mes + 1;//ahora lo tienes de 1 al 12
    if (_mes < 10)//ahora le agregas un 0 para el formato date
    { var mes = "0" + _mes;}
    else
    { var mes = _mes}
    
    var fechaCompleta = anio + "-" + mes + "-" + dia;
    fechaCompleta = fechaCompleta.toString();
    
    var fechaForm = document.getElementById("fInicio");
    fechaForm.setAttribute("min",fechaCompleta);
    
}

function validarHora() { 
    var fecha = new Date();
    var anio = fecha.getFullYear();
    var dia = fecha.getDate();
    var _mes = fecha.getMonth();//viene con valores de 0 al 11
    _mes = _mes + 1;//ahora lo tienes de 1 al 12
    if (_mes < 10)//ahora le agregas un 0 para el formato date
    { var mes = "0" + _mes;}
    else
    { var mes = _mes}
    
    var fechaCompleta = anio + "-" + mes + "-" + dia;
    fechaCompleta = fechaCompleta.toString();
    
    var fechaForm = document.getElementById("fInicio");
    alert("FEcha inicio " + fechaForm.value);
    
    var horaForm = document.getElementById("fHoraInicio");
    alert("FEcha inicio " + horaForm.value);
    // get por ID el campo de hora y mostrarlo a ver qué pedo
    
    if(fechaForm.value == fechaCompleta){
        alert("Las fechas son iguales");
    }else{
        alert("Las fechas NO son iguales");
    }
}

function generarDir(){
    var nroDirecciones = document.getElementById("nroDir").value();
    //Generar las direcciones con un innerHTML
    // Y se podría hacer un metodo en el DAO de agregar una direccion, y llamalo la cantidad de veces que indique el nroDirecciones
}