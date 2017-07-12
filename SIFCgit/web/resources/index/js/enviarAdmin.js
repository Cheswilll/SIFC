function enviarAdmin() {
    var aname, alastname, amail, aphone, aadress, acode, alocality, apass, aconfirm;
    aname = document.getElementById("nombre_admin").value;
    alastname = document.getElementById("apellidos_admin").value;
    amail = document.getElementById("correo_admin").value;
    aphone = document.getElementById("telefono_admin").value;
    aadress = document.getElementById("direccion_admin").value;
    acode = document.getElementById("codigo_c_admin").value;
    alocality = document.getElementById("localidad_admin").value;
    apass = document.getElementById("password_admin").value;
    aconfirm = document.getElementById("c_password_admin").value;

    if (aname === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Nombres",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (alastname === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Apellidos",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (amail === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Correo electrónico",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (!/\w+@\w+\.+[a-z]/.test(amail)) {
        swal({
            title: "¡Error!",
            text: "Debe ingresar una dirección de correo electrónico válida",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (aphone === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Teléfono",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (isNaN(aphone)) {
        swal({
            title: "¡Error!",
            text: "Debe ingresar un número de teléfono.",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (aadress === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Dirección",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (acode === "") {
        swal({
            title: "¡Error!",
            text: "Por favor llene el campo Código de seguridad",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (isNaN(acode)) {
        swal({
            title: "¡Error!",
            text: "Debe ingresar un código válido",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (acode.length >= 5 || acode.length <= 3) {
        swal({
            title: "¡Error!",
            text: "Invalido. El código debe tener 4 números",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (alocality === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Localidad",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (apass === "") {
        swal({
            title: "¡Error!",
            text: "Por favor complete el campo Contraseña",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (aconfirm === "") {
        swal({
            title: "¡Error!",
            text: "Por favor confirme su contraseña",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
    if (aconfirm != apass) {
        swal({
            title: "¡Error",
            text: "Las contraseñas no coinciden.",
            type: "error",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "75EC32",
        });
        return false;
    }
} 