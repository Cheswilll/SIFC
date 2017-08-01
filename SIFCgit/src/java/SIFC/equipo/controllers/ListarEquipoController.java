/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.equipo.controllers;

import DAO.EquipoFacadeLocal;
import Entities.Equipo;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "listarEquipoController")
@ViewScoped
public class ListarEquipoController implements Serializable{

    @EJB
    private EquipoFacadeLocal efl;
    
    private List<Equipo> categoria;
    private List<Equipo> equipos;
    
    public ListarEquipoController() {
    }

    public EquipoFacadeLocal getEfl() {
        return efl;
    }

    public void setEfl(EquipoFacadeLocal efl) {
        this.efl = efl;
    }
    
    
    public List<Equipo> listarCategoria(){
        categoria = efl.listarCategoria();
        return categoria;
    }
    
    public List<Equipo> equipos(){
        equipos = efl.findAll();
        return equipos;
    }
    
    
}
