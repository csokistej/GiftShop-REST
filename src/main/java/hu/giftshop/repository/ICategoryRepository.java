/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository;

import hu.giftshop.model.Category;
import java.util.List;
/**
 *
 * @author szotyi
 */
public interface ICategoryRepository {
   
    public void create(Category category);
    
    public List<Category> findAll();
    
    public Category find(int id);
    
    public void update(Category category);
    
    public void delete(Category category);
}
