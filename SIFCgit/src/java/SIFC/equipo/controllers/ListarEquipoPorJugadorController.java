/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.equipo.controllers;

import DAO.EquipoFacadeLocal;
import DAO.PartidoFacadeLocal;
import Entities.Partido;
import SIFC.login.controllers.SessionController;
import com.mysql.jdbc.Connection;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author cheswill
 */
@Named(value = "listarEquipoPorJugadorController")
@SessionScoped
public class ListarEquipoPorJugadorController implements Serializable {

    @EJB
    private PartidoFacadeLocal pfl;

    @EJB
    private EquipoFacadeLocal efl;
    
    @Inject
    private SessionController sc;

    private List<Partido> partidosPorJugador;

    private Integer cod;

    public ListarEquipoPorJugadorController() {
    }

    @PostConstruct
    public void init() {
        consultarCod();
        partidosPorJugador = pfl.listarPartidosPorEquipo(cod);
        System.out.println("Codigo del equipo" + getCod());
    }

    public List<Partido> getPartidosPorJugador() {
        return partidosPorJugador;
    }

    public void setPartidosPorJugador(List<Partido> partidosPorJugador) {
        this.partidosPorJugador = partidosPorJugador;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public void consultarCod() {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sifcnuevo", "administrador", "123456789");

            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery("SELECT equipos.codigoEquipo as cod FROM personas JOIN equipos "
                    + "ON personas.noIdentificacion = equipos.noIdentificacionJugador "
                    + "AND equipos.noIdentificacionJugador= " + sc.getPersona().getNoIdentificacion() + " ;");

            while (resultado.next()) {
                cod = resultado.getInt("cod");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
