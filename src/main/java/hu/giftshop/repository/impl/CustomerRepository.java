/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository.impl;

import hu.giftshop.model.Customer;
import hu.giftshop.repository.ICustomerRepositoryLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author szotyi
 */
@Stateless
public class CustomerRepository extends AbstractRepository<Customer> implements ICustomerRepositoryLocal {

    public CustomerRepository() {
        super(Customer.class);
    }

    @Override
    public Customer create(Customer customer) {
        getEntityManager().persist(customer);
        getEntityManager().flush();
        Integer id = customer.getId();
        return getEntityManager().find(Customer.class, id);
    }
    
    

    @Override
    public List<Customer> findAll() {
        Query query = getEntityManager().createNamedQuery(Customer.class.getSimpleName() + ".findAll");
        return query.getResultList();
    }

    @Override
    public Customer find(int id) {
        return getEntityManager().find(Customer.class, id);
    }

    @Override
    public void update(Customer customer) {
        getEntityManager().merge(customer);
    }

    @Override
    public void delete(Customer customer) {
        getEntityManager().remove(customer);
    }
    
    
    
    
}
