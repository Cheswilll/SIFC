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
@Table(name = "tipostorneos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTorneo.findAll", query = "SELECT t FROM TipoTorneo t")
    , @NamedQuery(name = "TipoTorneo.findByIdTipoTorneo", query = "SELECT t FROM TipoTorneo t WHERE t.idTipoTorneo = :idTipoTorneo")
    , @NamedQuery(name = "TipoTorneo.findByNombreTipoTorneo", query = "SELECT t FROM TipoTorneo t WHERE t.nombreTipoTorneo = :nombreTipoTorneo")})
public class TipoTorneo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoTorneo")
    private Integer idTipoTorneo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreTipoTorneo")
    private String nombreTipoTorneo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTorneo", fetch = FetchType.LAZY)
    private List<Torneo> torneos;

    public TipoTorneo() {
    }

    public TipoTorneo(Integer idTipoTorneo) {
        this.idTipoTorneo = idTipoTorneo;
    }

    public TipoTorneo(Integer idTipoTorneo, String nombreTipoTorneo) {
        this.idTipoTorneo = idTipoTorneo;
        this.nombreTipoTorneo = nombreTipoTorneo;
    }

    public Integer getIdTipoTorneo() {
        return idTipoTorneo;
    }

    public void setIdTipoTorneo(Integer idTipoTorneo) {
        this.idTipoTorneo = idTipoTorneo;
    }

    public String getNombreTipoTorneo() {
        return nombreTipoTorneo;
    }

    public void setNombreTipoTorneo(String nombreTipoTorneo) {
        this.nombreTipoTorneo = nombreTipoTorneo;
    }

    @XmlTransient
    public List<Torneo> getTorneos() {
        return torneos;
    }

    public void setTorneos(List<Torneo> torneos) {
        this.torneos = torneos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTorneo != null ? idTipoTorneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTorneo)) {
            return false;
        }
        TipoTorneo other = (TipoTorneo) object;
        if ((this.idTipoTorneo == null && other.idTipoTorneo != null) || (this.idTipoTorneo != null && !this.idTipoTorneo.equals(other.idTipoTorneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TipoTorneo[ idTipoTorneo=" + idTipoTorneo + " ]";
    }
    
}
