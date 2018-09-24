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
@Table(name = "platoseguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platoseguimiento.findAll", query = "SELECT p FROM Platoseguimiento p")
    , @NamedQuery(name = "Platoseguimiento.findByIdplatoseguimiento", query = "SELECT p FROM Platoseguimiento p WHERE p.idplatoseguimiento = :idplatoseguimiento")
    , @NamedQuery(name = "Platoseguimiento.findByCantidadVentas", query = "SELECT p FROM Platoseguimiento p WHERE p.cantidadVentas = :cantidadVentas")})
public class Platoseguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplatoseguimiento")
    private Integer idplatoseguimiento;
    @Column(name = "cantidad_ventas")
    private Integer cantidadVentas;
    @JoinColumn(name = "idplato", referencedColumnName = "id_plato")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Plato idplato;

    public Platoseguimiento() {
    }

    public Platoseguimiento(Integer idplatoseguimiento) {
        this.idplatoseguimiento = idplatoseguimiento;
    }

    public Integer getIdplatoseguimiento() {
        return idplatoseguimiento;
    }

    public void setIdplatoseguimiento(Integer idplatoseguimiento) {
        this.idplatoseguimiento = idplatoseguimiento;
    }

    public Integer getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(Integer cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public Plato getIdplato() {
        return idplato;
    }

    public void setIdplato(Plato idplato) {
        this.idplato = idplato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplatoseguimiento != null ? idplatoseguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platoseguimiento)) {
            return false;
        }
        Platoseguimiento other = (Platoseguimiento) object;
        if ((this.idplatoseguimiento == null && other.idplatoseguimiento != null) || (this.idplatoseguimiento != null && !this.idplatoseguimiento.equals(other.idplatoseguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Platoseguimiento[ idplatoseguimiento=" + idplatoseguimiento + " ]";
    }
    
}
