/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.converters;

import DAO.TipoDocumentoFacadeLocal;
import DAO.TipoDocumentoFacade;
import Entities.TipoDocumento;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = TipoDocumento.class, value = "tipoDocumentoConverter")
public class TipoDocumentoConverter implements Converter{
    
    private TipoDocumentoFacadeLocal tdfl;

    public TipoDocumentoConverter() {
        tdfl = CDI.current().select(TipoDocumentoFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return tdfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof TipoDocumento){
            TipoDocumento td = (TipoDocumento) value;
            return td.getIdTipoDocumento().toString();
        }
        return null;
    }
    
}
