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
@Table(name = "tipopartido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPartido.findAll", query = "SELECT t FROM TipoPartido t")
    , @NamedQuery(name = "TipoPartido.findByIdTipoPartido", query = "SELECT t FROM TipoPartido t WHERE t.idTipoPartido = :idTipoPartido")
    , @NamedQuery(name = "TipoPartido.findByNombreTipoPartido", query = "SELECT t FROM TipoPartido t WHERE t.nombreTipoPartido = :nombreTipoPartido")})
public class TipoPartido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoPartido")
    private Integer idTipoPartido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreTipoPartido")
    private String nombreTipoPartido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPartido", fetch = FetchType.LAZY)
    private List<Partido> partidos;

    public TipoPartido() {
    }

    public TipoPartido(Integer idTipoPartido) {
        this.idTipoPartido = idTipoPartido;
    }

    public TipoPartido(Integer idTipoPartido, String nombreTipoPartido) {
        this.idTipoPartido = idTipoPartido;
        this.nombreTipoPartido = nombreTipoPartido;
    }

    public Integer getIdTipoPartido() {
        return idTipoPartido;
    }

    public void setIdTipoPartido(Integer idTipoPartido) {
        this.idTipoPartido = idTipoPartido;
    }

    public String getNombreTipoPartido() {
        return nombreTipoPartido;
    }

    public void setNombreTipoPartido(String nombreTipoPartido) {
        this.nombreTipoPartido = nombreTipoPartido;
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
        hash += (idTipoPartido != null ? idTipoPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPartido)) {
            return false;
        }
        TipoPartido other = (TipoPartido) object;
        if ((this.idTipoPartido == null && other.idTipoPartido != null) || (this.idTipoPartido != null && !this.idTipoPartido.equals(other.idTipoPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TipoPartido[ idTipoPartido=" + idTipoPartido + " ]";
    }
    
}
