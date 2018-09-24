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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Richard HERO
 */
@Entity
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva")
    , @NamedQuery(name = "Reserva.findByFechaReserva", query = "SELECT r FROM Reserva r WHERE r.fechaReserva = :fechaReserva")
    , @NamedQuery(name = "Reserva.findByCantidadPersonas", query = "SELECT r FROM Reserva r WHERE r.cantidadPersonas = :cantidadPersonas")
    , @NamedQuery(name = "Reserva.findByNoMesa", query = "SELECT r FROM Reserva r WHERE r.noMesa = :noMesa")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva")
    private Integer idReserva;
    @Column(name = "fecha_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReserva;
    @Column(name = "cantidad_personas")
    private Integer cantidadPersonas;
    @Column(name = "no_mesa")
    private Integer noMesa;
    @JoinColumn(name = "id_sucursales", referencedColumnName = "id_sucursales")
    @ManyToOne(fetch = FetchType.EAGER)
    private Sucursal idSucursales;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente idCliente;

    public Reserva() {
    }

    public Reserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Integer getNoMesa() {
        return noMesa;
    }

    public void setNoMesa(Integer noMesa) {
        this.noMesa = noMesa;
    }

    public Sucursal getIdSucursales() {
        return idSucursales;
    }

    public void setIdSucursales(Sucursal idSucursales) {
        this.idSucursales = idSucursales;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
