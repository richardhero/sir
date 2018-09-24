/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Cliente;
import Facade.ClienteFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Usuario PC
 */
@Named(value = "clienteControlador")
@SessionScoped
public class ClienteControlador implements Serializable {

    /**
     * Creates a new instance of ClienteControlador
     */
    @EJB
    ClienteFacade clienteFacade;
    private Cliente clienteIngresado;
    public ClienteControlador() {
        clienteIngresado = new Cliente();
    }

    public Cliente getClienteIngresado() {
        return clienteIngresado;
    }

    public void setClienteIngresado(Cliente clienteIngresado) {
        this.clienteIngresado = clienteIngresado;
    }
    public void ingresarCliente(int ced){
        clienteIngresado=clienteFacade.find(ced);
    }
}
