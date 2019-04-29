/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.rest.impl;

import hu.giftshop.controller.CategoryController;
import hu.giftshop.dto.CategoryDto;
import hu.giftshop.dto.impl.CategoryDtoImpl;
import hu.giftshop.rest.ICategoryResource;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author szotyi
 */

@RequestScoped
public class ICategoryResourceImpl implements ICategoryResource {

    @EJB
    private CategoryController categoryController;
    
    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryController.getAllCategories();
    }

    @Override
    public CategoryDtoImpl getCategory(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response createCategory(CategoryDto categoryDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response updateCategory(CategoryDto categoryDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response deleteCategory(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
