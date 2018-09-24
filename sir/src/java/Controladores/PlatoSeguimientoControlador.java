/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Platoseguimiento;
import Facade.PlatoseguimientoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

@Named(value = "platoSeguimientoControlador")
@SessionScoped
public class PlatoSeguimientoControlador implements Serializable {

    /**
     * Creates a new instance of PlatoSeguimientoControlador
     */
    @EJB
    PlatoseguimientoFacade platoSeguimientoFacade;
    Platoseguimiento platoSeguimiento;
    private List<Platoseguimiento> lis;

    public PlatoSeguimientoControlador() {
        lis = new ArrayList<>();
        platoSeguimiento = new Platoseguimiento();
    }

    public List<Platoseguimiento> getLis() {
        return lis;
    }

    public void setLis(List<Platoseguimiento> lis) {
        this.lis = lis;
    }

    public List<Platoseguimiento> lista() {
        this.lis = null;
        lis = platoSeguimientoFacade.listar();
        return lis;

    }

    public void actualizarTabla() {
        this.lis = null;
    }

}
