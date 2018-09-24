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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Richard HERO
 */
@Entity
@Table(name = "plato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p")
    , @NamedQuery(name = "Plato.findByIdPlato", query = "SELECT p FROM Plato p WHERE p.idPlato = :idPlato")
    , @NamedQuery(name = "Plato.findByPrecio", query = "SELECT p FROM Plato p WHERE p.precio = :precio")
    , @NamedQuery(name = "Plato.findByEstado", query = "SELECT p FROM Plato p WHERE p.estado = :estado")
    , @NamedQuery(name = "Plato.findByNombrePlato", query = "SELECT p FROM Plato p WHERE p.nombrePlato = :nombrePlato")
    , @NamedQuery(name = "Plato.findByFechaVencimiento", query = "SELECT p FROM Plato p WHERE p.fechaVencimiento = :fechaVencimiento")})
public class Plato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plato")
    private Integer idPlato;
    @Column(name = "precio")
    private Integer precio;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "nombre_plato")
    private String nombrePlato;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlato", fetch = FetchType.EAGER)
    private List<Promocion> promocionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplato", fetch = FetchType.EAGER)
    private List<Platoseguimiento> platoseguimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlato", fetch = FetchType.EAGER)
    private List<PlatoVenta> platoVentaList;
    @OneToMany(mappedBy = "idPlato", fetch = FetchType.EAGER)
    private List<Desperdicio> desperdicioList;
    @JoinColumn(name = "id_receta", referencedColumnName = "id_receta")
    @ManyToOne(fetch = FetchType.EAGER)
    private Receta idReceta;

    public Plato() {
    }

    public Plato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @XmlTransient
    public List<Promocion> getPromocionList() {
        return promocionList;
    }

    public void setPromocionList(List<Promocion> promocionList) {
        this.promocionList = promocionList;
    }

    @XmlTransient
    public List<Platoseguimiento> getPlatoseguimientoList() {
        return platoseguimientoList;
    }

    public void setPlatoseguimientoList(List<Platoseguimiento> platoseguimientoList) {
        this.platoseguimientoList = platoseguimientoList;
    }

    @XmlTransient
    public List<PlatoVenta> getPlatoVentaList() {
        return platoVentaList;
    }

    public void setPlatoVentaList(List<PlatoVenta> platoVentaList) {
        this.platoVentaList = platoVentaList;
    }

    @XmlTransient
    public List<Desperdicio> getDesperdicioList() {
        return desperdicioList;
    }

    public void setDesperdicioList(List<Desperdicio> desperdicioList) {
        this.desperdicioList = desperdicioList;
    }

    public Receta getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Receta idReceta) {
        this.idReceta = idReceta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlato != null ? idPlato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.idPlato == null && other.idPlato != null) || (this.idPlato != null && !this.idPlato.equals(other.idPlato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Plato[ idPlato=" + idPlato + " ]";
    }
    
}
