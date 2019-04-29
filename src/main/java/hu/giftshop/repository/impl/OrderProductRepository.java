/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository.impl;

import hu.giftshop.model.OrderProduct;
import hu.giftshop.repository.IOrderProductRepositoryLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author szotyi
 */
@Stateless
public class OrderProductRepository extends AbstractRepository<OrderProduct> implements IOrderProductRepositoryLocal {

    public OrderProductRepository() {
        super(OrderProduct.class);
    }

    @Override
    public List<OrderProduct> findAll() {
        Query query = getEntityManager().createNamedQuery(OrderProduct.class.getSimpleName() + ".findAll");
        return query.getResultList();
    }

    @Override
    public OrderProduct find(int id) {
        return getEntityManager().find(OrderProduct.class, id);
    }

    @Override
    public void create(OrderProduct orderProduct) {
        getEntityManager().persist(orderProduct);
    }

    @Override
    public void update(OrderProduct orderProduct) {
        getEntityManager().merge(orderProduct);
    }

    @Override
    public void delete(OrderProduct orderProduct) {
        getEntityManager().remove(orderProduct);
    }
    
    
    
}
