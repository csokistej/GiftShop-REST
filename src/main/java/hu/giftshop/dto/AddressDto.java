/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;

/**
 *
 * @author szotyi
 */
@JsonDeserialize
public interface AddressDto extends Serializable {
    
     public Integer getId();

    public void setId(Integer id);
    
    public String getCountry();

    public void setCountry(String country);

    public String getZipCode();

    public void setZipCode(String zipCode);
    
    public String getCity();
    
    public void setCity(String city);
    
    public String getStreet();
    
    
    public void setStreet(String street);

    public String getHouseNumber();

    public void setHouseNumber(String houseNumber);
    
    public Integer getFloor();

    public void setFloor(Integer floor);

    public Integer getDoor();

    public void setDoor(Integer door) ;

    public Integer getDoorbell();

    public void setDoorbell(Integer doorbell);
    
}
