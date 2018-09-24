/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Platoseguimiento;
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
public class PlatoseguimientoFacade extends AbstractFacade<Platoseguimiento> {

    @PersistenceContext(unitName = "ProyectorSirPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlatoseguimientoFacade() {
        super(Platoseguimiento.class);
    }
    public List<Platoseguimiento> listar(){
        try {
            Query query = em.createNativeQuery("select * from platoseguimimento", Platoseguimiento.class);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("eeerror: "+ e.getMessage());
            return null;
        }
        
    }
}
