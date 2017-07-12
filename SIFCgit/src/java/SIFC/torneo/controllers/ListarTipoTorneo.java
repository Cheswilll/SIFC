/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.torneo.controllers;

import DAO.TipoTorneoFacadeLocal;
import Entities.TipoTorneo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cheswill
 */
@Named(value = "listarTipoTorneo")
@RequestScoped
public class ListarTipoTorneo {

    @EJB
    private TipoTorneoFacadeLocal ttfl;
    
    private List<TipoTorneo> tiposDeTorneo;
    
    public ListarTipoTorneo() {
    }
    
    @PostConstruct
    public void init(){
    tiposDeTorneo = ttfl.findAll();
    }

    public List<TipoTorneo> getTiposDeTorneo() {
        return tiposDeTorneo;
    }
    
    
    
}
