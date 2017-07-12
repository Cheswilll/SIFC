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
@Table(name = "tiposdesangre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeSangre.findAll", query = "SELECT t FROM TiposDeSangre t")
    , @NamedQuery(name = "TiposDeSangre.findByIdRh", query = "SELECT t FROM TiposDeSangre t WHERE t.idRh = :idRh")
    , @NamedQuery(name = "TiposDeSangre.findByRh", query = "SELECT t FROM TiposDeSangre t WHERE t.rh = :rh")})
public class TiposDeSangre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRh")
    private Integer idRh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rh")
    private String rh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rh", fetch = FetchType.LAZY)
    private List<Formulario> formularioList;

    public TiposDeSangre() {
    }

    public TiposDeSangre(Integer idRh) {
        this.idRh = idRh;
    }

    public TiposDeSangre(Integer idRh, String rh) {
        this.idRh = idRh;
        this.rh = rh;
    }

    public Integer getIdRh() {
        return idRh;
    }

    public void setIdRh(Integer idRh) {
        this.idRh = idRh;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    @XmlTransient
    public List<Formulario> getFormularioList() {
        return formularioList;
    }

    public void setFormularioList(List<Formulario> formularioList) {
        this.formularioList = formularioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRh != null ? idRh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDeSangre)) {
            return false;
        }
        TiposDeSangre other = (TiposDeSangre) object;
        if ((this.idRh == null && other.idRh != null) || (this.idRh != null && !this.idRh.equals(other.idRh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TiposDeSangre[ idRh=" + idRh + " ]";
    }
    
}
