/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.converters;

import DAO.TipoPartidoFacadeLocal;
import Entities.TipoPartido;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = TipoPartido.class, value = "tipoPartidoConverter")
public class TipoPartidoConverter implements Converter{
    
    private TipoPartidoFacadeLocal tpfl;

    public TipoPartidoConverter() {
        tpfl = CDI.current().select(TipoPartidoFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return tpfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof TipoPartido){
            TipoPartido tp = (TipoPartido) value;
            return tp.getIdTipoPartido().toString();
        }
        return null;
    }
    
}
