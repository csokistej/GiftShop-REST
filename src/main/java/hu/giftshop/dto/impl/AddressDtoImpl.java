/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.dto.impl;


import hu.giftshop.dto.AddressDto;

/**
 *
 * @author szotyi
 */
public class AddressDtoImpl implements AddressDto {
    
    private Integer id;
    private String country;
    private String zipCode;
    private String city;
    private String street;
    private String houseNumber;
    private Integer floor;
    private Integer door;
    private Integer doorbell;

    public AddressDtoImpl(AddressDtoBuilder builder){
        this.id = builder.id;
        this.country = builder.country;
        this.zipCode = builder.zipCode;
        this.city = builder.city;
        this.street = builder.street;
        this.houseNumber = builder.houseNumber;
        this.floor = builder.floor;
        this.door = builder.door;
        this.doorbell = builder.doorbell;            
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
    public String getCountry() {
        return country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getHouseNumber() {
        return houseNumber;
    }

    @Override
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public Integer getFloor() {
        return floor;
    }

    @Override
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Override
    public Integer getDoor() {
        return door;
    }
    
    
    @Override
    public void setDoor(Integer door) {
        this.door = door;
    }

    @Override
    public Integer getDoorbell() {
        return doorbell;
    }

    @Override
    public void setDoorbell(Integer doorbell) {
        this.doorbell = doorbell;
    }
    
    public static class AddressDtoBuilder {
        
        private Integer id;
        private String country;
        private String zipCode;
        private String city;
        private String street;
        private String houseNumber;
        private Integer floor;
        private Integer door;
        private Integer doorbell;
        
        public AddressDtoBuilder id(Integer id){
            this.id = id;
            return this;
        }
        
        public AddressDtoBuilder country(String country){
            this.country = country;
            return this;
        }
        
        public AddressDtoBuilder zipCode(String zipCode){
            this.zipCode = zipCode;
            return this;
        }
        public AddressDtoBuilder city(String city){
            this.city = city;
            return this;
        }
        public AddressDtoBuilder street(String street){
            this.street = street;
            return this;
        }
        public AddressDtoBuilder houseNumber(String houseNumber){
            this.houseNumber = houseNumber;
            return this;
        }
        public AddressDtoBuilder floor(Integer floor){
            this.floor = floor;
            return this;
        }
        public AddressDtoBuilder door(Integer door){
            this.door = door;
            return this;
        }
        
        public AddressDtoBuilder doorbell(Integer doorbell){
            this.doorbell = doorbell;
            return this;
        }
        
        public AddressDtoImpl build(){
            return new AddressDtoImpl(this);
        }
        
    }
    
    
}
