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
public interface CategoryDto extends Serializable {
    
    public Integer getId();

    public void setId(Integer id);

    public String getName();

    public void setName(String name);
    
    public Double getTaxRate();
    
    public void setTaxRate(Double taxRate);
    
}
