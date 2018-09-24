/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controladores;

import Entidades.Venta;
import Facade.VentaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Usuario PC
 */
@Named(value = "ventaControlador")
@SessionScoped
public class VentaControlador implements Serializable {
    
    /**
     * Creates a new instance of VentaControlador
     */
    @EJB
            VentaFacade ventaFacade;
    Venta venta;
    private List<Venta> numFac;
    private List venta1;
    private int numFac1;
    public VentaControlador() {
        numFac = new ArrayList<>();
        venta1 = new ArrayList();
        venta = new Venta();
    }
    
    public Venta getVenta() {
        return venta;
    }
    
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public List getVenta1() {
        return venta1;
    }
    
    public void setVenta1(List venta1) {
        this.venta1 = venta1;
    }
    public List<Venta> getnumFac() {
        return numFac;
    }
    
    public void setnumFac(List<Venta> numFac) {
        this.numFac = numFac;
    }
    public int getNumFac1() {
        this.numFac1=ventaFacade.obtenerMaximodeRegistros();
        if (this.numFac1==0) {
            System.out.println("el retorno 2 es "+numFac1);
            this.numFac1=1;
            return numFac1;
        }else{
            venta=ventaFacade.traerElUltimoRegistro();
            this.numFac1=venta.getCodFactura()+1;
            return numFac1;
        }
    }
    
    public void setNumFac1(int numFac1) {
        this.numFac1 = numFac1;
    }
}
