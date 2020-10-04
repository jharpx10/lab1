/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matriculas.ejb;

import com.matriculas.modelo.Materia;
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
public class MateriaFacade extends AbstractFacade<Materia> implements MateriaFacadeLocal {

    @PersistenceContext(unitName = "Lab1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaFacade() {
        super(Materia.class);
    }
    @Override
    public List<Materia> getCourses(int e) {
        Query q = em.createQuery("SELECT  distinct m.materia FROM Matricula m  join Materia k where m.estudiante.cedula=:e");
        q.setParameter("e", e);
        return q.getResultList();
    }
    
}
