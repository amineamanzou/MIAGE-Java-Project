/*
 * ModeleJPAImp.java
 *
 * Created on 27 mars 2007, 21:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.myapp.model.JPAModel;

import com.myapp.model.Cotations;
import com.myapp.model.Model;
import com.myapp.model.ModelException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author carine
 */


public class ModeleJPAImp implements Model {
    
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex-Struts-Spring-JPAPU");
    
    /** Creates a new instance of modeleImp */
    
    public ModeleJPAImp() {
    }
   
    
    @Override
    public Double getCotation(String symbole ) throws ModelException {
    EntityManager em;
    Cotations c;
    
    Double cours = null;
    try {
        em=emf.createEntityManager();
        c=em.find(Cotations.class, symbole);
        cours=(c.getCours()).doubleValue();
        System.out.println("cours : " + cours);
      }
    catch (Exception e) {
      throw new ModelException (e.getMessage());
    }
    
    return cours;
  }

    @Override
    public void createCotation(String symbole, Double cours ) throws ModelException {
        
        try {
            Cotations c=new Cotations();
            c.setSymbole(symbole);
            c.setCours(new BigDecimal (cours));
            persist(c);
            
          }  
        catch (Exception e) {

      throw new ModelException (e.getMessage());
    }
    }
    
    @Override
    public void updateCotation(String symbole, Double cours) throws ModelException {
        EntityManager em = emf.createEntityManager();
        Cotations c;
        try {
            em.getTransaction().begin();
            c=new Cotations();
            c.setSymbole(symbole);
            c.setCours(new BigDecimal (cours));
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
            throw new ModelException (e.getMessage());
        } finally {
            em.close();
        }
        
    }
    
  
    @Override
    public void deleteCotation(String Symbole) throws ModelException {
        EntityManager em=null;
        Cotations c;
        try {
        em=emf.createEntityManager();
        em.getTransaction().begin();
        c=em.find(Cotations.class, Symbole);
        em.remove(c);
        em.getTransaction().commit();
         
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            if (em!=null) em.getTransaction().rollback();
            throw new ModelException (e.getMessage());
            
        } finally {
            if (em!=null) em.close();
        }
        
    }
    
    private void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
          
        } finally {
            em.close();
        }
    }
}
