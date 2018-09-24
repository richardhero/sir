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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Richard HERO
 */
@Entity
@Table(name = "bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b")
    , @NamedQuery(name = "Bodega.findByIdBodega", query = "SELECT b FROM Bodega b WHERE b.idBodega = :idBodega")
    , @NamedQuery(name = "Bodega.findByNumeroBodega", query = "SELECT b FROM Bodega b WHERE b.numeroBodega = :numeroBodega")
    , @NamedQuery(name = "Bodega.findByConteo", query = "SELECT b FROM Bodega b WHERE b.conteo = :conteo")
    , @NamedQuery(name = "Bodega.findByCantidadParcial", query = "SELECT b FROM Bodega b WHERE b.cantidadParcial = :cantidadParcial")
    , @NamedQuery(name = "Bodega.findByCantidadTotal", query = "SELECT b FROM Bodega b WHERE b.cantidadTotal = :cantidadTotal")
    , @NamedQuery(name = "Bodega.findByFechaIngreso", query = "SELECT b FROM Bodega b WHERE b.fechaIngreso = :fechaIngreso")})
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bodega")
    private Integer idBodega;
    @Column(name = "numero_bodega")
    private Integer numeroBodega;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "conteo")
    private Double conteo;
    @Column(name = "cantidad_parcial")
    private Double cantidadParcial;
    @Column(name = "cantidad_total")
    private Double cantidadTotal;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @OneToMany(mappedBy = "idBodega", fetch = FetchType.EAGER)
    private List<Producto> productoList;

    public Bodega() {
    }

    public Bodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getNumeroBodega() {
        return numeroBodega;
    }

    public void setNumeroBodega(Integer numeroBodega) {
        this.numeroBodega = numeroBodega;
    }

    public Double getConteo() {
        return conteo;
    }

    public void setConteo(Double conteo) {
        this.conteo = conteo;
    }

    public Double getCantidadParcial() {
        return cantidadParcial;
    }

    public void setCantidadParcial(Double cantidadParcial) {
        this.cantidadParcial = cantidadParcial;
    }

    public Double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBodega != null ? idBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.idBodega == null && other.idBodega != null) || (this.idBodega != null && !this.idBodega.equals(other.idBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Bodega[ idBodega=" + idBodega + " ]";
    }
    
}
