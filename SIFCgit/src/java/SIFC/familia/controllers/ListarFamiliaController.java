/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.familia.controllers;

import DAO.FamiliaFacadeLocal;
import Entities.Familia;
import SIFC.util.MessageUtil;
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
@Named(value = "listarFamiliaController")
@ViewScoped
public class ListarFamiliaController implements Serializable {

    @EJB
    private FamiliaFacadeLocal ffl;

    private Familia familiaSeleccionada;
    private List<Familia> familias;

    public FamiliaFacadeLocal getFfl() {
        return ffl;
    }

    public void setFfl(FamiliaFacadeLocal ffl) {
        this.ffl = ffl;
    }

    public List<Familia> getFamilias() {
        return familias;
    }

    public void setFamilias(List<Familia> familias) {
        this.familias = familias;
    }

    public Familia getFamiliaSeleccionada() {
        return familiaSeleccionada;
    }

    public void setFamiliaSeleccionada(Familia familiaSeleccionada) {
        this.familiaSeleccionada = familiaSeleccionada;
    }

    

    @PostConstruct
    private void init() {
        recargarPersonas();
    }

    public ListarFamiliaController() {
    }

    private void recargarPersonas() {
        familias = ffl.findAll();
    }
    
    public void eliminarFamilia(){
        if (familiaSeleccionada.getId() != null) {
            ffl.remove(familiaSeleccionada);
            recargarPersonas();
        }else{
            MessageUtil.enviarMensajeError(null, "Error", "No se puede eliminar usted mismo");
        }
    }

}
