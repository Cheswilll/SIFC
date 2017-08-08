/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.asistencia.controllers;

import DAO.AsistenciaFacadeLocal;
import Entities.Asistencia;
import Entities.Persona;
import SIFC.login.controllers.SessionController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Cheswill
 */
@Named(value = "registrarAsistenciaController")
@RequestScoped
public class RegistrarAsistenciaController implements Serializable {

    @EJB
    private AsistenciaFacadeLocal afl;
    private Asistencia asistenciaNueva;

    private Persona persona;

    @Inject
    private SessionController sc;

    public RegistrarAsistenciaController() {
    }

    public AsistenciaFacadeLocal getAfl() {
        return afl;
    }

    public void setAfl(AsistenciaFacadeLocal afl) {
        this.afl = afl;
    }

    public Asistencia getAsistenciaNueva() {
        return asistenciaNueva;
    }

    public void setAsistenciaNueva(Asistencia asistenciaNueva) {
        this.asistenciaNueva = asistenciaNueva;
    }

    @PostConstruct
    public void init() {
        asistenciaNueva = new Asistencia();
    }

    public void registrarAsistencia() {
        if (sc.inicioSesion()) {
            asistenciaNueva.setNoIdentificacionProfesor(sc.getPersona());
            afl.create(asistenciaNueva);
        }else{
            System.out.println("Ha ocurrido un error al registrar la asistencia");
        }
        init();
    }

}
