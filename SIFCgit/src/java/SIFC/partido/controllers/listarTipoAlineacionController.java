/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.partido.controllers;

import DAO.TipoAlineacionFacadeLocal;
import Entities.TipoAlineacion;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "listarTipoAlineacionController")
@RequestScoped
public class listarTipoAlineacionController {

    @EJB
    private TipoAlineacionFacadeLocal tafl;
    
    private List<TipoAlineacion> tiposAlineaciones;
    
    public listarTipoAlineacionController() {
    }
    
    @PostConstruct
    public void init(){
    tiposAlineaciones = tafl.findAll();
    }

    public List<TipoAlineacion> getTiposAlineaciones() {
        return tiposAlineaciones;
    }
    
    
    
}
