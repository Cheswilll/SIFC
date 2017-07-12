/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.converters;


import DAO.LocalidadFacadeLocal;
import Entities.Localidad;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = Localidad.class, value = "localidadConverter")
public class LocalidadConverter implements Converter{
    
    private LocalidadFacadeLocal lfl;

    public LocalidadConverter() {
        lfl = CDI.current().select(LocalidadFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return lfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Localidad){
            Localidad lc = (Localidad) value;
            return lc.getIdLocalidad().toString();
        }
        return null;
    }
    
}
