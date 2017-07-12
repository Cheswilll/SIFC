/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cheswill
 */
@Entity
@Table(name = "tiposalineaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAlineacion.findAll", query = "SELECT t FROM TipoAlineacion t")
    , @NamedQuery(name = "TipoAlineacion.findByIdTipoAlineacion", query = "SELECT t FROM TipoAlineacion t WHERE t.idTipoAlineacion = :idTipoAlineacion")
    , @NamedQuery(name = "TipoAlineacion.findByNombreAlineacion", query = "SELECT t FROM TipoAlineacion t WHERE t.nombreAlineacion = :nombreAlineacion")})
public class TipoAlineacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoAlineacion")
    private Integer idTipoAlineacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreAlineacion")
    private String nombreAlineacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoAlineacion", fetch = FetchType.LAZY)
    private List<Partido> partidos;

    public TipoAlineacion() {
    }

    public TipoAlineacion(Integer idTipoAlineacion) {
        this.idTipoAlineacion = idTipoAlineacion;
    }

    public TipoAlineacion(Integer idTipoAlineacion, String nombreAlineacion) {
        this.idTipoAlineacion = idTipoAlineacion;
        this.nombreAlineacion = nombreAlineacion;
    }

    public Integer getIdTipoAlineacion() {
        return idTipoAlineacion;
    }

    public void setIdTipoAlineacion(Integer idTipoAlineacion) {
        this.idTipoAlineacion = idTipoAlineacion;
    }

    public String getNombreAlineacion() {
        return nombreAlineacion;
    }

    public void setNombreAlineacion(String nombreAlineacion) {
        this.nombreAlineacion = nombreAlineacion;
    }

    @XmlTransient
    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAlineacion != null ? idTipoAlineacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAlineacion)) {
            return false;
        }
        TipoAlineacion other = (TipoAlineacion) object;
        if ((this.idTipoAlineacion == null && other.idTipoAlineacion != null) || (this.idTipoAlineacion != null && !this.idTipoAlineacion.equals(other.idTipoAlineacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TipoAlineacion[ idTipoAlineacion=" + idTipoAlineacion + " ]";
    }
    
}
