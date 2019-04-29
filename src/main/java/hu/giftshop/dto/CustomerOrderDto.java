/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import hu.giftshop.dto.impl.CustomerOrderDtoImpl;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author szotyi
 */
@JsonDeserialize(as = CustomerOrderDtoImpl.class)
public interface CustomerOrderDto extends Serializable {
    
    
    public Integer getId();

    public void setId(Integer id);
    
    public Calendar getOrderDate();

    public void setOrderDate(Calendar orderDate);

    public Calendar getFulfillDate();

    public void setFulfillDate(Calendar fulfillDate);

    public CustomerDto getCustomer();
    
    public void setCustomer(CustomerDto customer);

    public List<OrderProductDto> getOrderProductList();

    public void setOrderProductList(List<OrderProductDto> orderProductList);
    
}
