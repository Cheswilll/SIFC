function EnviarAspirante(){ 
    var usuario = $('#usuario').val(); 
    var password = $('#passwordinput').val();

// *********************** SIEMPRE IMPRIMA TODO PARA IR VIENDO QUE TIENE, QUE CAPTURO *******************************
    console.log(usuario);
    console.log(password);

    if(usuario === "" && password === ""){
        alert('Por favor ingrese sus datos');
    }

    if (usuario === "aspirante" && password === "12345678" ){
        window.location = 'aspirante.xhtml';
            alert('<Bienvenido');
    }else if(usuario !== "aspirante" && password === "12345678"){
        alert('Usuario incorrecto, por favor verifique su usuario');
    }else if(usuario === "aspirante" && password !== "12345678"){
        alert('Contraseña incorrecta, por favor verifique su contraseña');
    }

    if (usuario === "administrador" && password === "12341234"){
        window.location ='admin.xhtml';
        alert('Bienvenido Administrador');
    }
    else if(usuario !== "administrador" && password === "12341234"){
        alert('Usuario incorrecto, por favor verifique su usuario');
    }else if (usuario === "administrador" && password !== "12341234"){
           alert('Contraseña incorrecta, por favor verifique su contraseña');    
    }

    if (usuario === "jugador" && password === "11111111"){
        window.location ='jugador.xhtml';
        alert('Bienvenido');
    }
    else if(usuario !== "jugador" && password === "11111111"){
        alert('Usuario incorrecto, por favor verifique su usuario');
    }else if (usuario === "jugador" && password !== "11111111"){
           alert('Contraseña incorrecta, por favor verifique su contraseña');    
    }


    if (usuario === "profesor" && password === "22222222"){
        window.location = "/profesor.xhtml";
        alert('Bienvenido Profesor');
    }
    else if(usuario !== "profesor" && password === "22222222"){
        alert('Usuario incorrecto, por favor verifique su usuario');
    }else if (usuario === "profesor" && password !== "22222222"){
           alert('Contraseña incorrecta, por favor verifique su contraseña');    
    }
    if(usuario !== "profesor" && usuario !== "aspirante" && usuario !== "administrador" && usuario !== "jugador" && password !== "12341234" && password !== "12345678" && password !== "11111111" && password !== "22222222"){
        alert("Datos incorrectos, por favor verifique las información registrada.");
    }


    }

