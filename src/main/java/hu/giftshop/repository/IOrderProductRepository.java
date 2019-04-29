/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository;

import hu.giftshop.model.OrderProduct;
import java.util.List;

/**
 *
 * @author szotyi
 */
public interface IOrderProductRepository {
    
    public List<OrderProduct> findAll();
    
    public OrderProduct find(int id);
    
    public void create(OrderProduct orderProduct);
    
    public void update(OrderProduct orderProduct);
    
    public void delete(OrderProduct orderProduct);
    
}
