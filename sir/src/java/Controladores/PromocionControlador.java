/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Cliente;
import Entidades.Plato;
import Entidades.Promocion;
import Facade.PromocionFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author carlo
 */
@Named(value = "promocionControlador")
@SessionScoped
public class PromocionControlador implements Serializable {

    /**
     * Creates a new instance of PromocionControlador
     */
    @EJB
    PromocionFacade promocionFacade;
    private Promocion promocion;
    private Cliente cliente;
    private Plato plato;
    public PromocionControlador() {
        
        cliente = new Cliente();
        promocion = new Promocion();
        plato = new Plato();
    }
    

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
    
    
    public void registrarPromocion(){
        promocion.setIdPlato(plato);
        promocion.setIdCliente(cliente);
        promocionFacade.create(promocion);
        promocion = new Promocion();
        
    }
    public void editarPromocion(Promocion newPromocion){
        promocion = newPromocion;
    }
    public void editarPromocion2(){
        promocion.setIdPlato(plato);
        promocion.setIdCliente(cliente);
        promocionFacade.edit(promocion);
        promocion = new Promocion();
        
    }
    public void eliminarPromocion(Promocion newPromocion){
        promocion = newPromocion;
        promocionFacade.remove(promocion);
        promocion = new Promocion();
        
    }
    public List<Promocion> listarPromocion(){
        return promocionFacade.findAll();
    }
}
