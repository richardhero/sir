/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controladores;


import Entidades.Persona;
import Entidades.Turno;
import Facade.TurnoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Richard HERO
 */
@Named(value = "turnoControlador")
@SessionScoped
public class TurnoControlador implements Serializable {
    
    @EJB
            TurnoFacade turnoFacade;
    private Turno turno;
    private Persona persona;
    
    public TurnoControlador() {
        turno = new Turno ();
        persona = new Persona ();
    }
    
    
    public Turno getTurno() {
        return turno;
    }
    
    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    
    public void agregarTurno (Turno newTurno){
        turnoFacade.create(turno);
        turno = new Turno ();
    }
    
    public void eliminarTurno (Turno newTurno){
        turno = newTurno ;
        turnoFacade.remove(turno);
        turno = new Turno();
    }
    
    public String editarTurno (Turno newTurno){
        turno = newTurno ;
        return"/Turno/Modificar";
    }
    
    public String editarTurno  (){
        turnoFacade.edit(turno);
        turno = new Turno ();
        return"/Turno/Listar";
    }
    public List<Turno> listarTurno (){
        return turnoFacade.findAll();
    }
    public void programarTurnos(){
        String men;
        int pro;
        pro = turnoFacade.programarTurnos(turno.getEntradaProgramada(), turno.getSalidaProgramada(),persona.getNumeroDocumento());
        if (pro!=0) {
            men="turno registrado correctamente";
        }else{
            men = "Error en el registro";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage("Informacion", men));
        
        System.out.println(men);
    }
    
    public Persona getPersona() {
        return persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public List<Turno> turnosProgramados(){
        List<Turno> lis = turnoFacade.verturnosprogramados();
        if (lis!=null){
            System.out.println("Vista");
        }
        else {System.out.println("Vista Nula");
        }
        return lis;
    }
    
    private static class TurnoService {
        
        public TurnoService() {
        }
        
        private List<Turno> createTurnos(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    public class DataExporterView implements Serializable {
        
        private List<Turno> turnos;
        
        @ManagedProperty("#{TurnoService}")
        private TurnoService service;
        
        @PostConstruct
        public void init() {
            turnos = service.createTurnos(100);
        }
        
        public List<Turno> getTurnos() {
            return turnos;
        }
        
        public void setService(TurnoService service) {
            this.service = service;
        }
    }
    
    public String regHoraReal(){
        
        String men;
        int reg;
        reg = turnoFacade.regHoraReal(turno.getHoraIngresoReal());
        if (reg!=0){
            men= "hora registrada correctamente";
        }else{
            men = "Error en el registro";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Informacion",men));
        return null;
    }
}

