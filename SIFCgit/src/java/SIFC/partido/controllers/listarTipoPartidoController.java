/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.partido.controllers;

import DAO.TipoPartidoFacadeLocal;
import Entities.TipoPartido;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "listarTipoPartidoController")
@RequestScoped
public class listarTipoPartidoController {

    @EJB
    private TipoPartidoFacadeLocal tpfl;
    
    private List<TipoPartido> tiposPartidos;
    
    public listarTipoPartidoController() {
    }
    
    @PostConstruct
    public void init(){
    tiposPartidos = tpfl.findAll();
    }

    public List<TipoPartido> getTiposPartidos() {
        return tiposPartidos;
    }
    
    
}
