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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cheswill
 */
@Entity
@Table(name = "codigosvalidacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigoValidacion.findAll", query = "SELECT c FROM CodigoValidacion c")
    , @NamedQuery(name = "CodigoValidacion.findByIdCodigo", query = "SELECT c FROM CodigoValidacion c WHERE c.idCodigo = :idCodigo")
    , @NamedQuery(name = "CodigoValidacion.findByCodigo", query = "SELECT c FROM CodigoValidacion c WHERE c.codigo = :codigo")})
public class CodigoValidacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCodigo")
    private Integer idCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @JoinColumn(name = "noIdentificacionPersona", referencedColumnName = "noIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona noIdentificacionPersona;

    public CodigoValidacion() {
    }

    public CodigoValidacion(Integer idCodigo) {
        this.idCodigo = idCodigo;
    }

    public CodigoValidacion(Integer idCodigo, String codigo) {
        this.idCodigo = idCodigo;
        this.codigo = codigo;
    }

    public Integer getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(Integer idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Persona getNoIdentificacionPersona() {
        return noIdentificacionPersona;
    }

    public void setNoIdentificacionPersona(Persona noIdentificacionPersona) {
        this.noIdentificacionPersona = noIdentificacionPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodigo != null ? idCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoValidacion)) {
            return false;
        }
        CodigoValidacion other = (CodigoValidacion) object;
        if ((this.idCodigo == null && other.idCodigo != null) || (this.idCodigo != null && !this.idCodigo.equals(other.idCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CodigoValidacion[ idCodigo=" + idCodigo + " ]";
    }
    
}
