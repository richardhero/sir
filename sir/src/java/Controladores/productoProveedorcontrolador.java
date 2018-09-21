/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.ProductoProveedor;
import Facade.ProductoProveedorFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Usuario PC
 */
@Named(value = "productoProveedorcontrolador")
@SessionScoped
public class productoProveedorcontrolador implements Serializable {

    @EJB
    ProductoProveedorFacade productoProveedorFacade;        
    private ProductoProveedor productoProveedor;
    private List<ProductoProveedor> lista;
    public productoProveedorcontrolador() {
     lista = new ArrayList<>();
     productoProveedor = new ProductoProveedor();
    }

    public ProductoProveedor getProductoProveedor() {
        return productoProveedor;
    }

    public void setProductoProveedor(ProductoProveedor productoProveedor) {
        this.productoProveedor = productoProveedor;
    }

    public List<ProductoProveedor> getLista() {
        return lista;
    }

    public void setLista(List<ProductoProveedor> lista) {
        this.lista = lista;
    }
    
}
