/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Bodega;
import Facade.BodegaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author julio
 */
@Named(value = "bodegaControlador")
@SessionScoped
public class BodegaControlador implements Serializable {

    @EJB
    BodegaFacade bodegaFacade;
    private Bodega bodega;
    public BodegaControlador() {
        bodega =  new Bodega();
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    
    public void agregarBodega(){
       bodegaFacade.create(bodega);
       bodega = new Bodega();
    }
    public void eliminarBodega(Bodega newBodega){
        bodega = newBodega;
        bodegaFacade.remove(bodega);
        bodega = new Bodega();
    }
    public String editarBodega(Bodega newBodega){
        bodega = newBodega;
        return "/Bodega/Modificar";
    }
    public String editarBodega(){
        bodegaFacade.edit(bodega);
        bodega = new Bodega();
        return "/Bodega/Listar";
    }
    public List<Bodega> listarBodega(){
        return bodegaFacade.findAll();
    }
}
