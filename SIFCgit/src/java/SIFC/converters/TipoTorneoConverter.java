/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.converters;

import DAO.TipoTorneoFacadeLocal;
import Entities.TipoTorneo;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = TipoTorneo.class, value = "tipoTorneoConverter")
public class TipoTorneoConverter implements Converter{
    
    private TipoTorneoFacadeLocal ttfl;

    public TipoTorneoConverter() {
        ttfl = CDI.current().select(TipoTorneoFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return ttfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof TipoTorneo){
            TipoTorneo tt = (TipoTorneo) value;
            return tt.getIdTipoTorneo().toString();
        }
        return null;
    }
    
}
