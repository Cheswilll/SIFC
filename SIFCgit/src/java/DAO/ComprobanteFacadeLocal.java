/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Comprobante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cheswill
 */
@Local
public interface ComprobanteFacadeLocal {

    void create(Comprobante comprobante);

    void edit(Comprobante comprobante);

    void remove(Comprobante comprobante);

    Comprobante find(Object id);

    List<Comprobante> findAll();

    List<Comprobante> findRange(int[] range);

    int count();
    
}
