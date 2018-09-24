/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesAuxiliares;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario PC
 */
public class LoginFiltro implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext faces = event.getFacesContext();
        
        String paginaActual = faces.getViewRoot().getViewId();
        
        boolean pagina=paginaActual.lastIndexOf("index.xhtml")>-1 ? true:false;
        
        HttpSession sesion = (HttpSession) faces.getExternalContext().getSession(true);
        
        Object objeto= sesion.getAttribute("usuario");
        
        if (!pagina && objeto==null) {
            NavigationHandler nHandler = faces.getApplication().getNavigationHandler();
            nHandler.handleNavigation(faces, null, "/index.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
