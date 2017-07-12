/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.converters;

import DAO.TorneoFacadeLocal;
import Entities.Torneo;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
    @FacesConverter(forClass = Torneo.class, value = "torneoConverter")
public class TorneoConverter implements Converter{
    
    private TorneoFacadeLocal trfl;

    public TorneoConverter() {
        trfl = CDI.current().select(TorneoFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return trfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Torneo){
            Torneo trn = (Torneo) value;
            return trn.getIdTorneo().toString();
        }
        return null;
    }
    
}
