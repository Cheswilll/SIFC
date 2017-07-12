/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.TipoDeSangre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cheswill
 */
@Local
public interface TipoDeSangreFacadeLocal {

    void create(TipoDeSangre tiposDeSangre);

    void edit(TipoDeSangre tiposDeSangre);

    void remove(TipoDeSangre tiposDeSangre);

    TipoDeSangre find(Object id);

    List<TipoDeSangre> findAll();

    List<TipoDeSangre> findRange(int[] range);

    int count();
    
}
