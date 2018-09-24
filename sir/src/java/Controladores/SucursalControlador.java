/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Sucursal;
import Facade.SucursalFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Usuario PC
 */
@Named(value = "sucursalControlador")
@SessionScoped
public class SucursalControlador implements Serializable {

    /**
     * Creates a new instance of SucursalControlador
     */
    @EJB
    SucursalFacade sucursalFacade;
    Sucursal sucursal;
    public SucursalControlador() {
        sucursal = new Sucursal();
        sucursalFacade = new SucursalFacade();
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    public List<Sucursal> listaSuc(){
        return sucursalFacade.findAll();
    }
}
