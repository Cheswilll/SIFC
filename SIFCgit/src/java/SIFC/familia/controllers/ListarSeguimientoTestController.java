/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.familia.controllers;

import DAO.TestFisicoFacadeLocal;
import Entities.TestFisico;
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
@Named(value = "listarSeguimientoTestController")
@ViewScoped
public class ListarSeguimientoTestController implements Serializable{

    @EJB
    private TestFisicoFacadeLocal tffl;
    
    private List<TestFisico> seguimientoTestFisicos;
    
    public ListarSeguimientoTestController() {
    }
    
    
    @PostConstruct
    public void init(){
        seguimientoTestFisicos=tffl.listarSeguimientoTestFisico();
        
    }

    public List<TestFisico> getSeguimientoTestFisicos() {
        return seguimientoTestFisicos;
    }

    public void setSeguimientoTestFisicos(List<TestFisico> seguimientoTestFisicos) {
        this.seguimientoTestFisicos = seguimientoTestFisicos;
    }
    
    
}
