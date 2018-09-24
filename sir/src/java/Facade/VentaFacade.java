/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Venta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Richard HERO
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> {

    @PersistenceContext(unitName = "ProyectorSirPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }
    public int obtenerMaximodeRegistros(){
        try {
            Query q = em.createNativeQuery("select * from ventas");
            return q.getResultList().size();
        } catch (Exception e) {
            System.out.println("eeerror : " + e.getMessage());
            return 0;
        }
    }
    public Venta traerElUltimoRegistro(){
        try {
          Query q = em.createNativeQuery("select * from ventas where cod_factura=(select max(cod_factura) from ventas)", Venta.class);
        return (Venta) q.getSingleResult();  
        } catch (Exception e) {
            System.out.println("eeerror : " + e.getMessage());
        }
        return null;
    }
}
