/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.dto.impl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import hu.giftshop.dto.CustomerOrderDto;
import hu.giftshop.dto.OrderProductDto;
import hu.giftshop.dto.ProductDto;

/**
 *
 * @author szotyi
 */
@JsonDeserialize
public class OrderProductDtoImpl implements OrderProductDto {
    
    private Integer id;
    private CustomerOrderDto customerOrder;
    private ProductDto product;
    private Integer quantity;

    public OrderProductDtoImpl(OrderProductDtoBuilder builder){
        this.id = builder.id;
        this.customerOrder = builder.customerOrder;
        this.product = builder.product;
        this.quantity = builder.quantity;
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
    public CustomerOrderDto getCustomerOrder() {
        return customerOrder;
    }

    @Override
    public void setCustomerOrder(CustomerOrderDto customerOrder) {
        this.customerOrder = customerOrder;
    }

    @Override
    public ProductDto getProduct() {
        return product;
    }

    @Override
    public void setProduct(ProductDto product) {
        this.product = product;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public static class OrderProductDtoBuilder {
        
        private Integer id;
        private CustomerOrderDto customerOrder;
        private ProductDto product;
        private Integer quantity;
        
        public OrderProductDtoBuilder id(Integer id){
            this.id = id;
            return this;
        }
        
        public OrderProductDtoBuilder customerOrder(CustomerOrderDto customerOrder){
            this.customerOrder= customerOrder;
            return this;
        }
        
         
        public OrderProductDtoBuilder product(ProductDto product){
            this.product = product;
            return this;
        }
        
          
        public OrderProductDtoBuilder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }
        
        public OrderProductDto build(){
            return new OrderProductDtoImpl(this);
        }
        
        
    }
    
    
}
