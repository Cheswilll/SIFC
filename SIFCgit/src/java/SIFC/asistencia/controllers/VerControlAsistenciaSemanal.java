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
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author cheswill
 */
@Named(value = "verControlAsistenciaSemanal")
@SessionScoped
public class VerControlAsistenciaSemanal implements Serializable{
    

    @Inject
    private SessionController sc;     
    
    @EJB
    private AsistenciaFacadeLocal afl;
    
    private Asistencia asistencia;
    
    private List<Asistencia> asistencias;
    
    private Long noidJug;
    
    
    
    private Integer asistenciaA;
    
    public VerControlAsistenciaSemanal() {
    }
    
    
    public String preConsultar(Asistencia a){
        setAsistencia(a);
        noidJug = getAsistencia().getNoIdentificacionJugador().getNoIdentificacion();
        System.out.println("No id jug: "+noidJug);
        System.out.println("Con get"+" "+getNoidJug());
        asistencias = afl.listarAsistenciasPorJugador(noidJug);
        System.out.println(asistencias);
        
        System.out.println("Aqui imprime: "+getNoidJug());
        asistenciaA = afl.listarAsistenciasA(getNoidJug());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+getNoidJug());
        return "/sinproteccion/profesor/verControlAsistencia.xhtml?faces-redirect=true";
    }
    
    

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

    public Long getNoidJug() {
        return noidJug;
    }

    public void setNoidJug(Long noidJug) {
        this.noidJug = noidJug;
    }

    public Integer getAsistenciaA() {
        return asistenciaA;
    }

    public void setAsistenciaA(Integer asistenciaA) {
        this.asistenciaA = asistenciaA;
    }
    
    
    
    
    
    
    
    
    
    @PostConstruct
    public void init(){
        System.out.println("Get asistencia: "+getAsistencia());
        System.out.println("Imprimiendo post: "+getNoidJug());
        asistencias = afl.listarAsistenciasPorJugador(getNoidJug());
    }
    
    
    
    
    
    
    

    
    
}
