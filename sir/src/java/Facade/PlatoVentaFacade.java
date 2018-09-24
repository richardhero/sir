/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.PlatoVenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Richard HERO
 */
@Stateless
public class PlatoVentaFacade extends AbstractFacade<PlatoVenta> {

    @PersistenceContext(unitName = "ProyectorSirPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlatoVentaFacade() {
        super(PlatoVenta.class);
    }
     public void registarVenta(int codfac, int totventa, int numdoc){
        try {
            Query query = em.createNativeQuery("call registroVenta(?,?,?)");
            query.setParameter(1, codfac);
            query.setParameter(2, totventa);
            query.setParameter(3, numdoc);
            query.executeUpdate();
        } catch (Exception e) {
            System.out.println("errorrr: "+ e.getMessage());
        }
        
    }
    public void registrarProductosDeLaVenta(int can,int idpla, int numdoc,String nompla, int prepla, double total){
        try {
            Query query = em.createNativeQuery("call registroPlato(?,?,?,?,?,?)");
            query.setParameter(1, can);
            query.setParameter(2, idpla);
            query.setParameter(3, numdoc);
            query.setParameter(4, nompla);
            query.setParameter(5, prepla);
            query.setParameter(6, total);
            query.executeUpdate();
        } catch (Exception e) {
            System.out.println("errorrrr1= "+e.getMessage());
        }
        
    }
}
