/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Bodega;
import Entidades.Desperdicio;

import Entidades.Producto;
import Entidades.Receta;
import Facade.ProductoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import static java.util.Collections.list;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import java.util.Collections;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author julio
 */
@Named(value = "productoControlador")
@SessionScoped
public class ProductoControlador implements Serializable {

    @EJB
    ProductoFacade productoFacade;
    private Desperdicio desperdicio;
    private Bodega bodega;
    private Receta receta;
    private Producto producto;
    
    public ProductoControlador() {
        producto = new Producto();
        desperdicio = new Desperdicio();
        bodega = new Bodega();
        receta = new Receta();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public void agregarProducto(){
        producto.setIdBodega(bodega);
        producto.setIdDesperdicio(desperdicio);
        producto.setIdReceta(receta);
        productoFacade.create(producto);
        producto = new Producto();
    }
    public void eliminarProducto(Producto newProducto){
        producto = newProducto;
        productoFacade.remove(producto);
        producto = new Producto ();
    }
    public String editarProducto(Producto newProducto){
        producto = newProducto;
        return "/Producto/Modificar";
    }
    public String editarProducto(){
        producto.setIdReceta(receta);
        producto.setIdDesperdicio(desperdicio);
        producto.setIdBodega(bodega);
        productoFacade.edit(producto);
        producto = new Producto();
        return "/Producto/Listar";
    }
    
    public List<Producto> listarProducto (){
        return productoFacade.findAll();
    }

    public Desperdicio getDesperdicio() {
        return desperdicio;
    }

    public void setDesperdicio(Desperdicio desperdicio) {
        this.desperdicio = desperdicio;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
    public ProductoControlador Suma (Desperdicio param){
        this.desperdicio.cantidad = param.cantidad;
        return this;
    }
   
}


   
    
    
        
    
    

