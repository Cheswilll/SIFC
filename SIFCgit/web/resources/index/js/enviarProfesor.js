function enviarProfesor() {
    var tname, lastname, tmail, tphone, tadress, tcode, tspecial, pass, cpass;

    tname = document.getElementById("nombre_profesor").value;
    tlastname = document.getElementById("apellidos_profesor").value;
    tmail = document.getElementById("correo_profesor").value;
    tphone = document.getElementById("telefono_profesor").value;
    tadress = document.getElementById("direccion_profesor").value;
    tcode = document.getElementById("codigo_c_profesor").value;
    tspecial = document.getElementById("especialidad").value;
    pass = document.getElementById("password_profesor").value;
    cpass = document.getElementById("c_password_profesor").value;

    if (tname === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Nombres",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (tlastname === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Apellidos",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (tmail === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Correo electrónico",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (!/\w+@\w+\.+[a-z]/.test(tmail)) {
        swal({
            title: "¡Error!",
            text: "Debe ingresar una dirección de correo electrónico válida",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (tphone === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Teléfono",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (isNaN(tphone)) {
        swal({
            title: "¡Error!",
            text: "Debe ingresar un número de teléfono válido",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (tadress === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Dirección",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (tcode === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Código del carné",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (isNaN(tcode)) {
        swal({
            title: "¡Error!",
            text: "Debe ingresar un código válido",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (tcode.length >= 5 || tcode.length <= 3) {
        swal({
            title: "¡Error!",
            text: "Invalido. El código debe tener 4 números",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (tspecial == null || tspecial == 0) {
        swal({
            title: "¡Error!",
            text: "Debe seleccionar una especialidad",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (pass === "") {
        swal({
            title: "¡Error!",
            text: "Por favor llene el campo Contraseña",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (cpass === "") {
        swal({
            title: "¡Error!",
            text: "Por favor llene el campo Confirmar contraseña",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (cpass != pass) {
        swal({
            title: "¡Error!",
            text: "Las contraseñas no coincide, intentelo de nuevo por favor",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
}