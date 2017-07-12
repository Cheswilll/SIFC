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
@Table(name = "partidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p")
    , @NamedQuery(name = "Partido.findByIdPartido", query = "SELECT p FROM Partido p WHERE p.idPartido = :idPartido")
    , @NamedQuery(name = "Partido.findByTiempoJuado", query = "SELECT p FROM Partido p WHERE p.tiempoJuado = :tiempoJuado")
    , @NamedQuery(name = "Partido.findByAmonestaciones", query = "SELECT p FROM Partido p WHERE p.amonestaciones = :amonestaciones")
    , @NamedQuery(name = "Partido.findByNombreEquipoRival", query = "SELECT p FROM Partido p WHERE p.nombreEquipoRival = :nombreEquipoRival")
    , @NamedQuery(name = "Partido.findByHoraDelPartido", query = "SELECT p FROM Partido p WHERE p.horaDelPartido = :horaDelPartido")
    , @NamedQuery(name = "Partido.findByObservaciones", query = "SELECT p FROM Partido p WHERE p.observaciones = :observaciones")
    , @NamedQuery(name = "Partido.findByFechaDelPartido", query = "SELECT p FROM Partido p WHERE p.fechaDelPartido = :fechaDelPartido")
    , @NamedQuery(name = "Partido.findByGolesAfavor", query = "SELECT p FROM Partido p WHERE p.golesAfavor = :golesAfavor")
    , @NamedQuery(name = "Partido.findByGolesEnContra", query = "SELECT p FROM Partido p WHERE p.golesEnContra = :golesEnContra")
    , @NamedQuery(name = "Partido.findByLugarPartido", query = "SELECT p FROM Partido p WHERE p.lugarPartido = :lugarPartido")
    , @NamedQuery(name = "Partido.findByDireccion", query = "SELECT p FROM Partido p WHERE p.direccion = :direccion")})
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPartido")
    private Integer idPartido;
    @Column(name = "tiempoJuado")
    @Temporal(TemporalType.TIME)
    private Date tiempoJuado;
    @Size(max = 45)
    @Column(name = "amonestaciones")
    private String amonestaciones;
    @Size(max = 45)
    @Column(name = "nombreEquipoRival")
    private String nombreEquipoRival;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaDelPartido")
    @Temporal(TemporalType.TIME)
    private Date horaDelPartido;
    @Size(max = 45)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDelPartido")
    @Temporal(TemporalType.DATE)
    private Date fechaDelPartido;
    @Column(name = "golesAfavor")
    private Integer golesAfavor;
    @Column(name = "golesEnContra")
    private Integer golesEnContra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lugarPartido")
    private String lugarPartido;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "idTipoAlineacion", referencedColumnName = "idTipoAlineacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoAlineacion idTipoAlineacion;
    @JoinColumn(name = "idTipoPartido", referencedColumnName = "idTipoPartido")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoPartido idTipoPartido;
    @JoinColumn(name = "idTorneo", referencedColumnName = "idTorneo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Torneo idTorneo;
    @JoinColumn(name = "noIdentificacionProfesor", referencedColumnName = "noIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona noIdentificacionProfesor;

    public Partido() {
    }

    public Partido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Partido(Integer idPartido, Date horaDelPartido, Date fechaDelPartido, String lugarPartido) {
        this.idPartido = idPartido;
        this.horaDelPartido = horaDelPartido;
        this.fechaDelPartido = fechaDelPartido;
        this.lugarPartido = lugarPartido;
    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Date getTiempoJuado() {
        return tiempoJuado;
    }

    public void setTiempoJuado(Date tiempoJuado) {
        this.tiempoJuado = tiempoJuado;
    }

    public String getAmonestaciones() {
        return amonestaciones;
    }

    public void setAmonestaciones(String amonestaciones) {
        this.amonestaciones = amonestaciones;
    }

    public String getNombreEquipoRival() {
        return nombreEquipoRival;
    }

    public void setNombreEquipoRival(String nombreEquipoRival) {
        this.nombreEquipoRival = nombreEquipoRival;
    }

    public Date getHoraDelPartido() {
        return horaDelPartido;
    }

    public void setHoraDelPartido(Date horaDelPartido) {
        this.horaDelPartido = horaDelPartido;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaDelPartido() {
        return fechaDelPartido;
    }

    public void setFechaDelPartido(Date fechaDelPartido) {
        this.fechaDelPartido = fechaDelPartido;
    }

    public Integer getGolesAfavor() {
        return golesAfavor;
    }

    public void setGolesAfavor(Integer golesAfavor) {
        this.golesAfavor = golesAfavor;
    }

    public Integer getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(Integer golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    public String getLugarPartido() {
        return lugarPartido;
    }

    public void setLugarPartido(String lugarPartido) {
        this.lugarPartido = lugarPartido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoAlineacion getIdTipoAlineacion() {
        return idTipoAlineacion;
    }

    public void setIdTipoAlineacion(TipoAlineacion idTipoAlineacion) {
        this.idTipoAlineacion = idTipoAlineacion;
    }

    public TipoPartido getIdTipoPartido() {
        return idTipoPartido;
    }

    public void setIdTipoPartido(TipoPartido idTipoPartido) {
        this.idTipoPartido = idTipoPartido;
    }

    public Torneo getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Torneo idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Persona getNoIdentificacionProfesor() {
        return noIdentificacionProfesor;
    }

    public void setNoIdentificacionProfesor(Persona noIdentificacionProfesor) {
        this.noIdentificacionProfesor = noIdentificacionProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartido != null ? idPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.idPartido == null && other.idPartido != null) || (this.idPartido != null && !this.idPartido.equals(other.idPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Partido[ idPartido=" + idPartido + " ]";
    }
    
}
