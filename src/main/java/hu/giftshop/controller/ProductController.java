/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.controller;

import hu.giftshop.dto.CategoryDto;
import hu.giftshop.dto.ProductDto;
import hu.giftshop.dto.impl.ProductDtoImpl;
import hu.giftshop.model.Category;
import hu.giftshop.model.Product;
import hu.giftshop.repository.IProductRepository;
import hu.giftshop.util.EJBAccess;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.naming.NamingException;

/**
 *
 * @author szotyi
 */
@Stateless
public class ProductController {
    
    public ProductController() {
    }
    
    public static Product convertFromProduct(ProductDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        Category category = CategoryController.convertFromDto(dto.getCategory());
        product.setCategory(category);
        product.setNetPrice(dto.getNetPrice());
        product.setQuantity(dto.getQuantity());
        product.setStockId(dto.getStockId());
        return product;
    }
    
    public static ProductDto convertFromEntity(Product product){
        Double grossPrice = product.getNetPrice() * (1.27);
        Double grossSalePrice = grossPrice * product.getCategory().getTaxRate();
        CategoryDto category = CategoryController.convertFromEntity(product.getCategory());
        return new ProductDtoImpl.ProductDtoBuilder()
                    .id(product.getId())
                    .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .netPrice(product.getNetPrice())
                        .grossPrice(grossPrice)
                        .grossSalePrice(grossSalePrice)
                        .quantity(product.getQuantity())
                        .stockId(product.getStockId())
                        .category(category)
                        .build();
    }
    
    public List<ProductDto> getAllProducts(){
        List<ProductDto> products = new ArrayList<>();
        try {
            IProductRepository productRepository = EJBAccess.getProductRepository();
            for (Product product : productRepository.findAll()) {
                products.add(convertFromEntity(product));
            }
        } catch (NamingException ex){
            System.out.println("NAMING EXCEPTION");
        } catch (Exception ex){
            System.out.println("EXCEPTION");
        } finally {
            return products;
        }
        
        
    }

    public Product getProduct(int id) {
        Product product = null;
        try{
            IProductRepository productRepository = EJBAccess.getProductRepository();
            product = productRepository.find(id);
        }catch (NamingException ex){
            System.out.println("NAMING EXCEPTION");
        } catch (Exception ex){
            System.out.println("EXCEPTION");
        }finally {
            return product;
        }
    }
    
}
