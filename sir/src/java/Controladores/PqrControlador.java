/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Persona;
import Entidades.Pqr;
import Facade.PqrFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author carlo
 */
@Named(value = "pqrControlador")
@SessionScoped
public class PqrControlador implements Serializable {

    /**
     * Creates a new instance of PqrControlador
     */
    @EJB
    PqrFacade pqrFacade;
    private Persona persona;
    private Pqr pqr;
    public PqrControlador() {
        persona = new Persona();
        pqr = new Pqr();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Pqr getPqr() {
        return pqr;
    }

    public void setPqr(Pqr pqr) {
        this.pqr = pqr;
    }

    public String registrarPqr(){
       pqr.setNumeroDocumento(persona);
       pqrFacade.create(pqr);
       pqr = new Pqr();
       return "/Menus/MenuPqrCliente.xhtml";
    }
    public List<Pqr> listarPqr(){
       return pqrFacade.findAll();
    }
    public enum estadoPqr{
        Sugerencia, Queja, Reclamo
    }
    public estadoPqr[] listaEstadoPqr(){
       estadoPqr [] estadol= estadoPqr.values();
       return estadol;
    } 
    
}

