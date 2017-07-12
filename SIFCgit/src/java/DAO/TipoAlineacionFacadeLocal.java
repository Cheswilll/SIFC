/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.TipoAlineacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cheswill
 */
@Local
public interface TipoAlineacionFacadeLocal {

    void create(TipoAlineacion tipoAlineacion);

    void edit(TipoAlineacion tipoAlineacion);

    void remove(TipoAlineacion tipoAlineacion);

    TipoAlineacion find(Object id);

    List<TipoAlineacion> findAll();

    List<TipoAlineacion> findRange(int[] range);

    int count();
    
}
