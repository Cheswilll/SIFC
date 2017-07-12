/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.TipoTorneo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cheswill
 */
@Local
public interface TipoTorneoFacadeLocal {

    void create(TipoTorneo tipoTorneo);

    void edit(TipoTorneo tipoTorneo);

    void remove(TipoTorneo tipoTorneo);

    TipoTorneo find(Object id);

    List<TipoTorneo> findAll();

    List<TipoTorneo> findRange(int[] range);

    int count();
    
}
