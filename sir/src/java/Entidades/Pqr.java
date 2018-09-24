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
import javax.persistence.Lob;
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
@Table(name = "pqr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqr.findAll", query = "SELECT p FROM Pqr p")
    , @NamedQuery(name = "Pqr.findByIdPqr", query = "SELECT p FROM Pqr p WHERE p.idPqr = :idPqr")
    , @NamedQuery(name = "Pqr.findByTipoPqr", query = "SELECT p FROM Pqr p WHERE p.tipoPqr = :tipoPqr")
    , @NamedQuery(name = "Pqr.findByAsuntoPqr", query = "SELECT p FROM Pqr p WHERE p.asuntoPqr = :asuntoPqr")
    , @NamedQuery(name = "Pqr.findByDescripcionPqr", query = "SELECT p FROM Pqr p WHERE p.descripcionPqr = :descripcionPqr")
    , @NamedQuery(name = "Pqr.findByEstado", query = "SELECT p FROM Pqr p WHERE p.estado = :estado")
    , @NamedQuery(name = "Pqr.findByFecha", query = "SELECT p FROM Pqr p WHERE p.fecha = :fecha")})
public class Pqr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pqr")
    private Integer idPqr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_pqr")
    private String tipoPqr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "asunto_pqr")
    private String asuntoPqr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion_pqr")
    private String descripcionPqr;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "archivo")
    private String archivo;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona numeroDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPqr", fetch = FetchType.EAGER)
    private List<RespuestaPqr> respuestaPqrList;

    public Pqr() {
    }

    public Pqr(Integer idPqr) {
        this.idPqr = idPqr;
    }

    public Pqr(Integer idPqr, String tipoPqr, String asuntoPqr, String descripcionPqr, Date fecha) {
        this.idPqr = idPqr;
        this.tipoPqr = tipoPqr;
        this.asuntoPqr = asuntoPqr;
        this.descripcionPqr = descripcionPqr;
        this.fecha = fecha;
    }

    public Integer getIdPqr() {
        return idPqr;
    }

    public void setIdPqr(Integer idPqr) {
        this.idPqr = idPqr;
    }

    public String getTipoPqr() {
        return tipoPqr;
    }

    public void setTipoPqr(String tipoPqr) {
        this.tipoPqr = tipoPqr;
    }

    public String getAsuntoPqr() {
        return asuntoPqr;
    }

    public void setAsuntoPqr(String asuntoPqr) {
        this.asuntoPqr = asuntoPqr;
    }

    public String getDescripcionPqr() {
        return descripcionPqr;
    }

    public void setDescripcionPqr(String descripcionPqr) {
        this.descripcionPqr = descripcionPqr;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Persona numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @XmlTransient
    public List<RespuestaPqr> getRespuestaPqrList() {
        return respuestaPqrList;
    }

    public void setRespuestaPqrList(List<RespuestaPqr> respuestaPqrList) {
        this.respuestaPqrList = respuestaPqrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPqr != null ? idPqr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pqr)) {
            return false;
        }
        Pqr other = (Pqr) object;
        if ((this.idPqr == null && other.idPqr != null) || (this.idPqr != null && !this.idPqr.equals(other.idPqr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pqr[ idPqr=" + idPqr + " ]";
    }
    
}
