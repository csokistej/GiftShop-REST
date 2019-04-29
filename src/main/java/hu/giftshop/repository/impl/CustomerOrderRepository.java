/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository.impl;

import hu.giftshop.model.CustomerOrder;
import hu.giftshop.repository.ICustomerOrderRepositoryLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author szotyi
 */
@Stateless
public class CustomerOrderRepository extends AbstractRepository<CustomerOrder> implements ICustomerOrderRepositoryLocal {

    public CustomerOrderRepository() {
        super(CustomerOrder.class);
    }
    
    @Override
    public List<CustomerOrder> findAll() {
        Query query = getEntityManager().createNamedQuery(CustomerOrder.class.getSimpleName() + ".findAll");
        return query.getResultList();
    }

    @Override
    public CustomerOrder find(int id) {
        return getEntityManager().find(CustomerOrder.class, id);
    }

    @Override
    public void create(CustomerOrder customerOrder) {
        getEntityManager().persist(customerOrder);
    }

    @Override
    public void update(CustomerOrder customerOrder) {
        getEntityManager().merge(customerOrder);
    }

    @Override
    public void delete(CustomerOrder customerOrder) {
        getEntityManager().remove(customerOrder);
    }

//    @Override
//    public void createCustomerOrder(CustomerOrder customerOrder) {
//        Query query = getEntityManager().
//    }

    @Override
    public Integer createCustomerOrder(CustomerOrder customerOrder) {
        getEntityManager().persist(customerOrder);
        getEntityManager().flush();
        System.out.println("ENTITY MANAGER FLUSHED");
        Integer id = customerOrder.getId();
        System.out.println("INSERTED ID: " + id.toString());
        return id;
    }
    
}
