/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Desperdicio;
import Facade.DesperdicioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;


/**
 *
 * @author julio
 */
@Named(value = "desperdicioControlador")
@SessionScoped
public class DesperdicioControlador implements Serializable {

    @EJB
    DesperdicioFacade desperdicioFacade;
    private Desperdicio desperdicio;
    public DesperdicioControlador() {
        desperdicio = new Desperdicio();
    }

    public Desperdicio getDesperdicio() {
        return desperdicio;
    }

    public void setDesperdicio(Desperdicio desperdicio) {
        this.desperdicio = desperdicio;
    }
    
    public void agregarDesperdicio (){
        desperdicioFacade.create(desperdicio);
        desperdicio = new Desperdicio();
    }
    public void eliminarDesperdicio(Desperdicio newDesperdicio){
        desperdicio = newDesperdicio;
        desperdicioFacade.remove(desperdicio);
        desperdicio = new Desperdicio();
    }
    public String editarDesperdicio(Desperdicio newDesperdicio){
        desperdicio = newDesperdicio;
        return "/Desperdicio/Modificar";
    }
    public String editarDesperdicio(){
        desperdicioFacade.edit(desperdicio);
        desperdicio = new Desperdicio();
        return "/Desperdicio/Listar";
    }
    public List<Desperdicio> listarDesperdicio(){
        return desperdicioFacade.findAll();
    }
    
}
