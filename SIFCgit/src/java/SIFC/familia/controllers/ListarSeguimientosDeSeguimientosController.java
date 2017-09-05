/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.familia.controllers;

import DAO.SeguimientoFacadeLocal;
import Entities.Seguimiento;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author cheswill
 */
@Named(value = "listarSeguimientosDeSeguimientosController")
@ViewScoped
public class ListarSeguimientosDeSeguimientosController implements Serializable{

    @EJB
    private SeguimientoFacadeLocal sfl;
    
    private List<Seguimiento> seguimientoDeSeguimientos;
            
    public ListarSeguimientosDeSeguimientosController() {
    }
    
    @PostConstruct
    public void init(){
        seguimientoDeSeguimientos = sfl.listarSeguimientosDeSeguimientos();
    }

    public List<Seguimiento> getSeguimientoDeSeguimientos() {
        return seguimientoDeSeguimientos;
    }

    public void setSeguimientoDeSeguimientos(List<Seguimiento> seguimientoDeSeguimientos) {
        this.seguimientoDeSeguimientos = seguimientoDeSeguimientos;
    }
    
    
    
}
