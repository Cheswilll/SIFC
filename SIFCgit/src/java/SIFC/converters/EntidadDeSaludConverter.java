/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.converters;

import DAO.EntidadDeSaludFacadeLocal;
import Entities.EntidadDeSalud;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = EntidadDeSalud.class, value = "entidadDeSaludConverter")
public class EntidadDeSaludConverter implements Converter{
    
    private EntidadDeSaludFacadeLocal edsfl;

    public EntidadDeSaludConverter() {
        edsfl = CDI.current().select(EntidadDeSaludFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return edsfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof EntidadDeSalud){
            EntidadDeSalud eds = (EntidadDeSalud) value;
            return eds.getIdEntidad().toString();
        }
        return null;
    }
    
}
