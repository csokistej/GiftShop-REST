/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.dto.impl;


import hu.giftshop.dto.CategoryDto;
import hu.giftshop.dto.ProductDto;

/**
 *
 * @author szotyi
 */
public class ProductDtoImpl implements ProductDto {
      
    private Integer id;
    private String name;
    private String description;
    private Double grossPrice;
    private Double grossSalePrice;
    private Double netPrice;    
    private CategoryDto category;
    private Integer quantity;
    private Integer stockId; 

    public ProductDtoImpl(ProductDtoBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.category = builder.category;
        this.netPrice = builder.netPrice;
        this.grossPrice = builder.grossPrice;
        this.grossSalePrice = builder.grossSalePrice;
        this.quantity = builder.quantity;
        this.stockId = builder.stockId;
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
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Double getGrossPrice() {
        return grossPrice;
    }

    @Override
    public void setGrossPrice(Double grossPrice) {
        this.grossPrice = grossPrice;
    }

    @Override
    public Double getGrossSalePrice() {
        return grossSalePrice;
    }

    @Override
    public void setGrossSalePrice(Double grossSalePrice) {
        this.grossSalePrice = grossSalePrice;
    }

    @Override
    public Double getNetPrice() {
        return netPrice;
    }

    @Override
    public void setNetPrice(Double netPrice) {
        this.netPrice = netPrice;
    }
   
    @Override
    public CategoryDto getCategory() {
        return category;
    }

    @Override
    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public Integer getStockId() {
        return stockId;
    }

    @Override
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }  
    
    public static class ProductDtoBuilder {
        private Integer id;
        private String name;
        private String description;
        private Double grossPrice;
        private Double grossSalePrice;
        private Double netPrice;  
        private CategoryDto category;
        private Integer quantity;
        private Integer stockId;
        
        public ProductDtoBuilder id(Integer id){
            this.id = id;
            return this;
        }
        
        public ProductDtoBuilder name(String name){
            this.name = name;
            return this;
        }
        
        public ProductDtoBuilder description(String description){
            this.description = description;
            return this;
        }

        public ProductDtoBuilder category(CategoryDto category){
            this.category = category;
            return this;
        }
        
        public ProductDtoBuilder netPrice(Double price){
            this.netPrice = price;
            return this;
        }
        
        public ProductDtoBuilder grossPrice(Double price){
            this.grossPrice = price;
            return this;
        }
        
        public ProductDtoBuilder grossSalePrice(Double price){
            this.grossSalePrice = price;
            return this;
        }
        
        public ProductDtoBuilder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }
        
        public ProductDtoBuilder stockId(Integer stockId){
            this.stockId = stockId;
            return this;
        }
        
        public ProductDtoImpl build(){
            return new ProductDtoImpl(this);
        }
    
    
    }
}
