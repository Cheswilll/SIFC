/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.persona.controllers;

import DAO.TipoDocumentoFacadeLocal;
import Entities.TipoDocumento;
import SIFC.util.MessageUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author cheswill
 */
@Named(value = "tipoDocumentoController")
@RequestScoped
public class TipoDocumentoController {

    @EJB
    private TipoDocumentoFacadeLocal tdfl;
    private List<TipoDocumento> tiposDeDocumentos;
    
    
    public TipoDocumentoController() {
    }
    
    @PostConstruct
    public void init(){
        tiposDeDocumentos = tdfl.findAll();
    }

    public List<TipoDocumento> getTiposDeDocumentos() {
        return tiposDeDocumentos;
    }
    
    public SelectItem[] getItemsAvailableSelectOne() {
        return MessageUtil.getSelectItems(tdfl.findAll(), true);
    }
    
    
}
