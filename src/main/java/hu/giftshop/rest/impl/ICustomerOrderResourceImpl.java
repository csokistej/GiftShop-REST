/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.rest.impl;

import hu.giftshop.controller.CustomerOrderController;
import hu.giftshop.dto.CustomerOrderDto;
import hu.giftshop.model.CustomerOrder;
import hu.giftshop.rest.ICustomerOrderResource;
import java.io.StringReader;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author szotyi
 */

@RequestScoped
public class ICustomerOrderResourceImpl implements ICustomerOrderResource {

    @EJB
    private CustomerOrderController customerOrderController;
    
    @Override
    public List<CustomerOrderDto> getAllCustomerOrders() {
        return customerOrderController.getAllCustomerOrders();
    }

    @Override
    public List<CustomerOrderDto> getCustomerOrder(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response createCustomerOrder(String customerOrderDto) {
//        System.out.println(customerOrderDto);
        
//        CustomerOrderDto order = (CustomerOrderDto)jsonObject;
//        System.out.println(jsonObject.get("orderDate").toString());
//        order.setOrderDate();
        customerOrderController.createCustomerOrder(customerOrderDto);

        return Response.ok("{}", MediaType.APPLICATION_JSON).build();
    }
    
    
    
}
