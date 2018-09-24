/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Caja;
import Entidades.Plato;
import Entidades.PlatoVenta;
import Entidades.Venta;
import Facade.PlatoFacade;
import Facade.PlatoVentaFacade;
import Facade.VentaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Usuario PC
 */
@Named(value = "platoVentaControlador")
@SessionScoped
public class PlatoVentaControlador implements Serializable {

    /**
     * Creates a new instance of PlatoVentaControlador
     */
    @EJB
    PlatoVentaFacade platoVentaFacade;
    VentaFacade ventaFacade;
    private PlatoVenta platoVenta;
    private List<PlatoVenta> lis1;
    private Plato plato;
    private Venta venta;
    PlatoFacade platoFacade;
    private int cantidad;
    private int ventatotal=0;

    
    public PlatoVentaControlador() {
       
        platoVenta = new PlatoVenta();
        lis1 = new ArrayList<>();
        plato = new Plato();
        venta = new Venta();
    }
        public int getVentatotal() {
        return ventatotal;
    }

    public void setVentatotal(int ventatotal) {
        this.ventatotal = ventatotal;
    }
    
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    public PlatoVenta getPlatoVenta() {
        return platoVenta;
    }

    public void setPlatoVenta(PlatoVenta platoVenta) {
        this.platoVenta = platoVenta;
    }

    public List<PlatoVenta> getLis1() {
        return lis1;
    }

    public void setLis1(List<PlatoVenta> lis1) {
        this.lis1 = lis1;
    }
    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     public void lista(Plato idplato){
         try {
             if (this.cantidad!=0) {
                 int total;
                 total=this.cantidad*idplato.getPrecio();
                 System.out.println("este es el total "+total);
                 this.lis1.add(new PlatoVenta(null, this.cantidad, idplato.getNombrePlato(), idplato.getPrecio(), total, null, idplato));
                 FacesContext context = FacesContext.getCurrentInstance();
                 context.addMessage(null, new FacesMessage("Informacion",  "Producto Agregado"));
                 venta.setTotal(this.calcularTotal());
             }else{
                 FacesContext context = FacesContext.getCurrentInstance();
                 context.addMessage(null, new FacesMessage("Informacion",  "El cantidad del producto no puede ser igual a 0"));
             }
         }
         catch (Exception e) {
         }
         
     }
    public void eliminarProducto(PlatoVenta pl){
        this.lis1.remove(pl);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Informacion",  "Se elimino el producto de la venta") );
        venta.setTotal(this.calcularTotal());
    }
    public List<PlatoVenta> listar(){
        return lis1;
    }
    public int calcularTotal(){
        int totalFactura=0;
        for (PlatoVenta item : lis1) {
            int totalVentaPorPorducto= item.getPrecio()*item.getCantidades();
            item.setTotal(totalVentaPorPorducto);
            totalFactura= totalFactura+totalVentaPorPorducto;
        }
        return totalFactura;
    }

        public void onRowEdit(RowEditEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Informacion",  "Se guardo el camobio") );
        venta.setTotal(this.calcularTotal());
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Informacion",  "No se guardo el camobio") );
    }
    public void registrarVenta(int codfac, int totventa, int numdoc){
        try {
            platoVentaFacade.registarVenta(codfac, totventa, numdoc);
            int i=0;
            do {
                platoVentaFacade.registrarProductosDeLaVenta(this.cantidad, lis1.get(i).getIdPlato().getIdPlato(), numdoc, lis1.get(i).getNombre(), lis1.get(i).getPrecio(), lis1.get(i).getTotal());
                i=i+1;
                System.out.println("cantidad de veces hecho= " + i);
            } while (i<lis1.size());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion",  "Se registro la venta correctamente") );
            lis1 = new ArrayList<>();
            ventatotal=(int) (ventatotal+venta.getTotal());
            venta.setTotal(0);
        } catch (Exception e) {
            System.out.println("el error ess= "+e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion",  "Error registrar la venta ") );
        }
        
    }
    public void reiniciarTotal(){
        this.ventatotal=0;
    }
    
    private boolean enabled;
    
    public void enabledButton(){
        enabled=true;
    }
    public void disabledButton(){
        enabled=false;
    }
    public boolean isEnabled() {
        return enabled;
    }


    
    
}
