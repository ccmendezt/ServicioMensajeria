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

/*function validarHora() { 
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
}*/

function fadeOutEffectInput(elements){
    var elementSelected = document.getElementById(elements);
    var fadeEffect = setInterval(function(){
        // if(!elementSelected.style.opacity){
        //     elementSelected.style.opacity = 1;
        // }

        if(elementSelected.style.opacity > 0){
            elementSelected.style.opacity = 0;
            if(elementSelected.style.opacity == 0){
                elementSelected.style.display = "none";
            }
        }else{
            clearInterval(fadeEffect);
        }
    }, 200);
}

function fadeInEffectInput(elements){
    var elementSelected = document.getElementById(elements);
    var fadeEffect = setInterval(function(){
        if(!elementSelected.style.opacity){
            elementSelected.style.opacity = 0;
        }

        if(elementSelected.style.opacity < 1){
            elementSelected.style.opacity += 1;
            elementSelected.style.display = "block"
        }else{
            clearInterval(fadeEffect);
        }
    }, 200);
}

var nroDir = document.getElementById("nroDir");
nroDir.addEventListener("change", event => {
    var elementSelected = nroDir.options[nroDir.selectedIndex].value;
    console.log(elementSelected)
    switch(elementSelected){
        case "0":
            fadeOutEffectInput("texto1")
            fadeOutEffectInput("texto2")
            fadeOutEffectInput("texto3")
            fadeOutEffectInput("texto4")
            break;
        // case "1":
        //     fadeOutEffectInput("texto2")
        //     fadeOutEffectInput("texto3")
        //     fadeOutEffectInput("texto4")

        //     fadeInEffectInput("texto1")
        //     break;
        case "2":
            fadeOutEffectInput("texto3")
            fadeOutEffectInput("texto4")

            fadeInEffectInput("texto1")
            fadeInEffectInput("texto2")
            break;
        case "3":
            fadeOutEffectInput("texto4")

            fadeInEffectInput("texto1")
            fadeInEffectInput("texto2")
            fadeInEffectInput("texto3")
            break;
        case "4":
            fadeInEffectInput("texto1")
            fadeInEffectInput("texto2")
            fadeInEffectInput("texto3")
            fadeInEffectInput("texto4")
            break;
        default:
            alert("Seleccion invalida");
            break;
    }
})

var tipoServicio = document.getElementById("tipoServicio");
tipoServicio.addEventListener("change", event => {
    var elementSelected = tipoServicio.options[tipoServicio.selectedIndex].value;
    console.log(elementSelected)
    switch(elementSelected){
        case "ida":
            break;
        case "vuelta":
            alert("El domiciliario regresara a la primera direccion")
            break;
        default:
            alert("Seleccion invalida");
            break;
    }
})


// Dias

var fechaComparar = new Date(); 
var fechas = document.getElementById("fInicio");
var igual = false;
var mayor = false;

fechas.addEventListener("change", event => {
    var datosFechas = fechas.valueAsDate;
    var datosDia = datosFechas.getDate();
    datosDia += 1;
    console.log(datosDia);
    var datosMes = datosFechas.getMonth();
    datosMes += 1;
    console.log(datosMes);
    var datosAnno = datosFechas.getFullYear();
    console.log(datosAnno);

    if(datosDia == fechaComparar.getDate() && datosMes == fechaComparar.getMonth()+1 && datosAnno == fechaComparar.getFullYear()){
        console.log("Dia igual")
        igual = true;
        mayor = false;
    }else{
        if(datosDia > fechaComparar.getDate() && datosMes >= fechaComparar.getMonth()+1 && datosAnno >= fechaComparar.getFullYear()){
            console.log("Fecha mayor")
            mayor = true;
            igual = false;
        }
    }
})


// Horas

var datos = document.getElementById("fHoraInicio");
var horaActual = fechaComparar.getHours();
var minutoActual = fechaComparar.getMinutes();
var AmPm = 0;
// if(horaActual == 0){
//     horaActual = 12;
//     AmPm = 1; 
// }

datos.addEventListener("change", event => {

    var datosFecha = datos.valueAsDate;
    var datosReloj = datosFecha.getTime();

    var s = datosReloj;
    var ms = s % 1000;
  	s = (s - ms) / 1000;
  	var secs = s % 60;
  	s = (s - secs) / 60;
  	var mins = s % 60;
  	var hrs = (s - mins) / 60;
    if(hrs == 0){
        hrs = 12;
    }

    strMsg = hrs + ':' + mins;
    console.log(strMsg)
    // horaTotalActual = horaActual + ":" + minutoActual;
    if(igual == true && mayor == false){
        if(hrs < horaActual){
            // if(horaActual == 12 && AmPm == 1){
            //     horaActual = "00";
            //     AmPm = 0;
            // }
            horaTotalActual = horaActual + ":" + minutoActual;
            document.getElementById("fHoraInicio").value = horaTotalActual;
            alert("Digite una hora mayor")
        }
        if(hrs == horaActual && mins < minutoActual){
            horaTotalActual = horaActual + ":" + minutoActual;
            document.getElementById("fHoraInicio").value = horaTotalActual;
            alert("Digite una hora mayor")
        }
    }
})

