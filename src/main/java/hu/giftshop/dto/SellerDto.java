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
public interface SellerDto extends Serializable {
    
    
    public Integer getId();

    public void setId(Integer id);

    public String getName();

    public void setName(String name);

    public String getPhone();

    public void setPhone(String phone);

    public String getEmail();

    public void setEmail(String email);

    public String getAccountNumber();

    public void setAccountNumber(String accountNumber);

    public AddressDto getAddress();

    public void setAddress(AddressDto address);
    
}
