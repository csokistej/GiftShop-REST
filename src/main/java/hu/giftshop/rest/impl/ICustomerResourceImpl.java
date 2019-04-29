/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.rest.impl;

import hu.giftshop.controller.CustomerController;
import hu.giftshop.dto.CustomerDto;
import hu.giftshop.model.Customer;
import hu.giftshop.rest.ICustomerResource;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author szotyi
 */
@RequestScoped
public class ICustomerResourceImpl implements ICustomerResource {

    @EJB
    private CustomerController customerController;
    
    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerController.getAllCustomers();
    }

    @Override
    public CustomerDto getCustomer(int id) {
        return customerController.getCustomer(id);
    }

    @Override
    public Response createCustomer(CustomerDto customerDto) {
        Customer customer = customerController.createCustomer(customerDto);
        return Response.ok(customer, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateCustomer(CustomerDto customerDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response deleteCustomer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
