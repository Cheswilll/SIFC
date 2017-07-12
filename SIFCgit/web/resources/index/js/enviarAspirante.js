function EnviarAspirante() {
    var usuario = $('#usuario').val();
    var password = $('#passwordinput').val();
    if (usuario == "" && password == "") {
        swal({
            title: "¡Error!",
            text: "Por favor ingrese sus datos",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
    } else if (usuario != "aspirante" && usuario != "administrador" && usuario != "jugador" && usuario != "profesor"
            && password != "12345678" && password != "12341234" && password != "11111111" && password != "22222222") {
        swal({
            title: "¡Error!",
            text: "El usuario no se encuentra registrado. Verifique los datos ingresados.",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
    }
    /*Validación aspirante */
    if (usuario == "aspirante" && password == "12345678") {
        window.location = 'aspirante.html';
        swal('¡Bienvenido!');
    } else if (usuario != "aspirante" && password == "12345678") {
        swal({
            title: "¡Error!",
            text: "Usuario incorrecto. Verifique la información ingresada",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
    } else if (usuario == "aspirante" && password != "12345678") {
        swal({
            title: "¡Error!",
            text: "Contraseña incorrecta. Verifique la información ingresada",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
    }
    /*Validación aspirante */

    /*Validación administrador */
    if (usuario == "administrador" && password == "12341234") {
        window.location = 'admin.html';
        swal('¡Bienvenido!');
    } else if (usuario != "administrador" && password == "12341234") {
        swal({
            title: "¡Error!",
            text: "Usuario incorrecto. Verifique la información ingresada",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
    } else if (usuario == "administrador" && password != "12341234") {
        swal({
            title: "¡Error!",
            text: "Contraseña incorrecta. Verifique la información ingresada",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
    }

    /*Validación administrador */

    /*Validación jugador */
    if (usuario == "jugador" && password == "11111111") {
        window.location = 'jugador.html';
        swal('¡Bienvenido!');
    } else if (usuario != "jugador" && password == "11111111") {
        swal({
            title: "¡Error!",
            text: "Usuario incorrecto. Verifique la información ingresada",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
    } else if (usuario == "jugador" && password != "11111111") {
        swal({
            title: "¡Error!",
            text: "Contraseña incorrecta. Verifique la información ingresada",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
    }

    /*Validación jugador */

    /*Validación profesor */
    if (usuario == "profesor" && password == "22222222") {
        window.location = 'profe.html';
        swal('¡Bienvenido!');
    } else if (usuario != "profesor" && password == "22222222") {
        swal({
            title: "¡Error!",
            text: "Usuario incorrecto. Verifique la información ingresada",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
    } else if (usuario == "profesor" && password != "22222222") {
        swal({
            title: "¡Error!",
            text: "Contraseña incorrecta. Verifique la información ingresada",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
    }

    /*Validación profesor */
}
