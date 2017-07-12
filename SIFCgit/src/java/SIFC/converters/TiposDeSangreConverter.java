/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.converters;

import DAO.TipoDeSangreFacadeLocal;
import Entities.TipoDeSangre;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = TipoDeSangre.class, value = "tipoDeSangreConverter")
public class TiposDeSangreConverter implements Converter{
    
    private TipoDeSangreFacadeLocal tsfl;

    public TiposDeSangreConverter() {
        tsfl = CDI.current().select(TipoDeSangreFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return tsfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof TipoDeSangre){
            TipoDeSangre tds = (TipoDeSangre) value;
            return tds.getIdRh().toString();
        }
        return null;
    }
    
}
