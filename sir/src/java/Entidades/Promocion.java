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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Richard HERO
 */
@Entity
@Table(name = "promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocion.findAll", query = "SELECT p FROM Promocion p")
    , @NamedQuery(name = "Promocion.findByIdPromocion", query = "SELECT p FROM Promocion p WHERE p.idPromocion = :idPromocion")
    , @NamedQuery(name = "Promocion.findByEstado", query = "SELECT p FROM Promocion p WHERE p.estado = :estado")
    , @NamedQuery(name = "Promocion.findByNombrePromocion", query = "SELECT p FROM Promocion p WHERE p.nombrePromocion = :nombrePromocion")
    , @NamedQuery(name = "Promocion.findByDescripcionPromocion", query = "SELECT p FROM Promocion p WHERE p.descripcionPromocion = :descripcionPromocion")
    , @NamedQuery(name = "Promocion.findByPrecioPromocion", query = "SELECT p FROM Promocion p WHERE p.precioPromocion = :precioPromocion")
    , @NamedQuery(name = "Promocion.findByTipo", query = "SELECT p FROM Promocion p WHERE p.tipo = :tipo")})
public class Promocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_promocion")
    private Integer idPromocion;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_promocion")
    private String nombrePromocion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_promocion")
    private String descripcionPromocion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_promocion")
    private int precioPromocion;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente idCliente;
    @JoinColumn(name = "id_plato", referencedColumnName = "id_plato")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Plato idPlato;

    public Promocion() {
    }

    public Promocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Promocion(Integer idPromocion, String nombrePromocion, String descripcionPromocion, int precioPromocion) {
        this.idPromocion = idPromocion;
        this.nombrePromocion = nombrePromocion;
        this.descripcionPromocion = descripcionPromocion;
        this.precioPromocion = precioPromocion;
    }

    public Integer getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        this.nombrePromocion = nombrePromocion;
    }

    public String getDescripcionPromocion() {
        return descripcionPromocion;
    }

    public void setDescripcionPromocion(String descripcionPromocion) {
        this.descripcionPromocion = descripcionPromocion;
    }

    public int getPrecioPromocion() {
        return precioPromocion;
    }

    public void setPrecioPromocion(int precioPromocion) {
        this.precioPromocion = precioPromocion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
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
        hash += (idPromocion != null ? idPromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocion)) {
            return false;
        }
        Promocion other = (Promocion) object;
        if ((this.idPromocion == null && other.idPromocion != null) || (this.idPromocion != null && !this.idPromocion.equals(other.idPromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Promocion[ idPromocion=" + idPromocion + " ]";
    }
    
}
