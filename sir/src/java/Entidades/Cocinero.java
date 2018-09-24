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
@Table(name = "cocinero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cocinero.findAll", query = "SELECT c FROM Cocinero c")
    , @NamedQuery(name = "Cocinero.findByIdCocinero", query = "SELECT c FROM Cocinero c WHERE c.idCocinero = :idCocinero")
    , @NamedQuery(name = "Cocinero.findByEspecialidad", query = "SELECT c FROM Cocinero c WHERE c.especialidad = :especialidad")
    , @NamedQuery(name = "Cocinero.findByNoCocina", query = "SELECT c FROM Cocinero c WHERE c.noCocina = :noCocina")})
public class Cocinero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cocinero")
    private Integer idCocinero;
    @Size(max = 45)
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "no_cocina")
    private Integer noCocina;
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    @ManyToOne(fetch = FetchType.EAGER)
    private Persona numeroDocumento;

    public Cocinero() {
    }

    public Cocinero(Integer idCocinero) {
        this.idCocinero = idCocinero;
    }

    public Integer getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(Integer idCocinero) {
        this.idCocinero = idCocinero;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getNoCocina() {
        return noCocina;
    }

    public void setNoCocina(Integer noCocina) {
        this.noCocina = noCocina;
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
        hash += (idCocinero != null ? idCocinero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cocinero)) {
            return false;
        }
        Cocinero other = (Cocinero) object;
        if ((this.idCocinero == null && other.idCocinero != null) || (this.idCocinero != null && !this.idCocinero.equals(other.idCocinero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cocinero[ idCocinero=" + idCocinero + " ]";
    }
    
}
