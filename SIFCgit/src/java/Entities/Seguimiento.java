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
@Table(name = "seguimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s")
    , @NamedQuery(name = "Seguimiento.findByIdSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.idSeguimiento = :idSeguimiento")
    , @NamedQuery(name = "Seguimiento.findByNombresJugador", query = "SELECT s FROM Seguimiento s WHERE s.nombresJugador = :nombresJugador")
    , @NamedQuery(name = "Seguimiento.findByPartidosJugados", query = "SELECT s FROM Seguimiento s WHERE s.partidosJugados = :partidosJugados")
    , @NamedQuery(name = "Seguimiento.findByTallaGuayos", query = "SELECT s FROM Seguimiento s WHERE s.tallaGuayos = :tallaGuayos")
    , @NamedQuery(name = "Seguimiento.findByTestRealizados", query = "SELECT s FROM Seguimiento s WHERE s.testRealizados = :testRealizados")
    , @NamedQuery(name = "Seguimiento.findByTallaCamisa", query = "SELECT s FROM Seguimiento s WHERE s.tallaCamisa = :tallaCamisa")
    , @NamedQuery(name = "Seguimiento.findByTallaPantaloneta", query = "SELECT s FROM Seguimiento s WHERE s.tallaPantaloneta = :tallaPantaloneta")
    , @NamedQuery(name = "Seguimiento.findByFechaIngreso", query = "SELECT s FROM Seguimiento s WHERE s.fechaIngreso = :fechaIngreso")})
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSeguimiento")
    private Integer idSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombresJugador")
    private String nombresJugador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partidosJugados")
    private int partidosJugados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tallaGuayos")
    private int tallaGuayos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "testRealizados")
    private int testRealizados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tallaCamisa")
    private int tallaCamisa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tallaPantaloneta")
    private int tallaPantaloneta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @JoinColumn(name = "noIdentificacionJugador", referencedColumnName = "noIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona noIdentificacionJugador;
    @JoinColumn(name = "noIdentificacionProfesor", referencedColumnName = "noIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona noIdentificacionProfesor;

    public Seguimiento() {
    }

    public Seguimiento(Integer idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Seguimiento(Integer idSeguimiento, String nombresJugador, int partidosJugados, int tallaGuayos, int testRealizados, int tallaCamisa, int tallaPantaloneta, Date fechaIngreso) {
        this.idSeguimiento = idSeguimiento;
        this.nombresJugador = nombresJugador;
        this.partidosJugados = partidosJugados;
        this.tallaGuayos = tallaGuayos;
        this.testRealizados = testRealizados;
        this.tallaCamisa = tallaCamisa;
        this.tallaPantaloneta = tallaPantaloneta;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Integer idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public String getNombresJugador() {
        return nombresJugador;
    }

    public void setNombresJugador(String nombresJugador) {
        this.nombresJugador = nombresJugador;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getTallaGuayos() {
        return tallaGuayos;
    }

    public void setTallaGuayos(int tallaGuayos) {
        this.tallaGuayos = tallaGuayos;
    }

    public int getTestRealizados() {
        return testRealizados;
    }

    public void setTestRealizados(int testRealizados) {
        this.testRealizados = testRealizados;
    }

    public int getTallaCamisa() {
        return tallaCamisa;
    }

    public void setTallaCamisa(int tallaCamisa) {
        this.tallaCamisa = tallaCamisa;
    }

    public int getTallaPantaloneta() {
        return tallaPantaloneta;
    }

    public void setTallaPantaloneta(int tallaPantaloneta) {
        this.tallaPantaloneta = tallaPantaloneta;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Persona getNoIdentificacionJugador() {
        return noIdentificacionJugador;
    }

    public void setNoIdentificacionJugador(Persona noIdentificacionJugador) {
        this.noIdentificacionJugador = noIdentificacionJugador;
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
        hash += (idSeguimiento != null ? idSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.idSeguimiento == null && other.idSeguimiento != null) || (this.idSeguimiento != null && !this.idSeguimiento.equals(other.idSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Seguimiento[ idSeguimiento=" + idSeguimiento + " ]";
    }
    
}
