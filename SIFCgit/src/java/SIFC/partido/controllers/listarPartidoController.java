/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.partido.controllers;

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
 * @author Cheswill
 */
@Named(value = "listarPartidoController")
@ViewScoped
public class listarPartidoController  implements Serializable{

    @EJB
    private PartidoFacadeLocal pofl;
    
    private List<Partido> partidos;
    
    public listarPartidoController() {
    }
    
    @PostConstruct
    public void init(){
    partidos = pofl.findAll();
    }

    public PartidoFacadeLocal getPofl() {
        return pofl;
    }

    public void setPofl(PartidoFacadeLocal pofl) {
        this.pofl = pofl;
    }
    
    public List<Partido> listarPartidosPorProfesor(){
    partidos = pofl.listarPartidosPorProfesor();
    return partidos;
    }
}
