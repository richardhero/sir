/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
 * @author Richard HERO
 */
@Entity
@Table(name = "turnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t")
    , @NamedQuery(name = "Turno.findByIdTurnos", query = "SELECT t FROM Turno t WHERE t.idTurnos = :idTurnos")
    , @NamedQuery(name = "Turno.findByEntradaProgramada", query = "SELECT t FROM Turno t WHERE t.entradaProgramada = :entradaProgramada")
    , @NamedQuery(name = "Turno.findBySalidaProgramada", query = "SELECT t FROM Turno t WHERE t.salidaProgramada = :salidaProgramada")
    , @NamedQuery(name = "Turno.findByHorasProgramadas", query = "SELECT t FROM Turno t WHERE t.horasProgramadas = :horasProgramadas")
    , @NamedQuery(name = "Turno.findByHoraIngresoReal", query = "SELECT t FROM Turno t WHERE t.horaIngresoReal = :horaIngresoReal")
    , @NamedQuery(name = "Turno.findByHoraSalidaReal", query = "SELECT t FROM Turno t WHERE t.horaSalidaReal = :horaSalidaReal")
    , @NamedQuery(name = "Turno.findByHorasReales", query = "SELECT t FROM Turno t WHERE t.horasReales = :horasReales")
    , @NamedQuery(name = "Turno.findByDirefenciaHoras", query = "SELECT t FROM Turno t WHERE t.direfenciaHoras = :direfenciaHoras")})
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_turnos")
    private Integer idTurnos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrada_programada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entradaProgramada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salida_programada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date salidaProgramada;
    @Column(name = "horas_programadas")
    private Integer horasProgramadas;
    @Column(name = "hora_ingreso_real")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaIngresoReal;
    @Column(name = "hora_salida_real")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaSalidaReal;
    @Column(name = "horas_reales")
    private Integer horasReales;
    @Column(name = "direfencia_horas")
    private Integer direfenciaHoras;
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona numeroDocumento;

    public Turno() {
    }

    public Turno(Integer idTurnos) {
        this.idTurnos = idTurnos;
    }

    public Turno(Integer idTurnos, Date entradaProgramada, Date salidaProgramada) {
        this.idTurnos = idTurnos;
        this.entradaProgramada = entradaProgramada;
        this.salidaProgramada = salidaProgramada;
    }

    public Integer getIdTurnos() {
        return idTurnos;
    }

    public void setIdTurnos(Integer idTurnos) {
        this.idTurnos = idTurnos;
    }

    public Date getEntradaProgramada() {
        return entradaProgramada;
    }

    public void setEntradaProgramada(Date entradaProgramada) {
        this.entradaProgramada = entradaProgramada;
    }

    public Date getSalidaProgramada() {
        return salidaProgramada;
    }

    public void setSalidaProgramada(Date salidaProgramada) {
        this.salidaProgramada = salidaProgramada;
    }

    public Integer getHorasProgramadas() {
        return horasProgramadas;
    }

    public void setHorasProgramadas(Integer horasProgramadas) {
        this.horasProgramadas = horasProgramadas;
    }

    public Date getHoraIngresoReal() {
        return horaIngresoReal;
    }

    public void setHoraIngresoReal(Date horaIngresoReal) {
        this.horaIngresoReal = horaIngresoReal;
    }

    public Date getHoraSalidaReal() {
        return horaSalidaReal;
    }

    public void setHoraSalidaReal(Date horaSalidaReal) {
        this.horaSalidaReal = horaSalidaReal;
    }

    public Integer getHorasReales() {
        return horasReales;
    }

    public void setHorasReales(Integer horasReales) {
        this.horasReales = horasReales;
    }

    public Integer getDirefenciaHoras() {
        return direfenciaHoras;
    }

    public void setDirefenciaHoras(Integer direfenciaHoras) {
        this.direfenciaHoras = direfenciaHoras;
    }

    public Persona getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Persona numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTurnos != null ? idTurnos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.idTurnos == null && other.idTurnos != null) || (this.idTurnos != null && !this.idTurnos.equals(other.idTurnos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Turno[ idTurnos=" + idTurnos + " ]";
    }
    
}
