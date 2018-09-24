/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Cliente;
import Entidades.Reserva;
import Entidades.Sucursal;
import Facade.ReservaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author carlo
 */
@Named(value = "reservaControlador")
@SessionScoped
public class ReservaControlador implements Serializable {

    /**
     * Creates a new instance of ReservaControlador
     */
    @EJB
    ReservaFacade reservaFacade;
    private Sucursal sucursal;
    private Reserva reserva;
    private Cliente cliente;
    public ReservaControlador() {
        cliente = new Cliente();
        reserva = new Reserva();
        sucursal = new Sucursal();
    }
    


    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
        
    public String registrarReserva(){
        reserva.setIdCliente(cliente);
        reserva.setIdSucursales(sucursal);
        reservaFacade.create(reserva);
        reserva = new Reserva();
        return "/Menus/MenuReservaCliente.xhtml";
        
    }
    public void editarReserva(Reserva newReserva){
        reserva = newReserva;
    }
    public void editarReserva(){
        reserva.setIdCliente(cliente);
        reserva.setIdSucursales(sucursal);
        reservaFacade.edit(reserva);
        reserva = new Reserva();
    }
    public void eliminarReserva(Reserva newReserva){
        reserva = newReserva;
        reservaFacade.remove(reserva);
        reserva = new Reserva();
    }
    public List<Reserva> listarReserva(){
        return reservaFacade.findAll();
    }
    
}
