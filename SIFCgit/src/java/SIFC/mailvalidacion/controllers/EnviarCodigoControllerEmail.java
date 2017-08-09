/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.mailvalidacion.controllers;


import SIFC.mail.*;
import SIFC.util.EnviarMail;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


/**
 *
 * @author Ruben
 */
@Named(value = "controllerCodigoValdacionEmail")
@RequestScoped
public class EnviarCodigoControllerEmail{
    
    private String nombresyAp;
    private String codigoValidacion;
    private String telefono;
    private String email;
    private String asunto;
    private String mensaje;
 
    /**
     * Creates a new instance of ControllerEmail
     */
    public EnviarCodigoControllerEmail() {
    }
    

    public String getNombresyAp() {
        return nombresyAp;
    }

    public void setNombresyAp(String nombresyAp) {
        this.nombresyAp = nombresyAp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }
    
    
    
    public void enviarMensaje(){
    
      EnviarCodigoValidacionMail enviarMail= new EnviarCodigoValidacionMail(nombresyAp, codigoValidacion,"sifccatepillarmotor@gmail.com", "sistemadeinformacion", email);
      enviarMail.enviarAnswer();
    }
}
