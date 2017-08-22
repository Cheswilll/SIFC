/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.asistencia.controllers;

import DAO.AsistenciaFacadeLocal;
import Entities.Asistencia;
import SIFC.login.controllers.SessionController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cheswill
 */
@Named(value = "verControlAsistenciaSemanal")
@RequestScoped
public class VerControlAsistenciaSemanal implements Serializable{
    

    @Inject
    private SessionController sc;     
    
    @EJB
    private AsistenciaFacadeLocal afl;
    
    private Asistencia asistencia;
    
    private List<Asistencia> asistencias;
    

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }
    
    
    
    public VerControlAsistenciaSemanal() {
    }
    
    
    
    
    
    public String preConsultar(Asistencia a){
        setAsistencia(a);
        return "/sinproteccion/profesor/verControlAsistencia.xhtml?faces-redirect=true";
    }
    
    @PostConstruct
    public void init(){
        afl.find(getAsistencia());
        asistencias = afl.listarAsistenciasPorJugador(getAsistencia().getNoIdentificacionJugador().getNoIdentificacion());
    }

    
    
}
