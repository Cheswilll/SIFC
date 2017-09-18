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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cheswill
 */
@Entity
@Table(name = "testfisicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestFisico.findAll", query = "SELECT t FROM TestFisico t")
    , @NamedQuery(name = "TestFisico.findByIdTest", query = "SELECT t FROM TestFisico t WHERE t.idTest = :idTest")
    , @NamedQuery(name = "TestFisico.findByVelocidad", query = "SELECT t FROM TestFisico t WHERE t.velocidad = :velocidad")
    , @NamedQuery(name = "TestFisico.findByAltura", query = "SELECT t FROM TestFisico t WHERE t.altura = :altura")
    , @NamedQuery(name = "TestFisico.findByResistencia", query = "SELECT t FROM TestFisico t WHERE t.resistencia = :resistencia")
    , @NamedQuery(name = "TestFisico.findByFuerza", query = "SELECT t FROM TestFisico t WHERE t.fuerza = :fuerza")
    , @NamedQuery(name = "TestFisico.findByAgilidad", query = "SELECT t FROM TestFisico t WHERE t.agilidad = :agilidad")
    , @NamedQuery(name = "TestFisico.findByPeso", query = "SELECT t FROM TestFisico t WHERE t.peso = :peso")})
public class TestFisico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTest")
    private Integer idTest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "velocidad")
    private double velocidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "altura")
    private double altura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resistencia")
    private double resistencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fuerza")
    private double fuerza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agilidad")
    private double agilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private double peso;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaTestFisico")
    @Temporal(TemporalType.DATE)
    private Date fechaTestFisico;
    
    @JoinColumn(name = "noIdentificacionJugador", referencedColumnName = "noIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona noIdentificacionJugador;
    @JoinColumn(name = "noIdentificacionProfesor", referencedColumnName = "noIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona noIdentificacionProfesor;

    public TestFisico() {
    }

    public TestFisico(Integer idTest) {
        this.idTest = idTest;
    }

    public TestFisico(Integer idTest, double velocidad, double altura, double resistencia, double fuerza, double agilidad, double peso) {
        this.idTest = idTest;
        this.velocidad = velocidad;
        this.altura = altura;
        this.resistencia = resistencia;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.peso = peso;
    }

    public TestFisico(Integer idTest, double velocidad, double altura, double resistencia, double fuerza, double agilidad, double peso, Date fechaTestFisico) {
        this.idTest = idTest;
        this.velocidad = velocidad;
        this.altura = altura;
        this.resistencia = resistencia;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.peso = peso;
        this.fechaTestFisico = fechaTestFisico;
    }
    
    

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public double getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(double agilidad) {
        this.agilidad = agilidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
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

    public Date getFechaTestFisico() {
        return fechaTestFisico;
    }

    public void setFechaTestFisico(Date fechaTestFisico) {
        this.fechaTestFisico = fechaTestFisico;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTest != null ? idTest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestFisico)) {
            return false;
        }
        TestFisico other = (TestFisico) object;
        if ((this.idTest == null && other.idTest != null) || (this.idTest != null && !this.idTest.equals(other.idTest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TestFisico[ idTest=" + idTest + " ]";
    }
    
}
