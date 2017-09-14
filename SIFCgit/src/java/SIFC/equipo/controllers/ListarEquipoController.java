/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.equipo.controllers;

import DAO.EquipoFacadeLocal;
import DAO.PersonaFacadeLocal;
import Entities.Equipo;
import Entities.Persona;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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

    @EJB 
    private PersonaFacadeLocal pfl;
    
    private List<Equipo> categoria;
    private List<Equipo> equipos;
    
    private List<Persona> jugadoresCategoria;
    
    public ListarEquipoController() {
    }

    public EquipoFacadeLocal getEfl() {
        return efl;
    }

    public void setEfl(EquipoFacadeLocal efl) {
        this.efl = efl;
    }

    public List<Equipo> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Equipo> categoria) {
        this.categoria = categoria;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Persona> getJugadoresCategoria() {
        return jugadoresCategoria;
    }

    public void setJugadoresCategoria(List<Persona> jugadoresCategoria) {
        this.jugadoresCategoria = jugadoresCategoria;
    }
    
    
    
    public List<Equipo> listarCategoria(){
        categoria = efl.listarCategoria();
        return categoria;
    }
    
    public List<Equipo> equipos(){
        equipos = efl.findAll();
        return equipos;
    }
    
    @PostConstruct
    public void init(){
        listarCategoria();
        equipos();
        jugadoresCategoria = pfl.listarJugadoresPorProfesor();
    }
    
    
}
