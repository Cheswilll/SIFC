/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.codigosvalidacion.controllers;

import DAO.CodigoValidacionFacadeLocal;
import Entities.CodigoValidacion;
import SIFC.login.controllers.SessionController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author cheswill
 */
@Named(value = "registrarCodigoController")
@RequestScoped
public class RegistrarCodigoController  implements Serializable{

    /**
     * Creates a new instance of RegistrarCodigoController
     */
    @EJB
    private CodigoValidacionFacadeLocal cvfl;
    private CodigoValidacion nuevoCodigo; 
    
    @Inject
    private SessionController sc;
    
    public RegistrarCodigoController() {
    }

    public CodigoValidacionFacadeLocal getCvfl() {
        return cvfl;
    }

    public void setCvfl(CodigoValidacionFacadeLocal cvfl) {
        this.cvfl = cvfl;
    }

    public CodigoValidacion getNuevoCodigo() {
        return nuevoCodigo;
    }

    public void setNuevoCodigo(CodigoValidacion nuevoCodigo) {
        this.nuevoCodigo = nuevoCodigo;
    }
    
    
    @PostConstruct
    private void init(){
        nuevoCodigo = new CodigoValidacion();
    }
    
    public void registrarCodigo(){
        if (sc.inicioSesion()) {
            nuevoCodigo.setNoIdentificacionPersona(sc.getPersona());
            cvfl.create(nuevoCodigo);
        }else{
            System.out.println("Ha ocurrido un error al registrar el codigo");
        }
        init();
    }
    
}
