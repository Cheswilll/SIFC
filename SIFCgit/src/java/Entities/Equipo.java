/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cheswill
 */
@Entity
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByIdAsignacion", query = "SELECT e FROM Equipo e WHERE e.idAsignacion = :idAsignacion")
    , @NamedQuery(name = "Equipo.findByCodigoEquipo", query = "SELECT e FROM Equipo e WHERE e.codigoEquipo = :codigoEquipo")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAsignacion")
    private Integer idAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoEquipo")
    private int codigoEquipo;
    @JoinColumn(name = "categoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoria;
    @JoinColumn(name = "noIdentificacionJugador", referencedColumnName = "noIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona noIdentificacionJugador;
    @JoinColumn(name = "noIdentificacionnProfesor", referencedColumnName = "noIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona noIdentificacionnProfesor;

    public Equipo() {
    }

    public Equipo(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Equipo(Integer idAsignacion, int codigoEquipo) {
        this.idAsignacion = idAsignacion;
        this.codigoEquipo = codigoEquipo;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public int getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(int codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Persona getNoIdentificacionJugador() {
        return noIdentificacionJugador;
    }

    public void setNoIdentificacionJugador(Persona noIdentificacionJugador) {
        this.noIdentificacionJugador = noIdentificacionJugador;
    }

    public Persona getNoIdentificacionnProfesor() {
        return noIdentificacionnProfesor;
    }

    public void setNoIdentificacionnProfesor(Persona noIdentificacionnProfesor) {
        this.noIdentificacionnProfesor = noIdentificacionnProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Equipo[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
