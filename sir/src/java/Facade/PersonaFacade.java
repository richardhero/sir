/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Persona;
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
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "ProyectorSirPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
        public List<Persona> empleadosregistrados (){ 
        Query listaempleados = em.createNativeQuery("select * from empleadosregistrados",Persona.class);
        List<Persona> empleadosregistrados  = listaempleados.getResultList();
        return empleadosregistrados;
    }
        
    public int registrarCliente(int numc, String tipodoc, String nombre, String apellido, String correo, int telefono){
         int persona=0;
        try{
            Query reg = em.createNativeQuery("call registroCliente(?,?,?,?,?,?)");
            reg.setParameter(1, numc);
            reg.setParameter(2, tipodoc);
            reg.setParameter(3, nombre);
            reg.setParameter(4, apellido);
            reg.setParameter(5, correo);
            reg.setParameter(6, telefono);
            reg.executeUpdate();
            persona=1;
        }catch(Exception e){
            System.out.println("error :" + e.getMessage());
        }
        
        return persona;
    }
    
    public int registrarEmpleado(int numc, String tipodoc, String nombre, String apellido, String correo, int telefono, String tipoper, int suc){
         int persona=0;
        try{
            Query reg = em.createNativeQuery("call registroEmpleado(?,?,?,?,?,?,?,?)");
            reg.setParameter(1, numc);
            reg.setParameter(2, tipodoc);
            reg.setParameter(3, nombre);
            reg.setParameter(4, apellido);
            reg.setParameter(5, correo);
            reg.setParameter(6, telefono);
            reg.setParameter(7, tipoper);
            reg.setParameter(8, suc);
            reg.executeUpdate();
            persona=1;
        }catch(Exception e){
            System.out.println("error :" + e.getMessage());
        }
        
        return persona;
    }
}


