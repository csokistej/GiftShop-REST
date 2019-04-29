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
public interface OrderProductDto extends Serializable {
    
    public Integer getId();
    
    public void setId(Integer id);

    public CustomerOrderDto getCustomerOrder();

    public void setCustomerOrder(CustomerOrderDto customerOrder);

    public ProductDto getProduct();
    
    public void setProduct(ProductDto product);

    public Integer getQuantity();

    public void setQuantity(Integer quantity);
    
    
}
