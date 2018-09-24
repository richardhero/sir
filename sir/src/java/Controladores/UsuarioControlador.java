/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Usuario;
import Facade.PersonaFacade;
import Facade.UsuarioFacade;
import Facade.UsuarioRolFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario PC
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class UsuarioControlador implements Serializable {

    /**
     * Creates a new instance of UsuarioControlador
     */
    @EJB
    UsuarioFacade usuarioFacade;
    UsuarioRolFacade usuarioRolFacade;
    private String g;
    Usuario usuario;
    Usuario us;

    public UsuarioControlador() {
        usuario = new Usuario();
        us = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public String ini() {
        String redireccion = "";
        us = usuarioFacade.registrar(usuario.getNombreUsuario(), usuario.getContraseña());

        if (us != null && us.getEstado().equals("Activo")) {
            if (us.getUsuarioRolList().get(0).getIdRoles().getDescripcion().equals("Cliente")) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
                redireccion = "/Cliente/TemplateMenuCliente?faces-redirect=true";
            }
            if (us.getUsuarioRolList().get(0).getIdRoles().getDescripcion().equals("Cajero")) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
                redireccion = "/Cajero/TemplateInicioCajero?faces-redirect=true";
            }
            if (us.getUsuarioRolList().get(0).getIdRoles().getDescripcion().equals("Cocinero")) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
                redireccion = "/Cocinero/TemplateInicioCocinero?faces-redirect=true";
            }
            if (us.getUsuarioRolList().get(0).getIdRoles().getDescripcion().equals("Administrador")) {
                System.out.println("dfghjkl");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Informacion", "Bienvenido"));
                redireccion = "/Administrador/TemplateInicioAdmin?faces-redirect=true";
            }
        } else {

            redireccion = "/index?faces-redirect=true";
        }
        return redireccion;
    }

    public int puntos() {
        int pun = us.getNumeroDocumento().getClienteList().get(0).getPuntos();
        return pun;
    }

    public void editarUsuario() {
        try {
            usuarioFacade.editarUsuario(us.getNumeroDocumento().getNombre(), us.getNumeroDocumento().getApellido(), us.getNumeroDocumento().getCorreo(), us.getNumeroDocumento().getTelefono(), us.getContraseña(), us.getNumeroDocumento().getNumeroDocumento());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion", "Cambios Guardados"));
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        us = new Usuario();
        return "/index?faces-redirect=true";
    }
}
