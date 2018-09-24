/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Richard HERO
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "ProyectorSirPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
        public Usuario registrar(String us, String con) {
        Usuario persona = null;
        try {
            Query reg = em.createNativeQuery("select * from usuarios where nombre_usuario=? and contraseña=?", Usuario.class);
            reg.setParameter(1, us);
            reg.setParameter(2, con);
            persona = (Usuario) reg.getSingleResult();
        } catch (Exception e) {
            System.out.println("errokr :" + e.getMessage());
        }
        return persona;
    }

    public void editarUsuario(String nom, String ape, String corr, int tel, String con, int numdoc) {
        try {
            Query query = em.createNativeQuery("call editarPerfil(?,?,?,?,?,?)");
            query.setParameter(1, nom);
            query.setParameter(2, ape);
            query.setParameter(3, corr);
            query.setParameter(4, tel);
            query.setParameter(5, con);
            query.setParameter(6, numdoc);
            query.executeUpdate();
            System.out.println("se ejecuto");
        } catch (Exception e) {
            System.out.println("error "+ e.getMessage());
        }

    }
}
