/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.login.controllers;

import DAO.PersonaFacadeLocal;
import Entities.Persona;
import Entities.Rol;
import SIFC.util.MessageUtil;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ismael
 */
@Stateless
public class SessionRule {

    @EJB
    private PersonaFacadeLocal pfl;

    public Persona iniciar(Long noidentificacion, String contraseña) {
        Persona p = null;
        if (noidentificacion != null && noidentificacion > 0
                && contraseña != null && contraseña.length() > 0) {
            p = pfl.login(noidentificacion, contraseña);
            if (p != null) {
                if (p.getIdEstado() == 2) {
                    p = null;
                    MessageUtil.enviarMensajeErrorGlobal(
                            "Usuario bloqueado",
                            "Contacte al administrador par que solucione el incoveniente.");

                }
            } else {
                MessageUtil.enviarMensajeErrorGlobal(
                        "Datos incorrectos",
                        "Documento y/o clave invalidos");
            }
        } else {
            MessageUtil.enviarMensajeErrorGlobal(
                    "Datos obligatorios",
                    "Documento y/o clave son necesarios para iniciar sesión");
        }
        return p;
    }

    public Rol validarRol(Persona p) {
        Rol r = null;
        if (p.getRoles() != null && p.getRoles().size() > 0) {
            r = p.getRoles().get(0);
        } else {
            MessageUtil.enviarMensajeErrorGlobal(
                    "Rol no asignado",
                    "Debe esperar a que se le asigne un rol dentro del sistema");
        }
        return r;
    }

}
