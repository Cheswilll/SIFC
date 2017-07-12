function enviarRegistro() {

    var name, lastname, mail, phone, adress, locality, neighboard, pass, passconfirm;

    name = document.getElementById("nombres_aspirante").value;
    lastname = document.getElementById("apellidos_aspirante").value;
    mail = document.getElementById("correo_aspirante").value;
    phone = document.getElementById("telefono_aspirante").value;
    adress = document.getElementById("direccion_aspirante").value;
    locality = document.getElementById("localidad_aspirante").value;
    neighboard = document.getElementById("barrio_aspirante").value;
    pass = document.getElementById("contraseña_aspirante").value;
    passconfirm = document.getElementById("confirmarpass_aspirante").value;

    if (name === "") {
        swal({
            title: "¡Error!",
            text: "Debe llenar el campo Nombres",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (lastname === "") {
        swal({
            title: "¡Error!",
            text: "Debe llenar el campo Apellidos",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (mail === "") {
        swal({
            title: "¡Error!",
            text: "Debe llenar el campo Correo Electrónico",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (!/\w+@\w+\.+[a-z]/.test(mail)) {
        swal({
            title: "¡Error!",
            text: "Debe ingresar una dirección de correo electrónico válida",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (phone === "") {
        swal({
            title: "¡Error!",
            text: "Debe llenar el campo Teléfono",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (isNaN(phone)) {
        swal({
            title: "¡Error!",
            text: "Debe ingresar un número de teléfono.",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (adress === "") {
        swal({
            title: "¡Error!",
            text: "Debe llenar el campo Dirección",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (locality === "") {
        swal({
            title: "¡Error!",
            text: "Debe llenar el campo Localidad",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (neighboard === "") {
        swal({
            title: "¡Error!",
            text: "Debe llenar el campo Barrio",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (pass === "") {
        swal({
            title: "¡Error!",
            text: "Por favor escriba su contraseña",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (passconfirm === "") {
        swal({
            title: "¡Error!",
            text: "Escriba la confirmación de su contraseña",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (passconfirm != pass) {
        swal({
            title: "¡Error!",
            text: "Las contraseñas no coinciden. Inténtelo de nuevo",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
}


