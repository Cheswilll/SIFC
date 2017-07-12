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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "torneos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Torneo.findAll", query = "SELECT t FROM Torneo t")
    , @NamedQuery(name = "Torneo.findByIdTorneo", query = "SELECT t FROM Torneo t WHERE t.idTorneo = :idTorneo")
    , @NamedQuery(name = "Torneo.findByLugarTorneo", query = "SELECT t FROM Torneo t WHERE t.lugarTorneo = :lugarTorneo")
    , @NamedQuery(name = "Torneo.findByDuracion", query = "SELECT t FROM Torneo t WHERE t.duracion = :duracion")})
public class Torneo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTorneo")
    private Integer idTorneo;
    @Size(max = 45)
    @Column(name = "lugarTorneo")
    private String lugarTorneo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "duracion")
    private String duracion;
    @JoinColumn(name = "idTipoTorneo", referencedColumnName = "idTipoTorneo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoTorneo idTipoTorneo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTorneo", fetch = FetchType.LAZY)
    private List<Partido> partidoList;

    public Torneo() {
    }

    public Torneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Torneo(Integer idTorneo, String duracion) {
        this.idTorneo = idTorneo;
        this.duracion = duracion;
    }

    public Integer getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getLugarTorneo() {
        return lugarTorneo;
    }

    public void setLugarTorneo(String lugarTorneo) {
        this.lugarTorneo = lugarTorneo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public TipoTorneo getIdTipoTorneo() {
        return idTipoTorneo;
    }

    public void setIdTipoTorneo(TipoTorneo idTipoTorneo) {
        this.idTipoTorneo = idTipoTorneo;
    }

    @XmlTransient
    public List<Partido> getPartidoList() {
        return partidoList;
    }

    public void setPartidoList(List<Partido> partidoList) {
        this.partidoList = partidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTorneo != null ? idTorneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Torneo)) {
            return false;
        }
        Torneo other = (Torneo) object;
        if ((this.idTorneo == null && other.idTorneo != null) || (this.idTorneo != null && !this.idTorneo.equals(other.idTorneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Torneo[ idTorneo=" + idTorneo + " ]";
    }
    
}
