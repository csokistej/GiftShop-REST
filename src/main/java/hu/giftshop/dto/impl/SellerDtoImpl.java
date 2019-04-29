/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.dto.impl;

import hu.giftshop.dto.AddressDto;
import hu.giftshop.dto.SellerDto;

/**
 *
 * @author szotyi
 */
public class SellerDtoImpl implements SellerDto {
    
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String accountNumber;
    private AddressDto address;

    public SellerDtoImpl(SellerDtoBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.phone = builder.phone;
        this.email = builder.email;
        this.accountNumber = builder.accountNumber;
        this.address = builder.address;
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
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public AddressDto getAddress() {
        return address;
    }
    
    @Override
    public void setAddress(AddressDto address) {
        this.address = address;
    }
    
    public static class SellerDtoBuilder {
        
        private Integer id;
        private String name;
        private String phone;
        private String email;
        private String accountNumber;
        private AddressDto address;
        
        public SellerDtoBuilder id(Integer id){
            this.id = id;
            return this;
        }
        
        public SellerDtoBuilder name(String name){
            this.name = name;
            return this;
        }
        
        public SellerDtoBuilder phone(String phone){
            this.phone = phone;
            return this;
        }
        
        public SellerDtoBuilder email(String email){
            this.email = email;
            return this;
        }
        
        public SellerDtoBuilder accountNumber(String accountNumber){
            this.accountNumber = accountNumber;
            return this;
        }
        
        public SellerDtoBuilder name(AddressDto address){
            this.address = address;
            return this;
        }
        
        public SellerDto build(){
            return new SellerDtoImpl(this);
        }
        
    }
    
    
}
