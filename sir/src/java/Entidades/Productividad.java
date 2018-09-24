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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Richard HERO
 */
@Entity
@Table(name = "productividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productividad.findAll", query = "SELECT p FROM Productividad p")
    , @NamedQuery(name = "Productividad.findByIdProductividad", query = "SELECT p FROM Productividad p WHERE p.idProductividad = :idProductividad")
    , @NamedQuery(name = "Productividad.findByVentasDia", query = "SELECT p FROM Productividad p WHERE p.ventasDia = :ventasDia")
    , @NamedQuery(name = "Productividad.findByVentasMesero", query = "SELECT p FROM Productividad p WHERE p.ventasMesero = :ventasMesero")
    , @NamedQuery(name = "Productividad.findByVentasSucursales", query = "SELECT p FROM Productividad p WHERE p.ventasSucursales = :ventasSucursales")})
public class Productividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_productividad")
    private Integer idProductividad;
    @Size(max = 50)
    @Column(name = "ventas_dia")
    private String ventasDia;
    @Size(max = 50)
    @Column(name = "ventas_mesero")
    private String ventasMesero;
    @Size(max = 50)
    @Column(name = "ventas_sucursales")
    private String ventasSucursales;
    @JoinColumn(name = "no_factura", referencedColumnName = "no_factura")
    @ManyToOne(fetch = FetchType.EAGER)
    private Venta noFactura;
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    @ManyToOne(fetch = FetchType.EAGER)
    private Persona numeroDocumento;

    public Productividad() {
    }

    public Productividad(Integer idProductividad) {
        this.idProductividad = idProductividad;
    }

    public Integer getIdProductividad() {
        return idProductividad;
    }

    public void setIdProductividad(Integer idProductividad) {
        this.idProductividad = idProductividad;
    }

    public String getVentasDia() {
        return ventasDia;
    }

    public void setVentasDia(String ventasDia) {
        this.ventasDia = ventasDia;
    }

    public String getVentasMesero() {
        return ventasMesero;
    }

    public void setVentasMesero(String ventasMesero) {
        this.ventasMesero = ventasMesero;
    }

    public String getVentasSucursales() {
        return ventasSucursales;
    }

    public void setVentasSucursales(String ventasSucursales) {
        this.ventasSucursales = ventasSucursales;
    }

    public Venta getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(Venta noFactura) {
        this.noFactura = noFactura;
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
        hash += (idProductividad != null ? idProductividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productividad)) {
            return false;
        }
        Productividad other = (Productividad) object;
        if ((this.idProductividad == null && other.idProductividad != null) || (this.idProductividad != null && !this.idProductividad.equals(other.idProductividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Productividad[ idProductividad=" + idProductividad + " ]";
    }
    
}
