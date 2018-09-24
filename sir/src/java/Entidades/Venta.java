/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Richard HERO
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByNoFactura", query = "SELECT v FROM Venta v WHERE v.noFactura = :noFactura")
    , @NamedQuery(name = "Venta.findByCodFactura", query = "SELECT v FROM Venta v WHERE v.codFactura = :codFactura")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Venta.findByTotal", query = "SELECT v FROM Venta v WHERE v.total = :total")
    , @NamedQuery(name = "Venta.findByEstado", query = "SELECT v FROM Venta v WHERE v.estado = :estado")
    , @NamedQuery(name = "Venta.findByIva", query = "SELECT v FROM Venta v WHERE v.iva = :iva")
    , @NamedQuery(name = "Venta.findBySubtotal", query = "SELECT v FROM Venta v WHERE v.subtotal = :subtotal")})
public class Venta implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noFactura", fetch = FetchType.EAGER)
    private List<PlatoVenta> platoVentaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no_factura")
    private Integer noFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_factura")
    private int codFactura;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "total")
    private Integer total;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "iva")
    private Double iva;
    @Column(name = "subtotal")
    private Double subtotal;
    @OneToMany(mappedBy = "noFactura", fetch = FetchType.EAGER)
    private List<Productividad> productividadList;
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    @ManyToOne(fetch = FetchType.EAGER)
    private Persona numeroDocumento;

    public Venta() {
    }

    public Venta(Integer noFactura) {
        this.noFactura = noFactura;
    }

    public Venta(Integer noFactura, int codFactura) {
        this.noFactura = noFactura;
        this.codFactura = codFactura;
    }

    public Integer getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(Integer noFactura) {
        this.noFactura = noFactura;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @XmlTransient
    public List<Productividad> getProductividadList() {
        return productividadList;
    }

    public void setProductividadList(List<Productividad> productividadList) {
        this.productividadList = productividadList;
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
        hash += (noFactura != null ? noFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.noFactura == null && other.noFactura != null) || (this.noFactura != null && !this.noFactura.equals(other.noFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Venta[ noFactura=" + noFactura + " ]";
    }

    public List<PlatoVenta> getPlatoVentaList() {
        return platoVentaList;
    }

    public void setPlatoVentaList(List<PlatoVenta> platoVentaList) {
        this.platoVentaList = platoVentaList;
    }
    
}
