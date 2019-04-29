/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository;

import hu.giftshop.model.Customer;
import java.util.List;

/**
 *
 * @author szotyi
 */
public interface ICustomerRepository {
    
    public List<Customer> findAll();
    
    public Customer find(int id);
    
    public Customer create(Customer customer);
    
    public void update(Customer customer);
    
    public void delete(Customer customer);
    
}
