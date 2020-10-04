/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matriculas.ejb;

import com.matriculas.modelo.Materia;
import com.matriculas.modelo.Matricula;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alejandro Rios
 */
@Stateless
public class MatriculaFacade extends AbstractFacade<Matricula> implements MatriculaFacadeLocal {

    @PersistenceContext(unitName = "Lab1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatriculaFacade() {
        super(Matricula.class);
    }
    
     
    public Object getMatricula(int ced, int cod) {
        Query q = em.createQuery("SELECT distinct m FROM Matricula m where m.estudiante.cedula=:ced and m.materia.codigo=:cod");
        q.setParameter("ced", ced);
        q.setParameter("cod", cod);
        return q.getResultList().get(0);
    }
    
}
