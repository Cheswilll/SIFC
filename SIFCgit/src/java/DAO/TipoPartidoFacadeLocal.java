/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.TipoPartido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cheswill
 */
@Local
public interface TipoPartidoFacadeLocal {

    void create(TipoPartido tipoPartido);

    void edit(TipoPartido tipoPartido);

    void remove(TipoPartido tipoPartido);

    TipoPartido find(Object id);

    List<TipoPartido> findAll();

    List<TipoPartido> findRange(int[] range);

    int count();
    
}
