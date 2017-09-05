/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.familia.controllers;

import DAO.AsistenciaFacadeLocal;
import Entities.Asistencia;
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
@Named(value = "listarSeguimientoAsistenciasController")
@ViewScoped
public class ListarSeguimientoAsistenciasController implements Serializable{

    
    @EJB
    private AsistenciaFacadeLocal afl;
    
    private Asistencia asistencia;
    private List<Asistencia> seguimientoAsistencias;
    
    
    public ListarSeguimientoAsistenciasController() {
    }

    public AsistenciaFacadeLocal getAfl() {
        return afl;
    }

    public void setAfl(AsistenciaFacadeLocal afl) {
        this.afl = afl;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public List<Asistencia> getSeguimientoAsistencias() {
        return seguimientoAsistencias;
    }

    public void setSeguimientoAsistencias(List<Asistencia> seguimientoAsistencias) {
        this.seguimientoAsistencias = seguimientoAsistencias;
    }

    @PostConstruct
    public void init(){
    seguimientoAsistencias = afl.listarSeguimientoAsistencias();
    }
    
    
}
