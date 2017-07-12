/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.converters;

import DAO.TipoAlineacionFacadeLocal;
import Entities.TipoAlineacion;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = TipoAlineacion.class, value = "tipoAlineacionConverter")
public class TipoAlineacionConverter implements Converter{
    
    private TipoAlineacionFacadeLocal tafl;

    public TipoAlineacionConverter() {
        tafl = CDI.current().select(TipoAlineacionFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return tafl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof TipoAlineacion){
            TipoAlineacion ta = (TipoAlineacion) value;
            return ta.getIdTipoAlineacion().toString();
        }
        return null;
    }
    
}
