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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cheswill
 */
@Entity
@Table(name = "familias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familias.findAll", query = "SELECT f FROM Familia f")
    , @NamedQuery(name = "Familias.findById", query = "SELECT f FROM Familia f WHERE f.id = :id")})
public class Familia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "noIdentificacionJugador", referencedColumnName = "noIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona noIdentificacionJugador;
    @JoinColumn(name = "noIdentificacionPadre", referencedColumnName = "noIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona noIdentificacionPadre;

    public Familia() {
    }

    public Familia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getNoIdentificacionJugador() {
        return noIdentificacionJugador;
    }

    public void setNoIdentificacionJugador(Persona noIdentificacionJugador) {
        this.noIdentificacionJugador = noIdentificacionJugador;
    }

    public Persona getNoIdentificacionPadre() {
        return noIdentificacionPadre;
    }

    public void setNoIdentificacionPadre(Persona noIdentificacionPadre) {
        this.noIdentificacionPadre = noIdentificacionPadre;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Familias[ id=" + id + " ]";
    }
    
}
