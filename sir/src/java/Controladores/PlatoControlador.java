/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Plato;
import Entidades.Venta;
import Facade.PlatoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author julio
 */
@Named(value = "platoControlador")
@SessionScoped
public class PlatoControlador implements Serializable {

    @EJB
    PlatoFacade platoFacade;
    private Plato plato;
    private Venta venta;
    public PlatoControlador() {
        plato = new Plato();
        venta = new Venta();
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    public void agregarPlato(){
        platoFacade.create(plato);
        plato = new Plato();
    }
    public void eliminarPlato(Plato newPlato){
        plato = newPlato;
        platoFacade.remove(plato);
        plato = new Plato();
    }
    public String editarPlato(Plato newPlato){
        plato = newPlato;
        return"/Plato/Modificar";
    }
    public String editarPlato(){
       
        platoFacade.edit(plato);
        plato = new Plato();
        return "/Plato/Listar";
    }
    public List<Plato> listarPlato(){
    return platoFacade.findAll();
    }
    
    
}
