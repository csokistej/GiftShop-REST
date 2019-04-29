/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.dto.impl;

import hu.giftshop.dto.AddressDto;
import hu.giftshop.dto.CustomerDto;


/**
 *
 * @author szotyi
 */
public class CustomerDtoImpl implements CustomerDto {
      
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String customerType;
    private AddressDto address;
    private String accountNumber;
    
    public CustomerDtoImpl(CustomerDtoBuilder builder){
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.email = builder.email;
        this.customerType = builder.customerType;
        this.address = builder.address;
        this.accountNumber = builder.accountNumber;
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
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getCustomerType() {
        return customerType;
    }

    @Override
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public AddressDto getAddress() {
        return address;
    }

    @Override
    public void setAddress(AddressDto address) {
        this.address = address;
    }
    
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public static class CustomerDtoBuilder {
        private Integer id;
        private String firstName;
        private String lastName;
        private String phone;
        private String email;
        private String customerType;
        private AddressDto address;
        private String accountNumber;
        
        public CustomerDtoBuilder id(Integer id){
            this.id = id;
            return this;
        }  
        
        public CustomerDtoBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        
        public CustomerDtoBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        
        
        public CustomerDtoBuilder phone(String phone){
            this.phone = phone;
            return this;
        }
        
        public CustomerDtoBuilder email(String email){
            this.email = email;
            return this;
        }
        
        public CustomerDtoBuilder customerType(String customerType){
            this.customerType = customerType;
            return this;
        }
        
        public CustomerDtoBuilder address(AddressDto address){
            this.address = address;
            return this;
        }
        
        public CustomerDtoBuilder accountNumber(String accountNumber){
            this.accountNumber = accountNumber;
            return this;
        }
        
        
        public CustomerDto build(){
            return new CustomerDtoImpl(this);
        }
        
    }
    
    
    
    
    
}
