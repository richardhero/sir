/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Plato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Richard HERO
 */
@Stateless
public class PlatoFacade extends AbstractFacade<Plato> {

    @PersistenceContext(unitName = "ProyectorSirPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlatoFacade() {
        super(Plato.class);
    }
        public Plato datosPlato(int idplato){
        try {
           Query q = em.createNativeQuery("select * from plato where id_plato=?");
        q.setParameter(1, idplato);
        return (Plato) q.getSingleResult(); 
        } catch (Exception e) {
            System.out.println("mire huevon:" + e.getMessage());
        }
        return null;
    }
}
