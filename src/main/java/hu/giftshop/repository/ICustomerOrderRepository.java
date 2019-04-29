/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository;

import hu.giftshop.model.CustomerOrder;
import java.util.List;

/**
 *
 * @author szotyi
 */
public interface ICustomerOrderRepository {
   
    public List<CustomerOrder> findAll();
    
    public CustomerOrder find(int id);
    
    public void create(CustomerOrder customerOrder);
    
    public Integer createCustomerOrder(CustomerOrder customerOrder);
    
    public void update(CustomerOrder customerOrder);
    
    public void delete(CustomerOrder customerOrder);
    
}
