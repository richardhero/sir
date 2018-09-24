/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Caja;
import Entidades.Persona;
import Facade.CajaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import Controladores.UsuarioControlador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario PC
 */
@Named(value = "cajaControlador")
@SessionScoped

public class CajaControlador implements Serializable {

    @EJB
    CajaFacade cajaFacade;
    @ManagedProperty(value = "#{usuarioControlador}")
    private UsuarioControlador usuarioControlador;
    private Caja caja;
    private Persona persona;
    private Caja cajaabierta;
    private List<Caja> lis;

    public CajaControlador() {
        caja = new Caja();
        cajaabierta = new Caja();
        persona = new Persona();
        lis = new ArrayList<>();
    }

    public List<Caja> listar() {
        this.lis = cajaFacade.listar();
        return lis;
    }

    public List<Caja> getLis() {
        return lis;
    }

    public void setLis(List<Caja> lis) {
        this.lis = lis;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Caja getCajaabierta() {
        return cajaabierta;
    }

    public void setCajaabierta(Caja cajaabierta) {
        this.cajaabierta = cajaabierta;
    }

    public UsuarioControlador getUsuarioControlador() {
        return usuarioControlador;
    }

    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }

    public void iniciocaja(int cedula) {
        cajaabierta = new Caja();
        String men = "";
        cajaabierta = cajaFacade.inicioCaja(caja.getNoCaja(), caja.getBaseInicial(), cedula);
        if (cajaabierta != null) {
            System.out.println(cajaabierta.getBaseInicial());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("caja1", cajaabierta);
            cajaabierta = (Caja) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("caja1");
            System.out.println("caja no " + cajaabierta.getIdCaja());
            men = "Caja iniciada correctamente";
            enabled = true;

        } else {
            men = "Error al registrar el inicio de la caja";
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Informacion", men));
    }

    public void cerrarCaja(int ced) {
        System.out.println("caja# " + cajaabierta.getIdCaja());
        System.out.println("caja#2 " + caja.getBaseFinal());
        int ccaja;
        try {
            ccaja = cajaFacade.cierreCaja(cajaabierta.getIdCaja(), caja.getBaseFinal());
            if (ccaja != 0) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Informacion", "Caja cerrada Exitosamente"));
                enabled = false;
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Informacion", "Error al cerrar la caja"));
            }
        } catch (Exception e) {
            System.out.println("paso: " + e.getMessage());
        }
    }

    public enum estado {
        Activa, Paga
    }

    public estado[] listaEstado() {
        estado[] est = estado.values();
        return est;
    }

    private boolean enabled;

    public void enabledButton() {
        enabled = true;
    }

    public void disabledButton() {
        enabled = false;
    }

    public boolean isEnabled() {
        return enabled;
    }

}
