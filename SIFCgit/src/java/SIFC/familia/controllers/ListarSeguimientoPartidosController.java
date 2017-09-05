/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.familia.controllers;

import DAO.PartidoFacadeLocal;
import Entities.Partido;
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
@Named(value = "listarSeguimientoPartidosController")
@ViewScoped
public class ListarSeguimientoPartidosController implements Serializable{

    @EJB
    private PartidoFacadeLocal pfl;
    
    private List<Partido> seguimientoPartidos;
    
    
    public ListarSeguimientoPartidosController() {
    }
    
    @PostConstruct
    public void init(){
     seguimientoPartidos=pfl.findAll();
    }

    public List<Partido> getSeguimientoPartidos() {
        return seguimientoPartidos;
    }

    public void setSeguimientoPartidos(List<Partido> seguimientoPartidos) {
        this.seguimientoPartidos = seguimientoPartidos;
    }
    
    
    
}
