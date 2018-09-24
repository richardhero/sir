/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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

/**
 *
 * @author Richard HERO
 */
@Entity
@Table(name = "plato_ventas")
@NamedQueries({
    @NamedQuery(name = "PlatoVenta.findAll", query = "SELECT p FROM PlatoVenta p")
    , @NamedQuery(name = "PlatoVenta.findByIdPlatoVentas", query = "SELECT p FROM PlatoVenta p WHERE p.idPlatoVentas = :idPlatoVentas")
    , @NamedQuery(name = "PlatoVenta.findByCantidades", query = "SELECT p FROM PlatoVenta p WHERE p.cantidades = :cantidades")
    , @NamedQuery(name = "PlatoVenta.findByNombre", query = "SELECT p FROM PlatoVenta p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PlatoVenta.findByPrecio", query = "SELECT p FROM PlatoVenta p WHERE p.precio = :precio")
    , @NamedQuery(name = "PlatoVenta.findByTotal", query = "SELECT p FROM PlatoVenta p WHERE p.total = :total")})
public class PlatoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plato_ventas")
    private Integer idPlatoVentas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidades")
    private int cantidades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @JoinColumn(name = "no_factura", referencedColumnName = "no_factura")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Venta noFactura;
    @JoinColumn(name = "id_plato", referencedColumnName = "id_plato")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Plato idPlato;

    public PlatoVenta() {
    }

    public PlatoVenta(Integer idPlatoVentas) {
        this.idPlatoVentas = idPlatoVentas;
    }

    public PlatoVenta(Integer idPlatoVentas, int cantidades, String nombre, int precio, int total, Venta noFactura, Plato idPlato) {
        this.idPlatoVentas = idPlatoVentas;
        this.cantidades = cantidades;
        this.nombre = nombre;
        this.precio = precio;
        this.total = total;
        this.noFactura = noFactura;
        this.idPlato = idPlato;
    }

    

    public Integer getIdPlatoVentas() {
        return idPlatoVentas;
    }

    public void setIdPlatoVentas(Integer idPlatoVentas) {
        this.idPlatoVentas = idPlatoVentas;
    }

    public int getCantidades() {
        return cantidades;
    }

    public void setCantidades(int cantidades) {
        this.cantidades = cantidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Venta getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(Venta noFactura) {
        this.noFactura = noFactura;
    }

    public Plato getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Plato idPlato) {
        this.idPlato = idPlato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlatoVentas != null ? idPlatoVentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlatoVenta)) {
            return false;
        }
        PlatoVenta other = (PlatoVenta) object;
        if ((this.idPlatoVentas == null && other.idPlatoVentas != null) || (this.idPlatoVentas != null && !this.idPlatoVentas.equals(other.idPlatoVentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PlatoVenta[ idPlatoVentas=" + idPlatoVentas + " ]";
    }
    
}
