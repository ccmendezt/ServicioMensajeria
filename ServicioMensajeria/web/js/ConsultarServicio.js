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

var tipoConsultaS = document.getElementById("tipoConsultaS");
tipoConsultaS.addEventListener("change", event => {
    var elementSelected = tipoConsultaS.options[tipoConsultaS.selectedIndex].value;
    console.log(elementSelected)
    switch(elementSelected){
        case "0":
            fadeOutEffectInput("texto1")
            fadeOutEffectInput("texto2")
            fadeOutEffectInput("texto3")
            break;
        case "1":
            fadeOutEffectInput("texto2")
            fadeOutEffectInput("texto3")

            fadeInEffectInput("texto1")
            break;
        case "2":
            fadeOutEffectInput("texto1")
            fadeOutEffectInput("texto3")

            fadeInEffectInput("texto2")
            break;
        case "3":
            fadeOutEffectInput("texto1")
            fadeOutEffectInput("texto2")

            fadeInEffectInput("texto3")
            break;
        default:
            alert("Seleccion invalida");
            break;
    }
})