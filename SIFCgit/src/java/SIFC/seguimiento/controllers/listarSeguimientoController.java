/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.seguimiento.controllers;

import DAO.SeguimientoFacadeLocal;
import Entities.Seguimiento;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "listarSeguimientoController")
@ViewScoped
public class listarSeguimientoController implements Serializable{

    @EJB
    private SeguimientoFacadeLocal sfl;
    
    private List<Seguimiento> seguimientos;
    
    
    public listarSeguimientoController() {
    }
    
    @PostConstruct
    public void init(){
    seguimientos = sfl.seguimeintosPorProfesor();
    }

    public SeguimientoFacadeLocal getSfl() {
        return sfl;
    }

    public void setSfl(SeguimientoFacadeLocal sfl) {
        this.sfl = sfl;
    }

    public List<Seguimiento> getSeguimientos() {
        return seguimientos;
    }

    public void setSeguimientos(List<Seguimiento> seguimientos) {
        this.seguimientos = seguimientos;
    }
    
    
}
