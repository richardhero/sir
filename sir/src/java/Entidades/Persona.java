/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Richard HERO
 */
@Entity
@Table(name = "personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByNumeroDocumento", query = "SELECT p FROM Persona p WHERE p.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Persona.findByTipoDocumento", query = "SELECT p FROM Persona p WHERE p.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo")
    , @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Persona.findByTipoPersona", query = "SELECT p FROM Persona p WHERE p.tipoPersona = :tipoPersona")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_documento")
    private Integer numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private Integer telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo_persona")
    private String tipoPersona;
    @OneToMany(mappedBy = "numeroDocumento", fetch = FetchType.EAGER)
    private List<Productividad> productividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroDocumento", fetch = FetchType.EAGER)
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroDocumento", fetch = FetchType.EAGER)
    private List<Pqr> pqrList;
    @OneToMany(mappedBy = "numeroDocumento", fetch = FetchType.EAGER)
    private List<Cocinero> cocineroList;
    @JoinColumn(name = "id_sucursales", referencedColumnName = "id_sucursales")
    @ManyToOne(fetch = FetchType.EAGER)
    private Sucursal idSucursales;
    @OneToMany(mappedBy = "numeroDocumento", fetch = FetchType.EAGER)
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroDocumento", fetch = FetchType.EAGER)
    private List<Turno> turnoList;
    @OneToMany(mappedBy = "numeroDocumento", fetch = FetchType.EAGER)
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroDocumento", fetch = FetchType.EAGER)
    private List<Caja> cajaList;

    public Persona() {
    }

    public Persona(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Persona(Integer numeroDocumento, String tipoDocumento, String nombre, String apellido, String correo, String tipoPersona) {
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.tipoPersona = tipoPersona;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    @XmlTransient
    public List<Productividad> getProductividadList() {
        return productividadList;
    }

    public void setProductividadList(List<Productividad> productividadList) {
        this.productividadList = productividadList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Pqr> getPqrList() {
        return pqrList;
    }

    public void setPqrList(List<Pqr> pqrList) {
        this.pqrList = pqrList;
    }

    @XmlTransient
    public List<Cocinero> getCocineroList() {
        return cocineroList;
    }

    public void setCocineroList(List<Cocinero> cocineroList) {
        this.cocineroList = cocineroList;
    }

    public Sucursal getIdSucursales() {
        return idSucursales;
    }

    public void setIdSucursales(Sucursal idSucursales) {
        this.idSucursales = idSucursales;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Turno> getTurnoList() {
        return turnoList;
    }

    public void setTurnoList(List<Turno> turnoList) {
        this.turnoList = turnoList;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<Caja> getCajaList() {
        return cajaList;
    }

    public void setCajaList(List<Caja> cajaList) {
        this.cajaList = cajaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.numeroDocumento == null && other.numeroDocumento != null) || (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Persona[ numeroDocumento=" + numeroDocumento + " ]";
    }
    
}
