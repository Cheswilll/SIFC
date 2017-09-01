/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.CodigoValidacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cheswill
 */
@Local
public interface CodigoValidacionFacadeLocal {

    void create(CodigoValidacion codigoValidacion);

    void edit(CodigoValidacion codigoValidacion);

    void remove(CodigoValidacion codigoValidacion);

    CodigoValidacion find(Object id);

    List<CodigoValidacion> findAll();

    List<CodigoValidacion> findRange(int[] range);

    int count();
    
    CodigoValidacion findByUsuario (Long documento);
    
}
