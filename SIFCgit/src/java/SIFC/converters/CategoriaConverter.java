/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.converters;

import DAO.CategoriaFacadeLocal;
import Entities.Categoria;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = Categoria.class, value = "categoriaConverter")
public class CategoriaConverter implements Converter{
    
    private CategoriaFacadeLocal cfl;

    public CategoriaConverter() {
        cfl = CDI.current().select(CategoriaFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return cfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Categoria){
            Categoria cat = (Categoria) value;
            return cat.getIdCategoria().toString();
        }
        return null;
    }
    
}
