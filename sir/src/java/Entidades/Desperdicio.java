/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Richard HERO
 */
@Entity
@Table(name = "desperdicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desperdicio.findAll", query = "SELECT d FROM Desperdicio d")
    , @NamedQuery(name = "Desperdicio.findByIdDesperdicios", query = "SELECT d FROM Desperdicio d WHERE d.idDesperdicios = :idDesperdicios")
    , @NamedQuery(name = "Desperdicio.findByTipoDesperdicio", query = "SELECT d FROM Desperdicio d WHERE d.tipoDesperdicio = :tipoDesperdicio")
    , @NamedQuery(name = "Desperdicio.findByCantidad", query = "SELECT d FROM Desperdicio d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Desperdicio.findByUtilidad", query = "SELECT d FROM Desperdicio d WHERE d.utilidad = :utilidad")})
public class Desperdicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_desperdicios")
    private Integer idDesperdicios;
    @Size(max = 45)
    @Column(name = "tipo_desperdicio")
    private String tipoDesperdicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    public Double cantidad;
    @Size(max = 45)
    @Column(name = "utilidad")
    private String utilidad;
    @OneToMany(mappedBy = "idDesperdicio", fetch = FetchType.EAGER)
    private List<Producto> productoList;
    @JoinColumn(name = "id_plato", referencedColumnName = "id_plato")
    @ManyToOne(fetch = FetchType.EAGER)
    private Plato idPlato;

    public Desperdicio() {
    }

    public Desperdicio(Integer idDesperdicios) {
        this.idDesperdicios = idDesperdicios;
    }

    public Integer getIdDesperdicios() {
        return idDesperdicios;
    }

    public void setIdDesperdicios(Integer idDesperdicios) {
        this.idDesperdicios = idDesperdicios;
    }

    public String getTipoDesperdicio() {
        return tipoDesperdicio;
    }

    public void setTipoDesperdicio(String tipoDesperdicio) {
        this.tipoDesperdicio = tipoDesperdicio;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(String utilidad) {
        this.utilidad = utilidad;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
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
        hash += (idDesperdicios != null ? idDesperdicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desperdicio)) {
            return false;
        }
        Desperdicio other = (Desperdicio) object;
        if ((this.idDesperdicios == null && other.idDesperdicios != null) || (this.idDesperdicios != null && !this.idDesperdicios.equals(other.idDesperdicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Desperdicio[ idDesperdicios=" + idDesperdicios + " ]";
    }
    
}
