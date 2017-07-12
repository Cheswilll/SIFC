/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cheswill
 */
@Entity
@Table(name = "formulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formulario.findAll", query = "SELECT f FROM Formulario f")
    , @NamedQuery(name = "Formulario.findByIdFormulario", query = "SELECT f FROM Formulario f WHERE f.idFormulario = :idFormulario")
    , @NamedQuery(name = "Formulario.findByNombres", query = "SELECT f FROM Formulario f WHERE f.nombres = :nombres")
    , @NamedQuery(name = "Formulario.findByApellidos", query = "SELECT f FROM Formulario f WHERE f.apellidos = :apellidos")
    , @NamedQuery(name = "Formulario.findByFechaNacimiento", query = "SELECT f FROM Formulario f WHERE f.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Formulario.findByJornadaEstudio", query = "SELECT f FROM Formulario f WHERE f.jornadaEstudio = :jornadaEstudio")
    , @NamedQuery(name = "Formulario.findByAlergias", query = "SELECT f FROM Formulario f WHERE f.alergias = :alergias")
    , @NamedQuery(name = "Formulario.findByLesiones", query = "SELECT f FROM Formulario f WHERE f.lesiones = :lesiones")
    , @NamedQuery(name = "Formulario.findByNombreMama", query = "SELECT f FROM Formulario f WHERE f.nombreMama = :nombreMama")
    , @NamedQuery(name = "Formulario.findByEmpresaMama", query = "SELECT f FROM Formulario f WHERE f.empresaMama = :empresaMama")
    , @NamedQuery(name = "Formulario.findByCargoMama", query = "SELECT f FROM Formulario f WHERE f.cargoMama = :cargoMama")
    , @NamedQuery(name = "Formulario.findByTelefonoMama", query = "SELECT f FROM Formulario f WHERE f.telefonoMama = :telefonoMama")
    , @NamedQuery(name = "Formulario.findByNombrePadre", query = "SELECT f FROM Formulario f WHERE f.nombrePadre = :nombrePadre")
    , @NamedQuery(name = "Formulario.findByEmpresaPadre", query = "SELECT f FROM Formulario f WHERE f.empresaPadre = :empresaPadre")
    , @NamedQuery(name = "Formulario.findByCargoPadre", query = "SELECT f FROM Formulario f WHERE f.cargoPadre = :cargoPadre")
    , @NamedQuery(name = "Formulario.findByTelefonoPadre", query = "SELECT f FROM Formulario f WHERE f.telefonoPadre = :telefonoPadre")})
public class Formulario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFormulario")
    private Integer idFormulario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "jornadaEstudio")
    private String jornadaEstudio;
    @Size(max = 45)
    @Column(name = "alergias")
    private String alergias;
    @Size(max = 45)
    @Column(name = "lesiones")
    private String lesiones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreMama")
    private String nombreMama;
    @Size(max = 45)
    @Column(name = "empresaMama")
    private String empresaMama;
    @Size(max = 45)
    @Column(name = "cargoMama")
    private String cargoMama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefonoMama")
    private String telefonoMama;
    @Size(max = 45)
    @Column(name = "nombrePadre")
    private String nombrePadre;
    @Size(max = 45)
    @Column(name = "empresaPadre")
    private String empresaPadre;
    @Size(max = 45)
    @Column(name = "cargoPadre")
    private String cargoPadre;
    @Size(max = 45)
    @Column(name = "telefonoPadre")
    private String telefonoPadre;
    @JoinColumn(name = "entidadSalud", referencedColumnName = "idEntidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EntidadDeSalud entidadSalud;
    @JoinColumn(name = "noIdentificacion", referencedColumnName = "noIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona noIdentificacion;
    @JoinColumn(name = "rh", referencedColumnName = "idRh")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDeSangre rh;

    public Formulario() {
    }

    public Formulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }

    public Formulario(Integer idFormulario, String nombres, String apellidos, Date fechaNacimiento, String nombreMama, String telefonoMama) {
        this.idFormulario = idFormulario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreMama = nombreMama;
        this.telefonoMama = telefonoMama;
    }

    public Integer getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getJornadaEstudio() {
        return jornadaEstudio;
    }

    public void setJornadaEstudio(String jornadaEstudio) {
        this.jornadaEstudio = jornadaEstudio;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getLesiones() {
        return lesiones;
    }

    public void setLesiones(String lesiones) {
        this.lesiones = lesiones;
    }

    public String getNombreMama() {
        return nombreMama;
    }

    public void setNombreMama(String nombreMama) {
        this.nombreMama = nombreMama;
    }

    public String getEmpresaMama() {
        return empresaMama;
    }

    public void setEmpresaMama(String empresaMama) {
        this.empresaMama = empresaMama;
    }

    public String getCargoMama() {
        return cargoMama;
    }

    public void setCargoMama(String cargoMama) {
        this.cargoMama = cargoMama;
    }

    public String getTelefonoMama() {
        return telefonoMama;
    }

    public void setTelefonoMama(String telefonoMama) {
        this.telefonoMama = telefonoMama;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getEmpresaPadre() {
        return empresaPadre;
    }

    public void setEmpresaPadre(String empresaPadre) {
        this.empresaPadre = empresaPadre;
    }

    public String getCargoPadre() {
        return cargoPadre;
    }

    public void setCargoPadre(String cargoPadre) {
        this.cargoPadre = cargoPadre;
    }

    public String getTelefonoPadre() {
        return telefonoPadre;
    }

    public void setTelefonoPadre(String telefonoPadre) {
        this.telefonoPadre = telefonoPadre;
    }

    public EntidadDeSalud getEntidadSalud() {
        return entidadSalud;
    }

    public void setEntidadSalud(EntidadDeSalud entidadSalud) {
        this.entidadSalud = entidadSalud;
    }

    public Persona getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(Persona noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public TipoDeSangre getRh() {
        return rh;
    }

    public void setRh(TipoDeSangre rh) {
        this.rh = rh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormulario != null ? idFormulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulario)) {
            return false;
        }
        Formulario other = (Formulario) object;
        if ((this.idFormulario == null && other.idFormulario != null) || (this.idFormulario != null && !this.idFormulario.equals(other.idFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Formulario[ idFormulario=" + idFormulario + " ]";
    }
    
}
