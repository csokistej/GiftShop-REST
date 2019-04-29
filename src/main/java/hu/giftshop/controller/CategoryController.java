/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.controller;

import hu.giftshop.dto.CategoryDto;
import hu.giftshop.dto.impl.CategoryDtoImpl;
import hu.giftshop.model.Category;
import hu.giftshop.repository.ICategoryRepository;
import hu.giftshop.util.EJBAccess;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author szotyi
 */
@Stateless
public class CategoryController {
    
    public CategoryController(){
//        categoryRepository; 
    }
    
    //@PostConstruct may would have helped to us...
    
    public List<CategoryDto> getAllCategories(){
        List<CategoryDto> categories = new ArrayList<>();
        try {
            ICategoryRepository categoryRepository = EJBAccess.getCategoryRepository();
            for (Category category : categoryRepository.findAll()) {
                categories.add(new CategoryDtoImpl.CategoryDtoBuilder()
                          .id(category.getId())
                          .name(category.getName())
                          .taxRate(category.getTaxRate())
                          .build()
                );
            }
            return categories;
        } catch (NamingException ex) {
            System.out.println("Naming EXCEPTION");
            return categories;
        } 
      
    }
    
    public static CategoryDto convertFromEntity(Category category){
        return new CategoryDtoImpl.CategoryDtoBuilder()
                .id(category.getId())
                .name(category.getName())
                .taxRate(category.getTaxRate())
                .build();
    }

    /**
     * not implemented yet
     * @param categoryDto
     * @return 
     */
    public static Category convertFromDto(CategoryDto categoryDto){
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setTaxRate(categoryDto.getTaxRate());
        return category;
    }
    
    
//    
//    public CategoryDtoImpl find(int id){
////        try {
//////            InitialContext ctx = new InitialContext();
//////            categoryRepository = (ICategoryRepository)ctx.lookup()
////              return convertFromEntity(categoryRepository.find(id));
////        } catch(NamingException ex){
////            System.out.println(ex.getMessage());
////        } catch(Exception ex){
////            System.out.println(ex.getMessage());
////        }
////        
//        return convertFromEntity(categoryRepository.find(id));
//    }
//    
//    public List<CategoryDto> findAll(){
//        List<CategoryDto> categories = new ArrayList<>();
//        for(Category category : categoryRepository.findAll()){
//            categories.add(new CategoryDtoImpl.CategoryDtoBuilder()
//                        .id(category.getId())
//                        .name(category.getName())
//                        .profitRate(category.getProfitRate())
//                        .build()                     
//            );
//        }
//        return categories;
//    }
//    
//    private CategoryDtoImpl convertFromEntity(Category category){
//        return new CategoryDtoImpl.CategoryDtoBuilder()
//                          .id(category.getId())
//                          .name(category.getName())
//                          .profitRate(category.getProfitRate())
//                          .build();
//    }
//    
//    private Category convertFromDto(CategoryDtoImpl categoryDto){
//        Category category = new Category();
//        if(categoryDto.getId() != null){
//            category.setId(categoryDto.getId());
//        }
//        category.setName(categoryDto.getName());
//        category.setProfitRate(categoryDto.getProfitRate());
//        return category;
//    }
//    
//    //MAY THIS FUNC. SHOULD RETURN WITH THE INSERTED ID (em.flush())
//    public void create(CategoryDtoImpl categoryDto){
//        categoryRepository.create(convertFromDto(categoryDto));
//    }
//    
//    public void update(CategoryDtoImpl categoryDto){
//        categoryRepository.update(convertFromDto(categoryDto));
//    }
//    
//    public void delete(int id){   
//        categoryRepository.delete(categoryRepository.find(id));
//    }
    
    
    
}

