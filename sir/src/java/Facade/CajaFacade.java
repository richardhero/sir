/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Caja;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Richard HERO
 */
@Stateless
public class CajaFacade extends AbstractFacade<Caja> {

    @PersistenceContext(unitName = "ProyectorSirPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CajaFacade() {
        super(Caja.class);
    }
    public Caja inicioCaja(int nocaja, int baseinicial,int numdoc){
        Caja caja=null;
        try {
            Query query = em.createNativeQuery("call inicioCaja(?,?,?)");   
            query.setParameter(1, nocaja);
            query.setParameter(2, baseinicial);
            query.setParameter(3, numdoc);
            query.executeUpdate();
            Query query1 = em.createNativeQuery("select * from caja order by id_caja desc limit 1",Caja.class);
            caja=(Caja) query1.getSingleResult();
            
        } catch (Exception e) {
            System.out.println("Error= " + e.getMessage());
        }
    return caja;
    }
    
        public int cierreCaja(int idcaja, int baseFinal){
        int caja=0;
        try {
            Query query = em.createNativeQuery("call cierreCaja(?,?)");   
            query.setParameter(1, idcaja);
            query.setParameter(2, baseFinal);
            query.executeUpdate();
            caja=1;
            return caja;
        } catch (Exception e) {
            System.out.println("Error= " + e.getMessage());
            return caja;
        }
    
    }
    public List<Caja> listar(){
        try {
            Query query = em.createNativeQuery("select * from caja",Caja.class);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("error de lista= "+ e.getMessage());
            return null;
        }
    }
}
