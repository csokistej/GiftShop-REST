/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.dto.impl;

import hu.giftshop.dto.CategoryDto;


/**
 *
 * @author szotyi
 */

public class CategoryDtoImpl implements CategoryDto {
    
    private Integer id;
    private String name;
    private Double taxRate;

    public CategoryDtoImpl() {
    }
    
    public CategoryDtoImpl(CategoryDtoBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.taxRate = builder.taxRate;
    }
    
    @Override
    public Integer getId() {
        return id;
    }
    
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getTaxRate() {
        return taxRate;
    }

    @Override
    public void setTaxRate(Double profitRate) {
        this.taxRate = profitRate;
    }
    
    
    public static class CategoryDtoBuilder {
        
        private Integer id;
        private String name;
        private Double taxRate;
       
        
        public CategoryDtoBuilder id(Integer id){
            this.id = id;
            return this;
        }
        
        public CategoryDtoBuilder name(String name){
            this.name = name;
            return this;
        }
        
        public CategoryDtoBuilder taxRate(Double taxRate){
            this.taxRate = taxRate;
            return this;
        }
        
        public CategoryDtoImpl build(){
            return new CategoryDtoImpl(this);
        }
        
    }
    
    
}
