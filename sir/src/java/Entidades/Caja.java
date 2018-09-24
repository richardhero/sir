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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Richard HERO
 */
@Entity
@Table(name = "caja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caja.findAll", query = "SELECT c FROM Caja c")
    , @NamedQuery(name = "Caja.findByIdCaja", query = "SELECT c FROM Caja c WHERE c.idCaja = :idCaja")
    , @NamedQuery(name = "Caja.findByNoCaja", query = "SELECT c FROM Caja c WHERE c.noCaja = :noCaja")
    , @NamedQuery(name = "Caja.findByFecha", query = "SELECT c FROM Caja c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Caja.findByBaseInicial", query = "SELECT c FROM Caja c WHERE c.baseInicial = :baseInicial")
    , @NamedQuery(name = "Caja.findByBaseFinal", query = "SELECT c FROM Caja c WHERE c.baseFinal = :baseFinal")
    , @NamedQuery(name = "Caja.findByTotalDiferencia", query = "SELECT c FROM Caja c WHERE c.totalDiferencia = :totalDiferencia")
    , @NamedQuery(name = "Caja.findBySaldoCredito", query = "SELECT c FROM Caja c WHERE c.saldoCredito = :saldoCredito")
    , @NamedQuery(name = "Caja.findBySaldoDebito", query = "SELECT c FROM Caja c WHERE c.saldoDebito = :saldoDebito")
    , @NamedQuery(name = "Caja.findBySaldoPuntos", query = "SELECT c FROM Caja c WHERE c.saldoPuntos = :saldoPuntos")
    , @NamedQuery(name = "Caja.findBySaldoFinalTotal", query = "SELECT c FROM Caja c WHERE c.saldoFinalTotal = :saldoFinalTotal")
    , @NamedQuery(name = "Caja.findBySaldoEfectivo", query = "SELECT c FROM Caja c WHERE c.saldoEfectivo = :saldoEfectivo")
    , @NamedQuery(name = "Caja.findByEstado", query = "SELECT c FROM Caja c WHERE c.estado = :estado")})
public class Caja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caja")
    private Integer idCaja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_caja")
    private int noCaja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "base_inicial")
    private int baseInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "base_final")
    private int baseFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_diferencia")
    private int totalDiferencia;
    @Column(name = "saldo_credito")
    private Integer saldoCredito;
    @Column(name = "saldo_debito")
    private Integer saldoDebito;
    @Column(name = "saldo_puntos")
    private Integer saldoPuntos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_final_total")
    private int saldoFinalTotal;
    @Column(name = "saldo_efectivo")
    private Integer saldoEfectivo;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona numeroDocumento;

    public Caja() {
    }

    public Caja(Integer idCaja) {
        this.idCaja = idCaja;
    }

    public Caja(Integer idCaja, int noCaja, Date fecha, int baseInicial, int baseFinal, int totalDiferencia, int saldoFinalTotal) {
        this.idCaja = idCaja;
        this.noCaja = noCaja;
        this.fecha = fecha;
        this.baseInicial = baseInicial;
        this.baseFinal = baseFinal;
        this.totalDiferencia = totalDiferencia;
        this.saldoFinalTotal = saldoFinalTotal;
    }

    public Integer getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Integer idCaja) {
        this.idCaja = idCaja;
    }

    public int getNoCaja() {
        return noCaja;
    }

    public void setNoCaja(int noCaja) {
        this.noCaja = noCaja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getBaseInicial() {
        return baseInicial;
    }

    public void setBaseInicial(int baseInicial) {
        this.baseInicial = baseInicial;
    }

    public int getBaseFinal() {
        return baseFinal;
    }

    public void setBaseFinal(int baseFinal) {
        this.baseFinal = baseFinal;
    }

    public int getTotalDiferencia() {
        return totalDiferencia;
    }

    public void setTotalDiferencia(int totalDiferencia) {
        this.totalDiferencia = totalDiferencia;
    }

    public Integer getSaldoCredito() {
        return saldoCredito;
    }

    public void setSaldoCredito(Integer saldoCredito) {
        this.saldoCredito = saldoCredito;
    }

    public Integer getSaldoDebito() {
        return saldoDebito;
    }

    public void setSaldoDebito(Integer saldoDebito) {
        this.saldoDebito = saldoDebito;
    }

    public Integer getSaldoPuntos() {
        return saldoPuntos;
    }

    public void setSaldoPuntos(Integer saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }

    public int getSaldoFinalTotal() {
        return saldoFinalTotal;
    }

    public void setSaldoFinalTotal(int saldoFinalTotal) {
        this.saldoFinalTotal = saldoFinalTotal;
    }

    public Integer getSaldoEfectivo() {
        return saldoEfectivo;
    }

    public void setSaldoEfectivo(Integer saldoEfectivo) {
        this.saldoEfectivo = saldoEfectivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (idCaja != null ? idCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caja)) {
            return false;
        }
        Caja other = (Caja) object;
        if ((this.idCaja == null && other.idCaja != null) || (this.idCaja != null && !this.idCaja.equals(other.idCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Caja[ idCaja=" + idCaja + " ]";
    }
    
}
