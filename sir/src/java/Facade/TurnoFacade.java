/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Turno;
import java.util.Date;
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
public class TurnoFacade extends AbstractFacade<Turno> {

    @PersistenceContext(unitName = "ProyectorSirPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TurnoFacade() {
        super(Turno.class);
    }
    
   public int programarTurnos(Date entrada_programada , Date salida_programada,int id ){
        int turno=0;
        try{
            Query pro = em.createNativeQuery("call ProgramarTurnos(?,?,?)");
            pro.setParameter(1,entrada_programada);
            pro.setParameter(2,salida_programada);
            pro.setParameter(3,id);
            pro.executeUpdate();
            turno=1;
        }
        catch(Exception e){
            System.out.println("error " + e.getMessage());
        }
        return turno;
    }
    
    public List<Turno> verturnosprogramados(){
        try {
            Query turnosProgramados = em.createNativeQuery("select * FROM turnos WHERE datediff(now(),entrada_programada)<31",Turno.class);
            List<Turno> verturnosprogramados  = turnosProgramados.getResultList();
            return verturnosprogramados;
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
            return null;
        }
        
    }
    
    public int regHoraReal(Date hora_ingreso_real){
        int rhr=0;        
        try{
            Query reg = em.createNativeQuery("call registroHoraReal(?)");
            reg.setParameter(1,hora_ingreso_real);
            reg.executeUpdate();
            rhr=1;
        } catch(Exception e){
            System.out.println("error"+e.getMessage());
        }
        return rhr;
    }    
}
