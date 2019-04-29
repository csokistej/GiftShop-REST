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
public interface CustomerDto extends Serializable {
    
    public Integer getId();

    public void setId(Integer id);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);
    
    public String getPhone();

    public void setPhone(String phone);

    public String getEmail();

    public void setEmail(String email);

    public String getCustomerType();

    public void setCustomerType(String customerType);
    
    public AddressDto getAddress();

    public void setAddress(AddressDto address);
    
    public String getAccountNumber();

    public void setAccountNumber(String accountNumber);
    
}
