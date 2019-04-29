/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository;

import hu.giftshop.model.Product;
import java.util.List;

/**
 *
 * @author szotyi
 */
public interface IProductRepository {
    
    public List<Product> findAll();
    
    public Product find(int id);
    
    public void create(Product product);
    
    public void update(Product product);
    
    public void delete(Product product);
    
    
    
}
