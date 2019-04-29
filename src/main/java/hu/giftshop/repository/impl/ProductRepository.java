/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository.impl;

import hu.giftshop.model.Product;
import hu.giftshop.repository.IProductRepositoryLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author szotyi
 */
@Stateless
public class ProductRepository extends AbstractRepository<Product> implements IProductRepositoryLocal {

    public ProductRepository() {
        super(Product.class);
    }
    
    @Override
    public List<Product> findAll() {
        Query query = getEntityManager().createNamedQuery(Product.class.getSimpleName() + ".findAll");
        return query.getResultList();
    }

    @Override
    public Product find(int id) {
        return getEntityManager().find(Product.class, id);
    }

    @Override
    public void create(Product product) {
        getEntityManager().persist(product);
    }

    @Override
    public void update(Product product) {
        getEntityManager().merge(product);
    }

    @Override
    public void delete(Product product) {
        getEntityManager().remove(product);
    }
    
    
    
}
