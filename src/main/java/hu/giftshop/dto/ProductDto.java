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
public interface ProductDto extends Serializable {
    
    public Integer getId();

    public void setId(Integer id);
    
    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);

    public Double getGrossPrice();
    
    public void setGrossPrice(Double grossPrice);

    public Double getGrossSalePrice();
    
    public void setGrossSalePrice(Double grossSalePrice);

    public Double getNetPrice();

    public void setNetPrice(Double netPrice);

    public CategoryDto getCategory();
    
    public void setCategory(CategoryDto category);
    
    public Integer getQuantity();

    public void setQuantity(Integer quantity);

    public Integer getStockId();

    public void setStockId(Integer stockId);
    
}
