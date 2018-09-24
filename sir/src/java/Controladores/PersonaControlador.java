/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controladores;

import Entidades.Cocinero;
import Entidades.Persona;
import Entidades.Sucursal;
import Facade.PersonaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario PC
 */
@Named(value = "personaControlador")
@SessionScoped
public class PersonaControlador implements Serializable {
    
    /**
     * Creates a new instance of PersonaController
     */
    @EJB
            PersonaFacade personaFacade;
    private Persona persona;
    private Sucursal sucursal;
    private Cocinero cocinero;
    
    public PersonaControlador() {
        persona = new Persona();
        sucursal = new Sucursal();
        cocinero = new Cocinero();
    }
    public Persona getPersona() {
        return persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public Sucursal getSucursal() {
        return sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    public Cocinero getCocinero() {
        return cocinero;
    }
    
    public void setCocinero(Cocinero cocinero) {
        this.cocinero = cocinero;
    }
    
    public enum Tipodoc{
        cc,ccextra,nit
    }
    public enum Tipoper{
        cliente, cajero,cocinero
    }
    public Tipoper[] listarper(){
        Tipoper[] tipo =  Tipoper.values();
        return tipo;
    }
    public enum TipoCliente{
        nuevo, frecuente
    }
    public TipoCliente[] listaTipoC(){
        TipoCliente[] tipoc = TipoCliente.values();
        return tipoc;
    }
    public Tipodoc[] listardoc(){
        Tipodoc[] tipo =  Tipodoc.values();
        return tipo;
    }
    public enum rol{
        Cajero, Cocinero
    }
    
    public rol[] rol(){
        rol[] roles = rol.values();
        return roles;
    }
    public void registrar(){
        String men;
        int reg;
        reg = personaFacade.registrarCliente(persona.getNumeroDocumento(), persona.getTipoDocumento(), persona.getNombre(), persona.getApellido(), persona.getCorreo(), persona.getTelefono());
        if (reg!=0) {
            men="Persona ingresada correctamente";
            
        }else{
            men = "Error en el registro";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Informacion",  men) );
        
    }
    public void registrarEmpleado(){
        String men;
        int reg1=personaFacade.registrarEmpleado(persona.getNumeroDocumento(), persona.getTipoDocumento(), persona.getNombre(), persona.getApellido(), persona.getCorreo(), persona.getTelefono(), persona.getTipoPersona(), sucursal.getIdSucursales());
        if (reg1!=0) {
            men="Persona ingresada correctamente";
            
        }else{
            men = "Error en el registro";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Informacion",  men) );
    }
    public List<Persona> listar(){
        return personaFacade.findAll();
    }
        public List<Persona> listaempleados (){
        List<Persona> lis = personaFacade.empleadosregistrados();
        if (lis!=null) {
            System.out.println("vista");
        }
        else { System.out.println("vista nula");
        }
        return lis;
    }
}
