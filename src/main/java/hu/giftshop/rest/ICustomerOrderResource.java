/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.rest;

import hu.giftshop.dto.CustomerOrderDto;
import hu.giftshop.dto.impl.CustomerOrderDtoImpl;
import hu.giftshop.model.CustomerOrder;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author szotyi
 */
@Path("orders")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface ICustomerOrderResource {
    
    @GET
    public List<CustomerOrderDto> getAllCustomerOrders();
    
    @GET
    @Path("{id}")
    public List<CustomerOrderDto> getCustomerOrder(@PathParam("id") int id);
 
    @POST
    public Response createCustomerOrder(String customerOrderDto);
    
}
