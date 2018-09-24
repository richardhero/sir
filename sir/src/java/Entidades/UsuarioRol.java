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
@Table(name = "usuarios_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u")
    , @NamedQuery(name = "UsuarioRol.findByIdUsuariosRoles", query = "SELECT u FROM UsuarioRol u WHERE u.idUsuariosRoles = :idUsuariosRoles")})
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuarios_roles")
    private Integer idUsuariosRoles;
    @JoinColumn(name = "id_roles", referencedColumnName = "id_roles")
    @ManyToOne(fetch = FetchType.EAGER)
    private Rol idRoles;
    @JoinColumn(name = "id_usuarios", referencedColumnName = "id_usuarios")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario idUsuarios;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer idUsuariosRoles) {
        this.idUsuariosRoles = idUsuariosRoles;
    }

    public Integer getIdUsuariosRoles() {
        return idUsuariosRoles;
    }

    public void setIdUsuariosRoles(Integer idUsuariosRoles) {
        this.idUsuariosRoles = idUsuariosRoles;
    }

    public Rol getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(Rol idRoles) {
        this.idRoles = idRoles;
    }

    public Usuario getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuario idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuariosRoles != null ? idUsuariosRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.idUsuariosRoles == null && other.idUsuariosRoles != null) || (this.idUsuariosRoles != null && !this.idUsuariosRoles.equals(other.idUsuariosRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.UsuarioRol[ idUsuariosRoles=" + idUsuariosRoles + " ]";
    }
    
}
