/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Cocinero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Richard HERO
 */
@Stateless
public class CocineroFacade extends AbstractFacade<Cocinero> {

    @PersistenceContext(unitName = "ProyectorSirPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CocineroFacade() {
        super(Cocinero.class);
    }
    
}
