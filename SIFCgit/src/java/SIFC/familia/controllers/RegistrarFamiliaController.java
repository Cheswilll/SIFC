/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.familia.controllers;

import DAO.FamiliaFacadeLocal;
import Entities.Familia;
import SIFC.util.MessageUtil;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cheswill
 */
@Named(value = "registrarFamiliaController")
@RequestScoped
public class RegistrarFamiliaController {

    @EJB
    private FamiliaFacadeLocal ffl;
    private Familia familiaNueva;
    
    public RegistrarFamiliaController() {
    }

    public FamiliaFacadeLocal getFfl() {
        return ffl;
    }

    public void setFfl(FamiliaFacadeLocal ffl) {
        this.ffl = ffl;
    }

    public Familia getFamiliaNueva() {
        return familiaNueva;
    }

    public void setFamiliaNueva(Familia familiaNueva) {
        this.familiaNueva = familiaNueva;
    }
    
    @PostConstruct
    public void init(){
        familiaNueva = new Familia();
    }
    
    public void registrarFamilia(){
        if (familiaNueva != null) {
            ffl.create(familiaNueva);
            MessageUtil.enviarMensajeInformacion("form-crear", "Registro exitoso", "El registro se ha completado");
            init();
        }else{
        MessageUtil.enviarMensajeError("form-crear", "Error", "No se han diligenciado datos");
        }
    }
    
}
