/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Receta;
import Facade.RecetaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author julio
 */
@Named(value = "recetaControlador")
@SessionScoped
public class RecetaControlador implements Serializable {
    @EJB
    RecetaFacade recetaFacade;
    private Receta receta;
    public RecetaControlador() {
        receta = new Receta();
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
    
    public void agregarReceta(){
      recetaFacade.create(receta);
      receta = new Receta();
      }
    public void eliminarReceta(Receta newReceta){
        receta = newReceta;
        recetaFacade.remove(receta);
        receta = new Receta();
    }
    public String editarReceta(Receta newReceta){
        receta = newReceta;
        return "/Receta/Modificar";
    }
    public String editarReceta(){
        recetaFacade.edit(receta);
        receta = new Receta();
        return "/Receta/Listar";
    }
    public List<Receta> listarReceta(){
        return recetaFacade.findAll();
    }
    
}
