/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository.impl;

import hu.giftshop.model.Category;
import hu.giftshop.repository.ICategoryRepositoryLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author szotyi
 */

@Stateless
public class CategoryRepository extends AbstractRepository<Category> implements ICategoryRepositoryLocal {

//    @PersistenceContext(unitName = "giftshopPU")
//    private EntityManager em;
    
    public CategoryRepository() {
        super(Category.class);
    }
    
    
    @Override
    public void create(Category category) {
      getEntityManager().persist(category);
    }

    @Override
    public List<Category> findAll() {
        Query query = getEntityManager().createNamedQuery(Category.class.getSimpleName() + ".findAll");
        return query.getResultList();
    }

    @Override
    public Category find(int id) {
        return getEntityManager().find(Category.class, id);
    }

    @Override
    public void update(Category category) {
        getEntityManager().merge(category);
    }

    @Override
    public void delete(Category category) {
        getEntityManager().remove(category);
    }
    
}
