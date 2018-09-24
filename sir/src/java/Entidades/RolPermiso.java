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
@Table(name = "roles_permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolPermiso.findAll", query = "SELECT r FROM RolPermiso r")
    , @NamedQuery(name = "RolPermiso.findByIdRolesPermisos", query = "SELECT r FROM RolPermiso r WHERE r.idRolesPermisos = :idRolesPermisos")})
public class RolPermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_roles_permisos")
    private Integer idRolesPermisos;
    @JoinColumn(name = "id_roles", referencedColumnName = "id_roles")
    @ManyToOne(fetch = FetchType.EAGER)
    private Rol idRoles;
    @JoinColumn(name = "id_permisos", referencedColumnName = "id_permisos")
    @ManyToOne(fetch = FetchType.EAGER)
    private Permiso idPermisos;

    public RolPermiso() {
    }

    public RolPermiso(Integer idRolesPermisos) {
        this.idRolesPermisos = idRolesPermisos;
    }

    public Integer getIdRolesPermisos() {
        return idRolesPermisos;
    }

    public void setIdRolesPermisos(Integer idRolesPermisos) {
        this.idRolesPermisos = idRolesPermisos;
    }

    public Rol getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(Rol idRoles) {
        this.idRoles = idRoles;
    }

    public Permiso getIdPermisos() {
        return idPermisos;
    }

    public void setIdPermisos(Permiso idPermisos) {
        this.idPermisos = idPermisos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolesPermisos != null ? idRolesPermisos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPermiso)) {
            return false;
        }
        RolPermiso other = (RolPermiso) object;
        if ((this.idRolesPermisos == null && other.idRolesPermisos != null) || (this.idRolesPermisos != null && !this.idRolesPermisos.equals(other.idRolesPermisos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.RolPermiso[ idRolesPermisos=" + idRolesPermisos + " ]";
    }
    
}
