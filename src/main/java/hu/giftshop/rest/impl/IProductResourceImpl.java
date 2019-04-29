/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.rest.impl;

import hu.giftshop.controller.ProductController;
import hu.giftshop.dto.ProductDto;
import hu.giftshop.repository.IProductRepositoryLocal;
import hu.giftshop.rest.IProductResource;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author szotyi
 */
@RequestScoped
public class IProductResourceImpl implements IProductResource {

    @EJB
    private ProductController productController;
    
    @Override
    public List<ProductDto> getAllProducts() {
        return productController.getAllProducts();
    }
    
}
