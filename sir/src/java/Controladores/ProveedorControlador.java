
package Controladores;

import Entidades.Proveedor;
import Facade.ProveedorFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Usuario PC
 */
@Named(value = "proveedorControlador")
@SessionScoped
public class ProveedorControlador implements Serializable {

    /**
     * Creates a new instance of ProveedorControlador
     */
    @EJB
    ProveedorFacade proveedorFacade;
    Proveedor proveedor;
    public ProveedorControlador() {
        proveedor =new Proveedor();
    }
    public void registrarProveedor(){
        proveedorFacade.create(proveedor);
        proveedor = new Proveedor();
    }
    public String editarProveedor(Proveedor newproveedor){
        proveedor = new Proveedor();
        return "/Proveedor/Modificar";
    }
    public String editarProveedor(){
        proveedorFacade.edit(proveedor);
        proveedor = new Proveedor(); 
        return "/Producto/Listar";        
    }
    public void eliminarProveedor(Proveedor newProveedor){
        proveedor = newProveedor;
        proveedorFacade.remove(proveedor);
        proveedor = new Proveedor();
        
    }
    public List<Proveedor> listarProveedor(){
        return proveedorFacade.findAll();
    }
}
