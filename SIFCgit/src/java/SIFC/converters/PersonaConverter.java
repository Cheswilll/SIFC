/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.converters;


import DAO.PersonaFacadeLocal;
import Entities.Persona;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = Persona.class, value = "personaConverter")
public class PersonaConverter implements Converter{
    
    private PersonaFacadeLocal pfl;

    public PersonaConverter() {
        pfl = CDI.current().select(PersonaFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return pfl.find(Long.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Persona){
            Persona p = (Persona) value;
            return p.getNoIdentificacion().toString();
        }
        return null;
    }
    
}
