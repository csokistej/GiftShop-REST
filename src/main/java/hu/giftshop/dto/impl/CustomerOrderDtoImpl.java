/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.dto.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import hu.giftshop.dto.CustomerDto;
import hu.giftshop.dto.CustomerOrderDto;
import hu.giftshop.dto.OrderProductDto;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author szotyi
 */
@JsonDeserialize
public class CustomerOrderDtoImpl implements CustomerOrderDto  {
    
    private Integer id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy.MM.dd")
    private Calendar orderDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy.MM.dd")
    private Calendar fulfillDate;
    private CustomerDto customer;
    private List<OrderProductDto> orderProductList; 

    public CustomerOrderDtoImpl() {
    }
    

    public CustomerOrderDtoImpl(CustomerOrderDtoBuilder builder){
        this.id = builder.id;
        this.orderDate = builder.orderDate;
        this.fulfillDate = builder.fulfillDate;
        this.customer = builder.customer;
        this.orderProductList = builder.orderProductList;    
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
    public Calendar getOrderDate() {
        return orderDate;
    }

    @Override
    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public Calendar getFulfillDate() {
        return fulfillDate;
    }

    @Override
    public void setFulfillDate(Calendar fulfillDate) {
        this.fulfillDate = fulfillDate;
    }

    @Override
    public CustomerDto getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    @Override
    public List<OrderProductDto> getOrderProductList() {
        return orderProductList;
    }

    @Override
    public void setOrderProductList(List<OrderProductDto> orderProductList) {
        this.orderProductList = orderProductList;
    }
    
    public static class CustomerOrderDtoBuilder {
        
        private Integer id;
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy.MM.dd")
        private Calendar orderDate;
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy.MM.dd")
        private Calendar fulfillDate;
        private CustomerDto customer;
        private List<OrderProductDto> orderProductList;
        
        public CustomerOrderDtoBuilder id(Integer id){
            this.id = id;
            return this;
        }
        
        public CustomerOrderDtoBuilder orderDate(Calendar orderDate){
            this.orderDate = orderDate;
            return this;
        }
        
        public CustomerOrderDtoBuilder fulfillDate(Calendar fulfillDate){
            this.fulfillDate = fulfillDate;
            return this;
        }
        
        public CustomerOrderDtoBuilder customer(CustomerDto customer){
            this.customer = customer;
            return this;
        }
        
        public CustomerOrderDtoBuilder orderProductList(List<OrderProductDto> orderProductList){
            this.orderProductList = orderProductList;
            return this;
        }
        
        public CustomerOrderDto build(){
            return new CustomerOrderDtoImpl(this);
        }
           
    }
}
