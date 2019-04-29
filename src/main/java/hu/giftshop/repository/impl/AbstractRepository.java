/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author szotyi
 */

public abstract class AbstractRepository<T extends Serializable> {
    
    private Class<T> entityClass;
    
    @PersistenceContext(unitName = "giftshopPU")
    private EntityManager em;
    
    public AbstractRepository(Class<T> entityClass){
        this.entityClass = entityClass;
    }
    
    public AbstractRepository(){
        
    }
    
    protected EntityManager getEntityManager() {
        return em;
    }
   
}
