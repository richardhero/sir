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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Richard HERO
 */
@Entity
@Table(name = "producto_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoProveedor.findAll", query = "SELECT p FROM ProductoProveedor p")
    , @NamedQuery(name = "ProductoProveedor.findByIdProductoProveedor", query = "SELECT p FROM ProductoProveedor p WHERE p.idProductoProveedor = :idProductoProveedor")})
public class ProductoProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto_proveedor")
    private Integer idProductoProveedor;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(fetch = FetchType.EAGER)
    private Producto idProducto;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(fetch = FetchType.EAGER)
    private Proveedor idProveedor;

    public ProductoProveedor() {
    }

    public ProductoProveedor(Integer idProductoProveedor) {
        this.idProductoProveedor = idProductoProveedor;
    }

    public Integer getIdProductoProveedor() {
        return idProductoProveedor;
    }

    public void setIdProductoProveedor(Integer idProductoProveedor) {
        this.idProductoProveedor = idProductoProveedor;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductoProveedor != null ? idProductoProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoProveedor)) {
            return false;
        }
        ProductoProveedor other = (ProductoProveedor) object;
        if ((this.idProductoProveedor == null && other.idProductoProveedor != null) || (this.idProductoProveedor != null && !this.idProductoProveedor.equals(other.idProductoProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ProductoProveedor[ idProductoProveedor=" + idProductoProveedor + " ]";
    }
    
}
