/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matriculas.ejb;

import com.matriculas.modelo.Estudiante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alejandro Rios
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> implements EstudianteFacadeLocal {

    @PersistenceContext(unitName = "Lab1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }
    
    
     @Override
    public boolean checkLogin(int e, String c) {
       Query q=em.createQuery("select e from Estudiante e where e.cedula=:e and e.contrasena=:c");
       q.setParameter("e", e);
       q.setParameter("c", c);
       return q.getResultList().size()>0;
    }

    @Override
    public Object getStudent(int cedula) {
         Query q=em.createQuery("select e from Estudiante e where e.cedula=:cedula");
         q.setParameter("cedula", cedula);
          return q.getResultList().get(0);
    }


    
    
    
}
