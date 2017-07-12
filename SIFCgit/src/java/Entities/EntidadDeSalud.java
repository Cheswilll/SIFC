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
@Table(name = "entidadesdesalud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntidadDeSalud.findAll", query = "SELECT e FROM EntidadDeSalud e")
    , @NamedQuery(name = "EntidadDeSalud.findByIdEntidad", query = "SELECT e FROM EntidadDeSalud e WHERE e.idEntidad = :idEntidad")
    , @NamedQuery(name = "EntidadDeSalud.findByNombreEntidad", query = "SELECT e FROM EntidadDeSalud e WHERE e.nombreEntidad = :nombreEntidad")})
public class EntidadDeSalud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEntidad")
    private Integer idEntidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreEntidad")
    private String nombreEntidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadSalud", fetch = FetchType.LAZY)
    private List<Formulario> formularios;

    public EntidadDeSalud() {
    }

    public EntidadDeSalud(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public EntidadDeSalud(Integer idEntidad, String nombreEntidad) {
        this.idEntidad = idEntidad;
        this.nombreEntidad = nombreEntidad;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    @XmlTransient
    public List<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidad != null ? idEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadDeSalud)) {
            return false;
        }
        EntidadDeSalud other = (EntidadDeSalud) object;
        if ((this.idEntidad == null && other.idEntidad != null) || (this.idEntidad != null && !this.idEntidad.equals(other.idEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.EntidadDeSalud[ idEntidad=" + idEntidad + " ]";
    }
    
}
