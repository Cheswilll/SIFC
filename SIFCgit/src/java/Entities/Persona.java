/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cheswill
 */
@Entity
@Table(name = "personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByNoIdentificacion", query = "SELECT p FROM Persona p WHERE p.noIdentificacion = :noIdentificacion")
    , @NamedQuery(name = "Persona.findByIdEstado", query = "SELECT p FROM Persona p WHERE p.idEstado = :idEstado")
    , @NamedQuery(name = "Persona.findByNombre1", query = "SELECT p FROM Persona p WHERE p.nombre1 = :nombre1")
    , @NamedQuery(name = "Persona.findByNombre2", query = "SELECT p FROM Persona p WHERE p.nombre2 = :nombre2")
    , @NamedQuery(name = "Persona.findByApellido1", query = "SELECT p FROM Persona p WHERE p.apellido1 = :apellido1")
    , @NamedQuery(name = "Persona.findByApellido2", query = "SELECT p FROM Persona p WHERE p.apellido2 = :apellido2")
    , @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Persona.findByTelefonoCelular", query = "SELECT p FROM Persona p WHERE p.telefonoCelular = :telefonoCelular")
    , @NamedQuery(name = "Persona.findByTelefonoFijo", query = "SELECT p FROM Persona p WHERE p.telefonoFijo = :telefonoFijo")
    , @NamedQuery(name = "Persona.findByContrasena", query = "SELECT p FROM Persona p WHERE p.contrasena = :contrasena")
    , @NamedQuery(name = "Persona.findByCorreoElectronico", query = "SELECT p FROM Persona p WHERE p.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "Persona.findByBarrio", query = "SELECT p FROM Persona p WHERE p.barrio = :barrio")
    , @NamedQuery(name = "Persona.findLogin", query = "SELECT p FROM Persona p WHERE p.noIdentificacion = :noIdentificacion AND p.contrasena = :contraseña")
    , @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "noIdentificacion")
    private Long noIdentificacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstado")
    private int idEstado;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoUsuario")
    private int estadoUsuario;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre1")
    private String nombre1;
    @Size(max = 45)
    @Column(name = "nombre2")
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 45)
    @Column(name = "apellido2")
    private String apellido2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefonoCelular")
    private String telefonoCelular;
    @Size(max = 15)
    @Column(name = "telefonoFijo")
    private String telefonoFijo;
    @Size(max = 45)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "barrio")
    private String barrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @JoinTable(name = "rolesdepersonas", joinColumns = {
        @JoinColumn(name = "noIdentificacion", referencedColumnName = "noIdentificacion")}, inverseJoinColumns = {
        @JoinColumn(name = "idRol", referencedColumnName = "idRol")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rol> roles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionJugador", fetch = FetchType.LAZY)
    private List<Seguimiento> seguimientosJugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionProfesor", fetch = FetchType.LAZY)
    private List<Seguimiento> seguimientosProfesor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionJugador", fetch = FetchType.LAZY)
    private List<Familia> familiasJugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionPadre", fetch = FetchType.LAZY)
    private List<Familia> familiasPadre;
    @JoinColumn(name = "idTipoIdentificacion", referencedColumnName = "idTipoDocumento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDocumento idTipoIdentificacion;
    @JoinColumn(name = "idLocalidad", referencedColumnName = "idLocalidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Localidad idLocalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionPersona", fetch = FetchType.LAZY)
    private List<Comprobante> comprobantes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionProfesor", fetch = FetchType.LAZY)
    private List<Partido> partidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacion", fetch = FetchType.LAZY)
    private List<Formulario> formularios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionPersona", fetch = FetchType.LAZY)
    private List<CodigoValidacion> codigosValidacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionJugador", fetch = FetchType.LAZY)
    private List<TestFisico> testFisicosJugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionProfesor", fetch = FetchType.LAZY)
    private List<TestFisico> testFisicosProfesor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionJugador", fetch = FetchType.LAZY)
    private List<Asistencia> asistenciasJugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionProfesor", fetch = FetchType.LAZY)
    private List<Asistencia> asistenciasProfesor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionJugador", fetch = FetchType.LAZY)
    private List<Equipo> equiposJugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noIdentificacionnProfesor", fetch = FetchType.LAZY)
    private List<Equipo> equiposProfesor;

    public Persona() {
    }

    public Persona(Long noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public Persona(Long noIdentificacion, int idEstado, int estadoUsuario, String nombre1, String nombre2, String apellido1, String apellido2, Date fechaNacimiento, String telefonoCelular, String telefonoFijo, String contrasena, String correoElectronico, String barrio, String direccion) {
        this.noIdentificacion = noIdentificacion;
        this.idEstado = idEstado;
        this.estadoUsuario = estadoUsuario;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.telefonoCelular = telefonoCelular;
        this.telefonoFijo = telefonoFijo;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.barrio = barrio;
        this.direccion = direccion;
    }

    public Persona(Long noIdentificacion, int idEstado, int estadoUsuario, String nombre1, String nombre2, String apellido1, String apellido2, Date fechaNacimiento, String telefonoCelular, String telefonoFijo, String contrasena, String correoElectronico, String barrio, String direccion, List<Rol> roles) {
        this.noIdentificacion = noIdentificacion;
        this.idEstado = idEstado;
        this.estadoUsuario = estadoUsuario;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.telefonoCelular = telefonoCelular;
        this.telefonoFijo = telefonoFijo;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.barrio = barrio;
        this.direccion = direccion;
        this.roles = roles;
    }
    

    

    public Long getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(Long noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(int estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
    
    

    @XmlTransient
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientosJugador() {
        return seguimientosJugador;
    }

    public void setSeguimientosJugador(List<Seguimiento> seguimientosJugador) {
        this.seguimientosJugador = seguimientosJugador;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientosProfesor() {
        return seguimientosProfesor;
    }

    public void setSeguimientosProfesor(List<Seguimiento> seguimientosProfesor) {
        this.seguimientosProfesor = seguimientosProfesor;
    }

    public TipoDocumento getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(TipoDocumento idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public Localidad getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Localidad idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    @XmlTransient
    public List<Comprobante> getComprobantes() {
        return comprobantes;
    }

    public void setComprobantes(List<Comprobante> comprobantes) {
        this.comprobantes = comprobantes;
    }

    @XmlTransient
    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    @XmlTransient
    public List<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }

    @XmlTransient
    public List<CodigoValidacion> getCodigosValidacion() {
        return codigosValidacion;
    }

    public void setCodigosValidacion(List<CodigoValidacion> codigosValidacion) {
        this.codigosValidacion = codigosValidacion;
    }

    @XmlTransient
    public List<TestFisico> getTestFisicosJugador() {
        return testFisicosJugador;
    }

    public void setTestFisicosJugador(List<TestFisico> testFisicosJugador) {
        this.testFisicosJugador = testFisicosJugador;
    }

    @XmlTransient
    public List<TestFisico> getTestFisicosProfesor() {
        return testFisicosProfesor;
    }

    public void setTestFisicosProfesor(List<TestFisico> testFisicosProfesor) {
        this.testFisicosProfesor = testFisicosProfesor;
    }

    @XmlTransient
    public List<Asistencia> getAsistenciasJugador() {
        return asistenciasJugador;
    }

    public void setAsistenciasJugador(List<Asistencia> asistenciasJugador) {
        this.asistenciasJugador = asistenciasJugador;
    }

    @XmlTransient
    public List<Asistencia> getAsistenciasProfesor() {
        return asistenciasProfesor;
    }

    public void setAsistenciasProfesor(List<Asistencia> asistenciasProfesor) {
        this.asistenciasProfesor = asistenciasProfesor;
    }

    @XmlTransient
    public List<Equipo> getEquiposJugador() {
        return equiposJugador;
    }

    public void setEquiposJugador(List<Equipo> equiposJugador) {
        this.equiposJugador = equiposJugador;
    }

    @XmlTransient
    public List<Equipo> getEquiposProfesor() {
        return equiposProfesor;
    }

    public void setEquiposProfesor(List<Equipo> equiposProfesor) {
        this.equiposProfesor = equiposProfesor;
    }

    public List<Familia> getFamiliasJugador() {
        return familiasJugador;
    }

    public void setFamiliasJugador(List<Familia> familiasJugador) {
        this.familiasJugador = familiasJugador;
    }

    public List<Familia> getFamiliasPadre() {
        return familiasPadre;
    }

    public void setFamiliasPadre(List<Familia> familiasPadre) {
        this.familiasPadre = familiasPadre;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noIdentificacion != null ? noIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.noIdentificacion == null && other.noIdentificacion != null) || (this.noIdentificacion != null && !this.noIdentificacion.equals(other.noIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override 
    public String toString() {
        return "Persona: " + "noIdentificacion:" + noIdentificacion + ", Nombre: " + nombre1+ " " + "Apellido: "+apellido1;
    }

    
    
}
