/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.partido.controllers;

import DAO.PartidoFacadeLocal;
import Entities.Partido;
import SIFC.login.controllers.SessionController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "registrarPartidoController")
@RequestScoped
public class registrarPartidoController implements Serializable {

    @EJB
    private PartidoFacadeLocal pdfl;

    private Partido nuevoPartido;

    @Inject
    private SessionController sc;

    public PartidoFacadeLocal getPdfl() {
        return pdfl;
    }

    public void setPdfl(PartidoFacadeLocal pdfl) {
        this.pdfl = pdfl;
    }

    public Partido getNuevoPartido() {
        return nuevoPartido;
    }

    public void setNuevoPartido(Partido nuevoPartido) {
        this.nuevoPartido = nuevoPartido;
    }

    public registrarPartidoController() {
    }

    @PostConstruct
    public void init() {
        nuevoPartido = new Partido();
    }

    public void registrarPartido() {
        if (sc.inicioSesion()) {
            nuevoPartido.setNoIdentificacionProfesor(sc.getPersona());
            pdfl.create(nuevoPartido);
        }else{
            System.out.println("Ha ocurrido un error al registrar la plantilla partido");
        }
        init();
    }

}
