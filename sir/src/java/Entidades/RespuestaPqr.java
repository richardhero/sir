/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Richard HERO
 */
@Entity
@Table(name = "respuesta_pqr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RespuestaPqr.findAll", query = "SELECT r FROM RespuestaPqr r")
    , @NamedQuery(name = "RespuestaPqr.findByIdRespuesta", query = "SELECT r FROM RespuestaPqr r WHERE r.idRespuesta = :idRespuesta")
    , @NamedQuery(name = "RespuestaPqr.findByObservacion", query = "SELECT r FROM RespuestaPqr r WHERE r.observacion = :observacion")
    , @NamedQuery(name = "RespuestaPqr.findByRespuesta", query = "SELECT r FROM RespuestaPqr r WHERE r.respuesta = :respuesta")
    , @NamedQuery(name = "RespuestaPqr.findByEstado", query = "SELECT r FROM RespuestaPqr r WHERE r.estado = :estado")
    , @NamedQuery(name = "RespuestaPqr.findByFechaRespuesta", query = "SELECT r FROM RespuestaPqr r WHERE r.fechaRespuesta = :fechaRespuesta")})
public class RespuestaPqr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_respuesta")
    private Integer idRespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "respuesta")
    private String respuesta;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_respuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRespuesta;
    @JoinColumn(name = "id_pqr", referencedColumnName = "id_pqr")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pqr idPqr;

    public RespuestaPqr() {
    }

    public RespuestaPqr(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public RespuestaPqr(Integer idRespuesta, String observacion, String respuesta, Date fechaRespuesta) {
        this.idRespuesta = idRespuesta;
        this.observacion = observacion;
        this.respuesta = respuesta;
        this.fechaRespuesta = fechaRespuesta;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Pqr getIdPqr() {
        return idPqr;
    }

    public void setIdPqr(Pqr idPqr) {
        this.idPqr = idPqr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestaPqr)) {
            return false;
        }
        RespuestaPqr other = (RespuestaPqr) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.RespuestaPqr[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
